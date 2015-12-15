package com.service;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.Order;
public class Orderervice implements RowMapper<Order> {
   public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Order order = new Order();
	   order.setIssueDate(rs.getString("issuedate"));
	   order.setOrderid(rs.getString("orderid"));
	   order.setEmail(rs.getString("email"));
	   order.setCompanyName(rs.getString("company"));
	   order.setDenomination(rs.getString("Denomination"));
	   order.setGcid(rs.getString("gcid"));
      return order;
   }
}