package a2.j.b.b.t0;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher a;
    public final /* synthetic */ DrmSessionEventListener b;

    public /* synthetic */ b(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.a = eventDispatcher;
        this.b = drmSessionEventListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DrmSessionEventListener.EventDispatcher eventDispatcher = this.a;
        this.b.onDrmSessionAcquired(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId);
    }
}
