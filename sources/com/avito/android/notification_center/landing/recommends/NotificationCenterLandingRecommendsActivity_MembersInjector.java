package com.avito.android.notification_center.landing.recommends;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class NotificationCenterLandingRecommendsActivity_MembersInjector implements MembersInjector<NotificationCenterLandingRecommendsActivity> {
    public final Provider<DeepLinkIntentFactory> a;

    public NotificationCenterLandingRecommendsActivity_MembersInjector(Provider<DeepLinkIntentFactory> provider) {
        this.a = provider;
    }

    public static MembersInjector<NotificationCenterLandingRecommendsActivity> create(Provider<DeepLinkIntentFactory> provider) {
        return new NotificationCenterLandingRecommendsActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(NotificationCenterLandingRecommendsActivity notificationCenterLandingRecommendsActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        notificationCenterLandingRecommendsActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    public void injectMembers(NotificationCenterLandingRecommendsActivity notificationCenterLandingRecommendsActivity) {
        injectDeepLinkIntentFactory(notificationCenterLandingRecommendsActivity, this.a.get());
    }
}
