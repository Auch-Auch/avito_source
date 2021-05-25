package com.avito.android.messenger.di;

import android.content.Context;
import com.avito.android.messenger.conversation.adapter.GoogleApiKey;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessengerModule_ProvideGoogleApiKeyFactory implements Factory<GoogleApiKey> {
    public final MessengerModule a;
    public final Provider<Context> b;

    public MessengerModule_ProvideGoogleApiKeyFactory(MessengerModule messengerModule, Provider<Context> provider) {
        this.a = messengerModule;
        this.b = provider;
    }

    public static MessengerModule_ProvideGoogleApiKeyFactory create(MessengerModule messengerModule, Provider<Context> provider) {
        return new MessengerModule_ProvideGoogleApiKeyFactory(messengerModule, provider);
    }

    public static GoogleApiKey provideGoogleApiKey(MessengerModule messengerModule, Context context) {
        return (GoogleApiKey) Preconditions.checkNotNullFromProvides(messengerModule.provideGoogleApiKey(context));
    }

    @Override // javax.inject.Provider
    public GoogleApiKey get() {
        return provideGoogleApiKey(this.a, this.b.get());
    }
}
