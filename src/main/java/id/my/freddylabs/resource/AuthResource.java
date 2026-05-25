package id.my.freddylabs.resource;

import id.my.freddylabs.dto.auth.LoginRequest;
import id.my.freddylabs.dto.auth.RegisterRequest;
import id.my.freddylabs.dto.response.ApiResponse;
import id.my.freddylabs.service.AuthService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Authentication")
public class AuthResource {

    @Inject
    AuthService authService;

    @POST
    @Path("/register")
    @Operation(summary = "Register new user")
    public ApiResponse<?> register(
            @Valid RegisterRequest request
    ) {

        authService.register(request);

        return new ApiResponse<>(
                true,
                "Register success",
                null
        );
    }

    @POST
    @Path("/login")
    @Operation(summary = "Login user")
    public ApiResponse<?> login(
            @Valid LoginRequest request
    ) {

        return new ApiResponse<>(
                true,
                "Login success",
                authService.login(request)
        );
    }
}