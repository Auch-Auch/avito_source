package a2.j.b.b.f1;

import android.view.Surface;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher a;
    public final /* synthetic */ Surface b;

    public /* synthetic */ c(VideoRendererEventListener.EventDispatcher eventDispatcher, Surface surface) {
        this.a = eventDispatcher;
        this.b = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.a;
        ((VideoRendererEventListener) Util.castNonNull(eventDispatcher.b)).onRenderedFirstFrame(this.b);
    }
}
