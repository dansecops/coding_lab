package stacksandqueue;

import java.rmi.NoSuchObjectException;

public class SimpleQueue<O> {


    private Element<O> first;
    private Element<O> last;

    /***
     * add item to the end of the list
     * @param item
     */
    public void addElement(O item) {

        Element<O> tmp = new Element<O>(item);


        if(last != null) {
            last.next = tmp;
        }
        last = tmp;

        if(first == null) {
            first = last;
        }
    }

    /***
     * remove the first item in the list
     * @return
     * @throws NoSuchObjectException
     */
    public O removeElement() throws NoSuchObjectException {
        if(first == null) {
            throw new NoSuchObjectException("There are no elements in the queue!");
        }
        O data = first.data;
        first = first.next;
        if(first == null) {
            last = null;
        }
        return data;
    }

    /***
     * Returns first element of the queue
     * @return <O>
     */
    public O getQueueTop() throws NoSuchObjectException {
        if (first == null) throw new NoSuchObjectException("There are no elements in the queue!");
        return first.data;
    }


    public boolean isEmpty() {
        return first == null;
    }


    private static class Element<O>{
        private O data;
        private Element<O> next;

        public Element(O data) {
            this.data = data;
        }

    }

}
