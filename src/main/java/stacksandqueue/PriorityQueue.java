package stacksandqueue;

import java.rmi.NoSuchObjectException;

public class PriorityQueue<O> {


    private Element<O> first;
    private Element<O> last;

    /***
     * add item to the end of the list
     * @param item
     */
    public void addElement(O item, int priority) {

        Element<O> tmp = new Element<O>(item, priority);

        if(last != null) {
            last.next = tmp;
            tmp.previous = last;
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

        Element<O> topPriority = first;
        Element<O> currentElement = first;
        while (currentElement.next != null) {
            if(currentElement.priority > topPriority.priority ) {
                    topPriority = currentElement;

            }
            currentElement = currentElement.next;
        }
        if(currentElement.priority > topPriority.priority ) {
            topPriority = currentElement;

        }

        if(topPriority.previous != null) {
            topPriority.previous.next = topPriority.next;
        } else {
            first = topPriority.next;
        }
        if(topPriority.next !=null) {
            topPriority.next.previous = topPriority.previous;
        } else {
            last = topPriority.previous;
        }
        return topPriority.data;
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
        private int priority;
        private O data;
        private Element<O> next;
        private Element<O> previous;

        public Element(O data, int priority) {
            this.data = data;
            this.priority = priority;
        }

    }

}
