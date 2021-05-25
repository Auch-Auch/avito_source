package a2.j.b.b.f1;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;

    public /* synthetic */ h(VideoRendererEventListener.EventDispatcher eventDispatcher, long j, int i) {
        this.a = eventDispatcher;
        this.b = j;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.a;
        ((VideoRendererEventListener) Util.castNonNull(eventDispatcher.b)).onVideoFrameProcessingOffset(this.b, this.c);
    }
}
