public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int first;
    private int last;
    public ArrayDeque(){
        size=0;
        first=0;
        last=0;
        T[] array = (T[]) new Object[8];
    }

    public boolean isEmpty(){
        return size==0;
    }

    private void update(){
        if (array.length==size){
            resize(array.length*2);
        }else if (size>0 && size*4<array.length && array.length>=16){
            resize((Math.max(array.length/2,16)));
        }
    }
    //resize the array
    private void resize(int capacity){
        T[] newArray = (T[]) new Object[capacity];
        if (first+size-1<=array.length) {
            System.arraycopy(array,first,newArray,first,size);
        } else {
            System.arraycopy(array,first,newArray,first,array.length-first);
            System.arraycopy(array,0,newArray,first+array.length-first,size-array.length+first);
        }
        array=newArray;
    }

    public void addFirst(T item){
        update();
        if (first==0){
            first=array.length-1;
        } else {
            first=first-1;
        }
        array[first]=item;
        size=size+1;
    }

    public void addLast(T item){
        update();
        if (last==array.length-1){
            last=0;
        } else {
            last = last+1;
        }
        array[last]=item;
        size = size+1;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        if(size+first-1> array.length) {
            for (int i = first; i < array.length; i++) {
                System.out.print(array[i]);
                System.out.print(" ");
            }
            for(int i=0;i<size-array.length+first;i++){
                System.out.print(array[i]);
                System.out.print(" ");
            }
        }else{
            for (int i =first;i<first+size;i++){
                System.out.print(array[i]);
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    public T removeFirst(){
        T item=array[first];
        if(first==array.length-1){
            first=0;
        }else{
            first=first-1;
        }
        size--;
        update();
        return item;
    }
    public T removeLast(){
        T item=array[last];
        if(last==0){
            last= array.length-1;
        }else{
            last=last-1;
        }
        size--;
        update();
        return item;
    }

    public T get(int index){
        if(index<0||index>=first+size){
            return null;
        }
        if (first+size-1<=array.length) {
            int i = index + first;
            return array[i];
        } else {
            int i = index+first;
            if(i<array.length){
                return array[i];
            } else {
                i = i - array.length;
                return array[i];
            }
        }
    }
}
