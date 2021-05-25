package a2.a.a.j.a;

import io.reactivex.functions.Action;
public final class f0 implements Action {
    public final /* synthetic */ g0 a;
    public final /* synthetic */ Throwable b;

    public f0(g0 g0Var, Throwable th) {
        this.a = g0Var;
        this.b = th;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        g0 g0Var = this.a;
        g0Var.a.a(g0Var.c, g0Var.b, g0Var.d.get(), this.b);
    }
}
