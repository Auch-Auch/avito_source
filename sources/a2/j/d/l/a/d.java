package a2.j.d.l.a;

import a2.b.a.a.a;
import a2.j.d.l.a.w;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Service;
public class d implements w.a<Service.Listener> {
    public final /* synthetic */ Service.State a;
    public final /* synthetic */ Throwable b;

    public d(AbstractService abstractService, Service.State state, Throwable th) {
        this.a = state;
        this.b = th;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a2.j.d.l.a.w.a
    public void a(Service.Listener listener) {
        listener.failed(this.a, this.b);
    }

    public String toString() {
        StringBuilder L = a.L("failed({from = ");
        L.append(this.a);
        L.append(", cause = ");
        L.append(this.b);
        L.append("})");
        return L.toString();
    }
}
