package stacksandqueue;

import java.rmi.NoSuchObjectException;

public class Main {

    public static void main(String[] args) throws NoSuchObjectException {
        /**
        SimpleStack simpstack = new SimpleStack();
        simpstack.add("A"); // .add("A", 3)
        simpstack.add("b");// .add("B", 2)
        simpstack.add("C");// .add("C", 1)
        simpstack.add("D");// .add("D", 2)
        System.out.println(simpstack.remove()); //A
        System.out.println(simpstack.remove()); // b
        System.out.println(simpstack.remove()); // c
        System.out.println(simpstack.remove()); // d
        System.out.println(simpstack.remove()); // Exception
         */

        PriorityQueue pq = new PriorityQueue();
        pq.addElement("a", 1);
        pq.addElement("b", 2);
        pq.addElement("c", 3);
        pq.addElement("d", 2);


        //PriorityQueue
  //No iterations over all alements !
        try {
            System.out.println(pq.removeElement()); // C
            System.out.println(pq.removeElement()); // B
            System.out.println(pq.removeElement()); // D
            System.out.println(pq.removeElement()); // A
            System.out.println(pq.removeElement()); // Exception
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    static int counter =0;

    public static void main(String[] args) {
        recursiveFunction(1000500, 100500, 100500);
    }

    private static void recursiveFunction(long a, long b, long c) {
        System.out.println(counter++);
        if(counter < 3000) {
            recursiveFunction(1000500, 100500, 100500);
        }

    }
    */
}
