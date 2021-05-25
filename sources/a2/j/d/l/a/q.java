package a2.j.d.l.a;

import com.google.common.util.concurrent.Striped;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
public abstract class q implements Lock {
    @Override // java.util.concurrent.locks.Lock
    public void lock() {
        ((Striped.n) this).a.lock();
    }

    @Override // java.util.concurrent.locks.Lock
    public void lockInterruptibly() throws InterruptedException {
        ((Striped.n) this).a.lockInterruptibly();
    }

    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock() {
        return ((Striped.n) this).a.tryLock();
    }

    @Override // java.util.concurrent.locks.Lock
    public void unlock() {
        ((Striped.n) this).a.unlock();
    }

    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
        return ((Striped.n) this).a.tryLock(j, timeUnit);
    }
}
