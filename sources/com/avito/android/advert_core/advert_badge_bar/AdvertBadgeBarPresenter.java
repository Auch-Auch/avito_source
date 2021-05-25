package com.avito.android.advert_core.advert_badge_bar;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarItemView;", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarItem;", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter$Router;", "getRouter", "()Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter$Router;", "setRouter", "(Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter$Router;)V", "router", "Router", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertBadgeBarPresenter extends ItemPresenter<AdvertBadgeBarItemView, AdvertBadgeBarItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter$Router;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        @Override // com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserPresenter.Router, com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter.Router
        void followDeepLink(@NotNull DeepLink deepLink);
    }

    @Nullable
    Router getRouter();

    void setRouter(@Nullable Router router);
}
