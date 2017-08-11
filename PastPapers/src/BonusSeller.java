import java.util.*;

public class BonusSeller extends Seller {
	private HashMap<String, Double> sales=new HashMap<String,Double>();
	public BonusSeller(String n)
	{
		super(n);
		sales=new HashMap<>(10);
	}

	public void sale(String name,double cost)
	{	
			super.sale(cost);
			if(sales.containsKey(name))
			{
				sales.put(name, sales.get(name)+cost);
			}
			else
			{
				sales.put(name,cost);
			}
		
	}
	public String toString()
	{
		String s=String.format("%s \nSales per customer:", super.toString());
		String t="";
		for(String n:sales.keySet())
		{
			t+=n+":"+(sales.get(n)).intValue()+"kg\n";
		}
		return s+t;
	}

	public int calculateBonus() {
		int count=0;
		for(double d:sales.values())
		{
			if(d>=20)
				count++;
		}
		if(count<5)
			return 0;
		else if(count>=5&&count<10)
			return 5;
		else if(count>=10)
			return 7;
		return 0;
		
		
	}
}