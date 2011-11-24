package whiteship.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppIntializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext context) throws ServletException {
		AnnotationConfigWebApplicationContext dispatcherServletContext = new AnnotationConfigWebApplicationContext();
		dispatcherServletContext.register(AppConfig.class, WebConfig.class);

		ServletRegistration.Dynamic dispatcher = context.addServlet("spring", new DispatcherServlet(dispatcherServletContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
    }
}
