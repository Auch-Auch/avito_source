package com.avito.android.job;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class JobIntentFactoryImpl_Factory implements Factory<JobIntentFactoryImpl> {
    public final Provider<Application> a;

    public JobIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static JobIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new JobIntentFactoryImpl_Factory(provider);
    }

    public static JobIntentFactoryImpl newInstance(Application application) {
        return new JobIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public JobIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
