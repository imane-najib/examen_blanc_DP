package stage.ifm.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import stage.ifm.SecurityContext;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthorisationAspect {
    @Around(value = "@annotation(securedBy )",argNames = "proceedingJoinPoint,securedBy")
    public Object secure(ProceedingJoinPoint proceedingJoinPoint,SecuredBy securedBy) throws Throwable {
        String[] roles = securedBy.roles();

        boolean authorized = false;

        for(String role : roles){
            if (SecurityContext.hasRole(role)){
                authorized = true;
                break;
            }
        }
        if(authorized==true){
            Object result = proceedingJoinPoint.proceed();
            return result;
        }
        throw new RuntimeException("Unauthorized =>403 to access "+proceedingJoinPoint.getSignature());

    }
}
