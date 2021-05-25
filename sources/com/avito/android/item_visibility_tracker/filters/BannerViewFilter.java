package com.avito.android.item_visibility_tracker.filters;

import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import com.avito.android.serp.ad.BannerInfoContainer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/item_visibility_tracker/filters/BannerViewFilter;", "Lcom/avito/android/item_visibility_tracker/filters/ItemVisibilityFilter;", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker$Item;", "item", "", "canStartTracking", "(Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker$Item;)Z", "", "track", "(Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker$Item;)V", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "e", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "interactor", "<init>", "(Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class BannerViewFilter extends ItemVisibilityFilter {
    public final CommercialBannersAnalyticsInteractor e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public BannerViewFilter(@NotNull CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor) {
        super(true, true, 0.0f, 0, 12, null);
        Intrinsics.checkNotNullParameter(commercialBannersAnalyticsInteractor, "interactor");
        this.e = commercialBannersAnalyticsInteractor;
    }

    @Override // com.avito.android.item_visibility_tracker.filters.ItemVisibilityFilter
    public boolean canStartTracking(@NotNull ItemVisibilityTracker.Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof BannerInfoContainer;
    }

    @Override // com.avito.android.item_visibility_tracker.filters.ItemVisibilityFilter
    public void track(@NotNull ItemVisibilityTracker.Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        CommercialBannersAnalyticsInteractor.DefaultImpls.sendBannerView$default(this.e, ((BannerInfoContainer) item).getBannerInfo(), null, 2, null);
    }
}
