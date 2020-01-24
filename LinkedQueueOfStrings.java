public class LinkedQueueOfStrings
{
    private Node first,last;
    private class Node{
        String item;
        Node next;
    }
    public boolean isEmpty(){
        return(first==null);
    }
    public void enqueue(String item){
        Node old = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        }
        else{
            old.next = last;
        }
    }
    public String dequeue(){
        String s = first.item;
        first = first.next;
        if(isEmpty()){
            last = null;
        }
        return(s);
    }
	public static void main(String[] args) {
		LinkedQueueOfStrings q = new LinkedQueueOfStrings();
		q.enqueue("hello");
		q.enqueue("hunter");
		System.out.println(q.dequeue());
	}
}
