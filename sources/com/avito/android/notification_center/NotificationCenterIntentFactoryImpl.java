package com.avito.android.notification_center;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import com.avito.android.CalledFrom;
import com.avito.android.NotificationCenterIntentFactory;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackActivityKt;
import com.avito.android.notification_center.landing.main.NotificationCenterLandingMainActivityKt;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsActivityKt;
import com.avito.android.notification_center.landing.share.NotificationCenterLandingShareActivityKt;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedActivityKt;
import com.avito.android.notification_center.list.NotificationCenterListActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.webview.WebViewActivityKt;
import com.facebook.share.internal.ShareConstants;
import com.yandex.mobile.ads.video.tracking.Tracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\bJ'\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0012\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/notification_center/NotificationCenterIntentFactoryImpl;", "Lcom/avito/android/NotificationCenterIntentFactory;", "Landroid/content/Intent;", "notificationCenterIntent", "()Landroid/content/Intent;", "", "id", "notificationCenterLandingUnifiedIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "notificationCenterLandingMainIntent", "notificationCenterLandingRecommendsIntent", "notificationCenterLandingFeedbackIntent", "notificationCenterLandingShareIntent", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", Tracker.Events.CREATIVE_FULLSCREEN, "withAuthorization", "promoIntent", "(Landroid/net/Uri;ZZ)Landroid/content/Intent;", "Lcom/avito/android/CalledFrom;", "calledFrom", "(Landroid/net/Uri;Lcom/avito/android/CalledFrom;)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterIntentFactoryImpl implements NotificationCenterIntentFactory {
    public final Application a;

    @Inject
    public NotificationCenterIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.NotificationCenterIntentFactory
    @NotNull
    public Intent notificationCenterIntent() {
        return NotificationCenterListActivityKt.createNotificationCenterListActivityIntent(this.a);
    }

    @Override // com.avito.android.NotificationCenterIntentFactory
    @NotNull
    public Intent notificationCenterLandingFeedbackIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return NotificationCenterLandingFeedbackActivityKt.createNotificationCenterLandingFeedbackIntent(this.a, str);
    }

    @Override // com.avito.android.NotificationCenterIntentFactory
    @NotNull
    public Intent notificationCenterLandingMainIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return NotificationCenterLandingMainActivityKt.createNotificationCenterLandingMainIntent(this.a, str);
    }

    @Override // com.avito.android.NotificationCenterIntentFactory
    @NotNull
    public Intent notificationCenterLandingRecommendsIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return NotificationCenterLandingRecommendsActivityKt.createNotificationCenterLandingRecommendsIntent(this.a, str);
    }

    @Override // com.avito.android.NotificationCenterIntentFactory
    @NotNull
    public Intent notificationCenterLandingShareIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return NotificationCenterLandingShareActivityKt.createNotificationCenterLandingShareIntent(this.a, str);
    }

    @Override // com.avito.android.NotificationCenterIntentFactory
    @NotNull
    public Intent notificationCenterLandingUnifiedIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return NotificationCenterLandingUnifiedActivityKt.createNotificationCenterLandingUnifiedIntent(this.a, str);
    }

    @Override // com.avito.android.NotificationCenterIntentFactory
    @NotNull
    public Intent promoIntent(@NotNull Uri uri, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return WebViewActivityKt.createWebViewActivityIntent(this.a, uri, z, z2);
    }

    @Override // com.avito.android.NotificationCenterIntentFactory
    @NotNull
    public Intent promoIntent(@NotNull Uri uri, @NotNull CalledFrom calledFrom) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(calledFrom, "calledFrom");
        return WebViewActivityKt.createWebViewActivityIntent(this.a, uri, calledFrom);
    }
}
