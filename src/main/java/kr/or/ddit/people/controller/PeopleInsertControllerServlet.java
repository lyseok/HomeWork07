package kr.or.ddit.people.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.people.service.PeopleService;
import kr.or.ddit.people.service.impl.PeopleServiceImpl;
import kr.or.ddit.validate.util.ValidateUtils;
import kr.or.ddit.vo.PersonVO;

@WebServlet("/people/new")
public class PeopleInsertControllerServlet extends HttpServlet{
	private PeopleService service = new PeopleServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PersonVO person = (PersonVO)session.getAttribute("person");
		session.removeAttribute("person");
		Map<String, String> errors = (Map<String, String>)session.getAttribute("errors");
		session.removeAttribute("errors");
		
		req.setAttribute("person", person);
		req.setAttribute("errors", errors);
		
		String view = "/WEB-INF/views/people/peopleForm.jsp";
		req.getRequestDispatcher(view).forward(req, resp);		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonVO person = new PersonVO();
		
		try {
			BeanUtils.populate(person,	req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new ServletException(e);
		}
		
		Map<String, String> errors = ValidateUtils.validate(person);
		if(errors.isEmpty()) {
			service.createPerson(person);
			resp.sendRedirect(req.getContextPath() + "/people/detail?who=" + person.getId());
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("person", person);
			session.setAttribute("errors", errors);
			resp.sendRedirect(req.getContextPath() + "/people/new");
		}
	}
}
