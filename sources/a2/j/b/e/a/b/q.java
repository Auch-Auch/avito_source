package a2.j.b.e.a.b;

import android.os.Bundle;
import com.google.android.play.core.assetpacks.AssetPackStates;
import com.google.android.play.core.tasks.i;
import java.util.List;
public final class q extends k<AssetPackStates> {
    public final List<String> c;
    public final t0 d;

    public q(r rVar, i<AssetPackStates> iVar, t0 t0Var, List<String> list) {
        super(rVar, iVar);
        this.d = t0Var;
        this.c = list;
    }

    @Override // a2.j.b.e.a.b.k, com.google.android.play.core.internal.u
    public final void a(int i, Bundle bundle) {
        super.a(i, bundle);
        this.a.b((i<T>) ((T) AssetPackStates.a(bundle, this.d, this.c)));
    }
}
