/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.inter;

import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author zar
 */
public class LoggerInterceptor {
    private static final Logger LOG = Logger.getLogger(LoggerInterceptor.class.getName());
    
    @Resource
    private SessionContext sctx;
    
    @AroundInvoke
    public Object traceCall(InvocationContext ictx) throws Exception {
        LOG.info("Metoda: " + ictx.getTarget() + 
                "." + ictx.getMethod().getName() +
                " wykonana dla: " + sctx.getCallerPrincipal().getName());
        return ictx.proceed();
    }
    
}
