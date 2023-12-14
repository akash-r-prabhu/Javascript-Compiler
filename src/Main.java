//import java.io.IOException;
//
//import org.antlr.v4.runtime.ANTLRFileStream;
//import org.antlr.v4.runtime.ANTLRInputStream;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.Token;
//import org.antlr.v4.runtime.tree.ParseTree;
//import org.antlr.v4.runtime.tree.ParseTreeWalker;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//        String path="/Users/macbook/Downloads/jscompilerfinal1/src/input";
//		ANTLRFileStream input = new ANTLRFileStream(path);
//        ANTLRInputStream ip = new ANTLRInputStream(input.toString());
//        helloLexer lex = new helloLexer(ip);
//        //Token token;
//        CommonTokenStream tokStream = new CommonTokenStream(lex);
//        helloParser parser = new helloParser(tokStream);
//        parser.parse();
//        ParseTree tree = parser.parse();
//	}
//}


import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.Arrays;

import javax.swing.*;
import java.io.IOException;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;


public class Main {

    public static void main(String[] args) throws IOException {
        String path = "/Users/macbook/Downloads/jscompilerfinal1/src/input";
        ANTLRFileStream input = new ANTLRFileStream(path);
        ANTLRInputStream ip = new ANTLRInputStream(input.toString());
        helloLexer lex = new helloLexer(ip);
        CommonTokenStream tokStream = new CommonTokenStream(lex);
        helloParser parser = new helloParser(tokStream);

        ParseTree tree = parser.parse();

//        showParseTree(tree, parser);
    }

    private static void showParseTree(ParseTree tree, helloParser parser) {
        JFrame frame = new JFrame("Parse Tree");

        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
        frame.getContentPane().add(viewer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 400);

        frame.setVisible(true);
    }

}

