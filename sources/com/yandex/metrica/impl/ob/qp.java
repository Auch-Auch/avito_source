package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.op;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
public class qp implements r {
    public static final long a = TimeUnit.MINUTES.toMillis(1);
    @SuppressLint({"StaticFieldLeak"})
    private static volatile qp b;
    private static final Object c = new Object();
    @NonNull
    private final WeakHashMap<Object, Object> d;
    private boolean e;
    @Nullable
    private ql f;
    @NonNull
    private yb g;
    @Nullable
    private rg h;
    @NonNull
    private a i;
    private Runnable j;
    @NonNull
    private final po k;
    @NonNull
    private final lz l;
    @NonNull
    private final ly m;
    @NonNull
    private final su n;
    private boolean o;
    private final Object p;
    private final Object q;

    public static class a {
        @NonNull
        public rg a(@NonNull rh rhVar) {
            return new rg(rhVar);
        }
    }

    private qp(@NonNull Context context) {
        this(context, new qq(context), new a(), (yb) op.a.a(yb.class).a(context).a());
    }

    private void d() {
        rg rgVar = this.h;
        if (rgVar != null) {
            rgVar.e();
        }
        g();
    }

    private void e() {
        if (this.h == null) {
            synchronized (this.q) {
                this.h = this.i.a(rh.a(this.k, this.l, this.m, this.g, this.f));
            }
        }
        this.h.d();
        f();
        b();
    }

    private void f() {
        if (this.j == null) {
            this.j = new Runnable() { // from class: com.yandex.metrica.impl.ob.qp.2
                @Override // java.lang.Runnable
                public void run() {
                    rg rgVar = qp.this.h;
                    if (rgVar != null) {
                        rgVar.c();
                    }
                    qp.this.h();
                }
            };
            h();
        }
    }

    private void g() {
        Runnable runnable = this.j;
        if (runnable != null) {
            this.k.b.b(runnable);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h() {
        this.k.b.a(this.j, a);
    }

    public static qp a(Context context) {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new qp(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    private void b() {
        this.k.b.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.qp.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (qp.this.h != null) {
                        qp.this.h.a();
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void c() {
        if (this.o) {
            if (!this.e || this.d.isEmpty()) {
                d();
                this.o = false;
            }
        } else if (this.e && !this.d.isEmpty()) {
            e();
            this.o = true;
        }
    }

    public void b(@Nullable Object obj) {
        synchronized (this.p) {
            this.d.remove(obj);
            c();
        }
    }

    @VisibleForTesting
    public qp(@NonNull Context context, @NonNull qq qqVar, @NonNull a aVar, @NonNull yb ybVar) {
        this.e = false;
        this.o = false;
        this.p = new Object();
        this.q = new Object();
        this.k = new po(context, qqVar.a(), qqVar.e());
        this.l = qqVar.b();
        this.m = qqVar.c();
        this.n = qqVar.d();
        this.d = new WeakHashMap<>();
        this.i = aVar;
        this.g = ybVar;
    }

    public void a(@Nullable Object obj) {
        synchronized (this.p) {
            this.d.put(obj, null);
            c();
        }
    }

    @Nullable
    public Location a() {
        rg rgVar = this.h;
        if (rgVar == null) {
            return null;
        }
        return rgVar.b();
    }

    public static byte[] a(@Nullable Location location) {
        if (location != null) {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeValue(location);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                return marshall;
            } catch (Throwable unused) {
                obtain.recycle();
            }
        }
        return null;
    }

    public static Location a(@NonNull byte[] bArr) {
        if (bArr != null) {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                Location location = (Location) obtain.readValue(Location.class.getClassLoader());
                obtain.recycle();
                return location;
            } catch (Throwable unused) {
                obtain.recycle();
            }
        }
        return null;
    }

    public void a(boolean z) {
        synchronized (this.p) {
            if (this.e != z) {
                this.e = z;
                this.n.a(z);
                this.k.c.a(this.n.a());
                c();
            }
        }
    }

    public void a(@NonNull final yb ybVar, @Nullable ql qlVar) {
        synchronized (this.p) {
            this.g = ybVar;
            this.n.a(ybVar);
            this.k.c.a(this.n.a());
            this.k.b.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.qp.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (qp.this.q) {
                        if (qp.this.h != null) {
                            qp.this.h.a(ybVar);
                        }
                    }
                }
            });
            if (!dl.a(this.f, qlVar)) {
                a(qlVar);
            }
        }
    }

    public void a(@Nullable final ql qlVar) {
        synchronized (this.p) {
            this.f = qlVar;
        }
        this.k.b.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.qp.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (qp.this.q) {
                    if (qp.this.h != null) {
                        qp.this.h.a(qlVar);
                    }
                }
            }
        });
    }
}
