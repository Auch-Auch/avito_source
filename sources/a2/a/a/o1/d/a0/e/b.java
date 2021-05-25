package a2.a.a.o1.d.a0.e;

import java.io.File;
import java.util.concurrent.Callable;
public final class b<V> implements Callable<Object> {
    public final /* synthetic */ e a;
    public final /* synthetic */ File b;

    public b(e eVar, File file) {
        this.a = eVar;
        this.b = file;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0067, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006b, code lost:
        throw r2;
     */
    @Override // java.util.concurrent.Callable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object call() {
        /*
            r5 = this;
            a2.a.a.o1.d.a0.e.e r0 = r5.a
            okhttp3.Call r0 = r0.b
            okhttp3.Response r0 = r0.execute()
            boolean r1 = r0.isSuccessful()     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0047
            okhttp3.ResponseBody r1 = r0.body()     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0047
            java.io.File r1 = r5.b     // Catch:{ all -> 0x0065 }
            java.lang.String r2 = "cacheFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x0065 }
            r2 = 0
            r3 = 1
            r4 = 0
            okio.Sink r1 = okio.Okio.sink$default(r1, r2, r3, r4)     // Catch:{ all -> 0x0065 }
            okio.BufferedSink r1 = okio.Okio.buffer(r1)     // Catch:{ all -> 0x0065 }
            okhttp3.ResponseBody r2 = r0.body()     // Catch:{ all -> 0x0040 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x0040 }
            okio.BufferedSource r2 = r2.source()     // Catch:{ all -> 0x0040 }
            long r2 = r1.writeAll(r2)     // Catch:{ all -> 0x0040 }
            kotlin.io.CloseableKt.closeFinally(r1, r4)
            java.lang.Long r1 = java.lang.Long.valueOf(r2)
            kotlin.io.CloseableKt.closeFinally(r0, r4)
            return r1
        L_0x0040:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            throw r3
        L_0x0047:
            com.avito.android.messenger.conversation.mvi.file_download.FileDownloadException$DownloadFailed r1 = new com.avito.android.messenger.conversation.mvi.file_download.FileDownloadException$DownloadFailed
            a2.a.a.o1.d.a0.e.e r2 = r5.a
            a2.a.a.o1.d.a0.e.f r3 = r2.a
            java.lang.String r3 = r3.e
            okhttp3.Call r2 = r2.b
            okhttp3.Request r2 = r2.request()
            okhttp3.Headers r2 = r2.headers()
            java.util.Map r2 = r2.toMultimap()
            java.lang.String r2 = r2.toString()
            r1.<init>(r3, r2, r0)
            throw r1
        L_0x0065:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.a.o1.d.a0.e.b.call():java.lang.Object");
    }
}
