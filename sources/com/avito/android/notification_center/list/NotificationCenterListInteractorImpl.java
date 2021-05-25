package com.avito.android.notification_center.list;

import android.net.Uri;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.notification.NotificationsResponse;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/notification_center/list/NotificationCenterListInteractorImpl;", "Lcom/avito/android/notification_center/list/NotificationCenterListInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/notification/NotificationsResponse;", "getNotifications", "()Lio/reactivex/Observable;", "Landroid/net/Uri;", "nextPage", "(Landroid/net/Uri;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/remote/NotificationsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/NotificationsApi;", "api", "<init>", "(Lcom/avito/android/remote/NotificationsApi;Lcom/avito/android/util/SchedulersFactory;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterListInteractorImpl implements NotificationCenterListInteractor {
    public final NotificationsApi a;
    public final SchedulersFactory b;

    @Inject
    public NotificationCenterListInteractorImpl(@NotNull NotificationsApi notificationsApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(notificationsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = notificationsApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListInteractor
    @NotNull
    public Observable<NotificationsResponse> getNotifications() {
        Observable subscribeOn = InteropKt.toV2(this.a.getNotifications()).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getNotifications().t…n(schedulersFactory.io())");
        return TypedObservablesKt.toTyped(subscribeOn);
    }

    @Override // com.avito.android.notification_center.list.NotificationCenterListInteractor
    @NotNull
    public Observable<NotificationsResponse> getNotifications(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "nextPage");
        NotificationsApi notificationsApi = this.a;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "nextPage.toString()");
        Observable subscribeOn = InteropKt.toV2(notificationsApi.getNotifications(uri2)).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getNotifications(nex…n(schedulersFactory.io())");
        return TypedObservablesKt.toTyped(subscribeOn);
    }
}
