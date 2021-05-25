package com.avito.android.vas_performance;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VasPerformanceIntentFactoryImpl_Factory implements Factory<VasPerformanceIntentFactoryImpl> {
    public final Provider<Context> a;

    public VasPerformanceIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static VasPerformanceIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new VasPerformanceIntentFactoryImpl_Factory(provider);
    }

    public static VasPerformanceIntentFactoryImpl newInstance(Context context) {
        return new VasPerformanceIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public VasPerformanceIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
