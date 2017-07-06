package com.github.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.daos.EmpDao;
import com.github.dtos.EmpDto;

@Controller
public class EmpController {
	
	@Autowired private EmpDao empdao;
	
	@ModelAttribute("empdto")
	public EmpDto createuserModel() {
		return new EmpDto();
	}
	
	@Autowired
	@Qualifier("empFormValidator")
	private Validator empFormValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(empFormValidator);
	}// to add errors to BindException.

		
	@RequestMapping( value = "/list")
	public String listEmpl(@ModelAttribute("empdto") EmpDto empdto,BindingResult result, 
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
					throws UnknownHostException {
		System.out.println("listEmp");		
		List<EmpDto> empList = empdao.listEmpoyees();
		System.out.println(empList.size());
		model.addAttribute("emplist", empList);
		empdto.setEmpList(empList);
		
		String ip = request.getRemoteAddr();
		if (ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String ipAddress = inetAddress.getHostAddress();
			ip = ipAddress;
		}
		model.addAttribute("IP", ip);
		
		return "viewEmployees";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addEmpForm");
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("empdto") @Validated EmpDto empdto,BindingResult br) {
		ModelAndView mav = new ModelAndView();
		String returnVal = "redirectList";
		if (br.hasErrors()) {
			returnVal = "addEmpForm";
		} else {
			empdao.saveEmp(empdto);
		}
		mav.setViewName(returnVal);
		return mav;
	}

	@RequestMapping(value = "/deleteEmp", method = RequestMethod.GET)
	public String deleteContact(HttpServletRequest request) {
		int empId = Integer.parseInt(request.getParameter("id"));
		empdao.delete(empId);
		return "redirectList";
	}
	
	@RequestMapping(value = "/editemp", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int empid = Integer.parseInt(request.getParameter("id"));
		
		EmpDto empdto =  empdao.get(empid);
		ModelAndView model = new ModelAndView("editForm");
		model.addObject("empdto", empdto);
		
		return model;
	}
	
	@RequestMapping(value="/editemp", method=RequestMethod.POST)
	public ModelAndView editEmp(@ModelAttribute("empdto") @Validated EmpDto empdto,BindingResult br) {
		ModelAndView mav = new ModelAndView();
		String returnVal = "redirectList";
		if (br.hasErrors()) {
			returnVal = "editForm";
		} else {
			empdao.updateEmp(empdto);
		}
		mav.setViewName(returnVal);
		return mav;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(Model model) {
		 return "logout";
	}
}