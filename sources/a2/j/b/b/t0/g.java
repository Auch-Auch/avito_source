package a2.j.b.b.t0;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher a;
    public final /* synthetic */ DrmSessionEventListener b;
    public final /* synthetic */ Exception c;

    public /* synthetic */ g(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, Exception exc) {
        this.a = eventDispatcher;
        this.b = drmSessionEventListener;
        this.c = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DrmSessionEventListener.EventDispatcher eventDispatcher = this.a;
        this.b.onDrmSessionManagerError(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, this.c);
    }
}
