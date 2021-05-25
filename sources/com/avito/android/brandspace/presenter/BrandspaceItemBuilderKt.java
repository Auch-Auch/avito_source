package com.avito.android.brandspace.presenter;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/Image;", "", "isValid", "(Lcom/avito/android/remote/model/Image;)Z", "brandspace_release"}, k = 2, mv = {1, 4, 2})
public final class BrandspaceItemBuilderKt {
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isValid(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.Image r3) {
        /*
            java.lang.String r0 = "$this$isValid"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Map r0 = r3.getVariants()
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            r2 = 0
            if (r0 == 0) goto L_0x0043
            java.util.Map r3 = r3.getVariants()
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L_0x001e
        L_0x001c:
            r3 = 0
            goto L_0x0040
        L_0x001e:
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0026:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x001c
            java.lang.Object r0 = r3.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r0 = r0.getValue()
            android.net.Uri r0 = (android.net.Uri) r0
            boolean r0 = com.avito.android.util.Uris.isNullOrEmpty(r0)
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0026
            r3 = 1
        L_0x0040:
            if (r3 == 0) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            r1 = 0
        L_0x0044:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.presenter.BrandspaceItemBuilderKt.isValid(com.avito.android.remote.model.Image):boolean");
    }
}
