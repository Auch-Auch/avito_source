package androidx.paging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import java.util.concurrent.Executor;
import l6.s.d;
public final class LivePagedListBuilder<Key, Value> {
    public Key a;
    public PagedList.Config b;
    public DataSource.Factory<Key, Value> c;
    public PagedList.BoundaryCallback d;
    public Executor e;

    public LivePagedListBuilder(@NonNull DataSource.Factory<Key, Value> factory, @NonNull PagedList.Config config) {
        this.e = ArchTaskExecutor.getIOThreadExecutor();
        if (config == null) {
            throw new IllegalArgumentException("PagedList.Config must be provided");
        } else if (factory != null) {
            this.c = factory;
            this.b = config;
        } else {
            throw new IllegalArgumentException("DataSource.Factory must be provided");
        }
    }

    @NonNull
    public LiveData<PagedList<Value>> build() {
        Key key = this.a;
        PagedList.Config config = this.b;
        PagedList.BoundaryCallback boundaryCallback = this.d;
        DataSource.Factory<Key, Value> factory = this.c;
        Executor mainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        Executor executor = this.e;
        return new d(executor, key, factory, config, mainThreadExecutor, executor, boundaryCallback).getLiveData();
    }

    @NonNull
    public LivePagedListBuilder<Key, Value> setBoundaryCallback(@Nullable PagedList.BoundaryCallback<Value> boundaryCallback) {
        this.d = boundaryCallback;
        return this;
    }

    @NonNull
    public LivePagedListBuilder<Key, Value> setFetchExecutor(@NonNull Executor executor) {
        this.e = executor;
        return this;
    }

    @NonNull
    public LivePagedListBuilder<Key, Value> setInitialLoadKey(@Nullable Key key) {
        this.a = key;
        return this;
    }

    public LivePagedListBuilder(@NonNull DataSource.Factory<Key, Value> factory, int i) {
        this(factory, new PagedList.Config.Builder().setPageSize(i).build());
    }
}
