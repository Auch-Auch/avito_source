package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SelfDestructiveThread {
    public final Object a = new Object();
    @GuardedBy("mLock")
    public HandlerThread b;
    @GuardedBy("mLock")
    public Handler c;
    @GuardedBy("mLock")
    public int d;
    public Handler.Callback e = new a();
    public final int f;
    public final int g;
    public final String h;

    public interface ReplyCallback<T> {
        void onReply(T t);
    }

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                SelfDestructiveThread selfDestructiveThread = SelfDestructiveThread.this;
                synchronized (selfDestructiveThread.a) {
                    if (!selfDestructiveThread.c.hasMessages(1)) {
                        selfDestructiveThread.b.quit();
                        selfDestructiveThread.b = null;
                        selfDestructiveThread.c = null;
                    }
                }
                return true;
            } else if (i != 1) {
                return true;
            } else {
                SelfDestructiveThread selfDestructiveThread2 = SelfDestructiveThread.this;
                Objects.requireNonNull(selfDestructiveThread2);
                ((Runnable) message.obj).run();
                synchronized (selfDestructiveThread2.a) {
                    selfDestructiveThread2.c.removeMessages(0);
                    Handler handler = selfDestructiveThread2.c;
                    handler.sendMessageDelayed(handler.obtainMessage(0), (long) selfDestructiveThread2.f);
                }
                return true;
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Callable a;
        public final /* synthetic */ Handler b;
        public final /* synthetic */ ReplyCallback c;

        public class a implements Runnable {
            public final /* synthetic */ Object a;

            public a(Object obj) {
                this.a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.c.onReply(this.a);
            }
        }

        public b(SelfDestructiveThread selfDestructiveThread, Callable callable, Handler handler, ReplyCallback replyCallback) {
            this.a = callable;
            this.b = handler;
            this.c = replyCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = this.a.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.b.post(new a(obj));
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ AtomicReference a;
        public final /* synthetic */ Callable b;
        public final /* synthetic */ ReentrantLock c;
        public final /* synthetic */ AtomicBoolean d;
        public final /* synthetic */ Condition e;

        public c(SelfDestructiveThread selfDestructiveThread, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.a = atomicReference;
            this.b = callable;
            this.c = reentrantLock;
            this.d = atomicBoolean;
            this.e = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.set(this.b.call());
            } catch (Exception unused) {
            }
            this.c.lock();
            try {
                this.d.set(false);
                this.e.signal();
            } finally {
                this.c.unlock();
            }
        }
    }

    public SelfDestructiveThread(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
        this.d = 0;
    }

    public final void a(Runnable runnable) {
        synchronized (this.a) {
            if (this.b == null) {
                HandlerThread handlerThread = new HandlerThread(this.h, this.g);
                this.b = handlerThread;
                handlerThread.start();
                this.c = new Handler(this.b.getLooper(), this.e);
                this.d++;
            }
            this.c.removeMessages(0);
            Handler handler = this.c;
            handler.sendMessage(handler.obtainMessage(1, runnable));
        }
    }

    @VisibleForTesting
    public int getGeneration() {
        int i;
        synchronized (this.a) {
            i = this.d;
        }
        return i;
    }

    @VisibleForTesting
    public boolean isRunning() {
        boolean z;
        synchronized (this.a) {
            z = this.b != null;
        }
        return z;
    }

    public <T> void postAndReply(Callable<T> callable, ReplyCallback<T> replyCallback) {
        a(new b(this, callable, new Handler(), replyCallback));
    }

    public <T> T postAndWait(Callable<T> callable, int i) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        a(new c(this, atomicReference, callable, reentrantLock, atomicBoolean, newCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos((long) i);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    T t = (T) atomicReference.get();
                    reentrantLock.unlock();
                    return t;
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
