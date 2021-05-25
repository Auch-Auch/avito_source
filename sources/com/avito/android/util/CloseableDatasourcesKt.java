package com.avito.android.util;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Lcom/avito/android/remote/model/CloseableDataSource;", "", "readAllAndClose", "(Lcom/avito/android/remote/model/CloseableDataSource;)Ljava/util/List;", "konveyor_release"}, k = 2, mv = {1, 4, 2})
public final class CloseableDatasourcesKt {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        throw r1;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.util.List<T> readAllAndClose(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.CloseableDataSource<T> r4) {
        /*
            java.lang.String r0 = "$this$readAllAndClose"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0024 }
            int r1 = r4.getCount()     // Catch:{ all -> 0x0024 }
            r0.<init>(r1)     // Catch:{ all -> 0x0024 }
            r1 = 0
            int r2 = r4.getCount()     // Catch:{ all -> 0x0024 }
        L_0x0013:
            if (r1 >= r2) goto L_0x001f
            java.lang.Object r3 = r4.getItem(r1)     // Catch:{ all -> 0x0024 }
            r0.add(r3)     // Catch:{ all -> 0x0024 }
            int r1 = r1 + 1
            goto L_0x0013
        L_0x001f:
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r4, r1)
            return r0
        L_0x0024:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.CloseableDatasourcesKt.readAllAndClose(com.avito.android.remote.model.CloseableDataSource):java.util.List");
    }
}
