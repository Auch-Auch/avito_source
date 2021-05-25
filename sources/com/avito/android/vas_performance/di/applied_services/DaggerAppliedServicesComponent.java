package com.avito.android.vas_performance.di.applied_services;

import androidx.lifecycle.ViewModelProvider;
import com.avito.android.Features;
import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitlePresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas.remote.VasApi;
import com.avito.android.vas_performance.AppliedServiceConverterImpl_Factory;
import com.avito.android.vas_performance.AppliedServicesConverter;
import com.avito.android.vas_performance.di.applied_services.AppliedServicesComponent;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.repository.VasRepositoryImpl;
import com.avito.android.vas_performance.repository.VasRepositoryImpl_Factory;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesDialogFragment;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesDialogFragment_MembersInjector;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesViewModel;
import com.avito.android.vas_performance.ui.items.applied_services.AppliedServiceBlueprint;
import com.avito.android.vas_performance.ui.items.applied_services.AppliedServiceBlueprint_Factory;
import com.avito.android.vas_performance.ui.items.applied_services.AppliedServiceItemPresenter_Factory;
import com.avito.android.vas_performance.ui.items.banner.VasBundleBannerBlueprint;
import com.avito.android.vas_performance.ui.items.banner.VasBundleBannerBlueprint_Factory;
import com.avito.android.vas_performance.ui.items.banner.VasBundleBannerItemPresenter_Factory;
import com.avito.android.vas_performance.ui.items.button.ButtonItemBlueprint;
import com.avito.android.vas_performance.ui.items.button.ButtonItemBlueprint_Factory;
import com.avito.android.vas_performance.ui.items.button.ButtonItemPresenter;
import com.avito.android.vas_performance.ui.items.button.ButtonItemPresenter_Factory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerAppliedServicesComponent implements AppliedServicesComponent {
    public Provider<ItemPresenter<?, ?>> a = DoubleCheck.provider(VasBundleBannerItemPresenter_Factory.create());
    public Provider<ButtonItemPresenter> b = DoubleCheck.provider(ButtonItemPresenter_Factory.create());
    public Provider<VasApi> c;
    public Provider<SchedulersFactory> d;
    public Provider<Features> e;
    public Provider<VasRepositoryImpl> f;
    public Provider<VasRepository> g;
    public Provider<AppliedServicesConverter> h;
    public Provider<DeepLinkIntentFactory> i;
    public Provider<ViewModelProvider.Factory> j;
    public Provider<AppliedServicesViewModel> k;
    public Provider<TitlePresenter> l;
    public Provider<ItemBlueprint<?, ?>> m;
    public Provider<Set<ItemBlueprint<?, ?>>> n;
    public Provider<VasBundleBannerBlueprint> o;
    public Provider<ItemBlueprint<?, ?>> p;
    public Provider<AppliedServiceBlueprint> q;
    public Provider<ItemBlueprint<?, ?>> r;
    public Provider<ButtonItemBlueprint> s;
    public Provider<ItemBlueprint<?, ?>> t;
    public Provider<Set<ItemBlueprint<?, ?>>> u;
    public Provider<ItemBinder> v;
    public Provider<AdapterPresenter> w;

    public static final class b implements AppliedServicesComponent.Builder {
        public AppliedServicesModule a;
        public AppliedServicesDependencies b;

        public b(a aVar) {
        }

        @Override // com.avito.android.vas_performance.di.applied_services.AppliedServicesComponent.Builder
        public AppliedServicesComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AppliedServicesModule.class);
            Preconditions.checkBuilderRequirement(this.b, AppliedServicesDependencies.class);
            return new DaggerAppliedServicesComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.vas_performance.di.applied_services.AppliedServicesComponent.Builder
        public AppliedServicesComponent.Builder dependencies(AppliedServicesDependencies appliedServicesDependencies) {
            this.b = (AppliedServicesDependencies) Preconditions.checkNotNull(appliedServicesDependencies);
            return this;
        }

        @Override // com.avito.android.vas_performance.di.applied_services.AppliedServicesComponent.Builder
        public AppliedServicesComponent.Builder module(AppliedServicesModule appliedServicesModule) {
            this.a = (AppliedServicesModule) Preconditions.checkNotNull(appliedServicesModule);
            return this;
        }
    }

    public static class c implements Provider<DeepLinkIntentFactory> {
        public final AppliedServicesDependencies a;

        public c(AppliedServicesDependencies appliedServicesDependencies) {
            this.a = appliedServicesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkIntentFactory get() {
            return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory());
        }
    }

    public static class d implements Provider<Features> {
        public final AppliedServicesDependencies a;

        public d(AppliedServicesDependencies appliedServicesDependencies) {
            this.a = appliedServicesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final AppliedServicesDependencies a;

        public e(AppliedServicesDependencies appliedServicesDependencies) {
            this.a = appliedServicesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class f implements Provider<VasApi> {
        public final AppliedServicesDependencies a;

        public f(AppliedServicesDependencies appliedServicesDependencies) {
            this.a = appliedServicesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public VasApi get() {
            return (VasApi) Preconditions.checkNotNullFromComponent(this.a.vasApi());
        }
    }

    public DaggerAppliedServicesComponent(AppliedServicesModule appliedServicesModule, AppliedServicesDependencies appliedServicesDependencies, a aVar) {
        f fVar = new f(appliedServicesDependencies);
        this.c = fVar;
        e eVar = new e(appliedServicesDependencies);
        this.d = eVar;
        d dVar = new d(appliedServicesDependencies);
        this.e = dVar;
        VasRepositoryImpl_Factory create = VasRepositoryImpl_Factory.create(fVar, eVar, dVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        Provider<AppliedServicesConverter> provider = DoubleCheck.provider(AppliedServiceConverterImpl_Factory.create());
        this.h = provider;
        c cVar = new c(appliedServicesDependencies);
        this.i = cVar;
        Provider<ViewModelProvider.Factory> provider2 = DoubleCheck.provider(AppliedServicesModule_ProvideVmFactoryFactory.create(appliedServicesModule, this.g, provider, cVar, this.d));
        this.j = provider2;
        this.k = DoubleCheck.provider(AppliedServicesModule_ProvideViewModelFactory.create(appliedServicesModule, provider2));
        Provider<TitlePresenter> provider3 = DoubleCheck.provider(AppliedServicesModule_ProvideTitlePresenterFactory.create(appliedServicesModule));
        this.l = provider3;
        this.m = DoubleCheck.provider(AppliedServicesModule_ProvideTitleBlueprintFactory.create(appliedServicesModule, provider3));
        this.n = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
        VasBundleBannerBlueprint_Factory create2 = VasBundleBannerBlueprint_Factory.create(VasBundleBannerItemPresenter_Factory.create());
        this.o = create2;
        this.p = DoubleCheck.provider(create2);
        AppliedServiceBlueprint_Factory create3 = AppliedServiceBlueprint_Factory.create(AppliedServiceItemPresenter_Factory.create());
        this.q = create3;
        this.r = DoubleCheck.provider(create3);
        ButtonItemBlueprint_Factory create4 = ButtonItemBlueprint_Factory.create(this.b);
        this.s = create4;
        this.t = DoubleCheck.provider(create4);
        SetFactory build = SetFactory.builder(4, 1).addProvider(this.m).addCollectionProvider(this.n).addProvider(this.p).addProvider(this.r).addProvider(this.t).build();
        this.u = build;
        Provider<ItemBinder> provider4 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.v = provider4;
        this.w = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider4));
    }

    public static AppliedServicesComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.vas_performance.di.applied_services.AppliedServicesComponent
    public void inject(AppliedServicesDialogFragment appliedServicesDialogFragment) {
        AppliedServicesDialogFragment_MembersInjector.injectItemPresenterSet(appliedServicesDialogFragment, SetBuilder.newSetBuilder(2).add(this.a.get()).add(this.b.get()).build());
        AppliedServicesDialogFragment_MembersInjector.injectViewModel(appliedServicesDialogFragment, this.k.get());
        AppliedServicesDialogFragment_MembersInjector.injectItemBinder(appliedServicesDialogFragment, this.v.get());
        AppliedServicesDialogFragment_MembersInjector.injectAdapterPresenter(appliedServicesDialogFragment, this.w.get());
    }
}
