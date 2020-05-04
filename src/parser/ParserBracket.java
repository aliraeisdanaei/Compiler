package parser;

import java.util.ArrayList;

/**
 * This class parses the following grammar:
 * <p>
 * S → [S] | {S} | (S) | SS | e e as in the empty string
 * </p>
 * <p>
 * to simplify the compilation the grammar has been converted to chomsky's
 * normal form as below: The empty string production has also been replaced by
 * 14) - 16) for simplification 0)S → S S 1)B10 → ( 2)B11 → ) 3)B20 → { 4)B21 →
 * } 5)B30 → [ 6)B31 → ] 7)S → B10 A1 8)A1 → S B11 9)S → B20 A2 10)A2 → S B21
 * 11)S → B30 A3 12)A3 → S B31 13)S → B10 B11 14)S → B20 B21 15)S → B30 B31
 *
 * </p>
 */
public class ParserBracket {

    /**
     * stack where tokens will be pushed on
     */
    private Stack2 tokenStack;

    /**
     * this assumes that the input has gone through a lexical analyzer & each char
     * in the string is a token
     */
    private String tokens;

    /**
     * the arraylist that holds each production, each production is an array of
     * Strings the first element of each array is always the left hand side & the
     * other two elements are the right hand side, will have 2 or 3 elements
     * depending on the production
     */
    private ArrayList<String[]> grammarProductions = new ArrayList<>();

    /**
     * will create a parser with the input of token strings provided. & instantiates
     * the grammar
     * 
     * @param tokens is the input of string the grammar needs to be checked on
     */
    public ParserBracket(String tokens) {
        this.tokens = tokens;
        this.tokenStack = new Stack2();
        this.uploadGrammar();
    }

    /**
     * runs the parser on the input tokens works by running 5 operations of accept,
     * reduce, shift, backtrack (omitted for this grammar), & reject in order of
     * successive fails
     * 
     * @return true iff the input can be derived with the grammar defined in the
     *         documentation of this class
     */
    public boolean parse() {
        // int i = this.tokens.length() - 1;
        // //for(int i = this.tokens.length() - 1; i >= 0; i--)
        // while(!this.tokens.isEmpty() /*||this.tokenStack.size() != 1*/)
        // {
        // if(! this.tokenStack.isEmpty()){
        // if(reduce() != -1){
        // shift();
        // }
        // }else{
        // shift();
        // }
        // i--;
        // }
        //
        // if(this.accept()) {
        // return true;
        // }else{
        //// while(this.tokenStack.size() != 1){
        //// if(reduce() != -1){
        //// return false;
        //// }
        //// }
        // return false; //rejection
        // }
        // while( (! this.tokens.isEmpty()) && this.tokenStack.size() != 1){
        // System.out.println("The LOOOP
        // Iteration-------------------------------------");
        if (accept()) {
            // System.out.println("accepting");
            return true;
        }
        if (reduce() == -1) {
            // we could not reduce the top of the stack so we must shift

            // System.out.print("reduce not possible, but here is the stack anyways: " );
            // Tester.printArray(this.tokenStack.getQueueString());
            if (!shift()) {
                // when shift is not possible that means the tokens was empty
                // System.out.println("Shift not possible anymore, the string was not in
                // grammar");
                System.out.print("rejection, but here is the stack anyways: ");
                Tester.printArray(this.tokenStack.getQueueString());
                return false; // rejection
            }
        }

        return this.parse();
    }

    private boolean accept() {
        return this.tokenStack.size() == 1 && ((String) this.tokenStack.top()).equals("S") && this.tokens.isEmpty();
    }

    /**
     * tries to reduce the stack with the productions
     * 
     * @return the index of the production reduction has been applied & -1 when
     *         reduction was not possible
     */
    private int reduce() {
        // Tester.printArray(this.tokenStack.getQueueString());
        // System.out.print("checked productions: ");

        for (int i = 0; i < this.grammarProductions.size(); i++) {
            // System.out.print(i + " ");
            String[] thisProduction = this.grammarProductions.get(i);
            if (thisProduction.length == 2 && this.tokenStack.size() >= 1) {
                // System.out.println("checking a terminal production");
                // thisProduction is a terminal production
                // System.out.println(" top: " + (String) this.tokenStack.top());
                // System.out.print("the stack: ");
                // Tester.printArray(this.tokenStack.getQueueString());

                if (((String) this.tokenStack.top()).equals(thisProduction[1])) {
                    String tmp = (String) this.tokenStack.pop();
                    // System.out.println("string: " + tmp);
                    this.tokenStack.push(thisProduction[0]);
                    // System.out.println("used this production: " + i);
                    return i;
                }
            } else if (this.tokenStack.size() >= 2) {
                String tmp1 = (String) this.tokenStack.pop();
                String tmp2 = (String) this.tokenStack.pop();
                if (tmp1.equals(thisProduction[1]) && tmp2.equals(thisProduction[2])) {
                    this.tokenStack.push(thisProduction[0]);
                    // System.out.println("used this production: " + i);
                    return i;
                } else {
                    this.tokenStack.push(tmp2);
                    this.tokenStack.push(tmp1);
                }

            }

        }

        return -1;
    }

    /**
     * puts the last character of the {@code tokens} onto the stack as a String
     * removes the last element from tokens
     * 
     * @return true iff shift was completed returns false when the {@code tokens}
     *         was empty & shift was not possible
     */
    private boolean shift() {
        if (this.tokens.isEmpty()) {
            return false;
        }
        String str = this.tokens;
        String endToken = str.substring(str.length() - 1, str.length());
        this.tokenStack.push(endToken);
        // System.out.print("this was shifted: " + endToken);
        this.tokens = str.substring(0, str.length() - 1);
        // System.out.println(" This is now the string: " + this.tokens);
        // System.out.print("& here is the stack: " );
        // Tester.printArray(this.tokenStack.getQueueString());
        // System.out.println("here is the top: " + this.tokenStack.top());
        return true;
    }

    /**
     * this grammar does not require any backtracking so that has been omitted.
     */
    private void backtrack() {

    }

    private void uploadGrammar() {
        // hard codes all the productions
        String[] p0 = { "S", "S", "S" };
        this.grammarProductions.add(p0);
        String[] p1 = { "B10", "(" };
        this.grammarProductions.add(p1);
        String[] p2 = { "B11", ")" };
        this.grammarProductions.add(p2);
        String[] p3 = { "B20", "{" };
        this.grammarProductions.add(p3);
        String[] p4 = { "B21", "}" };
        this.grammarProductions.add(p4);
        String[] p5 = { "B30", "[" };
        this.grammarProductions.add(p5);
        String[] p6 = { "B31", "]" };
        this.grammarProductions.add(p6);
        String[] p7 = { "S", "B10", "A1" };
        this.grammarProductions.add(p7);
        String[] p8 = { "A1", "S", "B11" };
        this.grammarProductions.add(p8);
        String[] p9 = { "S", "B20", "A2" };
        this.grammarProductions.add(p9);
        String[] p10 = { "A2", "S", "B21" };
        this.grammarProductions.add(p10);
        String[] p11 = { "S", "B30", "A3" };
        this.grammarProductions.add(p11);
        String[] p12 = { "A3", "S", "B31" };
        this.grammarProductions.add(p12);
        String[] p13 = { "S", "B10", "B11" };
        this.grammarProductions.add(p13);
        String[] p14 = { "S", "B20", "B21" };
        this.grammarProductions.add(p14);
        String[] p15 = { "S", "B30", "B31" };
        this.grammarProductions.add(p15);
    }

}
