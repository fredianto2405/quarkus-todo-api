package id.my.freddylabs.resource;

import id.my.freddylabs.dto.response.ApiResponse;
import id.my.freddylabs.dto.todo.TodoRequest;
import id.my.freddylabs.service.TodoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.UUID;

@Path("/api/todos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Todo")
@SecurityRequirement(name = "SecurityScheme")
public class TodoResource {

    @Inject
    TodoService todoService;

    @Inject
    JsonWebToken jwt;

    @POST
    @RolesAllowed("USER")
    @Operation(summary = "Create todo")
    public ApiResponse<?> create(
            @Valid TodoRequest request
    ) {

        UUID userId = UUID.fromString(
                jwt.getClaim("userId").toString()
        );

        todoService.create(userId, request);

        return new ApiResponse<>(
                true,
                "Todo created",
                null
        );
    }

    @GET
    @RolesAllowed("USER")
    @Operation(summary = "Get all todos")
    public ApiResponse<?> findAll() {

        UUID userId = UUID.fromString(
                jwt.getClaim("userId").toString()
        );

        return new ApiResponse<>(
                true,
                "Success",
                todoService.findAll(userId)
        );
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("USER")
    @Operation(summary = "Update todo")
    public ApiResponse<?> update(
            @PathParam("id") UUID id,
            @Valid TodoRequest request
    ) {

        UUID userId = UUID.fromString(
                jwt.getClaim("userId").toString()
        );

        todoService.update(
                id,
                userId,
                request
        );

        return new ApiResponse<>(
                true,
                "Todo updated",
                null
        );
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("USER")
    @Operation(summary = "Delete todo")
    public ApiResponse<?> delete(
            @PathParam("id") UUID id
    ) {

        UUID userId = UUID.fromString(
                jwt.getClaim("userId").toString()
        );

        todoService.delete(id, userId);

        return new ApiResponse<>(
                true,
                "Todo deleted",
                null
        );
    }
}