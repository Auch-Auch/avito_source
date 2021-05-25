package a2.j.b.b.z0;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import java.io.IOException;
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher a;
    public final /* synthetic */ MediaSourceEventListener b;
    public final /* synthetic */ LoadEventInfo c;
    public final /* synthetic */ MediaLoadData d;
    public final /* synthetic */ IOException e;
    public final /* synthetic */ boolean f;

    public /* synthetic */ d(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        this.a = eventDispatcher;
        this.b = mediaSourceEventListener;
        this.c = loadEventInfo;
        this.d = mediaLoadData;
        this.e = iOException;
        this.f = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaSourceEventListener.EventDispatcher eventDispatcher = this.a;
        this.b.onLoadError(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, this.c, this.d, this.e, this.f);
    }
}
