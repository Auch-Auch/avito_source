package com.avito.android.in_app_calls.di;

import com.avito.android.in_app_calls.service.ReconnectClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CallManagerServiceModule_ProvideReconnectClientFactory implements Factory<ReconnectClient> {

    public static final class a {
        public static final CallManagerServiceModule_ProvideReconnectClientFactory a = new CallManagerServiceModule_ProvideReconnectClientFactory();
    }

    public static CallManagerServiceModule_ProvideReconnectClientFactory create() {
        return a.a;
    }

    public static ReconnectClient provideReconnectClient() {
        return (ReconnectClient) Preconditions.checkNotNullFromProvides(CallManagerServiceModule.INSTANCE.provideReconnectClient());
    }

    @Override // javax.inject.Provider
    public ReconnectClient get() {
        return provideReconnectClient();
    }
}
