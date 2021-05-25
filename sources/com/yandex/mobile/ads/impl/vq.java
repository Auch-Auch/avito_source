package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.video.models.vmap.Vmap;
import java.util.HashMap;
public final class vq implements hw<to, Vmap> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.yandex.mobile.ads.impl.sa, int, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.hw
    public final /* synthetic */ hv a(@Nullable sa<Vmap> saVar, int i, @NonNull to toVar) {
        to toVar2 = toVar;
        HashMap hashMap = new HashMap();
        hashMap.put("page_id", toVar2.c());
        hashMap.put("category_id", toVar2.b());
        if (i != -1) {
            hashMap.put("code", Integer.valueOf(i));
        }
        return new hv(hv.b.VMAP_RESPONSE, hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.hw
    public final /* synthetic */ hv a(to toVar) {
        to toVar2 = toVar;
        HashMap hashMap = new HashMap();
        hashMap.put("page_id", toVar2.c());
        hashMap.put("category_id", toVar2.b());
        return new hv(hv.b.VMAP_REQUEST, hashMap);
    }
}
