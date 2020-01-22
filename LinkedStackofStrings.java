public class LinkedStackofStrings
{
    private Node first = null;
    private class Node{
        String item;
        Node next;
    }
    public boolean isEmpty(){
        return(first==null);
    }
    public void push(String s){
        Node old = first;
        first = new Node();
        first.item = s;
        first.next = old;
    }
    public String pop(){
        String a = first.item;
        first = first.next;
        return(a);
    }
	public static void main(String[] args) {
	    LinkedStackofStrings m1 = new LinkedStackofStrings();
	    m1.push("hello");
	    m1.push("hunter");
	    System.out.println(m1.pop());
		
	}
}
