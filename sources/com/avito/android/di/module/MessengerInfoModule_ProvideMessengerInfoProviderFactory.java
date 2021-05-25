package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.messenger.service.MessengerInfoProvider;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessengerInfoModule_ProvideMessengerInfoProviderFactory implements Factory<MessengerInfoProvider> {
    public final MessengerInfoModule a;
    public final Provider<Features> b;
    public final Provider<BuildInfo> c;

    public MessengerInfoModule_ProvideMessengerInfoProviderFactory(MessengerInfoModule messengerInfoModule, Provider<Features> provider, Provider<BuildInfo> provider2) {
        this.a = messengerInfoModule;
        this.b = provider;
        this.c = provider2;
    }

    public static MessengerInfoModule_ProvideMessengerInfoProviderFactory create(MessengerInfoModule messengerInfoModule, Provider<Features> provider, Provider<BuildInfo> provider2) {
        return new MessengerInfoModule_ProvideMessengerInfoProviderFactory(messengerInfoModule, provider, provider2);
    }

    public static MessengerInfoProvider provideMessengerInfoProvider(MessengerInfoModule messengerInfoModule, Features features, BuildInfo buildInfo) {
        return (MessengerInfoProvider) Preconditions.checkNotNullFromProvides(messengerInfoModule.provideMessengerInfoProvider(features, buildInfo));
    }

    @Override // javax.inject.Provider
    public MessengerInfoProvider get() {
        return provideMessengerInfoProvider(this.a, this.b.get(), this.c.get());
    }
}
