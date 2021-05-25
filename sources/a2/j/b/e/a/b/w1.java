package a2.j.b.e.a.b;

import com.google.android.play.core.assetpacks.dd;
import com.google.android.play.core.internal.ce;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
public final class w1 {
    public final a0 a;
    public final ce<q2> b;
    public final i1 c;
    public final ce<Executor> d;
    public final t0 e;

    public w1(a0 a0Var, ce<q2> ceVar, i1 i1Var, ce<Executor> ceVar2, t0 t0Var) {
        this.a = a0Var;
        this.b = ceVar;
        this.c = i1Var;
        this.d = ceVar2;
        this.e = t0Var;
    }

    public final void a(u1 u1Var) {
        File j = this.a.j(u1Var.b, u1Var.c, u1Var.d);
        a0 a0Var = this.a;
        String str = u1Var.b;
        int i = u1Var.c;
        long j2 = u1Var.d;
        Objects.requireNonNull(a0Var);
        File file = new File(new File(a0Var.w(str, i, j2), "_slices"), "_metadata");
        if (!j.exists() || !file.exists()) {
            throw new q0(String.format("Cannot find pack files to move for pack %s.", u1Var.b), u1Var.a);
        }
        File a3 = this.a.a(u1Var.b, u1Var.c, u1Var.d);
        a3.mkdirs();
        if (j.renameTo(a3)) {
            a0 a0Var2 = this.a;
            String str2 = u1Var.b;
            int i2 = u1Var.c;
            long j3 = u1Var.d;
            Objects.requireNonNull(a0Var2);
            File file2 = new File(a0Var2.a(str2, i2, j3), "_metadata");
            file2.mkdirs();
            if (file.renameTo(file2)) {
                a0 a0Var3 = this.a;
                a0Var3.getClass();
                this.d.a().execute(new Runnable(a0Var3) { // from class: a2.j.b.e.a.b.v1
                    public final a0 a;

                    {
                        this.a = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.m();
                    }
                });
                i1 i1Var = this.c;
                i1Var.a(new h1(i1Var, u1Var.b, u1Var.c, u1Var.d) { // from class: a2.j.b.e.a.b.x0
                    public final i1 a;
                    public final String b;
                    public final int c;
                    public final long d;

                    {
                        this.a = r1;
                        this.b = r2;
                        this.c = r3;
                        this.d = r4;
                    }

                    @Override // a2.j.b.e.a.b.h1
                    public final Object a() {
                        i1 i1Var2 = this.a;
                        String str3 = this.b;
                        int i3 = this.c;
                        long j4 = this.d;
                        Objects.requireNonNull(i1Var2);
                        f1 f1Var = (f1) ((Map) i1Var2.a(new y0(i1Var2, Arrays.asList(str3)))).get(str3);
                        if (f1Var == null || dd.b(f1Var.c.c)) {
                            i1.g.b(String.format("Could not find pack %s while trying to complete it", str3), new Object[0]);
                        }
                        a0 a0Var4 = i1Var2.a;
                        if (a0Var4.w(str3, i3, j4).exists()) {
                            a0.n(a0Var4.w(str3, i3, j4));
                        }
                        f1Var.c.c = 4;
                        return null;
                    }
                });
                this.e.a(u1Var.b);
                this.b.a().a(u1Var.a, u1Var.b);
                return;
            }
            throw new q0("Cannot move metadata files to final location.", u1Var.a);
        }
        throw new q0("Cannot move merged pack files to final location.", u1Var.a);
    }
}
