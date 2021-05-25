package com.facebook.internal;

import a2.g.r.k;
import com.facebook.FacebookSdk;
import java.util.Objects;
import java.util.concurrent.Executor;
public class WorkQueue {
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    public final Object a;
    public a b;
    public final int c;
    public final Executor d;
    public a e;
    public int f;

    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    public class a implements WorkItem {
        public final Runnable a;
        public a b;
        public a c;
        public boolean d;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        public a a(a aVar, boolean z) {
            if (aVar == null) {
                this.c = this;
                this.b = this;
                aVar = this;
            } else {
                this.b = aVar;
                a aVar2 = aVar.c;
                this.c = aVar2;
                aVar2.b = this;
                aVar.c = this;
            }
            return z ? this : aVar;
        }

        public a b(a aVar) {
            if (aVar == this && (aVar = this.b) == this) {
                aVar = null;
            }
            a aVar2 = this.b;
            aVar2.c = this.c;
            this.c.b = aVar2;
            this.c = null;
            this.b = null;
            return aVar;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean cancel() {
            synchronized (WorkQueue.this.a) {
                if (this.d) {
                    return false;
                }
                WorkQueue workQueue = WorkQueue.this;
                workQueue.b = b(workQueue.b);
                return true;
            }
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean isRunning() {
            return this.d;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public void moveToFront() {
            synchronized (WorkQueue.this.a) {
                if (!this.d) {
                    WorkQueue workQueue = WorkQueue.this;
                    workQueue.b = b(workQueue.b);
                    WorkQueue workQueue2 = WorkQueue.this;
                    workQueue2.b = a(workQueue2.b, true);
                }
            }
        }
    }

    public WorkQueue() {
        this(8);
    }

    public final void a(a aVar) {
        a aVar2;
        synchronized (this.a) {
            if (aVar != null) {
                this.e = aVar.b(this.e);
                this.f--;
            }
            if (this.f < this.c) {
                aVar2 = this.b;
                if (aVar2 != null) {
                    this.b = aVar2.b(aVar2);
                    this.e = aVar2.a(this.e, false);
                    this.f++;
                    aVar2.d = true;
                }
            } else {
                aVar2 = null;
            }
        }
        if (aVar2 != null) {
            this.d.execute(new k(this, aVar2));
        }
    }

    public WorkItem addActiveWorkItem(Runnable runnable) {
        return addActiveWorkItem(runnable, true);
    }

    public void validate() {
        synchronized (this.a) {
            a aVar = this.e;
            if (aVar != null) {
                do {
                    Objects.requireNonNull(aVar);
                    aVar = aVar.b;
                } while (aVar != this.e);
            }
        }
    }

    public WorkQueue(int i) {
        this(i, FacebookSdk.getExecutor());
    }

    public WorkItem addActiveWorkItem(Runnable runnable, boolean z) {
        a aVar = new a(runnable);
        synchronized (this.a) {
            this.b = aVar.a(this.b, z);
        }
        a(null);
        return aVar;
    }

    public WorkQueue(int i, Executor executor) {
        this.a = new Object();
        this.e = null;
        this.f = 0;
        this.c = i;
        this.d = executor;
    }
}
