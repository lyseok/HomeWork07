package kr.or.ddit.people.controller;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.exception.ResponseStateExcetion;
import kr.or.ddit.people.service.PeopleService;
import kr.or.ddit.people.service.impl.PeopleServiceImpl;
import kr.or.ddit.vo.PersonVO;

@WebServlet("/people/detail")
public class PeopleDetailControllerServlet extends HttpServlet{
	private PeopleService service = new PeopleServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("who");
		if(StringUtils.isBlank(id)) {
			resp.sendError(400, "필수 파라미터 누락");
			return;
		} 
		try {
			PersonVO person = service.readPerson(id)
									.orElseThrow(() -> new ResponseStateExcetion(400, "존재하지 않는 회원입니다."));
			req.setAttribute("person", person);
			String view = "/WEB-INF/views/people/peopleDetail.jsp";
			req.getRequestDispatcher(view).forward(req, resp);
		} catch (ResponseStateExcetion e) {
			resp.sendError(e.getStatus());
		}
	
	}
}
