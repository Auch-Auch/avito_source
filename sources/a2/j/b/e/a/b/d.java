package a2.j.b.e.a.b;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
public final class d extends ab {
    public final /* synthetic */ i b;
    public final /* synthetic */ r c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(r rVar, i iVar, i iVar2) {
        super(iVar);
        this.c = rVar;
        this.b = iVar2;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        try {
            this.c.c.b().a(this.c.a, r.g(), new m(this.c, this.b));
        } catch (RemoteException e) {
            r.f.a(e, "syncPacks", new Object[0]);
            this.b.b((Exception) new RuntimeException(e));
        }
    }
}
