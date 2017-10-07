package individuail.utils;

import indiviudual.domain.Student;
import indiviudual.form.StudentForm;

import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtil {
	public static <T>T request2Form(HttpServletRequest request, Class<T> beanClass){
		try{
			T bean = beanClass.newInstance();
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()){
				String name = (String)e.nextElement();
				String value = request.getParameter(name);
				System.out.println(name+":"+value);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
	
	public static void copyBean(StudentForm sf, Student student){
		try {
			BeanUtils.copyProperties(student, sf);
		} catch (Exception e) {
			throw new RuntimeException();
	}

}
}
