package com.avito.android.tariff.landing.viewmodel;

import dagger.internal.Factory;
public final class LandingConverterImpl_Factory implements Factory<LandingConverterImpl> {

    public static final class a {
        public static final LandingConverterImpl_Factory a = new LandingConverterImpl_Factory();
    }

    public static LandingConverterImpl_Factory create() {
        return a.a;
    }

    public static LandingConverterImpl newInstance() {
        return new LandingConverterImpl();
    }

    @Override // javax.inject.Provider
    public LandingConverterImpl get() {
        return newInstance();
    }
}
