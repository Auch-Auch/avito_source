package a2.j.b.e.a.i;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
import java.util.List;
public final class m extends ab {
    public final /* synthetic */ List b;
    public final /* synthetic */ i c;
    public final /* synthetic */ z d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(z zVar, i iVar, List list, i iVar2) {
        super(iVar);
        this.d = zVar;
        this.b = list;
        this.c = iVar2;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        try {
            this.d.b.b().e(this.d.a, z.c(this.b), z.b(), new t(this.d, this.c));
        } catch (RemoteException e) {
            z.c.a(e, "deferredLanguageUninstall(%s)", this.b);
            this.c.b((Exception) new RuntimeException(e));
        }
    }
}
