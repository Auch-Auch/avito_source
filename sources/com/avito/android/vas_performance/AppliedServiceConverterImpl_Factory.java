package com.avito.android.vas_performance;

import dagger.internal.Factory;
public final class AppliedServiceConverterImpl_Factory implements Factory<AppliedServiceConverterImpl> {

    public static final class a {
        public static final AppliedServiceConverterImpl_Factory a = new AppliedServiceConverterImpl_Factory();
    }

    public static AppliedServiceConverterImpl_Factory create() {
        return a.a;
    }

    public static AppliedServiceConverterImpl newInstance() {
        return new AppliedServiceConverterImpl();
    }

    @Override // javax.inject.Provider
    public AppliedServiceConverterImpl get() {
        return newInstance();
    }
}
