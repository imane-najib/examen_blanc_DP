package stage.ifm.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@EnableAspectJAutoProxy
public class logAspect {
    Logger logger = Logger.getLogger(logAspect.class.getName());

    @Around("@annotation(stage.ifm.aspects.Log)")
    public Object Log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        logger.info("From Logging Aspect .... Before "+proceedingJoinPoint.getSignature());
        Object result = proceedingJoinPoint.proceed();
        logger.info("From Logging Aspect .... After "+proceedingJoinPoint.getSignature());
        long t2 = System.currentTimeMillis();
        logger.info("Duration "+(t2-t1)+"ms");
        return result;


    }
}
