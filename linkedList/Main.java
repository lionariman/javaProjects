package test1;

class linkedList<T> {

    private static final class Entry<T> {
        T data;
        Entry<T> next = null;

        Entry(T data) {
            this.data = data;
        }
    }

    private Entry<T> head;
    private int size = 0;

    public Entry<T> getHead() {
        return this.head;
    }

    public int size() {
        return this.size;
    }

    linkedList() {
        this.head = null;
    }

    linkedList(linkedList<T> c) {
        this.head = c.getHead();
        this.size = c.size();
    }

    public boolean add(T c) {
        boolean isNotDuplicate = true;
        if (this.head == null) {
            this.head = new Entry<>(c);
        } else {
            Entry<T> tmp = this.head;
            for (; tmp.next != null; tmp = tmp.next)
                if (tmp.data == c)
                    isNotDuplicate = false;
            tmp.next = new Entry<>(c);
        }
        this.size++;
        return isNotDuplicate;
    }

    public void add(int index, T element) throws IndexOutOfBoundsException {
        if (this.head == null) {
            this.head = new Entry<>(element);
        } else {
            Entry<T> e = new Entry<>(element);
            if (index == 0) {
                e.next = getEntry(index);
                this.head = e;
            } else {
                e.next = getEntry(index);
                getEntry(index - 1).next = e;
            }
        }
        this.size++;
    }

    private Entry<T> getEntry(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        Entry<T> tmp = this.head;
        for (int i = 0; i < index; tmp = tmp.next, ++i);
        return tmp;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
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
                ", head=" + head +
                ", size=" + size +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {

        linkedList<Integer> lst = new linkedList<>();

        lst.add(1);
        lst.add(2);
        lst.add(3);

//        for (int i = 0; i < lst.size(); ++i)
//            System.out.println(i + ") " + lst.get(i));

        lst.add(4, 55);

        for (int i = 0; i < lst.size(); ++i)
            System.out.println(i + ") " + lst.get(i));

        System.out.println("DONE!");
    }
}