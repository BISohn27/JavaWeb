package listener;

import java.io.FileReader;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

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
}
