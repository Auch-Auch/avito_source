package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.yandex.mobile.ads.nativeads.ag;
import com.yandex.mobile.ads.nativeads.be;
import java.util.List;
public final class nu {
    @NonNull
    private final oa a = new oa();
    @NonNull
    private final nx b;
    @NonNull
    private final nv c;
    @NonNull
    private final Handler d;

    public class a implements Runnable {
        @NonNull
        private final ag b;

        public a(ag agVar) {
            this.b = agVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View c = this.b.c();
            if (c instanceof FrameLayout) {
                nu.this.c.a(nu.this.b.a(c.getContext()), (FrameLayout) c);
                nu.this.d.postDelayed(new a(this.b), 300);
            }
        }
    }

    public nu(@NonNull be beVar, @NonNull List<bo> list) {
        this.b = ny.a(beVar, list);
        this.c = new nv();
        this.d = new Handler(Looper.getMainLooper());
    }

    public final void a() {
        this.d.removeCallbacksAndMessages(null);
    }

    public final void a(@NonNull ag agVar) {
        a();
        View c2 = agVar.c();
        if (c2 instanceof FrameLayout) {
            nw.a((FrameLayout) c2);
        }
    }

    public final void a(@NonNull Context context, @NonNull ag agVar) {
        boolean z;
        fy a3 = fy.a();
        fz a4 = a3.a(context);
        Boolean n = a4 != null ? a4.n() : null;
        boolean d2 = a3.d();
        if (n != null) {
            z = n.booleanValue();
        } else {
            z = d2 && id.a(context);
        }
        if (z) {
            this.d.post(new a(agVar));
        }
    }
}
