package boilerplate.springboot.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Configuration
public class ControllerLogAspect {

    @Autowired
    private HttpServletRequest request;

    @Pointcut("execution(* boilerplate.springboot.web.controller..*Controller.*(..))")
    public void controllerLayer() {
    }

    @Pointcut("execution(* boilerplate.springboot.web.controller.GlobalExceptionController.*(..))")
    public void globalExceptionHandlerLayer() {
    }

    @Around(value = "controllerLayer()")
    public Object aroundController(ProceedingJoinPoint pjp) throws Throwable {
        log.debug("{} \"{}\"", request.getMethod(), getRequestURL());
        log.debug("Mapped to {}, args: {}", pjp.getSignature(), pjp.getArgs());

        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long proceedTime = System.currentTimeMillis() - start;

        log.debug("Return: {}, proceed time: {} ms", output, proceedTime);
        return output;
    }

    @AfterReturning(value = "globalExceptionHandlerLayer()", returning = "returnObject")
    public void globalExceptionHandlerReturning(JoinPoint joinPoint, Object returnObject) {
        log.debug("Handle by exception Handler: {}", returnObject);
    }

    private String getRequestURL() {
        if (request.getQueryString() == null) {
            return request.getRequestURI();
        }

        return request.getRequestURI() + "?" + request.getQueryString();
    }
}
