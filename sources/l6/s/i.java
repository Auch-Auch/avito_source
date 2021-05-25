package l6.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
public class i<T> extends PagedList<T> {
    public final boolean o;
    public final Object p;
    public final DataSource<?, T> q;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i(@androidx.annotation.NonNull androidx.paging.PagedList<T> r8) {
        /*
            r7 = this;
            l6.s.f<T> r0 = r8.e
            java.util.Objects.requireNonNull(r0)
            l6.s.f r2 = new l6.s.f
            r2.<init>(r0)
            java.util.concurrent.Executor r3 = r8.a
            java.util.concurrent.Executor r4 = r8.b
            androidx.paging.PagedList$Config r6 = r8.d
            r5 = 0
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            androidx.paging.DataSource r0 = r8.getDataSource()
            r7.q = r0
            boolean r0 = r8.d()
            r7.o = r0
            int r0 = r8.f
            r7.f = r0
            java.lang.Object r8 = r8.getLastKey()
            r7.p = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.s.i.<init>(androidx.paging.PagedList):void");
    }

    @Override // androidx.paging.PagedList
    public void c(@NonNull PagedList<T> pagedList, @NonNull PagedList.Callback callback) {
    }

    @Override // androidx.paging.PagedList
    public boolean d() {
        return this.o;
    }

    @Override // androidx.paging.PagedList
    public void e(int i) {
    }

    @Override // androidx.paging.PagedList
    @NonNull
    public DataSource<?, T> getDataSource() {
        return this.q;
    }

    @Override // androidx.paging.PagedList
    @Nullable
    public Object getLastKey() {
        return this.p;
    }

    @Override // androidx.paging.PagedList
    public boolean isDetached() {
        return true;
    }

    @Override // androidx.paging.PagedList
    public boolean isImmutable() {
        return true;
    }
}
