public class FixedCapacityStackOfStrings
{  
    private String[] s;
    private int N=0;
    public FixedCapacityStackOfStrings(int capacity){
        s = new String[capacity]; 
    }
    public boolean isEmpty(){
        return(N==0);
    }
    public void push(String item){
        s[N++]=item;
    }
    public String pop(){
	String item = s[--N];
	s[N] = null;    
        return(item);
    }

	public static void main(String[] args) {
	    FixedCapacityStackOfStrings s1 = new FixedCapacityStackOfStrings(10);
	    s1.push("hello");
	    s1.push("hunter");
	    System.out.println(s1.pop());
	    s1.push("hello");
	    System.out.println(s1.s[1]);

	}
}
