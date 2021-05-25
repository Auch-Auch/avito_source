package com.avito.android.user_adverts.items_search.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.component.user_advert.UserAdvertItemListBlueprint;
import com.avito.android.component.user_advert.UserAdvertItemPresenter;
import com.avito.android.conveyor_shared_item.single_text.SingleTextPresenter;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.serp.adapter.ShortcutBannerBlueprint;
import com.avito.android.serp.adapter.ShortcutBannerConverter;
import com.avito.android.serp.adapter.ShortcutBannerItemPresenter;
import com.avito.android.serp.adapter.ShortcutBannerWidthProvider;
import com.avito.android.user_adverts.di.UserAdvertsListItemsModule_ProvideAdapterPresenter$user_adverts_releaseFactory;
import com.avito.android.user_adverts.di.UserAdvertsListItemsModule_ProvideDestroyableViewHolderBuilder$user_adverts_releaseFactory;
import com.avito.android.user_adverts.di.UserAdvertsListItemsModule_ProvideLinkedInfoBannerConverter$user_adverts_releaseFactory;
import com.avito.android.user_adverts.di.UserAdvertsListItemsModule_ProvideLoadingItemBlueprint$user_adverts_releaseFactory;
import com.avito.android.user_adverts.di.UserAdvertsListItemsModule_ProvideShortcutBannerConverter$user_adverts_releaseFactory;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment_MembersInjector;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchInteractor;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchInteractorImpl;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchInteractorImpl_Factory;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModelFactory;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModelFactory_Factory;
import com.avito.android.user_adverts.items_search.advert_list.SearchCountBlueprint;
import com.avito.android.user_adverts.items_search.advert_list.SmallShortcutTitleBlueprint;
import com.avito.android.user_adverts.items_search.advert_list.UserSearchItemConverter;
import com.avito.android.user_adverts.items_search.advert_list.UserSearchItemConverterImpl;
import com.avito.android.user_adverts.items_search.advert_list.UserSearchItemConverterImpl_Factory;
import com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestsItemConverter;
import com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestsItemConverterImpl_Factory;
import com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker;
import com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTrackerImpl;
import com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTrackerImpl_Factory;
import com.avito.android.user_adverts.items_search.di.ProfileItemsSearchComponent;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvideAdapterPresenter$user_adverts_releaseFactory;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvideAdvertItemListBlueprint$user_adverts_releaseFactory;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvideAdvertItemPresenter$user_adverts_releaseFactory;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvideDisclaimerBlueprint$user_adverts_releaseFactory;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvideDiscountBannerPresenter$user_adverts_releaseFactory;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvideDiscountBlueprint$user_adverts_releaseFactory;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvideLinkedInfoBannerItemPresenter$user_adverts_releaseFactory;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvidePerformanceVasBannerBlueprint$user_adverts_releaseFactory;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvidePerformanceVasBannerPresenter$user_adverts_releaseFactory;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvideResponsiveItemPresenterRegistry$user_adverts_releaseFactory;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvideShortcutBannerItemBlueprint$user_adverts_releaseFactory;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvideShortcutBannerItemPresenter$user_adverts_releaseFactory;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvideShortcutBannerWidthProvider$user_adverts_releaseFactory;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvideSingleTextPresenter$user_adverts_releaseFactory;
import com.avito.android.user_adverts.tab_screens.advert_list.disclaimer.DisclaimerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerPresenter;
import com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerBlueprint_Factory;
import com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerPresenter;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingItemBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingItemPresenter;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingItemPresenterImpl;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingItemPresenterImpl_Factory;
import com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerItemPresenter;
import com.avito.android.user_adverts.tab_screens.converters.DisclaimerConverter;
import com.avito.android.user_adverts.tab_screens.converters.DisclaimerConverterImpl_Factory;
import com.avito.android.user_adverts.tab_screens.converters.DiscountBannerConverter;
import com.avito.android.user_adverts.tab_screens.converters.DiscountBannerConverterImpl_Factory;
import com.avito.android.user_adverts.tab_screens.converters.LinkedInfoBannerConverter;
import com.avito.android.user_adverts.tab_screens.converters.PerformanceVasBannerConverter;
import com.avito.android.user_adverts.tab_screens.converters.PerformanceVasBannerConverterImpl_Factory;
import com.avito.android.user_adverts.tab_screens.converters.UserAdvertConverter;
import com.avito.android.user_adverts.tab_screens.converters.UserAdvertConverterImpl_Factory;
import com.avito.android.user_adverts.tab_screens.converters.UserElementItemConverter;
import com.avito.android.user_adverts.tab_screens.converters.UserElementItemConverterImpl;
import com.avito.android.user_adverts.tab_screens.converters.UserElementItemConverterImpl_Factory;
import com.avito.android.user_adverts.tab_screens.converters.UserItemConverter;
import com.avito.android.user_adverts.tab_screens.converters.UserItemConverterImpl;
import com.avito.android.user_adverts.tab_screens.converters.UserItemConverterImpl_Factory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import javax.inject.Provider;
public final class DaggerProfileItemsSearchComponent implements ProfileItemsSearchComponent {
    public Provider<Analytics> A;
    public Provider<String> B;
    public Provider<ProfileItemsSearchViewModelFactory> C;
    public Provider<ViewModelProvider.Factory> D;
    public Provider<ProfileItemsSearchViewModel> E;
    public Provider<UserAdvertItemPresenter> F;
    public Provider<UserAdvertItemListBlueprint> G;
    public Provider<ShortcutBannerWidthProvider> H;
    public Provider<ShortcutBannerItemPresenter> I;
    public Provider<ShortcutBannerBlueprint> J;
    public Provider<LinkedInfoBannerPresenter> K;
    public Provider<AttributedTextFormatter> L;
    public Provider<LinkedInfoBannerBlueprint> M;
    public Provider<SingleTextPresenter> N;
    public Provider<DisclaimerBlueprint> O;
    public Provider<DiscountBannerPresenter> P;
    public Provider<DiscountBannerBlueprint> Q;
    public Provider<SmallShortcutTitleBlueprint> R;
    public Provider<PerformanceVasBannerItemPresenter> S;
    public Provider<PerformanceVasBannerBlueprint> T;
    public Provider<SearchCountBlueprint> U;
    public Provider<Consumer<UserAdvertItemAction>> V;
    public Provider<LoadingItemPresenterImpl> W;
    public Provider<LoadingItemPresenter> X;
    public Provider<LoadingItemBlueprint> Y;
    public Provider<ItemBinder> Z;
    public final ProfileItemsSearchDependencies a;
    public Provider<AdapterPresenter> a0;
    public Provider<ScreenTrackerFactory> b;
    public Provider<CallableResponsiveItemPresenterRegistry> b0;
    public Provider<TimerFactory> c;
    public Provider<ResponsiveAdapterPresenter> c0;
    public Provider<ProfileItemsSearchTrackerImpl> d;
    public Provider<DestroyableViewHolderBuilder> d0;
    public Provider<ProfileItemsSearchTracker> e;
    public Provider<Observable<UserAdvertItemAction>> e0;
    public Provider<Fragment> f;
    public Provider<UserAdvertsApi> g;
    public Provider<SchedulersFactory> h;
    public Provider<ProfileItemsSearchInteractorImpl> i;
    public Provider<ProfileItemsSearchInteractor> j;
    public Provider<UserAdvertConverter> k = DoubleCheck.provider(UserAdvertConverterImpl_Factory.create());
    public Provider<Resources> l;
    public Provider<DeepLinkFactory> m;
    public Provider<ShortcutBannerConverter> n;
    public Provider<LinkedInfoBannerConverter> o;
    public Provider<DiscountBannerConverter> p;
    public Provider<DisclaimerConverter> q;
    public Provider<PerformanceVasBannerConverter> r;
    public Provider<Features> s;
    public Provider<UserElementItemConverterImpl> t;
    public Provider<UserElementItemConverter> u;
    public Provider<UserItemConverterImpl> v;
    public Provider<UserItemConverter> w;
    public Provider<UserSearchItemConverterImpl> x;
    public Provider<UserSearchItemConverter> y;
    public Provider<SuggestsItemConverter> z;

    public static final class b implements ProfileItemsSearchComponent.Builder {
        public Fragment a;
        public Resources b;
        public String c;
        public ProfileItemsSearchDependencies d;
        public UserAdvertsListAdapterModule e;

        public b(a aVar) {
        }

        @Override // com.avito.android.user_adverts.items_search.di.ProfileItemsSearchComponent.Builder
        public ProfileItemsSearchComponent.Builder bindShortcut(String str) {
            this.c = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.user_adverts.items_search.di.ProfileItemsSearchComponent.Builder
        public ProfileItemsSearchComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Fragment.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, String.class);
            Preconditions.checkBuilderRequirement(this.d, ProfileItemsSearchDependencies.class);
            Preconditions.checkBuilderRequirement(this.e, UserAdvertsListAdapterModule.class);
            return new DaggerProfileItemsSearchComponent(this.e, this.d, this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.user_adverts.items_search.di.ProfileItemsSearchComponent.Builder
        public ProfileItemsSearchComponent.Builder fragment(Fragment fragment) {
            this.a = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.user_adverts.items_search.di.ProfileItemsSearchComponent.Builder
        public ProfileItemsSearchComponent.Builder profileItemsSearchComponentDependencies(ProfileItemsSearchDependencies profileItemsSearchDependencies) {
            this.d = (ProfileItemsSearchDependencies) Preconditions.checkNotNull(profileItemsSearchDependencies);
            return this;
        }

        @Override // com.avito.android.user_adverts.items_search.di.ProfileItemsSearchComponent.Builder
        public ProfileItemsSearchComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.user_adverts.items_search.di.ProfileItemsSearchComponent.Builder
        public ProfileItemsSearchComponent.Builder userAdvertsListAdapterModule(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
            this.e = (UserAdvertsListAdapterModule) Preconditions.checkNotNull(userAdvertsListAdapterModule);
            return this;
        }
    }

    public static class c implements Provider<UserAdvertsApi> {
        public final ProfileItemsSearchDependencies a;

        public c(ProfileItemsSearchDependencies profileItemsSearchDependencies) {
            this.a = profileItemsSearchDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAdvertsApi get() {
            return (UserAdvertsApi) Preconditions.checkNotNullFromComponent(this.a.advertApi());
        }
    }

    public static class d implements Provider<Analytics> {
        public final ProfileItemsSearchDependencies a;

        public d(ProfileItemsSearchDependencies profileItemsSearchDependencies) {
            this.a = profileItemsSearchDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<DeepLinkFactory> {
        public final ProfileItemsSearchDependencies a;

        public e(ProfileItemsSearchDependencies profileItemsSearchDependencies) {
            this.a = profileItemsSearchDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class f implements Provider<Features> {
        public final ProfileItemsSearchDependencies a;

        public f(ProfileItemsSearchDependencies profileItemsSearchDependencies) {
            this.a = profileItemsSearchDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final ProfileItemsSearchDependencies a;

        public g(ProfileItemsSearchDependencies profileItemsSearchDependencies) {
            this.a = profileItemsSearchDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class h implements Provider<ScreenTrackerFactory> {
        public final ProfileItemsSearchDependencies a;

        public h(ProfileItemsSearchDependencies profileItemsSearchDependencies) {
            this.a = profileItemsSearchDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class i implements Provider<TimerFactory> {
        public final ProfileItemsSearchDependencies a;

        public i(ProfileItemsSearchDependencies profileItemsSearchDependencies) {
            this.a = profileItemsSearchDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public DaggerProfileItemsSearchComponent(UserAdvertsListAdapterModule userAdvertsListAdapterModule, ProfileItemsSearchDependencies profileItemsSearchDependencies, Fragment fragment, Resources resources, String str, a aVar) {
        this.a = profileItemsSearchDependencies;
        h hVar = new h(profileItemsSearchDependencies);
        this.b = hVar;
        i iVar = new i(profileItemsSearchDependencies);
        this.c = iVar;
        ProfileItemsSearchTrackerImpl_Factory create = ProfileItemsSearchTrackerImpl_Factory.create(hVar, iVar);
        this.d = create;
        this.e = DoubleCheck.provider(create);
        this.f = InstanceFactory.create(fragment);
        c cVar = new c(profileItemsSearchDependencies);
        this.g = cVar;
        g gVar = new g(profileItemsSearchDependencies);
        this.h = gVar;
        ProfileItemsSearchInteractorImpl_Factory create2 = ProfileItemsSearchInteractorImpl_Factory.create(cVar, gVar);
        this.i = create2;
        this.j = DoubleCheck.provider(create2);
        Factory create3 = InstanceFactory.create(resources);
        this.l = create3;
        e eVar = new e(profileItemsSearchDependencies);
        this.m = eVar;
        this.n = DoubleCheck.provider(UserAdvertsListItemsModule_ProvideShortcutBannerConverter$user_adverts_releaseFactory.create(create3, eVar));
        this.o = DoubleCheck.provider(UserAdvertsListItemsModule_ProvideLinkedInfoBannerConverter$user_adverts_releaseFactory.create(this.l));
        this.p = DoubleCheck.provider(DiscountBannerConverterImpl_Factory.create());
        this.q = DoubleCheck.provider(DisclaimerConverterImpl_Factory.create());
        Provider<PerformanceVasBannerConverter> provider = DoubleCheck.provider(PerformanceVasBannerConverterImpl_Factory.create());
        this.r = provider;
        f fVar = new f(profileItemsSearchDependencies);
        this.s = fVar;
        UserElementItemConverterImpl_Factory create4 = UserElementItemConverterImpl_Factory.create(this.k, this.n, this.o, this.p, this.q, provider, fVar);
        this.t = create4;
        Provider<UserElementItemConverter> provider2 = DoubleCheck.provider(create4);
        this.u = provider2;
        UserItemConverterImpl_Factory create5 = UserItemConverterImpl_Factory.create(provider2, this.h);
        this.v = create5;
        Provider<UserItemConverter> provider3 = DoubleCheck.provider(create5);
        this.w = provider3;
        UserSearchItemConverterImpl_Factory create6 = UserSearchItemConverterImpl_Factory.create(provider3, this.l);
        this.x = create6;
        this.y = DoubleCheck.provider(create6);
        this.z = DoubleCheck.provider(SuggestsItemConverterImpl_Factory.create());
        this.A = new d(profileItemsSearchDependencies);
        Factory create7 = InstanceFactory.create(str);
        this.B = create7;
        ProfileItemsSearchViewModelFactory_Factory create8 = ProfileItemsSearchViewModelFactory_Factory.create(this.j, this.e, this.h, this.y, this.z, this.A, create7);
        this.C = create8;
        Provider<ViewModelProvider.Factory> provider4 = DoubleCheck.provider(create8);
        this.D = provider4;
        Provider<ProfileItemsSearchViewModel> provider5 = DoubleCheck.provider(ProfileItemsSearchModule_ProvideViewModelFactory.create(this.f, provider4));
        this.E = provider5;
        Provider<UserAdvertItemPresenter> provider6 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideAdvertItemPresenter$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, provider5));
        this.F = provider6;
        this.G = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideAdvertItemListBlueprint$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, provider6));
        Provider<ShortcutBannerWidthProvider> provider7 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideShortcutBannerWidthProvider$user_adverts_releaseFactory.create(userAdvertsListAdapterModule));
        this.H = provider7;
        Provider<ShortcutBannerItemPresenter> provider8 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideShortcutBannerItemPresenter$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, this.E, provider7));
        this.I = provider8;
        this.J = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideShortcutBannerItemBlueprint$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, provider8));
        this.K = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideLinkedInfoBannerItemPresenter$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, this.A));
        Provider<AttributedTextFormatter> provider9 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.L = provider9;
        this.M = LinkedInfoBannerBlueprint_Factory.create(this.K, provider9);
        Provider<SingleTextPresenter> provider10 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideSingleTextPresenter$user_adverts_releaseFactory.create(userAdvertsListAdapterModule));
        this.N = provider10;
        this.O = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideDisclaimerBlueprint$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, provider10));
        Provider<DiscountBannerPresenter> provider11 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideDiscountBannerPresenter$user_adverts_releaseFactory.create(userAdvertsListAdapterModule));
        this.P = provider11;
        this.Q = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideDiscountBlueprint$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, provider11));
        this.R = DoubleCheck.provider(ProfileItemsSearchModule_ProvideShortcutTitleBlueprint$user_adverts_releaseFactory.create(this.N));
        Provider<PerformanceVasBannerItemPresenter> provider12 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvidePerformanceVasBannerPresenter$user_adverts_releaseFactory.create(userAdvertsListAdapterModule));
        this.S = provider12;
        this.T = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvidePerformanceVasBannerBlueprint$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, provider12));
        this.U = DoubleCheck.provider(ProfileItemsSearchModule_ProvideSearchCountBlueprint$user_adverts_releaseFactory.create(this.N));
        Provider<Consumer<UserAdvertItemAction>> provider13 = DoubleCheck.provider(ProfileItemsSearchModule_BindConsumerFactory.create());
        this.V = provider13;
        LoadingItemPresenterImpl_Factory create9 = LoadingItemPresenterImpl_Factory.create(provider13);
        this.W = create9;
        Provider<LoadingItemPresenter> provider14 = DoubleCheck.provider(create9);
        this.X = provider14;
        Provider<LoadingItemBlueprint> provider15 = DoubleCheck.provider(UserAdvertsListItemsModule_ProvideLoadingItemBlueprint$user_adverts_releaseFactory.create(provider14));
        this.Y = provider15;
        Provider<ItemBinder> provider16 = DoubleCheck.provider(ProfileItemsSearchModule_ProvideItemBinder$user_adverts_releaseFactory.create(this.G, this.J, this.M, this.O, this.Q, this.R, this.T, this.U, provider15));
        this.Z = provider16;
        this.a0 = DoubleCheck.provider(UserAdvertsListItemsModule_ProvideAdapterPresenter$user_adverts_releaseFactory.create(provider16));
        Provider<CallableResponsiveItemPresenterRegistry> provider17 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideResponsiveItemPresenterRegistry$user_adverts_releaseFactory.create(userAdvertsListAdapterModule));
        this.b0 = provider17;
        this.c0 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideAdapterPresenter$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, this.a0, provider17));
        this.d0 = DoubleCheck.provider(UserAdvertsListItemsModule_ProvideDestroyableViewHolderBuilder$user_adverts_releaseFactory.create(this.Z));
        this.e0 = DoubleCheck.provider(ProfileItemsSearchModule_BindObservableFactory.create());
    }

    public static ProfileItemsSearchComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.user_adverts.items_search.di.ProfileItemsSearchComponent
    public void inject(ProfileItemsSearchFragment profileItemsSearchFragment) {
        ProfileItemsSearchFragment_MembersInjector.injectTracker(profileItemsSearchFragment, this.e.get());
        ProfileItemsSearchFragment_MembersInjector.injectProfileItemsViewModel(profileItemsSearchFragment, this.E.get());
        ProfileItemsSearchFragment_MembersInjector.injectAdapterPresenter(profileItemsSearchFragment, this.c0.get());
        ProfileItemsSearchFragment_MembersInjector.injectViewHolderBuilder(profileItemsSearchFragment, this.d0.get());
        ProfileItemsSearchFragment_MembersInjector.injectAnalytics(profileItemsSearchFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        ProfileItemsSearchFragment_MembersInjector.injectDeepLinkIntentFactory(profileItemsSearchFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        ProfileItemsSearchFragment_MembersInjector.injectItemActions(profileItemsSearchFragment, this.e0.get());
    }
}
