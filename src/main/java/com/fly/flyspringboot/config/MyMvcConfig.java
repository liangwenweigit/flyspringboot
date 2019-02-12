package com.fly.flyspringboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
	
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
