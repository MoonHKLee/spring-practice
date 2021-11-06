package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAuthPointcut {

    @Pointcut("execution(* com.example.demo.*Controller.*(..))")
    public void loginauth() {
    }

    @Before("loginauth()")
    public void commonAuth(JoinPoint joinPoint) {
        Object[] obj = joinPoint.getArgs();
        HttpServletRequest request = (HttpServletRequest)obj[0];
        String userId = request.getHeader("X-USER-ID");
        if (userId==null) {
            throw new NoUserIdException();
        }

    }
}
