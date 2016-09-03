//package com.cc.framework.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//
///**
// * @author whp
// * @Email whp@ehoo.cn
// * @Jan 4, 2011
// * 
// */
//@Aspect//声明切面
//@Component//把类交给spring管理
//public class MyInterceptor {
//	Logger logger = LoggerFactory.getLogger(getClass());
//	
//	@Pointcut("execution(* com.cc.framework.service.*.*(..))")// 切入点表达式
//	private void anyMethod() {
//	}// 声明一个切入点
//	/*@Before("anyMethod()")//定义前置通知 执行业务方法前执行 args(userName) 表示要执行的方式必须为一个参数并为Person类型.这样就给他再加了限制条件
//	public void doAccessCheck(SysResource resource) {
//		System.out.println("执行前置通知"); 
//		logger.info("执行前置通知");
//	}*/
//	@AfterReturning(pointcut="anyMethod()")//定义后置通知 执行完业务方法后执行 如果例外通知执行，那么它不会执行
//	public void doReturnCheck() {
//		System.out.println("执行后置通知"); 
//		logger.info("执行后置通知");
//	}
//	
//	@After("anyMethod()")//定义最终通知 finally里执行的通知。
//	public void doReleaseAction() {
//		System.out.println("执行最终通知"); 
//		logger.info("执行最终通知");
//	}
//	
//	@AfterThrowing(pointcut="anyMethod()", throwing="ex")//定义例外通知
//    public void doExceptionAction(Exception ex) {
//		System.out.println("执行例外通知"); 
//		logger.info("执行例外通知");
//	}
//	 
//	@Around("anyMethod()")//环绕通知 doBasicProfiling    pjp可以修改  用于权限
//	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
//		logger.info("执行环绕通知"); 
//		Object retule =pjp.proceed();
//		logger.info("退出环绕通知"); 
//		return retule;
//	}
//
//
//
//
//}
