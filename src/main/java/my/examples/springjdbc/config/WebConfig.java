package my.examples.springjdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"my.examples.springjdbc.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {
//web 설정은 webMvcConfigurerAdapter를 상속받아서 구현한다.
    //spring5에서는 사용하면 안된다.

    //JSP를 위한 viewResolver 빈을 생성한다.

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver bean= new InternalResourceViewResolver();
        //JstlView는 JSP를 실행하는 View(forward)
        bean.setViewClass(JstlView.class);

        //컨트롤러가 view name으로 list를 리턴한다면
        // "/WEB-INF/views/" + "list" + ".jsp"로 포워딩한다.
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");

        return bean;
    }

    //   원래 /로 등록되는 서블릿은 DefaultServlet이라고 했었다.
    //   그런데 Spring MVC는 DispatcherServlet이 그것을 사용한다.
    //   브라우저에서 GET /git.png 이런 요청이 왔는데, 이 정보가
    //   HandlerMapping에 없다. 이 경우 404가 발생하는데,
    //   아래와 같은 설정을 하게 되면 DispatcherServlet이 처리못하는 path를
    //   기존 DefaultServlet에게 넘긴다.

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        super.configureDefaultServletHandling(configurer);
        configurer.enable();
    }

    // Controller를 만들지 않고 헨들러를 설정.
    // http://localhost:8080 로 요청이 오면 /list로 리다이렉트
    @Override
    public void addViewControllers (ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("redirect:/list");
    }



}
