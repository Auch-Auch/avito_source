package a2.j.b.e.a.d;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.internal.ak;
public final class e extends ab {
    public final /* synthetic */ IBinder b;
    public final /* synthetic */ g c;

    public e(g gVar, IBinder iBinder) {
        this.c = gVar;
        this.b = iBinder;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        ak akVar = this.c.a;
        akVar.k = akVar.g.a(this.b);
        ak akVar2 = this.c.a;
        akVar2.b.c("linkToDeath", new Object[0]);
        try {
            akVar2.k.asBinder().linkToDeath(akVar2.i, 0);
        } catch (RemoteException e) {
            akVar2.b.a(e, "linkToDeath failed", new Object[0]);
        }
        ak akVar3 = this.c.a;
        akVar3.e = false;
        for (ab abVar : akVar3.d) {
            abVar.run();
        }
        this.c.a.d.clear();
    }
}
