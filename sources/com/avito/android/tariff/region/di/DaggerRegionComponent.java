package com.avito.android.tariff.region.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.remote.TariffApi;
import com.avito.android.tariff.StringProvider;
import com.avito.android.tariff.di.HeaderModule_ProvideHeaderBlueprintFactory;
import com.avito.android.tariff.di.HeaderModule_ProvideHeaderPresenterFactory;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.region.RegionFragment;
import com.avito.android.tariff.region.RegionFragment_MembersInjector;
import com.avito.android.tariff.region.di.RegionComponent;
import com.avito.android.tariff.region.item.RegionItemBlueprint;
import com.avito.android.tariff.region.item.RegionItemBlueprint_Factory;
import com.avito.android.tariff.region.item.RegionItemPresenterImpl;
import com.avito.android.tariff.region.item.RegionItemPresenterImpl_Factory;
import com.avito.android.tariff.region.viewmodel.RegionConverter;
import com.avito.android.tariff.region.viewmodel.RegionConverterImpl;
import com.avito.android.tariff.region.viewmodel.RegionConverterImpl_Factory;
import com.avito.android.tariff.region.viewmodel.RegionViewModel;
import com.avito.android.tariff.region.viewmodel.RegionViewModelFactory;
import com.avito.android.tariff.region.viewmodel.RegionViewModelFactory_Factory;
import com.avito.android.tariff.region.viewmodel.TariffRegionRepository;
import com.avito.android.tariff.region.viewmodel.TariffRegionRepositoryImpl;
import com.avito.android.tariff.region.viewmodel.TariffRegionRepositoryImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerRegionComponent implements RegionComponent {
    public Provider<Set<ItemBlueprint<?, ?>>> a = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PaidServiceHeaderItemPresenter> b;
    public Provider<ItemBlueprint<?, ?>> c;
    public Provider<RegionItemPresenterImpl> d;
    public Provider<RegionItemBlueprint> e;
    public Provider<ItemBlueprint<?, ?>> f;
    public Provider<Set<ItemBlueprint<?, ?>>> g;
    public Provider<ItemBinder> h;
    public Provider<AdapterPresenter> i;
    public Provider<Fragment> j;
    public Provider<String> k;
    public Provider<TariffApi> l;
    public Provider<SchedulersFactory> m;
    public Provider<TariffRegionRepositoryImpl> n;
    public Provider<TariffRegionRepository> o;
    public Provider<AttributedTextFormatter> p;
    public Provider<RegionConverterImpl> q;
    public Provider<RegionConverter> r;
    public Provider<StringProvider> s;
    public Provider<Kundle> t;
    public Provider<RegionViewModelFactory> u;
    public Provider<ViewModelProvider.Factory> v;
    public Provider<RegionViewModel> w;

    public static final class b implements RegionComponent.Builder {
        public TariffStepDependencies a;
        public String b;
        public Fragment c;
        public Kundle d;

        public b(a aVar) {
        }

        @Override // com.avito.android.tariff.region.di.RegionComponent.Builder
        public RegionComponent build() {
            Preconditions.checkBuilderRequirement(this.a, TariffStepDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, Fragment.class);
            Preconditions.checkBuilderRequirement(this.d, Kundle.class);
            return new DaggerRegionComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.tariff.region.di.RegionComponent.Builder
        public RegionComponent.Builder checkoutContext(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.tariff.region.di.RegionComponent.Builder
        public RegionComponent.Builder dependencies(TariffStepDependencies tariffStepDependencies) {
            this.a = (TariffStepDependencies) Preconditions.checkNotNull(tariffStepDependencies);
            return this;
        }

        @Override // com.avito.android.tariff.region.di.RegionComponent.Builder
        public RegionComponent.Builder fragment(Fragment fragment) {
            this.c = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.tariff.region.di.RegionComponent.Builder
        public RegionComponent.Builder savedState(Kundle kundle) {
            this.d = (Kundle) Preconditions.checkNotNull(kundle);
            return this;
        }
    }

    public static class c implements Provider<AttributedTextFormatter> {
        public final TariffStepDependencies a;

        public c(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AttributedTextFormatter get() {
            return (AttributedTextFormatter) Preconditions.checkNotNullFromComponent(this.a.attributedTextFormatter());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final TariffStepDependencies a;

        public d(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class e implements Provider<StringProvider> {
        public final TariffStepDependencies a;

        public e(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public StringProvider get() {
            return (StringProvider) Preconditions.checkNotNullFromComponent(this.a.stringProvider());
        }
    }

    public static class f implements Provider<TariffApi> {
        public final TariffStepDependencies a;

        public f(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TariffApi get() {
            return (TariffApi) Preconditions.checkNotNullFromComponent(this.a.tariffApi());
        }
    }

    public DaggerRegionComponent(TariffStepDependencies tariffStepDependencies, String str, Fragment fragment, Kundle kundle, a aVar) {
        Provider<PaidServiceHeaderItemPresenter> provider = DoubleCheck.provider(HeaderModule_ProvideHeaderPresenterFactory.create());
        this.b = provider;
        this.c = DoubleCheck.provider(HeaderModule_ProvideHeaderBlueprintFactory.create(provider));
        Provider<RegionItemPresenterImpl> provider2 = DoubleCheck.provider(RegionItemPresenterImpl_Factory.create());
        this.d = provider2;
        RegionItemBlueprint_Factory create = RegionItemBlueprint_Factory.create(provider2);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        SetFactory build = SetFactory.builder(2, 1).addCollectionProvider(this.a).addProvider(this.c).addProvider(this.f).build();
        this.g = build;
        Provider<ItemBinder> provider3 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.h = provider3;
        this.i = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider3));
        this.j = InstanceFactory.create(fragment);
        this.k = InstanceFactory.create(str);
        f fVar = new f(tariffStepDependencies);
        this.l = fVar;
        d dVar = new d(tariffStepDependencies);
        this.m = dVar;
        TariffRegionRepositoryImpl_Factory create2 = TariffRegionRepositoryImpl_Factory.create(fVar, dVar);
        this.n = create2;
        this.o = DoubleCheck.provider(create2);
        c cVar = new c(tariffStepDependencies);
        this.p = cVar;
        RegionConverterImpl_Factory create3 = RegionConverterImpl_Factory.create(cVar);
        this.q = create3;
        this.r = DoubleCheck.provider(create3);
        this.s = new e(tariffStepDependencies);
        Factory create4 = InstanceFactory.create(kundle);
        this.t = create4;
        RegionViewModelFactory_Factory create5 = RegionViewModelFactory_Factory.create(this.k, this.o, this.r, this.m, this.s, create4);
        this.u = create5;
        Provider<ViewModelProvider.Factory> provider4 = DoubleCheck.provider(create5);
        this.v = provider4;
        this.w = DoubleCheck.provider(RegionModule_ProvideViewModelFactory.create(this.j, provider4));
    }

    public static RegionComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.tariff.region.di.RegionComponent
    public void inject(RegionFragment regionFragment) {
        RegionFragment_MembersInjector.injectItemBinder(regionFragment, this.h.get());
        RegionFragment_MembersInjector.injectAdapterPresenter(regionFragment, this.i.get());
        RegionFragment_MembersInjector.injectItemPresenterSet(regionFragment, SetBuilder.newSetBuilder(2).add(this.b.get()).add(this.d.get()).build());
        RegionFragment_MembersInjector.injectViewModel(regionFragment, this.w.get());
    }
}
