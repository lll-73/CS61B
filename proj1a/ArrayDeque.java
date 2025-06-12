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
        T[] array = (T[]) new Object[8];
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
            System.arraycopy(array, first, newArray, first, size);
        } else {
            System.arraycopy(array, first, newArray, first, capacity-first);
            System.arraycopy(array, 0, newArray, first + capacity - first, size - capacity + first);
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
        if (last == capacity - 1) {
            last = 0;
        } else {
            last = last + 1;
        }
        array[last] = item;
        size = size + 1;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (size + first - 1 > capacity) {
            for (int i = first; i < capacity; i++) {
                System.out.print(array[i]);
                System.out.print(" ");
            }
            for(int i = 0; i < size - capacity + first; i++) {
                System.out.print(array[i]);
                System.out.print(" ");
            }
        } else {
            for (int i = first; i < first + size; i++) {
                System.out.print(array[i]);
                System.out.print(" ");
            }
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
    public T removeLast(){
        T item = array[last];
        if (last == 0) {
            last = capacity - 1;
        } else {
            last = last - 1;
        }
        size--;
        update();
        return item;
    }

    public T get(int index){
        if (index < 0 || index >= first + size) {
            return null;
        }
        if (first + size - 1 <= capacity) {
            int i = index + first;
            return array[i];
        } else {
            int i = index + first;
            if (i < capacity) {
                return array[i];
            } else {
                i = i - capacity;
                return array[i];
            }
        }
    }
}
