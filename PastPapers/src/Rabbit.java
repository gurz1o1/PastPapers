import java.util.*;

public class Rabbit {
	private int n;
	private Integer[][] r;
	public Rabbit(int n)
	{
		this.n=n;
		r=new Integer[n][];
		
	}
	public void init() 
	{
		if(n<2)
			return;
		else
		{	
			
			r[0]=new Integer[]{1};
			r[1]=new Integer[]{1,0};
			for(int i=2;i<n;i++)
			{
				r[i]=new Integer[r[i-1].length+r[i-2].length];
				System.arraycopy(r[i-1], 0, r[i], 0, r[i-1].length);
				System.arraycopy(r[i-2], 0, r[i], r[i-1].length,r[i-2].length);

			}
		}
	}
	public String toString()
	{
		String s="";
		for(int i=0;i<r.length;i ++) {
			Integer[] row = r[i];
			s+= Arrays.toString(row) + "\n";
		}		
		return s;
	}
	public int subsequenceIndex(Integer[] a) 
	{
		return Collections.indexOfSubList(Arrays.asList(r[r.length - 1]), Arrays.asList(a));
	}
	
	public static void main(String args[])
	{
		int n=Integer.parseInt(args[0]);
		Rabbit rabbit = new Rabbit(n);
		rabbit.init();
		System.out.print(rabbit.toString());
		System.out.println(rabbit.subsequenceIndex(new Integer[]{1,1,0}));
		System.out.println(rabbit.subsequenceIndex(new Integer[]{1,1,1}));

	}
}
