package androidx.paging;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import l6.s.c;
import l6.s.e;
public abstract class DataSource<Key, Value> {
    public AtomicBoolean a = new AtomicBoolean(false);
    public CopyOnWriteArrayList<InvalidatedCallback> b = new CopyOnWriteArrayList<>();

    public static abstract class Factory<Key, Value> {

        public class a extends Factory<Key, ToValue> {
            public final /* synthetic */ Function a;

            public a(Function function) {
                this.a = function;
            }

            @Override // androidx.paging.DataSource.Factory
            public DataSource<Key, ToValue> create() {
                return Factory.this.create().mapByPage(this.a);
            }
        }

        public abstract DataSource<Key, Value> create();

        @NonNull
        public <ToValue> Factory<Key, ToValue> map(@NonNull Function<Value, ToValue> function) {
            return mapByPage(new c(function));
        }

        @NonNull
        public <ToValue> Factory<Key, ToValue> mapByPage(@NonNull Function<List<Value>, List<ToValue>> function) {
            return new a(function);
        }
    }

    public interface InvalidatedCallback {
        @AnyThread
        void onInvalidated();
    }

    public static class a<T> {
        public final int a;
        public final DataSource b;
        public final e.a<T> c;
        public final Object d = new Object();
        public Executor e = null;
        public boolean f = false;

        /* renamed from: androidx.paging.DataSource$a$a  reason: collision with other inner class name */
        public class RunnableC0115a implements Runnable {
            public final /* synthetic */ e a;

            public RunnableC0115a(e eVar) {
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.c.a(aVar.a, this.a);
            }
        }

        public a(@NonNull DataSource dataSource, int i, @Nullable Executor executor, @NonNull e.a<T> aVar) {
            this.b = dataSource;
            this.a = i;
            this.e = executor;
            this.c = aVar;
        }

        public static void d(@NonNull List<?> list, int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Position must be non-negative");
            } else if (list.size() + i > i2) {
                throw new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
            } else if (list.size() == 0 && i2 > 0) {
                throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
            }
        }

        public boolean a() {
            if (!this.b.isInvalid()) {
                return false;
            }
            b(e.f);
            return true;
        }

        public void b(@NonNull e<T> eVar) {
            Executor executor;
            synchronized (this.d) {
                if (!this.f) {
                    this.f = true;
                    executor = this.e;
                } else {
                    throw new IllegalStateException("callback.onResult already called, cannot call again.");
                }
            }
            if (executor != null) {
                executor.execute(new RunnableC0115a(eVar));
            } else {
                this.c.a(this.a, eVar);
            }
        }

        public void c(Executor executor) {
            synchronized (this.d) {
                this.e = executor;
            }
        }
    }

    public static <A, B> List<B> a(Function<List<A>, List<B>> function, List<A> list) {
        List<B> apply = function.apply(list);
        if (apply.size() == list.size()) {
            return apply;
        }
        throw new IllegalStateException("Invalid Function " + function + " changed return size. This is not supported.");
    }

    @AnyThread
    public void addInvalidatedCallback(@NonNull InvalidatedCallback invalidatedCallback) {
        this.b.add(invalidatedCallback);
    }

    public abstract boolean b();

    @AnyThread
    public void invalidate() {
        if (this.a.compareAndSet(false, true)) {
            Iterator<InvalidatedCallback> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().onInvalidated();
            }
        }
    }

    @WorkerThread
    public boolean isInvalid() {
        return this.a.get();
    }

    @NonNull
    public abstract <ToValue> DataSource<Key, ToValue> map(@NonNull Function<Value, ToValue> function);

    @NonNull
    public abstract <ToValue> DataSource<Key, ToValue> mapByPage(@NonNull Function<List<Value>, List<ToValue>> function);

    @AnyThread
    public void removeInvalidatedCallback(@NonNull InvalidatedCallback invalidatedCallback) {
        this.b.remove(invalidatedCallback);
    }
}
