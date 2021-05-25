package a2.j.b.e.a.b;

import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ce;
import java.util.concurrent.atomic.AtomicBoolean;
public final class r0 {
    public static final aa j = new aa("ExtractorLooper");
    public final i1 a;
    public final p0 b;
    public final e2 c;
    public final t1 d;
    public final w1 e;
    public final y1 f;
    public final ce<q2> g;
    public final k1 h;
    public final AtomicBoolean i = new AtomicBoolean(false);

    public r0(i1 i1Var, ce<q2> ceVar, p0 p0Var, e2 e2Var, t1 t1Var, w1 w1Var, y1 y1Var, k1 k1Var) {
        this.a = i1Var;
        this.g = ceVar;
        this.b = p0Var;
        this.c = e2Var;
        this.d = t1Var;
        this.e = w1Var;
        this.f = y1Var;
        this.h = k1Var;
    }

    public final void a(int i2, Exception exc) {
        try {
            i1 i1Var = this.a;
            i1Var.a(new h1(i1Var, i2) { // from class: a2.j.b.e.a.b.z0
                public final i1 a;
                public final int b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // a2.j.b.e.a.b.h1
                public final Object a() {
                    this.a.c(this.b).c.c = 5;
                    return null;
                }
            });
            i1 i1Var2 = this.a;
            i1Var2.a(new a1(i1Var2, i2));
        } catch (q0 unused) {
            j.b("Error during error handling: %s", exc.getMessage());
        }
    }
}
