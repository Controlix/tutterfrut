package be.mbict.tutterfrut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean()
    {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(new UrlRewriteFilter());
        // registrationBean.addUrlPatterns("*");
        // registrationBean.addInitParameter("confReloadCheckInterval", "5");
        registrationBean.addInitParameter("logLevel", "DEBUG");
        registrationBean.addInitParameter("confPath", "WEB-INF/urlrewrite.xml");

        return registrationBean;
    }

}
