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
public class CategoriesConroller {

	@Autowired
	CategoryDAO dao;

	@RequestMapping("/empform")
	public String showCategoryform(Model m) {
		m.addAttribute("command", new Category());
		return "addCategory";
	}

	@RequestMapping(value = "/save_Category", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("Cat") Category cat) {
		dao.saveCategory(cat);
		return "redirect:/categorylist";
	}

	@RequestMapping("/categorylist")
	public String showListOfCategories(Model m) {
		List<Category> list = dao.getCategories();
		m.addAttribute("list", list);
		return "listCategories";
	}

	@RequestMapping(value = "/editcat/{id}")
	public String edit(@PathVariable int id, Model m) {
		Category cat = dao.getCategoryById(id);
		m.addAttribute("command", cat);
		return "editCategory";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("cat") Category cat) {
		dao.updateCategory(cat);
		return "redirect:/categorylist";
	}

	@RequestMapping(value = "/deletecat/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		dao.deleteCategory(id);
		return "redirect:/categorylist";
	}
	
}
