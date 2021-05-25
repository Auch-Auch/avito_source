package com.avito.android.publish.residential_complex_search.di;

import com.avito.android.publish.residential_complex_search.ResidentialComplexViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ResidentialComplexModule_ProvideViewModelFactory implements Factory<ResidentialComplexViewModel> {
    public final ResidentialComplexModule a;
    public final Provider<ResidentialComplexViewModelFactory> b;

    public ResidentialComplexModule_ProvideViewModelFactory(ResidentialComplexModule residentialComplexModule, Provider<ResidentialComplexViewModelFactory> provider) {
        this.a = residentialComplexModule;
        this.b = provider;
    }

    public static ResidentialComplexModule_ProvideViewModelFactory create(ResidentialComplexModule residentialComplexModule, Provider<ResidentialComplexViewModelFactory> provider) {
        return new ResidentialComplexModule_ProvideViewModelFactory(residentialComplexModule, provider);
    }

    public static ResidentialComplexViewModel provideViewModel(ResidentialComplexModule residentialComplexModule, ResidentialComplexViewModelFactory residentialComplexViewModelFactory) {
        return (ResidentialComplexViewModel) Preconditions.checkNotNullFromProvides(residentialComplexModule.provideViewModel(residentialComplexViewModelFactory));
    }

    @Override // javax.inject.Provider
    public ResidentialComplexViewModel get() {
        return provideViewModel(this.a, this.b.get());
    }
}
