package chap07.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class CacheAspect {
    private Map<Long,Object> cache=new HashMap<>();

    @Pointcut("execution(public * chap07..*(long))")
    public void cacheTarget(){}

    @Around("execution(public * chap07..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        Long num=(Long)joinPoint.getArgs()[0];
        if(cache.containsKey(num)){
            System.out.printf("cacheAspect : Cache에서 구함[%d]\n",num);
            return cache.get(num);
        }

        Object result=joinPoint.proceed();
        cache.put(num,result);
        System.out.printf("CacheAspect : cache에 추가 [%d]\n",num);
        return result;
    }


}
