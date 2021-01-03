package com.sales.dao;

import com.sales.model.Manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDao extends BaseDao {
	//管理员登录
	public Manager login(Manager manager){
		String sql = "select * from manager where managerId=? and managerPass=?";
		Manager managerRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, manager.getManagerId());
			prst.setString(2, manager.getManagerPass());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				managerRst = new Manager();
				managerRst.setManagerId(executeQuery.getString("managerId"));
				managerRst.setManagerName(executeQuery.getString("managerName"));
				managerRst.setManagerPass(executeQuery.getString("managerPass"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return managerRst;
	}
}
