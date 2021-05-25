package a2.j.b.b.z0.u;

import android.view.View;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.common.collect.ImmutableList;
import java.util.List;
/* compiled from: AdsLoader */
public final /* synthetic */ class f {
    /* JADX WARN: Incorrect args count in method signature: ()Ljava/util/List<Lcom/google/android/exoplayer2/source/ads/AdsLoader$OverlayInfo;>; */
    public static List $default$getAdOverlayInfos(AdsLoader.AdViewProvider _this) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (View view : _this.getAdOverlayViews()) {
            builder.add((ImmutableList.Builder) new AdsLoader.OverlayInfo(view, 0));
        }
        return builder.build();
    }

    @Deprecated
    public static View[] $default$getAdOverlayViews(AdsLoader.AdViewProvider adViewProvider) {
        return new View[0];
    }
}
