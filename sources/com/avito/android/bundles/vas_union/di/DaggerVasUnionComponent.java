package com.avito.android.bundles.vas_union.di;

import androidx.fragment.app.Fragment;
import com.avito.android.Features;
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
import com.avito.android.bundles.vas_union.VasUnionConverter;
import com.avito.android.bundles.vas_union.VasUnionConverterImpl_Factory;
import com.avito.android.bundles.vas_union.VasUnionFragment;
import com.avito.android.bundles.vas_union.VasUnionFragment_MembersInjector;
import com.avito.android.bundles.vas_union.di.VasUnionComponent;
import com.avito.android.bundles.vas_union.item.performance.description.PerformanceDescriptionBlueprint;
import com.avito.android.bundles.vas_union.item.performance.description.PerformanceDescriptionBlueprint_Factory;
import com.avito.android.bundles.vas_union.item.performance.description.PerformanceDescriptionPresenter;
import com.avito.android.bundles.vas_union.item.performance.description.PerformanceDescriptionPresenterImpl_Factory;
import com.avito.android.bundles.vas_union.item.performance.info_action.InfoActionItemBlueprint;
import com.avito.android.bundles.vas_union.item.performance.info_action.InfoActionItemBlueprint_Factory;
import com.avito.android.bundles.vas_union.item.performance.info_action.InfoActionItemPresenter;
import com.avito.android.bundles.vas_union.item.performance.info_action.InfoActionItemPresenterImpl_Factory;
import com.avito.android.bundles.vas_union.item.performance.tabs.PerformanceTabsItemBlueprint;
import com.avito.android.bundles.vas_union.item.performance.tabs.PerformanceTabsItemBlueprint_Factory;
import com.avito.android.bundles.vas_union.item.performance.tabs.PerformanceTabsItemPresenter;
import com.avito.android.bundles.vas_union.item.performance.tabs.PerformanceTabsItemPresenterImpl_Factory;
import com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasBlueprint;
import com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasBlueprint_Factory;
import com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasItemPresenter;
import com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasItemPresenterImpl_Factory;
import com.avito.android.bundles.vas_union.item.tabs.TabsItemBlueprint;
import com.avito.android.bundles.vas_union.item.tabs.TabsItemBlueprint_Factory;
import com.avito.android.bundles.vas_union.item.tabs.TabsItemPresenter;
import com.avito.android.bundles.vas_union.item.tabs.TabsItemPresenterImpl_Factory;
import com.avito.android.bundles.vas_union.item.union_title.VasUnionTitleItemBlueprint;
import com.avito.android.bundles.vas_union.item.union_title.VasUnionTitleItemBlueprint_Factory;
import com.avito.android.bundles.vas_union.item.union_title.VasUnionTitleItemPresenter;
import com.avito.android.bundles.vas_union.item.union_title.VasUnionTitleItemPresenterImpl_Factory;
import com.avito.android.bundles.vas_union.repository.VasUnionRepository;
import com.avito.android.bundles.vas_union.repository.VasUnionRepositoryImpl;
import com.avito.android.bundles.vas_union.repository.VasUnionRepositoryImpl_Factory;
import com.avito.android.bundles.vas_union.viewmodel.VasUnionViewModel;
import com.avito.android.bundles.vas_union.viewmodel.VasUnionViewModelFactory;
import com.avito.android.bundles.vas_union.viewmodel.VasUnionViewModelFactory_Factory;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.remote.VasUnionApi;
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
public final class DaggerVasUnionComponent implements VasUnionComponent {
    public Provider<AdapterPresenter> A;
    public Provider<VasBundleBlueprint> B;
    public Provider<ItemBlueprint<?, ?>> C;
    public Provider<ItemBlueprint<?, ?>> D;
    public Provider<BundleSkipButtonItemPresenter> E;
    public Provider<BundleSkipButtonItemBlueprint> F;
    public Provider<ItemBlueprint<?, ?>> G;
    public Provider<PerformanceTabsItemPresenter> H;
    public Provider<PerformanceTabsItemBlueprint> I;
    public Provider<ItemBlueprint<?, ?>> J;
    public Provider<PerformanceVasItemPresenter> K;
    public Provider<PerformanceVasBlueprint> L;
    public Provider<ItemBlueprint<?, ?>> M;
    public Provider<InfoActionItemPresenter> N;
    public Provider<InfoActionItemBlueprint> O;
    public Provider<ItemBlueprint<?, ?>> P;
    public Provider<PerformanceDescriptionPresenter> Q;
    public Provider<PerformanceDescriptionBlueprint> R;
    public Provider<ItemBlueprint<?, ?>> S;
    public Provider<Set<ItemBlueprint<?, ?>>> T;
    public Provider<ItemBinder> U;
    public Provider<AdapterPresenter> V;
    public Provider<SimpleRecyclerAdapter> W;
    public final VasUnionDependencies a;
    public Provider<Fragment> b;
    public Provider<String> c;
    public Provider<VasUnionApi> d;
    public Provider<SchedulersFactory3> e;
    public Provider<VasUnionRepositoryImpl> f;
    public Provider<VasUnionRepository> g;
    public Provider<VasUnionConverter> h;
    public Provider<VasUnionViewModelFactory> i;
    public Provider<VasUnionViewModel> j;
    public Provider<Set<ItemBlueprint<?, ?>>> k = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PaidServiceHeaderItemPresenter> l;
    public Provider<ItemBlueprint<?, ?>> m;
    public Provider<VasUnionTitleItemPresenter> n;
    public Provider<VasUnionTitleItemBlueprint> o;
    public Provider<ItemBlueprint<?, ?>> p;
    public Provider<TabsItemPresenter> q;
    public Provider<TabsItemBlueprint> r;
    public Provider<ItemBlueprint<?, ?>> s;
    public Provider<VasBundleItemPresenter> t;
    public Provider<AttributedTextFormatter> u;
    public Provider<Features> v;
    public Provider<BenefitItemPresenterImpl> w;
    public Provider<BenefitItemPresenter> x;
    public Provider<BundleBenefitItemBlueprint> y;
    public Provider<ItemBinder> z;

    public static final class b implements VasUnionComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.bundles.vas_union.di.VasUnionComponent.Factory
        public VasUnionComponent create(String str, boolean z, String str2, Fragment fragment, VasUnionDependencies vasUnionDependencies) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(Boolean.valueOf(z));
            Preconditions.checkNotNull(str2);
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(vasUnionDependencies);
            return new DaggerVasUnionComponent(new VasPerformanceListModule(), vasUnionDependencies, str, Boolean.valueOf(z), str2, fragment, null);
        }
    }

    public static class c implements Provider<Features> {
        public final VasUnionDependencies a;

        public c(VasUnionDependencies vasUnionDependencies) {
            this.a = vasUnionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final VasUnionDependencies a;

        public d(VasUnionDependencies vasUnionDependencies) {
            this.a = vasUnionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class e implements Provider<VasUnionApi> {
        public final VasUnionDependencies a;

        public e(VasUnionDependencies vasUnionDependencies) {
            this.a = vasUnionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public VasUnionApi get() {
            return (VasUnionApi) Preconditions.checkNotNullFromComponent(this.a.vasUnionApi());
        }
    }

    public DaggerVasUnionComponent(VasPerformanceListModule vasPerformanceListModule, VasUnionDependencies vasUnionDependencies, String str, Boolean bool, String str2, Fragment fragment, a aVar) {
        this.a = vasUnionDependencies;
        this.b = InstanceFactory.create(fragment);
        this.c = InstanceFactory.create(str);
        e eVar = new e(vasUnionDependencies);
        this.d = eVar;
        d dVar = new d(vasUnionDependencies);
        this.e = dVar;
        VasUnionRepositoryImpl_Factory create = VasUnionRepositoryImpl_Factory.create(eVar, dVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        Provider<VasUnionConverter> provider = DoubleCheck.provider(VasUnionConverterImpl_Factory.create());
        this.h = provider;
        Provider<VasUnionViewModelFactory> provider2 = DoubleCheck.provider(VasUnionViewModelFactory_Factory.create(this.c, this.g, provider, this.e));
        this.i = provider2;
        this.j = DoubleCheck.provider(VasUnionModule_ProvideViewModelFactory.create(this.b, provider2));
        Provider<PaidServiceHeaderItemPresenter> provider3 = DoubleCheck.provider(VasPerformanceListModule_ProvideHeaderPresenterFactory.create(vasPerformanceListModule));
        this.l = provider3;
        this.m = DoubleCheck.provider(VasPerformanceListModule_ProvideHeaderBlueprintFactory.create(vasPerformanceListModule, provider3));
        Provider<VasUnionTitleItemPresenter> provider4 = DoubleCheck.provider(VasUnionTitleItemPresenterImpl_Factory.create());
        this.n = provider4;
        VasUnionTitleItemBlueprint_Factory create2 = VasUnionTitleItemBlueprint_Factory.create(provider4);
        this.o = create2;
        this.p = DoubleCheck.provider(create2);
        Provider<TabsItemPresenter> provider5 = DoubleCheck.provider(TabsItemPresenterImpl_Factory.create());
        this.q = provider5;
        TabsItemBlueprint_Factory create3 = TabsItemBlueprint_Factory.create(provider5);
        this.r = create3;
        this.s = DoubleCheck.provider(create3);
        this.t = DoubleCheck.provider(VasBundleItemPresenterImpl_Factory.create());
        this.u = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        c cVar = new c(vasUnionDependencies);
        this.v = cVar;
        BenefitItemPresenterImpl_Factory create4 = BenefitItemPresenterImpl_Factory.create(cVar);
        this.w = create4;
        Provider<BenefitItemPresenter> provider6 = DoubleCheck.provider(create4);
        this.x = provider6;
        BundleBenefitItemBlueprint_Factory create5 = BundleBenefitItemBlueprint_Factory.create(provider6);
        this.y = create5;
        Provider<ItemBinder> provider7 = DoubleCheck.provider(VasUnionModule_ProvideBundleBenefitItemBinder$vas_bundles_releaseFactory.create(create5));
        this.z = provider7;
        Provider<AdapterPresenter> provider8 = DoubleCheck.provider(VasUnionModule_ProvideBundleBenefitAdapterPresenter$vas_bundles_releaseFactory.create(provider7));
        this.A = provider8;
        VasBundleBlueprint_Factory create6 = VasBundleBlueprint_Factory.create(this.t, this.u, this.z, provider8);
        this.B = create6;
        this.C = DoubleCheck.provider(create6);
        this.D = DoubleCheck.provider(this.y);
        Provider<BundleSkipButtonItemPresenter> provider9 = DoubleCheck.provider(BundleSkipButtonItemPresenterImpl_Factory.create());
        this.E = provider9;
        BundleSkipButtonItemBlueprint_Factory create7 = BundleSkipButtonItemBlueprint_Factory.create(provider9);
        this.F = create7;
        this.G = DoubleCheck.provider(create7);
        Provider<PerformanceTabsItemPresenter> provider10 = DoubleCheck.provider(PerformanceTabsItemPresenterImpl_Factory.create());
        this.H = provider10;
        PerformanceTabsItemBlueprint_Factory create8 = PerformanceTabsItemBlueprint_Factory.create(provider10);
        this.I = create8;
        this.J = DoubleCheck.provider(create8);
        Provider<PerformanceVasItemPresenter> provider11 = DoubleCheck.provider(PerformanceVasItemPresenterImpl_Factory.create());
        this.K = provider11;
        PerformanceVasBlueprint_Factory create9 = PerformanceVasBlueprint_Factory.create(provider11, this.u);
        this.L = create9;
        this.M = DoubleCheck.provider(create9);
        Provider<InfoActionItemPresenter> provider12 = DoubleCheck.provider(InfoActionItemPresenterImpl_Factory.create());
        this.N = provider12;
        InfoActionItemBlueprint_Factory create10 = InfoActionItemBlueprint_Factory.create(provider12);
        this.O = create10;
        this.P = DoubleCheck.provider(create10);
        Provider<PerformanceDescriptionPresenter> provider13 = DoubleCheck.provider(PerformanceDescriptionPresenterImpl_Factory.create());
        this.Q = provider13;
        PerformanceDescriptionBlueprint_Factory create11 = PerformanceDescriptionBlueprint_Factory.create(provider13);
        this.R = create11;
        this.S = DoubleCheck.provider(create11);
        SetFactory build = SetFactory.builder(10, 1).addCollectionProvider(this.k).addProvider(this.m).addProvider(this.p).addProvider(this.s).addProvider(this.C).addProvider(this.D).addProvider(this.G).addProvider(this.J).addProvider(this.M).addProvider(this.P).addProvider(this.S).build();
        this.T = build;
        Provider<ItemBinder> provider14 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.U = provider14;
        Provider<AdapterPresenter> provider15 = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider14));
        this.V = provider15;
        this.W = DoubleCheck.provider(VasUnionModule_ProvideSimpleRecyclerAdapterFactory.create(provider15, this.U));
    }

    public static VasUnionComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.bundles.vas_union.di.VasUnionComponent
    public void inject(VasUnionFragment vasUnionFragment) {
        VasUnionFragment_MembersInjector.injectViewModel(vasUnionFragment, this.j.get());
        VasUnionFragment_MembersInjector.injectItemBinder(vasUnionFragment, this.U.get());
        VasUnionFragment_MembersInjector.injectDeepLinkIntentFactory(vasUnionFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        VasUnionFragment_MembersInjector.injectAdapterPresenter(vasUnionFragment, this.V.get());
        VasUnionFragment_MembersInjector.injectRecyclerAdapter(vasUnionFragment, this.W.get());
        VasUnionFragment_MembersInjector.injectItemPresenterSet(vasUnionFragment, SetBuilder.newSetBuilder(9).add(this.q.get()).add(this.l.get()).add(this.t.get()).add(this.x.get()).add(this.E.get()).add(this.H.get()).add(this.K.get()).add(this.N.get()).add(this.l.get()).build());
    }
}
