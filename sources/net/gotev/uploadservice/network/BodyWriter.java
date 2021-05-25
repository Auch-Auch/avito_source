package net.gotev.uploadservice.network;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lnet/gotev/uploadservice/network/BodyWriter;", "Ljava/io/Closeable;", "Ljava/io/InputStream;", "stream", "", "writeStream", "(Ljava/io/InputStream;)V", "", "bytes", "write", "([B)V", "", "lengthToWriteFromStart", "([BI)V", "internalWrite", "flush", "()V", "Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;", AuthSource.SEND_ABUSE, "Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;)V", "OnStreamWriteListener", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public abstract class BodyWriter implements Closeable {
    public final OnStreamWriteListener a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;", "", "", "shouldContinueWriting", "()Z", "", "bytesWritten", "", "onBytesWritten", "(I)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public interface OnStreamWriteListener {
        void onBytesWritten(int i);

        boolean shouldContinueWriting();
    }

    public BodyWriter(@NotNull OnStreamWriteListener onStreamWriteListener) {
        Intrinsics.checkNotNullParameter(onStreamWriteListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = onStreamWriteListener;
    }

    public abstract void flush() throws IOException;

    public abstract void internalWrite(@NotNull byte[] bArr) throws IOException;

    public abstract void internalWrite(@NotNull byte[] bArr, int i) throws IOException;

    public final void write(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        internalWrite(bArr);
        flush();
        this.a.onBytesWritten(bArr.length);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeStream(@org.jetbrains.annotations.NotNull java.io.InputStream r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "stream"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = net.gotev.uploadservice.UploadServiceConfig.getBufferSizeBytes()
            byte[] r1 = new byte[r0]
        L_0x000b:
            net.gotev.uploadservice.network.BodyWriter$OnStreamWriteListener r2 = r3.a     // Catch:{ all -> 0x0024 }
            boolean r2 = r2.shouldContinueWriting()     // Catch:{ all -> 0x0024 }
            if (r2 == 0) goto L_0x001f
            r2 = 0
            int r2 = r4.read(r1, r2, r0)     // Catch:{ all -> 0x0024 }
            if (r2 > 0) goto L_0x001b
            goto L_0x001f
        L_0x001b:
            r3.write(r1, r2)     // Catch:{ all -> 0x0024 }
            goto L_0x000b
        L_0x001f:
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            return
        L_0x0024:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.network.BodyWriter.writeStream(java.io.InputStream):void");
    }

    public final void write(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        internalWrite(bArr, i);
        flush();
        this.a.onBytesWritten(i);
    }
}
