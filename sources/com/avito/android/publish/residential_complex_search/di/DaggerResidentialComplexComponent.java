package com.avito.android.publish.residential_complex_search.di;

import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.publish.residential_complex_search.ResidentialComplexActivity;
import com.avito.android.publish.residential_complex_search.ResidentialComplexActivity_MembersInjector;
import com.avito.android.publish.residential_complex_search.ResidentialComplexConverter;
import com.avito.android.publish.residential_complex_search.ResidentialComplexConverterImpl_Factory;
import com.avito.android.publish.residential_complex_search.ResidentialComplexViewModel;
import com.avito.android.publish.residential_complex_search.adapter.button.ResidentialComplexButtonBlueprint;
import com.avito.android.publish.residential_complex_search.adapter.button.ResidentialComplexButtonBlueprint_Factory;
import com.avito.android.publish.residential_complex_search.adapter.button.ResidentialComplexButtonPresenter;
import com.avito.android.publish.residential_complex_search.adapter.button.ResidentialComplexButtonPresenterImpl_Factory;
import com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestBlueprint;
import com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestBlueprint_Factory;
import com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestPresenter;
import com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestPresenterImpl_Factory;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexComponent;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerResidentialComplexComponent implements ResidentialComplexComponent {
    public Provider<SchedulersFactory> a;
    public Provider<PublishApi> b;
    public Provider<ResidentialComplexConverter> c = DoubleCheck.provider(ResidentialComplexConverterImpl_Factory.create());
    public Provider<Double> d;
    public Provider<Double> e;
    public Provider<List<SelectParameter.Value>> f;
    public Provider<ResidentialComplexViewModelFactory> g;
    public Provider<ResidentialComplexViewModel> h;
    public Provider<Set<ItemBlueprint<?, ?>>> i;
    public Provider<ResidentialComplexSuggestPresenter> j;
    public Provider<ResidentialComplexSuggestBlueprint> k;
    public Provider<ItemBlueprint<?, ?>> l;
    public Provider<ResidentialComplexButtonPresenter> m;
    public Provider<ResidentialComplexButtonBlueprint> n;
    public Provider<ItemBlueprint<?, ?>> o;
    public Provider<Set<ItemBlueprint<?, ?>>> p;
    public Provider<ItemBinder> q;
    public Provider<AdapterPresenter> r;

    public static final class b implements ResidentialComplexComponent.Builder {
        public ResidentialComplexComponentDependencies a;
        public ResidentialComplexModule b;
        public Double c;
        public Double d;
        public List<SelectParameter.Value> e;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.residential_complex_search.di.ResidentialComplexComponent.Builder
        public ResidentialComplexComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ResidentialComplexComponentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ResidentialComplexModule.class);
            return new DaggerResidentialComplexComponent(this.b, this.a, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.publish.residential_complex_search.di.ResidentialComplexComponent.Builder
        public ResidentialComplexComponent.Builder dependencies(ResidentialComplexComponentDependencies residentialComplexComponentDependencies) {
            this.a = (ResidentialComplexComponentDependencies) Preconditions.checkNotNull(residentialComplexComponentDependencies);
            return this;
        }

        @Override // com.avito.android.publish.residential_complex_search.di.ResidentialComplexComponent.Builder
        public ResidentialComplexComponent.Builder module(ResidentialComplexModule residentialComplexModule) {
            this.b = (ResidentialComplexModule) Preconditions.checkNotNull(residentialComplexModule);
            return this;
        }

        @Override // com.avito.android.publish.residential_complex_search.di.ResidentialComplexComponent.Builder
        public ResidentialComplexComponent.Builder withLat(Double d2) {
            this.c = d2;
            return this;
        }

        @Override // com.avito.android.publish.residential_complex_search.di.ResidentialComplexComponent.Builder
        public ResidentialComplexComponent.Builder withLng(Double d2) {
            this.d = d2;
            return this;
        }

        @Override // com.avito.android.publish.residential_complex_search.di.ResidentialComplexComponent.Builder
        public ResidentialComplexComponent.Builder withValues(List list) {
            this.e = list;
            return this;
        }
    }

    public static class c implements Provider<PublishApi> {
        public final ResidentialComplexComponentDependencies a;

        public c(ResidentialComplexComponentDependencies residentialComplexComponentDependencies) {
            this.a = residentialComplexComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishApi get() {
            return (PublishApi) Preconditions.checkNotNullFromComponent(this.a.publishApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final ResidentialComplexComponentDependencies a;

        public d(ResidentialComplexComponentDependencies residentialComplexComponentDependencies) {
            this.a = residentialComplexComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerResidentialComplexComponent(ResidentialComplexModule residentialComplexModule, ResidentialComplexComponentDependencies residentialComplexComponentDependencies, Double d2, Double d3, List list, a aVar) {
        this.a = new d(residentialComplexComponentDependencies);
        this.b = new c(residentialComplexComponentDependencies);
        this.d = InstanceFactory.createNullable(d2);
        this.e = InstanceFactory.createNullable(d3);
        Factory createNullable = InstanceFactory.createNullable(list);
        this.f = createNullable;
        Provider<ResidentialComplexViewModelFactory> provider = DoubleCheck.provider(ResidentialComplexModule_ProvideViewModelFactoryFactory.create(residentialComplexModule, this.a, this.b, this.c, this.d, this.e, createNullable));
        this.g = provider;
        this.h = DoubleCheck.provider(ResidentialComplexModule_ProvideViewModelFactory.create(residentialComplexModule, provider));
        this.i = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
        Provider<ResidentialComplexSuggestPresenter> provider2 = DoubleCheck.provider(ResidentialComplexSuggestPresenterImpl_Factory.create());
        this.j = provider2;
        ResidentialComplexSuggestBlueprint_Factory create = ResidentialComplexSuggestBlueprint_Factory.create(provider2);
        this.k = create;
        this.l = DoubleCheck.provider(create);
        Provider<ResidentialComplexButtonPresenter> provider3 = DoubleCheck.provider(ResidentialComplexButtonPresenterImpl_Factory.create());
        this.m = provider3;
        ResidentialComplexButtonBlueprint_Factory create2 = ResidentialComplexButtonBlueprint_Factory.create(provider3);
        this.n = create2;
        this.o = DoubleCheck.provider(create2);
        SetFactory build = SetFactory.builder(2, 1).addCollectionProvider(this.i).addProvider(this.l).addProvider(this.o).build();
        this.p = build;
        Provider<ItemBinder> provider4 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.q = provider4;
        this.r = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider4));
    }

    public static ResidentialComplexComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.residential_complex_search.di.ResidentialComplexComponent
    public void inject(ResidentialComplexActivity residentialComplexActivity) {
        ResidentialComplexActivity_MembersInjector.injectViewModel(residentialComplexActivity, this.h.get());
        ResidentialComplexActivity_MembersInjector.injectAdapterPresenter(residentialComplexActivity, this.r.get());
        ResidentialComplexActivity_MembersInjector.injectItemBinder(residentialComplexActivity, this.q.get());
        ResidentialComplexActivity_MembersInjector.injectSuggestPresenter(residentialComplexActivity, this.j.get());
        ResidentialComplexActivity_MembersInjector.injectButtonPresenter(residentialComplexActivity, this.m.get());
    }
}
