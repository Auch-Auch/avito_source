package com.avito.android.notification_center.landing.recommends.item.review;

import com.avito.android.notification_center.landing.recommends.di.ItemReviewRelay;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemPresenterImpl;", "Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemPresenter;", "Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemView;", "view", "Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemView;Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItem;I)V", "Lcom/jakewharton/rxrelay2/Relay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/Relay;", "consumer", "<init>", "(Lcom/jakewharton/rxrelay2/Relay;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingRecommendsReviewItemPresenterImpl implements NotificationCenterLandingRecommendsReviewItemPresenter {
    public final Relay<Integer> a;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((NotificationCenterLandingRecommendsReviewItemPresenterImpl) this.b).a.accept(1);
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((NotificationCenterLandingRecommendsReviewItemPresenterImpl) this.b).a.accept(0);
                return Unit.INSTANCE;
            } else if (i == 2) {
                ((NotificationCenterLandingRecommendsReviewItemView) this.b).setPositiveClickListener(null);
                ((NotificationCenterLandingRecommendsReviewItemView) this.b).setNegativeClickListener(null);
                ((NotificationCenterLandingRecommendsReviewItemView) this.b).setUnbindListener(null);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @Inject
    public NotificationCenterLandingRecommendsReviewItemPresenterImpl(@ItemReviewRelay @NotNull Relay<Integer> relay) {
        Intrinsics.checkNotNullParameter(relay, "consumer");
        this.a = relay;
    }

    public void bindView(@NotNull NotificationCenterLandingRecommendsReviewItemView notificationCenterLandingRecommendsReviewItemView, @NotNull NotificationCenterLandingRecommendsReviewItem notificationCenterLandingRecommendsReviewItem, int i) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingRecommendsReviewItemView, "view");
        Intrinsics.checkNotNullParameter(notificationCenterLandingRecommendsReviewItem, "item");
        notificationCenterLandingRecommendsReviewItemView.setPositiveClickListener(new a(0, this));
        notificationCenterLandingRecommendsReviewItemView.setNegativeClickListener(new a(1, this));
        notificationCenterLandingRecommendsReviewItemView.setUnbindListener(new a(2, notificationCenterLandingRecommendsReviewItemView));
    }
}
