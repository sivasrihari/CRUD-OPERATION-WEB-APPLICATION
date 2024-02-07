package in.ineuron.daofactory;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dao.StudentDaoImpl;

public class StudentDaoFactory 
{
	private StudentDaoFactory()
	{	
	}
	private static IStudentDao StudentDao=null;
	public static IStudentDao getStudentDao()
	{
		if(StudentDao==null)
			StudentDao=new StudentDaoImpl();
		return StudentDao;
	}
}
