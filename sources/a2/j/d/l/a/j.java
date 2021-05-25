package a2.j.d.l.a;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import java.util.concurrent.Callable;
public final class j implements Callable<T> {
    public final /* synthetic */ Supplier a;
    public final /* synthetic */ Callable b;

    public j(Supplier supplier, Callable callable) {
        this.a = supplier;
        this.b = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        boolean a3 = Callables.a((String) this.a.get(), currentThread);
        try {
            return (T) this.b.call();
        } finally {
            if (a3) {
                Callables.a(name, currentThread);
            }
        }
    }
}
