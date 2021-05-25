package okhttp3;

import kotlin.Metadata;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"okhttp3/ResponseBody$Companion$asResponseBody$1", "Lokhttp3/ResponseBody;", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "", "contentLength", "()J", "Lokio/BufferedSource;", "source", "()Lokio/BufferedSource;", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class ResponseBody$Companion$asResponseBody$1 extends ResponseBody {
    public final /* synthetic */ long $contentLength;
    public final /* synthetic */ MediaType $contentType;
    public final /* synthetic */ BufferedSource $this_asResponseBody;

    public ResponseBody$Companion$asResponseBody$1(BufferedSource bufferedSource, MediaType mediaType, long j) {
        this.$this_asResponseBody = bufferedSource;
        this.$contentType = mediaType;
        this.$contentLength = j;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.$contentLength;
    }

    @Override // okhttp3.ResponseBody
    @Nullable
    public MediaType contentType() {
        return this.$contentType;
    }

    @Override // okhttp3.ResponseBody
    @NotNull
    public BufferedSource source() {
        return this.$this_asResponseBody;
    }
}
