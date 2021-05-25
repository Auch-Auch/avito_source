package com.avito.android.analytics.provider.pixel;

import dagger.internal.Factory;
public final class PixelParameterFormatterImpl_Factory implements Factory<PixelParameterFormatterImpl> {

    public static final class a {
        public static final PixelParameterFormatterImpl_Factory a = new PixelParameterFormatterImpl_Factory();
    }

    public static PixelParameterFormatterImpl_Factory create() {
        return a.a;
    }

    public static PixelParameterFormatterImpl newInstance() {
        return new PixelParameterFormatterImpl();
    }

    @Override // javax.inject.Provider
    public PixelParameterFormatterImpl get() {
        return newInstance();
    }
}
