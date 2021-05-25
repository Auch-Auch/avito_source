package com.avito.android.messenger.service;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OpenErrorTrackerSchedulerImpl_Factory implements Factory<OpenErrorTrackerSchedulerImpl> {
    public final Provider<Context> a;

    public OpenErrorTrackerSchedulerImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static OpenErrorTrackerSchedulerImpl_Factory create(Provider<Context> provider) {
        return new OpenErrorTrackerSchedulerImpl_Factory(provider);
    }

    public static OpenErrorTrackerSchedulerImpl newInstance(Context context) {
        return new OpenErrorTrackerSchedulerImpl(context);
    }

    @Override // javax.inject.Provider
    public OpenErrorTrackerSchedulerImpl get() {
        return newInstance(this.a.get());
    }
}
