package com.avito.android.remote.notification;

import a2.b.a.a.a;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ExceptionEvent;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.notification.NotificationProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/notification/NotificationServiceInteractorImpl;", "Lcom/avito/android/remote/notification/NotificationServiceInteractor;", "Lcom/avito/android/remote/notification/NotificationProvider$Handler;", "handler", "", "setHandler", "(Lcom/avito/android/remote/notification/NotificationProvider$Handler;)V", "Lcom/avito/android/remote/notification/NotificationParameters;", "notification", "handleNotification", "(Lcom/avito/android/remote/notification/NotificationParameters;)V", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "d", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "intentFactory", "Lcom/avito/android/remote/notification/NotificationInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/notification/NotificationInteractor;", "notificationInteractor", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/notification/NotificationProvider$Handler;", "<init>", "(Lcom/avito/android/remote/notification/NotificationInteractor;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "notification_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationServiceInteractorImpl implements NotificationServiceInteractor {
    public NotificationProvider.Handler a;
    public final NotificationInteractor b;
    public final Analytics c;
    public final DeepLinkIntentFactory d;

    @Inject
    public NotificationServiceInteractorImpl(@NotNull NotificationInteractor notificationInteractor, @NotNull Analytics analytics, @NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(notificationInteractor, "notificationInteractor");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "intentFactory");
        this.b = notificationInteractor;
        this.c = analytics;
        this.d = deepLinkIntentFactory;
    }

    @Override // com.avito.android.remote.notification.NotificationServiceInteractor
    public void handleNotification(@NotNull NotificationParameters notificationParameters) {
        Intrinsics.checkNotNullParameter(notificationParameters, "notification");
        DeepLink link = notificationParameters.getLink();
        if (this.d.getIntent(link) == null) {
            Analytics analytics = this.c;
            StringBuilder L = a.L("Unsupported link in notification: ");
            L.append(link.getPath());
            analytics.track(new ExceptionEvent(new Exception(L.toString()), null, 2, null));
            return;
        }
        NotificationProvider.Handler handler = this.a;
        if (!(handler != null ? handler.handleMessage(link) : false)) {
            this.b.showNotification(notificationParameters);
        }
    }

    @Override // com.avito.android.remote.notification.NotificationProvider
    public void setHandler(@Nullable NotificationProvider.Handler handler) {
        this.a = handler;
    }
}
