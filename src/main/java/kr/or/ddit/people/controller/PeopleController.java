package kr.or.ddit.people.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.exception.ResponseStateExcetion;
import kr.or.ddit.people.service.PeopleService;
import kr.or.ddit.validate.util.ValidateUtils;
import kr.or.ddit.vo.PersonVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/spring/people")
public class PeopleController {
	private final PeopleService service;
	
	@GetMapping
	public String personList(Model model) {
		List<PersonVO> personList = service.readPersonList();
		model.addAttribute("personList", personList);
		return "people/peopleList";
	}
	
	@GetMapping("/{id}")
	public String personDetail(
		@PathVariable("id") String id	
		, Model model
	) {
		PersonVO person = service.readPerson(id)
				.orElseThrow(() -> new ResponseStateExcetion(400, "존재하지 않는 회원입니다."));
		model.addAttribute("person", person);
		return "people/peopleDetail";
	}
	
	@GetMapping("/new")
	public String newPerson(Model model) {
		log.info("new----------------");
		log.info("{}", model.getAttribute("message"));
		return "people/peopleForm";
	}
	
	@PostMapping
	public String personCreate(
		@RequestBody PersonVO person
		, RedirectAttributes redirectAttr
	) {
		log.info("post-------------------------");
		log.info("{}", person);
		Map<String, String> errors = ValidateUtils.validate(person);

		if (errors.isEmpty()) {
            service.createPerson(person);
            redirectAttr.addFlashAttribute("success", true);
            redirectAttr.addFlashAttribute("message", "회원 등록에 성공했습니다.");
            return "redirect:people/" + person.getId();
        } else {
        	redirectAttr.addFlashAttribute("success", false);
        	redirectAttr.addFlashAttribute("message", "회원 등록에 실패했습니다.");
        	redirectAttr.addFlashAttribute("errors", errors);
        	redirectAttr.addFlashAttribute("data", person); 
            return "redirect:people/new";
        }
	}
	@GetMapping("/{id}")
	public String personDelete(
		@PathVariable("id") String id
		, Model model
	) {
		if(StringUtils.isBlank(id)) {
			model.addAttribute("message", "회원 ID를 확인해주세요.");
			return "";
		} else {
			service.removePerson(id);
			model.addAttribute("message", "회원 삭제에 성공했습니다.");
			return "redirect:people";
		}
	}
}
