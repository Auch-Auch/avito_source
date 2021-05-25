package com.avito.android.notification_center.landing.recommends;

import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsPresenter;", "", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsView;", "view", "", "attachView", "(Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsView;)V", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsRouter;", "router", "attachRouter", "(Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsRouter;)V", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "detachRouter", "()V", "detachView", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterLandingRecommendsPresenter {
    void attachRouter(@NotNull NotificationCenterLandingRecommendsRouter notificationCenterLandingRecommendsRouter);

    void attachView(@NotNull NotificationCenterLandingRecommendsView notificationCenterLandingRecommendsView);

    void detachRouter();

    void detachView();

    @NotNull
    Kundle getState();
}
