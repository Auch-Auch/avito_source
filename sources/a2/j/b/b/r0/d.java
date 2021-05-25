package a2.j.b.b.r0;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.util.Util;
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher a;
    public final /* synthetic */ int b;

    public /* synthetic */ d(AudioRendererEventListener.EventDispatcher eventDispatcher, int i) {
        this.a = eventDispatcher;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.a;
        ((AudioRendererEventListener) Util.castNonNull(eventDispatcher.b)).onAudioSessionId(this.b);
    }
}
