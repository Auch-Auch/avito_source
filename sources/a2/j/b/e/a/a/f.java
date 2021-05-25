package a2.j.b.e.a.a;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
public final class f extends ab {
    public final /* synthetic */ i b;
    public final /* synthetic */ String c;
    public final /* synthetic */ j d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(j jVar, i iVar, i iVar2, String str) {
        super(iVar);
        this.d = jVar;
        this.b = iVar2;
        this.c = str;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        try {
            String str = this.d.b;
            Bundle bundle = new Bundle();
            bundle.putInt("playcore.version.code", 10702);
            this.d.a.b().b(str, bundle, new h(this.d, this.b));
        } catch (RemoteException e) {
            j.e.a(e, "completeUpdate(%s)", this.c);
            this.b.b((Exception) new RuntimeException(e));
        }
    }
}
