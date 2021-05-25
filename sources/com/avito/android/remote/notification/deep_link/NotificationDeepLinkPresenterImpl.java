package com.avito.android.remote.notification.deep_link;

import com.avito.android.CalledFrom;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.notification_center.NotificationButtonClickEvent;
import com.avito.android.analytics.event.notification_center.NotificationCenterOpenItemEvent;
import com.avito.android.analytics.event.notification_center.NotificationCenterPushClickEvent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NotificationCenterMarker;
import com.avito.android.deep_linking.links.PromoLink;
import com.avito.android.notification_center.counter.NotificationCenterCounterMarker;
import com.avito.android.notification_center.push.NcPushClicksListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.notification.Payload;
import com.avito.android.remote.notification.NotificationIdentifier;
import com.avito.android.remote.notification.NotificationInteractor;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u001d\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b \u0010!J7\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\t\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/avito/android/remote/notification/deep_link/NotificationDeepLinkPresenterImpl;", "Lcom/avito/android/remote/notification/deep_link/NotificationDeepLinkPresenter;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/remote/notification/NotificationIdentifier;", "identifier", "Lcom/avito/android/remote/model/notification/Payload;", "payload", "Lcom/avito/android/remote/notification/deep_link/AnalyticParams;", "analytics", "", Tracker.Events.CREATIVE_START, "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/notification/NotificationIdentifier;Lcom/avito/android/remote/model/notification/Payload;Lcom/avito/android/remote/notification/deep_link/AnalyticParams;)V", "Lcom/avito/android/remote/notification/NotificationInteractor;", "d", "Lcom/avito/android/remote/notification/NotificationInteractor;", "notificationInteractor", "Lcom/avito/android/remote/notification/deep_link/NotificationDeepLinkRouter;", "e", "Lcom/avito/android/remote/notification/deep_link/NotificationDeepLinkRouter;", "router", "Lcom/avito/android/notification_center/push/NcPushClicksListener;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/notification_center/push/NcPushClicksListener;", "ncPushClicksListener", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterMarker;", "c", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterMarker;", "notificationCenterCounterMarker", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/notification_center/push/NcPushClicksListener;Lcom/avito/android/notification_center/counter/NotificationCenterCounterMarker;Lcom/avito/android/remote/notification/NotificationInteractor;Lcom/avito/android/remote/notification/deep_link/NotificationDeepLinkRouter;)V", "notification-deeplink_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationDeepLinkPresenterImpl implements NotificationDeepLinkPresenter {
    public final Analytics a;
    public final NcPushClicksListener b;
    public final NotificationCenterCounterMarker c;
    public final NotificationInteractor d;
    public final NotificationDeepLinkRouter e;

    @Inject
    public NotificationDeepLinkPresenterImpl(@NotNull Analytics analytics, @NotNull NcPushClicksListener ncPushClicksListener, @NotNull NotificationCenterCounterMarker notificationCenterCounterMarker, @NotNull NotificationInteractor notificationInteractor, @NotNull NotificationDeepLinkRouter notificationDeepLinkRouter) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(ncPushClicksListener, "ncPushClicksListener");
        Intrinsics.checkNotNullParameter(notificationCenterCounterMarker, "notificationCenterCounterMarker");
        Intrinsics.checkNotNullParameter(notificationInteractor, "notificationInteractor");
        Intrinsics.checkNotNullParameter(notificationDeepLinkRouter, "router");
        this.a = analytics;
        this.b = ncPushClicksListener;
        this.c = notificationCenterCounterMarker;
        this.d = notificationInteractor;
        this.e = notificationDeepLinkRouter;
    }

    @Override // com.avito.android.remote.notification.deep_link.NotificationDeepLinkPresenter
    public void start(@Nullable DeepLink deepLink, @Nullable NotificationIdentifier notificationIdentifier, @Nullable Payload payload, @Nullable AnalyticParams analyticParams) {
        if (analyticParams != null) {
            if (analyticParams.getButtonName() == null && analyticParams.getAnalytics() != null) {
                this.a.track(new NotificationCenterOpenItemEvent(analyticParams.getAnalytics()));
            } else if (analyticParams.getButtonName() != null) {
                Analytics analytics = this.a;
                String buttonName = analyticParams.getButtonName();
                Map<String, String> analytics2 = analyticParams.getAnalytics();
                if (analytics2 == null) {
                    analytics2 = r.emptyMap();
                }
                analytics.track(new NotificationButtonClickEvent(buttonName, analytics2));
            }
        }
        if (deepLink == null || notificationIdentifier == null) {
            this.e.closeScreen();
            return;
        }
        CalledFrom.Push push = new CalledFrom.Push(deepLink.getPath(), payload);
        if (deepLink instanceof PromoLink) {
            this.e.openPromoScreen(((PromoLink) deepLink).getExtendedUrl(), push);
        } else {
            this.e.openDeepLink(deepLink, push);
        }
        this.d.cancelNotification(notificationIdentifier);
        if (payload instanceof Payload.NotificationCenter) {
            this.b.onClick();
            if (!(deepLink instanceof NotificationCenterMarker)) {
                this.c.markAsRead(((Payload.NotificationCenter) payload).getId());
            }
            Map<String, String> analyticParams2 = ((Payload.NotificationCenter) payload).getAnalyticParams();
            if (analyticParams2 != null) {
                this.a.track(new NotificationCenterPushClickEvent(analyticParams2));
                this.a.track(new NotificationCenterOpenItemEvent(analyticParams2));
            }
        }
        this.e.closeScreen();
    }
}
