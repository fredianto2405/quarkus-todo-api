package id.my.freddylabs.dto.response;

public class PaginationResponse<T> {

    public boolean success;
    public String message;
    public T data;
    public MetaResponse meta;

    public PaginationResponse(
            boolean success,
            String message,
            T data,
            MetaResponse meta
    ) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.meta = meta;
    }
}
