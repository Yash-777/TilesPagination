package com.github.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.daos.LoginRegisterDao;
import com.github.dtos.NewUser;

@Controller
@RequestMapping(value="/regestrationForm.form")
public class RegestrationControler {
	
	@Autowired
	private LoginRegisterDao loginDao;
	
	@Autowired
	@Qualifier("regitrationValidator")
	private Validator regitrationValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(regitrationValidator);
	}// to add errors to BindException.
	
	@RequestMapping( method = RequestMethod.GET )
	public ModelAndView inputFrom( Model model ){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("regestrationForm");
		model.addAttribute("newuserdto", new NewUser());
		return mav;
	}
	
	@RequestMapping( method = RequestMethod.POST )
	public ModelAndView outForm( @ModelAttribute("newuserdto") @Validated NewUser newUser,
			BindingResult br, Model model ) {
		ModelAndView mav = new ModelAndView();
		String returnVal = "regestrationSuccessForm";
		if (br.hasErrors()) {
			returnVal = "regestrationForm";
		} else {
			model.addAttribute("newuserdto", newUser);
			loginDao.registerNewUser(newUser);
		}
		mav.setViewName(returnVal);
		return mav;
	}
}