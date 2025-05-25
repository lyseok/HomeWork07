package kr.or.ddit.people.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.people.service.PeopleService;
import kr.or.ddit.people.service.impl.PeopleServiceImpl;
import kr.or.ddit.vo.PersonVO;

@WebServlet("/people/list")
public class PeopleListControllerServlet extends HttpServlet {
	private PeopleService service = new PeopleServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<PersonVO> peopleList = service.readPersonList();
		req.setAttribute("peopleList", peopleList);
		String view = "/WEB-INF/views/people/peopleList.jsp";
		req.getRequestDispatcher(view).forward(req, resp);
	}
}
