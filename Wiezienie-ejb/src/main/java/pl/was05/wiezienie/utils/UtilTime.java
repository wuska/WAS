/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import pl.was05.wiezienie.user.UserEndpoint;

/**
 *
 * @author zar
 */
public class UtilTime {
    public static void sllep(long second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(UserEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
