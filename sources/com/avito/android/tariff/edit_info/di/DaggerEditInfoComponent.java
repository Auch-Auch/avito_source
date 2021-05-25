package com.avito.android.tariff.edit_info.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.data_aware.ChangePayloadCreator;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.EqualityComparator;
import com.avito.android.remote.TariffApi;
import com.avito.android.tariff.di.HeaderModule_ProvideHeaderBlueprintFactory;
import com.avito.android.tariff.di.HeaderModule_ProvideHeaderPresenterFactory;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.edit_info.EditInfoFragment;
import com.avito.android.tariff.edit_info.EditInfoFragment_MembersInjector;
import com.avito.android.tariff.edit_info.di.EditInfoComponent;
import com.avito.android.tariff.edit_info.item.add_category.AddCategoryItemBlueprint;
import com.avito.android.tariff.edit_info.item.add_category.AddCategoryItemBlueprint_Factory;
import com.avito.android.tariff.edit_info.item.add_category.AddCategoryItemPresenter;
import com.avito.android.tariff.edit_info.item.add_category.AddCategoryItemPresenterImpl_Factory;
import com.avito.android.tariff.edit_info.item.alert_dialog.AlertDialogBlueprint;
import com.avito.android.tariff.edit_info.item.alert_dialog.AlertDialogBlueprint_Factory;
import com.avito.android.tariff.edit_info.item.alert_dialog.AlertDialogPresenter;
import com.avito.android.tariff.edit_info.item.alert_dialog.AlertDialogPresenterImpl_Factory;
import com.avito.android.tariff.edit_info.item.button.ButtonItemBlueprint;
import com.avito.android.tariff.edit_info.item.button.ButtonItemBlueprint_Factory;
import com.avito.android.tariff.edit_info.item.button.ButtonItemPresenter;
import com.avito.android.tariff.edit_info.item.button.ButtonItemPresenterImpl_Factory;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemBlueprint;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemBlueprint_Factory;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemPresenter;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemPresenterImpl_Factory;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemBlueprint;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemBlueprint_Factory;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemPresenter;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemPresenterImpl_Factory;
import com.avito.android.tariff.edit_info.item.manager_call.ManagerCallBlueprint;
import com.avito.android.tariff.edit_info.item.manager_call.ManagerCallBlueprint_Factory;
import com.avito.android.tariff.edit_info.item.manager_call.ManagerCallPresenter;
import com.avito.android.tariff.edit_info.item.manager_call.ManagerCallPresenterImpl_Factory;
import com.avito.android.tariff.edit_info.item.prolongation.ResourceProvider;
import com.avito.android.tariff.edit_info.item.prolongation.ResourceProviderImpl;
import com.avito.android.tariff.edit_info.item.prolongation.ResourceProviderImpl_Factory;
import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemBlueprint;
import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemBlueprint_Factory;
import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemPresenter;
import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemPresenterImpl;
import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemPresenterImpl_Factory;
import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationPayloadCreator_Factory;
import com.avito.android.tariff.edit_info.item.tabs.TabsItemBlueprint;
import com.avito.android.tariff.edit_info.item.tabs.TabsItemBlueprint_Factory;
import com.avito.android.tariff.edit_info.item.tabs.TabsItemPresenter;
import com.avito.android.tariff.edit_info.item.tabs.TabsItemPresenterImpl_Factory;
import com.avito.android.tariff.edit_info.ui.EditInfoContentsComparator_Factory;
import com.avito.android.tariff.edit_info.ui.EditInfoEqualityComparator_Factory;
import com.avito.android.tariff.edit_info.ui.EditInfoPaddingDecoration;
import com.avito.android.tariff.edit_info.ui.EditInfoPaddingDecoration_Factory;
import com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProvider;
import com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProviderImpl;
import com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProviderImpl_Factory;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoConverter;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoConverterImpl;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoConverterImpl_Factory;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoRepository;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoRepositoryImpl;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoRepositoryImpl_Factory;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModelFactory;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModelFactory_Factory;
import com.avito.android.tariff.info.item.info.InfoItemBlueprint;
import com.avito.android.tariff.info.item.info.InfoItemBlueprint_Factory;
import com.avito.android.tariff.info.item.info.InfoItemPresenter;
import com.avito.android.tariff.info.item.info.InfoItemPresenterImpl_Factory;
import com.avito.android.tariff.info.item.package_title.PackageTitleItemBlueprint;
import com.avito.android.tariff.info.item.package_title.PackageTitleItemBlueprint_Factory;
import com.avito.android.tariff.info.item.package_title.PackageTitleItemPresenter;
import com.avito.android.tariff.info.item.package_title.PackageTitleItemPresenterImpl_Factory;
import com.avito.android.tariff.view.TariffBarConverter;
import com.avito.android.tariff.view.TariffBarConverterImpl_Factory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerEditInfoComponent implements EditInfoComponent {
    public Provider<ResourceProvider> A;
    public Provider<TariffProlongationItemPresenterImpl> B;
    public Provider<TariffProlongationItemPresenter> C;
    public Provider<AttributedTextFormatter> D;
    public Provider<TariffProlongationItemBlueprint> E;
    public Provider<ItemBlueprint<?, ?>> F;
    public Provider<ManagerCallPresenter> G;
    public Provider<ManagerCallBlueprint> H;
    public Provider<ItemBlueprint<?, ?>> I;
    public Provider<Set<ItemBlueprint<?, ?>>> J;
    public Provider<ItemBinder> K;
    public Provider<EditInfoViewTypeProviderImpl> L;
    public Provider<EditInfoViewTypeProvider> M;
    public Provider<AdapterPresenter> N;
    public Provider<EqualityComparator> O;
    public Provider<ContentsComparator> P;
    public Provider<ChangePayloadCreator> Q;
    public Provider<DiffCalculator> R;
    public Provider<DataAwareAdapterPresenter> S;
    public Provider<Fragment> T;
    public Provider<String> U;
    public Provider<TariffApi> V;
    public Provider<SchedulersFactory> W;
    public Provider<EditInfoRepositoryImpl> X;
    public Provider<EditInfoRepository> Y;
    public Provider<TariffBarConverter> Z;
    public final TariffStepDependencies a;
    public Provider<EditInfoConverterImpl> a0;
    public Provider<SimpleRecyclerAdapter> b = new DelegateFactory();
    public Provider<EditInfoConverter> b0;
    public Provider<PaidServiceHeaderItemPresenter> c;
    public Provider<EditInfoViewModelFactory> c0;
    public Provider<ItemBlueprint<?, ?>> d;
    public Provider<ViewModelProvider.Factory> d0;
    public Provider<EditPackageItemPresenter> e;
    public Provider<EditInfoViewModel> e0;
    public Provider<MicroCategoryItemPresenter> f;
    public Provider<EditInfoPaddingDecoration> f0;
    public Provider<MicroCategoryItemBlueprint> g;
    public Provider<RecyclerView.ItemDecoration> g0;
    public Provider<ItemBinder> h;
    public Provider<AlertDialogPresenter> h0;
    public Provider<AdapterPresenter> i;
    public Provider<TabsItemPresenter> i0;
    public Provider<EditPackageItemBlueprint> j;
    public Provider<TabsItemBlueprint> j0;
    public Provider<ItemBlueprint<?, ?>> k;
    public Provider<ItemBlueprint<?, ?>> k0;
    public Provider<ItemBlueprint<?, ?>> l;
    public Provider<AlertDialogBlueprint> l0;
    public Provider<AddCategoryItemPresenter> m;
    public Provider<ItemBlueprint<?, ?>> m0;
    public Provider<AddCategoryItemBlueprint> n;
    public Provider<Set<ItemBlueprint<?, ?>>> n0;
    public Provider<ItemBlueprint<?, ?>> o;
    public Provider<ItemBinder> o0;
    public Provider<ButtonItemPresenter> p;
    public Provider<AdapterPresenter> p0;
    public Provider<ButtonItemBlueprint> q;
    public Provider<SimpleRecyclerAdapter> q0;
    public Provider<ItemBlueprint<?, ?>> r;
    public Provider<InfoItemPresenter> s;
    public Provider<InfoItemBlueprint> t;
    public Provider<ItemBlueprint<?, ?>> u;
    public Provider<PackageTitleItemPresenter> v;
    public Provider<PackageTitleItemBlueprint> w;
    public Provider<ItemBlueprint<?, ?>> x;
    public Provider<Resources> y;
    public Provider<ResourceProviderImpl> z;

    public static final class b implements EditInfoComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.tariff.edit_info.di.EditInfoComponent.Factory
        public EditInfoComponent create(Fragment fragment, String str, Resources resources, TariffStepDependencies tariffStepDependencies) {
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(tariffStepDependencies);
            return new DaggerEditInfoComponent(tariffStepDependencies, fragment, str, resources, null);
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

    public static class e implements Provider<TariffApi> {
        public final TariffStepDependencies a;

        public e(TariffStepDependencies tariffStepDependencies) {
            this.a = tariffStepDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TariffApi get() {
            return (TariffApi) Preconditions.checkNotNullFromComponent(this.a.tariffApi());
        }
    }

    public DaggerEditInfoComponent(TariffStepDependencies tariffStepDependencies, Fragment fragment, String str, Resources resources, a aVar) {
        this.a = tariffStepDependencies;
        Provider<PaidServiceHeaderItemPresenter> provider = DoubleCheck.provider(HeaderModule_ProvideHeaderPresenterFactory.create());
        this.c = provider;
        this.d = DoubleCheck.provider(HeaderModule_ProvideHeaderBlueprintFactory.create(provider));
        this.e = DoubleCheck.provider(EditPackageItemPresenterImpl_Factory.create());
        Provider<MicroCategoryItemPresenter> provider2 = DoubleCheck.provider(MicroCategoryItemPresenterImpl_Factory.create());
        this.f = provider2;
        MicroCategoryItemBlueprint_Factory create = MicroCategoryItemBlueprint_Factory.create(provider2);
        this.g = create;
        Provider<ItemBinder> provider3 = DoubleCheck.provider(EditInfoModule_ProvideMicroCategoryItemBinder$tariff_releaseFactory.create(create));
        this.h = provider3;
        Provider<AdapterPresenter> provider4 = DoubleCheck.provider(EditInfoModule_ProvideMicroCategoryAdapterPresenter$tariff_releaseFactory.create(provider3));
        this.i = provider4;
        EditPackageItemBlueprint_Factory create2 = EditPackageItemBlueprint_Factory.create(this.e, provider4, this.h);
        this.j = create2;
        this.k = DoubleCheck.provider(create2);
        this.l = DoubleCheck.provider(this.g);
        Provider<AddCategoryItemPresenter> provider5 = DoubleCheck.provider(AddCategoryItemPresenterImpl_Factory.create());
        this.m = provider5;
        AddCategoryItemBlueprint_Factory create3 = AddCategoryItemBlueprint_Factory.create(provider5);
        this.n = create3;
        this.o = DoubleCheck.provider(create3);
        Provider<ButtonItemPresenter> provider6 = DoubleCheck.provider(ButtonItemPresenterImpl_Factory.create());
        this.p = provider6;
        ButtonItemBlueprint_Factory create4 = ButtonItemBlueprint_Factory.create(provider6);
        this.q = create4;
        this.r = DoubleCheck.provider(create4);
        Provider<InfoItemPresenter> provider7 = DoubleCheck.provider(InfoItemPresenterImpl_Factory.create());
        this.s = provider7;
        InfoItemBlueprint_Factory create5 = InfoItemBlueprint_Factory.create(provider7);
        this.t = create5;
        this.u = DoubleCheck.provider(create5);
        Provider<PackageTitleItemPresenter> provider8 = DoubleCheck.provider(PackageTitleItemPresenterImpl_Factory.create());
        this.v = provider8;
        PackageTitleItemBlueprint_Factory create6 = PackageTitleItemBlueprint_Factory.create(provider8);
        this.w = create6;
        this.x = DoubleCheck.provider(create6);
        Factory create7 = InstanceFactory.create(resources);
        this.y = create7;
        ResourceProviderImpl_Factory create8 = ResourceProviderImpl_Factory.create(create7);
        this.z = create8;
        Provider<ResourceProvider> provider9 = DoubleCheck.provider(create8);
        this.A = provider9;
        TariffProlongationItemPresenterImpl_Factory create9 = TariffProlongationItemPresenterImpl_Factory.create(provider9);
        this.B = create9;
        Provider<TariffProlongationItemPresenter> provider10 = DoubleCheck.provider(create9);
        this.C = provider10;
        c cVar = new c(tariffStepDependencies);
        this.D = cVar;
        TariffProlongationItemBlueprint_Factory create10 = TariffProlongationItemBlueprint_Factory.create(provider10, cVar);
        this.E = create10;
        this.F = DoubleCheck.provider(create10);
        Provider<ManagerCallPresenter> provider11 = DoubleCheck.provider(ManagerCallPresenterImpl_Factory.create());
        this.G = provider11;
        ManagerCallBlueprint_Factory create11 = ManagerCallBlueprint_Factory.create(provider11);
        this.H = create11;
        this.I = DoubleCheck.provider(create11);
        SetFactory build = SetFactory.builder(9, 0).addProvider(this.d).addProvider(this.k).addProvider(this.l).addProvider(this.o).addProvider(this.r).addProvider(this.u).addProvider(this.x).addProvider(this.F).addProvider(this.I).build();
        this.J = build;
        this.K = DoubleCheck.provider(EditInfoModule_ProvideItemBinder$tariff_releaseFactory.create(build));
        EditInfoViewTypeProviderImpl_Factory create12 = EditInfoViewTypeProviderImpl_Factory.create(this.J);
        this.L = create12;
        Provider<EditInfoViewTypeProvider> provider12 = DoubleCheck.provider(create12);
        this.M = provider12;
        this.N = DoubleCheck.provider(EditInfoModule_ProvideAdapterPresenter$tariff_releaseFactory.create(this.K, provider12));
        this.O = DoubleCheck.provider(EditInfoEqualityComparator_Factory.create());
        this.P = DoubleCheck.provider(EditInfoContentsComparator_Factory.create());
        Provider<ChangePayloadCreator> provider13 = DoubleCheck.provider(TariffProlongationPayloadCreator_Factory.create());
        this.Q = provider13;
        Provider<DiffCalculator> provider14 = DoubleCheck.provider(EditInfoModule_ProvideDiffCalculatorFactory.create(this.O, this.P, provider13));
        this.R = provider14;
        Provider<DataAwareAdapterPresenter> provider15 = DoubleCheck.provider(EditInfoModule_ProvideDataAwareAdapterFactory.create(this.b, this.N, provider14));
        this.S = provider15;
        DelegateFactory.setDelegate(this.b, DoubleCheck.provider(EditInfoModule_ProvideRecyclerAdapterFactory.create(provider15, this.K)));
        this.T = InstanceFactory.create(fragment);
        this.U = InstanceFactory.create(str);
        e eVar = new e(tariffStepDependencies);
        this.V = eVar;
        d dVar = new d(tariffStepDependencies);
        this.W = dVar;
        EditInfoRepositoryImpl_Factory create13 = EditInfoRepositoryImpl_Factory.create(eVar, dVar);
        this.X = create13;
        this.Y = DoubleCheck.provider(create13);
        Provider<TariffBarConverter> provider16 = DoubleCheck.provider(TariffBarConverterImpl_Factory.create());
        this.Z = provider16;
        EditInfoConverterImpl_Factory create14 = EditInfoConverterImpl_Factory.create(provider16);
        this.a0 = create14;
        Provider<EditInfoConverter> provider17 = DoubleCheck.provider(create14);
        this.b0 = provider17;
        EditInfoViewModelFactory_Factory create15 = EditInfoViewModelFactory_Factory.create(this.U, this.Y, provider17, this.W);
        this.c0 = create15;
        Provider<ViewModelProvider.Factory> provider18 = DoubleCheck.provider(create15);
        this.d0 = provider18;
        this.e0 = DoubleCheck.provider(EditInfoModule_ProvideViewModelFactory.create(this.T, provider18));
        EditInfoPaddingDecoration_Factory create16 = EditInfoPaddingDecoration_Factory.create(this.M);
        this.f0 = create16;
        this.g0 = DoubleCheck.provider(create16);
        this.h0 = DoubleCheck.provider(AlertDialogPresenterImpl_Factory.create());
        Provider<TabsItemPresenter> provider19 = DoubleCheck.provider(TabsItemPresenterImpl_Factory.create());
        this.i0 = provider19;
        TabsItemBlueprint_Factory create17 = TabsItemBlueprint_Factory.create(provider19, this.D);
        this.j0 = create17;
        this.k0 = DoubleCheck.provider(create17);
        AlertDialogBlueprint_Factory create18 = AlertDialogBlueprint_Factory.create(this.h0, this.D);
        this.l0 = create18;
        this.m0 = DoubleCheck.provider(create18);
        SetFactory build2 = SetFactory.builder(2, 0).addProvider(this.k0).addProvider(this.m0).build();
        this.n0 = build2;
        Provider<ItemBinder> provider20 = DoubleCheck.provider(EditInfoModule_ProvideTabsItemBinder$tariff_releaseFactory.create(build2));
        this.o0 = provider20;
        Provider<AdapterPresenter> provider21 = DoubleCheck.provider(EditInfoModule_ProvideTabsDataAwareAdapterFactory.create(provider20));
        this.p0 = provider21;
        this.q0 = DoubleCheck.provider(EditInfoModule_ProvideTabsRecyclerAdapterFactory.create(provider21, this.o0));
    }

    public static EditInfoComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.tariff.edit_info.di.EditInfoComponent
    public void inject(EditInfoFragment editInfoFragment) {
        EditInfoFragment_MembersInjector.injectRecyclerAdapter(editInfoFragment, this.b.get());
        EditInfoFragment_MembersInjector.injectAdapterPresenter(editInfoFragment, this.S.get());
        EditInfoFragment_MembersInjector.injectViewModel(editInfoFragment, this.e0.get());
        EditInfoFragment_MembersInjector.injectAttributedTextFormatter(editInfoFragment, (AttributedTextFormatter) Preconditions.checkNotNullFromComponent(this.a.attributedTextFormatter()));
        EditInfoFragment_MembersInjector.injectItemDecoration(editInfoFragment, this.g0.get());
        EditInfoFragment_MembersInjector.injectItemPresenterSet(editInfoFragment, SetBuilder.newSetBuilder(7).add(this.e.get()).add(this.f.get()).add(this.m.get()).add(this.p.get()).add(this.h0.get()).add(this.C.get()).add(this.G.get()).build());
        EditInfoFragment_MembersInjector.injectDeepLinkIntentFactory(editInfoFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        EditInfoFragment_MembersInjector.injectTabsRecyclerAdapter(editInfoFragment, this.q0.get());
        EditInfoFragment_MembersInjector.injectTabsAdapterPresenter(editInfoFragment, this.p0.get());
        EditInfoFragment_MembersInjector.injectTabsItemPresenter(editInfoFragment, this.i0.get());
    }
}
