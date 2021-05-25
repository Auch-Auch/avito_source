package com.avito.android.publish.residential_complex_search.adapter.title;

import dagger.internal.Factory;
public final class ResidentialComplexSuggestPresenterImpl_Factory implements Factory<ResidentialComplexSuggestPresenterImpl> {

    public static final class a {
        public static final ResidentialComplexSuggestPresenterImpl_Factory a = new ResidentialComplexSuggestPresenterImpl_Factory();
    }

    public static ResidentialComplexSuggestPresenterImpl_Factory create() {
        return a.a;
    }

    public static ResidentialComplexSuggestPresenterImpl newInstance() {
        return new ResidentialComplexSuggestPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ResidentialComplexSuggestPresenterImpl get() {
        return newInstance();
    }
}
