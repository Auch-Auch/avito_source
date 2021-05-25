package com.avito.android.in_app_calls.di;

import android.content.Context;
import com.voximplant.sdk.client.IClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class InAppCallsModule_ProvideVoximplantCallClientFactory implements Factory<IClient> {
    public final InAppCallsModule a;
    public final Provider<Context> b;

    public InAppCallsModule_ProvideVoximplantCallClientFactory(InAppCallsModule inAppCallsModule, Provider<Context> provider) {
        this.a = inAppCallsModule;
        this.b = provider;
    }

    public static InAppCallsModule_ProvideVoximplantCallClientFactory create(InAppCallsModule inAppCallsModule, Provider<Context> provider) {
        return new InAppCallsModule_ProvideVoximplantCallClientFactory(inAppCallsModule, provider);
    }

    public static IClient provideVoximplantCallClient(InAppCallsModule inAppCallsModule, Context context) {
        return (IClient) Preconditions.checkNotNullFromProvides(inAppCallsModule.provideVoximplantCallClient(context));
    }

    @Override // javax.inject.Provider
    public IClient get() {
        return provideVoximplantCallClient(this.a, this.b.get());
    }
}
