package a2.j.b.e.a.b;

import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
public final class i extends ab {
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ com.google.android.play.core.tasks.i f;
    public final /* synthetic */ r g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(r rVar, com.google.android.play.core.tasks.i iVar, int i, String str, String str2, int i2, com.google.android.play.core.tasks.i iVar2) {
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
            this.g.c.b().d(this.g.a, r.h(this.b, this.c, this.d, this.e), r.g(), new l(this.g, this.f));
        } catch (RemoteException e2) {
            r.f.b("getChunkFileDescriptor(%s, %s, %d, session=%d)", this.c, this.d, Integer.valueOf(this.e), Integer.valueOf(this.b));
            this.f.b((Exception) new RuntimeException(e2));
        }
    }
}
