package l6.s;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import androidx.paging.PositionalDataSource;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import l6.s.e;
import l6.s.f;
public class j<T> extends PagedList<T> implements f.a {
    public final PositionalDataSource<T> o;
    public e.a<T> p = new a();

    public class a extends e.a<T> {
        public a() {
        }

        @Override // l6.s.e.a
        @AnyThread
        public void a(int i, @NonNull e<T> eVar) {
            Objects.requireNonNull(eVar);
            if (eVar == e.f) {
                j.this.detach();
            } else if (!j.this.isDetached()) {
                if (i == 0 || i == 3) {
                    if (j.this.e.e() == 0) {
                        j jVar = j.this;
                        f<T> fVar = jVar.e;
                        int i2 = eVar.b;
                        List<T> list = eVar.a;
                        int i3 = eVar.c;
                        int i4 = eVar.d;
                        int i5 = jVar.d.pageSize;
                        Objects.requireNonNull(fVar);
                        int size = ((i5 - 1) + list.size()) / i5;
                        int i6 = 0;
                        while (i6 < size) {
                            int i7 = i6 * i5;
                            int i8 = i6 + 1;
                            List<T> subList = list.subList(i7, Math.min(list.size(), i8 * i5));
                            if (i6 == 0) {
                                fVar.g(i2, subList, (list.size() + i3) - subList.size(), i4);
                            } else {
                                fVar.h(i7 + i2, subList, null);
                            }
                            i6 = i8;
                        }
                        jVar.g(0, fVar.size());
                    } else {
                        j jVar2 = j.this;
                        jVar2.e.h(eVar.d, eVar.a, jVar2);
                    }
                    j jVar3 = j.this;
                    if (jVar3.c != null) {
                        boolean z = jVar3.e.size() == 0;
                        j.this.a(z, !z && eVar.b == 0 && eVar.d == 0, !z && ((i == 0 && eVar.c == 0) || (i == 3 && eVar.d + j.this.d.pageSize >= j.this.size())));
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(a2.b.a.a.a.M2("unexpected resultType", i));
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!j.this.isDetached()) {
                j jVar = j.this;
                int i = jVar.d.pageSize;
                if (jVar.o.isInvalid()) {
                    j.this.detach();
                    return;
                }
                int i2 = this.a * i;
                int min = Math.min(i, j.this.e.size() - i2);
                j jVar2 = j.this;
                jVar2.o.c(3, i2, min, jVar2.a, jVar2.p);
            }
        }
    }

    @WorkerThread
    public j(@NonNull PositionalDataSource<T> positionalDataSource, @NonNull Executor executor, @NonNull Executor executor2, @Nullable PagedList.BoundaryCallback<T> boundaryCallback, @NonNull PagedList.Config config, int i) {
        super(new f(), executor, executor2, boundaryCallback, config);
        this.o = positionalDataSource;
        int i2 = this.d.pageSize;
        this.f = i;
        if (positionalDataSource.isInvalid()) {
            detach();
            return;
        }
        int max = Math.max(Math.round((float) (this.d.initialLoadSizeHint / i2)), 2) * i2;
        int max2 = Math.max(0, Math.round((float) ((i - (max / 2)) / i2)) * i2);
        Executor executor3 = this.a;
        PositionalDataSource.b bVar = new PositionalDataSource.b(positionalDataSource, true, i2, this.p);
        positionalDataSource.loadInitial(new PositionalDataSource.LoadInitialParams(max2, max, i2, true), bVar);
        bVar.a.c(executor3);
    }

    @Override // androidx.paging.PagedList
    public void c(@NonNull PagedList<T> pagedList, @NonNull PagedList.Callback callback) {
        f<T> fVar = pagedList.e;
        if (fVar.isEmpty() || this.e.size() != fVar.size()) {
            throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
        }
        int i = this.d.pageSize;
        f<T> fVar2 = this.e;
        int i2 = fVar2.a / i;
        int e = fVar2.e();
        int i3 = 0;
        while (i3 < e) {
            int i4 = i3 + i2;
            int i5 = 0;
            while (i5 < this.e.e()) {
                int i6 = i4 + i5;
                if (!this.e.f(i, i6) || fVar.f(i, i6)) {
                    break;
                }
                i5++;
            }
            if (i5 > 0) {
                callback.onChanged(i4 * i, i * i5);
                i3 += i5 - 1;
            }
            i3++;
        }
    }

    @Override // androidx.paging.PagedList
    public boolean d() {
        return false;
    }

    @Override // androidx.paging.PagedList
    public void e(int i) {
        f<T> fVar = this.e;
        PagedList.Config config = this.d;
        int i2 = config.prefetchDistance;
        int i3 = config.pageSize;
        int i4 = fVar.f;
        if (i3 != i4) {
            if (i3 < i4) {
                throw new IllegalArgumentException("Page size cannot be reduced");
            } else if (fVar.b.size() == 1 && fVar.c == 0) {
                fVar.f = i3;
            } else {
                throw new IllegalArgumentException("Page size can change only if last page is only one present");
            }
        }
        int size = fVar.size();
        int i5 = fVar.f;
        int i6 = ((size + i5) - 1) / i5;
        int max = Math.max((i - i2) / i5, 0);
        int min = Math.min((i + i2) / fVar.f, i6 - 1);
        fVar.a(max, min);
        int i7 = fVar.a / fVar.f;
        while (max <= min) {
            int i8 = max - i7;
            if (fVar.b.get(i8) == null) {
                fVar.b.set(i8, f.i);
                i(max);
            }
            max++;
        }
    }

    @Override // androidx.paging.PagedList
    @NonNull
    public DataSource<?, T> getDataSource() {
        return this.o;
    }

    @Override // androidx.paging.PagedList
    @Nullable
    public Object getLastKey() {
        return Integer.valueOf(this.f);
    }

    public void i(int i) {
        this.b.execute(new b(i));
    }
}
