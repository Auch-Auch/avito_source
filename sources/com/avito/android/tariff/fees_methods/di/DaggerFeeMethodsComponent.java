package com.avito.android.tariff.fees_methods.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.publish_limits_info.analytics.PublishLimitsAnalyticsModule_ProvideAnalyticsFactory;
import com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker;
import com.avito.android.publish_limits_info.item.LimitsInfoItemBlueprint;
import com.avito.android.publish_limits_info.item.LimitsInfoItemBlueprint_Factory;
import com.avito.android.publish_limits_info.item.LimitsInfoItemPresenter;
import com.avito.android.publish_limits_info.item.LimitsInfoItemPresenterImpl;
import com.avito.android.publish_limits_info.item.LimitsInfoItemPresenterImpl_Factory;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.TariffApi;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemBlueprint;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemBlueprint_Factory;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemPresenter;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemPresenterImpl_Factory;
import com.avito.android.tariff.fees_methods.FeesMethodsFragment;
import com.avito.android.tariff.fees_methods.FeesMethodsFragment_MembersInjector;
import com.avito.android.tariff.fees_methods.di.FeeMethodsComponent;
import com.avito.android.tariff.fees_methods.items.FeeMethodBlueprint;
import com.avito.android.tariff.fees_methods.items.FeeMethodBlueprint_Factory;
import com.avito.android.tariff.fees_methods.items.FeeMethodPresenter;
import com.avito.android.tariff.fees_methods.items.FeeMethodPresenter_Factory;
import com.avito.android.tariff.fees_methods.items.bar.BarItemBlueprint;
import com.avito.android.tariff.fees_methods.items.bar.BarItemBlueprint_Factory;
import com.avito.android.tariff.fees_methods.items.bar.BarItemPresenter_Factory;
import com.avito.android.tariff.fees_methods.items.description.FeeDescriptionItemBlueprint;
import com.avito.android.tariff.fees_methods.items.description.FeeDescriptionItemBlueprint_Factory;
import com.avito.android.tariff.fees_methods.items.description.FeeDescriptionItemPresenter_Factory;
import com.avito.android.tariff.fees_methods.items.high_demand.HighDemandBlueprint;
import com.avito.android.tariff.fees_methods.items.high_demand.HighDemandBlueprint_Factory;
import com.avito.android.tariff.fees_methods.items.high_demand.HighDemandPresenter;
import com.avito.android.tariff.fees_methods.items.high_demand.HighDemandPresenterImpl_Factory;
import com.avito.android.tariff.fees_methods.items.tariff_package.FeeMethodPackageBlueprint;
import com.avito.android.tariff.fees_methods.items.tariff_package.FeeMethodPackageBlueprint_Factory;
import com.avito.android.tariff.fees_methods.items.tariff_package.FeeMethodPackagePresenter;
import com.avito.android.tariff.fees_methods.items.tariff_package.FeeMethodPackagePresenterImpl_Factory;
import com.avito.android.tariff.fees_methods.items.title.FeeTitleItemBlueprint;
import com.avito.android.tariff.fees_methods.items.title.FeeTitleItemBlueprint_Factory;
import com.avito.android.tariff.fees_methods.items.title.FeeTitleItemPresenter_Factory;
import com.avito.android.tariff.fees_methods.limits_info.LimitsInfoItemLayoutProvider_Factory;
import com.avito.android.tariff.fees_methods.limits_info.PaidPublishLimitsInfoRepository;
import com.avito.android.tariff.fees_methods.limits_info.PaidPublishLimitsInfoRepositoryImpl;
import com.avito.android.tariff.fees_methods.limits_info.PaidPublishLimitsInfoRepositoryImpl_Factory;
import com.avito.android.tariff.fees_methods.recycler.FeeMethodsViewTypeProvider;
import com.avito.android.tariff.fees_methods.recycler.FeeMethodsViewTypeProviderImpl;
import com.avito.android.tariff.fees_methods.recycler.FeeMethodsViewTypeProviderImpl_Factory;
import com.avito.android.tariff.fees_methods.recycler.PaddingDecoration;
import com.avito.android.tariff.fees_methods.recycler.PaddingDecoration_Factory;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsConverter;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsConverterImpl;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsConverterImpl_Factory;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsRepository;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsRepositoryImpl;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsRepositoryImpl_Factory;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModel;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModelFactory;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModelFactory_Factory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerFeeMethodsComponent implements FeeMethodsComponent {
    public Provider<BarItemBlueprint> A;
    public Provider<ItemBlueprint<?, ?>> B;
    public Provider<Set<ItemBlueprint<?, ?>>> C;
    public Provider<ItemBinder> D;
    public Provider<FeeMethodsViewTypeProviderImpl> E;
    public Provider<FeeMethodsViewTypeProvider> F;
    public Provider<AdapterPresenter> G;
    public Provider<ItemPresenter<?, ?>> H;
    public Provider<ItemPresenter<?, ?>> I;
    public Provider<ItemPresenter<?, ?>> J;
    public Provider<Fragment> K;
    public Provider<String> L;
    public Provider<TariffApi> M;
    public Provider<SchedulersFactory3> N;
    public Provider<Features> O;
    public Provider<PublishLimitsApi> P;
    public Provider<PaidPublishLimitsInfoRepositoryImpl> Q;
    public Provider<PaidPublishLimitsInfoRepository> R;
    public Provider<FeeMethodsRepositoryImpl> S;
    public Provider<FeeMethodsRepository> T;
    public Provider<FeeMethodsConverterImpl> U;
    public Provider<FeeMethodsConverter> V;
    public Provider<SchedulersFactory> W;
    public Provider<Boolean> X;
    public Provider<FeeMethodsViewModelFactory> Y;
    public Provider<ViewModelProvider.Factory> Z;
    public final TariffStepDependencies a;
    public Provider<FeeMethodsViewModel> a0;
    public Provider<FeeTitleItemBlueprint> b;
    public Provider<Resources> b0;
    public Provider<ItemBlueprint<?, ?>> c;
    public Provider<PaddingDecoration> c0;
    public Provider<FeeDescriptionItemBlueprint> d;
    public Provider<RecyclerView.ItemDecoration> d0;
    public Provider<ItemBlueprint<?, ?>> e;
    public Provider<Analytics> f;
    public Provider<PublishLimitsEventTracker> g;
    public Provider<LimitsInfoItemPresenterImpl> h;
    public Provider<LimitsInfoItemPresenter> i;
    public Provider<AttributedTextFormatter> j;
    public Provider<LimitsInfoItemBlueprint.LayoutProvider> k;
    public Provider<LimitsInfoItemBlueprint> l;
    public Provider<ItemBlueprint<?, ?>> m;
    public Provider<FeeMethodPresenter> n;
    public Provider<FeeMethodBlueprint> o;
    public Provider<ItemBlueprint<?, ?>> p;
    public Provider<HighDemandPresenter> q;
    public Provider<HighDemandBlueprint> r;
    public Provider<ItemBlueprint<?, ?>> s;
    public Provider<FeeMethodPackagePresenter> t = DoubleCheck.provider(FeeMethodPackagePresenterImpl_Factory.create());
    public Provider<MicroCategoryItemPresenter> u;
    public Provider<MicroCategoryItemBlueprint> v;
    public Provider<ItemBinder> w;
    public Provider<AdapterPresenter> x;
    public Provider<FeeMethodPackageBlueprint> y;
    public Provider<ItemBlueprint<?, ?>> z;

    public static final class b implements FeeMethodsComponent.Builder {
        public TariffStepDependencies a;
        public String b;
        public Boolean c;
        public Fragment d;
        public Resources e;

        public b(a aVar) {
        }

        @Override // com.avito.android.tariff.fees_methods.di.FeeMethodsComponent.Builder
        public FeeMethodsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, TariffStepDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, Boolean.class);
            Preconditions.checkBuilderRequirement(this.d, Fragment.class);
            Preconditions.checkBuilderRequirement(this.e, Resources.class);
            return new DaggerFeeMethodsComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.tariff.fees_methods.di.FeeMethodsComponent.Builder
        public FeeMethodsComponent.Builder checkoutContext(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.tariff.fees_methods.di.FeeMethodsComponent.Builder
        public FeeMethodsComponent.Builder dependencies(TariffStepDependencies tariffStepDependencies) {
            this.a = (TariffStepDependencies) Preconditions.checkNotNull(tariffStepDependencies);
            return this;
        }

        @Override // com.avito.android.tariff.fees_methods.di.FeeMethodsComponent.Builder
        public FeeMethodsComponent.Builder fragment(Fragment fragment) {
            this.d = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.tariff.fees_methods.di.FeeMethodsComponent.Builder
        public FeeMethodsComponent.Builder isClosable(boolean z) {
            this.c = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.tariff.fees_methods.di.FeeMethodsComponent.Builder
        public FeeMethodsComponent.Builder resources(Resources resources) {
            this.e = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final TariffStepDependencies a;

        public c(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<AttributedTextFormatter> {
        public final TariffStepDependencies a;

        public d(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AttributedTextFormatter get() {
            return (AttributedTextFormatter) Preconditions.checkNotNullFromComponent(this.a.attributedTextFormatter());
        }
    }

    public static class e implements Provider<Features> {
        public final TariffStepDependencies a;

        public e(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<PublishLimitsApi> {
        public final TariffStepDependencies a;

        public f(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishLimitsApi get() {
            return (PublishLimitsApi) Preconditions.checkNotNullFromComponent(this.a.publishLimitsApi());
        }
    }

    public static class g implements Provider<SchedulersFactory3> {
        public final TariffStepDependencies a;

        public g(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class h implements Provider<SchedulersFactory> {
        public final TariffStepDependencies a;

        public h(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class i implements Provider<TariffApi> {
        public final TariffStepDependencies a;

        public i(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TariffApi get() {
            return (TariffApi) Preconditions.checkNotNullFromComponent(this.a.tariffApi());
        }
    }

    public DaggerFeeMethodsComponent(TariffStepDependencies tariffStepDependencies, String str, Boolean bool, Fragment fragment, Resources resources, a aVar) {
        this.a = tariffStepDependencies;
        FeeTitleItemBlueprint_Factory create = FeeTitleItemBlueprint_Factory.create(FeeTitleItemPresenter_Factory.create());
        this.b = create;
        this.c = DoubleCheck.provider(create);
        FeeDescriptionItemBlueprint_Factory create2 = FeeDescriptionItemBlueprint_Factory.create(FeeDescriptionItemPresenter_Factory.create());
        this.d = create2;
        this.e = DoubleCheck.provider(create2);
        c cVar = new c(tariffStepDependencies);
        this.f = cVar;
        PublishLimitsAnalyticsModule_ProvideAnalyticsFactory create3 = PublishLimitsAnalyticsModule_ProvideAnalyticsFactory.create(cVar);
        this.g = create3;
        LimitsInfoItemPresenterImpl_Factory create4 = LimitsInfoItemPresenterImpl_Factory.create(create3);
        this.h = create4;
        this.i = DoubleCheck.provider(create4);
        this.j = new d(tariffStepDependencies);
        Provider<LimitsInfoItemBlueprint.LayoutProvider> provider = DoubleCheck.provider(LimitsInfoItemLayoutProvider_Factory.create());
        this.k = provider;
        LimitsInfoItemBlueprint_Factory create5 = LimitsInfoItemBlueprint_Factory.create(this.i, this.j, provider);
        this.l = create5;
        this.m = DoubleCheck.provider(create5);
        Provider<FeeMethodPresenter> provider2 = DoubleCheck.provider(FeeMethodPresenter_Factory.create());
        this.n = provider2;
        FeeMethodBlueprint_Factory create6 = FeeMethodBlueprint_Factory.create(provider2);
        this.o = create6;
        this.p = DoubleCheck.provider(create6);
        Provider<HighDemandPresenter> provider3 = DoubleCheck.provider(HighDemandPresenterImpl_Factory.create());
        this.q = provider3;
        HighDemandBlueprint_Factory create7 = HighDemandBlueprint_Factory.create(provider3, this.j);
        this.r = create7;
        this.s = DoubleCheck.provider(create7);
        Provider<MicroCategoryItemPresenter> provider4 = DoubleCheck.provider(MicroCategoryItemPresenterImpl_Factory.create());
        this.u = provider4;
        MicroCategoryItemBlueprint_Factory create8 = MicroCategoryItemBlueprint_Factory.create(provider4);
        this.v = create8;
        Provider<ItemBinder> provider5 = DoubleCheck.provider(FeeMethodsModule_ProvideMicroCategoryItemBinder$tariff_releaseFactory.create(create8));
        this.w = provider5;
        Provider<AdapterPresenter> provider6 = DoubleCheck.provider(FeeMethodsModule_ProvideMicroCategoryAdapterPresenter$tariff_releaseFactory.create(provider5));
        this.x = provider6;
        FeeMethodPackageBlueprint_Factory create9 = FeeMethodPackageBlueprint_Factory.create(this.t, provider6, this.w);
        this.y = create9;
        this.z = DoubleCheck.provider(create9);
        BarItemBlueprint_Factory create10 = BarItemBlueprint_Factory.create(BarItemPresenter_Factory.create());
        this.A = create10;
        this.B = DoubleCheck.provider(create10);
        SetFactory build = SetFactory.builder(7, 0).addProvider(this.c).addProvider(this.e).addProvider(this.m).addProvider(this.p).addProvider(this.s).addProvider(this.z).addProvider(this.B).build();
        this.C = build;
        this.D = DoubleCheck.provider(FeeMethodsModule_ProvideItemBinder$tariff_releaseFactory.create(build));
        FeeMethodsViewTypeProviderImpl_Factory create11 = FeeMethodsViewTypeProviderImpl_Factory.create(this.C);
        this.E = create11;
        Provider<FeeMethodsViewTypeProvider> provider7 = DoubleCheck.provider(create11);
        this.F = provider7;
        this.G = DoubleCheck.provider(FeeMethodsModule_ProvideAdapterPresenter$tariff_releaseFactory.create(this.D, provider7));
        this.H = DoubleCheck.provider(FeeTitleItemPresenter_Factory.create());
        this.I = DoubleCheck.provider(FeeDescriptionItemPresenter_Factory.create());
        this.J = DoubleCheck.provider(BarItemPresenter_Factory.create());
        this.K = InstanceFactory.create(fragment);
        this.L = InstanceFactory.create(str);
        this.M = new i(tariffStepDependencies);
        g gVar = new g(tariffStepDependencies);
        this.N = gVar;
        this.O = new e(tariffStepDependencies);
        f fVar = new f(tariffStepDependencies);
        this.P = fVar;
        PaidPublishLimitsInfoRepositoryImpl_Factory create12 = PaidPublishLimitsInfoRepositoryImpl_Factory.create(fVar, gVar);
        this.Q = create12;
        Provider<PaidPublishLimitsInfoRepository> provider8 = DoubleCheck.provider(create12);
        this.R = provider8;
        FeeMethodsRepositoryImpl_Factory create13 = FeeMethodsRepositoryImpl_Factory.create(this.M, this.N, this.O, provider8);
        this.S = create13;
        this.T = DoubleCheck.provider(create13);
        FeeMethodsConverterImpl_Factory create14 = FeeMethodsConverterImpl_Factory.create(this.j, this.O);
        this.U = create14;
        this.V = DoubleCheck.provider(create14);
        this.W = new h(tariffStepDependencies);
        Factory create15 = InstanceFactory.create(bool);
        this.X = create15;
        FeeMethodsViewModelFactory_Factory create16 = FeeMethodsViewModelFactory_Factory.create(this.L, this.T, this.V, this.W, create15, this.g);
        this.Y = create16;
        Provider<ViewModelProvider.Factory> provider9 = DoubleCheck.provider(create16);
        this.Z = provider9;
        this.a0 = DoubleCheck.provider(FeeMethodsModule_ProvideViewModelFactory.create(this.K, provider9));
        Factory create17 = InstanceFactory.create(resources);
        this.b0 = create17;
        PaddingDecoration_Factory create18 = PaddingDecoration_Factory.create(create17, this.F);
        this.c0 = create18;
        this.d0 = DoubleCheck.provider(create18);
    }

    public static FeeMethodsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.tariff.fees_methods.di.FeeMethodsComponent
    public void inject(FeesMethodsFragment feesMethodsFragment) {
        FeesMethodsFragment_MembersInjector.injectItemBinder(feesMethodsFragment, this.D.get());
        FeesMethodsFragment_MembersInjector.injectAdapterPresenter(feesMethodsFragment, this.G.get());
        FeesMethodsFragment_MembersInjector.injectItemPresenterSet(feesMethodsFragment, SetBuilder.newSetBuilder(7).add(this.H.get()).add(this.I.get()).add(this.i.get()).add(this.n.get()).add(this.q.get()).add(this.t.get()).add(this.J.get()).build());
        FeesMethodsFragment_MembersInjector.injectViewModel(feesMethodsFragment, this.a0.get());
        FeesMethodsFragment_MembersInjector.injectItemDecoration(feesMethodsFragment, this.d0.get());
        FeesMethodsFragment_MembersInjector.injectAttributedTextFormatter(feesMethodsFragment, (AttributedTextFormatter) Preconditions.checkNotNullFromComponent(this.a.attributedTextFormatter()));
    }
}
