package com.avito.android.remote.parse.adapter;

import com.avito.android.Features;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdfoxBannerItem;
import com.avito.android.remote.model.DfpBannerItem;
import com.avito.android.remote.model.Disclaimer;
import com.avito.android.remote.model.HeaderElement;
import com.avito.android.remote.model.LinkedInfoBanner;
import com.avito.android.remote.model.MyTargetBannerItem;
import com.avito.android.remote.model.OtherAdverts;
import com.avito.android.remote.model.SellerElement;
import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.remote.model.SerpAdvertEmptyPlaceholder;
import com.avito.android.remote.model.SerpAdvertGroupTitle;
import com.avito.android.remote.model.SerpAdvertXl;
import com.avito.android.remote.model.SerpBannerContainer;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SerpPromoCardModel;
import com.avito.android.remote.model.SerpVipAdverts;
import com.avito.android.remote.model.SerpWarning;
import com.avito.android.remote.model.ServiceTypeKt;
import com.avito.android.remote.model.ShortcutBanner;
import com.avito.android.remote.model.UserAdvert;
import com.avito.android.remote.model.WitcherElement;
import com.avito.android.remote.model.YandexNativeBannerItem;
import com.avito.android.remote.model.feature_teaser.CreReportTeaser;
import com.avito.android.remote.model.location_notification.LocationNotification;
import com.avito.android.remote.model.map_banner.MapBanner;
import com.avito.android.remote.model.serp.Snippet;
import com.avito.android.remote.model.user_adverts.DiscountBanner;
import com.avito.android.remote.model.user_adverts.PerformanceVasBanner;
import com.avito.android.remote.model.vertical_main.SearchFormWidget;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.toggle.Feature;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R1\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\t0\u00078T@\u0014X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/parse/adapter/SerpElementTypeAdapter;", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapter;", "Lcom/avito/android/remote/model/SerpElement;", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "", "", "Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getMapping", "()Ljava/util/Map;", "mapping", "<init>", "(Lcom/avito/android/Features;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class SerpElementTypeAdapter extends RuntimeTypeAdapter<SerpElement> {
    @NotNull
    public final Lazy a;
    public final Features b;

    public static final class a extends Lambda implements Function0<Map<String, Class<? extends SerpElement>>> {
        public final /* synthetic */ SerpElementTypeAdapter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SerpElementTypeAdapter serpElementTypeAdapter) {
            super(0);
            this.a = serpElementTypeAdapter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Map<String, Class<? extends SerpElement>> invoke() {
            Feature<Boolean> verifiedByAvito;
            Map<String, Class<? extends SerpElement>> mutableMapOf = r.mutableMapOf(TuplesKt.to("item", SerpAdvert.class), TuplesKt.to("xlItem", SerpAdvertXl.class), TuplesKt.to("banner", SerpBannerContainer.class), TuplesKt.to(ServiceTypeKt.SERVICE_VIP, SerpVipAdverts.class), TuplesKt.to("dfp", DfpBannerItem.class), TuplesKt.to("yandex", YandexNativeBannerItem.class), TuplesKt.to("adfox", AdfoxBannerItem.class), TuplesKt.to("shortcut", ShortcutBanner.class), TuplesKt.to("user_item", UserAdvert.class), TuplesKt.to("discount_banner", DiscountBanner.class), TuplesKt.to("performance_vas_banner", PerformanceVasBanner.class), TuplesKt.to("other_items", OtherAdverts.class), TuplesKt.to("info_banner", ShortcutBanner.class), TuplesKt.to("disclaimer", Disclaimer.class), TuplesKt.to("myTarget", MyTargetBannerItem.class), TuplesKt.to("snippet", Snippet.class), TuplesKt.to("warning", SerpWarning.class), TuplesKt.to("groupTitle", SerpAdvertGroupTitle.class), TuplesKt.to(InternalConstsKt.PLACEHOLDER, SerpAdvertEmptyPlaceholder.class), TuplesKt.to(TariffPackageInfoConverterKt.HEADER_STRING_ID, HeaderElement.class), TuplesKt.to("witcher", WitcherElement.class), TuplesKt.to("laasTooltip", LocationNotification.class), TuplesKt.to("sellerItem", SellerElement.class), TuplesKt.to("linked_info_banner", LinkedInfoBanner.class), TuplesKt.to("findOfficeOffer", CreReportTeaser.class), TuplesKt.to("promoCard", SerpPromoCardModel.class), TuplesKt.to("mapBanner", MapBanner.class), TuplesKt.to("searchFormWidget", SearchFormWidget.class));
            Features features = this.a.b;
            if (!(features == null || (verifiedByAvito = features.getVerifiedByAvito()) == null || !verifiedByAvito.invoke().booleanValue())) {
                mutableMapOf.put("linked_info_banner.v2", LinkedInfoBanner.class);
            }
            return mutableMapOf;
        }
    }

    public SerpElementTypeAdapter() {
        this(null, 1, null);
    }

    public SerpElementTypeAdapter(@Nullable Features features) {
        super(null, null, null, 7, null);
        this.b = features;
        this.a = c.lazy(new a(this));
    }

    @Override // com.avito.android.remote.parse.adapter.RuntimeTypeAdapter
    @NotNull
    public Map<String, Class<? extends SerpElement>> getMapping() {
        return (Map) this.a.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SerpElementTypeAdapter(Features features, int i, j jVar) {
        this((i & 1) != 0 ? null : features);
    }
}
