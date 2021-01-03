package com.sales.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//数据库连接类
public class DbUtil {
	String dbUrl="jdbc:mysql://localhost:3306/sales?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
	String dbUserName="root";//用户名
	String dbPassword="123456";//密码
	private String jdbcName="com.mysql.cj.jdbc.Driver"; // 驱动名称
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon(){
		try {
			Class.forName(jdbcName);//加载驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);//获取数据库,connection代表数据库
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}
