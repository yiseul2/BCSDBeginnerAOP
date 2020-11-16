package util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PrintCalculator {

    @Before("execution (* service.*Service.*(*,*))")
    public void printParameter(JoinPoint joinPoint) throws Throwable {
        System.out.println(
                "<" + joinPoint.getSignature().getName() + ">"
        );
        Object args[] = joinPoint.getArgs();
        for(int i=0; i < args.length; i++){
            System.out.println(
                    (i+1) + "번째 인수: " + args[i].toString()
            );
        }
    }

    @After("execution (* service.*Service.*(*,*))")
    public void printExecutionResult(JoinPoint joinPoint) throws Throwable {
        System.out.println(
                joinPoint.getSignature().getName() + " 연산이 수행되었습니다."
        );
    }

    @AfterReturning(pointcut="execution (* service.*Service.*(*,*))", returning="result")
    public void printResult(JoinPoint joinPoint, Integer result) throws Throwable {
        System.out.println(
                "연산 결과는 " + result + " 입니다."
        );
    }

}
