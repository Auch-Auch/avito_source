package a2.j.b.b.t0;

import com.google.android.exoplayer2.drm.DefaultDrmSession;
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ DefaultDrmSession a;

    public /* synthetic */ a(DefaultDrmSession defaultDrmSession) {
        this.a = defaultDrmSession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.release(null);
    }
}
