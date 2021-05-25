package com.avito.android.advert.item.commercials;

import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.SerpCommercialBannerConverter;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/item/commercials/AdvertCommercialsConverterImpl;", "Lcom/avito/android/advert/item/commercials/AdvertCommercialsConverter;", "", "Lcom/avito/android/advert/item/commercials/PositionedBannerContainer;", "banners", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/advert/item/commercials/AdvertCommercials;", "convert", "(Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;)Lcom/avito/android/advert/item/commercials/AdvertCommercials;", "Lcom/avito/android/serp/adapter/SerpCommercialBannerConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpCommercialBannerConverter;", "serpCommercialBannerConverter", "<init>", "(Lcom/avito/android/serp/adapter/SerpCommercialBannerConverter;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertCommercialsConverterImpl implements AdvertCommercialsConverter {
    public final SerpCommercialBannerConverter a;

    @Inject
    public AdvertCommercialsConverterImpl(@AdvertFragmentModule.AdvertSerpCommercialBannerConverter @NotNull SerpCommercialBannerConverter serpCommercialBannerConverter) {
        Intrinsics.checkNotNullParameter(serpCommercialBannerConverter, "serpCommercialBannerConverter");
        this.a = serpCommercialBannerConverter;
    }

    @Override // com.avito.android.advert.item.commercials.AdvertCommercialsConverter
    @NotNull
    public AdvertCommercials convert(@NotNull List<PositionedBannerContainer> list, @NotNull SerpDisplayType serpDisplayType) {
        AdvertSerpCommercialBanner advertSerpCommercialBanner;
        T t;
        T t2;
        ViewTypeSerpItem convert;
        ViewTypeSerpItem convert2;
        Intrinsics.checkNotNullParameter(list, "banners");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Iterator<T> it = list.iterator();
        while (true) {
            advertSerpCommercialBanner = null;
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getPosition(), "item_atf_android")) {
                break;
            }
        }
        T t3 = t;
        AdvertSerpCommercialBanner advertSerpCommercialBanner2 = (t3 == null || (convert2 = this.a.convert(t3.getBanner(), serpDisplayType)) == null) ? null : new AdvertSerpCommercialBanner(convert2);
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it2.next();
            if (Intrinsics.areEqual(t2.getPosition(), "item_btf_android")) {
                break;
            }
        }
        T t4 = t2;
        if (!(t4 == null || (convert = this.a.convert(t4.getBanner(), serpDisplayType)) == null)) {
            advertSerpCommercialBanner = new AdvertSerpCommercialBanner(convert);
        }
        return new AdvertCommercials(advertSerpCommercialBanner2, advertSerpCommercialBanner);
    }
}
