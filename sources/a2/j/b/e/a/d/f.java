package a2.j.b.e.a.d;

import com.google.android.play.core.internal.ab;
import com.google.android.play.core.internal.ak;
public final class f extends ab {
    public final /* synthetic */ g b;

    public f(g gVar) {
        this.b = gVar;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        ak akVar = this.b.a;
        akVar.b.c("unlinkToDeath", new Object[0]);
        akVar.k.asBinder().unlinkToDeath(akVar.i, 0);
        ak akVar2 = this.b.a;
        akVar2.k = null;
        akVar2.e = false;
    }
}
