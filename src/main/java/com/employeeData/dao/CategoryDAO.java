package com.employeeData.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.employeData.Category;
import com.employeData.Task;

import java.util.List;
import com.mysql.cj.protocol.Resultset;

public class CategoryDAO {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	
	public int saveCategory(Category cat){    
	    String sql="insert into categories(category_name) values('"+cat.getCategory_name()+"')";    
	    return template.update(sql);    
	}

	public List<Category> getCategories(){    
	    return template.query("select * from categories",new RowMapper<Category>(){    
	        public Category mapRow(ResultSet rs, int row) throws SQLException {    
	        	Category cat=new Category();    
	        	cat.setCategory_id(rs.getInt(1));    
	        	cat.setCategory_name(rs.getString(2));        
	            return cat;    
	        }    
	    });    
	}   
	
	public Category getCategoryById(int id){    
	    String sql="select * from categories where category_id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Category>(Category.class));    
	}  
	
	public int updateCategory(Category cat){    
	    String sql="update categories set category_name='"+cat.getCategory_name()+"' where category_id="+cat.getCategory_id()+"";    
	    return template.update(sql);    
	}

	public int deleteCategory(int id) {
		// TODO Auto-generated method stub
		
		String sql="delete from categories where category_id="+id+"";    
		return template.update(sql); 
	}

	public List<Task> getTasks(int cat_id){    
	    return template.query("select * from tasks where category_id="+cat_id+"",new RowMapper<Task>(){    
	        public Task mapRow(ResultSet rs, int row) throws SQLException {    
	        	Task task=new Task();    
	        	task.setTask_id(rs.getInt(1));
	        	task.setTask_name(rs.getString(2));
	        	task.setCategory_id(rs.getInt(3));
	        	task.setTask_description(rs.getString(4));     
	            return task;    
	        }    
	    });    
	} 
	
	public int saveTask(Task task){    
	    String sql="insert into tasks(task_name,category_id,task_description) values('"+task.getTask_name() +"','"+ task.getCategory_id() +"','"+ task.getTask_description() +"')";    
	    return template.update(sql);    
	}
	
	public Task getTaskById(int id){    
	    String sql="select * from tasks where task_id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Task>(Task.class));    
	}  
	
	public int updateTask(Task task){    
	    String sql="update tasks set task_name='"+task.getTask_name() +"', task_description='"+ task.getTask_description() +"' where task_id="+task.getTask_id()+"";    
	    return template.update(sql);    
	}
	
	public int deleteTask(int id) {
		// TODO Auto-generated method stub
		
		String sql="delete from tasks where task_id="+id+"";    
		return template.update(sql); 
	}
	
	public Task getTaskByTaskId(int id){    
	    String sql="select * from tasks where task_id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Task>(Task.class));    
	} 
	
}
