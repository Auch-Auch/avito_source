package com.facebook.imagepipeline.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public class ListDataSource<T> extends AbstractDataSource<List<CloseableReference<T>>> {
    public final DataSource<CloseableReference<T>>[] i;
    @GuardedBy("this")
    public int j = 0;

    public class b implements DataSubscriber<CloseableReference<T>> {
        @GuardedBy("InternalDataSubscriber.this")
        public boolean a = false;

        public b(a aVar) {
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource listDataSource = ListDataSource.this;
            Objects.requireNonNull(listDataSource);
            listDataSource.setFailure(new CancellationException());
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onFailure(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource listDataSource = ListDataSource.this;
            Objects.requireNonNull(listDataSource);
            listDataSource.setFailure(dataSource.getFailureCause());
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onNewResult(DataSource<CloseableReference<T>> dataSource) {
            boolean z;
            boolean z2;
            if (dataSource.isFinished()) {
                synchronized (this) {
                    z = false;
                    if (this.a) {
                        z2 = false;
                    } else {
                        this.a = true;
                        z2 = true;
                    }
                }
                if (z2) {
                    ListDataSource listDataSource = ListDataSource.this;
                    synchronized (listDataSource) {
                        int i = listDataSource.j + 1;
                        listDataSource.j = i;
                        if (i == listDataSource.i.length) {
                            z = true;
                        }
                    }
                    if (z) {
                        listDataSource.setResult(null, true, null);
                    }
                }
            }
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onProgressUpdate(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource listDataSource = ListDataSource.this;
            float f = 0.0f;
            for (DataSource<CloseableReference<T>> dataSource2 : listDataSource.i) {
                f += dataSource2.getProgress();
            }
            listDataSource.setProgress(f / ((float) listDataSource.i.length));
        }
    }

    public ListDataSource(DataSource<CloseableReference<T>>[] dataSourceArr) {
        this.i = dataSourceArr;
    }

    public static <T> ListDataSource<T> create(DataSource<CloseableReference<T>>... dataSourceArr) {
        Preconditions.checkNotNull(dataSourceArr);
        Preconditions.checkState(dataSourceArr.length > 0);
        ListDataSource<T> listDataSource = new ListDataSource<>(dataSourceArr);
        for (DataSource<CloseableReference<T>> dataSource : dataSourceArr) {
            if (dataSource != null) {
                dataSource.subscribe(new b(null), CallerThreadExecutor.getInstance());
            }
        }
        return listDataSource;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public boolean close() {
        if (!super.close()) {
            return false;
        }
        for (DataSource<CloseableReference<T>> dataSource : this.i) {
            dataSource.close();
        }
        return true;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public synchronized boolean hasResult() {
        return !isClosed() && this.j == this.i.length;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @Nullable
    public synchronized List<CloseableReference<T>> getResult() {
        if (!hasResult()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.i.length);
        for (DataSource<CloseableReference<T>> dataSource : this.i) {
            arrayList.add(dataSource.getResult());
        }
        return arrayList;
    }
}
