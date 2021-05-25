package com.avito.android.notification_center.landing.share;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.PerActivity;
import com.avito.android.notification_center.landing.share.NotificationCenterLandingShareInteractor;
import com.avito.android.notification_center.landing.share.NotificationCenterLandingSharePresenter;
import com.avito.android.notification_center.landing.share.ShareImageInteractor;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareModule;", "", "Lcom/avito/android/remote/NotificationsApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareInteractor;", "provideInteractor", "(Lcom/avito/android/remote/NotificationsApi;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareInteractor;", "Lcom/avito/android/analytics/Analytics;", "analytics", "interactor", "Lcom/avito/android/notification_center/landing/share/ShareImageInteractor;", "shareImageInteractor", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingSharePresenter;", "providePresenter", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/notification_center/landing/share/ShareImageInteractor;)Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingSharePresenter;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "provideShareImageInteractor", "(Landroid/app/Application;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/notification_center/landing/share/ShareImageInteractor;", "Lcom/avito/android/util/Kundle;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/Kundle;", "kundle", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "id", "<init>", "(Ljava/lang/String;Lcom/avito/android/util/Kundle;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class NotificationCenterLandingShareModule {
    public final String a;
    public final Kundle b;

    public NotificationCenterLandingShareModule(@NotNull String str, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.a = str;
        this.b = kundle;
    }

    @Provides
    @PerActivity
    @NotNull
    public final NotificationCenterLandingShareInteractor provideInteractor(@NotNull NotificationsApi notificationsApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(notificationsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new NotificationCenterLandingShareInteractor.Impl(notificationsApi, schedulersFactory);
    }

    @Provides
    @PerActivity
    @NotNull
    public final NotificationCenterLandingSharePresenter providePresenter(@NotNull Analytics analytics, @NotNull NotificationCenterLandingShareInteractor notificationCenterLandingShareInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ShareImageInteractor shareImageInteractor) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(notificationCenterLandingShareInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(shareImageInteractor, "shareImageInteractor");
        return new NotificationCenterLandingSharePresenter.Impl(analytics, notificationCenterLandingShareInteractor, schedulersFactory, shareImageInteractor, this.a, this.b);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ShareImageInteractor provideShareImageInteractor(@NotNull Application application, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new ShareImageInteractor.Impl(application, schedulersFactory);
    }
}
