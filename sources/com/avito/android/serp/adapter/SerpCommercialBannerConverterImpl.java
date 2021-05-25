package com.avito.android.serp.adapter;

import com.avito.android.module.serp.adapter.ad.adfox.AdfoxBannerItem;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxImageBanner;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallBannerItem;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentBannerItem;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallBannerItem;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexBannerItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdNetworkBanner;
import com.avito.android.remote.model.AdSize;
import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.LoadedNetworkBanner;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.ad.DfpBanner;
import com.avito.android.serp.ad.MyTargetBanner;
import com.avito.android.serp.ad.YandexAppInstallBanner;
import com.avito.android.serp.ad.YandexContentBanner;
import com.avito.android.util.RandomKeyProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/serp/adapter/SerpCommercialBannerConverterImpl;", "Lcom/avito/android/serp/adapter/SerpCommercialBannerConverter;", "Lcom/avito/android/serp/adapter/SerpCommercialBanner;", "serpCommercialBanner", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "convert", "(Lcom/avito/android/serp/adapter/SerpCommercialBanner;Lcom/avito/android/remote/model/SerpDisplayType;)Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "Lcom/avito/android/util/RandomKeyProvider;", "d", "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "Lcom/avito/android/serp/ad/AdResourceProvider;", "c", "Lcom/avito/android/serp/ad/AdResourceProvider;", "adResourceProvider", "Lcom/avito/android/serp/adapter/AdvertSpanCountProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/AdvertSpanCountProvider;", "bigSpanCountProvider", AuthSource.SEND_ABUSE, "itemSpanCountProvider", "<init>", "(Lcom/avito/android/serp/adapter/AdvertSpanCountProvider;Lcom/avito/android/serp/adapter/AdvertSpanCountProvider;Lcom/avito/android/serp/ad/AdResourceProvider;Lcom/avito/android/util/RandomKeyProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpCommercialBannerConverterImpl implements SerpCommercialBannerConverter {
    public final AdvertSpanCountProvider a;
    public final AdvertSpanCountProvider b;
    public final AdResourceProvider c;
    public final RandomKeyProvider d;

    public SerpCommercialBannerConverterImpl(@NotNull AdvertSpanCountProvider advertSpanCountProvider, @NotNull AdvertSpanCountProvider advertSpanCountProvider2, @NotNull AdResourceProvider adResourceProvider, @NotNull RandomKeyProvider randomKeyProvider) {
        Intrinsics.checkNotNullParameter(advertSpanCountProvider, "itemSpanCountProvider");
        Intrinsics.checkNotNullParameter(advertSpanCountProvider2, "bigSpanCountProvider");
        Intrinsics.checkNotNullParameter(adResourceProvider, "adResourceProvider");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        this.a = advertSpanCountProvider;
        this.b = advertSpanCountProvider2;
        this.c = adResourceProvider;
        this.d = randomKeyProvider;
    }

    @Override // com.avito.android.serp.adapter.SerpCommercialBannerConverter
    @Nullable
    public ViewTypeSerpItem convert(@NotNull SerpCommercialBanner serpCommercialBanner, @NotNull SerpDisplayType serpDisplayType) {
        String str;
        LoadedNetworkBanner loadedNetworkBanner;
        LoadedNetworkBanner loadedNetworkBanner2;
        Intrinsics.checkNotNullParameter(serpCommercialBanner, "serpCommercialBanner");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        String generateKey = this.d.generateKey();
        long uniqueId = SerpElementUtilsKt.getUniqueId(serpCommercialBanner.getUniqueId(), generateKey);
        AdSize adSize = serpCommercialBanner.getAdSize();
        int spanCount = this.c.getSpanCount(this.a.getSpanCount(serpDisplayType), this.b.getSpanCount(serpDisplayType), adSize);
        SerpViewType serpViewType = this.c.getSerpViewType(serpDisplayType, adSize);
        CommercialBanner commercialBanner = serpCommercialBanner.getCommercialBanner();
        if (serpCommercialBanner.isEmpty()) {
            return new SerpCommercialBanner(uniqueId, generateKey, serpViewType, serpDisplayType, spanCount, adSize, null);
        }
        if (serpCommercialBanner.getHasNotLoadedAd()) {
            return new SerpCommercialBanner(uniqueId, generateKey, serpViewType, serpDisplayType, spanCount, adSize, commercialBanner);
        }
        AdNetworkBanner adNetworkBanner = (commercialBanner == null || (loadedNetworkBanner2 = commercialBanner.getLoadedNetworkBanner()) == null) ? null : loadedNetworkBanner2.getAdNetworkBanner();
        BannerInfo from = BannerInfo.Companion.from(commercialBanner != null ? commercialBanner.getLoadedNetworkBannerItem() : null, commercialBanner);
        if (commercialBanner == null || (loadedNetworkBanner = commercialBanner.getLoadedNetworkBanner()) == null || (str = loadedNetworkBanner.getId()) == null) {
            str = "";
        }
        if (adNetworkBanner instanceof DfpBanner.DfpUnifiedBanner) {
            return new DfpUnifiedBannerItem(uniqueId, str, (DfpBanner.DfpUnifiedBanner) adNetworkBanner, spanCount, serpViewType, serpDisplayType, from);
        }
        if (adNetworkBanner instanceof DfpBanner.DfpContentBanner) {
            return new DfpContentBannerItem(uniqueId, str, (DfpBanner.DfpContentBanner) adNetworkBanner, spanCount, serpViewType, serpDisplayType, from);
        }
        if (adNetworkBanner instanceof DfpBanner.DfpAppInstallBanner) {
            return new DfpAppInstallBannerItem(uniqueId, str, (DfpBanner.DfpAppInstallBanner) adNetworkBanner, spanCount, serpViewType, serpDisplayType, from);
        }
        if (adNetworkBanner instanceof YandexAppInstallBanner) {
            return new YandexAppInstallBannerItem(uniqueId, str, (YandexAppInstallBanner) adNetworkBanner, spanCount, serpViewType, serpDisplayType, false, false, from);
        }
        if (adNetworkBanner instanceof YandexContentBanner) {
            return new YandexBannerItem(uniqueId, str, (YandexContentBanner) adNetworkBanner, spanCount, serpViewType, serpDisplayType, false, from, SerpItemUtilsKt.getIsRedesign(adSize, serpDisplayType));
        }
        if (adNetworkBanner instanceof MyTargetBanner.MyTargetAppInstallBanner) {
            return new MyTargetAppInstallBannerItem(uniqueId, str, (MyTargetBanner.MyTargetAppInstallBanner) adNetworkBanner, spanCount, serpViewType, serpDisplayType, from);
        }
        if (adNetworkBanner instanceof MyTargetBanner.MyTargetContentBanner) {
            return new MyTargetContentBannerItem(uniqueId, str, (MyTargetBanner.MyTargetContentBanner) adNetworkBanner, spanCount, serpViewType, serpDisplayType, from);
        }
        if (adNetworkBanner instanceof AdfoxImageBanner) {
            return new AdfoxBannerItem(uniqueId, str, (AdfoxImageBanner) adNetworkBanner, spanCount, serpViewType, serpDisplayType, false, from, SerpItemUtilsKt.getIsRedesign(adSize, serpDisplayType));
        }
        return null;
    }
}
