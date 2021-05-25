package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
public class FirstAvailableDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public final List<Supplier<DataSource<T>>> a;

    @ThreadSafe
    public class b extends AbstractDataSource<T> {
        public int i = 0;
        public DataSource<T> j = null;
        public DataSource<T> k = null;

        public class a implements DataSubscriber<T> {
            public a(a aVar) {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> dataSource) {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> dataSource) {
                b.c(b.this, dataSource);
            }

            /* JADX WARNING: Removed duplicated region for block: B:17:0x0026  */
            @Override // com.facebook.datasource.DataSubscriber
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onNewResult(com.facebook.datasource.DataSource<T> r5) {
                /*
                    r4 = this;
                    boolean r0 = r5.hasResult()
                    if (r0 == 0) goto L_0x0040
                    com.facebook.datasource.FirstAvailableDataSourceSupplier$b r0 = com.facebook.datasource.FirstAvailableDataSourceSupplier.b.this
                    java.util.Objects.requireNonNull(r0)
                    boolean r1 = r5.isFinished()
                    monitor-enter(r0)
                    com.facebook.datasource.DataSource<T> r2 = r0.j     // Catch:{ all -> 0x003d }
                    r3 = 0
                    if (r5 != r2) goto L_0x002a
                    com.facebook.datasource.DataSource<T> r2 = r0.k     // Catch:{ all -> 0x003d }
                    if (r5 != r2) goto L_0x001a
                    goto L_0x002a
                L_0x001a:
                    if (r2 == 0) goto L_0x0021
                    if (r1 == 0) goto L_0x001f
                    goto L_0x0021
                L_0x001f:
                    r2 = r3
                    goto L_0x0023
                L_0x0021:
                    r0.k = r5     // Catch:{ all -> 0x003d }
                L_0x0023:
                    monitor-exit(r0)     // Catch:{ all -> 0x003d }
                    if (r2 == 0) goto L_0x002b
                    r2.close()
                    goto L_0x002b
                L_0x002a:
                    monitor-exit(r0)
                L_0x002b:
                    com.facebook.datasource.DataSource r1 = r0.d()
                    if (r5 != r1) goto L_0x004b
                    boolean r1 = r5.isFinished()
                    java.util.Map r5 = r5.getExtras()
                    r0.setResult(r3, r1, r5)
                    goto L_0x004b
                L_0x003d:
                    r5 = move-exception
                    monitor-exit(r0)
                    throw r5
                L_0x0040:
                    boolean r0 = r5.isFinished()
                    if (r0 == 0) goto L_0x004b
                    com.facebook.datasource.FirstAvailableDataSourceSupplier$b r0 = com.facebook.datasource.FirstAvailableDataSourceSupplier.b.this
                    com.facebook.datasource.FirstAvailableDataSourceSupplier.b.c(r0, r5)
                L_0x004b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.FirstAvailableDataSourceSupplier.b.a.onNewResult(com.facebook.datasource.DataSource):void");
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource) {
                b.this.setProgress(Math.max(b.this.getProgress(), dataSource.getProgress()));
            }
        }

        public b() {
            if (!e()) {
                setFailure(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        public static void c(b bVar, DataSource dataSource) {
            boolean z;
            synchronized (bVar) {
                if (!bVar.isClosed()) {
                    if (dataSource == bVar.j) {
                        bVar.j = null;
                        z = true;
                    }
                }
                z = false;
            }
            if (z) {
                if (!(dataSource == bVar.d() || dataSource == null)) {
                    dataSource.close();
                }
                if (!bVar.e()) {
                    bVar.setFailure(dataSource.getFailureCause(), dataSource.getExtras());
                }
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean close() {
            DataSource<T> dataSource;
            DataSource<T> dataSource2;
            synchronized (this) {
                if (!super.close()) {
                    return false;
                }
                dataSource = this.j;
                this.j = null;
                dataSource2 = this.k;
                this.k = null;
            }
            if (dataSource2 != null) {
                dataSource2.close();
            }
            if (dataSource == null) {
                return true;
            }
            dataSource.close();
            return true;
        }

        @Nullable
        public final synchronized DataSource<T> d() {
            return this.k;
        }

        public final boolean e() {
            Supplier<DataSource<T>> supplier;
            boolean z;
            synchronized (this) {
                if (isClosed() || this.i >= FirstAvailableDataSourceSupplier.this.a.size()) {
                    supplier = null;
                } else {
                    List<Supplier<DataSource<T>>> list = FirstAvailableDataSourceSupplier.this.a;
                    int i2 = this.i;
                    this.i = i2 + 1;
                    supplier = list.get(i2);
                }
            }
            DataSource<T> dataSource = supplier != null ? supplier.get() : null;
            synchronized (this) {
                if (isClosed()) {
                    z = false;
                } else {
                    this.j = dataSource;
                    z = true;
                }
            }
            if (!z || dataSource == null) {
                if (dataSource != null) {
                    dataSource.close();
                }
                return false;
            }
            dataSource.subscribe(new a(null), CallerThreadExecutor.getInstance());
            return true;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @Nullable
        public synchronized T getResult() {
            DataSource<T> d;
            d = d();
            return d != null ? d.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean hasResult() {
            DataSource<T> d;
            d = d();
            return d != null && d.hasResult();
        }
    }

    public FirstAvailableDataSourceSupplier(List<Supplier<DataSource<T>>> list) {
        Preconditions.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.a = list;
    }

    public static <T> FirstAvailableDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> list) {
        return new FirstAvailableDataSourceSupplier<>(list);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirstAvailableDataSourceSupplier)) {
            return false;
        }
        return Objects.equal(this.a, ((FirstAvailableDataSourceSupplier) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("list", this.a).toString();
    }

    @Override // com.facebook.common.internal.Supplier
    public DataSource<T> get() {
        return new b();
    }
}
