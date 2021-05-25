package a2.j.b.e.a.b;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
import java.util.List;
public final class c extends ab {
    public final /* synthetic */ List b;
    public final /* synthetic */ i c;
    public final /* synthetic */ r d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(r rVar, i iVar, List list, i iVar2) {
        super(iVar);
        this.d = rVar;
        this.b = list;
        this.c = iVar2;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        try {
            this.d.c.b().b(this.d.a, r.e(this.b), r.g(), new k(this.d, this.c, (byte[]) null));
        } catch (RemoteException e) {
            r.f.a(e, "cancelDownloads(%s)", this.b);
        }
    }
}
