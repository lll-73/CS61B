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
        if (first + size -1 <= capacity) {
            System.arraycopy(array, first, newArray, 0, size);
            last = size;
        } else {
            System.arraycopy(array, first, newArray, 0, capacity - first);
            System.arraycopy(array, 0, newArray, capacity - first + 1, size - capacity + first);
            last = size;
        }
        array = newArray;
        capacity = newcapacity;
    }

    public void addFirst(T item) {
        update();
        if (first == 0) {
            first = capacity - 1;
        } else {
            first = first - 1;
        }
        array[first] = item;
        size = size + 1;
    }

    public void addLast(T item) {
        update();
        array[last] = item;
        if (last == capacity - 1) {
            last = 0;
        } else {
            last = last + 1;
        }
        size = size + 1;
    }

    public int size() {
        return size;
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
        if (first == capacity - 1) {
            first = 0;
        } else {
            first = first - 1;
        }
        size--;
        update();
        return item;
    }
    public T removeLast() {
        if (last == 0) {
            last = capacity - 1;
        } else {
            last = last - 1;
        }
        T item = array[last];
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
