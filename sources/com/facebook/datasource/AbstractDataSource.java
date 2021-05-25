package com.facebook.datasource;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public abstract class AbstractDataSource<T> implements DataSource<T> {
    @Nullable
    public static volatile DataSourceInstrumenter h;
    @Nullable
    public Map<String, Object> a;
    @GuardedBy("this")
    public c b = c.IN_PROGRESS;
    @GuardedBy("this")
    public boolean c = false;
    @GuardedBy("this")
    @Nullable
    public T d = null;
    @GuardedBy("this")
    public Throwable e = null;
    @GuardedBy("this")
    public float f = 0.0f;
    public final ConcurrentLinkedQueue<Pair<DataSubscriber<T>, Executor>> g = new ConcurrentLinkedQueue<>();

    public interface DataSourceInstrumenter {
        Runnable decorateRunnable(Runnable runnable, String str);
    }

    public class a implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ DataSubscriber b;
        public final /* synthetic */ boolean c;

        public a(boolean z, DataSubscriber dataSubscriber, boolean z2) {
            this.a = z;
            this.b = dataSubscriber;
            this.c = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a) {
                this.b.onFailure(AbstractDataSource.this);
            } else if (this.c) {
                this.b.onCancellation(AbstractDataSource.this);
            } else {
                this.b.onNewResult(AbstractDataSource.this);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ DataSubscriber a;

        public b(DataSubscriber dataSubscriber) {
            this.a = dataSubscriber;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onProgressUpdate(AbstractDataSource.this);
        }
    }

    public enum c {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    @Nullable
    public static DataSourceInstrumenter getDataSourceInstrumenter() {
        return h;
    }

    public static void provideInstrumenter(@Nullable DataSourceInstrumenter dataSourceInstrumenter) {
        h = dataSourceInstrumenter;
    }

    public final void a() {
        boolean hasFailed = hasFailed();
        boolean b2 = b();
        Iterator<Pair<DataSubscriber<T>, Executor>> it = this.g.iterator();
        while (it.hasNext()) {
            Pair<DataSubscriber<T>, Executor> next = it.next();
            notifyDataSubscriber((DataSubscriber) next.first, (Executor) next.second, hasFailed, b2);
        }
    }

    public final synchronized boolean b() {
        return isClosed() && !isFinished();
    }

    @Override // com.facebook.datasource.DataSource
    public boolean close() {
        T t;
        synchronized (this) {
            if (this.c) {
                return false;
            }
            this.c = true;
            t = this.d;
            this.d = null;
        }
        if (t != null) {
            closeResult(t);
        }
        if (!isFinished()) {
            a();
        }
        synchronized (this) {
            this.g.clear();
        }
        return true;
    }

    public void closeResult(@Nullable T t) {
    }

    @Override // com.facebook.datasource.DataSource
    @Nullable
    public Map<String, Object> getExtras() {
        return this.a;
    }

    @Override // com.facebook.datasource.DataSource
    @Nullable
    public synchronized Throwable getFailureCause() {
        return this.e;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized float getProgress() {
        return this.f;
    }

    @Override // com.facebook.datasource.DataSource
    @Nullable
    public synchronized T getResult() {
        return this.d;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean hasFailed() {
        return this.b == c.FAILURE;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean hasMultipleResults() {
        return false;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean hasResult() {
        return this.d != null;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean isClosed() {
        return this.c;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean isFinished() {
        return this.b != c.IN_PROGRESS;
    }

    public void notifyDataSubscriber(DataSubscriber<T> dataSubscriber, Executor executor, boolean z, boolean z2) {
        Runnable aVar = new a(z, dataSubscriber, z2);
        DataSourceInstrumenter dataSourceInstrumenter = getDataSourceInstrumenter();
        if (dataSourceInstrumenter != null) {
            aVar = dataSourceInstrumenter.decorateRunnable(aVar, "AbstractDataSource_notifyDataSubscriber");
        }
        executor.execute(aVar);
    }

    public void notifyProgressUpdate() {
        Iterator<Pair<DataSubscriber<T>, Executor>> it = this.g.iterator();
        while (it.hasNext()) {
            Pair<DataSubscriber<T>, Executor> next = it.next();
            ((Executor) next.second).execute(new b((DataSubscriber) next.first));
        }
    }

    public void setExtras(@Nullable Map<String, Object> map) {
        this.a = map;
    }

    public boolean setFailure(Throwable th, @Nullable Map<String, Object> map) {
        boolean z;
        synchronized (this) {
            if (!this.c) {
                if (this.b == c.IN_PROGRESS) {
                    this.b = c.FAILURE;
                    this.e = th;
                    this.a = map;
                    z = true;
                }
            }
            z = false;
        }
        if (z) {
            a();
        }
        return z;
    }

    public boolean setProgress(float f2) {
        boolean z;
        synchronized (this) {
            z = false;
            if (!this.c) {
                if (this.b == c.IN_PROGRESS) {
                    if (f2 >= this.f) {
                        this.f = f2;
                        z = true;
                    }
                }
            }
        }
        if (z) {
            notifyProgressUpdate();
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0027, code lost:
        if (r4 != null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0029, code lost:
        closeResult(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002f, code lost:
        if (r4 != null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0043, code lost:
        r4 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean setResult(@javax.annotation.Nullable T r4, boolean r5, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            r3 = this;
            r3.setExtras(r6)
            r6 = 0
            monitor-enter(r3)     // Catch:{ all -> 0x0047 }
            boolean r0 = r3.c     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x002d
            com.facebook.datasource.AbstractDataSource$c r0 = r3.b     // Catch:{ all -> 0x003f }
            com.facebook.datasource.AbstractDataSource$c r1 = com.facebook.datasource.AbstractDataSource.c.IN_PROGRESS     // Catch:{ all -> 0x003f }
            if (r0 == r1) goto L_0x0010
            goto L_0x002d
        L_0x0010:
            if (r5 == 0) goto L_0x001a
            com.facebook.datasource.AbstractDataSource$c r5 = com.facebook.datasource.AbstractDataSource.c.SUCCESS     // Catch:{ all -> 0x003f }
            r3.b = r5     // Catch:{ all -> 0x003f }
            r5 = 1065353216(0x3f800000, float:1.0)
            r3.f = r5     // Catch:{ all -> 0x003f }
        L_0x001a:
            T r5 = r3.d     // Catch:{ all -> 0x003f }
            if (r5 == r4) goto L_0x0024
            r3.d = r4     // Catch:{ all -> 0x0022 }
            r4 = r5
            goto L_0x0025
        L_0x0022:
            r4 = move-exception
            goto L_0x003c
        L_0x0024:
            r4 = r6
        L_0x0025:
            r5 = 1
            monitor-exit(r3)     // Catch:{ all -> 0x0038 }
            if (r4 == 0) goto L_0x0032
        L_0x0029:
            r3.closeResult(r4)
            goto L_0x0032
        L_0x002d:
            r5 = 0
            monitor-exit(r3)
            if (r4 == 0) goto L_0x0032
            goto L_0x0029
        L_0x0032:
            if (r5 == 0) goto L_0x0037
            r3.a()
        L_0x0037:
            return r5
        L_0x0038:
            r5 = move-exception
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x003c:
            r6 = r5
        L_0x003d:
            r5 = r3
            goto L_0x0041
        L_0x003f:
            r4 = move-exception
            goto L_0x003d
        L_0x0041:
            monitor-exit(r5)     // Catch:{ all -> 0x0045 }
            throw r4     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r4 = move-exception
            goto L_0x0049
        L_0x0045:
            r4 = move-exception
            goto L_0x0041
        L_0x0047:
            r4 = move-exception
            r5 = r3
        L_0x0049:
            if (r6 == 0) goto L_0x004e
            r5.closeResult(r6)
        L_0x004e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.AbstractDataSource.setResult(java.lang.Object, boolean, java.util.Map):boolean");
    }

    @Override // com.facebook.datasource.DataSource
    public void subscribe(DataSubscriber<T> dataSubscriber, Executor executor) {
        boolean z;
        Preconditions.checkNotNull(dataSubscriber);
        Preconditions.checkNotNull(executor);
        synchronized (this) {
            if (!this.c) {
                if (this.b == c.IN_PROGRESS) {
                    this.g.add(Pair.create(dataSubscriber, executor));
                }
                if (!hasResult() && !isFinished()) {
                    if (!b()) {
                        z = false;
                    }
                }
                z = true;
            } else {
                return;
            }
        }
        if (z) {
            notifyDataSubscriber(dataSubscriber, executor, hasFailed(), b());
        }
    }

    public boolean setFailure(Throwable th) {
        return setFailure(th, null);
    }

    public boolean setResult(@Nullable T t, boolean z) {
        return setResult(t, z, null);
    }
}
