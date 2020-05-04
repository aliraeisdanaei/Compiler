package parser;

/**
 * the implementation of Queue2 is w/ arrays
 */
public class Queue2 implements Queue2_ADT {

    /**
     * maximum length of the array
     */
    public static final int MAX_SIZE = 100;

    /**
     * initialized to -1
     */
    private int indexEnd = -1;
    private Object[] arr = new Object[MAX_SIZE];

    /**
     * sends back the peak of the queue also pushes all the other elements back one
     * element
     * 
     * @return
     */
    @Override
    public Object dequeue() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("The queues empty");
        }
        Object tmp = arr[0];

        for (int i = 0; i < indexEnd; i++) {
            arr[i] = arr[i + 1];
        }
        indexEnd--;
        return tmp;
    }

    /**
     * puts obj x at the end of the queue
     * 
     * @throws ArrayIndexOutOfBoundsException if the stack is full
     * @param x is the obj in reference to be put at the back of the queue
     */
    @Override
    public void enqueue(Object x) {
        if (this.indexEnd == MAX_SIZE - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        arr[++indexEnd] = x;
    }

    /**
     * determines if the stack is empty
     * 
     * @return true iff the stack is Empty
     */
    @Override
    public boolean isEmpty() {
        return indexEnd == -1;
    }

    /**
     * determines size of the stack
     * 
     * @return the number of elements in the stack
     */
    @Override
    public int size() {
        return indexEnd + 1;
    }

    /**
     * sends back the Queue
     * 
     * @return the array of objects/ Queue
     */
    public Object[] getQueue() {
        return this.arr;
    }

    /**
     * assuming the queue is all strings will return an array of size of the current
     * queue of all strings inside it
     * 
     * @return an array of size {@code .size()} of all strings
     */
    public String[] getQueueString() {
        String[] arrString = new String[this.size()];
        for (int i = 0; i < this.size(); i++) {
            arrString[i] = (String) this.arr[i];
            // System.out.print(arrString[i]);
        }
        return arrString;
    }

    /**
     * reverses a Q w/ using only a stack & a Q
     * 
     * @return the reversed Queue of myQ
     */
    public Queue2 ReverseQueue() {
        Stack2 myStackRev = new Stack2();
        // System.out.println(" INITIALLY -----the q is: ");
        // Tester.printArray(this.getQueueString());
        while (!this.isEmpty()) {
            Object mine = this.dequeue();
            myStackRev.push(mine);
            // System.out.println("we are pushing: " + mine + " -----the q is: ");
            // Tester.printArray(this.getQueueString());
        }
        // System.out.println("strings now on stack: " );
        // Tester.printArray(myStackRev.getQueueString());
        while (!myStackRev.isEmpty()) {
            this.enqueue(myStackRev.pop());
        }
        return this;
    }

}
