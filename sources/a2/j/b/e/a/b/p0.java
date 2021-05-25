package a2.j.b.e.a.b;

import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ce;
import java.io.File;
public final class p0 {
    public static final aa f = new aa("ExtractChunkTaskHandler");
    public final byte[] a = new byte[8192];
    public final a0 b;
    public final ce<q2> c;
    public final ce<v> d;
    public final t0 e;

    public p0(a0 a0Var, ce<q2> ceVar, ce<v> ceVar2, t0 t0Var) {
        this.b = a0Var;
        this.c = ceVar;
        this.d = ceVar2;
        this.e = t0Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x02d6 A[SYNTHETIC, Splitter:B:102:0x02d6] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x038d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01b6 A[Catch:{ all -> 0x038e, all -> 0x0394 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(a2.j.b.e.a.b.o0 r23) {
        /*
        // Method dump skipped, instructions count: 980
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.e.a.b.p0.a(a2.j.b.e.a.b.o0):void");
    }

    public final File b(o0 o0Var) {
        File b2 = this.b.b(o0Var.b, o0Var.c, o0Var.d, o0Var.e);
        if (!b2.exists()) {
            b2.mkdirs();
        }
        return b2;
    }
}
