package com.avito.android.advert.item.marketplace_brief_specs;

import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsPresenter;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsPresenterImpl;", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsPresenter;", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsPresenter$Listener;", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsView;", "view", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsView;Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsItem;I)V", "onInfoClick", "()V", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "advertDetailsAnalyticsInteractor", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Ljava/lang/String;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceBriefSpecsPresenterImpl implements MarketplaceBriefSpecsPresenter, MarketplaceBriefSpecsPresenter.Listener {
    public final String a;
    public final AdvertDetailsAnalyticsInteractor b;

    @Inject
    public MarketplaceBriefSpecsPresenterImpl(@AdvertId @NotNull String str, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "advertDetailsAnalyticsInteractor");
        this.a = str;
        this.b = advertDetailsAnalyticsInteractor;
    }

    @Override // com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsPresenter.Listener
    public void onInfoClick() {
        this.b.sendInStockInfoClick(this.a);
    }

    public void bindView(@NotNull MarketplaceBriefSpecsView marketplaceBriefSpecsView, @NotNull MarketplaceBriefSpecsItem marketplaceBriefSpecsItem, int i) {
        Intrinsics.checkNotNullParameter(marketplaceBriefSpecsView, "view");
        Intrinsics.checkNotNullParameter(marketplaceBriefSpecsItem, "item");
        marketplaceBriefSpecsView.showSpecs(marketplaceBriefSpecsItem.getParams(), marketplaceBriefSpecsItem.getInStock(), this);
    }
}
