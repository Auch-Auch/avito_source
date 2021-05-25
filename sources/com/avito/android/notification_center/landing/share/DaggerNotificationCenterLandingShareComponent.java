package com.avito.android.notification_center.landing.share;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.notification_center.landing.share.NotificationCenterLandingShareComponent;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerNotificationCenterLandingShareComponent implements NotificationCenterLandingShareComponent {
    public final NotificationCenterLandingShareDependencies a;
    public Provider<Analytics> b;
    public Provider<NotificationsApi> c;
    public Provider<SchedulersFactory> d;
    public Provider<NotificationCenterLandingShareInteractor> e;
    public Provider<Application> f;
    public Provider<ShareImageInteractor> g;
    public Provider<NotificationCenterLandingSharePresenter> h;

    public static final class b implements NotificationCenterLandingShareComponent.Builder {
        public NotificationCenterLandingShareDependencies a;
        public NotificationCenterLandingShareModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareComponent.Builder
        public NotificationCenterLandingShareComponent build() {
            Preconditions.checkBuilderRequirement(this.a, NotificationCenterLandingShareDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, NotificationCenterLandingShareModule.class);
            return new DaggerNotificationCenterLandingShareComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareComponent.Builder
        public NotificationCenterLandingShareComponent.Builder dependencies(NotificationCenterLandingShareDependencies notificationCenterLandingShareDependencies) {
            this.a = (NotificationCenterLandingShareDependencies) Preconditions.checkNotNull(notificationCenterLandingShareDependencies);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareComponent.Builder
        public NotificationCenterLandingShareComponent.Builder module(NotificationCenterLandingShareModule notificationCenterLandingShareModule) {
            this.b = (NotificationCenterLandingShareModule) Preconditions.checkNotNull(notificationCenterLandingShareModule);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final NotificationCenterLandingShareDependencies a;

        public c(NotificationCenterLandingShareDependencies notificationCenterLandingShareDependencies) {
            this.a = notificationCenterLandingShareDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Application> {
        public final NotificationCenterLandingShareDependencies a;

        public d(NotificationCenterLandingShareDependencies notificationCenterLandingShareDependencies) {
            this.a = notificationCenterLandingShareDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class e implements Provider<NotificationsApi> {
        public final NotificationCenterLandingShareDependencies a;

        public e(NotificationCenterLandingShareDependencies notificationCenterLandingShareDependencies) {
            this.a = notificationCenterLandingShareDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationsApi get() {
            return (NotificationsApi) Preconditions.checkNotNullFromComponent(this.a.notificationsApi());
        }
    }

    public static class f implements Provider<SchedulersFactory> {
        public final NotificationCenterLandingShareDependencies a;

        public f(NotificationCenterLandingShareDependencies notificationCenterLandingShareDependencies) {
            this.a = notificationCenterLandingShareDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerNotificationCenterLandingShareComponent(NotificationCenterLandingShareModule notificationCenterLandingShareModule, NotificationCenterLandingShareDependencies notificationCenterLandingShareDependencies, a aVar) {
        this.a = notificationCenterLandingShareDependencies;
        this.b = new c(notificationCenterLandingShareDependencies);
        e eVar = new e(notificationCenterLandingShareDependencies);
        this.c = eVar;
        f fVar = new f(notificationCenterLandingShareDependencies);
        this.d = fVar;
        this.e = DoubleCheck.provider(NotificationCenterLandingShareModule_ProvideInteractorFactory.create(notificationCenterLandingShareModule, eVar, fVar));
        d dVar = new d(notificationCenterLandingShareDependencies);
        this.f = dVar;
        Provider<ShareImageInteractor> provider = DoubleCheck.provider(NotificationCenterLandingShareModule_ProvideShareImageInteractorFactory.create(notificationCenterLandingShareModule, dVar, this.d));
        this.g = provider;
        this.h = DoubleCheck.provider(NotificationCenterLandingShareModule_ProvidePresenterFactory.create(notificationCenterLandingShareModule, this.b, this.e, this.d, provider));
    }

    public static NotificationCenterLandingShareComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareComponent
    public void inject(NotificationCenterLandingShareActivity notificationCenterLandingShareActivity) {
        NotificationCenterLandingShareActivity_MembersInjector.injectAnalytics(notificationCenterLandingShareActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        NotificationCenterLandingShareActivity_MembersInjector.injectImplicitIntentFactory(notificationCenterLandingShareActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        NotificationCenterLandingShareActivity_MembersInjector.injectLocale(notificationCenterLandingShareActivity, (Locale) Preconditions.checkNotNullFromComponent(this.a.locale()));
        NotificationCenterLandingShareActivity_MembersInjector.injectPresenter(notificationCenterLandingShareActivity, this.h.get());
        NotificationCenterLandingShareActivity_MembersInjector.injectTimeSource(notificationCenterLandingShareActivity, (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource()));
        NotificationCenterLandingShareActivity_MembersInjector.injectConnectivityProvider(notificationCenterLandingShareActivity, (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider()));
    }
}
