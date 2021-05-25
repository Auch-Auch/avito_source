package com.avito.android.notification_center.landing.recommends.item.advert;

import com.avito.android.notification_center.landing.recommends.di.ItemAdvertRelay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.FavorableItem;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemPresenterImpl;", "Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemPresenter;", "Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemView;", "view", "Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItemView;Lcom/avito/android/notification_center/landing/recommends/item/advert/NotificationCenterLandingRecommendsAdvertItem;I)V", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/serp/adapter/FavorableItem;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/Relay;", "favoriteClickConsumer", AuthSource.SEND_ABUSE, "clickConsumer", "<init>", "(Lcom/jakewharton/rxrelay2/Relay;Lcom/jakewharton/rxrelay2/Relay;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingRecommendsAdvertItemPresenterImpl implements NotificationCenterLandingRecommendsAdvertItemPresenter {
    public final Relay<Integer> a;
    public final Relay<FavorableItem> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NotificationCenterLandingRecommendsAdvertItemPresenterImpl a;
        public final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(NotificationCenterLandingRecommendsAdvertItemPresenterImpl notificationCenterLandingRecommendsAdvertItemPresenterImpl, int i) {
            super(0);
            this.a = notificationCenterLandingRecommendsAdvertItemPresenterImpl;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(Integer.valueOf(this.b));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NotificationCenterLandingRecommendsAdvertItemPresenterImpl a;
        public final /* synthetic */ NotificationCenterLandingRecommendsAdvertItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(NotificationCenterLandingRecommendsAdvertItemPresenterImpl notificationCenterLandingRecommendsAdvertItemPresenterImpl, NotificationCenterLandingRecommendsAdvertItem notificationCenterLandingRecommendsAdvertItem) {
            super(0);
            this.a = notificationCenterLandingRecommendsAdvertItemPresenterImpl;
            this.b = notificationCenterLandingRecommendsAdvertItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.b.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NotificationCenterLandingRecommendsAdvertItemView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(NotificationCenterLandingRecommendsAdvertItemView notificationCenterLandingRecommendsAdvertItemView) {
            super(0);
            this.a = notificationCenterLandingRecommendsAdvertItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setAdvertClickListener(null);
            this.a.setAdvertFavoriteClickListener(null);
            this.a.setAdvertUnbindListener(null);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public NotificationCenterLandingRecommendsAdvertItemPresenterImpl(@ItemAdvertRelay @NotNull Relay<Integer> relay, @NotNull Relay<FavorableItem> relay2) {
        Intrinsics.checkNotNullParameter(relay, "clickConsumer");
        Intrinsics.checkNotNullParameter(relay2, "favoriteClickConsumer");
        this.a = relay;
        this.b = relay2;
    }

    public void bindView(@NotNull NotificationCenterLandingRecommendsAdvertItemView notificationCenterLandingRecommendsAdvertItemView, @NotNull NotificationCenterLandingRecommendsAdvertItem notificationCenterLandingRecommendsAdvertItem, int i) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingRecommendsAdvertItemView, "view");
        Intrinsics.checkNotNullParameter(notificationCenterLandingRecommendsAdvertItem, "item");
        notificationCenterLandingRecommendsAdvertItemView.setAdvertImage(notificationCenterLandingRecommendsAdvertItem.getImage());
        notificationCenterLandingRecommendsAdvertItemView.setAdvertTitle(notificationCenterLandingRecommendsAdvertItem.getTitle());
        notificationCenterLandingRecommendsAdvertItemView.setAdvertPrice(notificationCenterLandingRecommendsAdvertItem.getPrice());
        notificationCenterLandingRecommendsAdvertItemView.setAdvertPriceWithoutDiscount(notificationCenterLandingRecommendsAdvertItem.getPriceWithoutDiscount());
        notificationCenterLandingRecommendsAdvertItemView.setAdvertLocation(notificationCenterLandingRecommendsAdvertItem.getLocation());
        notificationCenterLandingRecommendsAdvertItemView.setAdvertDistance(notificationCenterLandingRecommendsAdvertItem.getDistance());
        notificationCenterLandingRecommendsAdvertItemView.setAdvertAddress(notificationCenterLandingRecommendsAdvertItem.getAddress());
        notificationCenterLandingRecommendsAdvertItemView.setAdvertIsFavorite(notificationCenterLandingRecommendsAdvertItem.isFavorite());
        notificationCenterLandingRecommendsAdvertItemView.setAdvertIsViewed(notificationCenterLandingRecommendsAdvertItem.isViewed());
        notificationCenterLandingRecommendsAdvertItemView.setAdvertClickListener(new a(this, i));
        notificationCenterLandingRecommendsAdvertItemView.setAdvertFavoriteClickListener(new b(this, notificationCenterLandingRecommendsAdvertItem));
        notificationCenterLandingRecommendsAdvertItemView.setAdvertUnbindListener(new c(notificationCenterLandingRecommendsAdvertItemView));
    }
}
