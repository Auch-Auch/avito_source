package a2.j.b.e.a.b;

import android.os.Bundle;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import com.google.android.play.core.assetpacks.dd;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.List;
public final class m extends k<List<String>> {
    public final /* synthetic */ r c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(r rVar, i<List<String>> iVar) {
        super(rVar, iVar);
        this.c = rVar;
    }

    @Override // a2.j.b.e.a.b.k, com.google.android.play.core.internal.u
    public final void a(List<Bundle> list) {
        this.b.c.a();
        r.f.c("onGetSessionStates", new Object[0]);
        r rVar = this.c;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AssetPackState next = AssetPackStates.a(list.get(i), rVar.b).packStates().values().iterator().next();
            if (next == null) {
                r.f.b("onGetSessionStates: Bundle contained no pack.", new Object[0]);
            }
            if (dd.a(next.status())) {
                arrayList.add(next.name());
            }
        }
        this.a.b((i<T>) arrayList);
    }
}
