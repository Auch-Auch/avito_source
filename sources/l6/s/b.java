package l6.s;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import l6.s.e;
import l6.s.f;
public class b<K, V> extends PagedList<V> implements f.a {
    public final a<K, V> o;
    public boolean p = false;
    public boolean q = false;
    public int r = 0;
    public int s = 0;
    public e.a<V> t = new a();

    public class a extends e.a<V> {
        public a() {
        }

        @Override // l6.s.e.a
        @AnyThread
        public void a(int i, @NonNull e<V> eVar) {
            Objects.requireNonNull(eVar);
            boolean z = true;
            if (eVar == e.f) {
                b.this.detach();
            } else if (!b.this.isDetached()) {
                List<T> list = eVar.a;
                if (i == 0) {
                    b bVar = b.this;
                    f<T> fVar = bVar.e;
                    fVar.g(eVar.b, list, eVar.c, eVar.d);
                    bVar.g(0, fVar.size());
                    b bVar2 = b.this;
                    if (bVar2.f == -1) {
                        bVar2.f = (list.size() / 2) + eVar.b + eVar.d;
                    }
                } else if (i == 1) {
                    b bVar3 = b.this;
                    f<T> fVar2 = bVar3.e;
                    Objects.requireNonNull(fVar2);
                    int size = list.size();
                    if (size != 0) {
                        if (fVar2.f > 0) {
                            ArrayList<List<T>> arrayList = fVar2.b;
                            int size2 = arrayList.get(arrayList.size() - 1).size();
                            int i2 = fVar2.f;
                            if (size2 != i2 || size > i2) {
                                fVar2.f = -1;
                            }
                        }
                        fVar2.b.add(list);
                        fVar2.e += size;
                        int min = Math.min(fVar2.c, size);
                        int i3 = size - min;
                        if (min != 0) {
                            fVar2.c -= min;
                        }
                        fVar2.h += size;
                        bVar3.i((fVar2.a + fVar2.e) - size, min, i3);
                    }
                } else if (i == 2) {
                    b bVar4 = b.this;
                    f<T> fVar3 = bVar4.e;
                    Objects.requireNonNull(fVar3);
                    int size3 = list.size();
                    if (size3 != 0) {
                        int i4 = fVar3.f;
                        if (i4 > 0 && size3 != i4) {
                            if (fVar3.b.size() != 1 || size3 <= fVar3.f) {
                                fVar3.f = -1;
                            } else {
                                fVar3.f = size3;
                            }
                        }
                        fVar3.b.add(0, list);
                        fVar3.e += size3;
                        int min2 = Math.min(fVar3.a, size3);
                        int i5 = size3 - min2;
                        if (min2 != 0) {
                            fVar3.a -= min2;
                        }
                        fVar3.d -= i5;
                        fVar3.g += size3;
                        bVar4.j(fVar3.a, min2, i5);
                    }
                } else {
                    throw new IllegalArgumentException(a2.b.a.a.a.M2("unexpected resultType ", i));
                }
                b bVar5 = b.this;
                if (bVar5.c != null) {
                    boolean z2 = bVar5.e.size() == 0;
                    boolean z3 = !z2 && i == 2 && eVar.a.size() == 0;
                    if (!(!z2 && i == 1 && eVar.a.size() == 0)) {
                        z = false;
                    }
                    b.this.a(z2, z3, z);
                }
            }
        }
    }

    /* renamed from: l6.s.b$b  reason: collision with other inner class name */
    public class RunnableC0535b implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public RunnableC0535b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: l6.s.a<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.isDetached()) {
                if (b.this.o.isInvalid()) {
                    b.this.detach();
                    return;
                }
                b bVar = b.this;
                bVar.o.d(this.a, this.b, bVar.d.pageSize, bVar.a, bVar.t);
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public c(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: l6.s.a<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.isDetached()) {
                if (b.this.o.isInvalid()) {
                    b.this.detach();
                    return;
                }
                b bVar = b.this;
                bVar.o.c(this.a, this.b, bVar.d.pageSize, bVar.a, bVar.t);
            }
        }
    }

    public b(@NonNull a<K, V> aVar, @NonNull Executor executor, @NonNull Executor executor2, @Nullable PagedList.BoundaryCallback<V> boundaryCallback, @NonNull PagedList.Config config, @Nullable K k, int i) {
        super(new f(), executor, executor2, boundaryCallback, config);
        this.o = aVar;
        this.f = i;
        if (aVar.isInvalid()) {
            detach();
            return;
        }
        PagedList.Config config2 = this.d;
        aVar.e(k, config2.initialLoadSizeHint, config2.pageSize, config2.enablePlaceholders, this.a, this.t);
    }

    @Override // androidx.paging.PagedList
    @MainThread
    public void c(@NonNull PagedList<V> pagedList, @NonNull PagedList.Callback callback) {
        f<T> fVar = pagedList.e;
        f<T> fVar2 = this.e;
        int i = fVar2.h - fVar.h;
        int i2 = fVar2.g - fVar.g;
        int i3 = fVar.c;
        int i4 = fVar.a;
        if (fVar.isEmpty() || i < 0 || i2 < 0 || this.e.c != Math.max(i3 - i, 0) || this.e.a != Math.max(i4 - i2, 0) || this.e.e != fVar.e + i + i2) {
            throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
        }
        if (i != 0) {
            int min = Math.min(i3, i);
            int i5 = i - min;
            int i6 = fVar.a + fVar.e;
            if (min != 0) {
                callback.onChanged(i6, min);
            }
            if (i5 != 0) {
                callback.onInserted(i6 + min, i5);
            }
        }
        if (i2 != 0) {
            int min2 = Math.min(i4, i2);
            int i7 = i2 - min2;
            if (min2 != 0) {
                callback.onChanged(i4, min2);
            }
            if (i7 != 0) {
                callback.onInserted(0, i7);
            }
        }
    }

    @Override // androidx.paging.PagedList
    public boolean d() {
        return true;
    }

    @Override // androidx.paging.PagedList
    @MainThread
    public void e(int i) {
        int i2 = this.d.prefetchDistance;
        f<T> fVar = this.e;
        int i3 = fVar.a;
        int i4 = i2 - (i - i3);
        int i5 = (i + i2) - (i3 + fVar.e);
        int max = Math.max(i4, this.r);
        this.r = max;
        if (max > 0) {
            l();
        }
        int max2 = Math.max(i5, this.s);
        this.s = max2;
        if (max2 > 0) {
            k();
        }
    }

    @Override // androidx.paging.PagedList
    @NonNull
    public DataSource<?, V> getDataSource() {
        return this.o;
    }

    @Override // androidx.paging.PagedList
    @Nullable
    public Object getLastKey() {
        return this.o.f(this.f, this.g);
    }

    @MainThread
    public void i(int i, int i2, int i3) {
        int i4 = (this.s - i2) - i3;
        this.s = i4;
        this.q = false;
        if (i4 > 0) {
            k();
        }
        f(i, i2);
        g(i + i2, i3);
    }

    @MainThread
    public void j(int i, int i2, int i3) {
        int i4 = (this.r - i2) - i3;
        this.r = i4;
        this.p = false;
        if (i4 > 0) {
            l();
        }
        f(i, i2);
        g(0, i3);
        this.f += i3;
        this.j += i3;
        this.k += i3;
    }

    @MainThread
    public final void k() {
        if (!this.q) {
            this.q = true;
            f<T> fVar = this.e;
            this.b.execute(new c(((fVar.a + fVar.e) - 1) + fVar.d, fVar.d()));
        }
    }

    @MainThread
    public final void l() {
        if (!this.p) {
            this.p = true;
            f<T> fVar = this.e;
            this.b.execute(new RunnableC0535b(fVar.a + fVar.d, fVar.b.get(0).get(0)));
        }
    }
}
