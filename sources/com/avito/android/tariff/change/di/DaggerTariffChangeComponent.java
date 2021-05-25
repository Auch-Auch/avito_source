package com.avito.android.tariff.change.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.remote.TariffApi;
import com.avito.android.tariff.change.TariffChangeFragment;
import com.avito.android.tariff.change.TariffChangeFragment_MembersInjector;
import com.avito.android.tariff.change.di.TariffChangeComponent;
import com.avito.android.tariff.change.item.benefit.BenefitItemBlueprint;
import com.avito.android.tariff.change.item.benefit.BenefitItemBlueprint_Factory;
import com.avito.android.tariff.change.item.benefit.BenefitItemPresenter;
import com.avito.android.tariff.change.item.benefit.BenefitItemPresenterImpl_Factory;
import com.avito.android.tariff.change.item.button.ButtonItemBlueprint;
import com.avito.android.tariff.change.item.button.ButtonItemBlueprint_Factory;
import com.avito.android.tariff.change.item.button.ButtonItemPresenter;
import com.avito.android.tariff.change.item.button.ButtonItemPresenterImpl_Factory;
import com.avito.android.tariff.change.item.title.TitleItemBlueprint;
import com.avito.android.tariff.change.item.title.TitleItemBlueprint_Factory;
import com.avito.android.tariff.change.item.title.TitleItemPresenter;
import com.avito.android.tariff.change.item.title.TitleItemPresenterImpl_Factory;
import com.avito.android.tariff.change.viewmodel.TariffChangeConverter;
import com.avito.android.tariff.change.viewmodel.TariffChangeConverterImpl_Factory;
import com.avito.android.tariff.change.viewmodel.TariffChangeRepository;
import com.avito.android.tariff.change.viewmodel.TariffChangeRepositoryImpl;
import com.avito.android.tariff.change.viewmodel.TariffChangeRepositoryImpl_Factory;
import com.avito.android.tariff.change.viewmodel.TariffChangeViewModel;
import com.avito.android.tariff.change.viewmodel.TariffChangeViewModelFactory;
import com.avito.android.tariff.change.viewmodel.TariffChangeViewModelFactory_Factory;
import com.avito.android.tariff.di.HeaderModule_ProvideHeaderBlueprintFactory;
import com.avito.android.tariff.di.HeaderModule_ProvideHeaderPresenterFactory;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerTariffChangeComponent implements TariffChangeComponent {
    public Provider<Set<ItemBlueprint<?, ?>>> a = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PaidServiceHeaderItemPresenter> b;
    public Provider<ItemBlueprint<?, ?>> c;
    public Provider<BenefitItemPresenter> d;
    public Provider<BenefitItemBlueprint> e;
    public Provider<ItemBlueprint<?, ?>> f;
    public Provider<TitleItemPresenter> g;
    public Provider<TitleItemBlueprint> h;
    public Provider<ItemBlueprint<?, ?>> i;
    public Provider<ButtonItemPresenter> j;
    public Provider<ButtonItemBlueprint> k;
    public Provider<ItemBlueprint<?, ?>> l;
    public Provider<Set<ItemBlueprint<?, ?>>> m;
    public Provider<ItemBinder> n;
    public Provider<AdapterPresenter> o;
    public Provider<SimpleRecyclerAdapter> p;
    public Provider<Fragment> q;
    public Provider<TariffApi> r;
    public Provider<SchedulersFactory> s;
    public Provider<TariffChangeRepositoryImpl> t;
    public Provider<TariffChangeRepository> u;
    public Provider<TariffChangeConverter> v;
    public Provider<Kundle> w;
    public Provider<TariffChangeViewModelFactory> x;
    public Provider<ViewModelProvider.Factory> y;
    public Provider<TariffChangeViewModel> z;

    public static final class b implements TariffChangeComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.tariff.change.di.TariffChangeComponent.Factory
        public TariffChangeComponent create(Fragment fragment, TariffStepDependencies tariffStepDependencies, Kundle kundle) {
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(tariffStepDependencies);
            Preconditions.checkNotNull(kundle);
            return new DaggerTariffChangeComponent(tariffStepDependencies, fragment, kundle, null);
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

    public DaggerTariffChangeComponent(TariffStepDependencies tariffStepDependencies, Fragment fragment, Kundle kundle, a aVar) {
        Provider<PaidServiceHeaderItemPresenter> provider = DoubleCheck.provider(HeaderModule_ProvideHeaderPresenterFactory.create());
        this.b = provider;
        this.c = DoubleCheck.provider(HeaderModule_ProvideHeaderBlueprintFactory.create(provider));
        Provider<BenefitItemPresenter> provider2 = DoubleCheck.provider(BenefitItemPresenterImpl_Factory.create());
        this.d = provider2;
        BenefitItemBlueprint_Factory create = BenefitItemBlueprint_Factory.create(provider2);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        Provider<TitleItemPresenter> provider3 = DoubleCheck.provider(TitleItemPresenterImpl_Factory.create());
        this.g = provider3;
        TitleItemBlueprint_Factory create2 = TitleItemBlueprint_Factory.create(provider3);
        this.h = create2;
        this.i = DoubleCheck.provider(create2);
        Provider<ButtonItemPresenter> provider4 = DoubleCheck.provider(ButtonItemPresenterImpl_Factory.create());
        this.j = provider4;
        ButtonItemBlueprint_Factory create3 = ButtonItemBlueprint_Factory.create(provider4);
        this.k = create3;
        this.l = DoubleCheck.provider(create3);
        SetFactory build = SetFactory.builder(4, 1).addCollectionProvider(this.a).addProvider(this.c).addProvider(this.f).addProvider(this.i).addProvider(this.l).build();
        this.m = build;
        Provider<ItemBinder> provider5 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.n = provider5;
        Provider<AdapterPresenter> provider6 = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider5));
        this.o = provider6;
        this.p = DoubleCheck.provider(TariffChangeModule_ProvideSimpleRecyclerAdapterFactory.create(provider6, this.n));
        this.q = InstanceFactory.create(fragment);
        d dVar = new d(tariffStepDependencies);
        this.r = dVar;
        c cVar = new c(tariffStepDependencies);
        this.s = cVar;
        TariffChangeRepositoryImpl_Factory create4 = TariffChangeRepositoryImpl_Factory.create(dVar, cVar);
        this.t = create4;
        this.u = DoubleCheck.provider(create4);
        this.v = DoubleCheck.provider(TariffChangeConverterImpl_Factory.create());
        Factory create5 = InstanceFactory.create(kundle);
        this.w = create5;
        TariffChangeViewModelFactory_Factory create6 = TariffChangeViewModelFactory_Factory.create(this.u, this.v, this.s, create5);
        this.x = create6;
        Provider<ViewModelProvider.Factory> provider7 = DoubleCheck.provider(create6);
        this.y = provider7;
        this.z = DoubleCheck.provider(TariffChangeModule_ProvideViewModelFactory.create(this.q, provider7));
    }

    public static TariffChangeComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.tariff.change.di.TariffChangeComponent
    public void inject(TariffChangeFragment tariffChangeFragment) {
        TariffChangeFragment_MembersInjector.injectRecyclerAdapter(tariffChangeFragment, this.p.get());
        TariffChangeFragment_MembersInjector.injectViewModel(tariffChangeFragment, this.z.get());
        TariffChangeFragment_MembersInjector.injectItemBinder(tariffChangeFragment, this.n.get());
    }
}
