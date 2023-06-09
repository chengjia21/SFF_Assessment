package vttp2023.batch3.ssf.frontcontroller.services;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpMethod;
import java.net.URI;

import jakarta.json.JsonObject;
import vttp2023.batch3.ssf.frontcontroller.model.UserLogin;
import vttp2023.batch3.ssf.frontcontroller.respositories.AuthenticationRepository;


@Service
public class AuthenticationService {


	// To save data on Redis
	// @Autowired
    // private AuthenticationRepository authRepo;


	// public UserLogin save(UserLogin u){
    //     UserLogin data = new UserLogin();
	// 	data = u.create();
      
    //     // repository.save(data);
    //     return data;
    // }


	// TODO: Task 2
	// DO NOT CHANGE THE METHOD'S SIGNATURE
	// Write the authentication method in here
	public void authenticate(String username, String password) throws Exception {

		// https://authservice-production-e8b2.up.railway.app/api/authenticate

		
        String authURL = "https://authservice-production-e8b2.up.railway.app";
		String authURL2 = UriComponentsBuilder
							.fromUriString(authURL)
							.path("/api")
							.path("/authenticate")
							.toUriString();

							UserLogin user = new UserLogin();
							JsonObject json = user.toJSON();
							RequestEntity<String> req = RequestEntity
															.post(authURL2)
															.contentType(MediaType.APPLICATION_JSON)
															// .headers("Accept", MediaType.APPLICATION_JSON)
															.body(json.toString(), String.class);
															
							RestTemplate template= new RestTemplate();
							ResponseEntity<String> r  = template.getForEntity(authURL2, String.class);
							user.setResponse(r);
							user.setIsAuthenticated(true);
							
	}
	
	


	// TODO: Task 3
	// DO NOT CHANGE THE METHOD'S SIGNATURE
	// Write an implementation to disable a user account for 30 mins
	public void disableUser(String username) {
	}

	// TODO: Task 5
	// DO NOT CHANGE THE METHOD'S SIGNATURE
	// Write an implementation to check if a given user's login has been disabled
	public boolean isLocked(String username) {
		return false;
	}
}
