package com.example.BitCoin.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // JSP 뷰 리졸버 설정
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");  // JSP 파일 경로 설정
        resolver.setSuffix(".jsp");  // 파일 확장자 설정
        return resolver;
    }

    // UTF-8 인코딩 필터 설정
    @Bean(name = "customCharacterEncodingFilter")
    public FilterRegistrationBean<CharacterEncodingFilter> characterEncodingFilter() {
        FilterRegistrationBean<CharacterEncodingFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceRequestEncoding(true);
        filter.setForceResponseEncoding(true);
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

}
