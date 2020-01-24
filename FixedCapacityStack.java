public class FixedCapacityStack<Item>
{
    private Item[] s;
    private int n =0;
    public FixedCapacityStack(int N){
        s = (Item[]) new Object[N];
    }
    public boolean isEmpty(){
        return(n==0);
    }
    public void push(Item item){
        s[n++] = item;
    }
    public Item pop(){
        Item x = s[--n];
        s[n] = null;
        return(x);
    }
	public static void main(String[] args) {
		FixedCapacityStack q = new FixedCapacityStack(10);
		q.push("hello");
		q.push(5);
		System.out.println(q.pop());
	}
}
