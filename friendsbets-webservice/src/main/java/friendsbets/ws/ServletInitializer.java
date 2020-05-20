package friendsbets.ws;

import org.jboss.logging.Logger;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * TODO: Verify if this class is needed by tomcat and not by spring boot server.
 * @author Gauthier Barbet <a href="https://gitlab.com/gauthiergitlab"> @gauthiergitlab </a>
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		Logger.getLogger(this.getClass()).info("		!! ServletInitializer !!");
		return application.sources(FbsWebServiceApplication.class);
	}

}
