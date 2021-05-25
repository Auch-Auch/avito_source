package a2.j.b.b.f1;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher a;
    public final /* synthetic */ Format b;

    public /* synthetic */ a(VideoRendererEventListener.EventDispatcher eventDispatcher, Format format) {
        this.a = eventDispatcher;
        this.b = format;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.a;
        ((VideoRendererEventListener) Util.castNonNull(eventDispatcher.b)).onVideoInputFormatChanged(this.b);
    }
}
