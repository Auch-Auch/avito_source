package a2.g.r;

import com.facebook.internal.WorkQueue;
public class k implements Runnable {
    public final /* synthetic */ WorkQueue.a a;
    public final /* synthetic */ WorkQueue b;

    public k(WorkQueue workQueue, WorkQueue.a aVar) {
        this.b = workQueue;
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.a.run();
        } finally {
            this.b.a(this.a);
        }
    }
}
