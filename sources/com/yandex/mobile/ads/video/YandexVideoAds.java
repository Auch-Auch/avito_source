package com.yandex.mobile.ads.video;

import android.content.Context;
import android.support.annotation.NonNull;
public final class YandexVideoAds {
    private YandexVideoAds() {
    }

    public static void loadBlocksInfo(@NonNull BlocksInfoRequest blocksInfoRequest) {
        Context context = blocksInfoRequest.getContext();
        b.a(context).a(context, blocksInfoRequest);
    }

    public static void loadVideoAds(@NonNull VideoAdRequest videoAdRequest) {
        Context context = videoAdRequest.getContext();
        b.a(context).a(context, videoAdRequest);
    }
}
