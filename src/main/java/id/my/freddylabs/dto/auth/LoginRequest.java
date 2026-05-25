package id.my.freddylabs.dto.auth;

import jakarta.validation.constraints.NotBlank;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class LoginRequest {

    @Schema(examples = "freddy@example.com", required = true)
    @NotBlank
    public String email;

    @Schema(examples = "12345678", required = true)
    @NotBlank
    public String password;
}