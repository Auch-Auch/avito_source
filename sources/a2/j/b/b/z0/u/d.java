package a2.j.b.b.z0.u;

import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import java.util.Arrays;
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ AdsMediaSource.c a;
    public final /* synthetic */ AdPlaybackState b;

    public /* synthetic */ d(AdsMediaSource.c cVar, AdPlaybackState adPlaybackState) {
        this.a = cVar;
        this.b = adPlaybackState;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AdsMediaSource.c cVar = this.a;
        AdPlaybackState adPlaybackState = this.b;
        if (!cVar.b) {
            AdsMediaSource adsMediaSource = AdsMediaSource.this;
            if (adsMediaSource.s == null) {
                AdsMediaSource.a[][] aVarArr = new AdsMediaSource.a[adPlaybackState.adGroupCount][];
                adsMediaSource.t = aVarArr;
                Arrays.fill(aVarArr, new AdsMediaSource.a[0]);
            }
            adsMediaSource.s = adPlaybackState;
            adsMediaSource.a();
        }
    }
}
