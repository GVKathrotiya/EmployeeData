package com.employeeData.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employeData.Category;
import com.employeData.Task;
import com.employeeData.dao.CategoryDAO;

@Controller
public class TaskController {

	@Autowired
	CategoryDAO dao;
	

	@RequestMapping("/view_tasks/{id}/{category_name}")
	public String showListOfTasks(Model m,@PathVariable int id,@PathVariable String category_name) {
		List<Task>list = dao.getTasks(id);
		m.addAttribute("list", list);
		m.addAttribute("cat_name", category_name);
		m.addAttribute("category_id", id);
		return "listTasks";
	}
	
	@RequestMapping("/addTaskform/{id}")
	public String showTaskform(Model m,@PathVariable String id) {
		m.addAttribute("command", new Task());
		m.addAttribute("category_id", id);
		return "addTask";
	}
	
	@RequestMapping(value = "/saveTask", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("Task") Task task) {
		dao.saveTask(task);
		String category_name = dao.getCategoryById(task.getCategory_id()).getCategory_name();
		return "redirect:/view_tasks/"+task.getCategory_id()+"/"+category_name;
	}
	
	@RequestMapping(value = "/editTask/{id}")
	public String edit(@PathVariable int id, Model m) {
		Task task = dao.getTaskById(id);
		m.addAttribute("command", task);
		return "editTask";
	}
	
	@RequestMapping(value = "/saveEditTask", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("task") Task task) {
		dao.updateTask(task);
		String category_name = dao.getCategoryById(task.getCategory_id()).getCategory_name();
		return "redirect:/view_tasks/"+task.getCategory_id()+"/"+category_name;
	}
	@RequestMapping(value = "/deleteTask/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		
		Task task = dao.getTaskByTaskId(id);
		String category_name = dao.getCategoryById(task.getCategory_id()).getCategory_name();
		int category_id = task.getCategory_id();
		System.out.println(".......catid ..." +category_id+"cat name " +category_name);
		dao.deleteTask(id);
		return "redirect:/view_tasks/"+category_id+"/"+category_name;
	}
}
