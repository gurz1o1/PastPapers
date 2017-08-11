import java.util.*;

public class Entropy {
	public static int[] charCount(String s)
	{if(s==""||s==null)
		return null;
	char[]a=s.toCharArray();
	Arrays.sort(a);
	HashMap<Character,Integer>map=new HashMap<>();
	for(int i=0;i<a.length;i++)
	{
		if(map.containsKey(a[i]))
		{
			map.put(a[i], map.get(a[i])+1);
		}
		else
		{
			map.put(a[i], 1);
		}
	}
	int[] b=new int[map.size()];
	int j=0;
	for(int x:map.values())
	{	
		b[j]=x;
		j++;
	}
	
	return b;
	
	}
	public static double[] normalise(int[] c)
	{
		double sum=0.0;
		double[] p=new double[c.length];
		if(c.length==0||c==null){
			return null;
		}
		for(int i=0;i<c.length;i++)
		{
			sum+=c[i];
		}
		for(int i=0;i<c.length;i++)
		{
			p[i]=(double)(c[i]/sum);
		}
		return p;
	}
	public static double entropyOf(double[] p)
	{
		double x=0.0;
		for(int i=0;i<p.length;i++)
		{
			x+=-1*(p[i]*Math.log(p[i]));
		}
		return x;
	}
	public static int[][] charCountArray(String[] a)
	{	
		int [][] x = new int[a.length][];
		for(int i=0;i<a.length;i++)
		{	
			String s=a[i];
			
			for(int j=0;j<s.length();j++)
			{
			
				String c = s.substring(j, j+1);
				
				for(int k=i+1;k<a.length;k++) {
					if(a[k].indexOf(c) != -1) {
						a[k] = a[k].replaceAll(c, "");
						a[i] = a[i].replaceAll(c, "");
					}
				}
			}
		}
		
		for(int i=0;i<a.length;i++)
		{
			int[] count = charCount(a[i]);
			x[i] = count;
		}
		
		return two;
	}
	public static void main(String[] args)
	{
		String a=args[0];
		String b=args[1];
		System.out.print("Character probabilities in "+a+" : ");
		System.out.println(Arrays.toString(normalise(charCount(a))));
		System.out.print("Entropy of "+a+" ");
		System.out.println((entropyOf(normalise(charCount(a)))));
		System.out.print("Entropy of "+b+" ");
		System.out.println((entropyOf(normalise(charCount(b)))));
		System.out.print("Entropy of unique chars in "+a+" : ");
		System.out.println(entropyOf(normalise(charCountArray(args)[0])));
		System.out.print("Entropy of unique chars in "+b+" : ");
		System.out.println(entropyOf(normalise(charCountArray(args)[1])));
		
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
