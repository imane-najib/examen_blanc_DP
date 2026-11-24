package stage.ifm.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import stage.ifm.entities.Agent;

import java.util.logging.Logger;

@Aspect
@Component
@EnableAspectJAutoProxy
public class CachableAspect {
    private static  boolean cache = false;
    private static Object result = null;
    private static int NbTran = 0;
    @Around("@annotation(stage.ifm.aspects.Cachable)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Agent agent = (Agent) proceedingJoinPoint.getTarget();



        if (cache == false) {
             cache = true;
             NbTran = agent.getTransactions().size();
             result = proceedingJoinPoint.proceed();
        }

        if (agent.getTransactions().size() != NbTran) {
            result = proceedingJoinPoint.proceed();
        }
     return result;

    }
}
