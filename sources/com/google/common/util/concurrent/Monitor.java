package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public final class Monitor {
    public final boolean a;
    public final ReentrantLock b;
    @GuardedBy("lock")
    public Guard c;

    @Beta
    public static abstract class Guard {
        @Weak
        public final Monitor a;
        public final Condition b;
        @GuardedBy("monitor.lock")
        public int c = 0;
        @NullableDecl
        @GuardedBy("monitor.lock")
        public Guard d;

        public Guard(Monitor monitor) {
            this.a = (Monitor) Preconditions.checkNotNull(monitor, "monitor");
            this.b = monitor.b.newCondition();
        }

        public abstract boolean isSatisfied();
    }

    public Monitor() {
        this(false);
    }

    public static long f(long j) {
        if (j <= 0) {
            return 0;
        }
        long nanoTime = System.nanoTime();
        if (nanoTime == 0) {
            return 1;
        }
        return nanoTime;
    }

    public static long g(long j, long j2) {
        if (j2 <= 0) {
            return 0;
        }
        return j2 - (System.nanoTime() - j);
    }

    public static long i(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (nanos <= 0) {
            return 0;
        }
        if (nanos > 6917529027641081853L) {
            return 6917529027641081853L;
        }
        return nanos;
    }

    @GuardedBy("lock")
    public final void a(Guard guard, boolean z) throws InterruptedException {
        if (z) {
            h();
        }
        d(guard);
        do {
            try {
                guard.b.await();
            } finally {
                e(guard);
            }
        } while (!guard.isSatisfied());
    }

    @GuardedBy("lock")
    public final boolean b(Guard guard, long j, boolean z) throws InterruptedException {
        boolean z2 = true;
        while (j > 0) {
            if (z2) {
                if (z) {
                    try {
                        h();
                    } catch (Throwable th) {
                        if (!z2) {
                            e(guard);
                        }
                        throw th;
                    }
                }
                d(guard);
                z2 = false;
            }
            j = guard.b.awaitNanos(j);
            if (guard.isSatisfied()) {
                if (!z2) {
                    e(guard);
                }
                return true;
            }
        }
        if (!z2) {
            e(guard);
        }
        return false;
    }

    @GuardedBy("lock")
    public final void c(Guard guard, boolean z) {
        if (z) {
            h();
        }
        d(guard);
        do {
            try {
                guard.b.awaitUninterruptibly();
            } finally {
                e(guard);
            }
        } while (!guard.isSatisfied());
    }

    @GuardedBy("lock")
    public final void d(Guard guard) {
        int i = guard.c;
        guard.c = i + 1;
        if (i == 0) {
            guard.d = this.c;
            this.c = guard;
        }
    }

    @GuardedBy("lock")
    public final void e(Guard guard) {
        int i = guard.c - 1;
        guard.c = i;
        if (i == 0) {
            Guard guard2 = this.c;
            Guard guard3 = null;
            while (guard2 != guard) {
                guard3 = guard2;
                guard2 = guard2.d;
            }
            if (guard3 == null) {
                this.c = guard2.d;
            } else {
                guard3.d = guard2.d;
            }
            guard2.d = null;
        }
    }

    public void enter() {
        this.b.lock();
    }

    public boolean enterIf(Guard guard) {
        if (guard.a == this) {
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean enterIfInterruptibly(Guard guard) throws InterruptedException {
        if (guard.a == this) {
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lockInterruptibly();
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public void enterInterruptibly() throws InterruptedException {
        this.b.lockInterruptibly();
    }

    public void enterWhen(Guard guard) throws InterruptedException {
        if (guard.a == this) {
            ReentrantLock reentrantLock = this.b;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lockInterruptibly();
            try {
                if (!guard.isSatisfied()) {
                    a(guard, isHeldByCurrentThread);
                }
            } catch (Throwable th) {
                leave();
                throw th;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public void enterWhenUninterruptibly(Guard guard) {
        if (guard.a == this) {
            ReentrantLock reentrantLock = this.b;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lock();
            try {
                if (!guard.isSatisfied()) {
                    c(guard, isHeldByCurrentThread);
                }
            } catch (Throwable th) {
                leave();
                throw th;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public int getOccupiedDepth() {
        return this.b.getHoldCount();
    }

    public int getQueueLength() {
        return this.b.getQueueLength();
    }

    public int getWaitQueueLength(Guard guard) {
        if (guard.a == this) {
            this.b.lock();
            try {
                return guard.c;
            } finally {
                this.b.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    @GuardedBy("lock")
    public final void h() {
        for (Guard guard = this.c; guard != null; guard = guard.d) {
            try {
                if (guard.isSatisfied()) {
                    guard.b.signal();
                    return;
                }
            } catch (Throwable th) {
                for (Guard guard2 = this.c; guard2 != null; guard2 = guard2.d) {
                    guard2.b.signalAll();
                }
                throw th;
            }
        }
    }

    public boolean hasQueuedThread(Thread thread) {
        return this.b.hasQueuedThread(thread);
    }

    public boolean hasQueuedThreads() {
        return this.b.hasQueuedThreads();
    }

    public boolean hasWaiters(Guard guard) {
        return getWaitQueueLength(guard) > 0;
    }

    public boolean isFair() {
        return this.a;
    }

    public boolean isOccupied() {
        return this.b.isLocked();
    }

    public boolean isOccupiedByCurrentThread() {
        return this.b.isHeldByCurrentThread();
    }

    public void leave() {
        ReentrantLock reentrantLock = this.b;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                h();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean tryEnter() {
        return this.b.tryLock();
    }

    public boolean tryEnterIf(Guard guard) {
        if (guard.a == this) {
            ReentrantLock reentrantLock = this.b;
            if (!reentrantLock.tryLock()) {
                return false;
            }
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public void waitFor(Guard guard) throws InterruptedException {
        if (!(guard.a == this) || !this.b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (!guard.isSatisfied()) {
            a(guard, true);
        }
    }

    public void waitForUninterruptibly(Guard guard) {
        if (!(guard.a == this) || !this.b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (!guard.isSatisfied()) {
            c(guard, true);
        }
    }

    public Monitor(boolean z) {
        this.c = null;
        this.a = z;
        this.b = new ReentrantLock(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean enter(long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r7 = this;
            long r8 = i(r8, r10)
            java.util.concurrent.locks.ReentrantLock r10 = r7.b
            boolean r0 = r7.a
            r1 = 1
            if (r0 != 0) goto L_0x0012
            boolean r0 = r10.tryLock()
            if (r0 == 0) goto L_0x0012
            return r1
        L_0x0012:
            boolean r0 = java.lang.Thread.interrupted()
            long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0033 }
            r4 = r8
        L_0x001b:
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x002b }
            boolean r8 = r10.tryLock(r4, r6)     // Catch:{ InterruptedException -> 0x002b }
            if (r0 == 0) goto L_0x002a
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            r9.interrupt()
        L_0x002a:
            return r8
        L_0x002b:
            long r4 = g(r2, r8)     // Catch:{ all -> 0x0031 }
            r0 = 1
            goto L_0x001b
        L_0x0031:
            r8 = move-exception
            goto L_0x0035
        L_0x0033:
            r8 = move-exception
            r1 = r0
        L_0x0035:
            if (r1 == 0) goto L_0x003e
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            r9.interrupt()
        L_0x003e:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enter(long, java.util.concurrent.TimeUnit):boolean");
    }

    public boolean enterInterruptibly(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.b.tryLock(j, timeUnit);
    }

    public boolean waitFor(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        long i = i(j, timeUnit);
        if (!(guard.a == this) || !this.b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (guard.isSatisfied()) {
            return true;
        } else {
            if (!Thread.interrupted()) {
                return b(guard, i, true);
            }
            throw new InterruptedException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean waitForUninterruptibly(com.google.common.util.concurrent.Monitor.Guard r8, long r9, java.util.concurrent.TimeUnit r11) {
        /*
            r7 = this;
            long r9 = i(r9, r11)
            com.google.common.util.concurrent.Monitor r11 = r8.a
            r0 = 0
            r1 = 1
            if (r11 != r7) goto L_0x000c
            r11 = 1
            goto L_0x000d
        L_0x000c:
            r11 = 0
        L_0x000d:
            java.util.concurrent.locks.ReentrantLock r2 = r7.b
            boolean r2 = r2.isHeldByCurrentThread()
            r11 = r11 & r2
            if (r11 == 0) goto L_0x0058
            boolean r11 = r8.isSatisfied()
            if (r11 == 0) goto L_0x001d
            return r1
        L_0x001d:
            long r2 = f(r9)
            boolean r11 = java.lang.Thread.interrupted()
            r4 = r9
            r6 = 1
        L_0x0027:
            boolean r8 = r7.b(r8, r4, r6)     // Catch:{ InterruptedException -> 0x0038, all -> 0x0035 }
            if (r11 == 0) goto L_0x0034
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            r9.interrupt()
        L_0x0034:
            return r8
        L_0x0035:
            r8 = move-exception
            r1 = r11
            goto L_0x004e
        L_0x0038:
            boolean r11 = r8.isSatisfied()     // Catch:{ all -> 0x004d }
            if (r11 == 0) goto L_0x0046
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            r8.interrupt()
            return r1
        L_0x0046:
            long r4 = g(r2, r9)
            r11 = 1
            r6 = 0
            goto L_0x0027
        L_0x004d:
            r8 = move-exception
        L_0x004e:
            if (r1 == 0) goto L_0x0057
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            r9.interrupt()
        L_0x0057:
            throw r8
        L_0x0058:
            java.lang.IllegalMonitorStateException r8 = new java.lang.IllegalMonitorStateException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.waitForUninterruptibly(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public boolean enterIf(Guard guard, long j, TimeUnit timeUnit) {
        if (guard.a != this) {
            throw new IllegalMonitorStateException();
        } else if (!enter(j, timeUnit)) {
            return false;
        } else {
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                this.b.unlock();
            }
        }
    }

    public boolean enterIfInterruptibly(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        if (guard.a == this) {
            ReentrantLock reentrantLock = this.b;
            if (!reentrantLock.tryLock(j, timeUnit)) {
                return false;
            }
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (b(r11, r0, r3) != false) goto L_0x0049;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[Catch:{ all -> 0x0050, all -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean enterWhen(com.google.common.util.concurrent.Monitor.Guard r11, long r12, java.util.concurrent.TimeUnit r14) throws java.lang.InterruptedException {
        /*
            r10 = this;
            long r0 = i(r12, r14)
            com.google.common.util.concurrent.Monitor r2 = r11.a
            if (r2 != r10) goto L_0x0060
            java.util.concurrent.locks.ReentrantLock r2 = r10.b
            boolean r3 = r2.isHeldByCurrentThread()
            boolean r4 = r10.a
            r5 = 0
            r6 = 0
            if (r4 != 0) goto L_0x0029
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L_0x0023
            boolean r4 = r2.tryLock()
            if (r4 == 0) goto L_0x0029
            r8 = r6
            goto L_0x0034
        L_0x0023:
            java.lang.InterruptedException r11 = new java.lang.InterruptedException
            r11.<init>()
            throw r11
        L_0x0029:
            long r8 = f(r0)
            boolean r12 = r2.tryLock(r12, r14)
            if (r12 != 0) goto L_0x0034
            return r5
        L_0x0034:
            boolean r12 = r11.isSatisfied()     // Catch:{ all -> 0x0050 }
            if (r12 != 0) goto L_0x0049
            int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r12 != 0) goto L_0x003f
            goto L_0x0043
        L_0x003f:
            long r0 = g(r8, r0)     // Catch:{ all -> 0x0050 }
        L_0x0043:
            boolean r11 = r10.b(r11, r0, r3)     // Catch:{ all -> 0x0050 }
            if (r11 == 0) goto L_0x004a
        L_0x0049:
            r5 = 1
        L_0x004a:
            if (r5 != 0) goto L_0x004f
            r2.unlock()
        L_0x004f:
            return r5
        L_0x0050:
            r11 = move-exception
            if (r3 != 0) goto L_0x005c
            r10.h()     // Catch:{ all -> 0x0057 }
            goto L_0x005c
        L_0x0057:
            r11 = move-exception
            r2.unlock()
            throw r11
        L_0x005c:
            r2.unlock()
            throw r11
        L_0x0060:
            java.lang.IllegalMonitorStateException r11 = new java.lang.IllegalMonitorStateException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enterWhen(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean enterWhenUninterruptibly(com.google.common.util.concurrent.Monitor.Guard r12, long r13, java.util.concurrent.TimeUnit r15) {
        /*
            r11 = this;
            long r13 = i(r13, r15)
            com.google.common.util.concurrent.Monitor r15 = r12.a
            if (r15 != r11) goto L_0x007e
            java.util.concurrent.locks.ReentrantLock r15 = r11.b
            boolean r0 = r15.isHeldByCurrentThread()
            boolean r1 = java.lang.Thread.interrupted()
            r2 = 1
            boolean r3 = r11.a     // Catch:{ all -> 0x0073 }
            r4 = 0
            r5 = 0
            if (r3 != 0) goto L_0x0023
            boolean r3 = r15.tryLock()     // Catch:{ all -> 0x0073 }
            if (r3 != 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r7 = r5
            goto L_0x0030
        L_0x0023:
            long r7 = f(r13)     // Catch:{ all -> 0x0073 }
            r9 = r13
        L_0x0028:
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x006a }
            boolean r3 = r15.tryLock(r9, r3)     // Catch:{ InterruptedException -> 0x006a }
            if (r3 == 0) goto L_0x0060
        L_0x0030:
            boolean r3 = r12.isSatisfied()     // Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }
            if (r3 == 0) goto L_0x0037
            goto L_0x0049
        L_0x0037:
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0041
            long r7 = f(r13)     // Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }
            r9 = r13
            goto L_0x0045
        L_0x0041:
            long r9 = g(r7, r13)     // Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }
        L_0x0045:
            boolean r2 = r11.b(r12, r9, r0)     // Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }
        L_0x0049:
            if (r2 != 0) goto L_0x004e
            r15.unlock()
        L_0x004e:
            if (r1 == 0) goto L_0x0057
            java.lang.Thread r12 = java.lang.Thread.currentThread()
            r12.interrupt()
        L_0x0057:
            return r2
        L_0x0058:
            r12 = move-exception
            r15.unlock()
            throw r12
        L_0x005d:
            r0 = 0
            r1 = 1
            goto L_0x0030
        L_0x0060:
            if (r1 == 0) goto L_0x0069
            java.lang.Thread r12 = java.lang.Thread.currentThread()
            r12.interrupt()
        L_0x0069:
            return r4
        L_0x006a:
            long r9 = g(r7, r13)     // Catch:{ all -> 0x0070 }
            r1 = 1
            goto L_0x0028
        L_0x0070:
            r12 = move-exception
            r1 = 1
            goto L_0x0074
        L_0x0073:
            r12 = move-exception
        L_0x0074:
            if (r1 == 0) goto L_0x007d
            java.lang.Thread r13 = java.lang.Thread.currentThread()
            r13.interrupt()
        L_0x007d:
            throw r12
        L_0x007e:
            java.lang.IllegalMonitorStateException r12 = new java.lang.IllegalMonitorStateException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.enterWhenUninterruptibly(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }
}
