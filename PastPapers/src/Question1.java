import java.util.*;

public class Question1 
{
	public static ArrayList<Integer> cayley()
	{
		ArrayList<Integer> a=new ArrayList<>();
		for(int i=0;i<=9;i++)
		{
			for(int j=1;j<=9;j++)
			{
				if((i*j)+(i+j)==j*10+i)
				{
					a.add(j*10+i);
				}
			}
		}
		Collections.sort(a);
		return a;
	}
	public static int[] countVowels(String[] s)
	{
		int[] a=new int[s.length];
		int counter=0;
		for(int i=0;i<s.length;i++)
		{
			String str=s[i];
			for(int j=0;j<str.length();j++)
			{
				String c=str.substring(j,j+1);
				if(c=="a"||c=="A"||c=="e"||c=="E"||c=="i"||c=="I"||c=="o"||c=="O"||c=="u"||c=="U")
				{
					counter=counter+1;
				}
			}
			a[i]=counter;
		}
		return a;
	}
	
	
				public static String mostVowels(String[] inputs) 
				{
					int valid = inputs.length;
					if(valid == 0)
					{
						return "";
					}
					int [] max = countVowels(inputs);
					int com = max[0];
					int index =0;
					for(int i = 1; i <inputs.length; i++)
					{
						if(max[i] > com)
						{
							com = max[i];
							index = i;
						}
						
						
					}
					return inputs[index];
				}
	
	
	public static void main(String[] args)
	{	
		ArrayList<Integer> a=cayley();
		System.out.println(a);
		System.out.println(Arrays.toString(countVowels(args)));
		System.out.println((mostVowels(args)));
	}
	
	
	
	
	
	
}