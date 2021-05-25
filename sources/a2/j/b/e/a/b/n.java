package a2.j.b.e.a.b;

import android.os.Bundle;
import com.google.android.play.core.tasks.i;
public final class n extends k<Void> {
    public final /* synthetic */ r c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(r rVar, i<Void> iVar) {
        super(rVar, iVar);
        this.c = rVar;
    }

    @Override // a2.j.b.e.a.b.k, com.google.android.play.core.internal.u
    public final void a(Bundle bundle, Bundle bundle2) {
        super.a(bundle, bundle2);
        if (!this.c.e.compareAndSet(true, false)) {
            r.f.d("Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.c.b();
        }
    }
}
