package a2.j.d.l.a;

import a2.b.a.a.a;
import a2.j.d.l.a.w;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;
public class c0 implements w.a<ServiceManager.Listener> {
    public final /* synthetic */ Service a;

    public c0(ServiceManager.f fVar, Service service) {
        this.a = service;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a2.j.d.l.a.w.a
    public void a(ServiceManager.Listener listener) {
        listener.failure(this.a);
    }

    public String toString() {
        StringBuilder L = a.L("failed({service=");
        L.append(this.a);
        L.append("})");
        return L.toString();
    }
}
