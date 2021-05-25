package com.avito.android.publish.residential_complex_search.adapter.button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ResidentialComplexButtonBlueprint_Factory implements Factory<ResidentialComplexButtonBlueprint> {
    public final Provider<ResidentialComplexButtonPresenter> a;

    public ResidentialComplexButtonBlueprint_Factory(Provider<ResidentialComplexButtonPresenter> provider) {
        this.a = provider;
    }

    public static ResidentialComplexButtonBlueprint_Factory create(Provider<ResidentialComplexButtonPresenter> provider) {
        return new ResidentialComplexButtonBlueprint_Factory(provider);
    }

    public static ResidentialComplexButtonBlueprint newInstance(ResidentialComplexButtonPresenter residentialComplexButtonPresenter) {
        return new ResidentialComplexButtonBlueprint(residentialComplexButtonPresenter);
    }

    @Override // javax.inject.Provider
    public ResidentialComplexButtonBlueprint get() {
        return newInstance(this.a.get());
    }
}
