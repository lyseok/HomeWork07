package kr.or.ddit.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * cros site에서 요청되는 rest api에 대해 cors헤더를 추가하기 위한 필터 
 */
public class CorsFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		res.setHeader("Access-Control-Allow-Origin", "http://localhost:6060");
	    res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
	    res.setHeader("Access-Control-Allow-Headers", "Content-Type");
	    
		chain.doFilter(req, res);
	}
}
