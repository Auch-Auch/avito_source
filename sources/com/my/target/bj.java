package com.my.target;

import a2.l.a.k;
import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ads.MyTargetView;
import com.my.target.as;
import java.lang.ref.WeakReference;
public class bj {
    @NonNull
    public final MyTargetView a;
    @NonNull
    public final a b;
    @NonNull
    public final b c;
    @NonNull
    public final c d;
    @Nullable
    public as e;
    public boolean f = true;
    public boolean g;
    public int h = -1;
    public long i;
    public long j;

    public static class a implements as.a {
        @NonNull
        public final bj a;

        public a(@NonNull bj bjVar) {
            this.a = bjVar;
        }

        @Override // com.my.target.as.a
        public void aa() {
            bj bjVar = this.a;
            MyTargetView.MyTargetViewListener listener = bjVar.a.getListener();
            if (listener != null) {
                listener.onShow(bjVar.a);
            }
        }

        @Override // com.my.target.as.a
        public void ah() {
            bj bjVar = this.a;
            if (bjVar.c.c()) {
                bjVar.d();
            }
            bjVar.c.f = true;
        }

        @Override // com.my.target.as.a
        public void ai() {
            bj bjVar = this.a;
            b bVar = bjVar.c;
            bVar.f = false;
            if (bVar.b()) {
                bjVar.e();
            }
        }

        @Override // com.my.target.as.a
        public void aj() {
            this.a.b();
        }

        @Override // com.my.target.as.a
        public void onClick() {
            bj bjVar = this.a;
            MyTargetView.MyTargetViewListener listener = bjVar.a.getListener();
            if (listener != null) {
                listener.onClick(bjVar.a);
            }
        }

        @Override // com.my.target.as.a
        public void onLoad() {
            bj bjVar = this.a;
            if (bjVar.f) {
                bjVar.c.c = true;
                MyTargetView.MyTargetViewListener listener = bjVar.a.getListener();
                if (listener != null) {
                    listener.onLoad(bjVar.a);
                }
                bjVar.f = false;
            }
            if (bjVar.c.a()) {
                bjVar.f();
            }
        }

        @Override // com.my.target.as.a
        public void onNoAd(@NonNull String str) {
            bj bjVar = this.a;
            if (bjVar.f) {
                bjVar.c.c = false;
                MyTargetView.MyTargetViewListener listener = bjVar.a.getListener();
                if (listener != null) {
                    listener.onNoAd(str, bjVar.a);
                }
                bjVar.f = false;
                return;
            }
            bjVar.b();
            bjVar.c();
        }
    }

    public static class b {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;

        public boolean a() {
            return this.d && this.c && (this.g || this.e) && !this.a;
        }

        public boolean b() {
            return this.c && this.a && (this.g || this.e) && !this.f && this.b;
        }

        public boolean c() {
            return !this.b && this.a && (this.g || !this.e);
        }
    }

    public static class c implements Runnable {
        @NonNull
        public final WeakReference<bj> a;

        public c(@NonNull bj bjVar) {
            this.a = new WeakReference<>(bjVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            bj bjVar = this.a.get();
            if (bjVar != null) {
                ae.a("load new standard ad");
                ab.a(bjVar.b).a(new k(bjVar)).a(bjVar.a.getContext());
            }
        }
    }

    public bj(@NonNull MyTargetView myTargetView, @NonNull a aVar) {
        b bVar = new b();
        this.c = bVar;
        this.a = myTargetView;
        this.b = aVar;
        this.d = new c(this);
        if (!(myTargetView.getContext() instanceof Activity)) {
            ae.a("MyTargetView was created with non-activity focus, so system cannot automatically handle lifecycle");
            bVar.g = true;
            return;
        }
        bVar.g = false;
    }

    @NonNull
    public static bj a(@NonNull MyTargetView myTargetView, @NonNull a aVar) {
        return new bj(myTargetView, aVar);
    }

    public void a(@NonNull MyTargetView.AdSize adSize) {
        as asVar = this.e;
        if (asVar != null) {
            asVar.a(adSize);
        }
    }

    public void a(@NonNull cu cuVar) {
        if (this.c.a) {
            g();
        }
        b();
        boolean z = false;
        this.g = cuVar.cq() && this.b.isRefreshAd() && !this.b.getFormat().equals("standard_300x250");
        ck cr = cuVar.cr();
        if (cr == null) {
            cl bQ = cuVar.bQ();
            if (bQ == null) {
                MyTargetView.MyTargetViewListener listener = this.a.getListener();
                if (listener != null) {
                    listener.onNoAd("no ad", this.a);
                }
            } else {
                this.e = be.a(this.a, bQ, this.b);
                if (this.g) {
                    int bJ = bQ.bJ() * 1000;
                    this.h = bJ;
                    if (bJ > 0) {
                        z = true;
                    }
                    this.g = z;
                }
            }
        } else {
            this.e = bi.a(this.a, cr);
            this.h = cr.getTimeout() * 1000;
        }
        as asVar = this.e;
        if (asVar != null) {
            asVar.a(new a(this));
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = this.h;
            this.i = currentTimeMillis + ((long) i2);
            this.j = 0;
            if (this.g && this.c.b) {
                this.j = (long) i2;
            }
            this.e.prepare();
        }
    }

    @Nullable
    public String ad() {
        as asVar = this.e;
        if (asVar != null) {
            return asVar.ad();
        }
        return null;
    }

    public float ae() {
        as asVar = this.e;
        if (asVar != null) {
            return asVar.ae();
        }
        return 0.0f;
    }

    public void b() {
        as asVar = this.e;
        if (asVar != null) {
            asVar.destroy();
            this.e.a((as.a) null);
            this.e = null;
        }
        this.a.removeAllViews();
    }

    public void c() {
        if (this.g && this.h > 0) {
            this.a.removeCallbacks(this.d);
            this.a.postDelayed(this.d, (long) this.h);
        }
    }

    public void d() {
        this.a.removeCallbacks(this.d);
        if (this.g) {
            this.j = this.i - System.currentTimeMillis();
        }
        as asVar = this.e;
        if (asVar != null) {
            asVar.pause();
        }
        this.c.b = true;
    }

    public void destroy() {
        if (this.c.a) {
            g();
        }
        b bVar = this.c;
        bVar.f = false;
        bVar.c = false;
        b();
    }

    public void e() {
        if (this.j > 0 && this.g) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.j;
            this.i = currentTimeMillis + j2;
            this.a.postDelayed(this.d, j2);
            this.j = 0;
        }
        as asVar = this.e;
        if (asVar != null) {
            asVar.resume();
        }
        this.c.b = false;
    }

    public void f() {
        int i2 = this.h;
        if (i2 > 0 && this.g) {
            this.a.postDelayed(this.d, (long) i2);
        }
        as asVar = this.e;
        if (asVar != null) {
            asVar.start();
        }
        b bVar = this.c;
        bVar.a = true;
        bVar.b = false;
    }

    public void g() {
        b bVar = this.c;
        bVar.a = false;
        bVar.b = false;
        this.a.removeCallbacks(this.d);
        as asVar = this.e;
        if (asVar != null) {
            asVar.stop();
        }
    }

    public void j(boolean z) {
        b bVar = this.c;
        bVar.d = z;
        bVar.e = this.a.hasWindowFocus();
        if (this.c.a()) {
            f();
        } else if (!z && this.c.a) {
            g();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        b bVar = this.c;
        bVar.e = z;
        if (bVar.a()) {
            f();
        } else if (this.c.b()) {
            e();
        } else if (this.c.c()) {
            d();
        }
    }
}
