package com.avito.android.analytics.provider.pixel;

import dagger.internal.Factory;
public final class PixelParameterEncoderImpl_Factory implements Factory<PixelParameterEncoderImpl> {

    public static final class a {
        public static final PixelParameterEncoderImpl_Factory a = new PixelParameterEncoderImpl_Factory();
    }

    public static PixelParameterEncoderImpl_Factory create() {
        return a.a;
    }

    public static PixelParameterEncoderImpl newInstance() {
        return new PixelParameterEncoderImpl();
    }

    @Override // javax.inject.Provider
    public PixelParameterEncoderImpl get() {
        return newInstance();
    }
}
