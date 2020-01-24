import java.util.Iterator;
public class LinkedListIterator<Item> implements Iterable<Item>
{
    private Node first = null;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return(first==null);
    }
    public void push(Item item){
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
    }
    public Item pop(){
        Item s = first.item;
        first = first.next;
        return(s);
    }
    public Iterator<Item> iterator(){
        return(new ListIterator());
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return(current!=null);
        }
        public void remove(){  
            /* not supported */      
        }              
        public Item next(){            
            Item item = current.item;            
            current   = current.next;             
            return (item);
        }
    }
	public static void main(String[] args) {
		LinkedListIterator q = new LinkedListIterator();
		q.push("hello");
		q.push("hunter");
		System.out.println(q.iterator());
	}
}
