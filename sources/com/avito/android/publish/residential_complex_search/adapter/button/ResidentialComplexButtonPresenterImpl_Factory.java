package com.avito.android.publish.residential_complex_search.adapter.button;

import dagger.internal.Factory;
public final class ResidentialComplexButtonPresenterImpl_Factory implements Factory<ResidentialComplexButtonPresenterImpl> {

    public static final class a {
        public static final ResidentialComplexButtonPresenterImpl_Factory a = new ResidentialComplexButtonPresenterImpl_Factory();
    }

    public static ResidentialComplexButtonPresenterImpl_Factory create() {
        return a.a;
    }

    public static ResidentialComplexButtonPresenterImpl newInstance() {
        return new ResidentialComplexButtonPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ResidentialComplexButtonPresenterImpl get() {
        return newInstance();
    }
}
