package com.avito.android.brandspace.interactor;

import com.avito.android.brandspace.data.AdvertRepository;
import com.avito.android.brandspace.presenter.BrandspaceAdvertItemProcessor;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource;
import com.avito.android.brandspace.remote.BrandspaceApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BrandspaceInteractorImpl_Factory implements Factory<BrandspaceInteractorImpl> {
    public final Provider<String> a;
    public final Provider<AdvertRepository<AdvertSource.LinkSource>> b;
    public final Provider<AdvertRepository<AdvertSource.ParametersSource>> c;
    public final Provider<AdvertRepository<AdvertSource.TabsSource>> d;
    public final Provider<BrandspaceApi> e;
    public final Provider<SearchApi> f;
    public final Provider<SchedulersFactory3> g;
    public final Provider<BrandspaceAdvertItemProcessor> h;

    public BrandspaceInteractorImpl_Factory(Provider<String> provider, Provider<AdvertRepository<AdvertSource.LinkSource>> provider2, Provider<AdvertRepository<AdvertSource.ParametersSource>> provider3, Provider<AdvertRepository<AdvertSource.TabsSource>> provider4, Provider<BrandspaceApi> provider5, Provider<SearchApi> provider6, Provider<SchedulersFactory3> provider7, Provider<BrandspaceAdvertItemProcessor> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static BrandspaceInteractorImpl_Factory create(Provider<String> provider, Provider<AdvertRepository<AdvertSource.LinkSource>> provider2, Provider<AdvertRepository<AdvertSource.ParametersSource>> provider3, Provider<AdvertRepository<AdvertSource.TabsSource>> provider4, Provider<BrandspaceApi> provider5, Provider<SearchApi> provider6, Provider<SchedulersFactory3> provider7, Provider<BrandspaceAdvertItemProcessor> provider8) {
        return new BrandspaceInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static BrandspaceInteractorImpl newInstance(String str, AdvertRepository<AdvertSource.LinkSource> advertRepository, AdvertRepository<AdvertSource.ParametersSource> advertRepository2, AdvertRepository<AdvertSource.TabsSource> advertRepository3, BrandspaceApi brandspaceApi, SearchApi searchApi, SchedulersFactory3 schedulersFactory3, BrandspaceAdvertItemProcessor brandspaceAdvertItemProcessor) {
        return new BrandspaceInteractorImpl(str, advertRepository, advertRepository2, advertRepository3, brandspaceApi, searchApi, schedulersFactory3, brandspaceAdvertItemProcessor);
    }

    @Override // javax.inject.Provider
    public BrandspaceInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
