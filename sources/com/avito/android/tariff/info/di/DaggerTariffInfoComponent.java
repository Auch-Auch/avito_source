package com.avito.android.tariff.info.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.remote.TariffApi;
import com.avito.android.tariff.StringProvider;
import com.avito.android.tariff.di.HeaderModule_ProvideHeaderBlueprintFactory;
import com.avito.android.tariff.di.HeaderModule_ProvideHeaderPresenterFactory;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.info.TariffInfoFragment;
import com.avito.android.tariff.info.TariffInfoFragment_MembersInjector;
import com.avito.android.tariff.info.di.TariffInfoComponent;
import com.avito.android.tariff.info.item.disclaimer.DisclaimerItemBlueprint;
import com.avito.android.tariff.info.item.disclaimer.DisclaimerItemBlueprint_Factory;
import com.avito.android.tariff.info.item.disclaimer.DisclaimerItemPresenter;
import com.avito.android.tariff.info.item.disclaimer.DisclaimerItemPresenterImpl_Factory;
import com.avito.android.tariff.info.item.info.InfoItemBlueprint;
import com.avito.android.tariff.info.item.info.InfoItemBlueprint_Factory;
import com.avito.android.tariff.info.item.info.InfoItemPresenter;
import com.avito.android.tariff.info.item.info.InfoItemPresenterImpl_Factory;
import com.avito.android.tariff.info.item.package_info.PackageInfoItemBlueprint;
import com.avito.android.tariff.info.item.package_info.PackageInfoItemBlueprint_Factory;
import com.avito.android.tariff.info.item.package_info.PackageInfoItemPresenter;
import com.avito.android.tariff.info.item.package_info.PackageInfoItemPresenterImpl_Factory;
import com.avito.android.tariff.info.item.package_title.PackageTitleItemBlueprint;
import com.avito.android.tariff.info.item.package_title.PackageTitleItemBlueprint_Factory;
import com.avito.android.tariff.info.item.package_title.PackageTitleItemPresenter;
import com.avito.android.tariff.info.item.package_title.PackageTitleItemPresenterImpl_Factory;
import com.avito.android.tariff.info.ui.TariffInfoViewTypeProvider;
import com.avito.android.tariff.info.ui.TariffInfoViewTypeProviderImpl;
import com.avito.android.tariff.info.ui.TariffInfoViewTypeProviderImpl_Factory;
import com.avito.android.tariff.info.viewmodel.TariffInfoConverter;
import com.avito.android.tariff.info.viewmodel.TariffInfoConverterImpl;
import com.avito.android.tariff.info.viewmodel.TariffInfoConverterImpl_Factory;
import com.avito.android.tariff.info.viewmodel.TariffInfoRepository;
import com.avito.android.tariff.info.viewmodel.TariffInfoRepositoryImpl;
import com.avito.android.tariff.info.viewmodel.TariffInfoRepositoryImpl_Factory;
import com.avito.android.tariff.info.viewmodel.TariffInfoViewModel;
import com.avito.android.tariff.info.viewmodel.TariffInfoViewModelFactory;
import com.avito.android.tariff.info.viewmodel.TariffInfoViewModelFactory_Factory;
import com.avito.android.tariff.view.TariffBarConverter;
import com.avito.android.tariff.view.TariffBarConverterImpl_Factory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerTariffInfoComponent implements TariffInfoComponent {
    public Provider<AttributedTextFormatter> A;
    public Provider<TariffBarConverter> B;
    public Provider<TariffInfoConverterImpl> C;
    public Provider<TariffInfoConverter> D;
    public Provider<StringProvider> E;
    public Provider<TariffInfoViewModelFactory> F;
    public Provider<ViewModelProvider.Factory> G;
    public Provider<TariffInfoViewModel> H;
    public Provider<PaidServiceHeaderItemPresenter> a;
    public Provider<ItemBlueprint<?, ?>> b;
    public Provider<PackageInfoItemPresenter> c;
    public Provider<PackageInfoItemBlueprint> d;
    public Provider<ItemBlueprint<?, ?>> e;
    public Provider<DisclaimerItemPresenter> f;
    public Provider<DisclaimerItemBlueprint> g;
    public Provider<ItemBlueprint<?, ?>> h;
    public Provider<InfoItemPresenter> i;
    public Provider<InfoItemBlueprint> j;
    public Provider<ItemBlueprint<?, ?>> k;
    public Provider<PackageTitleItemPresenter> l;
    public Provider<PackageTitleItemBlueprint> m;
    public Provider<ItemBlueprint<?, ?>> n;
    public Provider<Set<ItemBlueprint<?, ?>>> o;
    public Provider<ItemBinder> p;
    public Provider<TariffInfoViewTypeProviderImpl> q;
    public Provider<TariffInfoViewTypeProvider> r;
    public Provider<AdapterPresenter> s;
    public Provider<SimpleRecyclerAdapter> t;
    public Provider<Fragment> u;
    public Provider<String> v;
    public Provider<TariffApi> w;
    public Provider<SchedulersFactory> x;
    public Provider<TariffInfoRepositoryImpl> y;
    public Provider<TariffInfoRepository> z;

    public static final class b implements TariffInfoComponent.Builder {
        public TariffStepDependencies a;
        public Fragment b;
        public String c;

        public b(a aVar) {
        }

        @Override // com.avito.android.tariff.info.di.TariffInfoComponent.Builder
        public TariffInfoComponent build() {
            Preconditions.checkBuilderRequirement(this.a, TariffStepDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Fragment.class);
            Preconditions.checkBuilderRequirement(this.c, String.class);
            return new DaggerTariffInfoComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.tariff.info.di.TariffInfoComponent.Builder
        public TariffInfoComponent.Builder dependentOn(TariffStepDependencies tariffStepDependencies) {
            this.a = (TariffStepDependencies) Preconditions.checkNotNull(tariffStepDependencies);
            return this;
        }

        @Override // com.avito.android.tariff.info.di.TariffInfoComponent.Builder
        public TariffInfoComponent.Builder with(Fragment fragment) {
            this.b = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.tariff.info.di.TariffInfoComponent.Builder
        public TariffInfoComponent.Builder with(String str) {
            this.c = (String) Preconditions.checkNotNull(str);
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

    public DaggerTariffInfoComponent(TariffStepDependencies tariffStepDependencies, Fragment fragment, String str, a aVar) {
        Provider<PaidServiceHeaderItemPresenter> provider = DoubleCheck.provider(HeaderModule_ProvideHeaderPresenterFactory.create());
        this.a = provider;
        this.b = DoubleCheck.provider(HeaderModule_ProvideHeaderBlueprintFactory.create(provider));
        Provider<PackageInfoItemPresenter> provider2 = DoubleCheck.provider(PackageInfoItemPresenterImpl_Factory.create());
        this.c = provider2;
        PackageInfoItemBlueprint_Factory create = PackageInfoItemBlueprint_Factory.create(provider2);
        this.d = create;
        this.e = DoubleCheck.provider(create);
        Provider<DisclaimerItemPresenter> provider3 = DoubleCheck.provider(DisclaimerItemPresenterImpl_Factory.create());
        this.f = provider3;
        DisclaimerItemBlueprint_Factory create2 = DisclaimerItemBlueprint_Factory.create(provider3);
        this.g = create2;
        this.h = DoubleCheck.provider(create2);
        Provider<InfoItemPresenter> provider4 = DoubleCheck.provider(InfoItemPresenterImpl_Factory.create());
        this.i = provider4;
        InfoItemBlueprint_Factory create3 = InfoItemBlueprint_Factory.create(provider4);
        this.j = create3;
        this.k = DoubleCheck.provider(create3);
        Provider<PackageTitleItemPresenter> provider5 = DoubleCheck.provider(PackageTitleItemPresenterImpl_Factory.create());
        this.l = provider5;
        PackageTitleItemBlueprint_Factory create4 = PackageTitleItemBlueprint_Factory.create(provider5);
        this.m = create4;
        this.n = DoubleCheck.provider(create4);
        SetFactory build = SetFactory.builder(5, 0).addProvider(this.b).addProvider(this.e).addProvider(this.h).addProvider(this.k).addProvider(this.n).build();
        this.o = build;
        this.p = DoubleCheck.provider(TariffInfoModule_ProvideItemBinder$tariff_releaseFactory.create(build));
        TariffInfoViewTypeProviderImpl_Factory create5 = TariffInfoViewTypeProviderImpl_Factory.create(this.o);
        this.q = create5;
        Provider<TariffInfoViewTypeProvider> provider6 = DoubleCheck.provider(create5);
        this.r = provider6;
        Provider<AdapterPresenter> provider7 = DoubleCheck.provider(TariffInfoModule_ProvideAdapterPresenter$tariff_releaseFactory.create(this.p, provider6));
        this.s = provider7;
        this.t = DoubleCheck.provider(TariffInfoModule_ProvideSimpleRecyclerAdapterFactory.create(provider7, this.p));
        this.u = InstanceFactory.create(fragment);
        this.v = InstanceFactory.create(str);
        f fVar = new f(tariffStepDependencies);
        this.w = fVar;
        d dVar = new d(tariffStepDependencies);
        this.x = dVar;
        TariffInfoRepositoryImpl_Factory create6 = TariffInfoRepositoryImpl_Factory.create(fVar, dVar);
        this.y = create6;
        this.z = DoubleCheck.provider(create6);
        this.A = new c(tariffStepDependencies);
        Provider<TariffBarConverter> provider8 = DoubleCheck.provider(TariffBarConverterImpl_Factory.create());
        this.B = provider8;
        TariffInfoConverterImpl_Factory create7 = TariffInfoConverterImpl_Factory.create(this.A, provider8);
        this.C = create7;
        Provider<TariffInfoConverter> provider9 = DoubleCheck.provider(create7);
        this.D = provider9;
        e eVar = new e(tariffStepDependencies);
        this.E = eVar;
        TariffInfoViewModelFactory_Factory create8 = TariffInfoViewModelFactory_Factory.create(this.v, this.z, provider9, eVar, this.x);
        this.F = create8;
        Provider<ViewModelProvider.Factory> provider10 = DoubleCheck.provider(create8);
        this.G = provider10;
        this.H = DoubleCheck.provider(TariffInfoModule_ProvideViewModelFactory.create(this.u, provider10));
    }

    public static TariffInfoComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.tariff.info.di.TariffInfoComponent
    public void inject(TariffInfoFragment tariffInfoFragment) {
        TariffInfoFragment_MembersInjector.injectRecyclerAdapter(tariffInfoFragment, this.t.get());
        TariffInfoFragment_MembersInjector.injectAdapterPresenter(tariffInfoFragment, this.s.get());
        TariffInfoFragment_MembersInjector.injectViewModel(tariffInfoFragment, this.H.get());
        TariffInfoFragment_MembersInjector.injectViewTypeProvider(tariffInfoFragment, this.r.get());
    }
}
