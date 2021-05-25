package a2.j.b.b.f1;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ float e;

    public /* synthetic */ g(VideoRendererEventListener.EventDispatcher eventDispatcher, int i, int i2, int i3, float f) {
        this.a = eventDispatcher;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.a;
        ((VideoRendererEventListener) Util.castNonNull(eventDispatcher.b)).onVideoSizeChanged(this.b, this.c, this.d, this.e);
    }
}
