package day19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class Ex01_DBClass {
	private String url;
	private String id;
	private String pwd;
	private Connection con;
	
	public Ex01_DBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url="jdbc:oracle:thin:@localhost:1521:xe";
			id="system";
			pwd="oracle1185";
			con =DriverManager.getConnection(url,id,pwd);
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Ex01_Dto> getUsers(){
			ArrayList<Ex01_Dto> list =new ArrayList<Ex01_Dto>();
			String sql = "select * from newst";
	
			try {
				PreparedStatement ps=con.prepareStatement(sql);	
				ResultSet rs =ps.executeQuery();
				while(rs.next()) {
					Ex01_Dto dto =new Ex01_Dto();
					dto.setStNum(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setAge(rs.getInt("age"));
					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	}
	public int saveData(String stNum, String name, int age) {
		String sql="insert into newst values('"+stNum+"','"+name+"',"+age+")";
		int result=0; 
		try {
			PreparedStatement ps=con.prepareStatement(sql);	
			//ResultSet rs =ps.executeQuery();
			result =ps.executeUpdate();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	
		return result;
	}
	public int saveData02(String stNum, String name, int age) {
		String sql="insert into newst values(?,?,?)";
		int result=0; 
		try {
			PreparedStatement ps=con.prepareStatement(sql);	
			ps.setString(1, stNum);
			ps.setString(2, name);
			ps.setInt(3, age);
			result =ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return result;
	}
	public int delete(String userNum) {
		int result=0;
		String sql ="delete from newst where id= ?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);	
			ps.setString(1, userNum);
			result =ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return result;
	}
	public int modify(String stNum,String name,int age) {
		int result =0;
		String sql= "update newst set name=?, age=? where id= ?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);	
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, stNum);
			result =ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return result;
	}
	
}













