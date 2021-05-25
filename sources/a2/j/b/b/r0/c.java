package a2.j.b.b.r0;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Util;
import java.util.Objects;
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher a;
    public final /* synthetic */ DecoderCounters b;

    public /* synthetic */ c(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.a = eventDispatcher;
        this.b = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.a;
        DecoderCounters decoderCounters = this.b;
        Objects.requireNonNull(eventDispatcher);
        decoderCounters.ensureUpdated();
        ((AudioRendererEventListener) Util.castNonNull(eventDispatcher.b)).onAudioDisabled(decoderCounters);
    }
}
