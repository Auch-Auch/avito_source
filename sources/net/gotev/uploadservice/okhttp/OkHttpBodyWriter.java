package net.gotev.uploadservice.okhttp;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.network.BodyWriter;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lnet/gotev/uploadservice/okhttp/OkHttpBodyWriter;", "Lnet/gotev/uploadservice/network/BodyWriter;", "", "bytes", "", "internalWrite", "([B)V", "", "lengthToWriteFromStart", "([BI)V", "flush", "()V", "close", "Lokio/BufferedSink;", AuthSource.BOOKING_ORDER, "Lokio/BufferedSink;", "sink", "Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lokio/BufferedSink;Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;)V", "uploadservice-okhttp_release"}, k = 1, mv = {1, 4, 0})
public final class OkHttpBodyWriter extends BodyWriter {
    public final BufferedSink b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OkHttpBodyWriter(@NotNull BufferedSink bufferedSink, @NotNull BodyWriter.OnStreamWriteListener onStreamWriteListener) {
        super(onStreamWriteListener);
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        Intrinsics.checkNotNullParameter(onStreamWriteListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = bufferedSink;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    @Override // net.gotev.uploadservice.network.BodyWriter
    public void flush() throws IOException {
        this.b.flush();
    }

    @Override // net.gotev.uploadservice.network.BodyWriter
    public void internalWrite(@NotNull byte[] bArr) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        this.b.write(bArr);
    }

    @Override // net.gotev.uploadservice.network.BodyWriter
    public void internalWrite(@NotNull byte[] bArr, int i) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        this.b.write(bArr, 0, i);
    }
}
