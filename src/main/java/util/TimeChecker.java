package util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeChecker {

    @Around("execution(* service.*Service.*(*))")
    public void checker(ProceedingJoinPoint joinPoint) throws Throwable {
        // method 실행 전 처리
        long start = System.nanoTime();
        joinPoint.proceed();
        // method 실행 후 처리
        long end = System.nanoTime();

        String name = joinPoint.getSignature().getName();
        System.out.println(
                name + "이 걸린 시간은 " + (end - start) + "ns 입니다."
        );
    }
}
