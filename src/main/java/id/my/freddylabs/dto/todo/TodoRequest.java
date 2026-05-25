package id.my.freddylabs.dto.todo;

import jakarta.validation.constraints.NotBlank;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class TodoRequest {

    @Schema(examples = "Learn to play the game", required = true)
    @NotBlank
    public String title;

    @Schema(examples = "Lorem ipsum")
    public String description;
}