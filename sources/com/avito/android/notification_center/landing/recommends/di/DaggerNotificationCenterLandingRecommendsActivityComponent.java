package com.avito.android.notification_center.landing.recommends.di;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsActivity;
import com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsActivity_MembersInjector;
import com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsActivityComponent;
import dagger.internal.Preconditions;
public final class DaggerNotificationCenterLandingRecommendsActivityComponent implements NotificationCenterLandingRecommendsActivityComponent {
    public final NotificationCenterLandingRecommendsDependencies a;

    public static final class b implements NotificationCenterLandingRecommendsActivityComponent.Builder {
        public NotificationCenterLandingRecommendsDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsActivityComponent.Builder
        public NotificationCenterLandingRecommendsActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, NotificationCenterLandingRecommendsDependencies.class);
            return new DaggerNotificationCenterLandingRecommendsActivityComponent(this.a, null);
        }

        @Override // com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsActivityComponent.Builder
        public NotificationCenterLandingRecommendsActivityComponent.Builder dependencies(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies) {
            this.a = (NotificationCenterLandingRecommendsDependencies) Preconditions.checkNotNull(notificationCenterLandingRecommendsDependencies);
            return this;
        }
    }

    public DaggerNotificationCenterLandingRecommendsActivityComponent(NotificationCenterLandingRecommendsDependencies notificationCenterLandingRecommendsDependencies, a aVar) {
        this.a = notificationCenterLandingRecommendsDependencies;
    }

    public static NotificationCenterLandingRecommendsActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsActivityComponent
    public void inject(NotificationCenterLandingRecommendsActivity notificationCenterLandingRecommendsActivity) {
        NotificationCenterLandingRecommendsActivity_MembersInjector.injectDeepLinkIntentFactory(notificationCenterLandingRecommendsActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
    }
}
