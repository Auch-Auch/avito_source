package com.avito.android.di;

import com.avito.android.service.short_task.TimeDiffAnalyticsInterceptor;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CheckRequestModule_ProvideTimeDiffAnalyticsInterceptorFactory implements Factory<TimeDiffAnalyticsInterceptor> {
    public final Provider<Gson> a;

    public CheckRequestModule_ProvideTimeDiffAnalyticsInterceptorFactory(Provider<Gson> provider) {
        this.a = provider;
    }

    public static CheckRequestModule_ProvideTimeDiffAnalyticsInterceptorFactory create(Provider<Gson> provider) {
        return new CheckRequestModule_ProvideTimeDiffAnalyticsInterceptorFactory(provider);
    }

    public static TimeDiffAnalyticsInterceptor provideTimeDiffAnalyticsInterceptor(Gson gson) {
        return (TimeDiffAnalyticsInterceptor) Preconditions.checkNotNullFromProvides(CheckRequestModule.provideTimeDiffAnalyticsInterceptor(gson));
    }

    @Override // javax.inject.Provider
    public TimeDiffAnalyticsInterceptor get() {
        return provideTimeDiffAnalyticsInterceptor(this.a.get());
    }
}
