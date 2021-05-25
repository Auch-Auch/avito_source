package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.al;
import okhttp3.internal.connection.RealConnection;
public class ju {
    @NonNull
    private final fe a;
    @NonNull
    private final jt b;
    @NonNull
    private final a c;
    @NonNull
    private final am d;
    @NonNull
    private final jn<jp> e;
    @NonNull
    private final jn<jp> f;
    @Nullable
    private jo g;
    @Nullable
    private b h;

    /* renamed from: com.yandex.metrica.impl.ob.ju$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            b.values();
            int[] iArr = new int[3];
            a = iArr;
            try {
                b bVar = b.FOREGROUND;
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = a;
                b bVar2 = b.BACKGROUND;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = a;
                b bVar3 = b.EMPTY;
                iArr3[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface a {
        void a(@NonNull aa aaVar, @NonNull jv jvVar);
    }

    public enum b {
        EMPTY,
        BACKGROUND,
        FOREGROUND
    }

    public ju(@NonNull fe feVar, @NonNull jt jtVar, @NonNull a aVar) {
        this(feVar, jtVar, aVar, new jm(feVar, jtVar), new jl(feVar, jtVar), new am(feVar.k()));
    }

    @NonNull
    private jo f(@NonNull aa aaVar) {
        long r = aaVar.r();
        jo a3 = this.e.a(new jp(r, aaVar.s()));
        this.h = b.FOREGROUND;
        this.a.C().a();
        this.c.a(aa.a(aaVar, this.d), a(a3, r));
        return a3;
    }

    private void g(@NonNull aa aaVar) {
        if (this.h == null) {
            jo a3 = this.e.a();
            if (a(a3, aaVar)) {
                this.g = a3;
                this.h = b.FOREGROUND;
                return;
            }
            jo a4 = this.f.a();
            if (a(a4, aaVar)) {
                this.g = a4;
                this.h = b.BACKGROUND;
                return;
            }
            this.g = null;
            this.h = b.EMPTY;
        }
    }

    @Nullable
    private jo h(@NonNull aa aaVar) {
        if (this.h != null) {
            return this.g;
        }
        jo a3 = this.e.a();
        if (!b(a3, aaVar)) {
            return a3;
        }
        jo a4 = this.f.a();
        if (!b(a4, aaVar)) {
            return a4;
        }
        return null;
    }

    @NonNull
    private jo i(@NonNull aa aaVar) {
        this.h = b.BACKGROUND;
        long r = aaVar.r();
        jo a3 = this.f.a(new jp(r, aaVar.s()));
        if (this.a.u().d()) {
            this.c.a(aa.a(aaVar, this.d), a(a3, aaVar.r()));
        } else if (aaVar.g() == al.a.EVENT_TYPE_FIRST_ACTIVATION.a()) {
            this.c.a(aaVar, a(a3, r));
            this.c.a(aa.a(aaVar, this.d), a(a3, r));
        }
        return a3;
    }

    public synchronized void a(@NonNull aa aaVar) {
        g(aaVar);
        int i = AnonymousClass1.a[this.h.ordinal()];
        if (i != 1) {
            if (i == 2) {
                c(this.g, aaVar);
                this.g = f(aaVar);
            } else if (i == 3) {
                this.g = f(aaVar);
            }
        } else if (a(this.g, aaVar)) {
            this.g.b(aaVar.r());
        } else {
            this.g = f(aaVar);
        }
    }

    public synchronized void b(@NonNull aa aaVar) {
        c(aaVar).a(false);
        b bVar = this.h;
        b bVar2 = b.EMPTY;
        if (bVar != bVar2) {
            c(this.g, aaVar);
        }
        this.h = bVar2;
    }

    @NonNull
    public synchronized jo c(@NonNull aa aaVar) {
        g(aaVar);
        b bVar = this.h;
        b bVar2 = b.EMPTY;
        if (bVar != bVar2 && !a(this.g, aaVar)) {
            this.h = bVar2;
            this.g = null;
        }
        int i = AnonymousClass1.a[this.h.ordinal()];
        if (i == 1) {
            return this.g;
        } else if (i != 2) {
            jo i2 = i(aaVar);
            this.g = i2;
            return i2;
        } else {
            this.g.b(aaVar.r());
            return this.g;
        }
    }

    @NonNull
    public jv d(@NonNull aa aaVar) {
        return a(c(aaVar), aaVar.r());
    }

    @NonNull
    public jv e(@NonNull aa aaVar) {
        jo h2 = h(aaVar);
        if (h2 != null) {
            return new jv().a(h2.c()).b(h2.g()).c(h2.f()).a(h2.a());
        }
        return a(aaVar.s());
    }

    @VisibleForTesting
    public ju(@NonNull fe feVar, @NonNull jt jtVar, @NonNull a aVar, @NonNull jn<jp> jnVar, @NonNull jn<jp> jnVar2, @NonNull am amVar) {
        this.h = null;
        this.a = feVar;
        this.c = aVar;
        this.e = jnVar;
        this.f = jnVar2;
        this.b = jtVar;
        this.d = amVar;
    }

    private boolean b(@Nullable jo joVar, @NonNull aa aaVar) {
        if (joVar == null) {
            return false;
        }
        return joVar.a(aaVar.r());
    }

    public synchronized long a() {
        jo joVar;
        joVar = this.g;
        return joVar == null ? RealConnection.IDLE_CONNECTION_HEALTHY_NS : joVar.c() - 1;
    }

    private void c(@NonNull jo joVar, @Nullable aa aaVar) {
        if (joVar.h()) {
            this.c.a(aa.b(aaVar), a(joVar));
            joVar.a(false);
        }
        joVar.e();
    }

    @NonNull
    public jv a(long j) {
        long a3 = this.b.a();
        lr j2 = this.a.j();
        jy jyVar = jy.BACKGROUND;
        j2.a(a3, jyVar, j);
        return new jv().a(a3).a(jyVar).b(0).c(0);
    }

    private boolean a(@Nullable jo joVar, @NonNull aa aaVar) {
        if (joVar == null) {
            return false;
        }
        if (joVar.a(aaVar.r())) {
            return true;
        }
        c(joVar, aaVar);
        return false;
    }

    @NonNull
    private jv a(@NonNull jo joVar) {
        return new jv().a(joVar.c()).a(joVar.a()).b(joVar.g()).c(joVar.d());
    }

    @NonNull
    private jv a(@NonNull jo joVar, long j) {
        return new jv().a(joVar.c()).b(joVar.g()).c(joVar.c(j)).a(joVar.a());
    }
}
