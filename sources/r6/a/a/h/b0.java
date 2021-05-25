package r6.a.a.h;

import r6.a.a.h.c0;
public class b0 implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ c0.a b;

    public b0(c0.a aVar, long j) {
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
