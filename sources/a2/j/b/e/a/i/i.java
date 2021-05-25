package a2.j.b.e.a.i;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import java.util.ArrayList;
import java.util.Collection;
public final class i extends ab {
    public final /* synthetic */ Collection b;
    public final /* synthetic */ Collection c;
    public final /* synthetic */ com.google.android.play.core.tasks.i d;
    public final /* synthetic */ z e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(z zVar, com.google.android.play.core.tasks.i iVar, Collection collection, Collection collection2, com.google.android.play.core.tasks.i iVar2) {
        super(iVar);
        this.e = zVar;
        this.b = collection;
        this.c = collection2;
        this.d = iVar2;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        ArrayList a = z.a(this.b);
        a.addAll(z.c(this.c));
        try {
            this.e.b.b().a(this.e.a, a, z.b(), new x(this.e, this.d));
        } catch (RemoteException e2) {
            z.c.a(e2, "startInstall(%s,%s)", this.b, this.c);
            this.d.b((Exception) new RuntimeException(e2));
        }
    }
}
