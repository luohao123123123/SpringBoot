package com.luohao.springboot.aspect;

import com.luohao.springboot.annotation.LogAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import com.luohao.springboot.R.R;

import java.lang.reflect.Modifier;

/**
 * @Aspect：标识这个类是一个切面类
 */
@Aspect
@Component
public class LogAnnoAspect {
    /**
     * @Pointcut声明了切点（这里的切点是我们自定义的注解类）
     */
    @Pointcut("@annotation(com.luohao.springboot.annotation.LogAnnotation)")
    private void pointcut(){}

    /**
     * @Before:前置通知，在方法执行之前，声明了通知内容
     * @annotation(logger):拿到了自定义的注解对象
     * JoinPoint:连接点对象，通过它可以获取到目标方法的相关信息
     * @param logger
     */
    @Before(value = "pointcut() && @annotation(logger)", argNames = "joinPoint,logger")
    public void advice(JoinPoint joinPoint,LogAnnotation logger) {
        System.out.println("方法执行之前：[-------------");
        System.out.println("注解作用的方法名："+joinPoint.getSignature().getName());
        System.out.println("所在类的简单类名："+joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("所在类的完整类名："+joinPoint.getSignature().getDeclaringType());
        System.out.println("目标方法的声明类型："+ Modifier.toString(joinPoint.getSignature().getModifiers()));
        System.out.println("方法中的参数为："+joinPoint.getArgs()[0]);
        System.out.println("日志内容："+logger.value());
        System.out.println("-------------]");

    }


    /**
     * 修改方法的参数
     * ProceedingJoinPoint:JoinPoint的子类，比JoinPoint多了返回值
     * proceed:让目标方法执行，和更新参数列表
     * @param joinPoint
     * @param logger
     */
    @Around(value = "pointcut() && @annotation(logger)")
    public Object advice(ProceedingJoinPoint joinPoint, LogAnnotation logger){
        System.out.println("环绕执行：[---------");
        System.out.println("注解作用的方法名："+joinPoint.getSignature().getName());
        System.out.println("更新前方法中的参数为："+joinPoint.getArgs()[0]);
        Object result=null;
        Object[] args = joinPoint.getArgs();  //获取全部参数
        for (int i = 0; i < args.length; i++) {
            if(args[i] instanceof Integer){   //判断是否为tid
                args[i]=Integer.parseInt(args[i].toString())+1;   //给tid加1
                break;
            }
        }
        System.out.println("更新后方法中的参数为："+joinPoint.getArgs()[0]);
        try {
             result = joinPoint.proceed(args);  //更新参数列表
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return result;
    }
}
