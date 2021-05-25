package a2.j.b.e.a.b;

import com.google.android.play.core.assetpacks.dd;
public final /* synthetic */ class a1 implements h1 {
    public final i1 a;
    public final int b;

    public a1(i1 i1Var, int i) {
        this.a = i1Var;
        this.b = i;
    }

    @Override // a2.j.b.e.a.b.h1
    public final Object a() {
        i1 i1Var = this.a;
        int i = this.b;
        f1 c = i1Var.c(i);
        if (dd.b(c.c.c)) {
            a0 a0Var = i1Var.a;
            e1 e1Var = c.c;
            String str = e1Var.a;
            int i2 = c.b;
            long j = e1Var.b;
            if (a0Var.w(str, i2, j).exists()) {
                a0.n(a0Var.w(str, i2, j));
            }
            e1 e1Var2 = c.c;
            int i3 = e1Var2.c;
            if (i3 != 5 && i3 != 6) {
                return null;
            }
            i1Var.a.q(e1Var2.a);
            return null;
        }
        throw new q0(String.format("Could not safely delete session %d because it is not in a terminal state.", Integer.valueOf(i)), i);
    }
}
