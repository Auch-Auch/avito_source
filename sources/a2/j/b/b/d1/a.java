package a2.j.b.b.d1;

import com.google.android.exoplayer2.upstream.BandwidthMeter;
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ BandwidthMeter.EventListener.EventDispatcher.a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public /* synthetic */ a(BandwidthMeter.EventListener.EventDispatcher.a aVar, int i, long j, long j2) {
        this.a = aVar;
        this.b = i;
        this.c = j;
        this.d = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BandwidthMeter.EventListener.EventDispatcher.a aVar = this.a;
        aVar.b.onBandwidthSample(this.b, this.c, this.d);
    }
}
