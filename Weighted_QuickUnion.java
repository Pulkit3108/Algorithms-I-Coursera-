public class Weighted_QuickUnion
{
    private int[] A;
    private int[] S;
    public Weighted_QuickUnion(int N){
        A = new int[N];
        S = new int[N];
        for(int i=0;i<N;i++){
            A[i]=i;
            S[i]=1;
        }
    }
    public int root(int a){
        while(A[a]!=a){
	    A[a]=A[A[a]];	
            a=A[a];
        }
        return(a);
    }
    public boolean Connected(int a,int b){
        return(root(a)==root(b));
    }
    public void Union(int a,int b){
        int x=root(a);
        int y=root(b);
        if(x==y){
            return;
        }
        if(S[x]<S[y]){
            A[x]=y;
            S[y]+=S[x];
        }
        else{
            A[y]=x;
            S[x]+=S[y];
        }
        
    }
    
	public static void main(String[] args) {
	    int N=6;
		Main M = new Main(6);
		M.Union(1,4);
		M.Union(4,5);
		System.out.println(M.Connected(1,5));
	}
}
