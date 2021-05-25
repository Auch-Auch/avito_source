package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.ArrayList;
import java.util.List;
public final class vt {
    @NonNull
    public static vs a(@NonNull List<VideoAd> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (VideoAd videoAd : list) {
            if (videoAd.isWrapper()) {
                arrayList2.add(videoAd);
            } else {
                arrayList.add(videoAd);
            }
        }
        return new vs(arrayList, arrayList2);
    }
}
