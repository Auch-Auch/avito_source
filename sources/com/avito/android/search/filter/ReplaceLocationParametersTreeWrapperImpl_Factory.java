package com.avito.android.search.filter;

import dagger.internal.Factory;
public final class ReplaceLocationParametersTreeWrapperImpl_Factory implements Factory<ReplaceLocationParametersTreeWrapperImpl> {

    public static final class a {
        public static final ReplaceLocationParametersTreeWrapperImpl_Factory a = new ReplaceLocationParametersTreeWrapperImpl_Factory();
    }

    public static ReplaceLocationParametersTreeWrapperImpl_Factory create() {
        return a.a;
    }

    public static ReplaceLocationParametersTreeWrapperImpl newInstance() {
        return new ReplaceLocationParametersTreeWrapperImpl();
    }

    @Override // javax.inject.Provider
    public ReplaceLocationParametersTreeWrapperImpl get() {
        return newInstance();
    }
}
