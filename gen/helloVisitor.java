// Generated from /Users/macbook/Downloads/jscompilerfinal1/src/hello.g4 by ANTLR 4.13.1

import ast.*;
import java.util.Stack;
import java.util.EmptyStackException;
import java.io.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link helloParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface helloVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link helloParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(helloParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(helloParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStm(helloParser.StmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#assignstm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignstm(helloParser.AssignstmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#varassign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarassign(helloParser.VarassignContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#assignstm_tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignstm_tail(helloParser.Assignstm_tailContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(helloParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpression(helloParser.LogicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#comparisonExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(helloParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#comparisonTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonTerm(helloParser.ComparisonTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(helloParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#incrementstm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementstm(helloParser.IncrementstmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#incrementstmtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementstmtype(helloParser.IncrementstmtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#postIncrementstm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementstm(helloParser.PostIncrementstmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#preIncrementstm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementstm(helloParser.PreIncrementstmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#decrementstm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecrementstm(helloParser.DecrementstmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#decrementstmtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecrementstmtype(helloParser.DecrementstmtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#postDecrementstm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementstm(helloParser.PostDecrementstmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#preDecrementstm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecrementstm(helloParser.PreDecrementstmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#returnstm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnstm(helloParser.ReturnstmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#deletestm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeletestm(helloParser.DeletestmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(helloParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(helloParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(helloParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(helloParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperators(helloParser.OperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#compoperators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoperators(helloParser.CompoperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(helloParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#elsePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsePart(helloParser.ElsePartContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#elseContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseContent(helloParser.ElseContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#breakStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(helloParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#forinstm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForinstm(helloParser.ForinstmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#forinloopexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForinloopexpr(helloParser.ForinloopexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#whilestm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestm(helloParser.WhilestmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#forloopstm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForloopstm(helloParser.ForloopstmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#dowhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDowhile(helloParser.DowhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclaration(helloParser.ArrayDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#arrayElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElements(helloParser.ArrayElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(helloParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#arrayModification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayModification(helloParser.ArrayModificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#importlib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportlib(helloParser.ImportlibContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(helloParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(helloParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#emptyParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyParamList(helloParser.EmptyParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#nonEmptyParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonEmptyParamList(helloParser.NonEmptyParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(helloParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#commaID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaID(helloParser.CommaIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#functioncall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncall(helloParser.FunctioncallContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(helloParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#methodcall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodcall(helloParser.MethodcallContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#methodcalltail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodcalltail(helloParser.MethodcalltailContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(helloParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(helloParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#innerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerExpression(helloParser.InnerExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#optionalArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalArguments(helloParser.OptionalArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#optionalArgumentsTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalArgumentsTail(helloParser.OptionalArgumentsTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#classstm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassstm(helloParser.ClassstmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#classExtension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassExtension(helloParser.ClassExtensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#constructorstm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorstm(helloParser.ConstructorstmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#superCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperCall(helloParser.SuperCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#instancecall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstancecall(helloParser.InstancecallContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#instanceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceDeclaration(helloParser.InstanceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#selfassignstm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfassignstm(helloParser.SelfassignstmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#functionend}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionend(helloParser.FunctionendContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#arrowfunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowfunction(helloParser.ArrowfunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#connectionstm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectionstm(helloParser.ConnectionstmContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#tryCatchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryCatchBlock(helloParser.TryCatchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#catchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchBlock(helloParser.CatchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(helloParser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(helloParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#exceptionParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionParameter(helloParser.ExceptionParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link helloParser#keywords}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywords(helloParser.KeywordsContext ctx);
}