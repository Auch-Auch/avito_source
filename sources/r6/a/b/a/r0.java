package r6.a.b.a;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
public final class r0<T> extends CountDownLatch implements Future<T> {
    public final AtomicInteger a = new AtomicInteger();
    public Disposable b;
    public T c;
    public Throwable d;

    public r0(Disposable disposable) {
        super(1);
        this.b = disposable;
    }

    public void a(T t) {
        if (this.a.compareAndSet(0, 1)) {
            this.b = null;
            this.c = null;
            countDown();
        }
    }

    public void b(Throwable th) {
        Objects.requireNonNull(th, "error is null");
        if (this.a.compareAndSet(0, 2)) {
            this.b = null;
            this.d = th;
            countDown();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!this.a.compareAndSet(0, 3)) {
            return false;
        }
        this.d = new CancellationException();
        countDown();
        Disposable disposable = this.b;
        this.b = null;
        if (disposable == null) {
            return true;
        }
        disposable.dispose();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            await();
        }
        Throwable th = this.d;
        if (th == null) {
            return this.c;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.a.get() == 3;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() == 0 || await(j, timeUnit)) {
            Throwable th = this.d;
            if (th == null) {
                return this.c;
            }
            throw new ExecutionException(th);
        }
        throw new TimeoutException();
    }
}
