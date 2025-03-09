import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class ParenSymmetry {

    public static Boolean isBalanced(String s) {
        /*The thought process is to take the test string, split it and isolate it to store and count
        each side of '(' and ')'. Then I would match up the lengths of the arrays - 1. The return the comparison
        to see if left == right.*/

        /*Even better: What I'm looking for is ( and ) being even. So, using charAt will help me isolate the characters
        in the string. No need to make an array.*/

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c =='(') {
                count++;
            } else if (c ==')') {
                count--;
            }
        }
        return (count == 0);
    }



    private static void checkFile(String filename) {
        // open file named filename

        try{
            File theFile = new File(filename);
            Scanner scanner = new Scanner(theFile);
            while (scanner.hasNextLine()) {
                String testStr = scanner.nextLine();
                System.out.println(isBalanced(testStr));
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
        }
        // for each line in the file
        // read the line
        // print whether or not the line's parenthesis are balanced
        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry(); //'ps' object of ParenSymmetry class created
        ps.checkFile("TestStrings0.txt");
        ps.checkFile("TestStrings1.txt");
        Boolean b0 = ps.isBalanced("()"); //Object ps ran from method 'isBalanced' (line 6).
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);
//        File strings0 = new File("TestStrings0.txt");
//        File strings1 = new File("TestStrings1.txt");
//        checkFile(String.valueOf(strings0));
//        checkFile(String.valueOf(strings1));


    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
