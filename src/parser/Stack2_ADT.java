package parser;

/**
 * This is the ADT for stack2 The stack arranges its element in accordance to
 * the first in last out rule
 */
public interface Stack2_ADT {
    /**
     * returns & deletes the object at the top of the stack
     * 
     * @return the object at the top of the stack
     */
    public Object pop();

    /**
     * pushes the object to the top of the stack
     * 
     * @param x the object that will be pushed onto the top of the stack
     */
    public void push(Object x);

    /**
     *
     * @return trues iff if there are no elements in the stack
     */
    public boolean isEmpty();

    /**
     *
     * @return but not deletes the element on the top of the stack
     */
    public Object top();

    /**
     *
     * @return the number of elements on the stack
     */
    public int size();
}
