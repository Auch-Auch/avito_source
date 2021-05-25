package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
public final class gn {
    @NonNull
    private final fo a;
    @NonNull
    private final List<gl> b = new CopyOnWriteArrayList();

    public interface a {
        void a();

        void a(@NonNull String str);
    }

    public gn(@NonNull fo foVar) {
        this.a = foVar;
    }

    public final void a(@NonNull gm gmVar, @NonNull final a aVar) {
        AnonymousClass1 r0 = new gl() { // from class: com.yandex.mobile.ads.impl.gn.1
            @Override // com.yandex.mobile.ads.impl.gl
            public final void a(@NonNull Map<String, String> map) {
                gn.this.b.remove(this);
                gn.a(gn.this, map);
                aVar.a();
            }

            @Override // com.yandex.mobile.ads.impl.gl
            public final void a(@NonNull String str) {
                gn.this.b.remove(this);
                aVar.a(str);
            }
        };
        this.b.add(r0);
        gmVar.a(r0);
    }

    public final void a(@NonNull gm gmVar) {
        for (gl glVar : this.b) {
            gmVar.b(glVar);
        }
    }

    public static /* synthetic */ void a(gn gnVar, Map map) {
        gnVar.a.a((String) map.get("yandex_mobile_metrica_uuid"));
        gnVar.a.c((String) map.get("yandex_mobile_metrica_get_ad_url"));
        gnVar.a.d((String) map.get("yandex_mobile_metrica_device_id"));
    }
}
