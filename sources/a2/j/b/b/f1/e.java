package a2.j.b.b.f1;

import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.Objects;
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher a;
    public final /* synthetic */ DecoderCounters b;

    public /* synthetic */ e(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.a = eventDispatcher;
        this.b = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.a;
        DecoderCounters decoderCounters = this.b;
        Objects.requireNonNull(eventDispatcher);
        decoderCounters.ensureUpdated();
        ((VideoRendererEventListener) Util.castNonNull(eventDispatcher.b)).onVideoDisabled(decoderCounters);
    }
}
