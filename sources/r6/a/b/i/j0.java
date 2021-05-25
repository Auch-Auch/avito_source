package r6.a.b.i;

import r6.a.b.i.i0;
public class j0 implements Runnable {
    public final /* synthetic */ i0.b a;

    public j0(i0.b bVar) {
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
