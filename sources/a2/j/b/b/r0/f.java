package a2.j.b.b.r0;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.util.Util;
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher a;
    public final /* synthetic */ long b;

    public /* synthetic */ f(AudioRendererEventListener.EventDispatcher eventDispatcher, long j) {
        this.a = eventDispatcher;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.a;
        ((AudioRendererEventListener) Util.castNonNull(eventDispatcher.b)).onAudioPositionAdvancing(this.b);
    }
}
