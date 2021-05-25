package com.avito.android.analytics.clickstream;

import com.avito.android.analytics.inhouse_transport.DiskStorageConverter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.google.protobuf.MessageLite;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/analytics/clickstream/ProtobufDiskConverter;", "Lcom/google/protobuf/MessageLite;", "T", "Lcom/avito/android/analytics/inhouse_transport/DiskStorageConverter;", "", "bytes", "from", "([B)Lcom/google/protobuf/MessageLite;", "item", "Ljava/io/OutputStream;", "output", "", "toStream", "(Lcom/google/protobuf/MessageLite;Ljava/io/OutputStream;)V", "Lcom/google/protobuf/MessageLite$Builder;", AuthSource.SEND_ABUSE, "Lcom/google/protobuf/MessageLite$Builder;", "builder", "<init>", "(Lcom/google/protobuf/MessageLite$Builder;)V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public abstract class ProtobufDiskConverter<T extends MessageLite> implements DiskStorageConverter<T> {
    public final MessageLite.Builder a;

    public ProtobufDiskConverter(@NotNull MessageLite.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.a = builder;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.analytics.clickstream.ProtobufDiskConverter<T extends com.google.protobuf.MessageLite> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.tape2.ObjectQueue.Converter
    public /* bridge */ /* synthetic */ void toStream(Object obj, OutputStream outputStream) {
        toStream((ProtobufDiskConverter<T>) ((MessageLite) obj), outputStream);
    }

    @Override // com.squareup.tape2.ObjectQueue.Converter
    @Nullable
    public T from(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        try {
            return (T) this.a.clone().mergeFrom(bArr).build();
        } catch (Exception e) {
            Logs.error(ClickStreamEventTrackerKt.CS_LOG_TAG, "deserialization error", e);
            return null;
        }
    }

    public void toStream(@NotNull T t, @NotNull OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(t, "item");
        Intrinsics.checkNotNullParameter(outputStream, "output");
        t.writeTo(outputStream);
    }
}
