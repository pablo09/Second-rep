/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.interceptors;


import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;

import javax.interceptor.InvocationContext;

/**
 *
 * @author Pawel
 */
@Login
@Interceptor
public class  LoginInterceptor {
    @AroundInvoke
    public Object test(InvocationContext ctx) throws Exception {
        System.out.println("Test0, method : "+ctx.getMethod().getName());
        Object result = ctx.proceed();
        
        System.out.println("Test1, target : "+ctx.getTarget().toString());
        return result;
    }
}
