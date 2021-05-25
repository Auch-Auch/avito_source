package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.video.VideoAdRequest;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.HashMap;
import java.util.List;
public final class vp implements hw<VideoAdRequest, List<VideoAd>> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.yandex.mobile.ads.impl.sa, int, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.hw
    public final /* synthetic */ hv a(@Nullable sa<List<VideoAd>> saVar, int i, @NonNull VideoAdRequest videoAdRequest) {
        VideoAdRequest videoAdRequest2 = videoAdRequest;
        HashMap hashMap = new HashMap();
        hashMap.put("partner_id", videoAdRequest2.getBlocksInfo().getPartnerId());
        hashMap.put("block_id", videoAdRequest2.getBlockId());
        hashMap.put("page_ref", videoAdRequest2.getPageRef());
        hashMap.put("target_ref", videoAdRequest2.getTargetRef());
        if (i != -1) {
            hashMap.put("code", Integer.valueOf(i));
        }
        return new hv(hv.b.VAST_RESPONSE, hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.hw
    public final /* synthetic */ hv a(VideoAdRequest videoAdRequest) {
        VideoAdRequest videoAdRequest2 = videoAdRequest;
        HashMap hashMap = new HashMap();
        hashMap.put("partner_id", videoAdRequest2.getBlocksInfo().getPartnerId());
        hashMap.put("block_id", videoAdRequest2.getBlockId());
        hashMap.put("page_ref", videoAdRequest2.getPageRef());
        hashMap.put("target_ref", videoAdRequest2.getTargetRef());
        return new hv(hv.b.VAST_REQUEST, hashMap);
    }
}
