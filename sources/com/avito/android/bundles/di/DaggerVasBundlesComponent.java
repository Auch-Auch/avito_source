package com.avito.android.bundles.di;

import androidx.fragment.app.Fragment;
import com.avito.android.Features;
import com.avito.android.bundles.VasBundlesConverter;
import com.avito.android.bundles.VasBundlesConverterImpl_Factory;
import com.avito.android.bundles.di.VasBundlesComponent;
import com.avito.android.bundles.repository.VasBundlesRepository;
import com.avito.android.bundles.repository.VasBundlesRepositoryImpl;
import com.avito.android.bundles.repository.VasBundlesRepositoryImpl_Factory;
import com.avito.android.bundles.ui.VasBundlesFragment;
import com.avito.android.bundles.ui.VasBundlesFragment_MembersInjector;
import com.avito.android.bundles.ui.recycler.VasBundleContentComparator_Factory;
import com.avito.android.bundles.ui.recycler.item.benefit.BenefitItemPresenter;
import com.avito.android.bundles.ui.recycler.item.benefit.BenefitItemPresenterImpl;
import com.avito.android.bundles.ui.recycler.item.benefit.BenefitItemPresenterImpl_Factory;
import com.avito.android.bundles.ui.recycler.item.benefit.BundleBenefitItemBlueprint;
import com.avito.android.bundles.ui.recycler.item.benefit.BundleBenefitItemBlueprint_Factory;
import com.avito.android.bundles.ui.recycler.item.bundle.VasBundleBlueprint;
import com.avito.android.bundles.ui.recycler.item.bundle.VasBundleBlueprint_Factory;
import com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemPresenter;
import com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemPresenterImpl_Factory;
import com.avito.android.bundles.ui.recycler.item.skip_button.BundleSkipButtonItemBlueprint;
import com.avito.android.bundles.ui.recycler.item.skip_button.BundleSkipButtonItemBlueprint_Factory;
import com.avito.android.bundles.ui.recycler.item.skip_button.BundleSkipButtonItemPresenter;
import com.avito.android.bundles.ui.recycler.item.skip_button.BundleSkipButtonItemPresenterImpl_Factory;
import com.avito.android.bundles.viewmodel.VasBundlesViewModel;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.VasBundlesApi;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerVasBundlesComponent implements VasBundlesComponent {
    public Provider<Set<ItemBlueprint<?, ?>>> A;
    public Provider<ItemBinder> B;
    public Provider<AdapterPresenter> C;
    public Provider<SimpleRecyclerAdapter> D;
    public Provider<ContentsComparator> E;
    public Provider<DiffCalculator> F;
    public Provider<DataAwareAdapterPresenter> G;
    public Provider<Fragment> a;
    public Provider<String> b;
    public Provider<VasBundlesApi> c;
    public Provider<SchedulersFactory3> d;
    public Provider<VasBundlesRepositoryImpl> e;
    public Provider<VasBundlesRepository> f;
    public Provider<VasBundlesConverter> g;
    public Provider<VasBundlesViewModelFactory> h;
    public Provider<VasBundlesViewModel> i;
    public Provider<PaidServiceHeaderItemPresenter> j;
    public Provider<ItemBlueprint<?, ?>> k;
    public Provider<Set<ItemBlueprint<?, ?>>> l = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<VasBundleItemPresenter> m = DoubleCheck.provider(VasBundleItemPresenterImpl_Factory.create());
    public Provider<AttributedTextFormatter> n = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
    public Provider<Features> o;
    public Provider<BenefitItemPresenterImpl> p;
    public Provider<BenefitItemPresenter> q;
    public Provider<BundleBenefitItemBlueprint> r;
    public Provider<ItemBinder> s;
    public Provider<AdapterPresenter> t;
    public Provider<VasBundleBlueprint> u;
    public Provider<ItemBlueprint<?, ?>> v;
    public Provider<ItemBlueprint<?, ?>> w;
    public Provider<BundleSkipButtonItemPresenter> x;
    public Provider<BundleSkipButtonItemBlueprint> y;
    public Provider<ItemBlueprint<?, ?>> z;

    public static final class b implements VasBundlesComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.bundles.di.VasBundlesComponent.Factory
        public VasBundlesComponent create(String str, boolean z, String str2, Fragment fragment, VasBundlesDependencies vasBundlesDependencies) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(Boolean.valueOf(z));
            Preconditions.checkNotNull(str2);
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(vasBundlesDependencies);
            return new DaggerVasBundlesComponent(vasBundlesDependencies, str, Boolean.valueOf(z), str2, fragment, null);
        }
    }

    public static class c implements Provider<VasBundlesApi> {
        public final VasBundlesDependencies a;

        public c(VasBundlesDependencies vasBundlesDependencies) {
            this.a = vasBundlesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public VasBundlesApi get() {
            return (VasBundlesApi) Preconditions.checkNotNullFromComponent(this.a.bundlesApi());
        }
    }

    public static class d implements Provider<Features> {
        public final VasBundlesDependencies a;

        public d(VasBundlesDependencies vasBundlesDependencies) {
            this.a = vasBundlesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final VasBundlesDependencies a;

        public e(VasBundlesDependencies vasBundlesDependencies) {
            this.a = vasBundlesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerVasBundlesComponent(VasBundlesDependencies vasBundlesDependencies, String str, Boolean bool, String str2, Fragment fragment, a aVar) {
        this.a = InstanceFactory.create(fragment);
        this.b = InstanceFactory.create(str);
        c cVar = new c(vasBundlesDependencies);
        this.c = cVar;
        e eVar = new e(vasBundlesDependencies);
        this.d = eVar;
        VasBundlesRepositoryImpl_Factory create = VasBundlesRepositoryImpl_Factory.create(cVar, eVar);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        Provider<VasBundlesConverter> provider = DoubleCheck.provider(VasBundlesConverterImpl_Factory.create());
        this.g = provider;
        Provider<VasBundlesViewModelFactory> provider2 = DoubleCheck.provider(VasBundlesViewModelFactory_Factory.create(this.b, this.f, provider, this.d));
        this.h = provider2;
        this.i = DoubleCheck.provider(VasBundlesModule_ProvideViewModelFactory.create(this.a, provider2));
        Provider<PaidServiceHeaderItemPresenter> provider3 = DoubleCheck.provider(VasBundlesListModule_ProvideHeaderPresenterFactory.create());
        this.j = provider3;
        this.k = DoubleCheck.provider(VasBundlesListModule_ProvideHeaderBlueprintFactory.create(provider3));
        d dVar = new d(vasBundlesDependencies);
        this.o = dVar;
        BenefitItemPresenterImpl_Factory create2 = BenefitItemPresenterImpl_Factory.create(dVar);
        this.p = create2;
        Provider<BenefitItemPresenter> provider4 = DoubleCheck.provider(create2);
        this.q = provider4;
        BundleBenefitItemBlueprint_Factory create3 = BundleBenefitItemBlueprint_Factory.create(provider4);
        this.r = create3;
        Provider<ItemBinder> provider5 = DoubleCheck.provider(VasBundlesModule_ProvideBundleBenefitItemBinder$vas_bundles_releaseFactory.create(create3));
        this.s = provider5;
        Provider<AdapterPresenter> provider6 = DoubleCheck.provider(VasBundlesModule_ProvideBundleBenefitAdapterPresenter$vas_bundles_releaseFactory.create(provider5));
        this.t = provider6;
        VasBundleBlueprint_Factory create4 = VasBundleBlueprint_Factory.create(this.m, this.n, this.s, provider6);
        this.u = create4;
        this.v = DoubleCheck.provider(create4);
        this.w = DoubleCheck.provider(this.r);
        Provider<BundleSkipButtonItemPresenter> provider7 = DoubleCheck.provider(BundleSkipButtonItemPresenterImpl_Factory.create());
        this.x = provider7;
        BundleSkipButtonItemBlueprint_Factory create5 = BundleSkipButtonItemBlueprint_Factory.create(provider7);
        this.y = create5;
        this.z = DoubleCheck.provider(create5);
        SetFactory build = SetFactory.builder(4, 1).addProvider(this.k).addCollectionProvider(this.l).addProvider(this.v).addProvider(this.w).addProvider(this.z).build();
        this.A = build;
        Provider<ItemBinder> provider8 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.B = provider8;
        Provider<AdapterPresenter> provider9 = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider8));
        this.C = provider9;
        this.D = DoubleCheck.provider(VasBundlesModule_ProvideSimpleRecyclerAdapterFactory.create(provider9, this.B));
        Provider<ContentsComparator> provider10 = DoubleCheck.provider(VasBundleContentComparator_Factory.create());
        this.E = provider10;
        Provider<DiffCalculator> provider11 = DoubleCheck.provider(VasBundlesModule_ProvideDiffCalculatorFactory.create(provider10));
        this.F = provider11;
        this.G = DoubleCheck.provider(VasBundlesModule_ProvideDataAwareAdapterPresenter$vas_bundles_releaseFactory.create(this.D, this.C, provider11));
    }

    public static VasBundlesComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.bundles.di.VasBundlesComponent
    public void inject(VasBundlesFragment vasBundlesFragment) {
        VasBundlesFragment_MembersInjector.injectViewModel(vasBundlesFragment, this.i.get());
        VasBundlesFragment_MembersInjector.injectItemBinder(vasBundlesFragment, this.B.get());
        VasBundlesFragment_MembersInjector.injectAdapterPresenter(vasBundlesFragment, this.G.get());
        VasBundlesFragment_MembersInjector.injectRecyclerAdapter(vasBundlesFragment, this.D.get());
        VasBundlesFragment_MembersInjector.injectItemPresenterSet(vasBundlesFragment, SetBuilder.newSetBuilder(4).add(this.j.get()).add(this.m.get()).add(this.q.get()).add(this.x.get()).build());
    }
}
