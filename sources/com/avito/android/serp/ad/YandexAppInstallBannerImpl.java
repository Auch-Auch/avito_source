package com.avito.android.serp.ad;

import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.nativeads.NativeAppInstallAd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/serp/ad/YandexAppInstallBannerImpl;", "Lcom/avito/android/serp/ad/YandexAppInstallBanner;", "Lcom/yandex/mobile/ads/nativeads/NativeAppInstallAd;", AuthSource.SEND_ABUSE, "Lcom/yandex/mobile/ads/nativeads/NativeAppInstallAd;", "getAd", "()Lcom/yandex/mobile/ads/nativeads/NativeAppInstallAd;", "ad", "<init>", "(Lcom/yandex/mobile/ads/nativeads/NativeAppInstallAd;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class YandexAppInstallBannerImpl implements YandexAppInstallBanner {
    @NotNull
    public final NativeAppInstallAd a;

    public YandexAppInstallBannerImpl(@NotNull NativeAppInstallAd nativeAppInstallAd) {
        Intrinsics.checkNotNullParameter(nativeAppInstallAd, "ad");
        this.a = nativeAppInstallAd;
    }

    @Override // com.avito.android.serp.ad.YandexBanner
    @NotNull
    public NativeAppInstallAd getAd() {
        return this.a;
    }
}
