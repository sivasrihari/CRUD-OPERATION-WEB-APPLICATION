package in.ineuron.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.servicefactory.StudentServiceFactory;
import in.ineuron.service.IStudentService;
import in.ineuron.dto.Student;
import in.ineuron.jdbcUtil.*;



@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doProcess(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doProcess(request, response);
	}
	
	@SuppressWarnings("unused")
	public void doProcess(HttpServletRequest request, HttpServletResponse response) 
	{
		JDBCUtil.start();
		System.out.println("request uri is::"+request.getRequestURI());
		System.out.println("request path info ::"+request.getPathInfo());
		PrintWriter out=null;
		response.setContentType("text/html");
		try {
			out=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		IStudentService ISS=StudentServiceFactory.getStudentService();
		if(request.getRequestURI().endsWith("addform"))
		{
			String name=request.getParameter("sname");
			String age=request.getParameter("sage");
			String address=request.getParameter("saddr");
			Student stu=new Student();
			System.out.println(stu);
			stu.setSname(name);
			stu.setSage(Integer.parseInt(age));
			stu.setSaddress(address);
			String msg=ISS.addStudent(stu);
			System.out.println(msg);
			RequestDispatcher rd=null;
			rd=request.getRequestDispatcher("../dispAdd.jsp");
			request .setAttribute("msg",msg);
				
				try {
					rd.forward(request,response);
				} catch (ServletException | IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		if(request.getRequestURI().endsWith("searchform"))
		{
			String id=request.getParameter("sid");
			Student student=ISS.searchStudent(Integer.parseInt(id));
			RequestDispatcher rd=null;
			rd=request.getRequestDispatcher("../searchDisplay.jsp");
			request.setAttribute("student",student);
				try {
					rd.forward(request, response);
				} 
				catch (ServletException | IOException e) 
					{
					// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
		if(request.getRequestURI().endsWith("deleteform"))
		{
			String id=request.getParameter("sid");
			String msg=ISS.deleteStudent(Integer.parseInt(id));
			System.out.println("delete="+msg);
			RequestDispatcher rd=null;
			rd =request.getRequestDispatcher("../deleteDisplay.jsp");
			request.setAttribute("msg",msg);
			try {
				rd.forward(request,response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getRequestURI().endsWith("updateform"))
		{
			RequestDispatcher rd=null;
			System.out.println(request.getRequestURI());
			String id=request.getParameter("sid");
			Student stu=null;
			stu=ISS.searchStudent(Integer.parseInt(id));
			System.out.println(stu);
			if(stu!=null)
			{
				System.out.println("updating student id is ="+stu.getSid());
				request.setAttribute("student",stu);
				System.out.println("going to update form .jsp");
				rd=request.getRequestDispatcher("../updateForm.jsp");
				try {
					rd.forward(request,response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				out.println("<body>");
				out.println("<h1 style='color:red;ext-align;center'>NO record to display student with given id="+id+"</h1>");
				out.println("</body>");			
			}
		}
		if(request.getRequestURI().endsWith("updaterecord"))
		{
			RequestDispatcher rd=null;
			Student newStu=new Student();
			String id=request.getParameter("SID");
			System.out.println(id);
			String age=request.getParameter("SAGE");
			String name=request.getParameter("SNAME");
			String address=request.getParameter("SADDRESS");
			newStu.setSid(Integer.parseInt(id));
			newStu.setSname(name);
			newStu.setSage(Integer.parseInt(age));
			newStu.setSaddress(address);
			
		
			String msg=ISS.updateStudent(newStu);
			if(msg.equalsIgnoreCase("success"))
			{	
				System.out.println(request.getRequestURI());
				rd=request.getRequestDispatcher("../updateSuccess.html");
				try {
					System.out.println("it is updated");
					rd.forward(request,response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();}
				
			}
			else
			{
				rd=request.getRequestDispatcher("../updatefailed.html");
				try {
					rd.forward(request,response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();}
			}
		}
		
	}
}
