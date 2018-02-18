package stacksandqueue;

public class Main {

    public static void main(String[] args) {
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


        //PriorityQueue
  //No iterations over all alements !
//        System.out.println(simpstack.remove()); // C
//        System.out.println(simpstack.remove()); // B
//        System.out.println(simpstack.remove()); // D
//        System.out.println(simpstack.remove()); // A
//        System.out.println(simpstack.remove()); // Exception
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
