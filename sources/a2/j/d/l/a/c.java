package a2.j.d.l.a;

import a2.b.a.a.a;
import a2.j.d.l.a.w;
import com.google.common.util.concurrent.Service;
public final class c implements w.a<Service.Listener> {
    public final /* synthetic */ Service.State a;

    public c(Service.State state) {
        this.a = state;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a2.j.d.l.a.w.a
    public void a(Service.Listener listener) {
        listener.stopping(this.a);
    }

    public String toString() {
        StringBuilder L = a.L("stopping({from = ");
        L.append(this.a);
        L.append("})");
        return L.toString();
    }
}
