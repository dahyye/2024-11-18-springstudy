package com.sist.dao;

import java.util.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.sql.*;
import com.sist.vo.*;

@Repository
//@Scope("prototype") //부를때마다 객체 생성?
//spring은 디폴트가 싱글톤이야
public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public BoardDAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
