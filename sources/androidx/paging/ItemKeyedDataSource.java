package androidx.paging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import java.util.List;
import java.util.concurrent.Executor;
import l6.s.c;
import l6.s.e;
import l6.s.k;
public abstract class ItemKeyedDataSource<Key, Value> extends l6.s.a<Key, Value> {

    public static abstract class LoadCallback<Value> {
        public abstract void onResult(@NonNull List<Value> list);
    }

    public static abstract class LoadInitialCallback<Value> extends LoadCallback<Value> {
        public abstract void onResult(@NonNull List<Value> list, int i, int i2);
    }

    public static class LoadInitialParams<Key> {
        public final boolean placeholdersEnabled;
        @Nullable
        public final Key requestedInitialKey;
        public final int requestedLoadSize;

        public LoadInitialParams(@Nullable Key key, int i, boolean z) {
            this.requestedInitialKey = key;
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

    public static class a<Value> extends LoadCallback<Value> {
        public final DataSource.a<Value> a;

        public a(@NonNull ItemKeyedDataSource itemKeyedDataSource, int i, @Nullable Executor executor, @NonNull e.a<Value> aVar) {
            this.a = new DataSource.a<>(itemKeyedDataSource, i, executor, aVar);
        }

        @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
        public void onResult(@NonNull List<Value> list) {
            if (!this.a.a()) {
                this.a.b(new e<>(list, 0, 0, 0));
            }
        }
    }

    @Override // l6.s.a
    public final void c(int i, @NonNull Value value, int i2, @NonNull Executor executor, @NonNull e.a<Value> aVar) {
        loadAfter(new LoadParams<>(getKey(value), i2), new a(this, 1, executor, aVar));
    }

    @Override // l6.s.a
    public final void d(int i, @NonNull Value value, int i2, @NonNull Executor executor, @NonNull e.a<Value> aVar) {
        loadBefore(new LoadParams<>(getKey(value), i2), new a(this, 2, executor, aVar));
    }

    @Override // l6.s.a
    public final void e(@Nullable Key key, int i, int i2, boolean z, @NonNull Executor executor, @NonNull e.a<Value> aVar) {
        b bVar = new b(this, z, aVar);
        loadInitial(new LoadInitialParams<>(key, i, z), bVar);
        bVar.a.c(executor);
    }

    @Override // l6.s.a
    @Nullable
    public final Key f(int i, Value value) {
        if (value == null) {
            return null;
        }
        return getKey(value);
    }

    @NonNull
    public abstract Key getKey(@NonNull Value value);

    public abstract void loadAfter(@NonNull LoadParams<Key> loadParams, @NonNull LoadCallback<Value> loadCallback);

    public abstract void loadBefore(@NonNull LoadParams<Key> loadParams, @NonNull LoadCallback<Value> loadCallback);

    public abstract void loadInitial(@NonNull LoadInitialParams<Key> loadInitialParams, @NonNull LoadInitialCallback<Value> loadInitialCallback);

    @Override // androidx.paging.DataSource
    @NonNull
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> map(@NonNull Function<Value, ToValue> function) {
        return mapByPage((Function) new c(function));
    }

    @Override // androidx.paging.DataSource
    @NonNull
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> mapByPage(@NonNull Function<List<Value>, List<ToValue>> function) {
        return new k(this, function);
    }

    public static class b<Value> extends LoadInitialCallback<Value> {
        public final DataSource.a<Value> a;
        public final boolean b;

        public b(@NonNull ItemKeyedDataSource itemKeyedDataSource, boolean z, @NonNull e.a<Value> aVar) {
            this.a = new DataSource.a<>(itemKeyedDataSource, 0, null, aVar);
            this.b = z;
        }

        @Override // androidx.paging.ItemKeyedDataSource.LoadInitialCallback
        public void onResult(@NonNull List<Value> list, int i, int i2) {
            if (!this.a.a()) {
                DataSource.a.d(list, i, i2);
                int size = (i2 - i) - list.size();
                if (this.b) {
                    this.a.b(new e<>(list, i, size, 0));
                } else {
                    this.a.b(new e<>(list, i));
                }
            }
        }

        @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
        public void onResult(@NonNull List<Value> list) {
            if (!this.a.a()) {
                this.a.b(new e<>(list, 0, 0, 0));
            }
        }
    }
}
