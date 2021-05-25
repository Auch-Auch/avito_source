package a2.j.b.b.r0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.util.Util;
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher a;
    public final /* synthetic */ Format b;

    public /* synthetic */ a(AudioRendererEventListener.EventDispatcher eventDispatcher, Format format) {
        this.a = eventDispatcher;
        this.b = format;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.a;
        ((AudioRendererEventListener) Util.castNonNull(eventDispatcher.b)).onAudioInputFormatChanged(this.b);
    }
}
