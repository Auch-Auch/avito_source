package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.impl.tb;
import com.yandex.mobile.ads.video.VideoAdRequest;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.List;
public final class up extends un<VideoAdRequest, List<VideoAd>> {
    public up(VideoAdRequest videoAdRequest, String str, tb.a<List<VideoAd>> aVar, hw<VideoAdRequest, List<VideoAd>> hwVar) {
        super(str, aVar, videoAdRequest.getContext(), videoAdRequest, hwVar, (byte) 0);
    }

    @Override // com.yandex.mobile.ads.impl.un
    public final sa<List<VideoAd>> a(Exception exc) {
        return sa.a(new tw());
    }

    /* Return type fixed from 'com.yandex.mobile.ads.impl.sa' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.un
    public final /* synthetic */ sa<List<VideoAd>> c(List<VideoAd> list) {
        List<VideoAd> list2 = list;
        if (!list2.isEmpty()) {
            return sa.a(list2, null);
        }
        return sa.a(new tw());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.un
    public final /* synthetic */ List<VideoAd> a(String str) throws Exception {
        return new ur().b(str);
    }
}
