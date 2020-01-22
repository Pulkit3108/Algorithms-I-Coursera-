public class ResizingArrayStackOfStrings
{ 
    private String[] S;
    private int N;
    public ResizingArrayStackOfStrings(){
        S = new String[1];
    }
    public boolean isEmpty(){
        return(N==0);
    }
    public void push(String item){
        if(N==S.length){
            resize(2*S.length);
        }
        S[N++]=item;
        
    }
    public void resize(int size){
        String[] X = new String[size];
        for(int i=0;i<N;i++){
            X[i]=S[i];
        }
        S = X;
    }
    public String pop(){
        String item = S[--N];
        S[N]=null;
        if(N>0 && N==S.length/4){
            resize(S.length/2);
        }
        return(item);
    }
	public static void main(String[] args) {
	    ResizingArrayStackOfStrings s1 = new ResizingArrayStackOfStrings();
	    s1.push("hello");
	    s1.push("hunter");
	    System.out.println(s1.pop());
	    System.out.println(s1.S[1]);

	}
}
