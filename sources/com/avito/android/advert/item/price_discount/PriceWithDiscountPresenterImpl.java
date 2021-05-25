package com.avito.android.advert.item.price_discount;

import com.avito.android.advert_core.analytics.discount.AdvertDetailsDiscountInfoClickEvent;
import com.avito.android.advert_core.discount.AdvertDiscountDetailsDialog;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDiscounts;
import com.avito.android.util.Collections;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert/item/price_discount/PriceWithDiscountPresenterImpl;", "Lcom/avito/android/advert/item/price_discount/PriceWithDiscountPresenter;", "Lcom/avito/android/advert/item/price_discount/PriceWithDiscountView;", "view", "Lcom/avito/android/advert/item/price_discount/PriceWithDiscountItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/price_discount/PriceWithDiscountView;Lcom/avito/android/advert/item/price_discount/PriceWithDiscountItem;I)V", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialog;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialog;", "dialog", "<init>", "(Ljava/lang/String;Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialog;Lcom/avito/android/analytics/Analytics;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class PriceWithDiscountPresenterImpl implements PriceWithDiscountPresenter {
    public final String a;
    public final AdvertDiscountDetailsDialog b;
    public final Analytics c;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PriceWithDiscountView a;
        public final /* synthetic */ PriceWithDiscountPresenterImpl b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PriceWithDiscountView priceWithDiscountView, PriceWithDiscountPresenterImpl priceWithDiscountPresenterImpl, PriceWithDiscountItem priceWithDiscountItem) {
            super(0);
            this.a = priceWithDiscountView;
            this.b = priceWithDiscountPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.showDialog(this.b.b);
            this.b.c.track(new AdvertDetailsDiscountInfoClickEvent(this.b.a));
            return Unit.INSTANCE;
        }
    }

    @Inject
    public PriceWithDiscountPresenterImpl(@AdvertId @NotNull String str, @NotNull AdvertDiscountDetailsDialog advertDiscountDetailsDialog, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(advertDiscountDetailsDialog, "dialog");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = str;
        this.b = advertDiscountDetailsDialog;
        this.c = analytics;
    }

    public void bindView(@NotNull PriceWithDiscountView priceWithDiscountView, @NotNull PriceWithDiscountItem priceWithDiscountItem, int i) {
        Intrinsics.checkNotNullParameter(priceWithDiscountView, "view");
        Intrinsics.checkNotNullParameter(priceWithDiscountItem, "item");
        priceWithDiscountView.showPrice(priceWithDiscountItem.getPrice());
        if (priceWithDiscountItem.getPriceWithoutDiscount() == null) {
            priceWithDiscountView.hidePriceWithoutDiscount();
        } else {
            priceWithDiscountView.showPriceWithoutDiscount(priceWithDiscountItem.getPriceWithoutDiscount());
        }
        if (priceWithDiscountItem.getClosedAdvert()) {
            priceWithDiscountView.applyClosedAdvert();
        }
        AdvertDiscounts discounts = priceWithDiscountItem.getDiscounts();
        if (discounts == null || Collections.isNullOrEmpty(discounts.getDiscounts())) {
            priceWithDiscountView.removeOnClickListener();
            priceWithDiscountView.hideRightIcon();
            return;
        }
        this.b.bindData(priceWithDiscountItem.getDiscounts(), priceWithDiscountItem.getActions(), priceWithDiscountItem.getContactBarData());
        priceWithDiscountView.setOnClickListener(new a(priceWithDiscountView, this, priceWithDiscountItem));
        priceWithDiscountView.showRightIcon();
    }
}
