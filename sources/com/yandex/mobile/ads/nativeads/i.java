package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.dy;
import com.yandex.mobile.ads.impl.oq;
import com.yandex.mobile.ads.impl.os;
import com.yandex.mobile.ads.impl.ot;
import com.yandex.mobile.ads.impl.ox;
import com.yandex.mobile.ads.impl.pl;
import com.yandex.mobile.ads.impl.qr;
import com.yandex.mobile.ads.impl.qv;
import com.yandex.mobile.ads.impl.qz;
import com.yandex.mobile.ads.impl.sl;
import com.yandex.mobile.ads.impl.ss;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
public final class i {
    @NonNull
    private final qv a = new qv();
    @NonNull
    private final qz b;
    @NonNull
    private final qr c;
    @NonNull
    private final ss d;
    @NonNull
    private final pl.b e;

    public i(Context context) {
        this.b = new qz(context);
        this.c = new qr();
        pl a3 = pl.a(context);
        this.d = a3.b();
        this.e = a3.a();
    }

    public final void a(@NonNull Set<ot> set, @NonNull k kVar) {
        if (set.size() == 0) {
            kVar.a(Collections.emptyMap());
        } else {
            new a(this.d, set, kVar).a();
        }
    }

    public static class a {
        @NonNull
        private final Handler a = new Handler(Looper.getMainLooper());
        @NonNull
        private final ss b;
        @NonNull
        private final AtomicInteger c;
        @NonNull
        private final Set<ot> d;
        @NonNull
        private final k e;
        @NonNull
        private final dy f;

        public a(@NonNull ss ssVar, @NonNull Set<ot> set, @NonNull k kVar) {
            this.b = ssVar;
            this.d = set;
            this.e = kVar;
            this.c = new AtomicInteger(set.size());
            this.f = new dy();
        }

        public final void a() {
            final HashMap hashMap = new HashMap();
            for (final ot otVar : this.d) {
                final String c2 = otVar.c();
                final int b2 = otVar.b();
                final int a3 = otVar.a();
                int b3 = otVar.b();
                int a4 = otVar.a();
                Runtime runtime = Runtime.getRuntime();
                if (((float) Runtime.getRuntime().maxMemory()) - (((float) runtime.totalMemory()) - ((float) runtime.freeMemory())) >= ((float) ((b3 * a4) * 4)) + 1048576.0f) {
                    this.a.post(new Runnable() { // from class: com.yandex.mobile.ads.nativeads.i.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.b.a(c2, new ss.d() { // from class: com.yandex.mobile.ads.nativeads.i.a.1.1
                                @Override // com.yandex.mobile.ads.impl.sa.a
                                public final void a(@NonNull sl slVar) {
                                    AnonymousClass1 r2 = AnonymousClass1.this;
                                    a.this.a(hashMap);
                                }

                                @Override // com.yandex.mobile.ads.impl.ss.d
                                public final void a(ss.c cVar) {
                                    String c3 = otVar.c();
                                    Bitmap a5 = cVar.a();
                                    if (a5 != null) {
                                        if (c3 != null) {
                                            hashMap.put(c3, a5);
                                        }
                                        AnonymousClass1 r3 = AnonymousClass1.this;
                                        a.this.a(hashMap);
                                    }
                                }
                            }, a3, b2);
                        }
                    });
                } else {
                    a(hashMap);
                }
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void a(@NonNull Map<String, Bitmap> map) {
            if (this.c.decrementAndGet() == 0) {
                this.e.a(map);
            }
        }
    }

    public final void a(@NonNull Map<String, Bitmap> map) {
        for (Map.Entry<String, Bitmap> entry : map.entrySet()) {
            String key = entry.getKey();
            Bitmap value = entry.getValue();
            if (value != null) {
                this.e.a(key, value);
            }
        }
    }

    @NonNull
    public final Set<ot> a(@NonNull List<ox> list) {
        ot a3;
        HashSet hashSet = new HashSet();
        for (ox oxVar : list) {
            hashSet.addAll(qr.a(oxVar));
            ArrayList arrayList = new ArrayList();
            oq b2 = oxVar.b("feedback");
            if (!(b2 == null || !(b2.c() instanceof os) || (a3 = ((os) b2.c()).a()) == null)) {
                arrayList.add(a3);
            }
            hashSet.addAll(arrayList);
            hashSet.addAll(this.b.a(oxVar));
        }
        return hashSet;
    }
}
