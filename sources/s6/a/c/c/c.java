package s6.a.c.c;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
public final class c implements Callable<Void>, Disposable {
    public static final FutureTask<Void> f = new FutureTask<>(Functions.EMPTY_RUNNABLE, null);
    public final Runnable a;
    public final AtomicReference<Future<?>> b = new AtomicReference<>();
    public final AtomicReference<Future<?>> c = new AtomicReference<>();
    public final ExecutorService d;
    public Thread e;

    public c(Runnable runnable, ExecutorService executorService) {
        this.a = runnable;
        this.d = executorService;
    }

    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.c.get();
            if (future2 == f) {
                future.cancel(this.e != Thread.currentThread());
                return;
            }
        } while (!this.c.compareAndSet(future2, future));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.e = Thread.currentThread();
        try {
            this.a.run();
            Future<?> submit = this.d.submit(this);
            while (true) {
                Future<?> future = this.b.get();
                if (future != f) {
                    if (this.b.compareAndSet(future, submit)) {
                        break;
                    }
                } else {
                    submit.cancel(this.e != Thread.currentThread());
                }
            }
            this.e = null;
        } catch (Throwable th) {
            this.e = null;
            RxJavaPlugins.onError(th);
        }
        return null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.c;
        FutureTask<Void> futureTask = f;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        boolean z = true;
        if (!(andSet == null || andSet == futureTask)) {
            andSet.cancel(this.e != Thread.currentThread());
        }
        Future<?> andSet2 = this.b.getAndSet(futureTask);
        if (andSet2 != null && andSet2 != futureTask) {
            if (this.e == Thread.currentThread()) {
                z = false;
            }
            andSet2.cancel(z);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.c.get() == f;
    }
}
