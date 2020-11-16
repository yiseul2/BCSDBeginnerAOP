package util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ErrorChecker {

    @AfterThrowing (pointcut = "execution(* service.*Service.*(..))", throwing = "exception")
    public void checker(JoinPoint joinPoint, Throwable exception) throws Throwable {

        String name = joinPoint.getSignature().toString();

        System.out.println(
                "Error가 발생했습니다. Error 종류: " + exception + "\n"
                + "경로: " + name
        );
    }
}
