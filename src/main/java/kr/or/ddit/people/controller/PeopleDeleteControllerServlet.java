package kr.or.ddit.people.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.people.service.PeopleService;
import kr.or.ddit.people.service.impl.PeopleServiceImpl;

@WebServlet("/people/delete")
public class PeopleDeleteControllerServlet extends HttpServlet{
	private PeopleService service = new PeopleServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("who");
		if(StringUtils.isBlank(id)) {
			resp.sendError(400, "필수 파라미터 누락");
			return;
		} 
		service.removePerson(id);
		resp.sendRedirect(req.getContextPath() + "/people/list");
	}
}
