package com.avito.android.app.task;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RegisterAnalyticsActivityListenerTask_Factory implements Factory<RegisterAnalyticsActivityListenerTask> {
    public final Provider<Analytics> a;

    public RegisterAnalyticsActivityListenerTask_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static RegisterAnalyticsActivityListenerTask_Factory create(Provider<Analytics> provider) {
        return new RegisterAnalyticsActivityListenerTask_Factory(provider);
    }

    public static RegisterAnalyticsActivityListenerTask newInstance(Analytics analytics) {
        return new RegisterAnalyticsActivityListenerTask(analytics);
    }

    @Override // javax.inject.Provider
    public RegisterAnalyticsActivityListenerTask get() {
        return newInstance(this.a.get());
    }
}
