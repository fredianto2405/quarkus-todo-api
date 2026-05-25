package id.my.freddylabs.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

@Provider
public class RequestLoggingFilter implements ContainerRequestFilter {

    private static final Logger LOG =
            Logger.getLogger(RequestLoggingFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) {

        LOG.infof(
                "Request %s %s",
                requestContext.getMethod(),
                requestContext.getUriInfo().getPath()
        );
    }
}