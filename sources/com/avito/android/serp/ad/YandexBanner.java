package com.avito.android.serp.ad;

import com.avito.android.remote.model.AdNetworkBanner;
import com.yandex.mobile.ads.nativeads.NativeGenericAd;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003R\u0016\u0010\u0006\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/avito/android/serp/ad/YandexBanner;", "Lcom/yandex/mobile/ads/nativeads/NativeGenericAd;", "T", "Lcom/avito/android/remote/model/AdNetworkBanner;", "getAd", "()Lcom/yandex/mobile/ads/nativeads/NativeGenericAd;", "ad", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface YandexBanner<T extends NativeGenericAd> extends AdNetworkBanner {
    @NotNull
    T getAd();
}
