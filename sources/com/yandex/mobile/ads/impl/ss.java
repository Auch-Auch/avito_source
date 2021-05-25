package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import com.yandex.mobile.ads.impl.sa;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
public class ss {
    private final rz a;
    private int b = 100;
    private final b c;
    private final HashMap<String, a> d = new HashMap<>();
    private final HashMap<String, a> e = new HashMap<>();
    private final Handler f = new Handler(Looper.getMainLooper());
    private Runnable g;

    public interface b {
        Bitmap a(String str);

        void a(String str, Bitmap bitmap);
    }

    public interface d extends sa.a {
        void a(c cVar);
    }

    public ss(rz rzVar, b bVar) {
        this.a = rzVar;
        this.c = bVar;
    }

    public class a {
        private final ry<?> b;
        private Bitmap c;
        private sl d;
        private final LinkedList<c> e;

        public a(ry<?> ryVar, c cVar) {
            LinkedList<c> linkedList = new LinkedList<>();
            this.e = linkedList;
            this.b = ryVar;
            linkedList.add(cVar);
        }

        public final void a(sl slVar) {
            this.d = slVar;
        }

        public final sl a() {
            return this.d;
        }

        public final void a(c cVar) {
            this.e.add(cVar);
        }
    }

    public class c {
        private Bitmap b;
        private final d c;
        private final String d;
        private final String e;

        public c(Bitmap bitmap, String str, String str2, d dVar) {
            this.b = bitmap;
            this.e = str;
            this.d = str2;
            this.c = dVar;
        }

        public final Bitmap a() {
            return this.b;
        }
    }

    public c a(String str, d dVar, int i, int i2) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_INSIDE;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            final String a3 = a(str, i, i2, scaleType);
            Bitmap a4 = this.c.a(a3);
            if (a4 != null) {
                c cVar = new c(a4, str, null, null);
                dVar.a(cVar);
                return cVar;
            }
            c cVar2 = new c(null, str, a3, dVar);
            dVar.a(cVar2);
            a aVar = this.d.get(a3);
            if (aVar != null) {
                aVar.a(cVar2);
                return cVar2;
            }
            st stVar = new st(str, new sa.b<Bitmap>() { // from class: com.yandex.mobile.ads.impl.ss.1
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.yandex.mobile.ads.impl.sa.b
                public final /* bridge */ /* synthetic */ void a(Bitmap bitmap) {
                    ss.this.a(a3, bitmap);
                }
            }, i, i2, scaleType, Bitmap.Config.RGB_565, new sa.a() { // from class: com.yandex.mobile.ads.impl.ss.2
                @Override // com.yandex.mobile.ads.impl.sa.a
                public final void a(@NonNull sl slVar) {
                    ss.this.a(a3, slVar);
                }
            });
            this.a.a(stVar);
            this.d.put(a3, new a(stVar, cVar2));
            return cVar2;
        }
        throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
    }

    public final void a(String str, Bitmap bitmap) {
        this.c.a(str, bitmap);
        a remove = this.d.remove(str);
        if (remove != null) {
            remove.c = bitmap;
            a(str, remove);
        }
    }

    public final void a(String str, sl slVar) {
        a remove = this.d.remove(str);
        if (remove != null) {
            remove.a(slVar);
            a(str, remove);
        }
    }

    private void a(String str, a aVar) {
        this.e.put(str, aVar);
        if (this.g == null) {
            AnonymousClass3 r3 = new Runnable() { // from class: com.yandex.mobile.ads.impl.ss.3
                @Override // java.lang.Runnable
                public final void run() {
                    for (a aVar2 : ss.this.e.values()) {
                        Iterator it = aVar2.e.iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            if (cVar.c != null) {
                                if (aVar2.a() == null) {
                                    cVar.b = aVar2.c;
                                    cVar.c.a(cVar);
                                } else {
                                    cVar.c.a(aVar2.a());
                                }
                            }
                        }
                    }
                    ss.this.e.clear();
                    ss.this.g = null;
                }
            };
            this.g = r3;
            this.f.postDelayed(r3, (long) this.b);
        }
    }

    public String a(@NonNull String str, int i, int i2, @NonNull ImageView.ScaleType scaleType) {
        return "#W" + i + "#H" + i2 + "#S" + scaleType.ordinal() + str;
    }
}
