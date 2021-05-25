package a2.j.b.e.a.d;

import com.google.android.play.core.internal.ab;
import com.google.android.play.core.internal.ak;
public final class d extends ab {
    public final /* synthetic */ ak b;

    public d(ak akVar) {
        this.b = akVar;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        ak akVar = this.b;
        if (akVar.k != null) {
            akVar.b.c("Unbind from service.", new Object[0]);
            ak akVar2 = this.b;
            akVar2.a.unbindService(akVar2.j);
            ak akVar3 = this.b;
            akVar3.e = false;
            akVar3.k = null;
            akVar3.j = null;
        }
    }
}
