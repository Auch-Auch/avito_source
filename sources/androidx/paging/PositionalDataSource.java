package androidx.paging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import l6.s.e;
import l6.s.m;
public abstract class PositionalDataSource<T> extends DataSource<Integer, T> {

    public static abstract class LoadInitialCallback<T> {
        public abstract void onResult(@NonNull List<T> list, int i);

        public abstract void onResult(@NonNull List<T> list, int i, int i2);
    }

    public static class LoadInitialParams {
        public final int pageSize;
        public final boolean placeholdersEnabled;
        public final int requestedLoadSize;
        public final int requestedStartPosition;

        public LoadInitialParams(int i, int i2, int i3, boolean z) {
            this.requestedStartPosition = i;
            this.requestedLoadSize = i2;
            this.pageSize = i3;
            this.placeholdersEnabled = z;
        }
    }

    public static abstract class LoadRangeCallback<T> {
        public abstract void onResult(@NonNull List<T> list);
    }

    public static class LoadRangeParams {
        public final int loadSize;
        public final int startPosition;

        public LoadRangeParams(int i, int i2) {
            this.startPosition = i;
            this.loadSize = i2;
        }
    }

    public static class a<Value> extends l6.s.a<Integer, Value> {
        @NonNull
        public final PositionalDataSource<Value> c;

        public a(@NonNull PositionalDataSource<Value> positionalDataSource) {
            this.c = positionalDataSource;
        }

        @Override // androidx.paging.DataSource
        public void addInvalidatedCallback(@NonNull DataSource.InvalidatedCallback invalidatedCallback) {
            this.c.addInvalidatedCallback(invalidatedCallback);
        }

        @Override // l6.s.a
        public void c(int i, @NonNull Value value, int i2, @NonNull Executor executor, @NonNull e.a<Value> aVar) {
            this.c.c(1, i + 1, i2, executor, aVar);
        }

        @Override // l6.s.a
        public void d(int i, @NonNull Value value, int i2, @NonNull Executor executor, @NonNull e.a<Value> aVar) {
            int i3 = i - 1;
            if (i3 < 0) {
                this.c.c(2, i3, 0, executor, aVar);
                return;
            }
            int min = Math.min(i2, i3 + 1);
            this.c.c(2, (i3 - min) + 1, min, executor, aVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, boolean, java.util.concurrent.Executor, l6.s.e$a] */
        @Override // l6.s.a
        public void e(@Nullable Integer num, int i, int i2, boolean z, @NonNull Executor executor, @NonNull e.a aVar) {
            int i3;
            Integer num2 = num;
            if (num2 == null) {
                i3 = 0;
            } else {
                i3 = num2.intValue();
            }
            PositionalDataSource<Value> positionalDataSource = this.c;
            Objects.requireNonNull(positionalDataSource);
            b bVar = new b(positionalDataSource, false, i2, aVar);
            positionalDataSource.loadInitial(new LoadInitialParams(i3, i, i2, false), bVar);
            bVar.a.c(executor);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // l6.s.a
        public Integer f(int i, Object obj) {
            return Integer.valueOf(i);
        }

        @Override // androidx.paging.DataSource
        public void invalidate() {
            this.c.invalidate();
        }

        @Override // androidx.paging.DataSource
        public boolean isInvalid() {
            return this.c.isInvalid();
        }

        @Override // androidx.paging.DataSource
        @NonNull
        public <ToValue> DataSource<Integer, ToValue> map(@NonNull Function<Value, ToValue> function) {
            throw new UnsupportedOperationException("Inaccessible inner type doesn't support map op");
        }

        @Override // androidx.paging.DataSource
        @NonNull
        public <ToValue> DataSource<Integer, ToValue> mapByPage(@NonNull Function<List<Value>, List<ToValue>> function) {
            throw new UnsupportedOperationException("Inaccessible inner type doesn't support map op");
        }

        @Override // androidx.paging.DataSource
        public void removeInvalidatedCallback(@NonNull DataSource.InvalidatedCallback invalidatedCallback) {
            this.c.removeInvalidatedCallback(invalidatedCallback);
        }
    }

    public static class c<T> extends LoadRangeCallback<T> {
        public DataSource.a<T> a;
        public final int b;

        public c(@NonNull PositionalDataSource positionalDataSource, int i, int i2, Executor executor, e.a<T> aVar) {
            this.a = new DataSource.a<>(positionalDataSource, i, executor, aVar);
            this.b = i2;
        }

        @Override // androidx.paging.PositionalDataSource.LoadRangeCallback
        public void onResult(@NonNull List<T> list) {
            if (!this.a.a()) {
                this.a.b(new e<>(list, 0, 0, this.b));
            }
        }
    }

    public static int computeInitialLoadPosition(@NonNull LoadInitialParams loadInitialParams, int i) {
        int i2 = loadInitialParams.requestedStartPosition;
        int i3 = loadInitialParams.requestedLoadSize;
        int i4 = loadInitialParams.pageSize;
        return Math.max(0, Math.min(((((i - i3) + i4) - 1) / i4) * i4, Math.round((float) (i2 / i4)) * i4));
    }

    public static int computeInitialLoadSize(@NonNull LoadInitialParams loadInitialParams, int i, int i2) {
        return Math.min(i2 - i, loadInitialParams.requestedLoadSize);
    }

    @Override // androidx.paging.DataSource
    public boolean b() {
        return false;
    }

    public final void c(int i, int i2, int i3, @NonNull Executor executor, @NonNull e.a<T> aVar) {
        c cVar = new c(this, i, i2, executor, aVar);
        if (i3 == 0) {
            cVar.onResult(Collections.emptyList());
        } else {
            loadRange(new LoadRangeParams(i2, i3), cVar);
        }
    }

    @WorkerThread
    public abstract void loadInitial(@NonNull LoadInitialParams loadInitialParams, @NonNull LoadInitialCallback<T> loadInitialCallback);

    @WorkerThread
    public abstract void loadRange(@NonNull LoadRangeParams loadRangeParams, @NonNull LoadRangeCallback<T> loadRangeCallback);

    @Override // androidx.paging.DataSource
    @NonNull
    public final <V> PositionalDataSource<V> map(@NonNull Function<T, V> function) {
        return mapByPage((Function) new l6.s.c(function));
    }

    @Override // androidx.paging.DataSource
    @NonNull
    public final <V> PositionalDataSource<V> mapByPage(@NonNull Function<List<T>, List<V>> function) {
        return new m(this, function);
    }

    public static class b<T> extends LoadInitialCallback<T> {
        public final DataSource.a<T> a;
        public final boolean b;
        public final int c;

        public b(@NonNull PositionalDataSource positionalDataSource, boolean z, int i, e.a<T> aVar) {
            this.a = new DataSource.a<>(positionalDataSource, 0, null, aVar);
            this.b = z;
            this.c = i;
            if (i < 1) {
                throw new IllegalArgumentException("Page size must be non-negative");
            }
        }

        @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
        public void onResult(@NonNull List<T> list, int i, int i2) {
            if (!this.a.a()) {
                DataSource.a.d(list, i, i2);
                if (list.size() + i != i2 && list.size() % this.c != 0) {
                    StringBuilder L = a2.b.a.a.a.L("PositionalDataSource requires initial load size to be a multiple of page size to support internal tiling. loadSize ");
                    a2.b.a.a.a.t1(list, L, ", position ", i, ", totalCount ");
                    L.append(i2);
                    L.append(", pageSize ");
                    L.append(this.c);
                    throw new IllegalArgumentException(L.toString());
                } else if (this.b) {
                    this.a.b(new e<>(list, i, (i2 - i) - list.size(), 0));
                } else {
                    this.a.b(new e<>(list, i));
                }
            }
        }

        @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
        public void onResult(@NonNull List<T> list, int i) {
            if (this.a.a()) {
                return;
            }
            if (i < 0) {
                throw new IllegalArgumentException("Position must be non-negative");
            } else if (list.isEmpty() && i != 0) {
                throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
            } else if (!this.b) {
                this.a.b(new e<>(list, i));
            } else {
                throw new IllegalStateException("Placeholders requested, but totalCount not provided. Please call the three-parameter onResult method, or disable placeholders in the PagedList.Config");
            }
        }
    }
}
