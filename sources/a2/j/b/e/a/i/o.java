package a2.j.b.e.a.i;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
public final class o extends ab {
    public final /* synthetic */ i b;
    public final /* synthetic */ z c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(z zVar, i iVar, i iVar2) {
        super(iVar);
        this.c = zVar;
        this.b = iVar2;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        try {
            this.c.b.b().a(this.c.a, new w(this.c, this.b));
        } catch (RemoteException e) {
            z.c.a(e, "getSessionStates", new Object[0]);
            this.b.b((Exception) new RuntimeException(e));
        }
    }
}
