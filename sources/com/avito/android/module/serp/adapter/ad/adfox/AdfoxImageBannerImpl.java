package com.avito.android.module.serp.adapter.ad.adfox;

import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.nativeads.NativeImageAd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxImageBannerImpl;", "Lcom/avito/android/module/serp/adapter/ad/adfox/AdfoxImageBanner;", "Lcom/yandex/mobile/ads/nativeads/NativeImageAd;", AuthSource.SEND_ABUSE, "Lcom/yandex/mobile/ads/nativeads/NativeImageAd;", "getAd", "()Lcom/yandex/mobile/ads/nativeads/NativeImageAd;", "ad", "<init>", "(Lcom/yandex/mobile/ads/nativeads/NativeImageAd;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdfoxImageBannerImpl implements AdfoxImageBanner {
    @NotNull
    public final NativeImageAd a;

    public AdfoxImageBannerImpl(@NotNull NativeImageAd nativeImageAd) {
        Intrinsics.checkNotNullParameter(nativeImageAd, "ad");
        this.a = nativeImageAd;
    }

    @Override // com.avito.android.serp.ad.YandexBanner
    @NotNull
    public NativeImageAd getAd() {
        return this.a;
    }
}
