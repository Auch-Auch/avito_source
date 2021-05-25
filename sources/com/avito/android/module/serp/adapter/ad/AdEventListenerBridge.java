package com.avito.android.module.serp.adapter.ad;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.ad.AdEventListener;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/AdEventListenerBridge;", "Lcom/avito/android/serp/ad/AdEventListener;", "", "onAdClick", "()V", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/serp/ad/BannerInfo;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/ad/BannerInfo;", "getBannerInfo", "()Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "", "c", "I", "getPosition", "()I", VKApiConst.POSITION, "<init>", "(Ldagger/Lazy;Lcom/avito/android/serp/ad/BannerInfo;I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdEventListenerBridge implements AdEventListener {
    public final Lazy<AdBannerEventListener> a;
    @NotNull
    public final BannerInfo b;
    public final int c;

    public AdEventListenerBridge(@NotNull Lazy<AdBannerEventListener> lazy, @NotNull BannerInfo bannerInfo, int i) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        this.a = lazy;
        this.b = bannerInfo;
        this.c = i;
    }

    @NotNull
    public final BannerInfo getBannerInfo() {
        return this.b;
    }

    public final int getPosition() {
        return this.c;
    }

    @Override // com.avito.android.serp.ad.AdEventListener
    public void onAdClick() {
        this.a.get().onAdBannerOpened(this.b, this.c);
    }
}
