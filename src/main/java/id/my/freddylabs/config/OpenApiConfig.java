package id.my.freddylabs.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Todo API",
                version = "1.0.0",
                description = "Startup Todo API"
        )
)
@ApplicationPath("/")
public class OpenApiConfig extends Application {
}