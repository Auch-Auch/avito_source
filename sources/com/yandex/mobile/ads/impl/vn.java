package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.video.BlocksInfoRequest;
import com.yandex.mobile.ads.video.models.blocksinfo.BlocksInfo;
import java.util.HashMap;
public final class vn implements hw<BlocksInfoRequest, BlocksInfo> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.yandex.mobile.ads.impl.sa, int, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.hw
    public final /* synthetic */ hv a(@Nullable sa<BlocksInfo> saVar, int i, @NonNull BlocksInfoRequest blocksInfoRequest) {
        BlocksInfoRequest blocksInfoRequest2 = blocksInfoRequest;
        HashMap hashMap = new HashMap();
        hashMap.put("partner_id", blocksInfoRequest2.getPartnerId());
        hashMap.put("category_id", blocksInfoRequest2.getCategoryId());
        if (i != -1) {
            hashMap.put("code", Integer.valueOf(i));
        }
        return new hv(hv.b.BLOCKS_INFO_RESPONSE, hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.hw
    public final /* synthetic */ hv a(BlocksInfoRequest blocksInfoRequest) {
        BlocksInfoRequest blocksInfoRequest2 = blocksInfoRequest;
        HashMap hashMap = new HashMap();
        hashMap.put("partner_id", blocksInfoRequest2.getPartnerId());
        hashMap.put("category_id", blocksInfoRequest2.getCategoryId());
        return new hv(hv.b.BLOCKS_INFO_REQUEST, hashMap);
    }
}
