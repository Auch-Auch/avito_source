package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.tb;
import com.yandex.mobile.ads.video.models.vmap.Vmap;
public final class uq extends tc<to, Vmap> {
    @NonNull
    private final vg a = new vg();
    @NonNull
    private final bu b = new bu();

    public uq(@NonNull Context context, @NonNull String str, @NonNull tb.a<Vmap> aVar, @NonNull to toVar, @NonNull hw<to, Vmap> hwVar) {
        super(context, 0, str, aVar, toVar, hwVar);
    }

    @NonNull
    private sa<Vmap> a(@NonNull String str, @NonNull rx rxVar) {
        try {
            Vmap a3 = this.a.a(str);
            if (a3 != null) {
                return sa.a(a3, null);
            }
            return b(rxVar);
        } catch (Exception e) {
            return sa.a(new tx(e));
        }
    }

    @NonNull
    private static sa<Vmap> b(@NonNull rx rxVar) {
        return sa.a(new sl(s.a(r.a(rxVar).a()).getDescription()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        if ((r5 == null || r5.length == 0) == false) goto L_0x0015;
     */
    @Override // com.yandex.mobile.ads.impl.tc
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.yandex.mobile.ads.impl.sa<com.yandex.mobile.ads.video.models.vmap.Vmap> a(@android.support.annotation.NonNull com.yandex.mobile.ads.impl.rx r4, int r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = 200(0xc8, float:2.8E-43)
            if (r2 != r5) goto L_0x0014
            byte[] r5 = r4.b
            if (r5 == 0) goto L_0x0010
            int r5 = r5.length
            if (r5 != 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r5 = 0
            goto L_0x0011
        L_0x0010:
            r5 = 1
        L_0x0011:
            if (r5 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x0032
            java.lang.String r5 = com.yandex.mobile.ads.impl.bu.a(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x0026
            com.yandex.mobile.ads.impl.sa r4 = r3.a(r5, r4)
            goto L_0x0036
        L_0x0026:
            com.yandex.mobile.ads.impl.tx r4 = new com.yandex.mobile.ads.impl.tx
            java.lang.String r5 = "Can't parse VMAP response"
            r4.<init>(r5)
            com.yandex.mobile.ads.impl.sa r4 = com.yandex.mobile.ads.impl.sa.a(r4)
            goto L_0x0036
        L_0x0032:
            com.yandex.mobile.ads.impl.sa r4 = b(r4)
        L_0x0036:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.uq.a(com.yandex.mobile.ads.impl.rx, int):com.yandex.mobile.ads.impl.sa");
    }
}
