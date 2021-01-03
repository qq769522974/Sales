package com.sales.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sales.model.Canteen;
//ʳ�ð��̵�¼
public class CanteenDao extends BaseDao {
	
	public Canteen login(Canteen manager){
		String sql = "select * from canteen where canteenId=? and password=?";
		Canteen canteenRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//��sql��䴫�����ݿ��������
			prst.setString(1, manager.getCanteenId());
			prst.setString(2, manager.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				canteenRst = new Canteen();
				canteenRst.setCanteenId(executeQuery.getString("canteenId"));
				canteenRst.setCanteenName(executeQuery.getString("canteenName"));
				canteenRst.setPassword(executeQuery.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return canteenRst;
	}
}
