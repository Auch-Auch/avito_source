package com.google.android.play.core.tasks;

import a2.j.b.e.a.j.k;
import com.google.android.play.core.splitcompat.d;
import java.util.Objects;
public final class i<ResultT> {
    public final k<ResultT> a = new k<>();

    public final Task<ResultT> a() {
        return this.a;
    }

    public final void a(Exception exc) {
        this.a.a(exc);
    }

    public final void a(ResultT resultt) {
        this.a.b(resultt);
    }

    public final void b(Exception exc) {
        k<ResultT> kVar = this.a;
        Objects.requireNonNull(kVar);
        d.a(exc, "Exception must not be null");
        synchronized (kVar.a) {
            if (!kVar.c) {
                kVar.c = true;
                kVar.e = exc;
                kVar.b.a(kVar);
            }
        }
    }

    public final void b(ResultT resultt) {
        k<ResultT> kVar = this.a;
        synchronized (kVar.a) {
            if (!kVar.c) {
                kVar.c = true;
                kVar.d = resultt;
                kVar.b.a(kVar);
            }
        }
    }
}
