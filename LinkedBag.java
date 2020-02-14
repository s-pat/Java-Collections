/**
 * Linked list class for any objects
 * @author Sohan Patel
 */
public class LinkedBag<E extends Comparable<E>> {
     private Node<E> head;
    private  Node<E> tail;
    private int numElements;

    /**
     * No-arg Constructor
     */
    public LinkedBag() {
        head = null;
        tail = null;
        numElements = 0;
    }

    /**
     * The getSize method returns the linked bag's current size.
     *
     * @return The value in the numElements field.
     */
    public int getSize() {
        return numElements;
    }

    /**
     * The add method adds a String to the linked bag This version just sticks
     * the value at the end of the list
     *
     * @param newElement The String to be added to the linked bag.
     */
    public void add(E newElement) {
        
        
        Node<E> holder = new  Node<E> (newElement, null);

        if (tail == null) // is list empty?
        {
            head = holder;
            tail = head;
        } else {
             Node<E> current = head;
             Node<E> previous = null;

            while (current != null) {
                if (newElement.compareTo(current.getData()) < 0) {
                    break;
                }
                previous = current;
                current = current.getLink();
            }
            //make the new node(holder) point to current node
            holder.setLink(current); 

            //updates head to holder to front of list
            if (current == head) 
            {
                head = holder;
            } else {
                previous.setLink(holder);
            }
            //updates tail to holder to end of list
            if (current == null) 
            {
                tail = holder;
            }
        }
        numElements++;
    }

    /**
     * The exists method looks for a String in the linked bag
     *
     * @param target The String to be found in the linked bag.
     * @return a boolean to indicate if target is found in the linked bag.
     */
    public boolean exists(E target) {
        boolean found = false;
        Node<E> cursor = head;

        while (cursor != null && !found) {
            if (cursor.getData().equals(target)) {
                found = true;
            } else {
                cursor = cursor.getLink();
            }
        }
        return found;
        // although not "efficient", this method could contain just 1 line:
        // return (countOccurences(target) > 0);
    }

    /**
     * The countOccurrences method looks for a String in the linked bag
     *
     * @param target The String to be found in the linked bag.
     * @return an int with the number of times target is found in the linked
     * bag.
     */
    public int countOccurrences(E target) {
        int numOccurrences = 0;
        Node<E> cursor;

        for (cursor = head; cursor != null; cursor = cursor.getLink()) {
            if (cursor.getData().equals(target)) {
                numOccurrences++;
            }
        }

        return numOccurrences;
    }

    /**
     * The remove method looks for a String in the linked bag and removes it
     * this version of remove maintains order
     *
     * @param target The String to be removed from the linked bag.
     * @return a boolean to indicate if the target was removed from the bag.
     */

    public boolean remove(E target) {
        boolean found = false;
        Node<E> cursor = head, previous = null;

        while (cursor != null && !found) {
            if (cursor.getData().equals(target)) {
                found = true;
            } else {
                previous = cursor;
                cursor = cursor.getLink();
            }
        }

        if (found && cursor != null) {
            if (previous == null) {
                head = head.getLink();
            } else {
                previous.setLink(cursor.getLink());
            }

            if (tail == cursor) {
                tail = previous;
            }
            numElements--;
        }
        return found;
    }

    /**
     * the iteratorPrototype method "copies" the linked list and passes the
     * copied linked list to a new ListerPrototype2
     *
     * @return a ListerPrototype2 using a copy of the linked list
     */
    public Lister iterator() {
        // declare variables
        Node<E> headOfListToReturn; // beginning of new "copied" list
        Node<E> cursorOfListToCopy; // active node of list to copy
        Node<E> lastNodeOfListToReturn; // end of new "copied" list

        // establish the copied list
        headOfListToReturn = null;

        if (head != null) {
            // create the head of the new list
            headOfListToReturn = new Node<E>(head.getData(), null);
            // use lastNodeOfListToReturn as a pointer to the last node in the copied list
            lastNodeOfListToReturn = headOfListToReturn;
            /* for debugging:
            if (head == tail) 
                System.out.println("T: "+head.getData());
             */
            // use currentCursor as the pointer to the existing list
            cursorOfListToCopy = head.getLink();
            // if we have a node...
            while (cursorOfListToCopy != null) {
                // create a new node from the end of the new list
                lastNodeOfListToReturn.setLink(new Node<E>(cursorOfListToCopy.getData(), null));
                // move lastNodeOfListToReturn to the new last node
                lastNodeOfListToReturn = lastNodeOfListToReturn.getLink();
                /* for debugging:
                if (cursorOfListToCopy == tail) 
                    System.out.println("T: "+cursorOfListToCopy.getData());
                 */
                // move the cursorOfListToCopy to the next node
                cursorOfListToCopy = cursorOfListToCopy.getLink();
            }
        }
        return new Lister<E>(headOfListToReturn);
    }

}
