package com.avito.android.publish.residential_complex_search.di;

import com.avito.android.publish.residential_complex_search.ResidentialComplexConverter;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class ResidentialComplexModule_ProvideViewModelFactoryFactory implements Factory<ResidentialComplexViewModelFactory> {
    public final ResidentialComplexModule a;
    public final Provider<SchedulersFactory> b;
    public final Provider<PublishApi> c;
    public final Provider<ResidentialComplexConverter> d;
    public final Provider<Double> e;
    public final Provider<Double> f;
    public final Provider<List<SelectParameter.Value>> g;

    public ResidentialComplexModule_ProvideViewModelFactoryFactory(ResidentialComplexModule residentialComplexModule, Provider<SchedulersFactory> provider, Provider<PublishApi> provider2, Provider<ResidentialComplexConverter> provider3, Provider<Double> provider4, Provider<Double> provider5, Provider<List<SelectParameter.Value>> provider6) {
        this.a = residentialComplexModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
    }

    public static ResidentialComplexModule_ProvideViewModelFactoryFactory create(ResidentialComplexModule residentialComplexModule, Provider<SchedulersFactory> provider, Provider<PublishApi> provider2, Provider<ResidentialComplexConverter> provider3, Provider<Double> provider4, Provider<Double> provider5, Provider<List<SelectParameter.Value>> provider6) {
        return new ResidentialComplexModule_ProvideViewModelFactoryFactory(residentialComplexModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ResidentialComplexViewModelFactory provideViewModelFactory(ResidentialComplexModule residentialComplexModule, SchedulersFactory schedulersFactory, PublishApi publishApi, ResidentialComplexConverter residentialComplexConverter, Double d2, Double d3, List<SelectParameter.Value> list) {
        return (ResidentialComplexViewModelFactory) Preconditions.checkNotNullFromProvides(residentialComplexModule.provideViewModelFactory(schedulersFactory, publishApi, residentialComplexConverter, d2, d3, list));
    }

    @Override // javax.inject.Provider
    public ResidentialComplexViewModelFactory get() {
        return provideViewModelFactory(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
