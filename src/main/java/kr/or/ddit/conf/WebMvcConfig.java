package kr.or.ddit.conf;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import kr.or.ddit.view.GsonView;

@Configuration
@EnableWebMvc
@ComponentScan(
    basePackages = "kr.or.ddit",
    includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class),
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = ControllerAdvice.class)
    },
    useDefaultFilters = false
)
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public View gsonView() {
        return new GsonView(); // 커스텀 JSON View 클래스
    }

    // ContentNegotiatingViewResolver를 직접 등록
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        resolver.setDefaultViews(List.of(gsonView())); // JSON 응답용 View 추가
        return resolver;
    }

    // JSP ViewResolver 등록 (기본 뷰 처리용)
    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    // MIME 타입 판단 방식 설정 (예: Accept 헤더 우선)
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
            .favorParameter(false)
            .ignoreAcceptHeader(false)
            .defaultContentType(MediaType.TEXT_HTML);
    }

    // 정적 리소스 처리
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(0);
    }
}
