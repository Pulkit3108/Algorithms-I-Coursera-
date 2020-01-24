public class Stack<Item>
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
	public static void main(String[] args) {
		Stack q = new Stack();
		q.push("hello");
		q.push(5);
		System.out.println(q.pop());
	}
}
