package at.femaletrack.linkedlist;

import at.femaletrack.linkedlist.StringElement;

public class LinkedList {

    private StringElement head; // head of list

    public LinkedList() {
        this.head = null;
    }


    /**
     * Inserts a node at a given position
     *
     * @param index
     */
    public void add(int index, String val) {
        if (index == 0) {
            StringElement temp = head;
            this.head = new StringElement(val);
            head.next = temp;
        }
        //zuerst kontrollieren, ob der Index kleiner gleich der Liste ist
        if (head != null && index < size() && index != 0) {//index kleiner size, bei = muss man die Funktion append verwenden
            StringElement current = head;
            int count = 1;
            while (count < index) {
                current = current.next;
                count++;
            } //der Zeiger von dem Element vor dem neuen Element soll nun auf unser neues Element zeigen
            //das neue Element soll eingefügt werden und den Zeiger von StringElement davor bekommen.
            StringElement newElement = new StringElement(val);
            newElement.next = current.next; //zeigt auf das StringElement nach dem neuen Element
            current.next = newElement;
        }
    }

    /**
     * Inserts a node at the end of the list
     *
     * @param val
     */
    public void append(String val) {
        if (head == null) {
            this.head = new StringElement(val);
        } else {
            StringElement current = head;
            while (current.next != null) {
                current = current.next;
            }
            StringElement newElem = new StringElement(val);
            current.next = newElem;
        }

    }

    /**
     * Removes all nodes from the list with given String val
     *
     * @param val
     * @return Returns true (at least one node deleted) or false (no node deleted).
     */
    public boolean remove(String val) {
        if (head != null) {
            StringElement current = head;
            int count = 1;
            if (val.equals(head)){
                remove(0);
                current = current.next;
                return true;}
            while (count < size()) {
                if (val.equals(current.next.getValue())) {
                   current.next = current.next.next;
                    if(count <= size()-1 && val.equals(current.next.getValue())){
                        current.next = current.next.next;
                        count++;
                    }
                }
                current = current.next;
                count++;
            }
            return true;
        }
        return false;
    }

    /**
     * Removes a node at position index from the list
     *
     * @param index
     * @return Returns true (at least one node deleted) or false (no node deleted).
     */
    public boolean remove(int index) {
        if (index == 0){
            head = head.next;
            return true;
        }

        if (head != null && index < size() && index >= 1) {
            StringElement current = head;
            int count = 1;
            while (count < index) { //was ist, wenn Index eins mitgegben wird??
                current = current.next;
                count++;
            }
            //jetzt muss der Zeiger eins weiter gestellt werden
            current.next = current.next.next;
            //wie kann ich jetzt das StringElement dazwischen entfernen?

            return true;
        }
        return false;
    }

    /**
     * @return The size of the list
     */
    public int size() {
        if (head != null) {
            int counter = 1;
            //wir suchen eine Zeiger blabla.next, der auf null zeigt
            StringElement current = head;
            while (current.next != null) {
                current = current.next;
                counter++;
            }
            return counter;
        } else {
            return 0;
        }
    }

    /**
     * Returns the String at position index
     *
     * @param index
     * @return The String or null if out of bounds
     */
    public String get(int index) {

        if (head != null && index < size()){
            StringElement current = head;
            int count = 1;
            while (count <= index){
                current = current.next;
                count++;
            }

            String found = current.getValue();
            return found;

        }

        return null; //gibt den .value zurück an der index position
    }

    /**
     * Returns the first occurence of val in the list
     *
     * @param val
     * @return The index or -1 if string cannot be found
     */
    public int indexOf(String val) {
        if (head != null) {
            //Liste durchlaufen, bis der String gefunden wird.
            StringElement current = head;
            int count = 0;

            while ( (count < size()) && !val.equals(current.getValue())) {
                current = current.next;
                count++;
            }
            if(current == null){
                return -1;
            }
            if (val.equals(current.getValue())) {
                return count;
            }

            return -1;
        }

        return -1;
    }
}
