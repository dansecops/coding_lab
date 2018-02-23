package stacksandqueue;

class StackMain {

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
        try {

            System.out.println(simpstack.remove()); // Exception
        } catch (Exception e){
            e.printStackTrace();
        }





        //PriorityQueue
        //No iterations over all alements !
//        System.out.println(simpstack.remove()); // C
//        System.out.println(simpstack.remove()); // B
//        System.out.println(simpstack.remove()); // D
//        System.out.println(simpstack.remove()); // A
//        System.out.println(simpstack.remove()); // Exception
    }

}
