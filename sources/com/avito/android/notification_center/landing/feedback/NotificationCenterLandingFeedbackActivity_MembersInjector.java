package com.avito.android.notification_center.landing.feedback;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.DialogRouter;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
import kotlin.Unit;
public final class NotificationCenterLandingFeedbackActivity_MembersInjector implements MembersInjector<NotificationCenterLandingFeedbackActivity> {
    public final Provider<NotificationCenterLandingFeedbackPresenter> a;
    public final Provider<DialogRouter> b;
    public final Provider<PublishRelay<Unit>> c;
    public final Provider<Analytics> d;

    public NotificationCenterLandingFeedbackActivity_MembersInjector(Provider<NotificationCenterLandingFeedbackPresenter> provider, Provider<DialogRouter> provider2, Provider<PublishRelay<Unit>> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<NotificationCenterLandingFeedbackActivity> create(Provider<NotificationCenterLandingFeedbackPresenter> provider, Provider<DialogRouter> provider2, Provider<PublishRelay<Unit>> provider3, Provider<Analytics> provider4) {
        return new NotificationCenterLandingFeedbackActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackActivity.analytics")
    public static void injectAnalytics(NotificationCenterLandingFeedbackActivity notificationCenterLandingFeedbackActivity, Analytics analytics) {
        notificationCenterLandingFeedbackActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackActivity.dialogRouter")
    public static void injectDialogRouter(NotificationCenterLandingFeedbackActivity notificationCenterLandingFeedbackActivity, DialogRouter dialogRouter) {
        notificationCenterLandingFeedbackActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackActivity.onCancelDialogRelay")
    public static void injectOnCancelDialogRelay(NotificationCenterLandingFeedbackActivity notificationCenterLandingFeedbackActivity, PublishRelay<Unit> publishRelay) {
        notificationCenterLandingFeedbackActivity.onCancelDialogRelay = publishRelay;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackActivity.presenter")
    public static void injectPresenter(NotificationCenterLandingFeedbackActivity notificationCenterLandingFeedbackActivity, NotificationCenterLandingFeedbackPresenter notificationCenterLandingFeedbackPresenter) {
        notificationCenterLandingFeedbackActivity.presenter = notificationCenterLandingFeedbackPresenter;
    }

    public void injectMembers(NotificationCenterLandingFeedbackActivity notificationCenterLandingFeedbackActivity) {
        injectPresenter(notificationCenterLandingFeedbackActivity, this.a.get());
        injectDialogRouter(notificationCenterLandingFeedbackActivity, this.b.get());
        injectOnCancelDialogRelay(notificationCenterLandingFeedbackActivity, this.c.get());
        injectAnalytics(notificationCenterLandingFeedbackActivity, this.d.get());
    }
}
