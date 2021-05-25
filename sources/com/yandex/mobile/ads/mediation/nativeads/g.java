package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.oy;
import com.yandex.mobile.ads.impl.x;
import com.yandex.mobile.ads.nativeads.NativeAdType;
import com.yandex.mobile.ads.nativeads.i;
import com.yandex.mobile.ads.nativeads.k;
import java.util.List;
import java.util.Map;
public final class g {
    @NonNull
    private final i a;
    @NonNull
    private final h b;
    @NonNull
    private final r c;

    public interface a {
        void a(@NonNull x<oy> xVar);
    }

    public g(@NonNull Context context, @NonNull i iVar, @NonNull h hVar) {
        this.a = iVar;
        this.b = hVar;
        this.c = new r(context);
    }

    public final void a(@NonNull final MediatedNativeAd mediatedNativeAd, @NonNull final NativeAdType nativeAdType, @NonNull List<MediatedNativeAdImage> list, @NonNull final a aVar) {
        this.a.a(this.b.b(list), new k() { // from class: com.yandex.mobile.ads.mediation.nativeads.g.1
            @Override // com.yandex.mobile.ads.nativeads.k
            public final void a(@NonNull Map<String, Bitmap> map) {
                g.a(g.this, mediatedNativeAd, map, nativeAdType, aVar);
            }
        });
    }

    public static /* synthetic */ void a(g gVar, MediatedNativeAd mediatedNativeAd, Map map, NativeAdType nativeAdType, a aVar) {
        aVar.a(gVar.c.a(mediatedNativeAd, map, nativeAdType));
    }
}
