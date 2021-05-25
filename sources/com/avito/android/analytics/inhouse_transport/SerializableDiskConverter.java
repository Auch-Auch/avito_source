package com.avito.android.analytics.inhouse_transport;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/SerializableDiskConverter;", "T", "Lcom/avito/android/analytics/inhouse_transport/DiskStorageConverter;", "", "bytes", "from", "([B)Ljava/lang/Object;", "eventRecord", "Ljava/io/OutputStream;", "output", "", "toStream", "(Ljava/lang/Object;Ljava/io/OutputStream;)V", "<init>", "()V", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
public abstract class SerializableDiskConverter<T> implements DiskStorageConverter<T> {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r2 = move-exception;
     */
    @Override // com.squareup.tape2.ObjectQueue.Converter
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T from(@org.jetbrains.annotations.NotNull byte[] r4) {
        /*
            r3 = this;
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x0020 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0020 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0020 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0020 }
            java.lang.Object r4 = r1.readObject()     // Catch:{ all -> 0x0019 }
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            r0 = r4
            goto L_0x0028
        L_0x0019:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x001b }
        L_0x001b:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r4)
            throw r2
        L_0x0020:
            r4 = move-exception
            java.lang.String r1 = "AnalyticsTransport"
            java.lang.String r2 = "EventRecord deserialization error"
            com.avito.android.util.Logs.error(r1, r2, r4)
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.analytics.inhouse_transport.SerializableDiskConverter.from(byte[]):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    @Override // com.squareup.tape2.ObjectQueue.Converter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void toStream(T r2, @org.jetbrains.annotations.NotNull java.io.OutputStream r3) {
        /*
            r1 = this;
            java.lang.String r0 = "output"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream
            r0.<init>(r3)
            r0.writeObject(r2)     // Catch:{ all -> 0x0014 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0014 }
            r2 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            return
        L_0x0014:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0016 }
        L_0x0016:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.analytics.inhouse_transport.SerializableDiskConverter.toStream(java.lang.Object, java.io.OutputStream):void");
    }
}
