package a2.j.b.e.a.i;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
public final class n extends ab {
    public final /* synthetic */ int b;
    public final /* synthetic */ i c;
    public final /* synthetic */ z d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(z zVar, i iVar, int i, i iVar2) {
        super(iVar);
        this.d = zVar;
        this.b = i;
        this.c = iVar2;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        try {
            this.d.b.b().a(this.d.a, this.b, new v(this.d, this.c));
        } catch (RemoteException e) {
            z.c.a(e, "getSessionState(%d)", Integer.valueOf(this.b));
            this.c.b((Exception) new RuntimeException(e));
        }
    }
}
