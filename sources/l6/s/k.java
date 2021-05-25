package l6.s;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.ItemKeyedDataSource;
import java.util.IdentityHashMap;
import java.util.List;
public class k<K, A, B> extends ItemKeyedDataSource<K, B> {
    public final ItemKeyedDataSource<K, A> c;
    public final Function<List<A>, List<B>> d;
    public final IdentityHashMap<B, K> e = new IdentityHashMap<>();

    public class a extends ItemKeyedDataSource.LoadInitialCallback<A> {
        public final /* synthetic */ ItemKeyedDataSource.LoadInitialCallback a;

        public a(ItemKeyedDataSource.LoadInitialCallback loadInitialCallback) {
            this.a = loadInitialCallback;
        }

        @Override // androidx.paging.ItemKeyedDataSource.LoadInitialCallback
        public void onResult(@NonNull List<A> list, int i, int i2) {
            this.a.onResult(k.g(k.this, list), i, i2);
        }

        @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
        public void onResult(@NonNull List<A> list) {
            this.a.onResult(k.g(k.this, list));
        }
    }

    public class b extends ItemKeyedDataSource.LoadCallback<A> {
        public final /* synthetic */ ItemKeyedDataSource.LoadCallback a;

        public b(ItemKeyedDataSource.LoadCallback loadCallback) {
            this.a = loadCallback;
        }

        @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
        public void onResult(@NonNull List<A> list) {
            this.a.onResult(k.g(k.this, list));
        }
    }

    public class c extends ItemKeyedDataSource.LoadCallback<A> {
        public final /* synthetic */ ItemKeyedDataSource.LoadCallback a;

        public c(ItemKeyedDataSource.LoadCallback loadCallback) {
            this.a = loadCallback;
        }

        @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
        public void onResult(@NonNull List<A> list) {
            this.a.onResult(k.g(k.this, list));
        }
    }

    public k(ItemKeyedDataSource<K, A> itemKeyedDataSource, Function<List<A>, List<B>> function) {
        this.c = itemKeyedDataSource;
        this.d = function;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: java.util.IdentityHashMap<B, K> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: androidx.paging.ItemKeyedDataSource<K, A> */
    /* JADX WARN: Multi-variable type inference failed */
    public static List g(k kVar, List list) {
        List a3 = DataSource.a(kVar.d, list);
        synchronized (kVar.e) {
            for (int i = 0; i < a3.size(); i++) {
                kVar.e.put(a3.get(i), kVar.c.getKey(list.get(i)));
            }
        }
        return a3;
    }

    @Override // androidx.paging.DataSource
    public void addInvalidatedCallback(@NonNull DataSource.InvalidatedCallback invalidatedCallback) {
        this.c.addInvalidatedCallback(invalidatedCallback);
    }

    @Override // androidx.paging.ItemKeyedDataSource
    @NonNull
    public K getKey(@NonNull B b2) {
        K k;
        synchronized (this.e) {
            k = this.e.get(b2);
        }
        return k;
    }

    @Override // androidx.paging.DataSource
    public void invalidate() {
        this.c.invalidate();
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        return this.c.isInvalid();
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadAfter(@NonNull ItemKeyedDataSource.LoadParams<K> loadParams, @NonNull ItemKeyedDataSource.LoadCallback<B> loadCallback) {
        this.c.loadAfter(loadParams, new b(loadCallback));
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadBefore(@NonNull ItemKeyedDataSource.LoadParams<K> loadParams, @NonNull ItemKeyedDataSource.LoadCallback<B> loadCallback) {
        this.c.loadBefore(loadParams, new c(loadCallback));
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadInitial(@NonNull ItemKeyedDataSource.LoadInitialParams<K> loadInitialParams, @NonNull ItemKeyedDataSource.LoadInitialCallback<B> loadInitialCallback) {
        this.c.loadInitial(loadInitialParams, new a(loadInitialCallback));
    }

    @Override // androidx.paging.DataSource
    public void removeInvalidatedCallback(@NonNull DataSource.InvalidatedCallback invalidatedCallback) {
        this.c.removeInvalidatedCallback(invalidatedCallback);
    }
}
