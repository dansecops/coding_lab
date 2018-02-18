package stacksandqueue;

public class SimpleStack {

    LinkedListElement root;

    public void add(Object o) {
        if(root == null) {
            root = new LinkedListElement(o);
        }
        else {
            LinkedListElement lleNew = new LinkedListElement(o);
            lleNew.childElement = root;
            root = lleNew;
        }
    }

    public Object remove() {
        //root = null
        if(root != null) {
            Object payload = root.payload;
            root = root.childElement;
            return payload;
        }
        else {
            throw new IllegalArgumentException();
        }

    }

}
