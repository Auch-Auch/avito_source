package com.my.target;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
public class iq {
    @NonNull
    public final cz a;
    @NonNull
    public final c b = new c(null);
    @NonNull
    public final ik c;
    public final boolean d;
    public final float e;
    public final long f;
    public boolean g;
    public boolean h;
    public long i = 0;
    @Nullable
    public b j;
    @Nullable
    public WeakReference<View> k;
    public boolean l = false;
    public boolean m;

    public static abstract class b {
        public void aa() {
        }

        public void g(boolean z) {
        }
    }

    public class c implements Runnable {
        public c(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            iq.this.b();
        }
    }

    public iq(@NonNull bx bxVar, @NonNull cz czVar, boolean z) {
        float bF = bxVar.bF();
        this.e = bxVar.bG() * 100.0f;
        this.f = (long) (bxVar.bH() * 1000.0f);
        this.a = czVar;
        this.d = z;
        this.c = bF == 1.0f ? ik.pQ : ik.J((int) (bF * 1000.0f));
    }

    public static iq a(@NonNull bx bxVar, @NonNull cz czVar) {
        return new iq(bxVar, czVar, true);
    }

    public static iq a(@NonNull bx bxVar, @NonNull cz czVar, boolean z) {
        return new iq(bxVar, czVar, z);
    }

    public static double l(@Nullable View view) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null || view.getAlpha() < 0.5f) {
            return 0.0d;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (height <= 0 || width <= 0) {
            return 0.0d;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return 0.0d;
        }
        return ((double) (rect.height() * rect.width())) / (((double) (width * height)) / 100.0d);
    }

    public void a(@Nullable b bVar) {
        this.j = bVar;
    }

    public void b() {
        WeakReference<View> weakReference = this.k;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            ae.a("ViewabilityTracker: tracking view disappeared");
            fj();
            return;
        }
        boolean z = l(view) >= ((double) this.e);
        if (this.l != z) {
            this.l = z;
            b bVar = this.j;
            if (bVar != null) {
                bVar.g(z);
            }
        }
        if (!this.g) {
            if (!this.l) {
                this.i = 0;
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.i == 0) {
                this.i = currentTimeMillis;
            }
            if (currentTimeMillis - this.i >= this.f) {
                if (this.d) {
                    fj();
                }
                this.g = true;
                im.a(this.a.K("show"), view.getContext());
                b bVar2 = this.j;
                if (bVar2 != null) {
                    bVar2.aa();
                }
            }
        }
    }

    public void fj() {
        this.l = false;
        this.m = false;
        this.c.e(this.b);
        this.k = null;
    }

    public void m(@NonNull View view) {
        if (this.m) {
            return;
        }
        if (!this.g || !this.d) {
            this.m = true;
            this.i = 0;
            this.k = new WeakReference<>(view);
            if (!this.h) {
                im.a(this.a.K("render"), view.getContext());
                this.h = true;
            }
            b();
            if (!this.g || !this.d) {
                this.c.d(this.b);
            }
        }
    }
}
