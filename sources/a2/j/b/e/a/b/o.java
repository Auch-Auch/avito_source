package a2.j.b.e.a.b;

import android.os.Bundle;
import com.google.android.play.core.tasks.i;
public final class o extends k<Void> {
    public final int c;
    public final String d;
    public final int e;
    public final /* synthetic */ r f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(r rVar, i<Void> iVar, int i, String str, int i2) {
        super(rVar, iVar);
        this.f = rVar;
        this.c = i;
        this.d = str;
        this.e = i2;
    }

    @Override // a2.j.b.e.a.b.k, com.google.android.play.core.internal.u
    public final void a(Bundle bundle) {
        this.f.c.a();
        r.f.b("onError(%d), retrying notifyModuleCompleted...", Integer.valueOf(bundle.getInt("error_code")));
        int i = this.e;
        if (i > 0) {
            this.f.f(this.c, this.d, i - 1);
        }
    }
}
