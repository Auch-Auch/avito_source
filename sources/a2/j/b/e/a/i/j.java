package a2.j.b.e.a.i;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
import java.util.List;
public final class j extends ab {
    public final /* synthetic */ List b;
    public final /* synthetic */ i c;
    public final /* synthetic */ z d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(z zVar, i iVar, List list, i iVar2) {
        super(iVar);
        this.d = zVar;
        this.b = list;
        this.c = iVar2;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        try {
            this.d.b.b().b(this.d.a, z.a(this.b), z.b(), new u(this.d, this.c));
        } catch (RemoteException e) {
            z.c.a(e, "deferredUninstall(%s)", this.b);
            this.c.b((Exception) new RuntimeException(e));
        }
    }
}
