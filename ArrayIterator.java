import java.util.Iterator;
public class ArrayIterator<Item> implements Iterable<Item>
{
    private Item[] S;
    private int N=0;
    private ArrayIterator(int n){
        S = (Item[]) new Object[n];
    }
    public boolean isEmpty(){
        return(N==0);
    }
    public void push(Item item){
        S[N++] = item;
    }
    public Item pop(){
        Item s = S[--N];
        S[N] = null;
        return(s);
    }
    public Iterator<Item> iterator(){
        return(new ReverseArrayIterator());
    }
    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;
        public boolean hasNext(){
            return(i>0);
        }
        public void remove(){  
            /* not supported */      
        }              
        public Item next(){            
            return(S[--i]);
        }
    }
	public static void main(String[] args) {
		ArrayIterator q = new ArrayIterator(10);
		q.push("hello");
		q.push("hunter");
		System.out.println(q.iterator());
	}
}
