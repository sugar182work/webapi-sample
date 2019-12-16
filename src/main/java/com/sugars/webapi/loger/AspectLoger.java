package com.sugars.webapi.loger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLoger {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
    @Before("within(com.sugars.webapi.web.*)")
    public void before(JoinPoint joinPoint) {
    	logger.debug("-- before "
                + joinPoint.getTarget().getClass() + "." 
                + joinPoint.getSignature().getName());
    	System.out.println("-- before "
                + joinPoint.getTarget().getClass() + "." 
                + joinPoint.getSignature().getName());   
    }
}
