package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
public class IncreasingQualityDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public final List<Supplier<DataSource<T>>> a;
    public final boolean b;

    @ThreadSafe
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        public ArrayList<DataSource<T>> i;
        @GuardedBy("IncreasingQualityDataSource.this")
        public int j;
        public int k;
        public AtomicInteger l;
        @Nullable
        public Throwable m;
        @Nullable
        public Map<String, Object> n;

        /* renamed from: com.facebook.datasource.IncreasingQualityDataSourceSupplier$a$a  reason: collision with other inner class name */
        public class C0179a implements DataSubscriber<T> {
            public int a;

            public C0179a(int i) {
                this.a = i;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> dataSource) {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> dataSource) {
                a.c(a.this, this.a, dataSource);
            }

            /* JADX WARNING: Removed duplicated region for block: B:20:0x0034  */
            @Override // com.facebook.datasource.DataSubscriber
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onNewResult(com.facebook.datasource.DataSource<T> r6) {
                /*
                    r5 = this;
                    boolean r0 = r6.hasResult()
                    if (r0 == 0) goto L_0x0071
                    com.facebook.datasource.IncreasingQualityDataSourceSupplier$a r0 = com.facebook.datasource.IncreasingQualityDataSourceSupplier.a.this
                    int r1 = r5.a
                    java.util.Objects.requireNonNull(r0)
                    boolean r2 = r6.isFinished()
                    monitor-enter(r0)
                    int r3 = r0.j     // Catch:{ all -> 0x006e }
                    com.facebook.datasource.DataSource r4 = r0.f(r1)     // Catch:{ all -> 0x006e }
                    if (r6 != r4) goto L_0x0040
                    int r4 = r0.j     // Catch:{ all -> 0x006e }
                    if (r1 != r4) goto L_0x001f
                    goto L_0x0040
                L_0x001f:
                    com.facebook.datasource.DataSource r4 = r0.g()     // Catch:{ all -> 0x006e }
                    if (r4 == 0) goto L_0x002e
                    if (r2 == 0) goto L_0x002c
                    int r2 = r0.j     // Catch:{ all -> 0x006e }
                    if (r1 >= r2) goto L_0x002c
                    goto L_0x002e
                L_0x002c:
                    r2 = r3
                    goto L_0x0031
                L_0x002e:
                    r0.j = r1     // Catch:{ all -> 0x006e }
                    r2 = r1
                L_0x0031:
                    monitor-exit(r0)     // Catch:{ all -> 0x006e }
                L_0x0032:
                    if (r3 <= r2) goto L_0x0041
                    com.facebook.datasource.DataSource r4 = r0.e(r3)
                    if (r4 == 0) goto L_0x003d
                    r4.close()
                L_0x003d:
                    int r3 = r3 + -1
                    goto L_0x0032
                L_0x0040:
                    monitor-exit(r0)
                L_0x0041:
                    com.facebook.datasource.DataSource r2 = r0.g()
                    if (r6 != r2) goto L_0x005a
                    r2 = 0
                    if (r1 != 0) goto L_0x0052
                    boolean r1 = r6.isFinished()
                    if (r1 == 0) goto L_0x0052
                    r1 = 1
                    goto L_0x0053
                L_0x0052:
                    r1 = 0
                L_0x0053:
                    java.util.Map r6 = r6.getExtras()
                    r0.setResult(r2, r1, r6)
                L_0x005a:
                    java.util.concurrent.atomic.AtomicInteger r6 = r0.l
                    int r6 = r6.incrementAndGet()
                    int r1 = r0.k
                    if (r6 != r1) goto L_0x007e
                    java.lang.Throwable r6 = r0.m
                    if (r6 == 0) goto L_0x007e
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r0.n
                    r0.setFailure(r6, r1)
                    goto L_0x007e
                L_0x006e:
                    r6 = move-exception
                    monitor-exit(r0)
                    throw r6
                L_0x0071:
                    boolean r0 = r6.isFinished()
                    if (r0 == 0) goto L_0x007e
                    com.facebook.datasource.IncreasingQualityDataSourceSupplier$a r0 = com.facebook.datasource.IncreasingQualityDataSourceSupplier.a.this
                    int r1 = r5.a
                    com.facebook.datasource.IncreasingQualityDataSourceSupplier.a.c(r0, r1, r6)
                L_0x007e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.IncreasingQualityDataSourceSupplier.a.C0179a.onNewResult(com.facebook.datasource.DataSource):void");
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource) {
                if (this.a == 0) {
                    a.this.setProgress(dataSource.getProgress());
                }
            }
        }

        public a() {
            if (!IncreasingQualityDataSourceSupplier.this.b) {
                d();
            }
        }

        public static void c(a aVar, int i2, DataSource dataSource) {
            DataSource dataSource2;
            Throwable th;
            synchronized (aVar) {
                if (dataSource == aVar.g()) {
                    dataSource2 = null;
                } else if (dataSource == aVar.f(i2)) {
                    dataSource2 = aVar.e(i2);
                } else {
                    dataSource2 = dataSource;
                }
            }
            if (dataSource2 != null) {
                dataSource2.close();
            }
            if (i2 == 0) {
                aVar.m = dataSource.getFailureCause();
                aVar.n = dataSource.getExtras();
            }
            if (aVar.l.incrementAndGet() == aVar.k && (th = aVar.m) != null) {
                aVar.setFailure(th, aVar.n);
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean close() {
            int i2;
            ArrayList<DataSource<T>> arrayList;
            if (IncreasingQualityDataSourceSupplier.this.b) {
                d();
            }
            synchronized (this) {
                if (!super.close()) {
                    return false;
                }
                arrayList = this.i;
                this.i = null;
            }
            if (arrayList == null) {
                return true;
            }
            for (i2 = 0; i2 < arrayList.size(); i2++) {
                DataSource<T> dataSource = arrayList.get(i2);
                if (dataSource != null) {
                    dataSource.close();
                }
            }
            return true;
        }

        public final void d() {
            if (this.l == null) {
                synchronized (this) {
                    if (this.l == null) {
                        int i2 = 0;
                        this.l = new AtomicInteger(0);
                        int size = IncreasingQualityDataSourceSupplier.this.a.size();
                        this.k = size;
                        this.j = size;
                        this.i = new ArrayList<>(size);
                        while (true) {
                            if (i2 >= size) {
                                break;
                            }
                            DataSource<T> dataSource = IncreasingQualityDataSourceSupplier.this.a.get(i2).get();
                            this.i.add(dataSource);
                            dataSource.subscribe(new C0179a(i2), CallerThreadExecutor.getInstance());
                            if (dataSource.hasResult()) {
                                break;
                            }
                            i2++;
                        }
                    }
                }
            }
        }

        @Nullable
        public final synchronized DataSource<T> e(int i2) {
            DataSource<T> dataSource;
            ArrayList<DataSource<T>> arrayList = this.i;
            dataSource = null;
            if (arrayList != null && i2 < arrayList.size()) {
                dataSource = this.i.set(i2, null);
            }
            return dataSource;
        }

        @Nullable
        public final synchronized DataSource<T> f(int i2) {
            ArrayList<DataSource<T>> arrayList;
            arrayList = this.i;
            return (arrayList == null || i2 >= arrayList.size()) ? null : this.i.get(i2);
        }

        @Nullable
        public final synchronized DataSource<T> g() {
            return f(this.j);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @Nullable
        public synchronized T getResult() {
            DataSource<T> g;
            if (IncreasingQualityDataSourceSupplier.this.b) {
                d();
            }
            g = g();
            return g != null ? g.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean hasResult() {
            DataSource<T> g;
            if (IncreasingQualityDataSourceSupplier.this.b) {
                d();
            }
            g = g();
            return g != null && g.hasResult();
        }
    }

    public IncreasingQualityDataSourceSupplier(List<Supplier<DataSource<T>>> list, boolean z) {
        Preconditions.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.a = list;
        this.b = z;
    }

    public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> list) {
        return create(list, false);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IncreasingQualityDataSourceSupplier)) {
            return false;
        }
        return Objects.equal(this.a, ((IncreasingQualityDataSourceSupplier) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("list", this.a).toString();
    }

    public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> list, boolean z) {
        return new IncreasingQualityDataSourceSupplier<>(list, z);
    }

    @Override // com.facebook.common.internal.Supplier
    public DataSource<T> get() {
        return new a();
    }
}
