package com.qiudaozhang.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 邱道长
 * @since 2019/8/7
 * 总配置类
 */
@Configuration
@ComponentScan(basePackages = {"com.qiudaozhang.service","com.qiudaozhang.components"})
@Import({MybatisConfig.class,SpringMvcConfig.class})// 导入其它的配置类
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {


    // 注册一个会话工厂  需要数据源

    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastConfig = new FastJsonConfig();
        fastConfig.setDateFormat("yyyy-MM-dd");
        converter.setFastJsonConfig(fastConfig);
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypes);
        return converter;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 添加额外的消息转换器
        converters.add(fastJsonHttpMessageConverter());
    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/");
//    }
}
