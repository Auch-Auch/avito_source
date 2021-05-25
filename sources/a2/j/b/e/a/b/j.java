package a2.j.b.e.a.b;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
public final class j extends ab {
    public final /* synthetic */ i b;
    public final /* synthetic */ r c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(r rVar, i iVar, i iVar2) {
        super(iVar);
        this.c = rVar;
        this.b = iVar2;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        try {
            this.c.d.b().b(this.c.a, r.g(), new n(this.c, this.b));
        } catch (RemoteException e) {
            r.f.a(e, "keepAlive", new Object[0]);
        }
    }
}
