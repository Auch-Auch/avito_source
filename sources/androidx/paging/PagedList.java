package androidx.paging;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.paging.PositionalDataSource;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import l6.s.f;
import l6.s.i;
import l6.s.j;
public abstract class PagedList<T> extends AbstractList<T> {
    public static final /* synthetic */ int n = 0;
    @NonNull
    public final Executor a;
    @NonNull
    public final Executor b;
    @Nullable
    public final BoundaryCallback<T> c;
    @NonNull
    public final Config d;
    @NonNull
    public final f<T> e;
    public int f = 0;
    public T g = null;
    public boolean h = false;
    public boolean i = false;
    public int j = Integer.MAX_VALUE;
    public int k = Integer.MIN_VALUE;
    public final AtomicBoolean l = new AtomicBoolean(false);
    public final ArrayList<WeakReference<Callback>> m = new ArrayList<>();

    @MainThread
    public static abstract class BoundaryCallback<T> {
        public void onItemAtEndLoaded(@NonNull T t) {
        }

        public void onItemAtFrontLoaded(@NonNull T t) {
        }

        public void onZeroItemsLoaded() {
        }
    }

    public static abstract class Callback {
        public abstract void onChanged(int i, int i2);

        public abstract void onInserted(int i, int i2);

        public abstract void onRemoved(int i, int i2);
    }

    public static class Config {
        public final boolean enablePlaceholders;
        public final int initialLoadSizeHint;
        public final int pageSize;
        public final int prefetchDistance;

        public static final class Builder {
            public int a = -1;
            public int b = -1;
            public int c = -1;
            public boolean d = true;

            public Config build() {
                int i = this.a;
                if (i >= 1) {
                    if (this.b < 0) {
                        this.b = i;
                    }
                    if (this.c < 0) {
                        this.c = i * 3;
                    }
                    boolean z = this.d;
                    if (z || this.b != 0) {
                        return new Config(i, this.b, z, this.c, null);
                    }
                    throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
                }
                throw new IllegalArgumentException("Page size must be a positive number");
            }

            public Builder setEnablePlaceholders(boolean z) {
                this.d = z;
                return this;
            }

            public Builder setInitialLoadSizeHint(int i) {
                this.c = i;
                return this;
            }

            public Builder setPageSize(int i) {
                this.a = i;
                return this;
            }

            public Builder setPrefetchDistance(int i) {
                this.b = i;
                return this;
            }
        }

        public Config(int i, int i2, boolean z, int i3, a aVar) {
            this.pageSize = i;
            this.prefetchDistance = i2;
            this.enablePlaceholders = z;
            this.initialLoadSizeHint = i3;
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public a(boolean z, boolean z2, boolean z3) {
            this.a = z;
            this.b = z2;
            this.c = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a) {
                PagedList.this.c.onZeroItemsLoaded();
            }
            if (this.b) {
                PagedList.this.h = true;
            }
            if (this.c) {
                PagedList.this.i = true;
            }
            PagedList pagedList = PagedList.this;
            int i = PagedList.n;
            pagedList.h(false);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;

        public b(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PagedList pagedList = PagedList.this;
            boolean z = this.a;
            boolean z2 = this.b;
            int i = PagedList.n;
            pagedList.b(z, z2);
        }
    }

    public PagedList(@NonNull f<T> fVar, @NonNull Executor executor, @NonNull Executor executor2, @Nullable BoundaryCallback<T> boundaryCallback, @NonNull Config config) {
        this.e = fVar;
        this.a = executor;
        this.b = executor2;
        this.c = boundaryCallback;
        this.d = config;
    }

    @AnyThread
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.c != null) {
            if (this.j == Integer.MAX_VALUE) {
                this.j = this.e.size();
            }
            if (this.k == Integer.MIN_VALUE) {
                this.k = 0;
            }
            if (z || z2 || z3) {
                this.a.execute(new a(z, z2, z3));
                return;
            }
            return;
        }
        throw new IllegalStateException("Can't defer BoundaryCallback, no instance");
    }

    public void addWeakCallback(@Nullable List<T> list, @NonNull Callback callback) {
        if (!(list == null || list == this)) {
            if (!list.isEmpty()) {
                c((PagedList) list, callback);
            } else if (!this.e.isEmpty()) {
                callback.onInserted(0, this.e.size());
            }
        }
        for (int size = this.m.size() - 1; size >= 0; size--) {
            if (this.m.get(size).get() == null) {
                this.m.remove(size);
            }
        }
        this.m.add(new WeakReference<>(callback));
    }

    public final void b(boolean z, boolean z2) {
        if (z) {
            this.c.onItemAtFrontLoaded(this.e.b.get(0).get(0));
        }
        if (z2) {
            this.c.onItemAtEndLoaded(this.e.d());
        }
    }

    public abstract void c(@NonNull PagedList<T> pagedList, @NonNull Callback callback);

    public abstract boolean d();

    public void detach() {
        this.l.set(true);
    }

    public abstract void e(int i2);

    public void f(int i2, int i3) {
        if (i3 != 0) {
            int size = this.m.size();
            while (true) {
                size--;
                if (size >= 0) {
                    Callback callback = this.m.get(size).get();
                    if (callback != null) {
                        callback.onChanged(i2, i3);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void g(int i2, int i3) {
        if (i3 != 0) {
            int size = this.m.size();
            while (true) {
                size--;
                if (size >= 0) {
                    Callback callback = this.m.get(size).get();
                    if (callback != null) {
                        callback.onInserted(i2, i3);
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // java.util.AbstractList, java.util.List
    @Nullable
    public T get(int i2) {
        T t = this.e.get(i2);
        if (t != null) {
            this.g = t;
        }
        return t;
    }

    @NonNull
    public Config getConfig() {
        return this.d;
    }

    @NonNull
    public abstract DataSource<?, T> getDataSource();

    @Nullable
    public abstract Object getLastKey();

    public int getPositionOffset() {
        return this.e.d;
    }

    public final void h(boolean z) {
        boolean z2 = true;
        boolean z3 = this.h && this.j <= this.d.prefetchDistance;
        if (!this.i || this.k < (size() - 1) - this.d.prefetchDistance) {
            z2 = false;
        }
        if (z3 || z2) {
            if (z3) {
                this.h = false;
            }
            if (z2) {
                this.i = false;
            }
            if (z) {
                this.a.execute(new b(z3, z2));
            } else {
                b(z3, z2);
            }
        }
    }

    public boolean isDetached() {
        return this.l.get();
    }

    public boolean isImmutable() {
        return isDetached();
    }

    public void loadAround(int i2) {
        this.f = getPositionOffset() + i2;
        e(i2);
        this.j = Math.min(this.j, i2);
        this.k = Math.max(this.k, i2);
        h(true);
    }

    public void removeWeakCallback(@NonNull Callback callback) {
        for (int size = this.m.size() - 1; size >= 0; size--) {
            Callback callback2 = this.m.get(size).get();
            if (callback2 == null || callback2 == callback) {
                this.m.remove(size);
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.e.size();
    }

    @NonNull
    public List<T> snapshot() {
        if (isImmutable()) {
            return this;
        }
        return new i(this);
    }

    public static final class Builder<Key, Value> {
        public final DataSource<Key, Value> a;
        public final Config b;
        public Executor c;
        public Executor d;
        public BoundaryCallback e;
        public Key f;

        public Builder(@NonNull DataSource<Key, Value> dataSource, @NonNull Config config) {
            if (dataSource == null) {
                throw new IllegalArgumentException("DataSource may not be null");
            } else if (config != null) {
                this.a = dataSource;
                this.b = config;
            } else {
                throw new IllegalArgumentException("Config may not be null");
            }
        }

        @NonNull
        @WorkerThread
        public PagedList<Value> build() {
            int i;
            DataSource<Key, Value> dataSource;
            Executor executor = this.c;
            if (executor != null) {
                Executor executor2 = this.d;
                if (executor2 != null) {
                    DataSource<Key, Value> dataSource2 = this.a;
                    BoundaryCallback boundaryCallback = this.e;
                    Config config = this.b;
                    Key key = this.f;
                    int i2 = PagedList.n;
                    if (dataSource2.b() || !config.enablePlaceholders) {
                        if (!dataSource2.b()) {
                            dataSource = new PositionalDataSource.a<>((PositionalDataSource) dataSource2);
                            if (key != null) {
                                i = key.intValue();
                                return new l6.s.b((l6.s.a) dataSource, executor, executor2, boundaryCallback, config, key, i);
                            }
                            dataSource2 = dataSource;
                        }
                        dataSource = dataSource2;
                        i = -1;
                        return new l6.s.b((l6.s.a) dataSource, executor, executor2, boundaryCallback, config, key, i);
                    }
                    return new j((PositionalDataSource) dataSource2, executor, executor2, boundaryCallback, config, key != null ? key.intValue() : 0);
                }
                throw new IllegalArgumentException("BackgroundThreadExecutor required");
            }
            throw new IllegalArgumentException("MainThreadExecutor required");
        }

        @NonNull
        public Builder<Key, Value> setBoundaryCallback(@Nullable BoundaryCallback boundaryCallback) {
            this.e = boundaryCallback;
            return this;
        }

        @NonNull
        public Builder<Key, Value> setFetchExecutor(@NonNull Executor executor) {
            this.d = executor;
            return this;
        }

        @NonNull
        public Builder<Key, Value> setInitialKey(@Nullable Key key) {
            this.f = key;
            return this;
        }

        @NonNull
        public Builder<Key, Value> setNotifyExecutor(@NonNull Executor executor) {
            this.c = executor;
            return this;
        }

        public Builder(@NonNull DataSource<Key, Value> dataSource, int i) {
            this(dataSource, new Config.Builder().setPageSize(i).build());
        }
    }
}
