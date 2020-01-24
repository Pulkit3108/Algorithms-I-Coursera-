import java.util.*;  
public class Main<Item>
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
	    Scanner sc= new Scanner(System.in);
		Main<Character> op = new Main<>();
		Main<Double> val = new Main<>();
		for (char c : s.toCharArray()){
		    if(c=='('){}
		    else if(c=='+'){
		        op.push(c);
		    }
		    else if(c=='*'){
		        op.push(c);
		    }
		    else if(c==')'){
		        char x = op.pop();
		        if(x=='+'){
		            val.push(val.pop()+val.pop());
		        }
		        else if(x=='*'){
		            val.push(val.pop()*val.pop());
		        }
		    }
		    else val.push(Double.parseDouble(s));
		}
		System.out.println(val.pop());
	}
}
