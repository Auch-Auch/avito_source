package a2.j.d.l.a;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
public final class k implements Runnable {
    public final /* synthetic */ Supplier a;
    public final /* synthetic */ Runnable b;

    public k(Supplier supplier, Runnable runnable) {
        this.a = supplier;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        boolean a3 = Callables.a((String) this.a.get(), currentThread);
        try {
            this.b.run();
        } finally {
            if (a3) {
                Callables.a(name, currentThread);
            }
        }
    }
}
