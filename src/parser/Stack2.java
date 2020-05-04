package parser;

/**
 * implementation using arrays
 */
public class Stack2 implements Stack2_ADT {

    /**
     * maximum length of the array
     */
    public static final int MAX_SIZE = 100;

    /**
     * initialized to -1
     */
    private int indexTop = -1;
    private Object[] arr = new Object[MAX_SIZE];

    /**
     * returns & deletes the top of the stack if not empty
     * 
     * @throws IndexOutOfBoundsException when stack is empty
     * @return top of the stack
     */
    @Override
    public Object pop() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Object tmp = arr[indexTop];
        arr[indexTop--] = null;
        // System.out.println("Currently popping: " + tmp.toString());
        return tmp;
    }

    /**
     * pushes obj x onto stack if not full
     * 
     * @throws IndexOutOfBoundsException if the stack is full
     * @param x the object that will be pushed onto the top of the stack
     */
    @Override
    public void push(Object x) {
        if (indexTop == MAX_SIZE - 1) {
            throw new IndexOutOfBoundsException("The stack is full, indexTop: " + indexTop);
        }
        indexTop++;
        arr[indexTop] = x;

    }

    /**
     * returns true iff the stack is empty
     * 
     * @return true iff the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return indexTop == -1;
    }

    /**
     * return the obj at top of stack w/o deleting it from the stack
     * 
     * @return the obj at top of stack
     */
    @Override
    public Object top() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Object tmp = arr[indexTop];
        return tmp;
    }

    /**
     * returns the number of obj in this stack
     * 
     * @return the size of the stack
     */
    @Override
    public int size() {
        return indexTop + 1;
    }

    /**
     * sends back the stack
     * 
     * @return the array of objects/ stack
     */
    public Object[] getStack() {
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
}