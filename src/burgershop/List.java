
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burgershop;

class List {

    private Burger[] burgerArray;
    private Node first;

    public boolean add(Burger burger) {
        return add(size(), burger);
    }

    public boolean addFirst(Burger burger) {
        return add(0, burger);
    }

    public boolean addLast(Burger burger) {
        return add(burger);
    }

    public boolean add(int index, Burger burger) {
        if (index >= 0 && index <= size()) {
            Node n1 = new Node(burger);
            if (index == 0) {
                n1.next = first;
                first = n1;
            } else {
                int count = 0;
                Node temp = first;
                while (count < index - 1) {
                    count++;
                    temp = temp.next;
                }
                n1.next = temp.next;
                temp.next = n1;
            }
            return true;
        }
        return false;
    }

    public boolean addNewBurger(Burger burger) {
        return add(burger);
    }

    public void printList() {
        System.out.print("[");
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.burger.toString() + ", ");
            temp = temp.next;
        }
        System.out.println(isEmpty() ? "empty]" : "\b\b]");
    }

    public boolean remove(int index) {
        if (index >= 0 && index < size()) {
            if (index == 0) {
                first = first.next;
            } else {
                int count = 0;
                Node temp = first;
                while (count < index - 1) {
                    count++;
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
            return true;
        }
        return false;
    }

    public boolean removeFirst() {
        return remove(0);
    }

    public boolean removeLast() {
        return remove(size() - 1);
    }

    public int size() {
        int count = 0;
        Node temp = first;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int indexOf(Burger burger) {
        int index = 0;
        Node temp = first;
        while (temp != null) {
            if (temp.burger.equals(burger)) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public boolean set(Burger burger) {
        int index = indexOf(burger);
        System.out.println(index);
        if (index >= 0 && index < size()) {
            int count = 0;
            Node temp = first;
            while (count < index) {
                count++;
                temp = temp.next;
            }
            temp.burger = burger;
            return true;
        }
        return false;
    }

    public Burger get(int index) {
        if (index >= 0 && index < size()) {
            int count = 0;
            Node temp = first;
            while (count < index) {
                count++;
                temp = temp.next;
            }
            return temp.burger;
        }
        return null;
    }

    public boolean contains(Burger burger) {
        return indexOf(burger) != -1;
    }

    public boolean remove(Burger burger) {
        int index = indexOf(burger);
        return remove(index);
    }

    public Burger[] toArray() {
        Burger[] burgerArray = new Burger[size()];
        Node temp = first;
        for (int i = 0; i < burgerArray.length; i++) {
            burgerArray[i] = temp.burger;
            temp = temp.next;
        }
        return burgerArray;
    }

    public void clear() {
        first = null;
    }

    class Node {

        Burger burger;
        Node next;

        public Node(Burger burger) {
            this.burger = burger;
        }
    }
}
