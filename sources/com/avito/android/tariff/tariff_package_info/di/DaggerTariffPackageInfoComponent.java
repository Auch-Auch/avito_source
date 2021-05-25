package com.avito.android.tariff.tariff_package_info.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.TariffApi;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.tariff_package_info.TariffPackageInfoFragment;
import com.avito.android.tariff.tariff_package_info.TariffPackageInfoFragment_MembersInjector;
import com.avito.android.tariff.tariff_package_info.di.TariffPackageInfoComponent;
import com.avito.android.tariff.tariff_package_info.recycler.TariffPackageBlueprint;
import com.avito.android.tariff.tariff_package_info.recycler.TariffPackageBlueprint_Factory;
import com.avito.android.tariff.tariff_package_info.recycler.TariffPackagePresenter;
import com.avito.android.tariff.tariff_package_info.recycler.TariffPackagePresenter_Factory;
import com.avito.android.tariff.tariff_package_info.recycler.header.TariffPackageHeaderBlueprint;
import com.avito.android.tariff.tariff_package_info.recycler.header.TariffPackageHeaderBlueprint_Factory;
import com.avito.android.tariff.tariff_package_info.recycler.header.TariffPackageHeaderPresenter;
import com.avito.android.tariff.tariff_package_info.recycler.header.TariffPackageHeaderPresenter_Factory;
import com.avito.android.tariff.tariff_package_info.recycler.microcategory.TariffPackageMicrcategoryBlueprint;
import com.avito.android.tariff.tariff_package_info.recycler.microcategory.TariffPackageMicrcategoryBlueprint_Factory;
import com.avito.android.tariff.tariff_package_info.recycler.microcategory.TariffPackageMicrocategoryPresenter;
import com.avito.android.tariff.tariff_package_info.recycler.microcategory.TariffPackageMicrocategoryPresenter_Factory;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverter;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterImpl;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterImpl_Factory;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoRepository;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoRepositoryImpl;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoRepositoryImpl_Factory;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoViewModel;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoViewModelFactory;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoViewModelFactory_Factory;
import com.avito.android.tariff.view.TariffBarConverter;
import com.avito.android.tariff.view.TariffBarConverterImpl_Factory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerTariffPackageInfoComponent implements TariffPackageInfoComponent {
    public Provider<AdapterPresenter> A;
    public Provider<SimpleRecyclerAdapter> B;
    public final TariffStepDependencies a;
    public Provider<Fragment> b;
    public Provider<String> c;
    public Provider<String> d;
    public Provider<TariffBarConverter> e;
    public Provider<TariffPackageInfoConverterImpl> f;
    public Provider<TariffPackageInfoConverter> g;
    public Provider<TariffApi> h;
    public Provider<SchedulersFactory3> i;
    public Provider<TariffPackageInfoRepositoryImpl> j;
    public Provider<TariffPackageInfoRepository> k;
    public Provider<TariffPackageInfoViewModelFactory> l;
    public Provider<ViewModelProvider.Factory> m;
    public Provider<TariffPackageInfoViewModel> n;
    public Provider<TariffPackagePresenter> o = DoubleCheck.provider(TariffPackagePresenter_Factory.create());
    public Provider<TariffPackageMicrocategoryPresenter> p;
    public Provider<TariffPackageMicrcategoryBlueprint> q;
    public Provider<ItemBinder> r;
    public Provider<AdapterPresenter> s;
    public Provider<TariffPackageBlueprint> t;
    public Provider<ItemBlueprint<?, ?>> u;
    public Provider<TariffPackageHeaderPresenter> v;
    public Provider<TariffPackageHeaderBlueprint> w;
    public Provider<ItemBlueprint<?, ?>> x;
    public Provider<Set<ItemBlueprint<?, ?>>> y;
    public Provider<ItemBinder> z;

    public static final class b implements TariffPackageInfoComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.tariff.tariff_package_info.di.TariffPackageInfoComponent.Factory
        public TariffPackageInfoComponent create(Fragment fragment, String str, String str2, TariffStepDependencies tariffStepDependencies) {
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(str2);
            Preconditions.checkNotNull(tariffStepDependencies);
            return new DaggerTariffPackageInfoComponent(tariffStepDependencies, fragment, str, str2, null);
        }
    }

    public static class c implements Provider<SchedulersFactory3> {
        public final TariffStepDependencies a;

        public c(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
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

    public DaggerTariffPackageInfoComponent(TariffStepDependencies tariffStepDependencies, Fragment fragment, String str, String str2, a aVar) {
        this.a = tariffStepDependencies;
        this.b = InstanceFactory.create(fragment);
        this.c = InstanceFactory.create(str);
        this.d = InstanceFactory.create(str2);
        Provider<TariffBarConverter> provider = DoubleCheck.provider(TariffBarConverterImpl_Factory.create());
        this.e = provider;
        TariffPackageInfoConverterImpl_Factory create = TariffPackageInfoConverterImpl_Factory.create(provider);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        d dVar = new d(tariffStepDependencies);
        this.h = dVar;
        c cVar = new c(tariffStepDependencies);
        this.i = cVar;
        TariffPackageInfoRepositoryImpl_Factory create2 = TariffPackageInfoRepositoryImpl_Factory.create(dVar, cVar);
        this.j = create2;
        Provider<TariffPackageInfoRepository> provider2 = DoubleCheck.provider(create2);
        this.k = provider2;
        TariffPackageInfoViewModelFactory_Factory create3 = TariffPackageInfoViewModelFactory_Factory.create(this.c, this.d, this.g, provider2, this.i);
        this.l = create3;
        Provider<ViewModelProvider.Factory> provider3 = DoubleCheck.provider(create3);
        this.m = provider3;
        this.n = DoubleCheck.provider(TariffPackageInfoModule_ProvideViewModelFactory.create(this.b, provider3));
        Provider<TariffPackageMicrocategoryPresenter> provider4 = DoubleCheck.provider(TariffPackageMicrocategoryPresenter_Factory.create());
        this.p = provider4;
        TariffPackageMicrcategoryBlueprint_Factory create4 = TariffPackageMicrcategoryBlueprint_Factory.create(provider4);
        this.q = create4;
        Provider<ItemBinder> provider5 = DoubleCheck.provider(TariffPackageInfoModule_ProvideMicroCategoryItemBinder$tariff_releaseFactory.create(create4));
        this.r = provider5;
        Provider<AdapterPresenter> provider6 = DoubleCheck.provider(TariffPackageInfoModule_ProvideMicroCategoryAdapterPresenter$tariff_releaseFactory.create(provider5));
        this.s = provider6;
        TariffPackageBlueprint_Factory create5 = TariffPackageBlueprint_Factory.create(this.o, this.r, provider6);
        this.t = create5;
        this.u = DoubleCheck.provider(create5);
        Provider<TariffPackageHeaderPresenter> provider7 = DoubleCheck.provider(TariffPackageHeaderPresenter_Factory.create());
        this.v = provider7;
        TariffPackageHeaderBlueprint_Factory create6 = TariffPackageHeaderBlueprint_Factory.create(provider7);
        this.w = create6;
        this.x = DoubleCheck.provider(create6);
        SetFactory build = SetFactory.builder(2, 0).addProvider(this.u).addProvider(this.x).build();
        this.y = build;
        Provider<ItemBinder> provider8 = DoubleCheck.provider(TariffPackageInfoModule_ProvideItemBinder$tariff_releaseFactory.create(build));
        this.z = provider8;
        Provider<AdapterPresenter> provider9 = DoubleCheck.provider(TariffPackageInfoModule_ProvideAdapterPresenter$tariff_releaseFactory.create(provider8));
        this.A = provider9;
        this.B = DoubleCheck.provider(TariffPackageInfoModule_ProvideRecyclerAdapterFactory.create(provider9, this.z));
    }

    public static TariffPackageInfoComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.tariff.tariff_package_info.di.TariffPackageInfoComponent
    public void inject(TariffPackageInfoFragment tariffPackageInfoFragment) {
        TariffPackageInfoFragment_MembersInjector.injectViewModel(tariffPackageInfoFragment, this.n.get());
        TariffPackageInfoFragment_MembersInjector.injectItemBinder(tariffPackageInfoFragment, this.z.get());
        TariffPackageInfoFragment_MembersInjector.injectAdapterPresenter(tariffPackageInfoFragment, this.A.get());
        TariffPackageInfoFragment_MembersInjector.injectRecyclerAdapter(tariffPackageInfoFragment, this.B.get());
        TariffPackageInfoFragment_MembersInjector.injectAttributedTextFormatter(tariffPackageInfoFragment, (AttributedTextFormatter) Preconditions.checkNotNullFromComponent(this.a.attributedTextFormatter()));
        TariffPackageInfoFragment_MembersInjector.injectItemPresenterSet(tariffPackageInfoFragment, SetBuilder.newSetBuilder(2).add(this.o.get()).add(this.v.get()).build());
    }
}
