package a2.t.a.c.n0;

import com.voximplant.sdk.internal.call.Call;
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ Call.f a;

    public /* synthetic */ o(Call.f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Call.f fVar = this.a;
        Call.this.b.e(new w1(fVar), null, false);
    }
}
