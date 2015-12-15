package com.dao;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Order;
import com.service.Orderervice;
public class OrderJDBCTemplate implements OrderDAO {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject; 
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }
   public void create(String name, Integer age) {
      String SQL = "insert into Student (name, age) values (?, ?)";     
      jdbcTemplateObject.update( SQL, name, age);
      System.out.println("Created Record Name = " + name + " Age = " + age);
      return;
   }
   public List<Map<String, Object>> getOrder(String orderid) {
      String SQL = "SELECT pyid.gc_code AS gc_code, pyinfo.pyo_order_id AS orderid, g.orderid AS orderid_cyber_cash,"+" "+
		"pyinfo.card_type AS num, pyinfo.gcid AS gcid, pyid.pin AS pin, pyid.retailer AS company, pyid.status AS status,"+" "+
		"pyid.deleted AS deleted, pyinfo.credit_card_used AS ccused,"+"\n"+
		"CAST(pyinfo.denomination AS INTEGER) AS denomination, pyinfo.gcid_prefix AS prefix, pyinfo.issuedate AS issuedate,"+" "+
		"pyinfo.gc_code_issuemail AS email, g.actfirstname AS fname, g.actlastname AS lname, g.actemail AS gemail"+" "+
		"FROM pyo_silo_info pyinfo JOIN"+" "+
		"pyo_silo_id pyid"+" "+
		"ON pyinfo.gc_code=pyid.gc_code"+" "+
		"JOIN gc g ON"+" "+
		"g.gcid=pyinfo.gcid"+" "+
		"WHERE pyinfo.pyo_order_id = ?";
      List<Map<String, Object>> orders  = jdbcTemplateObject.queryForList(SQL, 
                        new Object[]{orderid});
      return orders;
   }
		
   public void setOrder(String gcid,String email) {
	   String sql = "update pyo_silo_info " +
               "set gc_code_issuemail = ? "+
			   "where gcid =?";
	   jdbcTemplateObject.update(sql, new Object[] {email,gcid});
			
		}
   
}