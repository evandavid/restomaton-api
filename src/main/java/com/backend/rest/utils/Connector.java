package com.backend.rest.utils;

//import java.nio.file.Paths;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;

import org.javalite.activejdbc.Base;

public class Connector {
//	private String working_dir;
//	private String database;
//	private Connection conn = null;
	
	public Connector(){
//		this.working_dir = System.getProperty("user.dir");
//		this.database = "DONOTREMOVE_2";
	}
	
	public void doConnect() throws SQLException{
//		String full_path = String.valueOf(Paths.get(this.working_dir, this.database));
//		
//		try {
//			Class.forName("org.hsqldb.jdbcDriver");
//			conn = DriverManager.getConnection("jdbc:hsqldb:file:" + full_path, "sa", "");
//		} catch (ClassNotFoundException | SQLException e) {
//			System.out.println("Error :"+e.toString());
//		}
//		
//		String sql = "";
//		
//		Statement statement = conn.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
		
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/OnlineShop_development", "root", "root");
	}
}
