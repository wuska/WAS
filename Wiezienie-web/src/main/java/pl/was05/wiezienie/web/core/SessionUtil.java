/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.core;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zar
 */
@Dependent
@Named
public class SessionUtil {

    /**
     * Creates a new instance of SessionBeen
     */
    public SessionUtil() {

    }
    private static String defLanf = Locale.FRANCE.toString();

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.
                getCurrentInstance().
                getExternalContext().
                getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.
                getCurrentInstance().
                getExternalContext().getRequest();
    }

    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return session.getAttribute("username").toString();
    }

    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("userid");
        } else {
            return null;
        }
    }

    public static String getSessionId() {
        HttpSession session = getSession();
        if (session != null) {
            return session.getId();
        } else {
            return null;
        }
    }

    public static String getSha256(String pass) throws Exception {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String text = pass;
            md.update(text.getBytes("UTF-8"));
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            String output = bigInt.toString(16);

            System.out.println(output);
            return output;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(SessionUtil.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Nie udało się zaszyfrować hasła!!!");
        }

    }

    public static void setUserLang(String lang) {
        if (lang != null) {
            System.err.printf("setLocale: lang: " + lang + " Locale->" + Locale.forLanguageTag(lang));
            FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.forLanguageTag(lang));
        }
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("userLang", lang);
    }

    public static String getUserLang() {

        try {
            String lang = "";
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            lang = session.getAttribute("userLang").toString();
setUserLang(lang);
return lang;
        } catch (NullPointerException ex) {
            System.err.printf("ex: Locale:" + FacesContext.getCurrentInstance().getViewRoot().getLocale().toString());
            setUserLang(FacesContext.getCurrentInstance().getViewRoot().getLocale().toString());
            return FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
        }
    }

}
