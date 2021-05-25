package com.avito.android.user_adverts.tab_screens.converters;

import dagger.internal.Factory;
public final class PerformanceVasBannerConverterImpl_Factory implements Factory<PerformanceVasBannerConverterImpl> {

    public static final class a {
        public static final PerformanceVasBannerConverterImpl_Factory a = new PerformanceVasBannerConverterImpl_Factory();
    }

    public static PerformanceVasBannerConverterImpl_Factory create() {
        return a.a;
    }

    public static PerformanceVasBannerConverterImpl newInstance() {
        return new PerformanceVasBannerConverterImpl();
    }

    @Override // javax.inject.Provider
    public PerformanceVasBannerConverterImpl get() {
        return newInstance();
    }
}
