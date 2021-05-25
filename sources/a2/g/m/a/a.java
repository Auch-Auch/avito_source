package a2.g.m.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import com.facebook.drawee.components.DeferredReleaser;
import java.util.ArrayList;
public class a extends DeferredReleaser {
    public final Object b = new Object();
    public final Handler c = new Handler(Looper.getMainLooper());
    public ArrayList<DeferredReleaser.Releasable> d = new ArrayList<>();
    public ArrayList<DeferredReleaser.Releasable> e = new ArrayList<>();
    public final Runnable f = new RunnableC0027a();

    /* renamed from: a2.g.m.a.a$a  reason: collision with other inner class name */
    public class RunnableC0027a implements Runnable {
        public RunnableC0027a() {
        }

        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            ArrayList<DeferredReleaser.Releasable> arrayList;
            synchronized (a.this.b) {
                a aVar = a.this;
                ArrayList<DeferredReleaser.Releasable> arrayList2 = aVar.e;
                arrayList = aVar.d;
                aVar.e = arrayList;
                aVar.d = arrayList2;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                a.this.e.get(i).release();
            }
            a.this.e.clear();
        }
    }

    @Override // com.facebook.drawee.components.DeferredReleaser
    @AnyThread
    public void cancelDeferredRelease(DeferredReleaser.Releasable releasable) {
        synchronized (this.b) {
            this.d.remove(releasable);
        }
    }

    @Override // com.facebook.drawee.components.DeferredReleaser
    @AnyThread
    public void scheduleDeferredRelease(DeferredReleaser.Releasable releasable) {
        boolean z = false;
        if (!(Looper.getMainLooper().getThread() == Thread.currentThread())) {
            releasable.release();
            return;
        }
        synchronized (this.b) {
            if (!this.d.contains(releasable)) {
                this.d.add(releasable);
                if (this.d.size() == 1) {
                    z = true;
                }
            } else {
                return;
            }
        }
        if (z) {
            this.c.post(this.f);
        }
    }
}
