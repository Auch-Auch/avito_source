package com.avito.android.serp.adapter.vertical_main;

import dagger.internal.Factory;
public final class VerticalFilterItemConverterImpl_Factory implements Factory<VerticalFilterItemConverterImpl> {

    public static final class a {
        public static final VerticalFilterItemConverterImpl_Factory a = new VerticalFilterItemConverterImpl_Factory();
    }

    public static VerticalFilterItemConverterImpl_Factory create() {
        return a.a;
    }

    public static VerticalFilterItemConverterImpl newInstance() {
        return new VerticalFilterItemConverterImpl();
    }

    @Override // javax.inject.Provider
    public VerticalFilterItemConverterImpl get() {
        return newInstance();
    }
}
