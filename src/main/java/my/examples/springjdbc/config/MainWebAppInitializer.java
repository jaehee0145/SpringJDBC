package my.examples.springjdbc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class MainWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public MainWebAppInitializer(){
        System.out.println("MainWebAppInitializer() -------------------------------------------");
    }
    // 비지니스 로직 관련 스프링 설정
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { ApplicationConfig.class };
    }
    // 웹과 관련된 설정
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    // 사용자가 필터를 설정.
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");

        return new Filter[]{encodingFilter};
    }

}