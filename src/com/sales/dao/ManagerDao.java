package com.sales.dao;

import com.sales.model.Manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDao extends BaseDao {
	//����Ա��¼
	public Manager login(Manager manager){
		String sql = "select * from manager where managerId=? and managerPass=?";
		Manager managerRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//��sql��䴫�����ݿ��������
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
