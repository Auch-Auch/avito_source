package com.avito.android.tariff.landing.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.remote.TariffApi;
import com.avito.android.tariff.di.HeaderModule_ProvideHeaderBlueprintFactory;
import com.avito.android.tariff.di.HeaderModule_ProvideHeaderPresenterFactory;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.landing.TariffLandingFragment;
import com.avito.android.tariff.landing.TariffLandingFragment_MembersInjector;
import com.avito.android.tariff.landing.di.LandingComponent;
import com.avito.android.tariff.landing.item.icon.IconItemBlueprint;
import com.avito.android.tariff.landing.item.icon.IconItemBlueprint_Factory;
import com.avito.android.tariff.landing.item.icon.IconItemPresenter_Factory;
import com.avito.android.tariff.landing.item.text.TextItemBlueprint;
import com.avito.android.tariff.landing.item.text.TextItemBlueprint_Factory;
import com.avito.android.tariff.landing.item.text.TextItemPresenter_Factory;
import com.avito.android.tariff.landing.viewmodel.LandingConverter;
import com.avito.android.tariff.landing.viewmodel.LandingConverterImpl_Factory;
import com.avito.android.tariff.landing.viewmodel.LandingInteractor;
import com.avito.android.tariff.landing.viewmodel.LandingInteractorImpl;
import com.avito.android.tariff.landing.viewmodel.LandingInteractorImpl_Factory;
import com.avito.android.tariff.landing.viewmodel.TariffLandingViewModel;
import com.avito.android.tariff.landing.viewmodel.TariffLandingViewModelFactory;
import com.avito.android.tariff.landing.viewmodel.TariffLandingViewModelFactory_Factory;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerLandingComponent implements LandingComponent {
    public Provider<Set<ItemBlueprint<?, ?>>> a = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PaidServiceHeaderItemPresenter> b;
    public Provider<ItemBlueprint<?, ?>> c;
    public Provider<IconItemBlueprint> d;
    public Provider<ItemBlueprint<?, ?>> e;
    public Provider<TextItemBlueprint> f;
    public Provider<ItemBlueprint<?, ?>> g;
    public Provider<Set<ItemBlueprint<?, ?>>> h;
    public Provider<ItemBinder> i;
    public Provider<AdapterPresenter> j;
    public Provider<SimpleRecyclerAdapter> k;
    public Provider<ItemPresenter<?, ?>> l;
    public Provider<ItemPresenter<?, ?>> m;
    public Provider<Fragment> n;
    public Provider<String> o;
    public Provider<TariffApi> p;
    public Provider<LandingConverter> q;
    public Provider<SchedulersFactory> r;
    public Provider<LandingInteractorImpl> s;
    public Provider<LandingInteractor> t;
    public Provider<TariffLandingViewModelFactory> u;
    public Provider<ViewModelProvider.Factory> v;
    public Provider<TariffLandingViewModel> w;

    public static final class b implements LandingComponent.Builder {
        public TariffStepDependencies a;
        public String b;
        public Fragment c;

        public b(a aVar) {
        }

        @Override // com.avito.android.tariff.landing.di.LandingComponent.Builder
        public LandingComponent build() {
            Preconditions.checkBuilderRequirement(this.a, TariffStepDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, Fragment.class);
            return new DaggerLandingComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.tariff.landing.di.LandingComponent.Builder
        public LandingComponent.Builder checkoutContext(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.tariff.landing.di.LandingComponent.Builder
        public LandingComponent.Builder dependencies(TariffStepDependencies tariffStepDependencies) {
            this.a = (TariffStepDependencies) Preconditions.checkNotNull(tariffStepDependencies);
            return this;
        }

        @Override // com.avito.android.tariff.landing.di.LandingComponent.Builder
        public LandingComponent.Builder fragment(Fragment fragment) {
            this.c = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }
    }

    public static class c implements Provider<SchedulersFactory> {
        public final TariffStepDependencies a;

        public c(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class d implements Provider<TariffApi> {
        public final TariffStepDependencies a;

        public d(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TariffApi get() {
            return (TariffApi) Preconditions.checkNotNullFromComponent(this.a.tariffApi());
        }
    }

    public DaggerLandingComponent(TariffStepDependencies tariffStepDependencies, String str, Fragment fragment, a aVar) {
        Provider<PaidServiceHeaderItemPresenter> provider = DoubleCheck.provider(HeaderModule_ProvideHeaderPresenterFactory.create());
        this.b = provider;
        this.c = DoubleCheck.provider(HeaderModule_ProvideHeaderBlueprintFactory.create(provider));
        IconItemBlueprint_Factory create = IconItemBlueprint_Factory.create(IconItemPresenter_Factory.create());
        this.d = create;
        this.e = DoubleCheck.provider(create);
        TextItemBlueprint_Factory create2 = TextItemBlueprint_Factory.create(TextItemPresenter_Factory.create());
        this.f = create2;
        this.g = DoubleCheck.provider(create2);
        SetFactory build = SetFactory.builder(3, 1).addCollectionProvider(this.a).addProvider(this.c).addProvider(this.e).addProvider(this.g).build();
        this.h = build;
        Provider<ItemBinder> provider2 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.i = provider2;
        Provider<AdapterPresenter> provider3 = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider2));
        this.j = provider3;
        this.k = DoubleCheck.provider(LandingModule_ProvideSimpleRecyclerAdapterFactory.create(provider3, this.i));
        this.l = DoubleCheck.provider(IconItemPresenter_Factory.create());
        this.m = DoubleCheck.provider(TextItemPresenter_Factory.create());
        this.n = InstanceFactory.create(fragment);
        this.o = InstanceFactory.create(str);
        this.p = new d(tariffStepDependencies);
        Provider<LandingConverter> provider4 = DoubleCheck.provider(LandingConverterImpl_Factory.create());
        this.q = provider4;
        c cVar = new c(tariffStepDependencies);
        this.r = cVar;
        LandingInteractorImpl_Factory create3 = LandingInteractorImpl_Factory.create(this.o, this.p, provider4, cVar);
        this.s = create3;
        Provider<LandingInteractor> provider5 = DoubleCheck.provider(create3);
        this.t = provider5;
        TariffLandingViewModelFactory_Factory create4 = TariffLandingViewModelFactory_Factory.create(provider5, this.r);
        this.u = create4;
        Provider<ViewModelProvider.Factory> provider6 = DoubleCheck.provider(create4);
        this.v = provider6;
        this.w = DoubleCheck.provider(LandingModule_ProvideViewModelFactory.create(this.n, provider6));
    }

    public static LandingComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.tariff.landing.di.LandingComponent
    public void inject(TariffLandingFragment tariffLandingFragment) {
        TariffLandingFragment_MembersInjector.injectRecyclerAdapter(tariffLandingFragment, this.k.get());
        TariffLandingFragment_MembersInjector.injectAdapterPresenter(tariffLandingFragment, this.j.get());
        TariffLandingFragment_MembersInjector.injectItemPresenterSet(tariffLandingFragment, SetBuilder.newSetBuilder(3).add(this.b.get()).add(this.l.get()).add(this.m.get()).build());
        TariffLandingFragment_MembersInjector.injectViewModel(tariffLandingFragment, this.w.get());
    }
}
