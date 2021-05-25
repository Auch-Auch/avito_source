package a2.j.b.b;

import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.Renderer;
public class e0 implements Renderer.WakeupListener {
    public final /* synthetic */ ExoPlayerImplInternal a;

    public e0(ExoPlayerImplInternal exoPlayerImplInternal) {
        this.a = exoPlayerImplInternal;
    }

    @Override // com.google.android.exoplayer2.Renderer.WakeupListener
    public void onSleep(long j) {
        if (j >= 2000) {
            this.a.E = true;
        }
    }

    @Override // com.google.android.exoplayer2.Renderer.WakeupListener
    public void onWakeup() {
        this.a.g.sendEmptyMessage(2);
    }
}
