package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Supplier;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
public class RetainingDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public final Set<b> a = Collections.newSetFromMap(new WeakHashMap());
    @Nullable
    public Supplier<DataSource<T>> b = null;

    public void replaceSupplier(Supplier<DataSource<T>> supplier) {
        this.b = supplier;
        for (b bVar : this.a) {
            if (!bVar.isClosed()) {
                bVar.c(supplier);
            }
        }
    }

    public static class b<T> extends AbstractDataSource<T> {
        @GuardedBy("RetainingDataSource.this")
        @Nullable
        public DataSource<T> i = null;

        public class a implements DataSubscriber<T> {
            public a(a aVar) {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> dataSource) {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> dataSource) {
                Objects.requireNonNull(b.this);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource<T> dataSource) {
                if (dataSource.hasResult()) {
                    b bVar = b.this;
                    if (dataSource == bVar.i) {
                        bVar.setResult(null, false, dataSource.getExtras());
                    }
                } else if (dataSource.isFinished()) {
                    Objects.requireNonNull(b.this);
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource) {
                b bVar = b.this;
                if (dataSource == bVar.i) {
                    bVar.setProgress(dataSource.getProgress());
                }
            }
        }

        public b() {
        }

        public void c(@Nullable Supplier<DataSource<T>> supplier) {
            DataSource<T> dataSource;
            if (!isClosed()) {
                DataSource<T> dataSource2 = supplier != null ? supplier.get() : null;
                synchronized (this) {
                    if (isClosed()) {
                        if (dataSource2 != null) {
                            dataSource2.close();
                        }
                        return;
                    }
                    dataSource = this.i;
                    this.i = dataSource2;
                }
                if (dataSource2 != null) {
                    dataSource2.subscribe(new a(null), CallerThreadExecutor.getInstance());
                }
                if (dataSource != null) {
                    dataSource.close();
                }
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean close() {
            DataSource<T> dataSource;
            synchronized (this) {
                if (!super.close()) {
                    return false;
                }
                dataSource = this.i;
                this.i = null;
            }
            if (dataSource == null) {
                return true;
            }
            dataSource.close();
            return true;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @Nullable
        public synchronized T getResult() {
            DataSource<T> dataSource;
            dataSource = this.i;
            return dataSource != null ? dataSource.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean hasMultipleResults() {
            return true;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean hasResult() {
            DataSource<T> dataSource;
            dataSource = this.i;
            return dataSource != null && dataSource.hasResult();
        }

        public b(a aVar) {
        }
    }

    @Override // com.facebook.common.internal.Supplier
    public DataSource<T> get() {
        b bVar = new b(null);
        bVar.c(this.b);
        this.a.add(bVar);
        return bVar;
    }
}
