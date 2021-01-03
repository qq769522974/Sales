package com.sales.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sales.model.Food;
import com.sales.util.StringUtil;

public class FoodDao extends BaseDao {
	//添加菜品
	public boolean addFood(Food food){
		String sql = "insert into food values(?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, food.getFoodId());
			preparedStatement.setString(2, food.getFoodName());
			preparedStatement.setDouble(3, food.getPrice());
			preparedStatement.setInt(4, food.getNumber());
			preparedStatement.setString(5, food.getCreateTime());
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//查询
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
				s.setPrice(executeQuery.getDouble("price"));
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
		String sql = "delete from food where studentId=?";
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
		String sql = "update food set foodName=?, price=?,sex=?,number=? where foodId=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, food.getFoodId());
			preparedStatement.setString(2, food.getFoodName());
			preparedStatement.setDouble(3, food.getPrice());
			preparedStatement.setInt(4, food.getNumber());
			preparedStatement.setString(5, food.getCreateTime());
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
