package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.h;
public class rm implements qz {
    @NonNull
    private final Context a;
    @NonNull
    private yb b;
    @Nullable
    private ql c;
    @NonNull
    private final lz d;
    @NonNull
    private final ly e;
    @NonNull
    private final abt f;
    @NonNull
    private final sb g;
    @NonNull
    private final h h;
    @NonNull
    private final h.b i;
    @NonNull
    private final act j;
    private boolean k;

    public rm(@NonNull Context context, @NonNull yb ybVar, @Nullable ql qlVar, @NonNull lz lzVar, @NonNull ly lyVar, @NonNull act act) {
        this(context, ybVar, qlVar, lzVar, lyVar, act, new abs(), new sb(), as.a().j());
    }

    private void b() {
        if (!this.k) {
            this.h.a(h.a, this.j, this.i);
        } else {
            c();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        by r = as.a().r();
        ql qlVar = this.c;
        if (qlVar != null && r != null) {
            r.a(this.g.a(this.a, this.b, qlVar, this));
        }
    }

    private boolean d() {
        return a(this.d) || a(this.e);
    }

    private boolean a(lo loVar) {
        return this.c != null && (b(loVar) || c(loVar));
    }

    @VisibleForTesting
    public rm(@NonNull Context context, @NonNull yb ybVar, @Nullable ql qlVar, @NonNull lz lzVar, @NonNull ly lyVar, @NonNull act act, @NonNull abt abt, @NonNull sb sbVar, @NonNull h hVar) {
        this.k = false;
        this.a = context;
        this.c = qlVar;
        this.b = ybVar;
        this.d = lzVar;
        this.e = lyVar;
        this.j = act;
        this.f = abt;
        this.g = sbVar;
        this.h = hVar;
        this.i = new h.b() { // from class: com.yandex.metrica.impl.ob.rm.1
            @Override // com.yandex.metrica.impl.ob.h.b
            public void a() {
                rm.this.k = true;
                rm.this.c();
            }
        };
    }

    private boolean b(lo loVar) {
        ql qlVar = this.c;
        return qlVar != null && a(loVar, (long) qlVar.c);
    }

    private boolean a(lo loVar, long j2) {
        return loVar.a() >= j2;
    }

    private boolean c(lo loVar) {
        ql qlVar = this.c;
        return qlVar != null && b(loVar, qlVar.e);
    }

    private boolean b(lo loVar, long j2) {
        return this.f.a() - loVar.b() > j2;
    }

    public void a(@NonNull yb ybVar) {
        this.b = ybVar;
    }

    public void a(@Nullable ql qlVar) {
        this.c = qlVar;
    }

    @Override // com.yandex.metrica.impl.ob.qz
    public void a() {
        if (d()) {
            b();
        }
    }
}
