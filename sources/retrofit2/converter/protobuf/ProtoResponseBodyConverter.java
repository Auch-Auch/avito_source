package retrofit2.converter.protobuf;

import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Converter;
public final class ProtoResponseBodyConverter<T extends MessageLite> implements Converter<ResponseBody, T> {
    private final Parser<T> parser;
    @Nullable
    private final ExtensionRegistryLite registry;

    public ProtoResponseBodyConverter(Parser<T> parser2, @Nullable ExtensionRegistryLite extensionRegistryLite) {
        this.parser = parser2;
        this.registry = extensionRegistryLite;
    }

    public T convert(ResponseBody responseBody) throws IOException {
        T t;
        try {
            if (this.registry == null) {
                t = this.parser.parseFrom(responseBody.byteStream());
            } else {
                t = this.parser.parseFrom(responseBody.byteStream(), this.registry);
            }
            responseBody.close();
            return t;
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            responseBody.close();
            throw th;
        }
    }
}
