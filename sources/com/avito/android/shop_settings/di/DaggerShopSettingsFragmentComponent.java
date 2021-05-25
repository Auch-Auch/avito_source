package com.avito.android.shop_settings.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStateProvider;
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
import com.avito.android.shop_settings.ShopSettingsConverter;
import com.avito.android.shop_settings.ShopSettingsConverterImpl_Factory;
import com.avito.android.shop_settings.ShopSettingsFragment;
import com.avito.android.shop_settings.ShopSettingsFragment_MembersInjector;
import com.avito.android.shop_settings.ShopSettingsInteractor;
import com.avito.android.shop_settings.ShopSettingsInteractorImpl;
import com.avito.android.shop_settings.ShopSettingsInteractorImpl_Factory;
import com.avito.android.shop_settings.ShopSettingsStringProvider;
import com.avito.android.shop_settings.ShopSettingsStringProviderImpl;
import com.avito.android.shop_settings.ShopSettingsStringProviderImpl_Factory;
import com.avito.android.shop_settings.ShopSettingsViewModel;
import com.avito.android.shop_settings.ShopSettingsViewModelFactory;
import com.avito.android.shop_settings.ShopSettingsViewModelFactory_Factory;
import com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItem;
import com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItemBlueprint;
import com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItemBlueprint_Factory;
import com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItemPresenter;
import com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItemPresenterImpl;
import com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItemPresenterImpl_Factory;
import com.avito.android.shop_settings.blueprints.alert.ShopSettingsAlertItemBlueprint;
import com.avito.android.shop_settings.blueprints.alert.ShopSettingsAlertItemBlueprint_Factory;
import com.avito.android.shop_settings.blueprints.alert.ShopSettingsAlertItemPresenter;
import com.avito.android.shop_settings.blueprints.alert.ShopSettingsAlertItemPresenterImpl_Factory;
import com.avito.android.shop_settings.blueprints.form_title.ShopSettingsFormTitleItemBlueprint;
import com.avito.android.shop_settings.blueprints.form_title.ShopSettingsFormTitleItemBlueprint_Factory;
import com.avito.android.shop_settings.blueprints.form_title.ShopSettingsFormTitleItemPresenter;
import com.avito.android.shop_settings.blueprints.form_title.ShopSettingsFormTitleItemPresenterImpl_Factory;
import com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemPresenter;
import com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemPresenterImpl_Factory;
import com.avito.android.shop_settings.blueprints.input.multi_line_input.ShopSettingsMultiLineInputItemBlueprint;
import com.avito.android.shop_settings.blueprints.input.multi_line_input.ShopSettingsMultiLineInputItemBlueprint_Factory;
import com.avito.android.shop_settings.blueprints.input.single_line_input.ShopSettingsSingleLineInputItemBlueprint;
import com.avito.android.shop_settings.blueprints.input.single_line_input.ShopSettingsSingleLineInputItemBlueprint_Factory;
import com.avito.android.shop_settings.blueprints.moderation_error.ShopSettingsModerationErrorItemBlueprint;
import com.avito.android.shop_settings.blueprints.moderation_error.ShopSettingsModerationErrorItemBlueprint_Factory;
import com.avito.android.shop_settings.blueprints.moderation_error.ShopSettingsModerationErrorItemPresenter;
import com.avito.android.shop_settings.blueprints.moderation_error.ShopSettingsModerationErrorItemPresenterImpl;
import com.avito.android.shop_settings.blueprints.moderation_error.ShopSettingsModerationErrorItemPresenterImpl_Factory;
import com.avito.android.shop_settings.blueprints.save_button.ShopSettingsSaveButtonItemBlueprint;
import com.avito.android.shop_settings.blueprints.save_button.ShopSettingsSaveButtonItemBlueprint_Factory;
import com.avito.android.shop_settings.blueprints.save_button.ShopSettingsSaveButtonItemPresenter;
import com.avito.android.shop_settings.blueprints.save_button.ShopSettingsSaveButtonItemPresenterImpl;
import com.avito.android.shop_settings.blueprints.save_button.ShopSettingsSaveButtonItemPresenterImpl_Factory;
import com.avito.android.shop_settings.blueprints.section_title.ShopSettingsSectionTitleItemBlueprint;
import com.avito.android.shop_settings.blueprints.section_title.ShopSettingsSectionTitleItemBlueprint_Factory;
import com.avito.android.shop_settings.blueprints.section_title.ShopSettingsSectionTitleItemPresenter;
import com.avito.android.shop_settings.blueprints.section_title.ShopSettingsSectionTitleItemPresenterImpl_Factory;
import com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItem;
import com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItemBlueprint;
import com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItemBlueprint_Factory;
import com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItemPresenter;
import com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItemPresenterImpl;
import com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItemPresenterImpl_Factory;
import com.avito.android.shop_settings.blueprints.separator.ShopSettingsSeparatorItemBlueprint;
import com.avito.android.shop_settings.blueprints.separator.ShopSettingsSeparatorItemBlueprint_Factory;
import com.avito.android.shop_settings.blueprints.separator.ShopSettingsSeparatorItemPresenter;
import com.avito.android.shop_settings.blueprints.separator.ShopSettingsSeparatorItemPresenterImpl_Factory;
import com.avito.android.shop_settings.blueprints.switcher.ShopSettingsSwitcherItemBlueprint;
import com.avito.android.shop_settings.blueprints.switcher.ShopSettingsSwitcherItemBlueprint_Factory;
import com.avito.android.shop_settings.blueprints.switcher.ShopSettingsSwitcherItemPresenter;
import com.avito.android.shop_settings.blueprints.switcher.ShopSettingsSwitcherItemPresenterImpl_Factory;
import com.avito.android.shop_settings.blueprints.title_subtitle.ShopSettingsTitleSubtitleItemBlueprint;
import com.avito.android.shop_settings.blueprints.title_subtitle.ShopSettingsTitleSubtitleItemBlueprint_Factory;
import com.avito.android.shop_settings.blueprints.title_subtitle.ShopSettingsTitleSubtitleItemPresenter;
import com.avito.android.shop_settings.blueprints.title_subtitle.ShopSettingsTitleSubtitleItemPresenterImpl_Factory;
import com.avito.android.shop_settings.di.ShopSettingsFragmentComponent;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Unit;
public final class DaggerShopSettingsFragmentComponent implements ShopSettingsFragmentComponent {
    public Provider<ShopSettingsSelectItemPresenterImpl> A;
    public Provider<ShopSettingsSelectItemPresenter> B;
    public Provider<ShopSettingsSelectItemBlueprint> C;
    public Provider<ItemBlueprint<?, ?>> D;
    public Provider<PublishRelay<ShopSettingsAddressItem>> E;
    public Provider<ShopSettingsAddressItemPresenterImpl> F;
    public Provider<ShopSettingsAddressItemPresenter> G;
    public Provider<ShopSettingsAddressItemBlueprint> H;
    public Provider<ItemBlueprint<?, ?>> I;
    public Provider<ShopSettingsSeparatorItemPresenter> J;
    public Provider<ShopSettingsSeparatorItemBlueprint> K;
    public Provider<ItemBlueprint<?, ?>> L;
    public Provider<ShopSettingsInputItemPresenter> M;
    public Provider<ShopSettingsSingleLineInputItemBlueprint> N;
    public Provider<ItemBlueprint<?, ?>> O;
    public Provider<ShopSettingsMultiLineInputItemBlueprint> P;
    public Provider<ItemBlueprint<?, ?>> Q;
    public Provider<ShopSettingsSectionTitleItemPresenter> R;
    public Provider<ShopSettingsSectionTitleItemBlueprint> S;
    public Provider<ItemBlueprint<?, ?>> T;
    public Provider<ShopSettingsTitleSubtitleItemPresenter> U;
    public Provider<ShopSettingsTitleSubtitleItemBlueprint> V;
    public Provider<ItemBlueprint<?, ?>> W;
    public Provider<PublishRelay<Unit>> X;
    public Provider<ShopSettingsSaveButtonItemPresenterImpl> Y;
    public Provider<ShopSettingsSaveButtonItemPresenter> Z;
    public final ShopSettingsFragmentDependencies a;
    public Provider<ShopSettingsSaveButtonItemBlueprint> a0;
    public Provider<Fragment> b;
    public Provider<ItemBlueprint<?, ?>> b0;
    public Provider<ShopSettingsConverter> c = DoubleCheck.provider(ShopSettingsConverterImpl_Factory.create());
    public Provider<AttributedTextFormatter> c0;
    public Provider<ShopSettingsApi> d;
    public Provider<ShopSettingsModerationErrorItemPresenterImpl> d0;
    public Provider<SchedulersFactory> e;
    public Provider<ShopSettingsModerationErrorItemPresenter> e0;
    public Provider<ShopSettingsInteractorImpl> f;
    public Provider<ShopSettingsModerationErrorItemBlueprint> f0;
    public Provider<ShopSettingsInteractor> g;
    public Provider<ItemBlueprint<?, ?>> g0;
    public Provider<Resources> h;
    public Provider<Set<ItemBlueprint<?, ?>>> h0;
    public Provider<ShopSettingsStringProviderImpl> i;
    public Provider<ItemBinder> i0;
    public Provider<ShopSettingsStringProvider> j;
    public Provider<AdapterPresenter> j0;
    public Provider<Kundle> k;
    public Provider<SimpleRecyclerAdapter> k0;
    public Provider<AccountStateProvider> l;
    public Provider<ContentsComparator> l0;
    public Provider<ShopSettingsViewModelFactory> m;
    public Provider<EqualityComparator> m0;
    public Provider<ViewModelProvider.Factory> n;
    public Provider<Boolean> n0;
    public Provider<ShopSettingsViewModel> o;
    public Provider<ChangePayloadCreator> o0;
    public Provider<Set<ItemBlueprint<?, ?>>> p;
    public Provider<SimpleDiffCalculator> p0;
    public Provider<ShopSettingsFormTitleItemPresenter> q;
    public Provider<DiffCalculator> q0;
    public Provider<ShopSettingsFormTitleItemBlueprint> r;
    public Provider<DataAwareAdapterPresenterImpl> r0;
    public Provider<ItemBlueprint<?, ?>> s;
    public Provider<DataAwareAdapterPresenter> s0;
    public Provider<ShopSettingsAlertItemPresenter> t;
    public Provider<ShopSettingsAlertItemBlueprint> u;
    public Provider<ItemBlueprint<?, ?>> v;
    public Provider<ShopSettingsSwitcherItemPresenter> w;
    public Provider<ShopSettingsSwitcherItemBlueprint> x;
    public Provider<ItemBlueprint<?, ?>> y;
    public Provider<PublishRelay<ShopSettingsSelectItem>> z;

    public static final class b implements ShopSettingsFragmentComponent.Builder {
        public ShopSettingsFragmentDependencies a;
        public Resources b;
        public Fragment c;
        public Kundle d;

        public b(a aVar) {
        }

        @Override // com.avito.android.shop_settings.di.ShopSettingsFragmentComponent.Builder
        public ShopSettingsFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ShopSettingsFragmentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Fragment.class);
            Preconditions.checkBuilderRequirement(this.d, Kundle.class);
            return new DaggerShopSettingsFragmentComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.shop_settings.di.ShopSettingsFragmentComponent.Builder
        public ShopSettingsFragmentComponent.Builder dependencies(ShopSettingsFragmentDependencies shopSettingsFragmentDependencies) {
            this.a = (ShopSettingsFragmentDependencies) Preconditions.checkNotNull(shopSettingsFragmentDependencies);
            return this;
        }

        @Override // com.avito.android.shop_settings.di.ShopSettingsFragmentComponent.Builder
        public ShopSettingsFragmentComponent.Builder fragment(Fragment fragment) {
            this.c = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.shop_settings.di.ShopSettingsFragmentComponent.Builder
        public ShopSettingsFragmentComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.shop_settings.di.ShopSettingsFragmentComponent.Builder
        public ShopSettingsFragmentComponent.Builder savedState(Kundle kundle) {
            this.d = (Kundle) Preconditions.checkNotNull(kundle);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final ShopSettingsFragmentDependencies a;

        public c(ShopSettingsFragmentDependencies shopSettingsFragmentDependencies) {
            this.a = shopSettingsFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final ShopSettingsFragmentDependencies a;

        public d(ShopSettingsFragmentDependencies shopSettingsFragmentDependencies) {
            this.a = shopSettingsFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class e implements Provider<ShopSettingsApi> {
        public final ShopSettingsFragmentDependencies a;

        public e(ShopSettingsFragmentDependencies shopSettingsFragmentDependencies) {
            this.a = shopSettingsFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShopSettingsApi get() {
            return (ShopSettingsApi) Preconditions.checkNotNullFromComponent(this.a.shopSettingsApi());
        }
    }

    public DaggerShopSettingsFragmentComponent(ShopSettingsFragmentDependencies shopSettingsFragmentDependencies, Resources resources, Fragment fragment, Kundle kundle, a aVar) {
        this.a = shopSettingsFragmentDependencies;
        this.b = InstanceFactory.create(fragment);
        e eVar = new e(shopSettingsFragmentDependencies);
        this.d = eVar;
        d dVar = new d(shopSettingsFragmentDependencies);
        this.e = dVar;
        ShopSettingsInteractorImpl_Factory create = ShopSettingsInteractorImpl_Factory.create(eVar, dVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.h = create2;
        ShopSettingsStringProviderImpl_Factory create3 = ShopSettingsStringProviderImpl_Factory.create(create2);
        this.i = create3;
        this.j = DoubleCheck.provider(create3);
        Factory create4 = InstanceFactory.create(kundle);
        this.k = create4;
        c cVar = new c(shopSettingsFragmentDependencies);
        this.l = cVar;
        ShopSettingsViewModelFactory_Factory create5 = ShopSettingsViewModelFactory_Factory.create(this.c, this.g, this.e, this.j, create4, cVar);
        this.m = create5;
        Provider<ViewModelProvider.Factory> provider = DoubleCheck.provider(create5);
        this.n = provider;
        this.o = DoubleCheck.provider(ShopSettingsFragmentModule_ProvideViewModelFactory.create(this.b, provider));
        this.p = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
        Provider<ShopSettingsFormTitleItemPresenter> provider2 = DoubleCheck.provider(ShopSettingsFormTitleItemPresenterImpl_Factory.create());
        this.q = provider2;
        ShopSettingsFormTitleItemBlueprint_Factory create6 = ShopSettingsFormTitleItemBlueprint_Factory.create(provider2);
        this.r = create6;
        this.s = DoubleCheck.provider(create6);
        Provider<ShopSettingsAlertItemPresenter> provider3 = DoubleCheck.provider(ShopSettingsAlertItemPresenterImpl_Factory.create());
        this.t = provider3;
        ShopSettingsAlertItemBlueprint_Factory create7 = ShopSettingsAlertItemBlueprint_Factory.create(provider3);
        this.u = create7;
        this.v = DoubleCheck.provider(create7);
        Provider<ShopSettingsSwitcherItemPresenter> provider4 = DoubleCheck.provider(ShopSettingsSwitcherItemPresenterImpl_Factory.create());
        this.w = provider4;
        ShopSettingsSwitcherItemBlueprint_Factory create8 = ShopSettingsSwitcherItemBlueprint_Factory.create(provider4);
        this.x = create8;
        this.y = DoubleCheck.provider(create8);
        Provider<PublishRelay<ShopSettingsSelectItem>> provider5 = DoubleCheck.provider(ShopSettingsFragmentModule_ProvideSelectItemClickFactory.create());
        this.z = provider5;
        ShopSettingsSelectItemPresenterImpl_Factory create9 = ShopSettingsSelectItemPresenterImpl_Factory.create(provider5);
        this.A = create9;
        Provider<ShopSettingsSelectItemPresenter> provider6 = DoubleCheck.provider(create9);
        this.B = provider6;
        ShopSettingsSelectItemBlueprint_Factory create10 = ShopSettingsSelectItemBlueprint_Factory.create(provider6);
        this.C = create10;
        this.D = DoubleCheck.provider(create10);
        Provider<PublishRelay<ShopSettingsAddressItem>> provider7 = DoubleCheck.provider(ShopSettingsFragmentModule_ProvideAddressItemClickFactory.create());
        this.E = provider7;
        ShopSettingsAddressItemPresenterImpl_Factory create11 = ShopSettingsAddressItemPresenterImpl_Factory.create(provider7);
        this.F = create11;
        Provider<ShopSettingsAddressItemPresenter> provider8 = DoubleCheck.provider(create11);
        this.G = provider8;
        ShopSettingsAddressItemBlueprint_Factory create12 = ShopSettingsAddressItemBlueprint_Factory.create(provider8);
        this.H = create12;
        this.I = DoubleCheck.provider(create12);
        Provider<ShopSettingsSeparatorItemPresenter> provider9 = DoubleCheck.provider(ShopSettingsSeparatorItemPresenterImpl_Factory.create());
        this.J = provider9;
        ShopSettingsSeparatorItemBlueprint_Factory create13 = ShopSettingsSeparatorItemBlueprint_Factory.create(provider9);
        this.K = create13;
        this.L = DoubleCheck.provider(create13);
        Provider<ShopSettingsInputItemPresenter> provider10 = DoubleCheck.provider(ShopSettingsInputItemPresenterImpl_Factory.create());
        this.M = provider10;
        ShopSettingsSingleLineInputItemBlueprint_Factory create14 = ShopSettingsSingleLineInputItemBlueprint_Factory.create(provider10);
        this.N = create14;
        this.O = DoubleCheck.provider(create14);
        ShopSettingsMultiLineInputItemBlueprint_Factory create15 = ShopSettingsMultiLineInputItemBlueprint_Factory.create(this.M);
        this.P = create15;
        this.Q = DoubleCheck.provider(create15);
        Provider<ShopSettingsSectionTitleItemPresenter> provider11 = DoubleCheck.provider(ShopSettingsSectionTitleItemPresenterImpl_Factory.create());
        this.R = provider11;
        ShopSettingsSectionTitleItemBlueprint_Factory create16 = ShopSettingsSectionTitleItemBlueprint_Factory.create(provider11);
        this.S = create16;
        this.T = DoubleCheck.provider(create16);
        Provider<ShopSettingsTitleSubtitleItemPresenter> provider12 = DoubleCheck.provider(ShopSettingsTitleSubtitleItemPresenterImpl_Factory.create());
        this.U = provider12;
        ShopSettingsTitleSubtitleItemBlueprint_Factory create17 = ShopSettingsTitleSubtitleItemBlueprint_Factory.create(provider12);
        this.V = create17;
        this.W = DoubleCheck.provider(create17);
        Provider<PublishRelay<Unit>> provider13 = DoubleCheck.provider(ShopSettingsFragmentModule_ProvideSaveButtonClickFactory.create());
        this.X = provider13;
        ShopSettingsSaveButtonItemPresenterImpl_Factory create18 = ShopSettingsSaveButtonItemPresenterImpl_Factory.create(provider13);
        this.Y = create18;
        Provider<ShopSettingsSaveButtonItemPresenter> provider14 = DoubleCheck.provider(create18);
        this.Z = provider14;
        ShopSettingsSaveButtonItemBlueprint_Factory create19 = ShopSettingsSaveButtonItemBlueprint_Factory.create(provider14);
        this.a0 = create19;
        this.b0 = DoubleCheck.provider(create19);
        Provider<AttributedTextFormatter> provider15 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.c0 = provider15;
        ShopSettingsModerationErrorItemPresenterImpl_Factory create20 = ShopSettingsModerationErrorItemPresenterImpl_Factory.create(provider15);
        this.d0 = create20;
        Provider<ShopSettingsModerationErrorItemPresenter> provider16 = DoubleCheck.provider(create20);
        this.e0 = provider16;
        ShopSettingsModerationErrorItemBlueprint_Factory create21 = ShopSettingsModerationErrorItemBlueprint_Factory.create(provider16);
        this.f0 = create21;
        this.g0 = DoubleCheck.provider(create21);
        SetFactory build = SetFactory.builder(12, 1).addCollectionProvider(this.p).addProvider(this.s).addProvider(this.v).addProvider(this.y).addProvider(this.D).addProvider(this.I).addProvider(this.L).addProvider(this.O).addProvider(this.Q).addProvider(this.T).addProvider(this.W).addProvider(this.b0).addProvider(this.g0).build();
        this.h0 = build;
        Provider<ItemBinder> provider17 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.i0 = provider17;
        Provider<AdapterPresenter> provider18 = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider17));
        this.j0 = provider18;
        this.k0 = DoubleCheck.provider(ShopSettingsFragmentModule_ProvideSimpleRecyclerAdapterFactory.create(provider18, this.i0));
        this.l0 = DoubleCheck.provider(SimpleContentsComparator_Factory.create());
        this.m0 = DoubleCheck.provider(SimpleEqualityComparator_Factory.create());
        this.n0 = DoubleCheck.provider(ShopSettingsFragmentModule_ProvideDetectMovesFactory.create());
        Provider<ChangePayloadCreator> provider19 = DoubleCheck.provider(ShopSettingsFragmentModule_ProvideChangePayloadCreatorFactory.create());
        this.o0 = provider19;
        SimpleDiffCalculator_Factory create22 = SimpleDiffCalculator_Factory.create(this.l0, this.m0, this.n0, provider19);
        this.p0 = create22;
        Provider<DiffCalculator> provider20 = DoubleCheck.provider(create22);
        this.q0 = provider20;
        DataAwareAdapterPresenterImpl_Factory create23 = DataAwareAdapterPresenterImpl_Factory.create(this.k0, this.j0, provider20);
        this.r0 = create23;
        this.s0 = DoubleCheck.provider(create23);
    }

    public static ShopSettingsFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.shop_settings.di.ShopSettingsFragmentComponent
    public void inject(ShopSettingsFragment shopSettingsFragment) {
        ShopSettingsFragment_MembersInjector.injectViewModel(shopSettingsFragment, this.o.get());
        ShopSettingsFragment_MembersInjector.injectRecyclerAdapter(shopSettingsFragment, this.k0.get());
        ShopSettingsFragment_MembersInjector.injectAdapterPresenter(shopSettingsFragment, this.s0.get());
        ShopSettingsFragment_MembersInjector.injectActivityIntentFactory(shopSettingsFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ShopSettingsFragment_MembersInjector.injectSaveButtonClickListener(shopSettingsFragment, this.X.get());
        ShopSettingsFragment_MembersInjector.injectSelectItemClickListener(shopSettingsFragment, this.z.get());
        ShopSettingsFragment_MembersInjector.injectAddressItemClickListener(shopSettingsFragment, this.E.get());
    }
}
