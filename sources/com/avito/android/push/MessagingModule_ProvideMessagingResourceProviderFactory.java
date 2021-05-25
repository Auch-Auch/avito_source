package com.avito.android.push;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessagingModule_ProvideMessagingResourceProviderFactory implements Factory<MessagingResourceProvider> {
    public final Provider<Application> a;

    public MessagingModule_ProvideMessagingResourceProviderFactory(Provider<Application> provider) {
        this.a = provider;
    }

    public static MessagingModule_ProvideMessagingResourceProviderFactory create(Provider<Application> provider) {
        return new MessagingModule_ProvideMessagingResourceProviderFactory(provider);
    }

    public static MessagingResourceProvider provideMessagingResourceProvider(Application application) {
        return (MessagingResourceProvider) Preconditions.checkNotNullFromProvides(MessagingModule.provideMessagingResourceProvider(application));
    }

    @Override // javax.inject.Provider
    public MessagingResourceProvider get() {
        return provideMessagingResourceProvider(this.a.get());
    }
}
