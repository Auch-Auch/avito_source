package a2.t.a.c.n0;

import com.voximplant.sdk.internal.call.Call;
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ Call.e a;

    public /* synthetic */ m(Call.e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Call.e eVar = this.a;
        Call.this.b.e(new v1(eVar), null, false);
    }
}
