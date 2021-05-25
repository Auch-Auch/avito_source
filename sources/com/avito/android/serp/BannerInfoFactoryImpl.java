package com.avito.android.serp;

import com.avito.android.remote.model.AdNetworkBannerItem;
import com.avito.android.serp.ad.BannerInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u000b\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/serp/BannerInfoFactoryImpl;", "Lcom/avito/android/serp/BannerInfoFactory;", "Lcom/avito/android/remote/model/AdNetworkBannerItem;", "bannerItem", "", "pageCdtm", "", "fallbackCount", "", "samplingEnabled", "Lcom/avito/android/serp/ad/BannerInfo;", "create", "(Lcom/avito/android/remote/model/AdNetworkBannerItem;JIZ)Lcom/avito/android/serp/ad/BannerInfo;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class BannerInfoFactoryImpl implements BannerInfoFactory {
    @Override // com.avito.android.serp.BannerInfoFactory
    @NotNull
    public BannerInfo create(@NotNull AdNetworkBannerItem<?> adNetworkBannerItem, long j, int i, boolean z) {
        Intrinsics.checkNotNullParameter(adNetworkBannerItem, "bannerItem");
        return BannerInfo.Companion.from$default(BannerInfo.Companion, adNetworkBannerItem, j, i, z, 0, false, 48, null);
    }
}
