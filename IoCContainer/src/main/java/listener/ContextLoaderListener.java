package listener;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import controller.LogInController;
import dao.MemberDAO;
import dao.MemberDAOImpl;

@WebListener
public class ContextLoaderListener implements ServletContextListener{
	//pagecontroller 등 bean 객체들을 생성하는 역할을 하는 instance
	static ApplicationContext applicationContext;
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	//웹 컨테이너가 실행될 때 가장 먼저 실행되는 것(웹 시작과 동시에 실행되며 발생하는 이벤트를 감지하는 역할을 하는게 listener)
	//IoC 컨테이너를 만들기 위해 컨텍스트로부터 초기 매개변수 값을 받아오는 객체
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			//웹 어플리케이션 마다 하나씩 생성되는 ServletContext 객체(웹 어플리케이션에서 서블릿 간 공유되는 값들을 저장한 일종의 메타 데이터 저장 객체)를 불러와
			ServletContext sc = event.getServletContext();
			
			MemberDAOImpl dao = new MemberDAOImpl();
			InitialContext initialContext = new InitialContext(); 
			DataSource ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/oracle");
			dao.setDataSource(ds);
			sc.setAttribute("memberdao", dao);
//			sc.setAttribute("/auth/login.do", new LogInController().setMemberDao(dao));
			//sc.getInitParameter("contextConfigLocation"): 서블릿 컨텍스트에 저장된 초기화 관련 매개변수 중 contextConfigLocation으로 매핑된 매개변수롤 가져온다.
			//sc.getRealPath(sc.getInitParameter("contextConfigLocation")) : 상대 주소로 저장된 위의 매개변수 값을 상대 경로가 아닌 실제 경로를 반환하는 메소드
			//이를 통해 properties 파일이 존재하는 실제 경로를 얻을 수 있다.
			String propertiesPath=sc.getRealPath(sc.getInitParameter("contextConfigLocation"));
			//properties가 들어있는 실제 경로를 ApplicationContext 생성자에 넣어 properties파일에 저장된 key와 value를 가지고 실제 실행해야 되는 서블릿을 알아낸다.
			applicationContext = new ApplicationContext(propertiesPath);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
