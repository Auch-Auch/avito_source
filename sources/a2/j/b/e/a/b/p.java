package a2.j.b.e.a.b;

import android.os.Bundle;
import com.google.android.play.core.assetpacks.AssetPackStates;
import com.google.android.play.core.tasks.i;
public final class p extends k<AssetPackStates> {
    public final t0 c;
    public final x d;

    public p(r rVar, i<AssetPackStates> iVar, t0 t0Var, x xVar) {
        super(rVar, iVar);
        this.c = t0Var;
        this.d = xVar;
    }

    @Override // a2.j.b.e.a.b.k, com.google.android.play.core.internal.u
    public final void c(Bundle bundle, Bundle bundle2) {
        this.b.c.a();
        r.f.c("onRequestDownloadInfo()", new Object[0]);
        this.a.b((i<T>) ((T) AssetPackStates.a(bundle, this.c, this.d)));
    }
}
