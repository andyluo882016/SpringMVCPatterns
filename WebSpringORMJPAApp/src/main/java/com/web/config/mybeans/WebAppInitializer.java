package com.web.config.mybeans;

import org.springframework.web.WebApplicationInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import com.web.config.mybeans.AppConfig;
public class WebAppInitializer implements WebApplicationInitializer{

	public void onStartup(ServletContext container) throws ServletException {
		 
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(container);
 
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
 
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
