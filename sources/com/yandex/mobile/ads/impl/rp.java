package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.impl.hv;
import java.util.Collections;
import java.util.List;
public final class rp {
    @NonNull
    private final ht a;
    @NonNull
    private final List<oq> b;
    @NonNull
    private final b c;
    @Nullable
    private final String d;
    @Nullable
    private hv.a e;

    public rp(@NonNull Context context, @NonNull b bVar, @Nullable String str, @Nullable List<oq> list) {
        this.c = bVar;
        this.d = str;
        this.a = ht.a(context);
        this.b = list == null ? Collections.emptyList() : list;
    }

    public final void a(@NonNull hv.a aVar) {
        this.e = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        if (((r1 == null || !(r1.c() instanceof com.yandex.mobile.ads.impl.ow) || ((com.yandex.mobile.ads.impl.ow) r1.c()).a() == null) ? false : true) != false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(@android.support.annotation.NonNull com.yandex.mobile.ads.nativeads.ag r6) {
        /*
            r5 = this;
            com.yandex.mobile.ads.nativeads.al r6 = r6.d()
            com.yandex.mobile.ads.nativeads.MediaView r6 = r6.k()
            java.util.List<com.yandex.mobile.ads.impl.oq> r0 = r5.b
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x000f:
            boolean r2 = r0.hasNext()
            java.lang.String r3 = "media"
            if (r2 == 0) goto L_0x0029
            java.lang.Object r2 = r0.next()
            com.yandex.mobile.ads.impl.oq r2 = (com.yandex.mobile.ads.impl.oq) r2
            java.lang.String r4 = r2.a()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x000f
            r1 = r2
            goto L_0x000f
        L_0x0029:
            r0 = 1
            r2 = 0
            if (r6 != 0) goto L_0x0049
            if (r1 == 0) goto L_0x0045
            java.lang.Object r6 = r1.c()
            boolean r6 = r6 instanceof com.yandex.mobile.ads.impl.ow
            if (r6 == 0) goto L_0x0045
            java.lang.Object r6 = r1.c()
            com.yandex.mobile.ads.impl.ow r6 = (com.yandex.mobile.ads.impl.ow) r6
            com.yandex.mobile.ads.impl.ov r6 = r6.a()
            if (r6 == 0) goto L_0x0045
            r6 = 1
            goto L_0x0046
        L_0x0045:
            r6 = 0
        L_0x0046:
            if (r6 == 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r0 = 0
        L_0x004a:
            if (r0 == 0) goto L_0x008d
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            com.yandex.mobile.ads.b r0 = r5.c
            java.lang.String r0 = r0.a()
            java.lang.String r1 = "ad_type"
            r6.put(r1, r0)
            java.lang.String r0 = r5.d
            java.lang.String r1 = "block_id"
            r6.put(r1, r0)
            java.lang.String r0 = "reason"
            java.lang.String r1 = "expected_view_missing"
            r6.put(r0, r1)
            java.lang.String r0 = "view"
            java.lang.String r1 = "mediaview"
            r6.put(r0, r1)
            java.lang.String r0 = "asset_name"
            r6.put(r0, r3)
            com.yandex.mobile.ads.impl.hv$a r0 = r5.e
            if (r0 == 0) goto L_0x0081
            java.util.Map r0 = r0.a()
            r6.putAll(r0)
        L_0x0081:
            com.yandex.mobile.ads.impl.hv r0 = new com.yandex.mobile.ads.impl.hv
            com.yandex.mobile.ads.impl.hv$b r1 = com.yandex.mobile.ads.impl.hv.b.BINDING_FAILURE
            r0.<init>(r1, r6)
            com.yandex.mobile.ads.impl.ht r6 = r5.a
            r6.a(r0)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.rp.a(com.yandex.mobile.ads.nativeads.ag):void");
    }
}
