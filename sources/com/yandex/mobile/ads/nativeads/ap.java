package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.cv;
import com.yandex.mobile.ads.impl.fo;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.impl.ox;
import com.yandex.mobile.ads.nativeads.ba;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class ap implements hv.a {
    @NonNull
    private final fo a;
    @NonNull
    private final List<ox> b;
    @NonNull
    private final q c = new q();
    @NonNull
    private final cv d = new cv();
    @Nullable
    private String e;
    @Nullable
    private ba.a f;

    public ap(@NonNull List<ox> list, @NonNull fo foVar) {
        this.b = list;
        this.a = foVar;
    }

    public final void a(@NonNull ba.a aVar) {
        this.f = aVar;
    }

    public final void a(@NonNull String str) {
        this.e = str;
    }

    @Override // com.yandex.mobile.ads.impl.hv.a
    @NonNull
    public final Map<String, Object> a() {
        HashMap hashMap = new HashMap();
        ba.a aVar = this.f;
        if (aVar != null) {
            hashMap.put("bind_type", aVar.c);
        }
        String str = this.e;
        if (str != null) {
            hashMap.put("native_ad_type", str);
        }
        hashMap.putAll(cv.a(this.a.c()));
        List<String> a3 = q.a(this.b);
        if (a3.size() > 0) {
            hashMap.put("image_sizes", a3.toArray(new String[a3.size()]));
        }
        return hashMap;
    }
}
