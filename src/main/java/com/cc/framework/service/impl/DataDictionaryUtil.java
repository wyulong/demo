package com.cc.framework.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cc.framework.annotation.Dict;
import com.cc.framework.model.SysDictionaries;
import com.cc.framework.service.SysDictionariesService;

@Component
public class DataDictionaryUtil {
	
	@Autowired
	private SysDictionariesService sysDictionariesService;//cas系统获取数据字典服务
	/*@Reference
	private OrganizationService organizationService;//cas系统获取组织机构服务
*/	//数据字典
	private static List<SysDictionaries> dictList = new ArrayList<SysDictionaries>();
	//组织机构字典
	//private static List<OrganizationInfo> orgList = new ArrayList<OrganizationInfo>();
	//需要转化的字段名
	private static String fieldNames = "";
	//已经获取的数据字典记录，避免重复去系统获取
	private static Map<String, String> codeRecord = new HashMap<String, String>();
	
	/**
	 * 根据clzz初始将要转化的字典数据
	 * @param clzz 需要转换的对象class
	 */
	public <T> void initData(Class<T> clzz){
		clear();
		initDictionary(clzz);
	}
	
	public void clear(){
		fieldNames = "";
	}
	
	public <T> void initDictionary(Class<T> clzz){
		Field[] fields = clzz.getDeclaredFields();
		for (Field field : fields) {
			Class<?> c = field.getType();
			//判断字段否是对象
			if(null!=c.getClassLoader()){
				//递归获取需要转换的字段
				initDictionary(c);
			}else{
				if(field.isAnnotationPresent(Dict.class)){
					fieldNames += clzz.getSimpleName()+"."+field.getName()+",";
					Dict dict = field.getAnnotation(Dict.class);
					//判断是否已经获取过该code的字典数据 避免重复获取
					if(codeRecord.get(dict.value()) == null){
						List<SysDictionaries> list = sysDictionariesService.getChildrenByCode(dict.value());
						if(list!=null&&list.size()>0){
							dictList.addAll(list); 
							//记录已经获取的字典code
							codeRecord.put(dict.value()+"", dict.value()+"");
						}
					}
				}/*else if(field.isAnnotationPresent(Org.class)){
					fieldNames += clzz.getSimpleName()+"."+field.getName()+",";
					Org org = field.getAnnotation(Org.class);
					if(codeRecord.get(org.value()) == null){
						List<OrganizationInfo> list = organizationService.getChildrenByType(org.value());
						if(list!=null&&list.size()>0){
							orgList.addAll(list);
							codeRecord.put(org.value(), org.value());
						}
					}
				}*/
			}
		}
	}
	/**
	 * 将指定数据内凡是对象标注有@dict @org 注解的字段转化为对应数据字典的codeName）
	 * @param datalist 数据集合（一般为分页查询后的pageInfo.getPage().getContent()数据）
	 * @return 返回List<Object> 
	 */
	@SuppressWarnings("unchecked")
	public <T> List<Object> handDictionaryCodeToCodeName(List<?> datalist){
//		System.out.println("需要转换的字段为："+fieldNames);
		if(!"".equals(fieldNames) && !(null == fieldNames)){
			String[] fNames = fieldNames.split(",");
			for (Object object : datalist) {
				codeToName(fNames, object);
			}
		}
		return (List<Object>) datalist;
	}
	
	public <T> Object handDictionaryCodeToCodeName(Object data){
//		System.out.println("需要转换的字段为："+fieldNames);
		if(!"".equals(fieldNames) && !(null == fieldNames)){
			String[] fNames = fieldNames.split(",");
			codeToName(fNames, data);
		}
		return data;
	}
	
	public void codeToName(String[] fNames,Object object){
		String classFieldName = "";
		Class<? extends Object> clzz = object.getClass();
		Field[] fields = clzz.getDeclaredFields();
		for (int i = 0; i < fNames.length; i++) {
			for (Field field : fields) {
				Class<?> c = field.getType();
				//是否是对象
				if(null!=c.getClassLoader()){
					//只统计一次
					if(i==0){
						classFieldName += field.getName()+",";
					}
				}else{
					String[] n = fNames[i].split("\\.");
					if(clzz.getSimpleName().equals(n[0])&&field.getName().equals(n[1])){
//						System.out.println("开始转换字段："+fNames[i]);
						try {
							field.setAccessible(true);
							Object val = field.get(object);
							if(field.isAnnotationPresent(Dict.class)){
								for (SysDictionaries code : dictList) {
									if(code.getBianma().equals(val+"")){
										field.set(object, code.getName());
										break;
									}
								}
							}/*else if(field.isAnnotationPresent(Org.class)){
								for (OrganizationInfo org : orgList) {
									if(org.getOrgCode().equals(val)){
										field.set(object, org.getOrgName());
										break;
									}
								}
							}*/
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					}
				}
			}
		}
		String[] classFieldNames = classFieldName.split(",");
		for (String fieldName : classFieldNames) {
			try {
				if(!"".equals(fieldName) && fieldName != null){
					Field classField = clzz.getDeclaredField(fieldName);
					classField.setAccessible(true);
					if(null!=classField.get(object)){
						codeToName(fNames, classField.get(object));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}