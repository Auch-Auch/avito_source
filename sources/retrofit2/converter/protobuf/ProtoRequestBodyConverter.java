package retrofit2.converter.protobuf;

import com.google.protobuf.MessageLite;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;
public final class ProtoRequestBodyConverter<T extends MessageLite> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.get("application/x-protobuf");

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: retrofit2.converter.protobuf.ProtoRequestBodyConverter<T extends com.google.protobuf.MessageLite> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ RequestBody convert(Object obj) throws IOException {
        return convert((ProtoRequestBodyConverter<T>) ((MessageLite) obj));
    }

    public RequestBody convert(T t) throws IOException {
        return RequestBody.create(MEDIA_TYPE, t.toByteArray());
    }
}
