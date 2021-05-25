package com.avito.android.serp.ad;

import com.yandex.mobile.ads.nativeads.NativeAdAssets;
import com.yandex.mobile.ads.nativeads.NativeContentAd;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/serp/ad/YandexContentBanner;", "Lcom/avito/android/serp/ad/YandexBanner;", "Lcom/yandex/mobile/ads/nativeads/NativeContentAd;", "", "hasDisclaimer", "()Z", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface YandexContentBanner extends YandexBanner<NativeContentAd> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static boolean hasDisclaimer(@NotNull YandexContentBanner yandexContentBanner) {
            String warning;
            NativeAdAssets adAssets = ((NativeContentAd) yandexContentBanner.getAd()).getAdAssets();
            return (adAssets == null || (warning = adAssets.getWarning()) == null || warning.length() <= 0) ? false : true;
        }
    }

    boolean hasDisclaimer();
}
