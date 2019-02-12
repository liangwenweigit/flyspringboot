package com.fly.flyspringboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fly.flyspringboot.interceptor.LoginInterceptor;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * 添加登录拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
                                                       //添加拦截的请求url（原来是/user/api/order/**）
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                //设置不拦截的请求url
                .excludePathPatterns();
        //注意：静态页面不需要处理，springboot已经处理了
        WebMvcConfigurer.super.addInterceptors(registry);
    }
	
	/**
	 * localDirectory变量是外部文件夹
	 * 文件需要上传到该文件夹中去，staticMapping就是映射的静态资源请求路径了。
	 */
    @Value("${my.upload.imgPath}")
    private String path;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String staticMapping="/image/**";
        String localDirectory = "file:"+path;
        registry.addResourceHandler(staticMapping).addResourceLocations(localDirectory);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
