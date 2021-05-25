package r6.a.a.h;

import r6.a.a.h.c0;
public class d0 implements Runnable {
    public final /* synthetic */ c0.b a;

    public d0(c0.b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.e.compareAndSet(false, true)) {
            this.a.g.cancel();
            this.a.d();
        }
    }
}
