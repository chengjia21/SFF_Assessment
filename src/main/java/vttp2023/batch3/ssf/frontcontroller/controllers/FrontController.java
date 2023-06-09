package vttp2023.batch3.ssf.frontcontroller.controllers;

import java.rmi.ServerException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.JsonObject;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vttp2023.batch3.ssf.frontcontroller.model.UserLogin;
import vttp2023.batch3.ssf.frontcontroller.services.AuthenticationService;


@Controller
@RequestMapping(consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public class FrontController {

	// TODO: Task 2, Task 3, Task 4, Task 6


	@Autowired AuthenticationService authSvc;

    // public String index() {
    //     return "view0";}

	

	@GetMapping(path="/getuser")
	public String login1(Model m, @Valid UserLogin username, BindingResult result, HttpSession session){

		UserLogin user1 = new UserLogin();
		if(result.hasErrors()){
					m.addAttribute("error", result);
			
					return "test";
				}

	//HTTP session to capture number of login attempts
		Integer attempts = 0;
		UserLogin userSession = (UserLogin)session.getAttribute("UserLogin");
        if(null == userSession){
            userSession = new UserLogin();
            session.setAttribute("user1", userSession);}
			attempts++;
		if(attempts > 3){
			return "view2";
		}

		m.addAttribute("user1", user1.getUsername());
		m.addAttribute("user1", user1.getPassword());
		
		if(user1.getIsAuthenticated() == true){
			return "view1";
		}
	
		return "view0";
}



@PostMapping("/login" )
	public String postUser(Model m, @Valid UserLogin userlogin, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "index";

		}
		AuthenticationService authSvc = new AuthenticationService();



		return "view1";
	}


}



// @RequestBody MultiValueMap<String, String> form, 
	// @PostMapping(path = "users", 
    //     consumes = MediaType.APPLICATION_JSON_VALUE, 
    //     produces = MediaType.APPLICATION_JSON_VALUE)
	// 	public 
	// 	public ResponseEntity<User> create(@RequestBody User newUser) {

	// 		User user = AuthenticationService.save(newUser);
	// 		if (user == null) {
	// 			throw new ServerException();
	// 		} else {
	// 			return new ResponseEntity<>(user, HttpStatus.CREATED);
	// 		}
	// 	}

	//HTTP session to capture number of login attempts
	// @PostMapping(path="/authenticate")
    // public String login(Model m, @Valid UserLogin username, BindingResult result, HttpSession session) {

		
	

    //     if(result.hasErrors()){
	// 		m.addAttribute("error", result);
	
    //         return "index";
    //     }

	// 	//later change to return view 1 or view 2
	// 	return "index";






    

	
	

