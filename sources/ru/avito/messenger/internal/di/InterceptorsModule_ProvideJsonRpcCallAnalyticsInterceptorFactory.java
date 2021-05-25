package ru.avito.messenger.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.RequestIdHolder;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.jsonrpc.JsonRpcCallAnalyticsInterceptor;
public final class InterceptorsModule_ProvideJsonRpcCallAnalyticsInterceptorFactory implements Factory<JsonRpcCallAnalyticsInterceptor> {
    public final InterceptorsModule a;
    public final Provider<Config> b;
    public final Provider<RequestIdHolder> c;

    public InterceptorsModule_ProvideJsonRpcCallAnalyticsInterceptorFactory(InterceptorsModule interceptorsModule, Provider<Config> provider, Provider<RequestIdHolder> provider2) {
        this.a = interceptorsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static InterceptorsModule_ProvideJsonRpcCallAnalyticsInterceptorFactory create(InterceptorsModule interceptorsModule, Provider<Config> provider, Provider<RequestIdHolder> provider2) {
        return new InterceptorsModule_ProvideJsonRpcCallAnalyticsInterceptorFactory(interceptorsModule, provider, provider2);
    }

    public static JsonRpcCallAnalyticsInterceptor provideJsonRpcCallAnalyticsInterceptor(InterceptorsModule interceptorsModule, Config config, RequestIdHolder requestIdHolder) {
        return (JsonRpcCallAnalyticsInterceptor) Preconditions.checkNotNullFromProvides(interceptorsModule.provideJsonRpcCallAnalyticsInterceptor(config, requestIdHolder));
    }

    @Override // javax.inject.Provider
    public JsonRpcCallAnalyticsInterceptor get() {
        return provideJsonRpcCallAnalyticsInterceptor(this.a, this.b.get(), this.c.get());
    }
}
