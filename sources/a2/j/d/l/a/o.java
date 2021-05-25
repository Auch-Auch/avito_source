package a2.j.d.l.a;

import com.google.common.util.concurrent.Striped;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
public abstract class o implements Condition {
    @Override // java.util.concurrent.locks.Condition
    public void await() throws InterruptedException {
        ((Striped.m) this).a.await();
    }

    @Override // java.util.concurrent.locks.Condition
    public long awaitNanos(long j) throws InterruptedException {
        return ((Striped.m) this).a.awaitNanos(j);
    }

    @Override // java.util.concurrent.locks.Condition
    public void awaitUninterruptibly() {
        ((Striped.m) this).a.awaitUninterruptibly();
    }

    @Override // java.util.concurrent.locks.Condition
    public boolean awaitUntil(Date date) throws InterruptedException {
        return ((Striped.m) this).a.awaitUntil(date);
    }

    @Override // java.util.concurrent.locks.Condition
    public void signal() {
        ((Striped.m) this).a.signal();
    }

    @Override // java.util.concurrent.locks.Condition
    public void signalAll() {
        ((Striped.m) this).a.signalAll();
    }

    @Override // java.util.concurrent.locks.Condition
    public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        return ((Striped.m) this).a.await(j, timeUnit);
    }
}
