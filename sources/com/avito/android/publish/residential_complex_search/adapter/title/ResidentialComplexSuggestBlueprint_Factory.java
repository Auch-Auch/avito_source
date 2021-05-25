package com.avito.android.publish.residential_complex_search.adapter.title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ResidentialComplexSuggestBlueprint_Factory implements Factory<ResidentialComplexSuggestBlueprint> {
    public final Provider<ResidentialComplexSuggestPresenter> a;

    public ResidentialComplexSuggestBlueprint_Factory(Provider<ResidentialComplexSuggestPresenter> provider) {
        this.a = provider;
    }

    public static ResidentialComplexSuggestBlueprint_Factory create(Provider<ResidentialComplexSuggestPresenter> provider) {
        return new ResidentialComplexSuggestBlueprint_Factory(provider);
    }

    public static ResidentialComplexSuggestBlueprint newInstance(ResidentialComplexSuggestPresenter residentialComplexSuggestPresenter) {
        return new ResidentialComplexSuggestBlueprint(residentialComplexSuggestPresenter);
    }

    @Override // javax.inject.Provider
    public ResidentialComplexSuggestBlueprint get() {
        return newInstance(this.a.get());
    }
}
