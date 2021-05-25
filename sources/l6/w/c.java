package l6.w;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
public class c<T> extends LiveData<T> {
    public final RoomDatabase l;
    public final boolean m;
    public final Callable<T> n;
    public final a o;
    public final InvalidationTracker.Observer p;
    public final AtomicBoolean q = new AtomicBoolean(true);
    public final AtomicBoolean r = new AtomicBoolean(false);
    public final AtomicBoolean s = new AtomicBoolean(false);
    public final Runnable t = new a();
    public final Runnable u = new b();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        @WorkerThread
        public void run() {
            boolean z;
            boolean z2 = false;
            if (c.this.s.compareAndSet(false, true)) {
                c.this.l.getInvalidationTracker().addWeakObserver(c.this.p);
            }
            do {
                if (c.this.r.compareAndSet(false, true)) {
                    T t = null;
                    z = false;
                    while (c.this.q.compareAndSet(true, false)) {
                        try {
                            try {
                                t = c.this.n.call();
                                z = true;
                            } catch (Exception e) {
                                throw new RuntimeException("Exception while computing database live data.", e);
                            }
                        } finally {
                            c.this.r.set(z2);
                        }
                    }
                    if (z) {
                        c.this.postValue(t);
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    return;
                }
            } while (c.this.q.get());
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            Executor executor;
            boolean hasActiveObservers = c.this.hasActiveObservers();
            if (c.this.q.compareAndSet(false, true) && hasActiveObservers) {
                c cVar = c.this;
                if (cVar.m) {
                    executor = cVar.l.getTransactionExecutor();
                } else {
                    executor = cVar.l.getQueryExecutor();
                }
                executor.execute(c.this.t);
            }
        }
    }

    /* renamed from: l6.w.c$c  reason: collision with other inner class name */
    public class C0541c extends InvalidationTracker.Observer {
        public C0541c(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@NonNull Set<String> set) {
            ArchTaskExecutor.getInstance().executeOnMainThread(c.this.u);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public c(RoomDatabase roomDatabase, a aVar, boolean z, Callable<T> callable, String[] strArr) {
        this.l = roomDatabase;
        this.m = z;
        this.n = callable;
        this.o = aVar;
        this.p = new C0541c(strArr);
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        Executor executor;
        super.onActive();
        this.o.a.add(this);
        if (this.m) {
            executor = this.l.getTransactionExecutor();
        } else {
            executor = this.l.getQueryExecutor();
        }
        executor.execute(this.t);
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.o.a.remove(this);
    }
}
