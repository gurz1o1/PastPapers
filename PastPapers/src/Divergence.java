import java.util.*;

public class Divergence {
	public static int[] charCount(String s)
	{
		char[] a=s.toCharArray();
		HashMap <Character, Integer> map=new HashMap<>();
		if(a.length==0||a==null)
			return null;
		Arrays.sort(a);
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
		int [] freq=new int[map.size()];
		int j=0;
		for(int x:map.values())
		{
			freq[j]=x;
			j++;
		}
		return freq;
	}
	public static double[] normalise(int[] c)
	{	if(c.length==0||c==null)
			return null;
		else
		{
		double[]p=new double[c.length];
		double sum=0.0;
		for(int i=0;i<c.length;i++)
		{
			sum+=c[i];
		}
		for(int i=0;i<c.length;i++)
		{
			p[i]=c[i]/sum;
		}
		return p;
		}
	
	}
	
	public static double kld(double[] p, double[] q)
	{
		double sum=0.0;
		for(int i=0;i<p.length;i++)
		{
			sum+=(p[i]*Math.log(p[i]/q[i]));
		}
		return sum;
	}
	public static int[][] charCountArray(String a[])
	{
		int[][] x=new int[a.length][];
		for(int i=0;i<a.length-1;i++)
		{
			String s=a[i];
			Object String;
			for(int j=0;j<s.length();j++)
			{
				String c=s.substring(j, j+1);
				for(int k=i+1;k<a.length;k++)
				{
				if(a[k].indexOf(c)==-1)
					{
					a[k].replaceAll(c, "");
					a[i].replaceAll(c, "");
					}		
				}
			}
		}
		for(int i=0;i<a.length;i++)
		{
			x[i]=charCount(a[i]);
		}
		return x;
	}
	
	public static void main(String[] args)
	{
		String a=args[0];
		String b=args[1];
		System.out.println(Arrays.toString(charCount(a)));
		System.out.println(Arrays.toString(normalise(charCount(a))));
		System.out.println(Arrays.toString(normalise(charCount(b))));
		System.out.print(Arrays.toString(charCountArray(args)));
		
		int[][] x=charCountArray(args);
		double[] p=normalise(x[0]);
		double[] q=normalise(x[1]);
		System.out.printf("%.3f",kld(p,q));
		//System.out.printf("%.3f", kld(normalise(charCountArray(args)[0])));
	}
	
	
	
}
