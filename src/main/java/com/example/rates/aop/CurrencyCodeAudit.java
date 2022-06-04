package com.example.rates.aop;

import com.example.rates.annotation.ToUpper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;

@Aspect
@Component
public class CurrencyCodeAudit {

    @Pointcut("execution(* com.example.rates.service.*Service.*(.., @com.example.rates.annotation.ToUpper (*),..))")
    public void methodPointcut() {}

    @Around("methodPointcut()")
    public Object codeAudit(ProceedingJoinPoint pjp) throws Throwable{
        Object[] args = pjp.getArgs();
        Parameter[]  parameters = ((MethodSignature)pjp.getSignature()).getMethod().getParameters();

        return pjp.proceed(IntStream.range(0, args.length)
                .mapToObj(index -> (parameters[index].isAnnotationPresent(ToUpper.class)) ? (new String(args[index].toString().toUpperCase())) : (args[index]) )
                .toArray());
    }
}
