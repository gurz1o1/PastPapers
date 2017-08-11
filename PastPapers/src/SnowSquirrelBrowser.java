import java.util.*;

public class SnowSquirrelBrowser extends Browser 
{
	
	private HashMap<String,Double> installedPlugins=new HashMap<>();
	private String version;
	double availableQuota;
	public double getQuota()
	{
		return availableQuota;
	}
	public String getVersion()
	{
		return version;
	}
	public SnowSquirrelBrowser(String name, double cq,String ver)
	{
		super(name);
		availableQuota=cq;
		version=ver;
	}
	public boolean installPlugin(Plugin p)
	{
		if(installedPlugins.containsKey(p.getName()))
			return false;
		if(p.getQuotaReq()>availableQuota)
			return false;
		if(!p.getVersionReq().equals(version))
			return false;
		else
		{
			installedPlugins.put(p.getName(),p.getQuotaReq());
			availableQuota-=p.getQuotaReq();
			return true;
		}
	}
	public boolean uninstallPlugin(Plugin p)
	{
		if(!installedPlugins.containsKey(p.getName()))
			return false;
		else
		{	availableQuota+=p.getQuotaReq();
			installedPlugins.remove(p.getName());
			return true;
			
		}		
	}
	public boolean usePlugin(String name)
	{
		if(!installedPlugins.containsKey(name))
			return false;
		for(String s:installedPlugins.keySet())
		{
			if(s.equals(name))
			{	if(availableQuota>=1)
				{
				installedPlugins.put(name, installedPlugins.get(name)+1);
				availableQuota-=1;
				return true;
				}
			return false;
			}
			return false;
		}
			return false;
	}
	
	public ArrayList<String> getInstalledPlugins()
	{
		ArrayList<String> plugins=new ArrayList<>();
		ArrayList<Double> x=new ArrayList<>();
		for(double a:installedPlugins.values())
		{
			x.add(a);
		}
		Collections.sort(x);
		Collections.reverse(x);
		for(double y:x)
		{
			for(String z:installedPlugins.keySet())
			{
				if(installedPlugins.get(z)==y)
				{
					plugins.add(z);
				}
			}
		}
		return plugins;
	}	
}
