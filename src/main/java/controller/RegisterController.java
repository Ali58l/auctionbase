package controller;

import java.sql.Timestamp;

import model.bl.GeneralLogic;
import model.dao.LoginForm;
import model.dao.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import service.PersonService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	 
	 @Autowired private PersonService personSvc;
	  /**
	   * Requests to http://localhost:8080/hello will be mapped here.
	   * Everytime invoked, we pass list of all persons to view
	   */
	  @RequestMapping( method = RequestMethod.GET)
	   public String Bid(Model model) {
		  model.addAttribute("person", new Person());
		  
	      return ("/page/register");
	   }
	  
	  @RequestMapping(value = "/add", method = RequestMethod.POST)
	   public String addUser(@ModelAttribute ("person")	Person person,
			   @ModelAttribute ("loginForm") LoginForm loginForm
			   , Model model ,BindingResult result, SessionStatus status) {
		  model.addAttribute("person", person);
		  //	      model.addAttribute("name", person.getName());
//	      model.addAttribute("username",person.getUsername());
//	      model.addAttribute("password", person.getPassword());
//	      model.addAttribute("email", person.getEmail());
	      person.setActive(true);
	      Timestamp ts = GeneralLogic.addTimeStamo();
	      person.setUpdateDate(ts);
	      person.setCreationDate(ts);
	    
	      personSvc.add(person);
	      GeneralLogic gLogic = new GeneralLogic();
	    //  gLogic.sendEmail("Auction Registration", "Welcome To Big Auction/Bid"); 
	      model.addAttribute("loginForm", loginForm);
	      //return "redirect:/";
	      return "/page/login";
	   }

}
	
