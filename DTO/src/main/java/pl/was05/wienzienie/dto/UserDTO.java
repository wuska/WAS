/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wienzienie.dto;

/**
 *
 * @author Dawid
 */
public class UserDTO {

    private String login;
    private String pass;
    private String email;
    private boolean active = false;
    
    private Long groupId;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass)  {
  
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

   

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    
    @Override
    public String toString() {
        return "UserDTO{" + "login=" + login + " pass=" + pass + " email=" + email + "}";
    }

}
