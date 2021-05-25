package u6.a;

import a2.b.a.a.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
public final class d0 implements Function1<Throwable, Unit> {
    public static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(d0.class, "_state");
    private volatile int _state = 0;
    public final Thread a = Thread.currentThread();
    public DisposableHandle b;
    public final Job c;

    public d0(@NotNull Job job) {
        this.c = job;
    }

    public final void a() {
        while (true) {
            int i = this._state;
            if (i != 0) {
                if (i != 2) {
                    if (i == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i);
                        throw null;
                    }
                }
            } else if (d.compareAndSet(this, i, 1)) {
                DisposableHandle disposableHandle = this.b;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                    return;
                }
                return;
            }
        }
    }

    public final Void b(int i) {
        throw new IllegalStateException(a.M2("Illegal state ", i).toString());
    }

    public final void c() {
        int i;
        this.b = this.c.invokeOnCompletion(true, true, this);
        do {
            i = this._state;
            if (i != 0) {
                if (i != 2 && i != 3) {
                    b(i);
                    throw null;
                }
                return;
            }
        } while (!d.compareAndSet(this, i, 0));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        while (true) {
            int i = this._state;
            if (i == 0) {
                if (d.compareAndSet(this, i, 2)) {
                    this.a.interrupt();
                    this._state = 3;
                    break;
                }
            } else if (i != 1 && i != 2 && i != 3) {
                b(i);
                throw null;
            }
        }
        return Unit.INSTANCE;
    }
}
