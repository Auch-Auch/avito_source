package com.avito.android.notification_center.landing.main.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.notification_center.landing.main.NotificationCenterLandingMainActivity;
import com.avito.android.notification_center.landing.main.NotificationCenterLandingMainActivity_MembersInjector;
import com.avito.android.notification_center.landing.main.NotificationCenterLandingMainInteractor;
import com.avito.android.notification_center.landing.main.NotificationCenterLandingMainInteractorImpl;
import com.avito.android.notification_center.landing.main.NotificationCenterLandingMainInteractorImpl_Factory;
import com.avito.android.notification_center.landing.main.NotificationCenterLandingMainPresenter;
import com.avito.android.notification_center.landing.main.NotificationCenterLandingMainPresenterImpl;
import com.avito.android.notification_center.landing.main.NotificationCenterLandingMainPresenterImpl_Factory;
import com.avito.android.notification_center.landing.main.di.NotificationCenterLandingMainComponent;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerNotificationCenterLandingMainComponent implements NotificationCenterLandingMainComponent {
    public final NotificationCenterLandingMainDependencies a;
    public Provider<String> b;
    public Provider<NotificationsApi> c;
    public Provider<SchedulersFactory> d;
    public Provider<NotificationCenterLandingMainInteractorImpl> e;
    public Provider<NotificationCenterLandingMainInteractor> f;
    public Provider<Analytics> g;
    public Provider<Kundle> h;
    public Provider<NotificationCenterLandingMainPresenterImpl> i;
    public Provider<NotificationCenterLandingMainPresenter> j;

    public static final class b implements NotificationCenterLandingMainComponent.Builder {
        public NotificationCenterLandingMainDependencies a;
        public String b;
        public Kundle c;

        public b(a aVar) {
        }

        @Override // com.avito.android.notification_center.landing.main.di.NotificationCenterLandingMainComponent.Builder
        public NotificationCenterLandingMainComponent build() {
            Preconditions.checkBuilderRequirement(this.a, NotificationCenterLandingMainDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            return new DaggerNotificationCenterLandingMainComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.notification_center.landing.main.di.NotificationCenterLandingMainComponent.Builder
        public NotificationCenterLandingMainComponent.Builder dependencies(NotificationCenterLandingMainDependencies notificationCenterLandingMainDependencies) {
            this.a = (NotificationCenterLandingMainDependencies) Preconditions.checkNotNull(notificationCenterLandingMainDependencies);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.main.di.NotificationCenterLandingMainComponent.Builder
        public NotificationCenterLandingMainComponent.Builder withId(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.notification_center.landing.main.di.NotificationCenterLandingMainComponent.Builder
        public NotificationCenterLandingMainComponent.Builder withPresenterState(Kundle kundle) {
            this.c = kundle;
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final NotificationCenterLandingMainDependencies a;

        public c(NotificationCenterLandingMainDependencies notificationCenterLandingMainDependencies) {
            this.a = notificationCenterLandingMainDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<NotificationsApi> {
        public final NotificationCenterLandingMainDependencies a;

        public d(NotificationCenterLandingMainDependencies notificationCenterLandingMainDependencies) {
            this.a = notificationCenterLandingMainDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationsApi get() {
            return (NotificationsApi) Preconditions.checkNotNullFromComponent(this.a.notificationsApi());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final NotificationCenterLandingMainDependencies a;

        public e(NotificationCenterLandingMainDependencies notificationCenterLandingMainDependencies) {
            this.a = notificationCenterLandingMainDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerNotificationCenterLandingMainComponent(NotificationCenterLandingMainDependencies notificationCenterLandingMainDependencies, String str, Kundle kundle, a aVar) {
        this.a = notificationCenterLandingMainDependencies;
        this.b = InstanceFactory.create(str);
        d dVar = new d(notificationCenterLandingMainDependencies);
        this.c = dVar;
        e eVar = new e(notificationCenterLandingMainDependencies);
        this.d = eVar;
        NotificationCenterLandingMainInteractorImpl_Factory create = NotificationCenterLandingMainInteractorImpl_Factory.create(dVar, eVar);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        this.g = new c(notificationCenterLandingMainDependencies);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.h = createNullable;
        NotificationCenterLandingMainPresenterImpl_Factory create2 = NotificationCenterLandingMainPresenterImpl_Factory.create(this.b, this.f, this.d, this.g, createNullable);
        this.i = create2;
        this.j = DoubleCheck.provider(create2);
    }

    public static NotificationCenterLandingMainComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.notification_center.landing.main.di.NotificationCenterLandingMainComponent
    public void inject(NotificationCenterLandingMainActivity notificationCenterLandingMainActivity) {
        NotificationCenterLandingMainActivity_MembersInjector.injectDeepLinkIntentFactory(notificationCenterLandingMainActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        NotificationCenterLandingMainActivity_MembersInjector.injectPresenter(notificationCenterLandingMainActivity, this.j.get());
        NotificationCenterLandingMainActivity_MembersInjector.injectAnalytics(notificationCenterLandingMainActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
