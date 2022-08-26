package cn.tangtj.clouddisk.annotation;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.apache.logging.log4j.Logger;

@Aspect // 1.切面类注解
public class MyLogAspect {
    private static Logger logger = LogManager.getLogger(MyLogAspect.class.getName());
    // 2. PointCut表示这是一个切点，@annotation表示这个切点切到一个注解上，后面带该注解的全类名
    // @Pointcut("execution(public * *(..))") execution：匹配指定方法。
    // 切面最主要的就是切点，所有的故事都围绕切点发生
    @Pointcut("execution(* cn.tangtj.clouddisk.web.LoginController.*(..))")
    public void controllerPoint() {

    }

    // 环绕通知
    @Around("controllerPoint()")
    public Object log(JoinPoint joinPoint) {
        System.out.println("进aop了 Around");
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        // 打印到控制台
        logger.info("请求类：{}，请求方法：{}", className, methodName);
        return null;
    }
}
