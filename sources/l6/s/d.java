package l6.s;

import androidx.annotation.Nullable;
import androidx.lifecycle.ComputableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import java.util.concurrent.Executor;
public final class d extends ComputableLiveData<PagedList<Value>> {
    @Nullable
    public PagedList<Value> g;
    @Nullable
    public DataSource<Key, Value> h;
    public final DataSource.InvalidatedCallback i = new a();
    public final /* synthetic */ Object j;
    public final /* synthetic */ DataSource.Factory k;
    public final /* synthetic */ PagedList.Config l;
    public final /* synthetic */ Executor m;
    public final /* synthetic */ Executor n;
    public final /* synthetic */ PagedList.BoundaryCallback o;

    public class a implements DataSource.InvalidatedCallback {
        public a() {
        }

        @Override // androidx.paging.DataSource.InvalidatedCallback
        public void onInvalidated() {
            d.this.invalidate();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Executor executor, Object obj, DataSource.Factory factory, PagedList.Config config, Executor executor2, Executor executor3, PagedList.BoundaryCallback boundaryCallback) {
        super(executor);
        this.j = obj;
        this.k = factory;
        this.l = config;
        this.m = executor2;
        this.n = executor3;
        this.o = boundaryCallback;
    }

    @Override // androidx.lifecycle.ComputableLiveData
    public Object compute() {
        PagedList<Value> build;
        Object obj = this.j;
        PagedList<Value> pagedList = this.g;
        if (pagedList != null) {
            obj = pagedList.getLastKey();
        }
        do {
            DataSource<Key, Value> dataSource = this.h;
            if (dataSource != null) {
                dataSource.removeInvalidatedCallback(this.i);
            }
            DataSource<Key, Value> create = this.k.create();
            this.h = create;
            create.addInvalidatedCallback(this.i);
            build = new PagedList.Builder(this.h, this.l).setNotifyExecutor(this.m).setFetchExecutor(this.n).setBoundaryCallback(this.o).setInitialKey(obj).build();
            this.g = build;
        } while (build.isDetached());
        return this.g;
    }
}
