package net.gotev.uploadservice.network;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import net.gotev.uploadservice.data.NameValue;
import net.gotev.uploadservice.network.BodyWriter;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0014J\u001d\u0010\u0005\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lnet/gotev/uploadservice/network/HttpRequest;", "Ljava/io/Closeable;", "", "Lnet/gotev/uploadservice/data/NameValue;", "requestHeaders", "setHeaders", "(Ljava/util/List;)Lnet/gotev/uploadservice/network/HttpRequest;", "", "totalBodyBytes", "", "isFixedLengthStreamingMode", "setTotalBodyBytes", "(JZ)Lnet/gotev/uploadservice/network/HttpRequest;", "Lnet/gotev/uploadservice/network/HttpRequest$RequestBodyDelegate;", "delegate", "Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lnet/gotev/uploadservice/network/ServerResponse;", "getResponse", "(Lnet/gotev/uploadservice/network/HttpRequest$RequestBodyDelegate;Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;)Lnet/gotev/uploadservice/network/ServerResponse;", "RequestBodyDelegate", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public interface HttpRequest extends Closeable {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lnet/gotev/uploadservice/network/HttpRequest$RequestBodyDelegate;", "", "Lnet/gotev/uploadservice/network/BodyWriter;", "bodyWriter", "", "onWriteRequestBody", "(Lnet/gotev/uploadservice/network/BodyWriter;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public interface RequestBodyDelegate {
        void onWriteRequestBody(@NotNull BodyWriter bodyWriter) throws IOException;
    }

    @NotNull
    ServerResponse getResponse(@NotNull RequestBodyDelegate requestBodyDelegate, @NotNull BodyWriter.OnStreamWriteListener onStreamWriteListener) throws IOException;

    @NotNull
    HttpRequest setHeaders(@NotNull List<NameValue> list) throws IOException;

    @NotNull
    HttpRequest setTotalBodyBytes(long j, boolean z);
}
