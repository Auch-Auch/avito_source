package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
public class DataSources {

    public static class a implements Supplier<DataSource<T>> {
        public final /* synthetic */ Throwable a;

        public a(Throwable th) {
            this.a = th;
        }

        @Override // com.facebook.common.internal.Supplier
        public Object get() {
            return DataSources.immediateFailedDataSource(this.a);
        }
    }

    public static class b implements DataSubscriber<T> {
        public final /* synthetic */ d a;
        public final /* synthetic */ CountDownLatch b;
        public final /* synthetic */ d c;

        public b(d dVar, CountDownLatch countDownLatch, d dVar2) {
            this.a = dVar;
            this.b = countDownLatch;
            this.c = dVar2;
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<T> dataSource) {
            this.b.countDown();
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onFailure(DataSource<T> dataSource) {
            try {
                this.c.a = (T) dataSource.getFailureCause();
            } finally {
                this.b.countDown();
            }
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onNewResult(DataSource<T> dataSource) {
            if (dataSource.isFinished()) {
                try {
                    this.a.a = dataSource.getResult();
                } finally {
                    this.b.countDown();
                }
            }
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onProgressUpdate(DataSource<T> dataSource) {
        }
    }

    public static class c implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static class d<T> {
        @Nullable
        public T a = null;

        public d(a aVar) {
        }
    }

    public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(Throwable th) {
        return new a(th);
    }

    public static <T> DataSource<T> immediateDataSource(T t) {
        SimpleDataSource create = SimpleDataSource.create();
        create.setResult(t);
        return create;
    }

    public static <T> DataSource<T> immediateFailedDataSource(Throwable th) {
        SimpleDataSource create = SimpleDataSource.create();
        create.setFailure(th);
        return create;
    }

    @Nullable
    public static <T> T waitForFinalResult(DataSource<T> dataSource) throws Throwable {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d dVar = new d(null);
        d dVar2 = new d(null);
        dataSource.subscribe(new b(dVar, countDownLatch, dVar2), new c());
        countDownLatch.await();
        T t = dVar2.a;
        if (t == null) {
            return dVar.a;
        }
        throw t;
    }
}
