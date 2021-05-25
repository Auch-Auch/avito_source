package a2.a.a.f1.e;

import java.io.File;
import java.util.concurrent.Callable;
public final class a<V> implements Callable<File> {
    public final /* synthetic */ File a;

    public a(File file) {
        this.a = file;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005f, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        throw r1;
     */
    @Override // java.util.concurrent.Callable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.File call() {
        /*
            r6 = this;
            java.io.File r0 = r6.a
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = ".gz"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = t6.y.m.endsWith$default(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L_0x0019
            java.io.File r0 = r6.a
            goto L_0x005b
        L_0x0019:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.io.File r5 = r6.a
            java.lang.String r5 = r5.getPath()
            r3.append(r5)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            r0.createNewFile()
            r0.deleteOnExit()
            r1 = 1
            okio.Sink r1 = okio.Okio.sink$default(r0, r2, r1, r4)
            okio.GzipSink r2 = new okio.GzipSink
            r2.<init>(r1)
            java.io.File r1 = r6.a     // Catch:{ all -> 0x0063 }
            okio.Source r1 = okio.Okio.source(r1)     // Catch:{ all -> 0x0063 }
            okio.BufferedSource r1 = okio.Okio.buffer(r1)     // Catch:{ all -> 0x0063 }
            r1.readAll(r2)     // Catch:{ all -> 0x005c }
            kotlin.io.CloseableKt.closeFinally(r1, r4)
            kotlin.io.CloseableKt.closeFinally(r2, r4)
            java.io.File r1 = r6.a
            r1.delete()
        L_0x005b:
            return r0
        L_0x005c:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x005e }
        L_0x005e:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            throw r3
        L_0x0063:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.a.f1.e.a.call():java.lang.Object");
    }
}
