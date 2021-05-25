package androidx.paging;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import java.util.List;
import java.util.concurrent.Executor;
import l6.s.c;
import l6.s.e;
import l6.s.l;
public abstract class PageKeyedDataSource<Key, Value> extends l6.s.a<Key, Value> {
    public final Object c = new Object();
    @Nullable
    @GuardedBy("mKeyLock")
    public Key d = null;
    @Nullable
    @GuardedBy("mKeyLock")
    public Key e = null;

    public static abstract class LoadCallback<Key, Value> {
        public abstract void onResult(@NonNull List<Value> list, @Nullable Key key);
    }

    public static abstract class LoadInitialCallback<Key, Value> {
        public abstract void onResult(@NonNull List<Value> list, int i, int i2, @Nullable Key key, @Nullable Key key2);

        public abstract void onResult(@NonNull List<Value> list, @Nullable Key key, @Nullable Key key2);
    }

    public static class LoadInitialParams<Key> {
        public final boolean placeholdersEnabled;
        public final int requestedLoadSize;

        public LoadInitialParams(int i, boolean z) {
            this.requestedLoadSize = i;
            this.placeholdersEnabled = z;
        }
    }

    public static class LoadParams<Key> {
        public final Key key;
        public final int requestedLoadSize;

        public LoadParams(Key key2, int i) {
            this.key = key2;
            this.requestedLoadSize = i;
        }
    }

    public static class a<Key, Value> extends LoadCallback<Key, Value> {
        public final DataSource.a<Value> a;
        public final PageKeyedDataSource<Key, Value> b;

        public a(@NonNull PageKeyedDataSource<Key, Value> pageKeyedDataSource, int i, @Nullable Executor executor, @NonNull e.a<Value> aVar) {
            this.a = new DataSource.a<>(pageKeyedDataSource, i, executor, aVar);
            this.b = pageKeyedDataSource;
        }

        @Override // androidx.paging.PageKeyedDataSource.LoadCallback
        public void onResult(@NonNull List<Value> list, @Nullable Key key) {
            if (!this.a.a()) {
                if (this.a.a == 1) {
                    PageKeyedDataSource<Key, Value> pageKeyedDataSource = this.b;
                    synchronized (pageKeyedDataSource.c) {
                        pageKeyedDataSource.d = key;
                    }
                } else {
                    PageKeyedDataSource<Key, Value> pageKeyedDataSource2 = this.b;
                    synchronized (pageKeyedDataSource2.c) {
                        pageKeyedDataSource2.e = key;
                    }
                }
                this.a.b(new e<>(list, 0, 0, 0));
            }
        }
    }

    @Override // l6.s.a
    public final void c(int i, @NonNull Value value, int i2, @NonNull Executor executor, @NonNull e.a<Value> aVar) {
        Key key;
        synchronized (this.c) {
            key = this.d;
        }
        if (key != null) {
            loadAfter(new LoadParams<>(key, i2), new a(this, 1, executor, aVar));
        } else {
            aVar.a(1, e.e);
        }
    }

    @Override // l6.s.a
    public final void d(int i, @NonNull Value value, int i2, @NonNull Executor executor, @NonNull e.a<Value> aVar) {
        Key key;
        synchronized (this.c) {
            key = this.e;
        }
        if (key != null) {
            loadBefore(new LoadParams<>(key, i2), new a(this, 2, executor, aVar));
        } else {
            aVar.a(2, e.e);
        }
    }

    @Override // l6.s.a
    public final void e(@Nullable Key key, int i, int i2, boolean z, @NonNull Executor executor, @NonNull e.a<Value> aVar) {
        b bVar = new b(this, z, aVar);
        loadInitial(new LoadInitialParams<>(i, z), bVar);
        bVar.a.c(executor);
    }

    @Override // l6.s.a
    @Nullable
    public final Key f(int i, Value value) {
        return null;
    }

    public abstract void loadAfter(@NonNull LoadParams<Key> loadParams, @NonNull LoadCallback<Key, Value> loadCallback);

    public abstract void loadBefore(@NonNull LoadParams<Key> loadParams, @NonNull LoadCallback<Key, Value> loadCallback);

    public abstract void loadInitial(@NonNull LoadInitialParams<Key> loadInitialParams, @NonNull LoadInitialCallback<Key, Value> loadInitialCallback);

    @Override // androidx.paging.DataSource
    @NonNull
    public final <ToValue> PageKeyedDataSource<Key, ToValue> map(@NonNull Function<Value, ToValue> function) {
        return mapByPage((Function) new c(function));
    }

    @Override // androidx.paging.DataSource
    @NonNull
    public final <ToValue> PageKeyedDataSource<Key, ToValue> mapByPage(@NonNull Function<List<Value>, List<ToValue>> function) {
        return new l(this, function);
    }

    public static class b<Key, Value> extends LoadInitialCallback<Key, Value> {
        public final DataSource.a<Value> a;
        public final PageKeyedDataSource<Key, Value> b;
        public final boolean c;

        public b(@NonNull PageKeyedDataSource<Key, Value> pageKeyedDataSource, boolean z, @NonNull e.a<Value> aVar) {
            this.a = new DataSource.a<>(pageKeyedDataSource, 0, null, aVar);
            this.b = pageKeyedDataSource;
            this.c = z;
        }

        @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
        public void onResult(@NonNull List<Value> list, int i, int i2, @Nullable Key key, @Nullable Key key2) {
            if (!this.a.a()) {
                DataSource.a.d(list, i, i2);
                PageKeyedDataSource<Key, Value> pageKeyedDataSource = this.b;
                synchronized (pageKeyedDataSource.c) {
                    pageKeyedDataSource.e = key;
                    pageKeyedDataSource.d = key2;
                }
                int size = (i2 - i) - list.size();
                if (this.c) {
                    this.a.b(new e<>(list, i, size, 0));
                } else {
                    this.a.b(new e<>(list, i));
                }
            }
        }

        @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
        public void onResult(@NonNull List<Value> list, @Nullable Key key, @Nullable Key key2) {
            if (!this.a.a()) {
                PageKeyedDataSource<Key, Value> pageKeyedDataSource = this.b;
                synchronized (pageKeyedDataSource.c) {
                    pageKeyedDataSource.e = key;
                    pageKeyedDataSource.d = key2;
                }
                this.a.b(new e<>(list, 0, 0, 0));
            }
        }
    }
}
