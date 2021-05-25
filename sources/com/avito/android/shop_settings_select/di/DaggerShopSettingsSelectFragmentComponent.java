package com.avito.android.shop_settings_select.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.recycler.data_aware.ChangePayloadCreator;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl_Factory;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.EqualityComparator;
import com.avito.android.recycler.data_aware.SimpleContentsComparator_Factory;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator_Factory;
import com.avito.android.recycler.data_aware.SimpleEqualityComparator_Factory;
import com.avito.android.remote.ShopSettingsApi;
import com.avito.android.shop_settings_select.ShopSettingsSelectConverter;
import com.avito.android.shop_settings_select.ShopSettingsSelectConverterImpl;
import com.avito.android.shop_settings_select.ShopSettingsSelectConverterImpl_Factory;
import com.avito.android.shop_settings_select.ShopSettingsSelectFragment;
import com.avito.android.shop_settings_select.ShopSettingsSelectFragment_MembersInjector;
import com.avito.android.shop_settings_select.ShopSettingsSelectRepository;
import com.avito.android.shop_settings_select.ShopSettingsSelectRepositoryImpl;
import com.avito.android.shop_settings_select.ShopSettingsSelectRepositoryImpl_Factory;
import com.avito.android.shop_settings_select.ShopSettingsSelectViewModel;
import com.avito.android.shop_settings_select.ShopSettingsSelectViewModelFactory;
import com.avito.android.shop_settings_select.ShopSettingsSelectViewModelFactory_Factory;
import com.avito.android.shop_settings_select.blueprints.shop_settings_selection.ShopSettingsSelectionItemBlueprint;
import com.avito.android.shop_settings_select.blueprints.shop_settings_selection.ShopSettingsSelectionItemBlueprint_Factory;
import com.avito.android.shop_settings_select.blueprints.shop_settings_selection.ShopSettingsSelectionItemPresenter;
import com.avito.android.shop_settings_select.blueprints.shop_settings_selection.ShopSettingsSelectionItemPresenterImpl_Factory;
import com.avito.android.shop_settings_select.di.ShopSettingsSelectFragmentComponent;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerShopSettingsSelectFragmentComponent implements ShopSettingsSelectFragmentComponent {
    public Provider<EqualityComparator> A;
    public Provider<Boolean> B;
    public Provider<ChangePayloadCreator> C;
    public Provider<SimpleDiffCalculator> D;
    public Provider<DiffCalculator> E;
    public Provider<DataAwareAdapterPresenterImpl> F;
    public Provider<DataAwareAdapterPresenter> G;
    public Provider<Set<ItemPresenter<?, ?>>> H;
    public final ShopSettingsSelectFragmentDependencies a;
    public final List<String> b;
    public final String c;
    public Provider<Fragment> d;
    public Provider<ShopSettingsApi> e;
    public Provider<SchedulersFactory> f;
    public Provider<String> g;
    public Provider<String> h;
    public Provider<ShopSettingsSelectRepositoryImpl> i;
    public Provider<ShopSettingsSelectRepository> j;
    public Provider<List<String>> k;
    public Provider<ShopSettingsSelectConverterImpl> l;
    public Provider<ShopSettingsSelectConverter> m;
    public Provider<Kundle> n;
    public Provider<ShopSettingsSelectViewModelFactory> o;
    public Provider<ViewModelProvider.Factory> p;
    public Provider<ShopSettingsSelectViewModel> q;
    public Provider<Set<ItemBlueprint<?, ?>>> r = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<ShopSettingsSelectionItemPresenter> s;
    public Provider<ShopSettingsSelectionItemBlueprint> t;
    public Provider<ItemBlueprint<?, ?>> u;
    public Provider<Set<ItemBlueprint<?, ?>>> v;
    public Provider<ItemBinder> w;
    public Provider<AdapterPresenter> x;
    public Provider<SimpleRecyclerAdapter> y;
    public Provider<ContentsComparator> z;

    public static final class b implements ShopSettingsSelectFragmentComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.shop_settings_select.di.ShopSettingsSelectFragmentComponent.Factory
        public ShopSettingsSelectFragmentComponent create(Resources resources, Fragment fragment, Kundle kundle, String str, List<String> list, String str2, ShopSettingsSelectFragmentDependencies shopSettingsSelectFragmentDependencies) {
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(kundle);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(list);
            Preconditions.checkNotNull(shopSettingsSelectFragmentDependencies);
            return new DaggerShopSettingsSelectFragmentComponent(shopSettingsSelectFragmentDependencies, resources, fragment, kundle, str, list, str2, null);
        }
    }

    public static class c implements Provider<SchedulersFactory> {
        public final ShopSettingsSelectFragmentDependencies a;

        public c(ShopSettingsSelectFragmentDependencies shopSettingsSelectFragmentDependencies) {
            this.a = shopSettingsSelectFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class d implements Provider<ShopSettingsApi> {
        public final ShopSettingsSelectFragmentDependencies a;

        public d(ShopSettingsSelectFragmentDependencies shopSettingsSelectFragmentDependencies) {
            this.a = shopSettingsSelectFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShopSettingsApi get() {
            return (ShopSettingsApi) Preconditions.checkNotNullFromComponent(this.a.shopSettingsApi());
        }
    }

    public DaggerShopSettingsSelectFragmentComponent(ShopSettingsSelectFragmentDependencies shopSettingsSelectFragmentDependencies, Resources resources, Fragment fragment, Kundle kundle, String str, List list, String str2, a aVar) {
        this.a = shopSettingsSelectFragmentDependencies;
        this.b = list;
        this.c = str;
        this.d = InstanceFactory.create(fragment);
        this.e = new d(shopSettingsSelectFragmentDependencies);
        this.f = new c(shopSettingsSelectFragmentDependencies);
        this.g = InstanceFactory.create(str);
        Factory createNullable = InstanceFactory.createNullable(str2);
        this.h = createNullable;
        ShopSettingsSelectRepositoryImpl_Factory create = ShopSettingsSelectRepositoryImpl_Factory.create(this.e, this.f, this.g, createNullable);
        this.i = create;
        this.j = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(list);
        this.k = create2;
        ShopSettingsSelectConverterImpl_Factory create3 = ShopSettingsSelectConverterImpl_Factory.create(create2);
        this.l = create3;
        this.m = DoubleCheck.provider(create3);
        Factory create4 = InstanceFactory.create(kundle);
        this.n = create4;
        ShopSettingsSelectViewModelFactory_Factory create5 = ShopSettingsSelectViewModelFactory_Factory.create(this.j, this.m, this.f, create4);
        this.o = create5;
        Provider<ViewModelProvider.Factory> provider = DoubleCheck.provider(create5);
        this.p = provider;
        this.q = DoubleCheck.provider(ShopSettingsSelectFragmentModule_ProvideViewModelFactory.create(this.d, provider));
        Provider<ShopSettingsSelectionItemPresenter> provider2 = DoubleCheck.provider(ShopSettingsSelectionItemPresenterImpl_Factory.create());
        this.s = provider2;
        ShopSettingsSelectionItemBlueprint_Factory create6 = ShopSettingsSelectionItemBlueprint_Factory.create(provider2);
        this.t = create6;
        this.u = DoubleCheck.provider(create6);
        SetFactory build = SetFactory.builder(1, 1).addCollectionProvider(this.r).addProvider(this.u).build();
        this.v = build;
        Provider<ItemBinder> provider3 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.w = provider3;
        Provider<AdapterPresenter> provider4 = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider3));
        this.x = provider4;
        this.y = DoubleCheck.provider(ShopSettingsSelectFragmentModule_ProvideSimpleRecyclerAdapterFactory.create(provider4, this.w));
        this.z = DoubleCheck.provider(SimpleContentsComparator_Factory.create());
        this.A = DoubleCheck.provider(SimpleEqualityComparator_Factory.create());
        this.B = DoubleCheck.provider(ShopSettingsSelectFragmentModule_ProvideDetectMovesFactory.create());
        Provider<ChangePayloadCreator> provider5 = DoubleCheck.provider(ShopSettingsSelectFragmentModule_ProvideChangePayloadCreatorFactory.create());
        this.C = provider5;
        SimpleDiffCalculator_Factory create7 = SimpleDiffCalculator_Factory.create(this.z, this.A, this.B, provider5);
        this.D = create7;
        Provider<DiffCalculator> provider6 = DoubleCheck.provider(create7);
        this.E = provider6;
        DataAwareAdapterPresenterImpl_Factory create8 = DataAwareAdapterPresenterImpl_Factory.create(this.y, this.x, provider6);
        this.F = create8;
        this.G = DoubleCheck.provider(create8);
        this.H = DoubleCheck.provider(ShopSettingsSelectFragmentModule_ProvideItemPresentersFactory.create());
    }

    public static ShopSettingsSelectFragmentComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.shop_settings_select.di.ShopSettingsSelectFragmentComponent
    public void inject(ShopSettingsSelectFragment shopSettingsSelectFragment) {
        ShopSettingsSelectFragment_MembersInjector.injectViewModel(shopSettingsSelectFragment, this.q.get());
        ShopSettingsSelectFragment_MembersInjector.injectRecyclerAdapter(shopSettingsSelectFragment, this.y.get());
        ShopSettingsSelectFragment_MembersInjector.injectAdapterPresenter(shopSettingsSelectFragment, this.G.get());
        ShopSettingsSelectFragment_MembersInjector.injectItemPresenterSet(shopSettingsSelectFragment, SetBuilder.newSetBuilder(2).addAll(this.H.get()).add(this.s.get()).build());
        ShopSettingsSelectFragment_MembersInjector.injectActivityIntentFactory(shopSettingsSelectFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ShopSettingsSelectFragment_MembersInjector.injectCheckedIds(shopSettingsSelectFragment, this.b);
        ShopSettingsSelectFragment_MembersInjector.injectSelectContext(shopSettingsSelectFragment, this.c);
    }
}
