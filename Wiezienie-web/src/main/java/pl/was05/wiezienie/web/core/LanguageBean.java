/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.core;

/**
 *
 * @author zar
 */
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import pl.was05.wiezienie.web.admin.users.UserController;

@ManagedBean(name = "language")
@RequestScoped
public class LanguageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String localeCode;

    private static Map<String, Object> countries;

    static {
        countries = new LinkedHashMap<String, Object>();
        countries.put("PL", Locale.FRENCH);
        countries.put("English", Locale.ENGLISH); //label, value

    }

    public Map<String, Object> getCountriesInMap() {
        return countries;
    }

    public String getLocaleCode() {
        setLocaleCode(SessionUtil.getUserLang());
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        SessionUtil.setUserLang(localeCode);
        this.localeCode = localeCode;
    }

    public void countryLocaleCodeChanged(ValueChangeEvent e) {
        String newLocaleValue = e.getNewValue().toString();

        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if (entry.getValue().toString().equals(newLocaleValue)) {
                setLocaleCode(entry.getValue().toString());
                FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.forLanguageTag(entry.getValue().toString()));

            }
        }
    }

    public String logout() {
        HttpSession session = SessionUtil.getSession();
        session.invalidate();
        return "/index";
    }
    
    public String sessionId(){
        return SessionUtil.getSessionId();
    }
    public String getUser(){
         FacesContext context = FacesContext.getCurrentInstance();
       return  context.getExternalContext().getRemoteUser();
       
    }
}
