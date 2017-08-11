import java.util.*;
import java.util.Map.Entry;

public class FruitySmartPhone extends Phone {
	HashMap<String,Integer> installedApps=new HashMap<>();
	private int cpuSpeed;
	private int freeMemory;
	public int getCpuSpeed()
	{
		return cpuSpeed;
	}
	public int getFreeMemory()
	{
		return freeMemory;
	}
	public FruitySmartPhone(String name, int am, int cpu)
	{
		super(name);
		freeMemory=am;
		cpuSpeed=cpu;
	}
	public boolean installApp(App a)
	{
		for(String s:installedApps.keySet())
		{
			if(s.equals(a.getName()))
				return false;
		}
		if(a.getMemoryReq()>freeMemory||a.getCpuReq()>cpuSpeed)
		{
			return false;
		}
		else
		{
			installedApps.put(a.getName(), a.getMemoryReq());
			freeMemory-=a.getMemoryReq();
			return true;
		}
	}
	public boolean uninstallApp(App a)
	{
		for(String s:installedApps.keySet())
		{
			if(s.equals(a.getName()))
			{	
				freeMemory+=a.getMemoryReq();
				installedApps.remove(a.getName());
				return true;
			}
		}
		return false;
	}
	public boolean useApp(String a)
	{	
		
		for(String s:installedApps.keySet())
		{
			if(a.equals(s))
			{
				if(freeMemory>=1){
					freeMemory-=1;
					installedApps.put(a,installedApps.get(a)+1);
					return true;
				}
					
				return false;
			}
			return false;
		}
		

		return false;
	}
	

	
	
	
	public ArrayList<String> getInstalledApps()
	{	if(installedApps.size()==0)
			return null;
		ArrayList<String> a=new ArrayList<>();
		ArrayList<Integer> list=new ArrayList<>(installedApps.values());
		Collections.sort(list);		
		Collections.reverse(list);
		for(int values:list)
		{
			for(String key:installedApps.keySet())
			{
				if(values==installedApps.get(key))
					a.add(key);
			}
		}
		return a;
	}	
}
