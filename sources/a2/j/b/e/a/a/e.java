package a2.j.b.e.a.a;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
public final class e extends ab {
    public final /* synthetic */ String b;
    public final /* synthetic */ i c;
    public final /* synthetic */ j d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(j jVar, i iVar, String str, i iVar2) {
        super(iVar);
        this.d = jVar;
        this.b = str;
        this.c = iVar2;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        try {
            j jVar = this.d;
            this.d.a.b().a(jVar.b, j.a(jVar, this.b), new i(this.d, this.c, this.b));
        } catch (RemoteException e) {
            j.e.a(e, "requestUpdateInfo(%s)", this.b);
            this.c.b((Exception) new RuntimeException(e));
        }
    }
}
