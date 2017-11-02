package com.example.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/hive")
@Log
public class HiveController {

   @GetMapping("/yeardelay")
   public String yeardelay(Model model) throws ClassNotFoundException, SQLException {
      log.info("/hive/yeardelay...");

      // HIVE 작업 수행
      Class.forName("org.apache.hive.jdbc.HiveDriver");
		Connection conn = DriverManager.getConnection("jdbc:hive2://localhost:10000","","");
		Statement stmt = conn.createStatement();
		System.out.println(conn);
		
		ResultSet rs = stmt.executeQuery("select * from year_delay");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + ", " + rs.getInt(2) + ", " + rs.getInt(3) + ", " + rs.getFloat(4));
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
      return "jsp/hive/yeardelay";
   }

   
   
}