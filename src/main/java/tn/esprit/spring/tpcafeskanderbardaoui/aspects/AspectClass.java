package tn.esprit.spring.tpcafeskanderbardaoui.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspectClass {

    @Before("execution(* tn.esprit.spring.tpcafeskanderbardaoui.services..*.*(..))")
    public void logMethodEntry(JoinPoint jp) {
        log.info("In method"+jp.getSignature().getName());
    }

    @After("execution(* tn.esprit.spring.tpcafeskanderbardaoui.services..*.*(..))")
    public void logMethodExit(JoinPoint jp) {
        log.info("Out method"+jp.getSignature().getName());
    }

    @Before("execution(* tn.esprit.spring.tpcafeskanderbardaoui.services..*.*(..))")
    public void logMethodEnter(JoinPoint jp) {
        log.info("Enter method"+jp.getSignature().getName());
    }


    @Around("execution(* tn.esprit.spring.tpcafeskanderbardaoui.services..*.*(..))")
    public Object profile(ProceedingJoinPoint jp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = jp.proceed();
        long elapsedTime = System.currentTimeMillis() - startTime;
        log.info("Method execution time: " + elapsedTime + " ms");
        return obj;
    }

}
