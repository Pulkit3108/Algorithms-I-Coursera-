public class QuickUnion
{
    private int[] A;
    public QuickUnion(int N){
        A = new int[N];
        for(int i=0;i<N;i++){
            A[i]=i;
        }
    }
    public int root(int a){
        while(A[a]!=a){
            a=A[a];
        }
        return(a);
    }
    public boolean Connected(int a,int b){
        return(root(a)==root(b));
    }
    public void Union(int a,int b){
        int x=root(a);
        A[x]=root(b);
    }
    
	public static void main(String[] args) {
	    int N=6;
		Main M = new Main(6);
		M.Union(1,4);
		M.Union(4,5);
		System.out.println(M.Connected(1,5));
	}
}
