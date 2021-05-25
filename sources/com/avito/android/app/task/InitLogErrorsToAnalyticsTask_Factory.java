package com.avito.android.app.task;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InitLogErrorsToAnalyticsTask_Factory implements Factory<InitLogErrorsToAnalyticsTask> {
    public final Provider<Analytics> a;
    public final Provider<Features> b;

    public InitLogErrorsToAnalyticsTask_Factory(Provider<Analytics> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static InitLogErrorsToAnalyticsTask_Factory create(Provider<Analytics> provider, Provider<Features> provider2) {
        return new InitLogErrorsToAnalyticsTask_Factory(provider, provider2);
    }

    public static InitLogErrorsToAnalyticsTask newInstance(Analytics analytics, Features features) {
        return new InitLogErrorsToAnalyticsTask(analytics, features);
    }

    @Override // javax.inject.Provider
    public InitLogErrorsToAnalyticsTask get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
