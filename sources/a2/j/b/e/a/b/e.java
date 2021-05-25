package a2.j.b.e.a.b;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.List;
public final class e extends ab {
    public final /* synthetic */ List b;
    public final /* synthetic */ i c;
    public final /* synthetic */ x d;
    public final /* synthetic */ r e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(r rVar, i iVar, List list, i iVar2, x xVar) {
        super(iVar);
        this.e = rVar;
        this.b = list;
        this.c = iVar2;
        this.d = xVar;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        ArrayList e2 = r.e(this.b);
        try {
            String str = this.e.a;
            Bundle g = r.g();
            r rVar = this.e;
            this.e.c.b().c(str, e2, g, new p(rVar, this.c, rVar.b, this.d));
        } catch (RemoteException e3) {
            r.f.a(e3, "getPackStates(%s)", this.b);
            this.c.b((Exception) new RuntimeException(e3));
        }
    }
}
