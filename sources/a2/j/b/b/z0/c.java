package a2.j.b.b.z0;

import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher a;
    public final /* synthetic */ MediaSourceEventListener b;
    public final /* synthetic */ MediaSource.MediaPeriodId c;
    public final /* synthetic */ MediaLoadData d;

    public /* synthetic */ c(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        this.a = eventDispatcher;
        this.b = mediaSourceEventListener;
        this.c = mediaPeriodId;
        this.d = mediaLoadData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaSourceEventListener.EventDispatcher eventDispatcher = this.a;
        this.b.onUpstreamDiscarded(eventDispatcher.windowIndex, this.c, this.d);
    }
}
