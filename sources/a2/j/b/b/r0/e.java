package a2.j.b.b.r0;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.util.Util;
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public /* synthetic */ e(AudioRendererEventListener.EventDispatcher eventDispatcher, String str, long j, long j2) {
        this.a = eventDispatcher;
        this.b = str;
        this.c = j;
        this.d = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.a;
        ((AudioRendererEventListener) Util.castNonNull(eventDispatcher.b)).onAudioDecoderInitialized(this.b, this.c, this.d);
    }
}
