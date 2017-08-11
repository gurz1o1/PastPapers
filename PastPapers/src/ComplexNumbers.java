import java.util.*;



public class ComplexNumbers {

		public static double[] complexAdd(double[] z1, double[] z2)
		{
			double [] complex=new double[2];
			complex[0]=z1[0]+z2[0];
			complex[1]=z1[1]+z2[1];
			return complex;
		}
		public static double[] complexConjugate(double[] z)
		{	double[] x=new double[2];
			x[0]=z[0];
			x[1]=z[1]*-1;
			return x;
		}
		public static double[] complexMultiply(double[] z1, double[] z2)
		{
			double[] complex=new double[2];
			complex[0]=(z1[0]*z2[0])-(z1[1]*z2[1]);
			complex[1]=(z1[0]*z2[1]) + (z1[1]*z2[0]);
			return complex;
		}
		public static double[] complexReciprocal(double[] z)
		{
			double[] reciprocal=new double[2];
			reciprocal[0]=z[0]/(z[0]*z[0]+z[1]*z[1]);
			reciprocal[1]=-1*z[1]/(z[0]*z[0]+z[1]*z[1]);
			return reciprocal;
		}
		public static String toString(double[] z)
		{
			if(z[0]==0.0 && z[1]==0.0)
			{
				return "(0.0)";
			}
			else if(z[0]==0)
			{
				String s=String.format("(%.1fi)", z[1]);
				return s;
			}
			else if(z[1]==0)
			{
				String s=String.format("(%.1f)", z[0]);
				return s;
			}
			else if(z[1]>0)
			{
				String s =String.format("(%.1f+%.1fi)",z[0],z[1]);
				return s;
			}
			else
			{
				String s =String.format("(%.1f%.1fi)",z[0],z[1]);
				return s;
			}
		}
		
		
public static double[][] sortByMagnitude(double[][] unsorted) 
	
	{
		double [] mag = new double [unsorted.length];
		double[][] sorted = new double [unsorted.length][2];
		for(int i = 0; i < unsorted.length; i++)
		{
			for(int j = 0; j< unsorted[i].length; j++)
			{
				mag[i]= Math.sqrt((unsorted[i][0] * unsorted[i][0]) + (unsorted[i][1] * unsorted[i][1]));
			}
			
		}
		double min = mag[0];
		double [] test = unsorted[0];
				
		for(int i = 1; i <mag.length; i++)
		{
			if(mag[i] <min)
			{
				min = mag[i];
				test = unsorted[i];
				
			}
			
			sorted[i] = test;
		}
		
		return sorted;
	}
		

		
		public static void main(String args[])
		{	
			double[] z1=new double[2];
			double[] z2=new double[2];
			z1[0]=Double.parseDouble(args[0]);
			z1[1]=Double.parseDouble(args[1]);
			z2[0]=Double.parseDouble(args[2]);
			z2[1]=Double.parseDouble(args[3]);
			double[][]x=;
			double a[]=ComplexNumbers.complexAdd(z1, z2);
			System.out.println(ComplexNumbers.toString(a));
			double b[]=ComplexNumbers.complexConjugate(z1);
			System.out.println(ComplexNumbers.toString(b));
			double c[]=ComplexNumbers.complexMultiply(z1, z2);
			System.out.println(ComplexNumbers.toString(c));
			double d[]=ComplexNumbers.complexReciprocal(z1);
			System.out.println(ComplexNumbers.toString(d));
			double e[]=ComplexNumbers.complexConjugate(a);
			System.out.println(ComplexNumbers.toString(e));
			System.out.println(sortByMagnitude(unsorted));
			}
}











