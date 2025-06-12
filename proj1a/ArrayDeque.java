public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int first;
    private int last;
    private int capacity;
    public ArrayDeque() {
        size = 0;
        first = 0;
        last = 0;
        capacity = 8;
        array = (T[]) new Object[8];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void update() {
        if (capacity == size){
            resize(capacity * 2);
        } else if (size > 0 && size * 4 < capacity && capacity >= 16){
            resize((Math.max(capacity / 2,16)));
        }
    }
    //resize the array
    private void resize(int newcapacity) {
        T[] newArray = (T[]) new Object[newcapacity];
        int index = first;
        for (int i = 0; i < size; i++) {
            newArray[i] = array[index];
            index = (index + 1) % capacity;
        }
        array = newArray;
        capacity = newcapacity;
    }

    public void addFirst(T item) {
        update();
        first = (first - 1 + capacity) % capacity;
        array[first] = item;
        size = size + 1;
    }

    public void addLast(T item) {
        update();
        array[last] = item;
        last = (last + 1) % capacity;
        size = size + 1;
    }

    public int size() {
        return Math.max(0,size);
    }

    public void printDeque() {
        int index = first;
        while (index != last) {
            System.out.print(array[index]);
            System.out.print(" ");
            index = (index + 1) % capacity;
        }
        System.out.println();
    }

    public T removeFirst() {
        T item=array[first];
        array[first] = null;
        first = (first - 1 + capacity) % capacity;
        size--;
        update();
        return item;
    }
    public T removeLast() {
        last = (last -1 + capacity) % capacity;
        T item = array[last];
        array[last] = null;
        size--;
        update();
        return item;
    }

    public T get(int index){
        if (index < 0 || index >= first + size) {
            return null;
        }
        int i = first;
        for (int j = 0; j <= index; j++) {
            i = (i + 1) % capacity;
        }
        return array[i];
    }
}
