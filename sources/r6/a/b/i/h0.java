package r6.a.b.i;

import r6.a.b.i.i0;
public class h0 implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ i0.a b;

    public h0(i0.a aVar, long j) {
        this.b = aVar;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.e.compareAndSet(this.a, Long.MIN_VALUE)) {
            this.b.g.cancel();
            this.b.d();
        }
    }
}
