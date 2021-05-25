package com.avito.android.advert.item.dfpcreditinfo;

import com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor;
import com.avito.android.brandspace_entry_point.BrandspaceEntryPointAnalyticsInteractor;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.item_visibility_tracker.filters.ItemVisibilityFilter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/CreditBannerFilter;", "Lcom/avito/android/item_visibility_tracker/filters/ItemVisibilityFilter;", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker$Item;", "item", "", "canStartTracking", "(Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker$Item;)Z", "", "track", "(Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker$Item;)V", "Lcom/avito/android/brandspace_entry_point/BrandspaceEntryPointAnalyticsInteractor;", "f", "Lcom/avito/android/brandspace_entry_point/BrandspaceEntryPointAnalyticsInteractor;", "brandspaceEntryPointInteractor", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;", "e", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;", "interactor", "<init>", "(Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;Lcom/avito/android/brandspace_entry_point/BrandspaceEntryPointAnalyticsInteractor;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class CreditBannerFilter extends ItemVisibilityFilter {
    public final CreditBrokerAnalyticsInteractor e;
    public final BrandspaceEntryPointAnalyticsInteractor f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public CreditBannerFilter(@NotNull CreditBrokerAnalyticsInteractor creditBrokerAnalyticsInteractor, @NotNull BrandspaceEntryPointAnalyticsInteractor brandspaceEntryPointAnalyticsInteractor) {
        super(true, true, 0.0f, 0, 12, null);
        Intrinsics.checkNotNullParameter(creditBrokerAnalyticsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(brandspaceEntryPointAnalyticsInteractor, "brandspaceEntryPointInteractor");
        this.e = creditBrokerAnalyticsInteractor;
        this.f = brandspaceEntryPointAnalyticsInteractor;
    }

    @Override // com.avito.android.item_visibility_tracker.filters.ItemVisibilityFilter
    public boolean canStartTracking(@NotNull ItemVisibilityTracker.Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof AdvertDetailsCreditInfoItem;
    }

    @Override // com.avito.android.item_visibility_tracker.filters.ItemVisibilityFilter
    public void track(@NotNull ItemVisibilityTracker.Item item) {
        String brandSlug;
        Intrinsics.checkNotNullParameter(item, "item");
        DfpCreditInfo creditInfo = ((AdvertDetailsCreditInfoItem) item).getCreditInfo();
        if (creditInfo instanceof DfpCreditInfo.CreditCalculator) {
            this.e.sendCreditCalculatorView();
        } else if ((creditInfo instanceof DfpCreditInfo.Web) && (brandSlug = ((DfpCreditInfo.Web) creditInfo).getBrandSlug()) != null) {
            if (!(m.isBlank(brandSlug))) {
                this.f.sendBrandspaceEntryPointView("app", brandSlug);
            }
        }
    }
}
