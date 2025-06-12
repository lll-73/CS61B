public class LinkedListDeque<T> {
    private T item;
    private int size;
    private static class Node<T>{
        private Node<T> prev;
        private T item;
        private Node<T> next;
        public Node() {
            prev=null;
            item=null;
            next=null;
        }
        public Node(T i) {
            prev=null;
            item=i;
            next=null;
        }
        public Node(Node<T> p,T i,Node<T> q){
            prev=p;
            item=i;
            next=q;
        }
        public Node(Node<T> p,T i){
            prev=p;
            item=i;
            next=null;
        }
        public Node(T i,Node<T> q) {
            prev=null;
            item=i;
            next=q;
        }
    }

    private Node<T> headsentinel;
    private Node<T> endsentinel;
    public LinkedListDeque(){
        size=0;
        headsentinel=null;
        endsentinel=null;
    }
    //public LinkedListDeque(T item){
    //    size=1;
    //    headsentinel=new Node<>(item);
    //    endsentinel=headsentinel;
    //}

    public void addFirst(T item){
        headsentinel = new Node<>(item,headsentinel);
        if (size>0){
            headsentinel.next.prev=headsentinel;
        }else{
            endsentinel=headsentinel;
        }
        size=size+1;
    }

    public void addLast(T item){
        endsentinel = new Node<>(endsentinel,item);
        if (size>0){
            endsentinel.prev.next=endsentinel;
        }else{
            headsentinel=endsentinel;
        }
        size = size+1;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node<T> p=headsentinel;
        while (p!=null){
            System.out.print(p.item);
            System.out.print(" ");
            p=p.next;
        }
    }

    //Removes and returns the item at the front of the deque. If no such item exists, return null.
    public T removeFirst(){
        if (headsentinel!=null){
            Node<T> p=headsentinel;
            if (size!=1) {
                headsentinel=headsentinel.next;
                headsentinel.prev=null;
            }else{
                headsentinel=null;
                endsentinel=null;
            }
            T item=p.item;
            p.next=null;
            p=null;
            size=size-1;
            return item;
        }
        return null;
    }

    //Removes and returns the item at the back of the deque. If no such item exists, return null.
    public T removeLast(){
        if (endsentinel!=null){
            Node<T> p=endsentinel;
            if (size!=1){
                endsentinel=endsentinel.prev;
                endsentinel.next=null;
            } else {
                endsentinel=null;
                headsentinel=null;
            }
            T item=p.item;
            p.prev=null;
            p=null;
            size=size-1;
            return item;
        }
        return null;
    }

    //Get the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque.
    public T get(int index){
        if (index<0 || index>=size){
            return null;
        } else {
            int i=0;
            Node<T> p=headsentinel;
            while (i!=index){
                p=p.next;
                i++;
            }
            return p.item;
        }
    }

    //Same as get method, but uses recursion.
    public T getRecursive(int index){
        if (index<0 || index>=size){
            return null;
        } else {
            Node<T> p=headsentinel;
            return getResHelper(index,p);
        }
    }

    //The helper method of getRecursive
    private T getResHelper(int index, Node<T> p){
        if (index==0){
            return p.item;
        } else {
            return getResHelper(index-1,p.next);
        }
    }
}
