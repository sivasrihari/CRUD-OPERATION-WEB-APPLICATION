package in.ineuron.jdbcUtil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.dto.Student;

//import com.zaxxer.hikari.*;
public class JDBCUtil 
{
	/*static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}*/
	
	/*public static Connection getConnection() throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql:///ineuron","root","root123@");
		return con;
	}*/
	
	/*
	 * public static Connection getConnection() throws SQLException { HikariConfig
	 * config=new HikariConfig("src\\in\\svec\\properties\\application.Properties");
	 * HikariDataSource datasource=new HikariDataSource(config); return
	 * datasource.getConnection(); }
	 */
	private  static SessionFactory sessionfactory=null;
	private static Session session=null;
	static
	{
		sessionfactory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	}
	public static Session getConnection()
	{
		if(session==null) session=sessionfactory.openSession();
		return session;
	}
	public static void getCloseSession(Session session)
	{
		if(session!=null) {
			session.close();
		}
	}
	public static void getCloseSessionFactroy()
	{
		if(sessionfactory!=null) {
			sessionfactory.close();
		}
	}
	public static void start()
	{
		System.out.println("Hibernate is started");
	}
}
