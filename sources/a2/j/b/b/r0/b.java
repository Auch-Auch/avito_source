package a2.j.b.b.r0;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.util.Util;
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ b(AudioRendererEventListener.EventDispatcher eventDispatcher, boolean z) {
        this.a = eventDispatcher;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.a;
        ((AudioRendererEventListener) Util.castNonNull(eventDispatcher.b)).onSkipSilenceEnabledChanged(this.b);
    }
}
