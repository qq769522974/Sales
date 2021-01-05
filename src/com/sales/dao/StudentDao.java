package com.sales.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sales.model.Student;
import com.sales.util.StringUtil;

public class StudentDao extends BaseDao {
	//添加学生
	public boolean addStudent(Student student){
		String sql = "insert into student values(?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getStudentId());
			preparedStatement.setString(2, student.getStudentName());
			preparedStatement.setString(3, student.getStudentAddress());
			preparedStatement.setString(4, student.getSex());
			preparedStatement.setString(5, student.getStudentPass());
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//查，列出学生
	public List<Student> getStudentList(Student student){
		List<Student> retList = new ArrayList<Student>();
		StringBuffer sqlString = new StringBuffer("select * from student");
		if(!StringUtil.isEmpty(student.getStudentName())){
			sqlString.append(" and studentName like '%"+student.getStudentName()+"%'");
		}
		if(!StringUtil.isEmpty(student.getStudentId())){
			sqlString.append(" and studentId ="+student.getStudentId());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Student s = new Student();
				s.setStudentId(executeQuery.getString("studentId"));
				s.setStudentName(executeQuery.getString("studentName"));
				s.setStudentAddress(executeQuery.getString("studentAddress"));
				s.setSex(executeQuery.getString("sex"));
				s.setStudentPass(executeQuery.getString("studentPass"));
				retList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	//通过学生的id获取学生的信息
	public Student search(Student student,String id){
		String sqlString ="select * from student where studentId=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			preparedStatement.setString(1, id);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				student.setStudentId(executeQuery.getString("studentId"));
				student.setStudentName(executeQuery.getString("studentName"));
				student.setStudentAddress(executeQuery.getString("studentAddress"));
				student.setSex(executeQuery.getString("sex"));
				student.setStudentPass(executeQuery.getString("studentPass"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	
	//删除学生
	public boolean delete(String id){
		String sql = "delete from student where studentId=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//改(包括密码)
	public boolean update2(Student student){
		String sql = "update student set studentName=?,studentAddress=?,sex=?,studentPass=? where studentId=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getStudentName());
			preparedStatement.setString(2, student.getStudentAddress());
			preparedStatement.setString(3, student.getSex());
			preparedStatement.setString(4, student.getStudentPass());
			preparedStatement.setString(5, student.getStudentId());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//改(不包括密码)
		public boolean update1(Student student){
			String sql = "update student set studentName=?,studentAddress=?,sex=? where studentId=?";
			try {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, student.getStudentName());
				preparedStatement.setString(2, student.getStudentAddress());
				preparedStatement.setString(3, student.getSex());
				preparedStatement.setString(4, student.getStudentId());
				if(preparedStatement.executeUpdate() > 0){
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	//学生登录
	public Student login(Student student){
		String sql = "select * from student where studentId=? and studentPass=?";
		Student studentRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, student.getStudentId());
			prst.setString(2, student.getStudentPass());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				studentRst = new Student();
				studentRst.setStudentId(executeQuery.getString("studentId"));
				studentRst.setStudentName(executeQuery.getString("studentName"));
				studentRst.setStudentAddress(executeQuery.getString("studentAddress"));
				studentRst.setStudentPass(executeQuery.getString("studentPass"));
				studentRst.setSex(executeQuery.getString("sex"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentRst;
	}
}
