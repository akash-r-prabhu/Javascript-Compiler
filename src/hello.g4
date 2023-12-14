grammar hello;

@header{
import ast.*;
import java.util.Stack;
import java.util.EmptyStackException;
import java.io.*;
}

@members
{

class Pair<T, U> {
    public T a;
    public U b;
    public int level;

    public Pair(T a, U b, int level) {
        this.a = a;
        this.b = b;
        this.level = level;
    }
}

Stack<Pair<String, String>> stack = new Stack<Pair<String, String>>();
int currentLevel = 0;  // Track the current level offset

// Increment the current level when entering a new scope
public void enterScope() {
    currentLevel++;
}

// Decrement the current level when leaving a scope
public void exitScope() {
    currentLevel--;
}


public void pushToStack(String key, String value, int level) {
    stack.push(new Pair<>(key, value, level));
}

public void popFromStack() {
    try {
        Pair<String, String> pair = stack.pop();
        System.out.println("Popped Key: " + pair.a + ", Value: " + pair.b + ", Level: " + pair.level);
    } catch (EmptyStackException e) {
        System.out.println("Stack is empty.");
    }
}

public void printStack() {
    System.out.println("\nStack:");
    System.out.println("+-----------------+-------+");
    System.out.println("|   Key  |  Value  | Level |");
    System.out.println("+-----------------+-------+");
    for (Pair<String, String> pair : stack) {
        System.out.printf("|%-8s|%-9s|%-6d|%n", pair.a, pair.b, pair.level);
    }
    System.out.println("+------------------+-------+");
}


public void handleIdAssignment(String key, String type) {
    try {
        if (!stack.isEmpty()) {
            Pair<String, String> pair = stack.pop();
            if (!type.equals(pair.b)) {
                pushToStack(key, "Type Mismatch in Assignment", pair.level);
            } else {
                pushToStack(key, type, pair.level);
            }
        } else {
            // If the stack is empty, the level is assumed to be the current level
            pushToStack(key, type, currentLevel);
        }
    } catch (EmptyStackException e) {
        System.out.println("Stack is empty.");
    }
}




}


parse returns [ASTNode node]
    : s=statements
      {
        $node = $s.node;
        $node.print();
        printStack();  // Add this line to print the stack
      };


statements returns [Statement node]
    : st=stm s=statements {$node = new StatementsNode($st.node, $s.node);}
    | SEMICOLON s=statements {$node = new SemicolonStatements();}
    | /*empty*/ {$node = new EmptyStatements();}
    ;


stm returns [Stm2 node]: forin = forinstm {$node = $forin.node;}
	| arrdic = arrayDeclaration {$node = $arrdic.node;}
	| arracc = arrayAccess {$node = $arracc.node;}
	| implib = importlib {$node = $implib.node;}
    | a = assignstm {$node = $a.node;}
    | funcall = functioncall {$node = $funcall.node;}
    | wstm = whilestm {$node = $wstm.node;}
    | delstm = deletestm {$node = $delstm.node;}
    | incstm = incrementstm {$node = $incstm.node;}
    | decstm = decrementstm {$node = $decstm.node;}
    | forloop = forloopstm {$node = $forloop.node;}
    | dwhile = dowhile {$node = $dwhile.node;}
    | fun = function {$node =$fun.node;}
    | rstm = returnstm {$node = $rstm.node;}
    | arg = argument {$node = $arg.node;}
    | mcall = methodcall {$node = $mcall.node;}
    | arrowfunction
    | ifstm = ifStatement {$node = $ifstm.node;}
    //| switchCaseStmt
    //| caseList
    //| caseItem
    //| defaultCase
    | bstm = breakStmt {$node = $bstm.node;}
    | arrmod = arrayModification {$node = $arrmod.node;}
    | classstm
    | constructorstm
    | instancecall
    | selfassign = selfassignstm {$node = $selfassign.node;}
	| functionend
	| connectionstm
	| tryCatchBlock
    | throwStatement
    | exp {$node = $exp.node;}
	| SEMICOLON;

assignstm returns [AssignBase node]
    : LET i=ID EQUAL e=exp
      {
//        enterScope();
        $node = new LetAssignStm($i.text, $e.node);
        if ($e.expType != null) {
          pushToStack($i.text, $e.expType, currentLevel);
        }
      }
    | i2=ID EQUAL e2=assignstm_tail
      {
//        enterScope();
        $node = new IdAssignStm($i2.text, $e2.node);
        handleIdAssignment($i2.text, $e2.type);
      }
    | CONST i3=ID EQUAL e3=exp
      {
//        enterScope();
        $node = new ConstAssignStm($i3.text, $e3.node);
        if ($e3.expType != null) {
          pushToStack($i3.text, $e3.expType, currentLevel);
        }
      }
    | i4=ID o=operators EQUAL s=stm
      {
//        enterScope();
        $node = new OperatorAssignStm($i4.text, $o.text, $s.node);
      }
    | vassign = varassign
      {
//        enterScope();
        $node = new VarAssignStm($vassign.node);
      }
    | mcall = methodcall
      {
   //     enterScope();
        $node = new MethodCallStm($mcall.node);
      }
    | selfassign = selfassignstm
      {
//        enterScope();
        $node = new SelfAssignStm($selfassign.node);
      };


varassign returns [VarAssignBase node]
    : VAR id=ID EQUAL t=assignstm_tail
      {
//        enterScope();
        $node = new VarAssignNode($id.text, $t.node);
        pushToStack($id.text, $t.type, currentLevel);
      }
    | VAR k=keywords EQUAL t=assignstm_tail
      {
//        enterScope();
        $node = new VarAssignTailNode($k.text, $t.node);
      };


assignstm_tail returns [AssignTail node, String type]
    : functioncall {$node = new AssignStmtTailNode1($functioncall.node); $type="function";}
    | exp {$node = new AssignStmtTailNode2($exp.node);
    	$type = $exp.expType;
    }
    | f1=factor {$node = new AssignStmtTailNode3($factor.node); $type = $f1.type; }
    | k1=keywords {$node = new AssignStmtTailNode4($keywords.node); $type = $k1.type;}
    | NEW ID f2=factor {$node = new NewIDFactorNode($ID.text, $factor.node); $type = $f2.type;}
    ;

exp returns [ExpBase node, String expType]
    : f1=factor {$node = new ExpNode1($factor.node); $expType = $f1.type;}
    | f2=comparisonExpression {$node = new ExpNode2($comparisonExpression.node);  $expType = $f2.type;}
    | f3=methodcall {$node = new ExpNode3($methodcall.node); }
    | lexpress = logicalExpression {$node = new ExpNode4($lexpress.node); $expType = $lexpress.type;}
    ;

logicalExpression returns [LogicalExpBase node, String type]
    : l1 = logicalExpression OR c1 = comparisonTerm {$node = new LogicalExpressionNode(LogicalOperator.OR, $l1.node, $c1.node); $type = "BOOLEAN";}
    | l1 = logicalExpression AND c1 = comparisonTerm {$node = new LogicalExpressionNode(LogicalOperator.AND, $l1.node, $c1.node); $type = "BOOLEAN";}
    | NOT comparisonTerm {$node = new LogicalExpressionNode(LogicalOperator.NOT, null, $comparisonTerm.node); $type = "BOOLEAN";}
    | t1=comparisonTerm {$node = new ComparisonExp2($t1.node); $type = "BOOLEAN";}
    ;


comparisonExpression returns [ComparisonExpBase node, String type]
    : left1 = comparisonExpression NEQ right1=comparisonTerm     { $node = new ComparisonExpressionNode(ComparisonOperator.NEQ, $left1.node, $right1.node);
    	if($left1.type!=$right1.type){
    		$type="Mismatch in TYPE in COMPARISON";
    	}
    	else{
    		$type="boolean";
    	} }
    | left2 = comparisonExpression SEQ right2=comparisonTerm     { $node = new ComparisonExpressionNode(ComparisonOperator.SEQ, $left2.node, $right2.node);
    	if($left2.type!=$right2.type){
    		$type="Mismatch in TYPE in COMPARISON";
    	}
    	else{
    		$type="BOOLEAN";
    	}}
    | left3 = comparisonExpression SNEQ right3=comparisonTerm    { $node = new ComparisonExpressionNode(ComparisonOperator.SNEQ, $left3.node, $right3.node);
   	if($left3.type!=$right3.type){
    		$type="Mismatch in TYPE in COMPARISON";
    	}
    	else{
    		$type="BOOLEAN";
    	} }
    | left4 = comparisonExpression LT right4=comparisonTerm      { $node = new ComparisonExpressionNode(ComparisonOperator.LT, $left4.node, $right4.node);
  	if($left4.type!=$right4.type){
    		$type="Mismatch in TYPE in COMPARISON";
    	}
    	else{
    		$type="BOOLEAN";
    	}}
    | left5 = comparisonExpression GT right5=comparisonTerm      { $node = new ComparisonExpressionNode(ComparisonOperator.GT, $left5.node, $right5.node);
    	if($left5.type!=$right5.type){
    		$type="Mismatch in TYPE in COMPARISON";
    	}
    	else{
    		$type="BOOLEAN";
    	}}
    | left6 = comparisonExpression LEQ right6=comparisonTerm     { $node = new ComparisonExpressionNode(ComparisonOperator.LEQ, $left6.node, $right6.node);
    	if($left6.type!=$right6.type){
    		$type="Mismatch in TYPE in COMPARISON";
    	}
    	else{
    		$type="BOOLEAN";
    	}}
    | left7 = comparisonExpression GEQ right7=comparisonTerm     { $node = new ComparisonExpressionNode(ComparisonOperator.GEQ, $left7.node, $right7.node);
    	if($left7.type!=$right7.type){
    		$type="Mismatch in TYPE in COMPARISON";
    	}
    	else{
    		$type="BOOLEAN";
    	}
    }
    | left8 = comparisonExpression EQUALS right8=comparisonTerm  { $node = new ComparisonExpressionNode(ComparisonOperator.EQUALS, $left8.node, $right8.node);
    	if($left8.type!=$right8.type){
    		$type="Mismatch in TYPE in COMPARISON";
    	}
    	else{
    		$type="BOOLEAN";
    	} }
    | t1=comparisonTerm  { $node = new ComparisonExp3($t1.node); $type = "BOOLEAN";}
    ;

comparisonTerm returns [ComparisonBase node, String type] : i=additiveExpression {$node = new ComparisonTermNode($additiveExpression.node); $type = $i.type;};

additiveExpression returns [AdditiveExpBase node, String type]
    : left1=additiveExpression add = ADD right1=term {$node = new AdditiveExpressionNode($left1.node, $add.text, $right1.node);
    		if($left1.type!=$right1.type){
    		$type="Mismatch in TYPE in ADD";
    	}
    	else{
    		$type=$right1.type;
    	}
    }
    | left2=additiveExpression sub = SUB right2=term {$node = new AdditiveExpressionNode($left2.node, $sub.text, $right2.node);
    				if($left2.type!=$right2.type){
    		$type="Mismatch in TYPE in SUB";
    	}
    	else{
    		$type=$right2.type;
    	}
    }
    | term {$node = new TermExp($term.node); $type = $term.type;};

// done removing left common factor for post/pre inc/dec
incrementstm returns [IncrementBase node]
    : incrementType=incrementstmtype SEMICOLON {$node = new IncrementStmNode($incrementType.node);}
    | incrementType=incrementstmtype {$node = new IncrementStmNode($incrementType.node);}
    ;

incrementstmtype returns [IncrementStmTypeBase node]
    : incrementType1=postIncrementstm {$node = new IncrementStmTypeNode1($incrementType1.node);}
    | incrementType2=preIncrementstm {$node = new IncrementStmTypeNode2($incrementType2.node);}
    ;

postIncrementstm returns [PostIncBase node]
    : identifier=ID INC {$node = new PostIncrementStmNode($identifier.text);}
    | THIS DOT identifier=ID INC {$node = new PostIncrementStmNode("THIS." + $identifier.text);}
    | kwords=keywords INC {$node = new PostIncrementStmNode($kwords.text);}
    ;

preIncrementstm returns [PreIncBase node]
    : INC identifier=ID {$node = new PreIncrementStmNode($identifier.text);}
    | INC THIS DOT identifier=ID {$node = new PreIncrementStmNode("THIS." + $identifier.text);}
    | INC kwords=keywords {$node = new PreIncrementStmNode($kwords.text);}
    ;

decrementstm returns [DecStmBase node]
    : decrementType=decrementstmtype SEMICOLON {$node = new DecrementStmNode($decrementType.node);}
    | decrementType=decrementstmtype {$node = new DecrementStmNode($decrementType.node);}
    ;

decrementstmtype returns [DecStmTypeBase node]
    : decrementType1=postDecrementstm {$node = new DecrementStmTypeNode($decrementType1.node);}
    | decrementType2=preDecrementstm {$node = new DecrementStmTypeNode2($decrementType2.node);}
    ;

postDecrementstm returns [PostDecBase node]
    : identifier=ID DEC {$node = new PostDecrementStmNode($identifier.text);}
    | THIS DOT identifier=ID DEC {$node = new PostDecrementStmNode("THIS." + $identifier.text);}
    | kword=keywords DEC {$node = new PostDecrementStmNode($kword.text);}
    ;

preDecrementstm returns [PreDecBase node]
    : DEC identifier=ID {$node = new PreDecrementStmNode($identifier.text);}
    | DEC THIS DOT identifier=ID {$node = new PreDecrementStmNode("THIS." + $identifier.text);}
    | DEC kword=keywords {$node = new PreDecrementStmNode($kword.text);}
    ;


// done removing left common factor for return statement
returnstm returns [ReturnBase node, String type]
    : RETURN expression=stm {$node = new ReturnStmNode($expression.node);}
    | RETURN keyword=keywords {$node = new ReturnStmtTailNode($keyword.text);}
    | RETURN selfassign=selfassignstm {$node = new ReturnStmNode2($selfassign.node);}
    | RETURN NEW expression=stm {$node = new ReturnStmNode($expression.node);}
    ;

// done removing left common factor for delete statement
deletestm returns [DeleteStmBase node]
    : DELETE factor {$node = new DeleteStmNode($factor.node);}
    ;

term returns [TermBase node, String type]
    : left1=term MUL right1=factor {$node = new TermNode($left1.node, "*", $right1.node);
    	if($left1.type!=$right1.type){
    		$type="Mismatch in TYPE in MUL";
    	}
    	else{
    		$type=$right1.type;
    	}
    }
    | left2=term DIV right2=factor {$node = new TermNode($left2.node, "/", $right2.node);
    		if($left2.type!=$right2.type){
    		$type="Mismatch in TYPE in DIV";
    	}
    	else{
    		$type=$right2.type;
    	}

    }
    | factor {$node = new FactorTerm($factor.node); $type=$factor.type;};

factor returns [FactorBase node, String type]: ID {$node = new FactorNode($ID.text);}
    | INT {$node = new FactorNode($INT.text); $type = "INT";}
    | SUB INT {$node = new IntNode(-Integer.parseInt($INT.text)); $type = "INT";}
    | STRING {$node = new StringNode($STRING.text); $type =  "STRING";}
    | LPAREN e1=exp RPAREN {$node = new ExpFactor($exp.node); if($e1.expType != null) $type = $e1.expType;}
    | TRUE {$node = new TrueNode(); $type = "BOOLEAN";}
    | FALSE {$node = new FalseNode(); $type = "BOOLEAN";}
    | LPAREN f1=factor RPAREN {$node = $factor.node; $type = "BOOLEAN";}
    | LPAREN l1=list RPAREN {$node = new ListFactor($list.node); $type = $l1.type;}
    | LPAREN RPAREN {$node = new EmptyParenNode(); $type = "null";}
    | a1=arrayAccess {$node = new ArrayAccessDer($arrayAccess.node); $type = $a1.type;}
    | LBRACKET b1=factor RBRACKET {$node = new BracketFactorNode($factor.node); $type = $b1.type;}
    | LBRACKET c1=exp RBRACKET {$node = new BracketExpNode($exp.node); $type = $c1.expType;}
    | LBRACKET d1=list RBRACKET {$node = new BracketListNode($list.node); $type = $d1.type;}
    | LBRACKET RBRACKET {$node = new EmptyBracketNode(); $type = "null"; }
    | LPAREN h1=list RPAREN {$node = new ParenListStmNode($list.node); $type = $h1.type;}
    | LPAREN h2=list {$node = new ParenListStmNode($list.node); $type = $h2.type;}
    | fun = function {$node = new FunctionFactor($fun.node); $type = "FUNCTION";}
    | selfassign = selfassignstm {$node = new SelfAssignFac($selfassign.node); $type = "null";}
    |  ID DOT LENGTH {$node = new LengthNode($ID.text); $type = "null";}
    | THIS DOT ID {$node = new LengthNode($ID.text); $type = "null";}
    | keywords {$node = new FactorNode($keywords.text); $type = "null";}
    | ID DOT keywords {$node = new IDKeywordsNode($ID.text, $keywords.text); $type = "null";}
    | keywords DOT ID {$node = new KeywordsIDNode($keywords.text, $ID.text); $type = "null";}
    | LBRACES RBRACES {$node = new EmptyBracesNode(); $type = "null";};

list returns [ListBase node, String type]
    : factor1=factor {$node = new ListNode(); $type = $factor1.type;}
    | factor2=factor COMMA l=list {$node = new ListNode(); $type = $factor2.type; }
    | factor3=factor EQUAL l=list {$node = new ListElementNode($factor3.node, $l.node); $type = $factor3.type;}
    | element1=element {$node = new ElementList($element1.node); $type = $element1.type;}
    | element2=element COMMA l=list {$node = new ListNode2(); $type = $element2.type;};

element returns [ElementBase node, String type]
    : ID {$node = new ElementNode($ID.text); $type="IDENTIFIER";}
    | INT {$node = new ElementNode(Integer.parseInt($INT.text)); $type="INT";}
    | STRING {$node = new ElementNode($STRING.text); $type="STRING";}
    | function {$node = new FunctionElement($function.node); $type="FUNCTION";}
    | LPAREN RPAREN {$node = new ElementNode(); $type="null";}
    | LBRACES f=factor COLON e=factor RBRACES {$node = new ElementNode($f.node, $e.node); $type="null";}
    | exp {$node = new ElementNode($exp.node); $type = $exp.expType;}
    ;
/*
parameter returns [ASTNode node]
    : ID {$node = new IDParameterNode($ID.text);}
    | INT {$node = new IntegerParameterNode($INT.text);}
    | STRING {$node = new StringParameterNode($STRING.text);}
    ;

parameterList returns [ASTNode node]
    : parameter {$node = new ParameterListNode(); ((ParameterListNode)$node).addParameter($parameter.node);}
    | parameter COMMA pl=parameterList {$node = new ParameterListNode(); ((ParameterListNode)$node).addParameter($parameter.node); ((ParameterListNode)$node).addParameter($pl.node);}
    ;
*/

operators returns [OperatorBase node]
    : ADD {$node = new OperatorNode("ADD");}
    | SUB {$node = new OperatorNode("SUB");}
    | MUL {$node = new OperatorNode("MUL");}
    | DIV {$node = new OperatorNode("DIV");}
    | MOD {$node = new OperatorNode("MOD");}
    | INC {$node = new OperatorNode("INC");}
    | DEC {$node = new OperatorNode("DEC");}
    | EXP {$node = new OperatorNode("EXP");}
    ;

compoperators returns [CompOperatorBase node]
    : EQUAL  {$node = new CompOperatorNode("EQUAL");}
    | EQUALS {$node = new CompOperatorNode("EQUALS");}
    | NEQ    {$node = new CompOperatorNode("NEQ");}
    | SEQ    {$node = new CompOperatorNode("SEQ");}
    | SNEQ   {$node = new CompOperatorNode("SNEQ");}
    | GT     {$node = new CompOperatorNode("GT");}
    | LT     {$node = new CompOperatorNode("LT");}
    | GEQ    {$node = new CompOperatorNode("GEQ");}
    | LEQ    {$node = new CompOperatorNode("LEQ");}
    | TEN    {$node = new CompOperatorNode("TEN");}
    ;
/*
numericalexpression returns [ASTNode node]
    : leftFactor=factor operator=operators rightFactor=factor compOperator=compoperators comparisonFactor=factor
    {
        $node = new NumericExpressionNode($leftFactor.node, $operator.text, $rightFactor.node, $compOperator.node, $comparisonFactor.node);
    }
    ;*/

// done removing left common factor for if statement
ifStatement returns [IfStmBase node]
    : IF LPAREN exp RPAREN LBRACES stmts=statements RBRACES {$node = new IfStatementNode($exp.node, $stmts.node);}
    | IF LPAREN exp RPAREN LBRACES stmts=statements RBRACES elP=elsePart {$node = new IfElseStatementNode($exp.node, $stmts.node, $elP.node);}
    ;

elsePart returns [ElsePartBase node]
    : ELSE elC=elseContent {$node = new ElsePartNode($elC.node);}
    ;

elseContent returns [elseContentBase node]
    : ifSt=ifStatement
      {$node = new ElseContentNode($ifSt.node, null);}
    | LBRACES stmts=statements RBRACES
      {$node = new ElseContentNode(null, $stmts.node);}
    | LBRACES stmts=statements RBRACES elP=elsePart
      {$node = new ElseContentNode2($stmts.node, $elP.node);}
    ;

// done removing left common factor for switch case

/*switchCaseStmt: SWITCH LPAREN exp RPAREN LBRACES caseList defaultCase RBRACES
              | SWITCH LPAREN exp RPAREN LBRACES caseList RBRACES;

caseList: caseItem caseList | caseItem;

caseItem: CASE exp COLON stm breakStmt;

defaultCase: DEFAULT COLON stm;*/


// done removing left common factor for break statement
breakStmt returns [BreakStmBase node]
	: BREAK SEMICOLON {$node = new BreakStmt();};

forinstm returns [ForInStmBase node]
    : FOR LPAREN f=forinloopexpr RPAREN LBRACES s=stm RBRACES {$node = new ForInstm($f.node, $s.node);}
    ;

forinloopexpr returns [ForInLoopBase node]
    : VAR i1 = ID IN i2 = ID {$node = new ForInLoopExpr("VAR", $i1.text, $i2.text);}
    | CONST i1 = ID IN i2 = ID {$node = new ForInLoopExpr("CONST", $i1.text, $i2.text);}
    ;

whilestm returns [WhileStmBase node]
    : WHILE LPAREN s=stm RPAREN LBRACES ss=statements RBRACES {$node = new WhileStmNode($s.node, $ss.node);}
    ;

forloopstm returns [ForLoopBase node]
    : FOR LPAREN s1=stm s2=stm SEMICOLON s3=stm RPAREN LBRACES ss=statements RBRACES  {$node = new ForLoopStmNode($s1.node, $s2.node, $s3.node, $ss.node);}
    ;

dowhile returns [DoWhileBase node]
    : DO LBRACES statements RBRACES WHILE LPAREN s=stm RPAREN {$node = new DoWhileNode($statements.node, $s.node);}
    ;


arrayDeclaration returns [ArrayDeclBase node]
				: LET ID EQUAL LBRACKET ae = arrayElements RBRACKET {$node = new ArrayDeclarationNode($ID.text,$ae.node);}
				| LET ID EQUAL LBRACKET RBRACKET {$node = new ArrayDeclarationNode($ID.text);};

arrayElements returns [ArrayElementsBase node, String type]
		: exp {$node = new ArrayElements($exp.node); $type=$exp.expType;}
		| exp COMMA ae = arrayElements {$node = new ArrayElements($exp.node,$ae.node); $type="list";};

arrayAccess returns [ArrayAccessBase node, String type]
		: ID LBRACKET e1=exp RBRACKET {$node = new ArrayAccess($ID.text,$exp.node); $type = $e1.expType; };

arrayModification returns [ArrayModifyBase node]: ID LBRACKET e1 = exp RBRACKET EQUAL e2 = exp {$node = new ArrayModification($ID.text,$e1.node,$e2.node);};

importlib returns [ImportBase node] : CONST ID EQUAL REQUIRE LPAREN STRING RPAREN {$node = new ImportLib($ID.text,$REQUIRE.text,$STRING.text);}
				| IMPORT ID FROM STRING {$node = new ImportLib($ID.text,$STRING.text);};

// done removing left common factor for function
function returns [FunctionBase node]
    :{enterScope();} FUNCTION ID LPAREN paramList RPAREN LBRACES statements RBRACES
      {
         // Entering a new scope
        $node = new FunctionStatement($ID.text, $paramList.node, $statements.node);
        pushToStack($ID.text, "Function", currentLevel);
      }
    |{enterScope();} FUNCTION LPAREN paramList RPAREN LBRACES statements RBRACES
      {
        // Entering a new scope
        $node = new FunctionStatement($paramList.node, $statements.node);
        pushToStack("anonymous_function", "ANON1", currentLevel);
      }
    | {enterScope();} FUNCTION LPAREN paramList RPAREN
      {
         // Entering a new scope
        $node = new FunctionStatement($paramList.node);
        pushToStack("anonymous_function2", "ANON2", currentLevel);
      };

paramList returns [ParamListBase node, ArrayList<String> params]: emptyParamList {$node = new FunctionParameters1($emptyParamList.node); $params = new ArrayList<>();}
         | param nonEmptyParamList {$node = new FunctionParameters2($param.node,$nonEmptyParamList.node);};

emptyParamList returns [EmptyParamBase node, ArrayList<String> params]: /* empty */ {$node = new EmptyStatements2(); $params = new ArrayList<>();};

nonEmptyParamList returns [NomEmptyParamBase node, ArrayList<String> params]: COMMA param nonEmptyParamList {$node = new NonEmptyPrameter($param.node,$nonEmptyParamList.node); }
                | /* empty */ {$node = new EmptyStatements4();};

param returns [ParamBase node]: ID commaID {$node = new Parameters($ID.text,$commaID.node);}
		|keywords commaID {$node = new Parameters($keywords.text,$commaID.node);};
commaID returns [CommaIDBase node]: COMMA ID commaID {$node = new CommaParameters($ID.text,$commaID.node);}
       |COMMA keywords commaID {$node = new CommaParameters($keywords.text,$commaID.node);}
       | /* empty */ {$node = new EmptyStatements3();};

functioncall returns [FunctionCallBase node]: ID LPAREN argument RPAREN {$node = new FunctionCall($ID.text,$argument.node);};

argument returns [ArgumentBase node] : ID {$node = new IdArguments($ID.text);}
        | INT {$node = new IntArguments($INT.text);}
        | ID COMMA argument {$node = new IdArguments($ID.text,$argument.node);}
        | INT COMMA argument {$node = new IntArguments($INT.text,$argument.node);};

// done removing left common factor for method call
methodcall returns [MethodCallBase node]
  : ID DOT ID1 = ID t=methodcalltail {$node = new MethodCallNode($ID.text, $ID1.text, $t.node);}
  ;

methodcalltail returns [MethodCallBase node]
  : arguments {$node = new MethodCallArg($arguments.node);}
  | LPAREN optionalArguments LBRACES statements RBRACES RPAREN {$node = new MethodCallTailNode2($optionalArguments.node, $statements.node);}
  | LPAREN innerExpression RPAREN {$node = new MethodCallTailNode($innerExpression.node);}
  ;

argumentList returns [ArgListBase node]
  : e=exp {$node = new ArgumentListNode($e.node);}
  | e=exp COMMA al=argumentList {$node = new ArgumentListNode($e.node, $al.node);}
  ;

arguments returns [ArgsBase node]
    : LPAREN argumentList RPAREN {$node = new ArgumentsNode1($argumentList.node);}
    | factor {$node = new ArgumentsNode2($factor.node);}
    | factor COMMA arguments {$node = new ArgumentsNode3($factor.node, $arguments.node);}
    | /* empty */ {$node = new EmptyNode();} // Assuming you have a class for an empty node
    ;

innerExpression returns [InnerExpBase node]
    : NEW ID LPAREN arguments RPAREN {$node = new InnerExpressionNode($ID.text, $arguments.node);}
    ;

optionalArguments returns [OptArgBase node]
    : exp {$node = new OptionalArgumentsNode1($exp.node);}
    | factor optionalArgumentsTail {$node = new OptionalArgumentsNode2($factor.node, $optionalArgumentsTail.node);}
    ;

optionalArgumentsTail returns [OptArgTailBase node]
    : COMMA exp optionalArgumentsTail {$node = new OptionalArgumentsTailNode($exp.node, $optionalArgumentsTail.node);}
    | /* empty */ {$node = new EmptyNode2();}
    ;


classstm: CLASS ID LBRACES statements RBRACES
		| CLASS ID classExtension LBRACES statements RBRACES;

classExtension: EXTENDS ID;

constructorstm: CONSTRUCTOR factor LBRACES statements RBRACES
              | ID LPAREN RPAREN LBRACES statements RBRACES
              | ID LPAREN factor RPAREN LBRACES statements RBRACES
              | CONSTRUCTOR LPAREN RPAREN LBRACES statements RBRACES
              | CONSTRUCTOR factor LBRACES superCall statements RBRACES ;

superCall: SUPER LPAREN argumentList RPAREN SEMICOLON
		 | SUPER LPAREN RPAREN SEMICOLON;

instancecall: instanceDeclaration;

instanceDeclaration: CONST ID EQUAL NEW ID factor;



selfassignstm returns [SelfAssignBase node] : THIS DOT ID EQUAL factor
			  |THIS DOT keywords EQUAL factor
			  | THIS DOT ID operators
			  | THIS DOT ID
			  | THIS DOT ID factor
			  | THIS DOT ID factor EQUAL factor
			  | ID DOT ID
			  | ID DOT ID EQUAL factor
			  | keywords DOT ID factor
			  | ID DOT ID factor;

functionend: ID DOT ID LPAREN RPAREN
		   | ID DOT CLOSE LPAREN RPAREN;

arrowfunction: CONST ID EQUAL LPAREN ID RPAREN EQUAL GT LBRACES statements RBRACES
			 | CONST ID EQUAL (ID|stm) LPAREN factor EQUAL GT LBRACES statements RBRACES RPAREN
			 | ID LPAREN factor EQUAL GT LBRACES statements RBRACES RPAREN
			 | CONST ID EQUAL ID DOT ID LPAREN LBRACES statements RBRACES RPAREN
			 | ID DOT ID factor EQUAL GT LBRACES statements RBRACES RPAREN
			 | ID DOT ID EQUAL ID factor EQUAL GT LBRACES statements RBRACES;


connectionstm
		:ID COLON factor COMMA
		|ID COLON factor;


tryCatchBlock
		: 'try' block catchBlock;

catchBlock
		: 'catch' '(' exceptionParameter ')' block;

throwStatement
		: 'throw' exp ';';

block returns [String val]

		: '{' statements '}' ;

exceptionParameter
		: ID;


keywords returns [String node, String type] : ABSTRACT| ALERT| ALL| ANCHOR| ANCHORS| AREA| ARRAY| ASSIGN| BLUR| BOOLEAN
| BREAK| BUTTON| BYTE| CASE| CATCH| CHAR| CHECKBOX| CLASS| CLEARINTERVAL| CLEARTIMEOUT| CLIENTINFORMATION
| CLOSE| CLOSED| CONFIRM| CONST| CONSTRUCTOR| CONTINUE| CRYPTO| DATE| DEBUGGER| DECODEURI| DECODEURICOMPONENT| DEFAULT
| DEFAULTSTATUS| DELETE| DO| DOCUMENT| DOUBLE| ELEMENT| ELEMENTS| ELSE| EMBED| EMBEDS| ENCODEURI| ENCODEURICOMPONENT| ENUM
| ESCAPE| EVAL| EVENT| EXPORT| EXTENDS| FALSE| FILEUPLOAD| FINAL| FINALLY| FLOAT| FOCUS| FOR| FORM| FORMS| FRAME| FRAMERATE| FRAMES
| FROM| FUNCTION| GETCLASS| GOTO| HASOWNPROPERTY| HISTORY| IF| IMAGE| IMAGES| IMPORT| IN| INFINITY| INNERHEIGHT| INNERWIDTH| INSTANCEOF
| ISFINITE| ISNAN| ISPROTOTYPEOF| JAVA| JAVAARRAY| JAVACLASS| JAVAOBJECT| JAVAPACKAGE| LAYER| LAYERS| LENGTH| LET| LINK| LOCATION
| LONG| MATH| MIMETYPES| NAN| NATIVE| NAVIGATE| NAVIGATOR| NEW| NULL| NUMBER| OBJECT| OFFSCREENBUFFERING| ONBLUR| ONCLICK| ONERROR
| ONFOCUS| ONKEYDOWN| ONKEYPRESS| ONKEYUP| ONLOAD| ONMOUSEDOWN| ONMOUSEOVER| ONMOUSEUP| ONSUBMIT| OPEN| OPENER| OPTION| OUTERHEIGHT
| OUTERWIDTH| PACKAGES| PAGEXOFFSET| PAGEYOFFSET| PARENT| PARSEFLOAT| PARSEINT| PKCS11| PLUGIN| PROMPT| PROPERTYISENUM
| PROTOTYPE| RADIO| REQUIRE| RESET| RETURN| SCREENX| SCREENY| SCROLL| SECURE| SELECT| SELF| SETINTERVAL| SETTIMEOUT| SHORT| STATUS
| SUBMIT| SUPER| SWITCH| SYNCHRONIZED| TAINT| TEXT| TEXTAREA| THIS| THROW| THROWS| TOP| TOSTRING| TRANSIENT| TRUE
| TRY| TYPEOF| UNDEFINED| UNESCAPE| UNTAINT| VALUEOF| VAR| VOID| VOLATILE| WHILE| WINDOW| WITH| YIELD;



ABSTRACT: 'abstract';
ALERT: 'alert';
ALL: 'all';
ANCHOR: 'anchor';
ANCHORS: 'anchors';
AREA: 'area';
ARRAY: 'Array';
ASSIGN: 'assign';
BLUR: 'blur';
BOOLEAN: 'boolean';
BREAK: 'break';
BUTTON: 'button';
BYTE: 'byte';
CASE: 'case';
CATCH: 'catch';
CHAR: 'char';
CHECKBOX: 'checkbox';
CLASS: 'class';
CLEARINTERVAL: 'clearInterval';
CLEARTIMEOUT: 'clearTimeout';
CLIENTINFORMATION: 'clientInformation';
CLOSE: 'close';
CLOSED: 'closed';
CONFIRM: 'confirm';
CONST: 'const';
CONSTRUCTOR: 'constructor';
CONTINUE: 'continue';
CRYPTO: 'crypto';
DATE: 'Date';
DEBUGGER: 'debugger';
DECODEURI: 'decodeURI';
DECODEURICOMPONENT: 'decodeURIComponent';
DEFAULT: 'default';
DEFAULTSTATUS: 'defaultStatus';
DELETE: 'delete';
DO: 'do';
DOCUMENT: 'document';
DOUBLE: 'double';
ELEMENT: 'element';
ELEMENTS: 'elements';
ELSE: 'else';
EMBED: 'embed';
EMBEDS: 'embeds';
ENCODEURI: 'encodeURI';
ENCODEURICOMPONENT: 'encodeURIComponent';
ENUM: 'enum';
ESCAPE: 'escape';
EVAL: 'eval';
EVENT: 'event';
EXPORT: 'export';
EXTENDS: 'extends';
FALSE: 'false';
FILEUPLOAD: 'fileUpload';
FINAL: 'final';
FINALLY: 'finally';
FLOAT: 'float';
FOCUS: 'focus';
FOR: 'for';
FORM: 'form';
FORMS: 'forms';
FRAME: 'frame';
FRAMERATE: 'frameRate';
FRAMES: 'frames';
FROM: 'from';
FUNCTION: 'function';
GETCLASS: 'getClass';
GOTO: 'goto';
HASOWNPROPERTY: 'hasOwnProperty';
HISTORY: 'history';
IF: 'if';
IMAGE: 'image';
IMAGES: 'images';
IMPORT: 'import';
IN: 'in';
INFINITY: 'Infinity';
INNERHEIGHT: 'innerHeight';
INNERWIDTH: 'innerWidth';
INSTANCEOF: 'instanceof';
ISFINITE: 'isFinite';
ISNAN: 'isNaN';
ISPROTOTYPEOF: 'isPrototypeOf';
JAVA: 'java';
JAVAARRAY: 'JavaArray';
JAVACLASS: 'javaClass';
JAVAOBJECT: 'JavaObject';
JAVAPACKAGE: 'JavaPackage';
LAYER: 'layer';
LAYERS: 'layers';
LENGTH: 'length';
LET:'let';
LINK: 'link';
LOCATION: 'location';
LONG: 'long';
MATH: 'Math';
MIMETYPES: 'mimeTypes';
NAN: 'NaN';
NATIVE: 'native';
NAVIGATE: 'navigate';
NAVIGATOR: 'navigator';
NEW: 'new';
NULL: 'null';
NUMBER: 'Number';
OBJECT: 'Object';
OFFSCREENBUFFERING: 'offscreenBuffering';
ONBLUR: 'onblur';
ONCLICK: 'onclick';
ONERROR: 'onerror';
ONFOCUS: 'onfocus';
ONKEYDOWN: 'onkeydown';
ONKEYPRESS: 'onkeypress';
ONKEYUP: 'onkeyup';
ONLOAD: 'onload';
ONMOUSEDOWN: 'onmousedown';
ONMOUSEOVER: 'onmouseover';
ONMOUSEUP: 'onmouseup';
ONSUBMIT: 'onsubmit';
OPEN: 'open';
OPENER: 'opener';
OPTION: 'option';
OUTERHEIGHT: 'outerHeight';
OUTERWIDTH: 'outerWidth';
PACKAGES: 'packages';
PAGEXOFFSET: 'pageXOffset';
PAGEYOFFSET: 'pageYOffset';
PARENT: 'parent';
PARSEFLOAT: 'parseFloat';
PARSEINT: 'parseInt';
PKCS11: 'pkcs11';
PLUGIN: 'plugin';
PROMPT: 'prompt';
PROPERTYISENUM: 'propertyIsEnum';
PROTOTYPE: 'prototype';
RADIO: 'radio';
REQUIRE: 'require';
RESET: 'reset';
RETURN: 'return';
SCREENX: 'screenX';
SCREENY: 'screenY';
SCROLL: 'scroll';
SECURE: 'secure';
SELECT: 'select';
SELF: 'self';
SETINTERVAL: 'setInterval';
SETTIMEOUT: 'setTimeout';
SHORT: 'short';
STATUS: 'status';
SUBMIT: 'submit';
SUPER: 'super';
SWITCH: 'switch';
SYNCHRONIZED: 'synchronized';
TAINT: 'taint';
TEXT: 'text';
TEXTAREA: 'textarea';
THIS: 'this';
THROW: 'throw';
THROWS: 'throws';
TOP: 'top';
TOSTRING: 'toString';
TRANSIENT: 'transient';
TRUE: 'true';
TRY: 'try';
TYPEOF: 'typeof';
UNDEFINED: 'undefined';
UNESCAPE: 'unescape';
UNTAINT: 'untaint';
VALUEOF: 'valueOf';
VAR: 'var';
VOID: 'void';
VOLATILE: 'volatile';
WHILE: 'while';
WINDOW: 'window';
WITH: 'with';
YIELD: 'yield';

//Delimiters and Punctuation
LPAREN: '(';
RPAREN: ')';
RBRACES: '}';
LBRACES: '{';
SEMICOLON: ';';
COMMA: ',';
LBRACKET: '[';
RBRACKET: ']';
DOT : '.';
COLON : ':';
DOLLAR: '$';

//Relational Operators
EQUAL: '=';
EQUALS: '==';
NEQ: '!=';
SEQ: '===';
SNEQ: '!==';
GT: '>';
LT: '<';
GEQ: '>=';
LEQ: '<=';
TEN: '?';

// Logical Operators
AND: '&&';
OR: '||';
NOT: '!';

// Arithmetic Operators
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
MOD: '%';
INC: '++';
DEC: '--';
EXP: '**';

// Identifiers and Literals
ID: [a-zA-Z_][a-zA-Z0-9_]*;
INT: [0-9]+;
STRING: '"' ~["\r\n]* '"';

// Whitespace and Comments
WS: [ `\t\r\n]+ -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/' .? '*/' -> skip;