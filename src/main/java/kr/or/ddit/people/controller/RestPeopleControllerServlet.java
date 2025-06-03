package kr.or.ddit.people.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.conf.AppConfig;
import kr.or.ddit.exception.ResponseStateExcetion;
import kr.or.ddit.people.service.PeopleService;
import kr.or.ddit.people.service.impl.PeopleServiceImpl;
import kr.or.ddit.validate.util.ValidateUtils;
import kr.or.ddit.vo.PersonVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/rest/people/*")
@Component
public class RestPeopleControllerServlet extends HttpServlet {
	private PeopleService service;
	private Gson gson = new Gson();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		service = ac.getBean(PeopleService.class);
	}
	/**
	 * @param out 출력 Writer
	 * @param status 요청 성공 여부
	 * @param message 요청 상세 정보
	 */
	private void respMessage(PrintWriter out, boolean status, Object message) throws JsonIOException, IOException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", status);
		res.put("message", message);
		gson.toJson(res, out);
	}
	
	/**
	 * @param out 출력 Writer
	 * @param status 요청 성공 여부
	 * @param message 요청 상세 정보
	 * @param body 응답에 같이 보낼 데이터
	 */
	private void respMessage(PrintWriter out, boolean status, Object message, Object body) throws JsonIOException, IOException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", status);
		res.put("message", message);
		res.put("body", body);
		gson.toJson(res, out);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		
		if(path == null || path.equals("/")) {
			List<PersonVO> peopleList = service.readPersonList();
			gson.toJson(peopleList, resp.getWriter());	
		} else {
			String id = path.substring(1);
			try {
				PersonVO person = service.readPerson(id)
						.orElseThrow(() -> new ResponseStateExcetion(400, "존재하지 않는 회원입니다."));
				gson.toJson(person, resp.getWriter());	
			} catch (ResponseStateExcetion e) {
				respMessage(resp.getWriter(), false, e.getMessage());
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonVO person = gson.fromJson(req.getReader(), PersonVO.class);
		Map<String, String> errors = ValidateUtils.validate(person);
		
		if(errors.isEmpty()) {
			service.createPerson(person);
			respMessage(resp.getWriter(), true, "회원 등록에 성공했습니다.");
		} else {
			respMessage(resp.getWriter(), false, errors, person);
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		PersonVO person = gson.fromJson(req.getReader(), PersonVO.class);
		person.setId(path.substring(1));
		Map<String, String> errors = ValidateUtils.validate(person);
		
		if(errors.isEmpty()) {
			service.modifyPerson(person);
			respMessage(resp.getWriter(), true, "회원 정보 수정에 성공했습니다.");
		} else {
			respMessage(resp.getWriter(), false, errors, person);
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		
		if(path == null || path.equals("/")) {
			respMessage(resp.getWriter(), false, "회원 ID를 확인해주세요.");
		} else {
			String id = path.substring(1);
			service.removePerson(id);
			respMessage(resp.getWriter(), true, "회원 삭제에 성공했습니다.");
		}
	}
}
