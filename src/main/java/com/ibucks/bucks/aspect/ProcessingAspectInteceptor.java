package com.ibucks.bucks.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class ProcessingAspectInteceptor {

    @Pointcut("execution(public * com.ibucks.bucks.sevice..*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        String result = "Y";
        String methodName = "-";
        try{
           methodName =  proceedingJoinPoint.getSignature().getName();
           return proceedingJoinPoint.proceed();
        }catch (Throwable se){
            result = "N";
            throw se;
        }finally {
            long endTime = System.currentTimeMillis();
            log.info("{};{};{} ms",methodName,result,endTime-startTime);

        }
    }
}
