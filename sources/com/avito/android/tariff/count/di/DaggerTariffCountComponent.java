package com.avito.android.tariff.count.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.recycler.data_aware.ChangePayloadCreator;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.TariffApi;
import com.avito.android.tariff.StringProvider;
import com.avito.android.tariff.count.TariffCountFragment;
import com.avito.android.tariff.count.TariffCountFragment_MembersInjector;
import com.avito.android.tariff.count.di.TariffCountComponent;
import com.avito.android.tariff.count.item.CountItemBlueprint;
import com.avito.android.tariff.count.item.CountItemBlueprint_Factory;
import com.avito.android.tariff.count.item.CountItemPresenterImpl;
import com.avito.android.tariff.count.item.CountItemPresenterImpl_Factory;
import com.avito.android.tariff.count.item.bonus.BonusItemBlueprint;
import com.avito.android.tariff.count.item.bonus.BonusItemBlueprint_Factory;
import com.avito.android.tariff.count.item.bonus.BonusItemPresenter_Factory;
import com.avito.android.tariff.count.recycler.TariffCountContentsComparator_Factory;
import com.avito.android.tariff.count.recycler.TariffCountPayloadCreator_Factory;
import com.avito.android.tariff.count.viewmodel.PriceConverter;
import com.avito.android.tariff.count.viewmodel.PriceConverterImpl_Factory;
import com.avito.android.tariff.count.viewmodel.TariffCountConverter;
import com.avito.android.tariff.count.viewmodel.TariffCountConverterImpl;
import com.avito.android.tariff.count.viewmodel.TariffCountConverterImpl_Factory;
import com.avito.android.tariff.count.viewmodel.TariffCountRepository;
import com.avito.android.tariff.count.viewmodel.TariffCountRepositoryImpl;
import com.avito.android.tariff.count.viewmodel.TariffCountRepositoryImpl_Factory;
import com.avito.android.tariff.count.viewmodel.TariffCountViewModel;
import com.avito.android.tariff.count.viewmodel.TariffCountViewModelFactory;
import com.avito.android.tariff.count.viewmodel.TariffCountViewModelFactory_Factory;
import com.avito.android.tariff.di.HeaderModule_ProvideHeaderBlueprintFactory;
import com.avito.android.tariff.di.HeaderModule_ProvideHeaderPresenterFactory;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerTariffCountComponent implements TariffCountComponent {
    public Provider<TariffCountConverter> A;
    public Provider<StringProvider> B;
    public Provider<Kundle> C;
    public Provider<TariffCountViewModelFactory> D;
    public Provider<ViewModelProvider.Factory> E;
    public Provider<TariffCountViewModel> F;
    public Provider<DataAwareAdapterPresenter> a = new DelegateFactory();
    public Provider<Set<ItemBlueprint<?, ?>>> b = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PaidServiceHeaderItemPresenter> c;
    public Provider<ItemBlueprint<?, ?>> d;
    public Provider<CountItemPresenterImpl> e;
    public Provider<CountItemBlueprint> f;
    public Provider<ItemBlueprint<?, ?>> g;
    public Provider<BonusItemBlueprint> h;
    public Provider<ItemBlueprint<?, ?>> i;
    public Provider<Set<ItemBlueprint<?, ?>>> j;
    public Provider<ItemBinder> k;
    public Provider<SimpleRecyclerAdapter> l;
    public Provider<AdapterPresenter> m;
    public Provider<ContentsComparator> n;
    public Provider<ChangePayloadCreator> o;
    public Provider<DiffCalculator> p;
    public Provider<ItemPresenter<?, ?>> q;
    public Provider<Fragment> r;
    public Provider<String> s;
    public Provider<TariffApi> t;
    public Provider<SchedulersFactory> u;
    public Provider<TariffCountRepositoryImpl> v;
    public Provider<TariffCountRepository> w;
    public Provider<AttributedTextFormatter> x;
    public Provider<PriceConverter> y;
    public Provider<TariffCountConverterImpl> z;

    public static final class b implements TariffCountComponent.Builder {
        public TariffStepDependencies a;
        public String b;
        public Fragment c;
        public Kundle d;

        public b(a aVar) {
        }

        @Override // com.avito.android.tariff.count.di.TariffCountComponent.Builder
        public TariffCountComponent build() {
            Preconditions.checkBuilderRequirement(this.a, TariffStepDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, Fragment.class);
            Preconditions.checkBuilderRequirement(this.d, Kundle.class);
            return new DaggerTariffCountComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.tariff.count.di.TariffCountComponent.Builder
        public TariffCountComponent.Builder checkoutContext(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.tariff.count.di.TariffCountComponent.Builder
        public TariffCountComponent.Builder dependencies(TariffStepDependencies tariffStepDependencies) {
            this.a = (TariffStepDependencies) Preconditions.checkNotNull(tariffStepDependencies);
            return this;
        }

        @Override // com.avito.android.tariff.count.di.TariffCountComponent.Builder
        public TariffCountComponent.Builder fragment(Fragment fragment) {
            this.c = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.tariff.count.di.TariffCountComponent.Builder
        public TariffCountComponent.Builder savedState(Kundle kundle) {
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

    public DaggerTariffCountComponent(TariffStepDependencies tariffStepDependencies, String str, Fragment fragment, Kundle kundle, a aVar) {
        Provider<PaidServiceHeaderItemPresenter> provider = DoubleCheck.provider(HeaderModule_ProvideHeaderPresenterFactory.create());
        this.c = provider;
        this.d = DoubleCheck.provider(HeaderModule_ProvideHeaderBlueprintFactory.create(provider));
        Provider<CountItemPresenterImpl> provider2 = DoubleCheck.provider(CountItemPresenterImpl_Factory.create());
        this.e = provider2;
        CountItemBlueprint_Factory create = CountItemBlueprint_Factory.create(provider2);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        BonusItemBlueprint_Factory create2 = BonusItemBlueprint_Factory.create(BonusItemPresenter_Factory.create());
        this.h = create2;
        this.i = DoubleCheck.provider(create2);
        SetFactory build = SetFactory.builder(3, 1).addCollectionProvider(this.b).addProvider(this.d).addProvider(this.g).addProvider(this.i).build();
        this.j = build;
        Provider<ItemBinder> provider3 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.k = provider3;
        this.l = DoubleCheck.provider(TariffCountModule_ProvideRecyclerAdapterFactory.create(this.a, provider3));
        this.m = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(this.k));
        this.n = DoubleCheck.provider(TariffCountContentsComparator_Factory.create());
        Provider<ChangePayloadCreator> provider4 = DoubleCheck.provider(TariffCountPayloadCreator_Factory.create());
        this.o = provider4;
        Provider<DiffCalculator> provider5 = DoubleCheck.provider(TariffCountModule_ProvideDiffCalculatorFactory.create(this.n, provider4));
        this.p = provider5;
        DelegateFactory.setDelegate(this.a, DoubleCheck.provider(TariffCountModule_ProvideDataAwareAdapterFactory.create(this.l, this.m, provider5)));
        this.q = DoubleCheck.provider(BonusItemPresenter_Factory.create());
        this.r = InstanceFactory.create(fragment);
        this.s = InstanceFactory.create(str);
        f fVar = new f(tariffStepDependencies);
        this.t = fVar;
        d dVar = new d(tariffStepDependencies);
        this.u = dVar;
        TariffCountRepositoryImpl_Factory create3 = TariffCountRepositoryImpl_Factory.create(fVar, dVar);
        this.v = create3;
        this.w = DoubleCheck.provider(create3);
        this.x = new c(tariffStepDependencies);
        Provider<PriceConverter> provider6 = DoubleCheck.provider(PriceConverterImpl_Factory.create());
        this.y = provider6;
        TariffCountConverterImpl_Factory create4 = TariffCountConverterImpl_Factory.create(this.x, provider6);
        this.z = create4;
        this.A = DoubleCheck.provider(create4);
        this.B = new e(tariffStepDependencies);
        Factory create5 = InstanceFactory.create(kundle);
        this.C = create5;
        TariffCountViewModelFactory_Factory create6 = TariffCountViewModelFactory_Factory.create(this.s, this.w, this.A, this.y, this.u, this.B, create5);
        this.D = create6;
        Provider<ViewModelProvider.Factory> provider7 = DoubleCheck.provider(create6);
        this.E = provider7;
        this.F = DoubleCheck.provider(TariffCountModule_ProvideViewModelFactory.create(this.r, provider7));
    }

    public static TariffCountComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.tariff.count.di.TariffCountComponent
    public void inject(TariffCountFragment tariffCountFragment) {
        TariffCountFragment_MembersInjector.injectAdapterPresenter(tariffCountFragment, this.a.get());
        TariffCountFragment_MembersInjector.injectRecyclerAdapter(tariffCountFragment, this.l.get());
        TariffCountFragment_MembersInjector.injectItemPresenterSet(tariffCountFragment, SetBuilder.newSetBuilder(3).add(this.c.get()).add(this.e.get()).add(this.q.get()).build());
        TariffCountFragment_MembersInjector.injectViewModel(tariffCountFragment, this.F.get());
    }
}
