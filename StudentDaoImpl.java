package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.dto.Student;
import in.ineuron.jdbcUtil.JDBCUtil;

public class StudentDaoImpl implements IStudentDao {

	
	@SuppressWarnings("finally")
	@Override
	public String addStudent(Student student) 
	{
		Session session=null;
		Transaction tran=null;
		boolean flag=false;
		try
		{
			session=JDBCUtil.getConnection();
			tran=session.beginTransaction();
			if(session!=null)
			{
				session.save(student);
				flag=true;
			}
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(flag)
			{
				tran.commit();
				return "success";
			}
			else
			{
				tran.rollback();
				return "not";
			}
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Student searchStudent(Integer sid) 
	{
		Student student=null;
		Session session=null;
		boolean flag=false;
		try
		{
			session=JDBCUtil.getConnection();
			student=(Student)session.get(Student.class,sid);
			flag=true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			flag=false;
		}
		finally
		{
			return student;
		}
	}

	@Override
	public String updateStudent(Student student) 
	{
		Student stu1=null;
		Session session=null;
		boolean flag=false;
		Transaction tran=null;
		try
		{
		session=JDBCUtil.getConnection();
		tran=session.beginTransaction();
		stu1=(Student)session.merge(student);
		flag=true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(flag)
			{
				tran.commit();
				System.out.println(stu1);
				return "success";
			}
		}
		tran.rollback();
		return "fail";
	}

	@Override
	public String deleteStudent(Integer sid) 
	{
		Student stu1=null;
		Session session=null;
		boolean flag=false;
		Transaction tran=null;
		Integer count=null;
		try
		{
			session=JDBCUtil.getConnection();
			tran=session.beginTransaction();
			stu1=(Student)session.get(Student.class,sid);
			if(stu1!=null)
				{session.delete(stu1);
				flag=true;}
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(flag)
			{
				tran.commit();
				return "success";
			}
			tran.rollback();
		}
		return "failed";
	}

}
