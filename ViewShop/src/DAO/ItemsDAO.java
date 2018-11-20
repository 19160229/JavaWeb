package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Items;
import util.DBHelper;

public class ItemsDAO {
	// 获得所有的商品信息
	public ArrayList<Items> GetAllItems() {
		ArrayList<Items> allItems = new ArrayList<Items>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from items;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setPrice(rs.getDouble("price"));
				item.setNumber(rs.getInt("number"));
				item.setPicture(rs.getString("picture"));
				allItems.add(item);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}
			}
			if (conn != null) {
				try {
					conn = null;
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}
			}
		}
		return allItems;
	}
	
	//根据商品id获得商品信息
	public Items getItemsByID(int id) {
		Items items=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from items where id=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				items=new Items();
				items.setId(rs.getInt("id"));
				items.setName(rs.getString("name"));
				items.setCity(rs.getString("city"));
				items.setPrice(rs.getDouble("price"));
				items.setNumber(rs.getInt("number"));
				items.setPicture(rs.getString("picture"));	
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}
			}
			if (conn != null) {
				try {
					conn = null;
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}
			}
		}
		return items;
	}
	
	public ArrayList<Items> getViewList(String list){
		ArrayList<Items> itemList=new ArrayList<Items>();
		int iCount=5;
		if(list!=null&&list.length()>0) {
			String[] arr=list.split(",");
			if(arr.length>=5) {
				for(int i=arr.length-1;i>=arr.length-iCount;i--) {
					int id=Integer.parseInt(arr[i]);
					itemList.add(getItemsByID(id));
				}
			}
			else {
				for(int i=arr.length-1;i>=0;i--) {
					int id=Integer.parseInt(arr[i]);
					itemList.add(getItemsByID(id));
				}
			}
			return itemList;
		}
		else {
			return null;
		}
	}
}
