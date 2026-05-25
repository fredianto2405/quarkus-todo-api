package id.my.freddylabs.dto.response;

public class MetaResponse {

    public long total;
    public int page;
    public long pageCount;

    public MetaResponse(long total, int page, long pageCount) {
        this.total = total;
        this.page = page;
        this.pageCount = pageCount;
    }
}