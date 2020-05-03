package compiler;

public class Tester {

    public static void main(String args[]) {

        Queue2 myQ = new Queue2();
        System.out.println("--------------------------------------------TESTING THE REVERSER\n");
        System.out.println("Enqueueing E V I L");
        myQ.enqueue("E");
        myQ.enqueue("V");
        myQ.enqueue("I");
        myQ.enqueue("L");
        System.out.print("Here is the array: ");
        printArray(myQ.getQueueString());

        myQ.ReverseQueue();
        System.out.print("Now we reverse the Queue, & print it: ");
        printArray(myQ.getQueueString());

        System.out.println("\n\n--------------------------------------------TESTING THE COMPILER\n");
        CompilerBracket newCompiler1 =  new CompilerBracket("()");
        System.out.println("Just created new compiler to test this string: ()");        System.out.println("This should be accepted. Here is the result of the compiler: " + newCompiler1.compile());
        System.out.println("\n");

        CompilerBracket newCompiler3 =  new CompilerBracket("([]){}");
        System.out.println("Just created new compiler to test this string: ([]){}");
        System.out.println("This should be accepted. Here is the result of the compiler: " + newCompiler1.compile());
        System.out.println("\n");

        CompilerBracket newCompiler4 =  new CompilerBracket("([]){(){[[]]}}");
        System.out.println("Just created new compiler to test this string: ([]){(){[[]]}}");
        System.out.println("This should be accepted. Here is the result of the compiler: " + newCompiler1.compile());
        System.out.println("\n");

        CompilerBracket newCompiler2 =  new CompilerBracket("(}");
        System.out.println("Just created new compiler to test this string: (}");
        System.out.println("This should not be accepted. Here is the result of the compiler: " + newCompiler2.compile());
        System.out.println("\n");

    }

    public static void printArray(String[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "  " );
        }
        System.out.println("");
    }

}
