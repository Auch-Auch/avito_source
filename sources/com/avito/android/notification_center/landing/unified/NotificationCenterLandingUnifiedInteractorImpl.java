package com.avito.android.notification_center.landing.unified;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.notification_center.landing.unified.NotificationCenterLandingUnified;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedInteractorImpl;", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedInteractor;", "", "id", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingUnified;", "getNotificationCenterLandingUnified", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/NotificationsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/NotificationsApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Lcom/avito/android/remote/NotificationsApi;Lcom/avito/android/util/SchedulersFactory;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingUnifiedInteractorImpl implements NotificationCenterLandingUnifiedInteractor {
    public final NotificationsApi a;
    public final SchedulersFactory b;

    @Inject
    public NotificationCenterLandingUnifiedInteractorImpl(@NotNull NotificationsApi notificationsApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(notificationsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = notificationsApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedInteractor
    @NotNull
    public Observable<NotificationCenterLandingUnified> getNotificationCenterLandingUnified(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Observable subscribeOn = InteropKt.toV2(this.a.getNotificationCenterLandingUnified(str)).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getNotificationCente…n(schedulersFactory.io())");
        return TypedObservablesKt.toTyped(subscribeOn);
    }
}
