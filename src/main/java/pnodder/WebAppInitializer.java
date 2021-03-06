package pnodder;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pnodder.data.config.AppConfig;
import pnodder.web.config.WebConfig;
import pnodder.web.config.WebSecurityConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {AppConfig.class, WebSecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
