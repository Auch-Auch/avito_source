package com.avito.android.advert_core.advert_badge_bar;

import com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenter;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.component.badge_bar.badge.BadgeItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.advert_badge_bar.BadgeBarOrientation;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenterImpl;", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter;", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarItemView;", "view", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarItemView;Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarItem;I)V", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter$Router;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter$Router;", "getRouter", "()Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter$Router;", "setRouter", "(Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter$Router;)V", "router", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "<init>", "(Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertBadgeBarPresenterImpl implements AdvertBadgeBarPresenter {
    @Nullable
    public AdvertBadgeBarPresenter.Router a;
    public final AdvertDetailsAnalyticsInteractor b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            BadgeBarOrientation.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            BadgeBarOrientation badgeBarOrientation = BadgeBarOrientation.HORIZONTAL;
            iArr[0] = 1;
            BadgeBarOrientation badgeBarOrientation2 = BadgeBarOrientation.VERTICAL;
            iArr[1] = 2;
        }
    }

    public static final class a extends Lambda implements Function1<BadgeItem, Unit> {
        public final /* synthetic */ AdvertBadgeBarPresenterImpl a;
        public final /* synthetic */ AdvertBadgeBarItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertBadgeBarPresenterImpl advertBadgeBarPresenterImpl, AdvertBadgeBarItem advertBadgeBarItem) {
            super(1);
            this.a = advertBadgeBarPresenterImpl;
            this.b = advertBadgeBarItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(BadgeItem badgeItem) {
            AdvertBadgeBarPresenter.Router router;
            BadgeItem badgeItem2 = badgeItem;
            Intrinsics.checkNotNullParameter(badgeItem2, "it");
            this.a.b.sendBadgeClicked(this.b.getAdvertId(), badgeItem2.getBadgeId());
            DeepLink uri = badgeItem2.getUri();
            if (!(uri == null || (router = this.a.getRouter()) == null)) {
                router.followDeepLink(uri);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertBadgeBarPresenterImpl a;
        public final /* synthetic */ AdvertBadgeBarItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AdvertBadgeBarPresenterImpl advertBadgeBarPresenterImpl, AdvertBadgeBarItem advertBadgeBarItem) {
            super(0);
            this.a = advertBadgeBarPresenterImpl;
            this.b = advertBadgeBarItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.setExpanded(true);
            this.a.b.sendBadgeBarExpandButtonClicked(this.b.getAdvertId());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public AdvertBadgeBarPresenterImpl(@NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        this.b = advertDetailsAnalyticsInteractor;
    }

    @Override // com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenter
    @Nullable
    public AdvertBadgeBarPresenter.Router getRouter() {
        return this.a;
    }

    @Override // com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenter
    public void setRouter(@Nullable AdvertBadgeBarPresenter.Router router) {
        this.a = router;
    }

    public void bindView(@NotNull AdvertBadgeBarItemView advertBadgeBarItemView, @NotNull AdvertBadgeBarItem advertBadgeBarItem, int i) {
        Intrinsics.checkNotNullParameter(advertBadgeBarItemView, "view");
        Intrinsics.checkNotNullParameter(advertBadgeBarItem, "item");
        advertBadgeBarItemView.setBadges(advertBadgeBarItem.getBadges(), advertBadgeBarItem.getPreloadCount(), advertBadgeBarItem.getShowMoreTitle());
        advertBadgeBarItemView.setExpanded(advertBadgeBarItem.isExpanded());
        int ordinal = advertBadgeBarItem.getOrientation().ordinal();
        int i2 = 1;
        if (ordinal == 0) {
            i2 = 0;
        } else if (ordinal != 1) {
            throw new NoWhenBranchMatchedException();
        }
        advertBadgeBarItemView.setOrientation(i2);
        advertBadgeBarItemView.setOnBadgeClickListener(new a(this, advertBadgeBarItem));
        advertBadgeBarItemView.setExpandButtonClickListener(new b(this, advertBadgeBarItem));
    }
}
