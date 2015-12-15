package com.dao;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.model.Order;
public interface OrderDAO {
   /** 
    * This is the method to be used to initialize
    * database resources ie. connection.
    */
   public void setDataSource(DataSource ds);
   /** 
    * This is the method to be used to create
    * a record in the Student table.
    */
   public List<Map<String, Object>> getOrder(String id);
   /** 
    * This is the method to be used to list down
    * all the records from the Student table.
    */
   public void setOrder(String id,String email);
   /** 
    * This is the method to be used to list down
    * all the records from the Student table.
    */
}