package id.my.freddylabs.dto.todo;

import jakarta.validation.constraints.NotBlank;

public class TodoRequest {

    @NotBlank
    public String title;

    public String description;
}