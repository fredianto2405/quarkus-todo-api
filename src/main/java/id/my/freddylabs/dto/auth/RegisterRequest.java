package id.my.freddylabs.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class RegisterRequest {

    @Schema(examples = "Freddy", required = true)
    @NotBlank
    public String name;

    @Schema(examples = "freddy@example.com", required = true)
    @Email
    @NotBlank
    public String email;

    @Schema(examples = "12345678", required = true)
    @NotBlank
    public String password;
}