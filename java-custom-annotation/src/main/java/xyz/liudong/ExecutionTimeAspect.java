package xyz.liudong;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ExecutionTime 注解 AOP 处理类
 *
 * @author: liudong
 * @date: 2019/10/17
 */
@Aspect
@Component
public class ExecutionTimeAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    /**
     * 当某方法使用了 @ExecutionTime 注解并被调用, 该方法也将执行用于记录某方法的执行时间
     *
     * @param proceedingJoinPoint proceedingJoinPoint
     * @param executionTime       executionTime
     * @return object
     */
    @Around("@annotation(executionTime)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, ExecutionTime executionTime) throws Throwable {
        String className = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String methodName = proceedingJoinPoint.getSignature().getName();

        long startTime = System.nanoTime();
        Object object = proceedingJoinPoint.proceed();
        long endTime = System.nanoTime();
        long timeElapsed;

        ExecutionTimeEnum[] timeUnitEnums = executionTime.timeUnit();

        for (ExecutionTimeEnum timeUnitEnum : timeUnitEnums) {
            switch (timeUnitEnum) {
                case SECOND:
                    timeElapsed = (endTime - startTime) / 1000000 / 1000;
                    logger.info("{}.{} running time is {} s", className, methodName, timeElapsed);
                    break;
                case MILLISECOND:
                    timeElapsed = (endTime - startTime) / 1000000;
                    logger.info("{}.{} running time is {} ms", className, methodName, timeElapsed);
                    break;
                case NANOSECOND:
                    timeElapsed = (endTime - startTime);
                    logger.info("{}.{} running time is {} ns", className, methodName, timeElapsed);
                    break;
                case ALLTIMEUNIT:
                    timeElapsed = (endTime - startTime) / 1000000 / 1000;
                    logger.info("{}.{} running time is {} s", className, methodName, timeElapsed);
                    timeElapsed = (endTime - startTime) / 1000000;
                    logger.info("{}.{} running time is {} ms", className, methodName, timeElapsed);
                    timeElapsed = (endTime - startTime);
                    logger.info("{}.{} running time is {} ns", className, methodName, timeElapsed);
                    break;
                default:
                    break;
            }
        }
        return object;
    }

}
