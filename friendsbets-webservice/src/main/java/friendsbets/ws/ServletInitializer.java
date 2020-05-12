package friendsbets.ws;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * TODO: Verify if this class is needed.
 * @author Gauthier Barbet <a href="https://gitlab.com/gauthiergitlab"> @gauthiergitlab </a>
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("servletInit");
		return application.sources(FbsWebServiceApplication.class);
	}

}
