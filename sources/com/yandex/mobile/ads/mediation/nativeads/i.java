package com.yandex.mobile.ads.mediation.nativeads;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
public final class i {
    @NonNull
    public static List<MediatedNativeAdImage> a(@NonNull MediatedNativeAd mediatedNativeAd) {
        MediatedNativeAdAssets mediatedNativeAdAssets = mediatedNativeAd.getMediatedNativeAdAssets();
        ArrayList arrayList = new ArrayList();
        arrayList.add(mediatedNativeAdAssets.getFavicon());
        arrayList.add(mediatedNativeAdAssets.getIcon());
        arrayList.add(mediatedNativeAdAssets.getImage());
        return a(arrayList);
    }

    @NonNull
    private static List<MediatedNativeAdImage> a(@NonNull List<MediatedNativeAdImage> list) {
        ArrayList arrayList = new ArrayList();
        for (MediatedNativeAdImage mediatedNativeAdImage : list) {
            if (mediatedNativeAdImage != null) {
                arrayList.add(mediatedNativeAdImage);
            }
        }
        return arrayList;
    }
}
