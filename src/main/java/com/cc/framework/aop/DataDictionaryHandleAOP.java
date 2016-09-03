package com.cc.framework.aop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.cc.framework.annotation.Dict;
import com.cc.framework.service.impl.DataDictionaryUtil;
import com.github.pagehelper.PageInfo;

/*@Aspect
@Configuration*/
public class DataDictionaryHandleAOP {
	@Autowired
	//数据字典处理工具类
	private DataDictionaryUtil dataDictionaryUtil;
	//设定切入点
	/*@Pointcut("execution(* com.cc.framework.service.impl.*.find(..)) || execution(* com.cc.framework.service.impl.*.get(..))")
	private void anyMethod(){};*/
	
	//切入方式为后切入
//	@AfterReturning(value="execution(* com.cc.framework.service.impl.*.find(..)) || execution(* com.cc.framework.service.impl.*.get(..))", returning="result")
	public void afterRunningMethod(JoinPoint joinPoint,Object result){
//		System.out.println("AOP数组字典code转name--start "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		int count = 0;
		if(result instanceof PageInfo<?>){
			List<?> list = ((PageInfo<?>)result).getList();
			if(list!=null&&list.size()>0){
				long startD = new Date().getTime();
				//初始中央平台获取class转换所需的码表集合
				dataDictionaryUtil.initData(list.get(0).getClass());
				//开始转换
				dataDictionaryUtil.handDictionaryCodeToCodeName(list);
				count  = (int) (new Date().getTime() - startD);
			}
		}else if(result.getClass().getAnnotation(Dict.class) != null){
			dataDictionaryUtil.handDictionaryCodeToCodeName(result);
		}
		//获取数据集
//		System.out.println("AOP数组字典code转name--end"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//		System.out.println("耗时："+count+" ms");
	}
	
}