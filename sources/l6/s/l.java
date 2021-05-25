package l6.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;
import java.util.List;
public class l<K, A, B> extends PageKeyedDataSource<K, B> {
    public final PageKeyedDataSource<K, A> f;
    public final Function<List<A>, List<B>> g;

    public class b extends PageKeyedDataSource.LoadCallback<K, A> {
        public final /* synthetic */ PageKeyedDataSource.LoadCallback a;

        public b(PageKeyedDataSource.LoadCallback loadCallback) {
            this.a = loadCallback;
        }

        @Override // androidx.paging.PageKeyedDataSource.LoadCallback
        public void onResult(@NonNull List<A> list, @Nullable K k) {
            this.a.onResult(DataSource.a(l.this.g, list), k);
        }
    }

    public class c extends PageKeyedDataSource.LoadCallback<K, A> {
        public final /* synthetic */ PageKeyedDataSource.LoadCallback a;

        public c(PageKeyedDataSource.LoadCallback loadCallback) {
            this.a = loadCallback;
        }

        @Override // androidx.paging.PageKeyedDataSource.LoadCallback
        public void onResult(@NonNull List<A> list, @Nullable K k) {
            this.a.onResult(DataSource.a(l.this.g, list), k);
        }
    }

    public l(PageKeyedDataSource<K, A> pageKeyedDataSource, Function<List<A>, List<B>> function) {
        this.f = pageKeyedDataSource;
        this.g = function;
    }

    @Override // androidx.paging.DataSource
    public void addInvalidatedCallback(@NonNull DataSource.InvalidatedCallback invalidatedCallback) {
        this.f.addInvalidatedCallback(invalidatedCallback);
    }

    @Override // androidx.paging.DataSource
    public void invalidate() {
        this.f.invalidate();
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        return this.f.isInvalid();
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadAfter(@NonNull PageKeyedDataSource.LoadParams<K> loadParams, @NonNull PageKeyedDataSource.LoadCallback<K, B> loadCallback) {
        this.f.loadAfter(loadParams, new c(loadCallback));
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadBefore(@NonNull PageKeyedDataSource.LoadParams<K> loadParams, @NonNull PageKeyedDataSource.LoadCallback<K, B> loadCallback) {
        this.f.loadBefore(loadParams, new b(loadCallback));
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadInitial(@NonNull PageKeyedDataSource.LoadInitialParams<K> loadInitialParams, @NonNull PageKeyedDataSource.LoadInitialCallback<K, B> loadInitialCallback) {
        this.f.loadInitial(loadInitialParams, new a(loadInitialCallback));
    }

    @Override // androidx.paging.DataSource
    public void removeInvalidatedCallback(@NonNull DataSource.InvalidatedCallback invalidatedCallback) {
        this.f.removeInvalidatedCallback(invalidatedCallback);
    }

    public class a extends PageKeyedDataSource.LoadInitialCallback<K, A> {
        public final /* synthetic */ PageKeyedDataSource.LoadInitialCallback a;

        public a(PageKeyedDataSource.LoadInitialCallback loadInitialCallback) {
            this.a = loadInitialCallback;
        }

        @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
        public void onResult(@NonNull List<A> list, int i, int i2, @Nullable K k, @Nullable K k2) {
            this.a.onResult(DataSource.a(l.this.g, list), i, i2, k, k2);
        }

        @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
        public void onResult(@NonNull List<A> list, @Nullable K k, @Nullable K k2) {
            this.a.onResult(DataSource.a(l.this.g, list), k, k2);
        }
    }
}
