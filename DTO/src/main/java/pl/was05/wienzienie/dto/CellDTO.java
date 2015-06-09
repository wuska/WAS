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
public class CellDTO {
    
    private Integer capacity;
    private Integer employeeId;

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    
    @Override
    public String toString() {
        return "CellDTO{" + "capactity=" + capacity + " employeeId=" + employeeId + "}";
    }
}
