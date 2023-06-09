package vttp2023.batch3.ssf.frontcontroller.model;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserLogin implements Serializable {
    
    private Boolean isAuthenticated;

    @NotNull(message="Please state your username")
    @Size(min=2, message="Username must be at least 2 characters in length")
    @NotBlank(message="Please state your username")
    private String username;
    private String password;
    private ResponseEntity<String> response;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

      public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  

    public Boolean getIsAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(Boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public void setResponse(ResponseEntity<String> response){
        this.response = response;
    }
  
    
    public UserLogin create(){
        UserLogin u = new UserLogin();
        u.getUsername();
        u.getPassword();
        return u;
    }
  
    public JsonObject toJSON(){
        return Json.createObjectBuilder()
                .add("username", this.getUsername())
                .add("password", this.getPassword())
                .build();
    }

}
