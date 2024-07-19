package com.EmployeeManagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagement.Model.EmployeeModel;
import com.EmployeeManagement.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	//-----------------------Reload Landing page methods------------------------------
	@GetMapping("/")
	public String home(Model model) {

		//--------------Counting methods---------------
		model.addAttribute("countT", empService.getTotalCount());
		model.addAttribute("countM", empService.getMaleCount());
		model.addAttribute("countF", empService.getFemaleCount());
		model.addAttribute("countO", empService.getOtherCount());
		model.addAttribute("allemployees",empService.getAllEmployees());
		return "home";
	}
	
	//-----------------------navigation forward methods------------------------------
	
	@GetMapping("/forwardSearch")		
	  public String forwardSearch(Model model) {  
	  	 	model.addAttribute("employee", new EmployeeModel());
	         return "searchemp";
	     }
	
	//-----------------------Add employee methods------------------------------

	@GetMapping("/forwardAdd")		
	  public String forwardAddemployee(Model model) {  
	  	 	model.addAttribute("employee", new EmployeeModel());
	         return "addemployee";
	     }
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute EmployeeModel employee,Model model) {
		empService.saveEmployee(employee);
		return "redirect:/displayAll";
	}
	
	//-----------------------Employee List methods------------------------------
	
	@GetMapping("/displayAll")
	public String displayAllEmployee(Model model) {
		model.addAttribute("employees",empService.getAllEmployees());
		return "viewAll";
	}
	
	//-----------------------Employee Search methods------------------------------
	
	@GetMapping("/display/{id}")
	public String displayEmployeeById(@PathVariable(value="id") String id,Model model) {
		Optional<EmployeeModel> employee=empService.getEmployeeId(id);
		
			model.addAttribute("employee",employee.get());
			return "searchemp";
	}
	
	
	//-------------------------Editing methods-------------------------
	
	@GetMapping("/displayEdit")
	public String editEmployee(Model model) {
		model.addAttribute("employees",empService.getAllEmployees());
		return "viewAll";
	}
	
	@GetMapping("/showformforupdate/{id}")
	public String showformforupdate(@PathVariable(value="id") String id,Model model) {
		Optional<EmployeeModel> employee=empService.getEmployeeId(id);
		model.addAttribute("employees",employee);
		return "employee_update";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute EmployeeModel employee,Model model) {
		empService.saveEmployee(employee);
		return "redirect:/displayEdit";
	}
	
	
	//-------------------------delete methods-------------------------
	

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable String id) {
		empService.deleteEmployeeById(id);
        return "redirect:/displayAll";
    }
	
	
	
}
