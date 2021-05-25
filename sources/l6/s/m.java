package l6.s;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import java.util.List;
public class m<A, B> extends PositionalDataSource<B> {
    public final PositionalDataSource<A> c;
    public final Function<List<A>, List<B>> d;

    public class b extends PositionalDataSource.LoadRangeCallback<A> {
        public final /* synthetic */ PositionalDataSource.LoadRangeCallback a;

        public b(PositionalDataSource.LoadRangeCallback loadRangeCallback) {
            this.a = loadRangeCallback;
        }

        @Override // androidx.paging.PositionalDataSource.LoadRangeCallback
        public void onResult(@NonNull List<A> list) {
            this.a.onResult(DataSource.a(m.this.d, list));
        }
    }

    public m(PositionalDataSource<A> positionalDataSource, Function<List<A>, List<B>> function) {
        this.c = positionalDataSource;
        this.d = function;
    }

    @Override // androidx.paging.DataSource
    public void addInvalidatedCallback(@NonNull DataSource.InvalidatedCallback invalidatedCallback) {
        this.c.addInvalidatedCallback(invalidatedCallback);
    }

    @Override // androidx.paging.DataSource
    public void invalidate() {
        this.c.invalidate();
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        return this.c.isInvalid();
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadInitial(@NonNull PositionalDataSource.LoadInitialParams loadInitialParams, @NonNull PositionalDataSource.LoadInitialCallback<B> loadInitialCallback) {
        this.c.loadInitial(loadInitialParams, new a(loadInitialCallback));
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadRange(@NonNull PositionalDataSource.LoadRangeParams loadRangeParams, @NonNull PositionalDataSource.LoadRangeCallback<B> loadRangeCallback) {
        this.c.loadRange(loadRangeParams, new b(loadRangeCallback));
    }

    @Override // androidx.paging.DataSource
    public void removeInvalidatedCallback(@NonNull DataSource.InvalidatedCallback invalidatedCallback) {
        this.c.removeInvalidatedCallback(invalidatedCallback);
    }

    public class a extends PositionalDataSource.LoadInitialCallback<A> {
        public final /* synthetic */ PositionalDataSource.LoadInitialCallback a;

        public a(PositionalDataSource.LoadInitialCallback loadInitialCallback) {
            this.a = loadInitialCallback;
        }

        @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
        public void onResult(@NonNull List<A> list, int i, int i2) {
            this.a.onResult(DataSource.a(m.this.d, list), i, i2);
        }

        @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
        public void onResult(@NonNull List<A> list, int i) {
            this.a.onResult(DataSource.a(m.this.d, list), i);
        }
    }
}
