package com.avito.android.push;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessagingModule_ProvideMessagingInteractorFactory implements Factory<MessagingInteractor> {
    public final Provider<Analytics> a;
    public final Provider<DeepLinkFactory> b;
    public final Provider<Gson> c;
    public final Provider<MessagingResourceProvider> d;
    public final Provider<NotificationManagerProvider> e;

    public MessagingModule_ProvideMessagingInteractorFactory(Provider<Analytics> provider, Provider<DeepLinkFactory> provider2, Provider<Gson> provider3, Provider<MessagingResourceProvider> provider4, Provider<NotificationManagerProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MessagingModule_ProvideMessagingInteractorFactory create(Provider<Analytics> provider, Provider<DeepLinkFactory> provider2, Provider<Gson> provider3, Provider<MessagingResourceProvider> provider4, Provider<NotificationManagerProvider> provider5) {
        return new MessagingModule_ProvideMessagingInteractorFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static MessagingInteractor provideMessagingInteractor(Analytics analytics, DeepLinkFactory deepLinkFactory, Gson gson, MessagingResourceProvider messagingResourceProvider, NotificationManagerProvider notificationManagerProvider) {
        return (MessagingInteractor) Preconditions.checkNotNullFromProvides(MessagingModule.provideMessagingInteractor(analytics, deepLinkFactory, gson, messagingResourceProvider, notificationManagerProvider));
    }

    @Override // javax.inject.Provider
    public MessagingInteractor get() {
        return provideMessagingInteractor(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
