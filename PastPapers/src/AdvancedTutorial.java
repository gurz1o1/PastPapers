import java.util.*;

public class AdvancedTutorial extends Tutorial
{
	private String topic;
	public AdvancedTutorial(String name1, String name2, String name3)
	{
		super(name2,name3);
		topic=name1;
		
	}
	public String toString()
	{
		return "Topic: "+topic+" "+super.toString();
	}
	public boolean couldCombineWith(AdvancedTutorial a)
	{
		return a.topic.equals(topic)&&a.getTime().equals(super.getTime());
	}
	public static HashMap<String, ArrayList<AdvancedTutorial>> construct(String[] s)
	{
		HashMap<String, ArrayList<AdvancedTutorial>> map=new HashMap<>();
		for(int i=0;i<s.length;i=i+3)
		{
			ArrayList<AdvancedTutorial> ad=new ArrayList<AdvancedTutorial>();
			ad.add(new AdvancedTutorial(s[i], s[i+1], s[i+2]));
			map.put(s[i],ad );
		}
		return map;
	}
	public static void main(String args[])
	{
		if(args.length==0||args.length%3!=0)
		{
			System.out.println("Wrong number of arguments");
			return;
		}
		System.out.println(construct(args));
	}
}