package listener;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import controller.LogInController;
import controller.MemberAddController;
import controller.MemberDeleteController;
import controller.MemberListController;
import controller.MemberUpdateController;
import dao.MemberDAOImpl;

@WebListener
public class ContextLoaderListener implements ServletContextListener{
	//pagecontroller �� bean ��ü���� �����ϴ� ������ �ϴ� instance
	static ApplicationContext applicationContext;
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	//�� �����̳ʰ� ����� �� ���� ���� ����Ǵ� ��(�� ���۰� ���ÿ� ����Ǹ� �߻��ϴ� �̺�Ʈ�� �����ϴ� ������ �ϴ°� listener)
	//IoC �����̳ʸ� ����� ���� ���ؽ�Ʈ�κ��� �ʱ� �Ű����� ���� �޾ƿ��� ��ü
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			//�� ���ø����̼� ���� �ϳ��� �����Ǵ� ServletContext ��ü(�� ���ø����̼ǿ��� ������ �� �����Ǵ� ������ ������ ������ ��Ÿ ������ ���� ��ü)�� �ҷ���
			ServletContext sc = event.getServletContext();
			
//			MemberDAOImpl dao = new MemberDAOImpl();
//			InitialContext initialContext = new InitialContext(); 
//			
//			DataSource ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/oracle");
//			dao.setDataSource(ds);
//			
//			//������ ������ ��Ʈ�ѷ����� application context ��ü�� �ؽ����̺��� ���� �ȴ�.
//			sc.setAttribute("/auth/login.do", new LogInController().setMemberDao(dao));
//			sc.setAttribute("/member/list.do", new MemberListController().setMemberDao(dao));
//			sc.setAttribute("/member/add.do", new MemberAddController().setMemberDao(dao));
//			sc.setAttribute("/member/delete.do", new MemberDeleteController().setMemberDao(dao));
//			sc.setAttribute("/member/update.do", new MemberUpdateController().setMemberDao(dao));
			
			//sc.getInitParameter("contextConfigLocation"): ������ ���ؽ�Ʈ�� ����� �ʱ�ȭ ���� �Ű����� �� contextConfigLocation���� ���ε� �Ű������� �����´�.
			//sc.getRealPath(sc.getInitParameter("contextConfigLocation")) : ��� �ּҷ� ����� ���� �Ű����� ���� ��� ��ΰ� �ƴ� ���� ��θ� ��ȯ�ϴ� �޼ҵ�
			//�̸� ���� properties ������ �����ϴ� ���� ��θ� ���� �� �ִ�.
			
			String propertiesPath=sc.getRealPath(sc.getInitParameter("contextConfigLocation"));
			//properties�� ����ִ� ���� ��θ� ApplicationContext �����ڿ� �־� properties���Ͽ� ����� key�� value�� ������ ���� �����ؾ� �Ǵ� �������� �˾Ƴ���.
			applicationContext = new ApplicationContext(propertiesPath);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}