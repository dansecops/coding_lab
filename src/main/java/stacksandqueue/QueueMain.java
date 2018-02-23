package stacksandqueue;

import java.rmi.NoSuchObjectException;

public class QueueMain {
    public static void main(String[] args) throws NoSuchObjectException {

        SimpleQueue<Integer> q1= new SimpleQueue<Integer>();
        SimpleQueue q = new SimpleQueue();
        String result;


        q.addElement("A");
        q.addElement("B");
        q.addElement("C");

        //get first element of the queue
        result = q.getQueueTop().toString();

        //print out result
        System.out.println(result);

        //remove top element of the queue
        Object removedElement = q.removeElement();
        System.out.println(removedElement);
        q.removeElement();


        //print out result
        result = q.getQueueTop().toString();

        System.out.println(result);


    }
}
