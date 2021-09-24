package test1;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

class linkedList<T> {
    private Throwable IndexOutOfBoundsException;
    private Throwable NullPointerException;

    private static final long serialVersionUID = 876323262645176444L;

    class Entry<T> {
        T data;
        Entry next = null;

        Entry(T data) {
            this.data = data;
        }
    }

    private Entry head;
    private int size = 0;

    public Entry getHead() {
        return this.head;
    }

    public int size() {
        return this.size;
    }

    linkedList() {
        this.head = null;
    }

    linkedList(linkedList c) {
        this.head = c.getHead();
    }

    public boolean add(T c) {
        boolean isNotDuplicate = true;
        if (this.head == null) {
            this.head = new Entry(c);
        } else {
            Entry tmp = this.head;
            for (; tmp.next != null; tmp = tmp.next)
                if (tmp.data == c)
                    isNotDuplicate = false;
            tmp.next = new Entry(c);
        }
        this.size++;
        return isNotDuplicate;
    }

    public void add(int index, T element) throws Throwable {
        if (this.head == null) {
            this.head = new Entry(element);
        } else {
            if (index < 0 || index > size()) {
                throw IndexOutOfBoundsException;
            }
            Entry current = this.head;
            Entry beforeCurrent = this.head;
            for (int i = 0; i < index; beforeCurrent = current ,current = current.next, ++i);
            beforeCurrent.next = new Entry(element);
            beforeCurrent.next.next = current;
        }
        this.size++;
    }

    public T get(int index) throws Throwable {
        if (index < 0 || index > size())
            throw IndexOutOfBoundsException;
        Entry<T> tmp = this.head;
        for (int i = 0; i < index; tmp = tmp.next, ++i);
        return tmp.data;
    }

//    public boolean addAll(Collection<? extends T> c) throws Throwable {
//        if (c == null)
//            throw NullPointerException;
//        for (int i = 0; i < c.size(); ++i)
//            add();
//    }


    @Override
    public String toString() {
        return "linkedList{" +
                "IndexOutOfBoundsException=" + IndexOutOfBoundsException +
                ", NullPointerException=" + NullPointerException +
                ", head=" + head +
                ", size=" + size +
                '}';
    }
}

public class Main {

    public static void main(String[] args) throws Throwable {
        System.out.println("Hello world!");

        linkedList lst = new linkedList();

        lst.add(1);
        lst.add(2);
        lst.add(3);

        for (int i = 0; i < lst.size(); ++i)
            System.out.println(i + ") " + lst.get(i));

        lst.add(0, 55);

        for (int i = 0; i < lst.size(); ++i)
            System.out.println(i + ") " + lst.get(i));

        System.out.println("DONE!");
    }
}