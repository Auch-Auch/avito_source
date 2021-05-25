package a2.j.b.b.f1;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public /* synthetic */ d(VideoRendererEventListener.EventDispatcher eventDispatcher, int i, long j) {
        this.a = eventDispatcher;
        this.b = i;
        this.c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.a;
        ((VideoRendererEventListener) Util.castNonNull(eventDispatcher.b)).onDroppedFrames(this.b, this.c);
    }
}
