package com.avito.android.publish.residential_complex_search;

import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import java.util.List;
import javax.inject.Provider;
public final class ResidentialComplexViewModel_Factory implements Factory<ResidentialComplexViewModel> {
    public final Provider<SchedulersFactory> a;
    public final Provider<PublishApi> b;
    public final Provider<ResidentialComplexConverter> c;
    public final Provider<Double> d;
    public final Provider<Double> e;
    public final Provider<List<SelectParameter.Value>> f;

    public ResidentialComplexViewModel_Factory(Provider<SchedulersFactory> provider, Provider<PublishApi> provider2, Provider<ResidentialComplexConverter> provider3, Provider<Double> provider4, Provider<Double> provider5, Provider<List<SelectParameter.Value>> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static ResidentialComplexViewModel_Factory create(Provider<SchedulersFactory> provider, Provider<PublishApi> provider2, Provider<ResidentialComplexConverter> provider3, Provider<Double> provider4, Provider<Double> provider5, Provider<List<SelectParameter.Value>> provider6) {
        return new ResidentialComplexViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ResidentialComplexViewModel newInstance(SchedulersFactory schedulersFactory, PublishApi publishApi, ResidentialComplexConverter residentialComplexConverter, Double d2, Double d3, List<SelectParameter.Value> list) {
        return new ResidentialComplexViewModel(schedulersFactory, publishApi, residentialComplexConverter, d2, d3, list);
    }

    @Override // javax.inject.Provider
    public ResidentialComplexViewModel get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
