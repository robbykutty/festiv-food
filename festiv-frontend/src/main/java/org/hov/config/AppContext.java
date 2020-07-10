package org.hov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="org.hov.*")
public class AppContext implements WebMvcConfigurer
{
	@Bean(name="multipartResolver") 
	public CommonsMultipartResolver getResolver() 
	{
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSizePerFile(5242880);//5MB
		//Set other available properties here.
		return resolver;
	}
	 
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
   public void addResourceHandlers(ResourceHandlerRegistry registry) 
   {
	   registry.addResourceHandler("/images/**")
	   					.addResourceLocations("/WEB-INF/resources/images/");
	   registry.addResourceHandler("/css/**")
	   					.addResourceLocations("/WEB-INF/resources/css/");
	   registry.addResourceHandler("/engine1/**")
	   					.addResourceLocations("/WEB-INF/resources/engine1/");
	   registry.addResourceHandler("/tooltips/**")
	   					.addResourceLocations("/WEB-INF/resources/tooltips/");       
   }
}
