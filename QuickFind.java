public class QuickFind
{
    private int[] A;
    public QuickFind(int N){
        A = new int[N];
        for(int i=0;i<N;i++){
            A[i]=i;
        }
    }
    public boolean Connected(int a,int b){
        return(A[a]==A[b]);
    }
    public void Union(int a,int b){
        for(int i=0;i<A.length;i++){
            if(A[i]==A[a]){
                A[i]=A[b];
            }
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
