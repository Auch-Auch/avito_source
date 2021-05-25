package com.avito.android.messenger.di;

import androidx.core.app.NotificationManagerCompat;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.messenger.di.DirectReplyServiceComponent;
import com.avito.android.messenger.service.direct_reply.DirectReplyIntentService;
import com.avito.android.messenger.service.direct_reply.DirectReplyIntentService_MembersInjector;
import com.avito.android.messenger.service.direct_reply.DirectReplyServiceDelegate;
import com.avito.android.messenger.service.direct_reply.DirectReplyServiceDelegateImpl;
import com.avito.android.messenger.service.direct_reply.DirectReplyServiceDelegateImpl_Factory;
import com.avito.android.messenger.service.direct_reply.DirectReplyServiceInteractor;
import com.avito.android.messenger.service.direct_reply.DirectReplyServiceInteractorImpl;
import com.avito.android.messenger.service.direct_reply.DirectReplyServiceInteractorImpl_Factory;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerDirectReplyServiceComponent implements DirectReplyServiceComponent {
    public final DirectReplyServiceDependencies a;
    public Provider<MessengerClient<AvitoMessengerApi>> b;
    public Provider<TimeSource> c;
    public Provider<SchedulersFactory> d;
    public Provider<Analytics> e;
    public Provider<NetworkTypeProvider> f;
    public Provider<DirectReplyServiceInteractorImpl> g;
    public Provider<DirectReplyServiceInteractor> h;
    public Provider<RandomKeyProvider> i;
    public Provider<DirectReplyServiceDelegateImpl> j;
    public Provider<DirectReplyServiceDelegate> k;

    public static final class b implements DirectReplyServiceComponent.Builder {
        public DirectReplyServiceDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.di.DirectReplyServiceComponent.Builder
        public DirectReplyServiceComponent build() {
            Preconditions.checkBuilderRequirement(this.a, DirectReplyServiceDependencies.class);
            return new DaggerDirectReplyServiceComponent(this.a, null);
        }

        @Override // com.avito.android.messenger.di.DirectReplyServiceComponent.Builder
        public DirectReplyServiceComponent.Builder directReplyServiceDependencies(DirectReplyServiceDependencies directReplyServiceDependencies) {
            this.a = (DirectReplyServiceDependencies) Preconditions.checkNotNull(directReplyServiceDependencies);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final DirectReplyServiceDependencies a;

        public c(DirectReplyServiceDependencies directReplyServiceDependencies) {
            this.a = directReplyServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<MessengerClient<AvitoMessengerApi>> {
        public final DirectReplyServiceDependencies a;

        public d(DirectReplyServiceDependencies directReplyServiceDependencies) {
            this.a = directReplyServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerClient<AvitoMessengerApi> get() {
            return (MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient());
        }
    }

    public static class e implements Provider<NetworkTypeProvider> {
        public final DirectReplyServiceDependencies a;

        public e(DirectReplyServiceDependencies directReplyServiceDependencies) {
            this.a = directReplyServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NetworkTypeProvider get() {
            return (NetworkTypeProvider) Preconditions.checkNotNullFromComponent(this.a.networkTypeProvider());
        }
    }

    public static class f implements Provider<RandomKeyProvider> {
        public final DirectReplyServiceDependencies a;

        public f(DirectReplyServiceDependencies directReplyServiceDependencies) {
            this.a = directReplyServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final DirectReplyServiceDependencies a;

        public g(DirectReplyServiceDependencies directReplyServiceDependencies) {
            this.a = directReplyServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class h implements Provider<TimeSource> {
        public final DirectReplyServiceDependencies a;

        public h(DirectReplyServiceDependencies directReplyServiceDependencies) {
            this.a = directReplyServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public DaggerDirectReplyServiceComponent(DirectReplyServiceDependencies directReplyServiceDependencies, a aVar) {
        this.a = directReplyServiceDependencies;
        d dVar = new d(directReplyServiceDependencies);
        this.b = dVar;
        h hVar = new h(directReplyServiceDependencies);
        this.c = hVar;
        g gVar = new g(directReplyServiceDependencies);
        this.d = gVar;
        c cVar = new c(directReplyServiceDependencies);
        this.e = cVar;
        e eVar = new e(directReplyServiceDependencies);
        this.f = eVar;
        DirectReplyServiceInteractorImpl_Factory create = DirectReplyServiceInteractorImpl_Factory.create(dVar, hVar, gVar, cVar, eVar);
        this.g = create;
        Provider<DirectReplyServiceInteractor> provider = DoubleCheck.provider(create);
        this.h = provider;
        f fVar = new f(directReplyServiceDependencies);
        this.i = fVar;
        DirectReplyServiceDelegateImpl_Factory create2 = DirectReplyServiceDelegateImpl_Factory.create(provider, this.d, fVar);
        this.j = create2;
        this.k = DoubleCheck.provider(create2);
    }

    public static DirectReplyServiceComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.di.DirectReplyServiceComponent
    public void inject(DirectReplyIntentService directReplyIntentService) {
        DirectReplyIntentService_MembersInjector.injectDelegate(directReplyIntentService, this.k.get());
        DirectReplyIntentService_MembersInjector.injectNotificationManagerCompat(directReplyIntentService, (NotificationManagerCompat) Preconditions.checkNotNullFromComponent(this.a.notificationManagerCompat()));
        DirectReplyIntentService_MembersInjector.injectServiceIntentFactory(directReplyIntentService, (ServiceIntentFactory) Preconditions.checkNotNullFromComponent(this.a.serviceIntentFactory()));
    }
}
