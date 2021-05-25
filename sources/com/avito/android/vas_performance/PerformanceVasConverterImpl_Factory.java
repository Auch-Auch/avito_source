package com.avito.android.vas_performance;

import dagger.internal.Factory;
public final class PerformanceVasConverterImpl_Factory implements Factory<PerformanceVasConverterImpl> {

    public static final class a {
        public static final PerformanceVasConverterImpl_Factory a = new PerformanceVasConverterImpl_Factory();
    }

    public static PerformanceVasConverterImpl_Factory create() {
        return a.a;
    }

    public static PerformanceVasConverterImpl newInstance() {
        return new PerformanceVasConverterImpl();
    }

    @Override // javax.inject.Provider
    public PerformanceVasConverterImpl get() {
        return newInstance();
    }
}
