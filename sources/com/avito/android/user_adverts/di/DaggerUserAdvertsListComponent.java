package com.avito.android.user_adverts.di;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.component.user_advert.UserAdvertItemListBlueprint;
import com.avito.android.component.user_advert.UserAdvertItemPresenter;
import com.avito.android.conveyor_shared_item.single_text.SingleTextPresenter;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.DeeplinkClickStreamProvider;
import com.avito.android.floating_views.FloatingViewsPresenter;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.serp.adapter.ShortcutBannerBlueprint;
import com.avito.android.serp.adapter.ShortcutBannerConverter;
import com.avito.android.serp.adapter.ShortcutBannerItemPresenter;
import com.avito.android.serp.adapter.ShortcutBannerWidthProvider;
import com.avito.android.user_advert.UserAdvertsInfoUpdateRunner;
import com.avito.android.user_adverts.di.UserAdvertsListComponent;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter;
import com.avito.android.user_adverts.tab_screens.UserAdvertsCountUpdater;
import com.avito.android.user_adverts.tab_screens.UserAdvertsCountUpdaterImpl;
import com.avito.android.user_adverts.tab_screens.UserAdvertsCountUpdaterImpl_Factory;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment_MembersInjector;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListInteractor;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListInteractorImpl;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListInteractorImpl_Factory;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenterImpl;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenterImpl_Factory;
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
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule_ProvideShortcutTitleBlueprint$user_adverts_releaseFactory;
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
import com.avito.android.user_adverts.tab_screens.advert_list.shortcut_title.ShortcutTitleBlueprint;
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
import com.avito.android.user_adverts.tracker.UserAdvertsListTracker;
import com.avito.android.user_adverts.tracker.UserAdvertsListTrackerImpl;
import com.avito.android.user_adverts.tracker.UserAdvertsListTrackerImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerUserAdvertsListComponent implements UserAdvertsListComponent {
    public Provider<PublishRelay<UserAdvertItemAction>> A;
    public Provider<Consumer<UserAdvertItemAction>> B;
    public Provider<LoadingItemPresenterImpl> C;
    public Provider<LoadingItemPresenter> D;
    public Provider<LoadingItemBlueprint> E;
    public Provider<ItemBinder> F;
    public Provider<AdapterPresenter> G;
    public Provider<UserAdvertConverter> H = DoubleCheck.provider(UserAdvertConverterImpl_Factory.create());
    public Provider<Resources> I;
    public Provider<DeepLinkFactory> J;
    public Provider<ShortcutBannerConverter> K;
    public Provider<LinkedInfoBannerConverter> L;
    public Provider<DiscountBannerConverter> M;
    public Provider<DisclaimerConverter> N;
    public Provider<PerformanceVasBannerConverter> O;
    public Provider<UserElementItemConverterImpl> P;
    public Provider<UserElementItemConverter> Q;
    public Provider<UserItemConverterImpl> R;
    public Provider<UserItemConverter> S;
    public Provider<FloatingViewsPresenter> T;
    public Provider<UserAdvertsHostPresenter> U;
    public Provider<Context> V;
    public Provider<UserAdvertsInfoUpdateRunner> W;
    public Provider<UserAdvertsCountUpdaterImpl> X;
    public Provider<UserAdvertsCountUpdater> Y;
    public Provider<ScreenTrackerFactory> Z;
    public final UserAdvertsListComponentDependencies a;
    public Provider<Screen> a0;
    public Provider<String> b;
    public Provider<Boolean> b0;
    public Provider<UserAdvertsApi> c;
    public Provider<TimerFactory> c0;
    public Provider<SchedulersFactory> d;
    public Provider<ScreenDiInjectTracker> d0;
    public Provider<Boolean> e;
    public Provider<ScreenInitTracker> e0;
    public Provider<Features> f;
    public Provider<ScreenFlowTrackerProvider> f0;
    public Provider<Bundle> g;
    public Provider<UserAdvertsListTrackerImpl> g0;
    public Provider<UserAdvertsListInteractorImpl> h;
    public Provider<UserAdvertsListTracker> h0;
    public Provider<UserAdvertsListInteractor> i;
    public Provider<Kundle> i0;
    public Provider<UserAdvertsListPresenter> j;
    public Provider<Set<DeeplinkClickStreamProvider>> j0;
    public Provider<UserAdvertItemPresenter> k;
    public Provider<Observable<UserAdvertItemAction>> k0;
    public Provider<UserAdvertItemListBlueprint> l;
    public Provider<UserAdvertsListPresenterImpl> l0;
    public Provider<ShortcutBannerWidthProvider> m;
    public Provider<CallableResponsiveItemPresenterRegistry> m0;
    public Provider<ShortcutBannerItemPresenter> n;
    public Provider<ResponsiveAdapterPresenter> n0;
    public Provider<ShortcutBannerBlueprint> o;
    public Provider<DestroyableViewHolderBuilder> o0;
    public Provider<Analytics> p;
    public Provider<LinkedInfoBannerPresenter> q;
    public Provider<AttributedTextFormatter> r;
    public Provider<LinkedInfoBannerBlueprint> s;
    public Provider<SingleTextPresenter> t;
    public Provider<DisclaimerBlueprint> u;
    public Provider<DiscountBannerPresenter> v;
    public Provider<DiscountBannerBlueprint> w;
    public Provider<ShortcutTitleBlueprint> x;
    public Provider<PerformanceVasBannerItemPresenter> y;
    public Provider<PerformanceVasBannerBlueprint> z;

    public static final class b implements UserAdvertsListComponent.Builder {
        public Context a;
        public String b;
        public Kundle c;
        public Resources d;
        public Bundle e;
        public Screen f;
        public Boolean g;
        public Boolean h;
        public PublishRelay<UserAdvertItemAction> i;
        public UserAdvertsListComponentDependencies j;
        public UserAdvertsListAdapterModule k;

        public b(a aVar) {
        }

        @Override // com.avito.android.user_adverts.di.UserAdvertsListComponent.Builder
        public UserAdvertsListComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Context.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.f, Screen.class);
            Preconditions.checkBuilderRequirement(this.g, Boolean.class);
            Preconditions.checkBuilderRequirement(this.h, Boolean.class);
            Preconditions.checkBuilderRequirement(this.i, PublishRelay.class);
            Preconditions.checkBuilderRequirement(this.j, UserAdvertsListComponentDependencies.class);
            Preconditions.checkBuilderRequirement(this.k, UserAdvertsListAdapterModule.class);
            return new DaggerUserAdvertsListComponent(this.k, this.j, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, null);
        }

        @Override // com.avito.android.user_adverts.di.UserAdvertsListComponent.Builder
        public UserAdvertsListComponent.Builder context(Context context) {
            this.a = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // com.avito.android.user_adverts.di.UserAdvertsListComponent.Builder
        public UserAdvertsListComponent.Builder interactorState(Bundle bundle) {
            this.e = bundle;
            return this;
        }

        @Override // com.avito.android.user_adverts.di.UserAdvertsListComponent.Builder
        public UserAdvertsListComponent.Builder isFirstTab(boolean z) {
            this.h = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.user_adverts.di.UserAdvertsListComponent.Builder
        public UserAdvertsListComponent.Builder isSubComponent(boolean z) {
            this.g = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.user_adverts.di.UserAdvertsListComponent.Builder
        public UserAdvertsListComponent.Builder presenterState(Kundle kundle) {
            this.c = kundle;
            return this;
        }

        @Override // com.avito.android.user_adverts.di.UserAdvertsListComponent.Builder
        public UserAdvertsListComponent.Builder resources(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.user_adverts.di.UserAdvertsListComponent.Builder
        public UserAdvertsListComponent.Builder screenName(Screen screen) {
            this.f = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }

        @Override // com.avito.android.user_adverts.di.UserAdvertsListComponent.Builder
        public UserAdvertsListComponent.Builder shortcut(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.user_adverts.di.UserAdvertsListComponent.Builder
        public UserAdvertsListComponent.Builder userAdvertsListAdapterModule(UserAdvertsListAdapterModule userAdvertsListAdapterModule) {
            this.k = (UserAdvertsListAdapterModule) Preconditions.checkNotNull(userAdvertsListAdapterModule);
            return this;
        }

        @Override // com.avito.android.user_adverts.di.UserAdvertsListComponent.Builder
        public UserAdvertsListComponent.Builder userAdvertsListComponentDependencies(UserAdvertsListComponentDependencies userAdvertsListComponentDependencies) {
            this.j = (UserAdvertsListComponentDependencies) Preconditions.checkNotNull(userAdvertsListComponentDependencies);
            return this;
        }

        @Override // com.avito.android.user_adverts.di.UserAdvertsListComponent.Builder
        public UserAdvertsListComponent.Builder with(PublishRelay publishRelay) {
            this.i = (PublishRelay) Preconditions.checkNotNull(publishRelay);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final UserAdvertsListComponentDependencies a;

        public c(UserAdvertsListComponentDependencies userAdvertsListComponentDependencies) {
            this.a = userAdvertsListComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<DeepLinkFactory> {
        public final UserAdvertsListComponentDependencies a;

        public d(UserAdvertsListComponentDependencies userAdvertsListComponentDependencies) {
            this.a = userAdvertsListComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class e implements Provider<Features> {
        public final UserAdvertsListComponentDependencies a;

        public e(UserAdvertsListComponentDependencies userAdvertsListComponentDependencies) {
            this.a = userAdvertsListComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<SchedulersFactory> {
        public final UserAdvertsListComponentDependencies a;

        public f(UserAdvertsListComponentDependencies userAdvertsListComponentDependencies) {
            this.a = userAdvertsListComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class g implements Provider<ScreenTrackerFactory> {
        public final UserAdvertsListComponentDependencies a;

        public g(UserAdvertsListComponentDependencies userAdvertsListComponentDependencies) {
            this.a = userAdvertsListComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class h implements Provider<TimerFactory> {
        public final UserAdvertsListComponentDependencies a;

        public h(UserAdvertsListComponentDependencies userAdvertsListComponentDependencies) {
            this.a = userAdvertsListComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class i implements Provider<UserAdvertsApi> {
        public final UserAdvertsListComponentDependencies a;

        public i(UserAdvertsListComponentDependencies userAdvertsListComponentDependencies) {
            this.a = userAdvertsListComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAdvertsApi get() {
            return (UserAdvertsApi) Preconditions.checkNotNullFromComponent(this.a.userAdvertsApi());
        }
    }

    public static class j implements Provider<UserAdvertsInfoUpdateRunner> {
        public final UserAdvertsListComponentDependencies a;

        public j(UserAdvertsListComponentDependencies userAdvertsListComponentDependencies) {
            this.a = userAdvertsListComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAdvertsInfoUpdateRunner get() {
            return (UserAdvertsInfoUpdateRunner) Preconditions.checkNotNullFromComponent(this.a.userAdvertsInfoUpdateRunner());
        }
    }

    public static class k implements Provider<UserAdvertsHostPresenter> {
        public final UserAdvertsListComponentDependencies a;

        public k(UserAdvertsListComponentDependencies userAdvertsListComponentDependencies) {
            this.a = userAdvertsListComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAdvertsHostPresenter get() {
            return (UserAdvertsHostPresenter) Preconditions.checkNotNullFromComponent(this.a.userAdvertsPresenter());
        }
    }

    public DaggerUserAdvertsListComponent(UserAdvertsListAdapterModule userAdvertsListAdapterModule, UserAdvertsListComponentDependencies userAdvertsListComponentDependencies, Context context, String str, Kundle kundle, Resources resources, Bundle bundle, Screen screen, Boolean bool, Boolean bool2, PublishRelay publishRelay, a aVar) {
        this.a = userAdvertsListComponentDependencies;
        this.b = InstanceFactory.create(str);
        this.c = new i(userAdvertsListComponentDependencies);
        this.d = new f(userAdvertsListComponentDependencies);
        this.e = InstanceFactory.create(bool2);
        this.f = new e(userAdvertsListComponentDependencies);
        Factory createNullable = InstanceFactory.createNullable(bundle);
        this.g = createNullable;
        UserAdvertsListInteractorImpl_Factory create = UserAdvertsListInteractorImpl_Factory.create(this.c, this.d, this.e, this.f, createNullable);
        this.h = create;
        this.i = DoubleCheck.provider(create);
        DelegateFactory delegateFactory = new DelegateFactory();
        this.j = delegateFactory;
        Provider<UserAdvertItemPresenter> provider = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideAdvertItemPresenter$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, delegateFactory));
        this.k = provider;
        this.l = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideAdvertItemListBlueprint$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, provider));
        Provider<ShortcutBannerWidthProvider> provider2 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideShortcutBannerWidthProvider$user_adverts_releaseFactory.create(userAdvertsListAdapterModule));
        this.m = provider2;
        Provider<ShortcutBannerItemPresenter> provider3 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideShortcutBannerItemPresenter$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, this.j, provider2));
        this.n = provider3;
        this.o = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideShortcutBannerItemBlueprint$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, provider3));
        c cVar = new c(userAdvertsListComponentDependencies);
        this.p = cVar;
        this.q = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideLinkedInfoBannerItemPresenter$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, cVar));
        Provider<AttributedTextFormatter> provider4 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.r = provider4;
        this.s = LinkedInfoBannerBlueprint_Factory.create(this.q, provider4);
        Provider<SingleTextPresenter> provider5 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideSingleTextPresenter$user_adverts_releaseFactory.create(userAdvertsListAdapterModule));
        this.t = provider5;
        this.u = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideDisclaimerBlueprint$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, provider5));
        Provider<DiscountBannerPresenter> provider6 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideDiscountBannerPresenter$user_adverts_releaseFactory.create(userAdvertsListAdapterModule));
        this.v = provider6;
        this.w = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideDiscountBlueprint$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, provider6));
        this.x = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideShortcutTitleBlueprint$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, this.t));
        Provider<PerformanceVasBannerItemPresenter> provider7 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvidePerformanceVasBannerPresenter$user_adverts_releaseFactory.create(userAdvertsListAdapterModule));
        this.y = provider7;
        this.z = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvidePerformanceVasBannerBlueprint$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, provider7));
        Factory create2 = InstanceFactory.create(publishRelay);
        this.A = create2;
        Provider<Consumer<UserAdvertItemAction>> provider8 = DoubleCheck.provider(create2);
        this.B = provider8;
        LoadingItemPresenterImpl_Factory create3 = LoadingItemPresenterImpl_Factory.create(provider8);
        this.C = create3;
        Provider<LoadingItemPresenter> provider9 = DoubleCheck.provider(create3);
        this.D = provider9;
        Provider<LoadingItemBlueprint> provider10 = DoubleCheck.provider(UserAdvertsListItemsModule_ProvideLoadingItemBlueprint$user_adverts_releaseFactory.create(provider9));
        this.E = provider10;
        Provider<ItemBinder> provider11 = DoubleCheck.provider(UserAdvertsListModule_ProvideItemBinder$user_adverts_releaseFactory.create(this.l, this.o, this.s, this.u, this.w, this.x, this.z, provider10));
        this.F = provider11;
        this.G = DoubleCheck.provider(UserAdvertsListItemsModule_ProvideAdapterPresenter$user_adverts_releaseFactory.create(provider11));
        Factory create4 = InstanceFactory.create(resources);
        this.I = create4;
        d dVar = new d(userAdvertsListComponentDependencies);
        this.J = dVar;
        this.K = DoubleCheck.provider(UserAdvertsListItemsModule_ProvideShortcutBannerConverter$user_adverts_releaseFactory.create(create4, dVar));
        this.L = DoubleCheck.provider(UserAdvertsListItemsModule_ProvideLinkedInfoBannerConverter$user_adverts_releaseFactory.create(this.I));
        this.M = DoubleCheck.provider(DiscountBannerConverterImpl_Factory.create());
        this.N = DoubleCheck.provider(DisclaimerConverterImpl_Factory.create());
        Provider<PerformanceVasBannerConverter> provider12 = DoubleCheck.provider(PerformanceVasBannerConverterImpl_Factory.create());
        this.O = provider12;
        UserElementItemConverterImpl_Factory create5 = UserElementItemConverterImpl_Factory.create(this.H, this.K, this.L, this.M, this.N, provider12, this.f);
        this.P = create5;
        Provider<UserElementItemConverter> provider13 = DoubleCheck.provider(create5);
        this.Q = provider13;
        UserItemConverterImpl_Factory create6 = UserItemConverterImpl_Factory.create(provider13, this.d);
        this.R = create6;
        this.S = DoubleCheck.provider(create6);
        this.T = DoubleCheck.provider(UserAdvertsListItemsModule_ProvideFloatingViewsPresenter$user_adverts_releaseFactory.create());
        this.U = new k(userAdvertsListComponentDependencies);
        Factory create7 = InstanceFactory.create(context);
        this.V = create7;
        j jVar = new j(userAdvertsListComponentDependencies);
        this.W = jVar;
        UserAdvertsCountUpdaterImpl_Factory create8 = UserAdvertsCountUpdaterImpl_Factory.create(create7, jVar);
        this.X = create8;
        this.Y = DoubleCheck.provider(create8);
        this.Z = new g(userAdvertsListComponentDependencies);
        this.a0 = InstanceFactory.create(screen);
        Factory create9 = InstanceFactory.create(bool);
        this.b0 = create9;
        h hVar = new h(userAdvertsListComponentDependencies);
        this.c0 = hVar;
        this.d0 = DoubleCheck.provider(UserAdvertsListTrackerModule_ProvidesScreenDiInjectTracker$user_adverts_releaseFactory.create(this.Z, this.a0, create9, hVar));
        this.e0 = DoubleCheck.provider(UserAdvertsListTrackerModule_ProvidesScreenInitTrackerFactory.create(this.Z, this.a0, this.b0, this.c0));
        Provider<ScreenFlowTrackerProvider> provider14 = DoubleCheck.provider(UserAdvertsListTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.Z, this.a0, this.c0));
        this.f0 = provider14;
        UserAdvertsListTrackerImpl_Factory create10 = UserAdvertsListTrackerImpl_Factory.create(this.d0, this.e0, provider14);
        this.g0 = create10;
        this.h0 = DoubleCheck.provider(create10);
        this.i0 = InstanceFactory.createNullable(kundle);
        this.j0 = SetFactory.builder(3, 0).addProvider(this.q).addProvider(this.v).addProvider(this.y).build();
        Provider<Observable<UserAdvertItemAction>> provider15 = DoubleCheck.provider(this.A);
        this.k0 = provider15;
        UserAdvertsListPresenterImpl_Factory create11 = UserAdvertsListPresenterImpl_Factory.create(this.b, this.i, this.d, this.G, this.S, this.T, this.U, this.Y, this.h0, this.i0, this.j0, this.p, provider15, this.q);
        this.l0 = create11;
        DelegateFactory.setDelegate(this.j, DoubleCheck.provider(create11));
        Provider<CallableResponsiveItemPresenterRegistry> provider16 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideResponsiveItemPresenterRegistry$user_adverts_releaseFactory.create(userAdvertsListAdapterModule));
        this.m0 = provider16;
        this.n0 = DoubleCheck.provider(UserAdvertsListAdapterModule_ProvideAdapterPresenter$user_adverts_releaseFactory.create(userAdvertsListAdapterModule, this.G, provider16));
        this.o0 = DoubleCheck.provider(UserAdvertsListItemsModule_ProvideDestroyableViewHolderBuilder$user_adverts_releaseFactory.create(this.F));
    }

    public static UserAdvertsListComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.user_adverts.di.UserAdvertsListComponent
    public void inject(UserAdvertsListFragment userAdvertsListFragment) {
        UserAdvertsListFragment_MembersInjector.injectPresenter(userAdvertsListFragment, this.j.get());
        UserAdvertsListFragment_MembersInjector.injectInteractor(userAdvertsListFragment, this.i.get());
        UserAdvertsListFragment_MembersInjector.injectFloatingViewsPresenter(userAdvertsListFragment, this.T.get());
        UserAdvertsListFragment_MembersInjector.injectAdapterPresenter(userAdvertsListFragment, this.n0.get());
        UserAdvertsListFragment_MembersInjector.injectViewHolderBuilder(userAdvertsListFragment, this.o0.get());
        UserAdvertsListFragment_MembersInjector.injectIntentFactory(userAdvertsListFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        UserAdvertsListFragment_MembersInjector.injectDeepLinkIntentFactory(userAdvertsListFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        UserAdvertsListFragment_MembersInjector.injectAnalytics(userAdvertsListFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        UserAdvertsListFragment_MembersInjector.injectTracker(userAdvertsListFragment, this.h0.get());
        UserAdvertsListFragment_MembersInjector.injectFeatures(userAdvertsListFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}
