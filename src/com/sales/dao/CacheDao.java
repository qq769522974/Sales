package com.sales.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sales.model.Cache;

//��¼����
public class CacheDao extends BaseDao{
	    //��ӵ�¼����
		public boolean addCache(Cache cache){
			//CURRENT_TIMESTAMP=ʱ���,�Զ��������ݸ��ĵ�ʱ��
			String sql = "insert into cache values(CURRENT_TIMESTAMP,?,?,?,?,?)";
			try {
				java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, cache.getId());
				preparedStatement.setString(2, cache.getName());
				preparedStatement.setString(3, cache.getAddress());
				preparedStatement.setString(4, cache.getSex());
				preparedStatement.setString(5, cache.getPassword());
				if(preparedStatement.executeUpdate() > 0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		//��ȡ��¼����
		public Cache getCache(Cache cache) {
			String sql=" select * from cache LAST_INSERT_ID";//��ȡ����������һ������
			try {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				ResultSet executeQuery = preparedStatement.executeQuery();
				while(executeQuery.next()) {
					cache.setId(executeQuery.getString("id"));
					cache.setName(executeQuery.getString("name"));
					cache.setAddress(executeQuery.getString("address"));
					cache.setSex(executeQuery.getString("sex"));
					cache.setPassword(executeQuery.getString("password"));
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cache;
		}
}