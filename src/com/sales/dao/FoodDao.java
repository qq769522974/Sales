package com.sales.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sales.model.Food;
import com.sales.util.StringUtil;

public class FoodDao extends BaseDao {
	//添加菜品
	public boolean addFood(Food food){
		//CURRENT_TIMESTAMP=时间戳，在数据库中自动添加菜品创建的时间和修改的
		String sql = "insert into food values(?,?,?,0,CURRENT_TIMESTAMP)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, food.getFoodId());
			preparedStatement.setString(2, food.getFoodName());
			preparedStatement.setString(3, food.getPrice());
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//查询，列出菜品
	public List<Food> getFoodList(Food food){
		List<Food> retList = new ArrayList<Food>();
		StringBuffer sqlString = new StringBuffer("select * from food");
		if(!StringUtil.isEmpty(food.getFoodName())){
			sqlString.append(" and foodName like '%"+food.getFoodName()+"%'");
		}
		if(!StringUtil.isEmpty(food.getFoodId())){
			sqlString.append(" and studentId ="+food.getFoodId());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Food s = new Food();
				s.setFoodId(executeQuery.getString("foodId"));
				s.setFoodName(executeQuery.getString("foodName"));
				s.setPrice(executeQuery.getString("price"));
				s.setNumber(executeQuery.getInt("number"));
				s.setCreateTime(executeQuery.getString("createTime"));
				retList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	//删除菜品
	public boolean delete(int id){
		String sql = "delete from food where FoodId=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//修改菜品
	public boolean update(Food food){
		String sql = "update food set foodName=?, price=? where foodId=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, food.getFoodName());
			preparedStatement.setString(2, food.getPrice());
			preparedStatement.setString(3, food.getFoodId());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//菜品下单，下单数+1
	public boolean buy(int id) {
		String sql="update food set number = number + 1 where foodId=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}


