package in.ineuron.servicefactory;

import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;


public class StudentServiceFactory 
{
	
	private StudentServiceFactory() 
	{
		
	}
	public static IStudentService StudentService=null;
	public static IStudentService getStudentService()
	{
		//singleton  pattern code
		if(StudentService==null) 
		{
			StudentService =new StudentServiceImpl();
		}
		return StudentService;
	}
}
