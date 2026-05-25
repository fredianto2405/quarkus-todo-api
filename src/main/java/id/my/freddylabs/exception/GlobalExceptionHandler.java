package id.my.freddylabs.exception;

import id.my.freddylabs.dto.response.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {

        if (exception instanceof BusinessException ex) {

            return Response.status(ex.getStatusCode())
                    .entity(new ApiResponse<>(
                            false,
                            ex.getMessage(),
                            null
                    ))
                    .build();
        }

        if (exception instanceof ConstraintViolationException ex) {

            return Response.status(400)
                    .entity(new ApiResponse<>(
                            false,
                            ex.getMessage(),
                            null
                    ))
                    .build();
        }

        return Response.status(500)
                .entity(new ApiResponse<>(
                        false,
                        "Internal server error",
                        null
                ))
                .build();
    }
}
