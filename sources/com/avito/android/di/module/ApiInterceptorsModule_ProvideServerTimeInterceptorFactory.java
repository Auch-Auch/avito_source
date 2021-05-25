package com.avito.android.di.module;

import com.avito.android.remote.interceptor.ServerTimeInterceptor;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.functions.Consumer;
import javax.inject.Provider;
public final class ApiInterceptorsModule_ProvideServerTimeInterceptorFactory implements Factory<ServerTimeInterceptor> {
    public final ApiInterceptorsModule a;
    public final Provider<Consumer<Long>> b;
    public final Provider<BuildInfo> c;

    public ApiInterceptorsModule_ProvideServerTimeInterceptorFactory(ApiInterceptorsModule apiInterceptorsModule, Provider<Consumer<Long>> provider, Provider<BuildInfo> provider2) {
        this.a = apiInterceptorsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ApiInterceptorsModule_ProvideServerTimeInterceptorFactory create(ApiInterceptorsModule apiInterceptorsModule, Provider<Consumer<Long>> provider, Provider<BuildInfo> provider2) {
        return new ApiInterceptorsModule_ProvideServerTimeInterceptorFactory(apiInterceptorsModule, provider, provider2);
    }

    public static ServerTimeInterceptor provideServerTimeInterceptor(ApiInterceptorsModule apiInterceptorsModule, Consumer<Long> consumer, BuildInfo buildInfo) {
        return (ServerTimeInterceptor) Preconditions.checkNotNullFromProvides(apiInterceptorsModule.provideServerTimeInterceptor(consumer, buildInfo));
    }

    @Override // javax.inject.Provider
    public ServerTimeInterceptor get() {
        return provideServerTimeInterceptor(this.a, this.b.get(), this.c.get());
    }
}
