package com.avito.android.push;

import android.app.Application;
import com.avito.android.NotificationWorkFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.push.MessagingComponent;
import com.avito.android.push.debug.DebugMessagingReceiver;
import com.avito.android.push.debug.DebugMessagingReceiver_MembersInjector;
import com.avito.android.remote.notification.NotificationSystemSettingsLogger;
import com.avito.android.service.SafeServiceStarter;
import com.avito.android.util.preferences.Preferences;
import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerMessagingComponent implements MessagingComponent {
    public final MessagingDependencies a;
    public Provider<Analytics> b;
    public Provider<DeepLinkFactory> c;
    public Provider<Gson> d;
    public Provider<Application> e;
    public Provider<MessagingResourceProvider> f;
    public Provider<NotificationManagerProvider> g;
    public Provider<MessagingInteractor> h;
    public Provider<TokenStorage> i;
    public Provider<Preferences> j;
    public Provider<NotificationSystemSettingsLogger> k;

    public static final class b implements MessagingComponent.Builder {
        public b(a aVar) {
        }

        @Override // com.avito.android.push.MessagingComponent.Builder
        public MessagingComponent create(MessagingDependencies messagingDependencies) {
            Preconditions.checkNotNull(messagingDependencies);
            return new DaggerMessagingComponent(messagingDependencies, null);
        }
    }

    public static class c implements Provider<Analytics> {
        public final MessagingDependencies a;

        public c(MessagingDependencies messagingDependencies) {
            this.a = messagingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Application> {
        public final MessagingDependencies a;

        public d(MessagingDependencies messagingDependencies) {
            this.a = messagingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class e implements Provider<DeepLinkFactory> {
        public final MessagingDependencies a;

        public e(MessagingDependencies messagingDependencies) {
            this.a = messagingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class f implements Provider<Gson> {
        public final MessagingDependencies a;

        public f(MessagingDependencies messagingDependencies) {
            this.a = messagingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Gson get() {
            return (Gson) Preconditions.checkNotNullFromComponent(this.a.gson());
        }
    }

    public static class g implements Provider<TokenStorage> {
        public final MessagingDependencies a;

        public g(MessagingDependencies messagingDependencies) {
            this.a = messagingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TokenStorage get() {
            return (TokenStorage) Preconditions.checkNotNullFromComponent(this.a.instanceIdStorage());
        }
    }

    public static class h implements Provider<NotificationManagerProvider> {
        public final MessagingDependencies a;

        public h(MessagingDependencies messagingDependencies) {
            this.a = messagingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationManagerProvider get() {
            return (NotificationManagerProvider) Preconditions.checkNotNullFromComponent(this.a.notificationManagerProvider());
        }
    }

    public static class i implements Provider<Preferences> {
        public final MessagingDependencies a;

        public i(MessagingDependencies messagingDependencies) {
            this.a = messagingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public DaggerMessagingComponent(MessagingDependencies messagingDependencies, a aVar) {
        this.a = messagingDependencies;
        this.b = new c(messagingDependencies);
        this.c = new e(messagingDependencies);
        this.d = new f(messagingDependencies);
        d dVar = new d(messagingDependencies);
        this.e = dVar;
        Provider<MessagingResourceProvider> provider = DoubleCheck.provider(MessagingModule_ProvideMessagingResourceProviderFactory.create(dVar));
        this.f = provider;
        h hVar = new h(messagingDependencies);
        this.g = hVar;
        this.h = DoubleCheck.provider(MessagingModule_ProvideMessagingInteractorFactory.create(this.b, this.c, this.d, provider, hVar));
        g gVar = new g(messagingDependencies);
        this.i = gVar;
        i iVar = new i(messagingDependencies);
        this.j = iVar;
        this.k = DoubleCheck.provider(MessagingModule_ProvideNotificationSystemSettingsLoggerFactory.create(this.b, gVar, this.g, iVar));
    }

    public static MessagingComponent.Builder factory() {
        return new b(null);
    }

    public final MessagingServiceDelegate a() {
        return new MessagingServiceDelegate(this.h.get(), this.k.get(), (SafeServiceStarter) Preconditions.checkNotNullFromComponent(this.a.safeServiceStarter()), (NotificationWorkFactory) Preconditions.checkNotNullFromComponent(this.a.notificationWorkFactory()), (CallPushHandler) Preconditions.checkNotNullFromComponent(this.a.callPushHandler()));
    }

    @Override // com.avito.android.push.MessagingComponent
    public void inject(MessagingService messagingService) {
        MessagingService_MembersInjector.injectDelegate(messagingService, a());
    }

    @Override // com.avito.android.push.MessagingComponent
    public void inject(DebugMessagingReceiver debugMessagingReceiver) {
        DebugMessagingReceiver_MembersInjector.injectDelegate(debugMessagingReceiver, a());
    }
}
