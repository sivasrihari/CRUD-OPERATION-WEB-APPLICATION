package in.ineuron.dao;

import in.ineuron.dto.Student;

public interface IStudentDao 
{
	public String addStudent(Student student);
	//resultSet ins unable to transfer over network so we need a student obj 
	//which bale to transfer over network
	public Student searchStudent(Integer sid);
	public String updateStudent(Student student);
	public String deleteStudent(Integer sid);
}
