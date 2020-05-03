package compiler;
/**
 * the ADT of queue
 * the queue is a list of object which arranges its elements based on first in first out principle.
 * elements can be enqueue() & dequeue()
 *
 */
public interface Queue2_ADT {

    /**
     * sends the element in front of the queue
     * @return the object in front of the queue
     */
    public Object dequeue();

    /**
     * obj x is put onto the end of the queue
     * @param x is the obj in reference to be put at the back of the queue
     */
    public void enqueue(Object x);

    /**
     * returns true iff if there are no elements in the queue
     * @return true iff queue is empty
     */
    public boolean isEmpty();

    /**
     * returns the number of elements of the queue
     * @return the number of the elements
     */
    public int size();
}
