package com.avito.android.advert_core.car_market_price.badge;

import com.adjust.sdk.Constants;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenter;
import com.avito.android.advert_core.analytics.imv.AdvertDetailsImvClickEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.component.badge_bar.badge.BadgeItem;
import com.avito.android.component.badge_bar.badge.BadgeItemPresenter;
import com.avito.android.component.badge_bar.badge.BadgeItemView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenterImpl;", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenter;", "Lcom/avito/android/component/badge_bar/badge/BadgeItemView;", "view", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/component/badge_bar/badge/BadgeItemView;Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItem;I)V", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter$Router;)V", "detachRouter", "()V", "Lcom/avito/android/component/badge_bar/badge/BadgeItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/component/badge_bar/badge/BadgeItemPresenter;", "badgeItemPresenter", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter$Router;", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Ljava/lang/String;Lcom/avito/android/analytics/Analytics;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsImvBadgePresenterImpl implements AdvertDetailsImvBadgePresenter {
    public AdvertBadgeBarPresenter.Router a;
    public final BadgeItemPresenter b;

    public static final class a extends Lambda implements Function1<BadgeItem, Unit> {
        public final /* synthetic */ AdvertDetailsImvBadgePresenterImpl a;
        public final /* synthetic */ Analytics b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertDetailsImvBadgePresenterImpl advertDetailsImvBadgePresenterImpl, Analytics analytics, String str) {
            super(1);
            this.a = advertDetailsImvBadgePresenterImpl;
            this.b = analytics;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(BadgeItem badgeItem) {
            AdvertBadgeBarPresenter.Router router;
            BadgeItem badgeItem2 = badgeItem;
            Intrinsics.checkNotNullParameter(badgeItem2, "it");
            this.b.track(new AdvertDetailsImvClickEvent(this.c));
            DeepLink uri = badgeItem2.getUri();
            if (!(uri == null || (router = this.a.a) == null)) {
                router.followDeepLink(uri);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public AdvertDetailsImvBadgePresenterImpl(@AdvertId @NotNull String str, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = new BadgeItemPresenter(new a(this, analytics, str));
    }

    @Override // com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenter
    public void attachRouter(@NotNull AdvertBadgeBarPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
    }

    @Override // com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenter
    public void detachRouter() {
        this.a = null;
    }

    public void bindView(@NotNull BadgeItemView badgeItemView, @NotNull AdvertDetailsImvBadgeItem advertDetailsImvBadgeItem, int i) {
        Intrinsics.checkNotNullParameter(badgeItemView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsImvBadgeItem, "item");
        this.b.bindView(badgeItemView, advertDetailsImvBadgeItem.getBadgeItem(), i);
        String priceType = advertDetailsImvBadgeItem.getPriceType();
        if (priceType != null) {
            int hashCode = priceType.hashCode();
            if (hashCode != -1039745817) {
                if (hashCode == 107348 && priceType.equals(Constants.LOW)) {
                    badgeItemView.setLocalHardcodedImage(R.drawable.ic_imv_low_image);
                }
            } else if (priceType.equals("normal")) {
                badgeItemView.setLocalHardcodedImage(R.drawable.ic_imv_normal_image);
            }
        }
    }
}
