package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

public class LogOutController implements Controller{
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		((HttpSession)model.get("session")).invalidate();
		return "redirect:/auth/LoginForm.html";
	}
}
