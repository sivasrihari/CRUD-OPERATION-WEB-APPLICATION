package in.ineuron.service;

import in.ineuron.dto.Student;
import in.ineuron.dao.*;
import in.ineuron.daofactory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService 
{
	private IStudentDao stdServicedao=null;
	
	@Override
	public String addStudent(Student student) 
	{
		stdServicedao=StudentDaoFactory.getStudentDao();
		if(stdServicedao!=null)
			return stdServicedao.addStudent(student);
		else
		{
			return "not";
		}
	}

	@Override
	public Student searchStudent(Integer sid) 
	{
		stdServicedao=StudentDaoFactory.getStudentDao();
		if(stdServicedao!=null)
		{
			return stdServicedao.searchStudent(sid);
		}
		else
			return null;
	}

	@Override
	public String updateStudent(Student student) 
	{
		
		stdServicedao=StudentDaoFactory.getStudentDao();
		if(student!=null)
			return stdServicedao.updateStudent(student);
		return "no";
	}

	@Override
	public String deleteStudent(Integer sid)
	{
		stdServicedao=StudentDaoFactory.getStudentDao();
		if(stdServicedao!=null)
		{
			return stdServicedao.deleteStudent(sid);
		}
		else
			return null;
	}

}
