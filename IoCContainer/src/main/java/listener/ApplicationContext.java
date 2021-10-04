package listener;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.reflections.Reflections;

import controller.Component;

//ContextLoaderListener�κ��� properties�� �ִ� �ּҸ� ���� properties �� key ������ ���ε� ���� �������� ��ü�� �����Ͽ�
//hashtable�� key������ �����ϴ� IoC container ����
public class ApplicationContext {
	Hashtable<String, Object> objTable = new Hashtable<>();
	
	public Object getBean(String key) {
		return objTable.get(key);
	}
	//�����ڿ��� �Ű������� properties�� ���� ��θ� �Է� �޾�
	//properties�� Ű �����κ��� ���� ���� �о� ��ü�� �����ϴ� �۾��� �Ѵ�.
	public ApplicationContext(String propertiesPath) throws Exception{
		Properties props = new Properties();
		props.load(new FileReader(propertiesPath));
		//�޼ҵ带 ���� IoC container�� ����Ǿ��� ��ü���� ������.
		prepareObjects(props);
		prepareAnnotationObjects();
		injectDependency();
	}
	//������ properties���� ���� ���� ���Ǵ� controller�� ���� ��ü���� Ű���� ���� �����Ѵ�.
	public void prepareObjects(Properties props) throws Exception{
		Context ctx = new InitialContext();
		String key = null;
		String value = null;
		for(Object item: props.keySet()) {
			key = (String)item;
			value=props.getProperty(key);
			if(key.startsWith("jndi.")) {
				objTable.put(key, ctx.lookup(value));
			}else {
				objTable.put(key, Class.forName(value).newInstance());
			}
		}
	}
	
	private void injectDependency() throws Exception{
		for(String key : objTable.keySet()) {
			if(!key.startsWith("jndi.")) {
				callSetter(objTable.get(key));
			}
		}
	}
	
	private void callSetter(Object obj) throws Exception{
		Object dependency = null;
		
		//reflection ���, obj.getClass().getMethods() ������ ��ü�� ��� �޼ҵ带 �迭�� �������� �޼ҵ�
		for(Method m : obj.getClass().getMethods()) {
			if(m.getName().startsWith("set")) {
				dependency = findObjectByType(m.getParameterTypes()[0]);
				if(dependency != null) {
					//�޼ҵ带 ã�Ƽ� �޼ҵ带 ȣ�����ִ� ����.
					m.invoke(obj, dependency);
				}
			}
		}
	}
	
	private Object findObjectByType(Class<?> type) {
		for(Object obj: objTable.values()) {
			if(type.isInstance(obj)) {
				return obj;
			}
		}
		return null;
	}
	
	private void prepareAnnotationObjects() throws Exception{
		Reflections reflector = new Reflections("");
		Set<Class<?>> list = reflector.getTypesAnnotatedWith(Component.class);
		for(Class<?> clazz : list) {
			String key = clazz.getAnnotation(Component.class).value();
			objTable.put(key, clazz.newInstance());
		}
	}
}
