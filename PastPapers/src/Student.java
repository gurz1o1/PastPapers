import java.util.*;

public class Student extends Person {
	private ArrayList<Course> activeCourses=new ArrayList<Course>();
	private ArrayList<Course> completedCourses=new ArrayList<Course>();
	private int maxCourses;
	public void setMax(int x)
	{
		maxCourses=x;
	}
	public int getMax()
	{
		return maxCourses;
	}
	public Student(String fname,String lname, ArrayList<Course> a, ArrayList<Course> c, int x)
	{
		super(fname,lname);
		activeCourses=a;
		completedCourses=c;
		maxCourses=x;
	}
	public boolean canEnroll(Course c)
	{
		//completedCourses.contains(c.getPrerequisiteCourses());
		
		boolean pre=false, act=false, comp=false,max=false;
		for(int i=0;i<c.getPrerequisiteCourses().size();i++)
		{
			for(int j=0;j<completedCourses.size();j++)
			{
				if(!c.getPrerequisiteCourses().get(i).equals(completedCourses.get(j))){
					pre = false;
				} else {
					pre = true;
					break;
				}
			}
			
		}
		for(Course a:activeCourses)
		{
			if(a.getName().equals(c.getName()))
				act=false;
			else 
			{
				act=true;
				break;
			}
		}
		for(Course a:completedCourses)
		{
			if(a.getName().equals(c.getName()))
				comp=false;
			else 
			{
				comp=true;
				break;
			}
		}
		int total=activeCourses.size()+completedCourses.size();
		max=maxCourses>total;
		
		return pre&&act&&comp&&max;
	}
	public boolean complete(String courseName) {
		
		boolean removed = false;
		for(Course c :activeCourses) {
			if(c.getName().equals(courseName)) {
				activeCourses.remove(c);
				removed = true;
				break;
			}
				
		}
		
		if(removed) {
			Course c = new Course(courseName, null);
			completedCourses.add(c);
			return true;
		}
		
		return false;
	}
	public boolean enroll(Course c2) {
		if(canEnroll(c2))
				{
				activeCourses.add(c2);
				return true;
				}
		return false;
		}
	
	public HashMap<Course, String> getAllCourses() {
		HashMap<Course,String> map=new HashMap<>();
		for(Course c:activeCourses)
		{
			map.put(c, "active");
		}
		for(Course c:completedCourses)
		{
			map.put(c, "completed");
		}
		return map;
	}
	public String summary() {
		String s="";
		for(Course c:activeCourses)
		{
			s+=c.getName()+ " (active)\n";
		}
		for(Course c:completedCourses)
		{
			s+=c.getName()+ " (completed)\n";
		}
		
		return s;
	}
}
