/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wienzienie.dto;

/**
 *
 * @author Kawa
 */
public class PenaltyDTO {
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString() {
        return "PenlatyDTO{" + "name=" + name + "}";
    }
}
