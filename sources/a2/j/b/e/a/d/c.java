package a2.j.b.e.a.d;

import com.google.android.play.core.internal.ab;
import com.google.android.play.core.internal.ak;
import com.google.android.play.core.internal.al;
import com.google.android.play.core.tasks.i;
import java.util.List;
public final class c extends ab {
    public final /* synthetic */ ab b;
    public final /* synthetic */ ak c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ak akVar, i iVar, ab abVar) {
        super(iVar);
        this.c = akVar;
        this.b = abVar;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        ak akVar = this.c;
        ab abVar = this.b;
        if (akVar.k == null && !akVar.e) {
            akVar.b.c("Initiate binding to the service.", new Object[0]);
            akVar.d.add(abVar);
            g gVar = new g(akVar);
            akVar.j = gVar;
            akVar.e = true;
            if (!akVar.a.bindService(akVar.f, gVar, 1)) {
                akVar.b.c("Failed to bind to the service.", new Object[0]);
                akVar.e = false;
                List<ab> list = akVar.d;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    i<?> iVar = list.get(i).a;
                    if (iVar != null) {
                        iVar.b((Exception) new al());
                    }
                }
                akVar.d.clear();
            }
        } else if (akVar.e) {
            akVar.b.c("Waiting to bind to the service.", new Object[0]);
            akVar.d.add(abVar);
        } else {
            abVar.run();
        }
    }
}
