package com.avito.android.notification_center.landing.recommends.item.review;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPositiveClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setNegativeClickListener", "setUnbindListener", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterLandingRecommendsReviewItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull NotificationCenterLandingRecommendsReviewItemView notificationCenterLandingRecommendsReviewItemView) {
            ItemView.DefaultImpls.onUnbind(notificationCenterLandingRecommendsReviewItemView);
        }
    }

    void setNegativeClickListener(@Nullable Function0<Unit> function0);

    void setPositiveClickListener(@Nullable Function0<Unit> function0);

    void setUnbindListener(@Nullable Function0<Unit> function0);
}
