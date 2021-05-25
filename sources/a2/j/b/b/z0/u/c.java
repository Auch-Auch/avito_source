package a2.j.b.b.z0.u;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ AdsMediaSource.b a;
    public final /* synthetic */ MediaSource.MediaPeriodId b;

    public /* synthetic */ c(AdsMediaSource.b bVar, MediaSource.MediaPeriodId mediaPeriodId) {
        this.a = bVar;
        this.b = mediaPeriodId;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AdsMediaSource.b bVar = this.a;
        MediaSource.MediaPeriodId mediaPeriodId = this.b;
        AdsMediaSource.this.l.handlePrepareComplete(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
    }
}
