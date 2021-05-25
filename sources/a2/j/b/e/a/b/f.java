package a2.j.b.e.a.b;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
public final class f extends ab {
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ i f;
    public final /* synthetic */ r g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(r rVar, i iVar, int i, String str, String str2, int i2, i iVar2) {
        super(iVar);
        this.g = rVar;
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = i2;
        this.f = iVar2;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        try {
            this.g.c.b().a(this.g.a, r.h(this.b, this.c, this.d, this.e), r.g(), new k(this.g, this.f, (char[]) null));
        } catch (RemoteException e2) {
            r.f.a(e2, "notifyChunkTransferred", new Object[0]);
        }
    }
}
