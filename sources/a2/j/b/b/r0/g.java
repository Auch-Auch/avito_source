package a2.j.b.b.r0;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.util.Util;
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public /* synthetic */ g(AudioRendererEventListener.EventDispatcher eventDispatcher, int i, long j, long j2) {
        this.a = eventDispatcher;
        this.b = i;
        this.c = j;
        this.d = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.a;
        ((AudioRendererEventListener) Util.castNonNull(eventDispatcher.b)).onAudioUnderrun(this.b, this.c, this.d);
    }
}
