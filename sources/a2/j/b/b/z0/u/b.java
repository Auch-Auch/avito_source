package a2.j.b.b.z0.u;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import java.io.IOException;
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ AdsMediaSource.b a;
    public final /* synthetic */ MediaSource.MediaPeriodId b;
    public final /* synthetic */ IOException c;

    public /* synthetic */ b(AdsMediaSource.b bVar, MediaSource.MediaPeriodId mediaPeriodId, IOException iOException) {
        this.a = bVar;
        this.b = mediaPeriodId;
        this.c = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AdsMediaSource.b bVar = this.a;
        MediaSource.MediaPeriodId mediaPeriodId = this.b;
        AdsMediaSource.this.l.handlePrepareError(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, this.c);
    }
}
