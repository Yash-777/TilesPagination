
package com.github.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.daos.LoginRegisterDao;
import com.github.dtos.LoginDto;

@Controller
@RequestMapping(value = "/login.form")
public class LoginControler {
	
	@Autowired
	private LoginRegisterDao loginDao;
	
	@ModelAttribute("loginDto")
	public LoginDto createuserModel() {
		// ModelAttribute value should be used in the _______.jsp to get data to display.
		return new LoginDto();
	}
	
	@Autowired
	@Qualifier("loginFormValidator") // configured in XML with this id.
	private Validator loginFormValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(loginFormValidator);
	}// to add errors to BindException.
	
	@RequestMapping( method = RequestMethod.GET )
	public ModelAndView inputFrom( Model model ){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	
	@RequestMapping( method = RequestMethod.POST )
	public ModelAndView outForm( @ModelAttribute("loginDto") @Validated LoginDto loginDto,
			BindingResult br, Model model, HttpServletRequest req, HttpServletResponse resp ) {
		
		ModelAndView mav = new ModelAndView();
		String returnVal = "redirectList";
		/*HttpSession session = null;*/
		if (br.hasErrors()) {
			returnVal = "loginForm";
		} else {
			/*model.addAttribute("loginDto", loginDto);*/
			System.out.println(loginDao);
			boolean isTrue = loginDao.loginChectk(loginDto);
			if (!(isTrue)) {
				ValidationUtils.rejectIfEmpty(br, "password", "Email or password may wrong.");
				returnVal = "loginForm";
			} else {
				System.out.println(loginDto.getUserName());
				model.addAttribute("loginDto", loginDto);
				HttpSession session = req.getSession();
				session.setAttribute("userName", loginDto.getUserName());
				// return "redirect:/list.form"; To redirect to the controller
			}
		}
		mav.setViewName(returnVal);
		return mav;
	}
}