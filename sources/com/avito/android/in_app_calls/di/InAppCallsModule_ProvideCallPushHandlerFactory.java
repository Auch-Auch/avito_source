package com.avito.android.in_app_calls.di;

import com.avito.android.in_app_calls.CallManager;
import com.avito.android.push.CallPushHandler;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class InAppCallsModule_ProvideCallPushHandlerFactory implements Factory<CallPushHandler> {
    public final InAppCallsModule a;
    public final Provider<CallManager> b;

    public InAppCallsModule_ProvideCallPushHandlerFactory(InAppCallsModule inAppCallsModule, Provider<CallManager> provider) {
        this.a = inAppCallsModule;
        this.b = provider;
    }

    public static InAppCallsModule_ProvideCallPushHandlerFactory create(InAppCallsModule inAppCallsModule, Provider<CallManager> provider) {
        return new InAppCallsModule_ProvideCallPushHandlerFactory(inAppCallsModule, provider);
    }

    public static CallPushHandler provideCallPushHandler(InAppCallsModule inAppCallsModule, Lazy<CallManager> lazy) {
        return (CallPushHandler) Preconditions.checkNotNullFromProvides(inAppCallsModule.provideCallPushHandler(lazy));
    }

    @Override // javax.inject.Provider
    public CallPushHandler get() {
        return provideCallPushHandler(this.a, DoubleCheck.lazy(this.b));
    }
}
