package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServeletInitializer;


@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    // Used when run as WAR
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(Application.class);
    }

    // Used when run as JAR
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
