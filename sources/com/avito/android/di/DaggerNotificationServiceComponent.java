package com.avito.android.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.NotificationServiceComponent;
import com.avito.android.remote.notification.NotificationInteractor;
import com.avito.android.remote.notification.NotificationService;
import com.avito.android.remote.notification.NotificationServiceInteractor;
import com.avito.android.remote.notification.NotificationServiceInteractorImpl;
import com.avito.android.remote.notification.NotificationServiceInteractorImpl_Factory;
import com.avito.android.remote.notification.NotificationService_MembersInjector;
import com.avito.android.service.SafeServiceStarter;
import com.avito.android.service.ServiceCountdownHandler;
import com.avito.android.service.ServiceCountdownHandlerImpl;
import com.avito.android.service.ServiceCountdownHandlerImpl_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerNotificationServiceComponent implements NotificationServiceComponent {
    public final NotificationServiceDependencies a;
    public Provider<NotificationInteractor> b;
    public Provider<Analytics> c;
    public Provider<DeepLinkIntentFactory> d;
    public Provider<NotificationServiceInteractorImpl> e;
    public Provider<NotificationServiceInteractor> f;
    public Provider<String> g;
    public Provider<ServiceCountdownHandler.Listener> h;
    public Provider<ServiceCountdownHandlerImpl> i;
    public Provider<ServiceCountdownHandler> j;

    public static final class b implements NotificationServiceComponent.Builder {
        public NotificationServiceDependencies a;
        public String b;
        public ServiceCountdownHandler.Listener c;

        public b(a aVar) {
        }

        @Override // com.avito.android.di.NotificationServiceComponent.Builder
        public NotificationServiceComponent build() {
            Preconditions.checkBuilderRequirement(this.a, NotificationServiceDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            return new DaggerNotificationServiceComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.di.NotificationServiceComponent.Builder
        public NotificationServiceComponent.Builder dependencies(NotificationServiceDependencies notificationServiceDependencies) {
            this.a = (NotificationServiceDependencies) Preconditions.checkNotNull(notificationServiceDependencies);
            return this;
        }

        @Override // com.avito.android.di.NotificationServiceComponent.Builder
        public NotificationServiceComponent.Builder withCountdownHandlerListener(ServiceCountdownHandler.Listener listener) {
            this.c = null;
            return this;
        }

        @Override // com.avito.android.di.NotificationServiceComponent.Builder
        public NotificationServiceComponent.Builder withName(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final NotificationServiceDependencies a;

        public c(NotificationServiceDependencies notificationServiceDependencies) {
            this.a = notificationServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<DeepLinkIntentFactory> {
        public final NotificationServiceDependencies a;

        public d(NotificationServiceDependencies notificationServiceDependencies) {
            this.a = notificationServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkIntentFactory get() {
            return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory());
        }
    }

    public static class e implements Provider<NotificationInteractor> {
        public final NotificationServiceDependencies a;

        public e(NotificationServiceDependencies notificationServiceDependencies) {
            this.a = notificationServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationInteractor get() {
            return (NotificationInteractor) Preconditions.checkNotNullFromComponent(this.a.notificationInteractor());
        }
    }

    public DaggerNotificationServiceComponent(NotificationServiceDependencies notificationServiceDependencies, String str, ServiceCountdownHandler.Listener listener, a aVar) {
        this.a = notificationServiceDependencies;
        e eVar = new e(notificationServiceDependencies);
        this.b = eVar;
        c cVar = new c(notificationServiceDependencies);
        this.c = cVar;
        d dVar = new d(notificationServiceDependencies);
        this.d = dVar;
        NotificationServiceInteractorImpl_Factory create = NotificationServiceInteractorImpl_Factory.create(eVar, cVar, dVar);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        this.g = InstanceFactory.create(str);
        Factory createNullable = InstanceFactory.createNullable(listener);
        this.h = createNullable;
        ServiceCountdownHandlerImpl_Factory create2 = ServiceCountdownHandlerImpl_Factory.create(this.g, createNullable);
        this.i = create2;
        this.j = DoubleCheck.provider(create2);
    }

    public static NotificationServiceComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.di.NotificationServiceComponent
    public void inject(NotificationService notificationService) {
        NotificationService_MembersInjector.injectInteractor(notificationService, this.f.get());
        NotificationService_MembersInjector.injectCountdownHandler(notificationService, this.j.get());
        NotificationService_MembersInjector.injectSafeStarter(notificationService, (SafeServiceStarter) Preconditions.checkNotNullFromComponent(this.a.safeServiceStarter()));
    }
}
