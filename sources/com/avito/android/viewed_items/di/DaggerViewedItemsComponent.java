package com.avito.android.viewed_items.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.provider.TreeStateIdGenerator_Factory;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorites.FavoriteAdvertItemConverter;
import com.avito.android.favorites.FavoriteAdvertItemConverterImpl;
import com.avito.android.favorites.FavoriteAdvertItemConverterImpl_Factory;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProvider;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProviderImpl;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProviderImpl_Factory;
import com.avito.android.favorites.remote.ViewedItemsApi;
import com.avito.android.preferences.UserFavoritesStorage;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.AdvertPriceFormatter;
import com.avito.android.util.AdvertPriceFormatter_Factory;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.viewed_items.ViewedItemsCountInteractor;
import com.avito.android.viewed_items.ViewedItemsFragment;
import com.avito.android.viewed_items.ViewedItemsFragment_MembersInjector;
import com.avito.android.viewed_items.ViewedItemsInteractor;
import com.avito.android.viewed_items.ViewedItemsInteractorImpl;
import com.avito.android.viewed_items.ViewedItemsInteractorImpl_Factory;
import com.avito.android.viewed_items.ViewedItemsPresenter;
import com.avito.android.viewed_items.ViewedItemsPresenterImpl;
import com.avito.android.viewed_items.ViewedItemsPresenterImpl_Factory;
import com.avito.android.viewed_items.adapter.ViewedItemsBlueprint;
import com.avito.android.viewed_items.adapter.ViewedItemsBlueprint_Factory;
import com.avito.android.viewed_items.adapter.ViewedItemsListPresenter;
import com.avito.android.viewed_items.adapter.ViewedItemsListPresenter_Factory;
import com.avito.android.viewed_items.adapter.ViewedItemsLoadingItemBlueprint;
import com.avito.android.viewed_items.adapter.ViewedItemsLoadingItemBlueprint_Factory;
import com.avito.android.viewed_items.adapter.ViewedItemsLoadingItemsPresenterImpl_Factory;
import com.avito.android.viewed_items.di.ViewedItemsComponent;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerViewedItemsComponent implements ViewedItemsComponent {
    public Provider<ViewedItemsPresenterImpl> A;
    public final ViewedItemsDependencies a;
    public Provider<ViewedItemsApi> b;
    public Provider<Locale> c;
    public Provider<AdvertPriceFormatter> d;
    public Provider<Formatter<AdvertPrice>> e;
    public Provider<Resources> f;
    public Provider<FavoriteAdvertItemConverterResourceProviderImpl> g;
    public Provider<FavoriteAdvertItemConverterResourceProvider> h;
    public Provider<Features> i;
    public Provider<FavoriteAdvertItemConverterImpl> j;
    public Provider<FavoriteAdvertItemConverter> k;
    public Provider<TypedErrorThrowableConverter> l;
    public Provider<SchedulersFactory3> m;
    public Provider<ViewedItemsInteractorImpl> n;
    public Provider<ViewedItemsInteractor> o;
    public Provider<ViewedItemsCountInteractor> p;
    public Provider<ViewedItemsPresenter> q;
    public Provider<ViewedItemsListPresenter> r;
    public Provider<TimeSource> s;
    public Provider<ViewedItemsBlueprint> t;
    public Provider<ViewedItemsLoadingItemBlueprint> u;
    public Provider<ItemBinder> v;
    public Provider<AdapterPresenter> w;
    public Provider<UserFavoritesStorage> x;
    public Provider<FavoriteAdvertsInteractor> y;
    public Provider<FavoriteAdvertsEventInteractor> z;

    public static final class b implements ViewedItemsComponent.Builder {
        public ViewedItemsDependencies a;
        public Resources b;
        public Kundle c;

        public b(a aVar) {
        }

        @Override // com.avito.android.viewed_items.di.ViewedItemsComponent.Builder
        public ViewedItemsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ViewedItemsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            return new DaggerViewedItemsComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.viewed_items.di.ViewedItemsComponent.Builder
        public ViewedItemsComponent.Builder dependentOn(ViewedItemsDependencies viewedItemsDependencies) {
            this.a = (ViewedItemsDependencies) Preconditions.checkNotNull(viewedItemsDependencies);
            return this;
        }

        @Override // com.avito.android.viewed_items.di.ViewedItemsComponent.Builder
        public ViewedItemsComponent.Builder withPresenterState(Kundle kundle) {
            this.c = kundle;
            return this;
        }

        @Override // com.avito.android.viewed_items.di.ViewedItemsComponent.Builder
        public ViewedItemsComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<FavoriteAdvertsEventInteractor> {
        public final ViewedItemsDependencies a;

        public c(ViewedItemsDependencies viewedItemsDependencies) {
            this.a = viewedItemsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsEventInteractor get() {
            return (FavoriteAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsEventInteractor());
        }
    }

    public static class d implements Provider<FavoriteAdvertsInteractor> {
        public final ViewedItemsDependencies a;

        public d(ViewedItemsDependencies viewedItemsDependencies) {
            this.a = viewedItemsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsInteractor get() {
            return (FavoriteAdvertsInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsInteractor());
        }
    }

    public static class e implements Provider<Features> {
        public final ViewedItemsDependencies a;

        public e(ViewedItemsDependencies viewedItemsDependencies) {
            this.a = viewedItemsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<Locale> {
        public final ViewedItemsDependencies a;

        public f(ViewedItemsDependencies viewedItemsDependencies) {
            this.a = viewedItemsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class g implements Provider<SchedulersFactory3> {
        public final ViewedItemsDependencies a;

        public g(ViewedItemsDependencies viewedItemsDependencies) {
            this.a = viewedItemsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class h implements Provider<TimeSource> {
        public final ViewedItemsDependencies a;

        public h(ViewedItemsDependencies viewedItemsDependencies) {
            this.a = viewedItemsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class i implements Provider<TypedErrorThrowableConverter> {
        public final ViewedItemsDependencies a;

        public i(ViewedItemsDependencies viewedItemsDependencies) {
            this.a = viewedItemsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class j implements Provider<UserFavoritesStorage> {
        public final ViewedItemsDependencies a;

        public j(ViewedItemsDependencies viewedItemsDependencies) {
            this.a = viewedItemsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserFavoritesStorage get() {
            return (UserFavoritesStorage) Preconditions.checkNotNullFromComponent(this.a.userFavoritesStorage());
        }
    }

    public static class k implements Provider<ViewedItemsApi> {
        public final ViewedItemsDependencies a;

        public k(ViewedItemsDependencies viewedItemsDependencies) {
            this.a = viewedItemsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedItemsApi get() {
            return (ViewedItemsApi) Preconditions.checkNotNullFromComponent(this.a.viewedItemsApi());
        }
    }

    public static class l implements Provider<ViewedItemsCountInteractor> {
        public final ViewedItemsDependencies a;

        public l(ViewedItemsDependencies viewedItemsDependencies) {
            this.a = viewedItemsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedItemsCountInteractor get() {
            return (ViewedItemsCountInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedItemsCountInteractor());
        }
    }

    public DaggerViewedItemsComponent(ViewedItemsDependencies viewedItemsDependencies, Resources resources, Kundle kundle, a aVar) {
        this.a = viewedItemsDependencies;
        this.b = new k(viewedItemsDependencies);
        f fVar = new f(viewedItemsDependencies);
        this.c = fVar;
        AdvertPriceFormatter_Factory create = AdvertPriceFormatter_Factory.create(fVar);
        this.d = create;
        this.e = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.f = create2;
        FavoriteAdvertItemConverterResourceProviderImpl_Factory create3 = FavoriteAdvertItemConverterResourceProviderImpl_Factory.create(create2);
        this.g = create3;
        Provider<FavoriteAdvertItemConverterResourceProvider> provider = DoubleCheck.provider(create3);
        this.h = provider;
        e eVar = new e(viewedItemsDependencies);
        this.i = eVar;
        FavoriteAdvertItemConverterImpl_Factory create4 = FavoriteAdvertItemConverterImpl_Factory.create(this.e, provider, eVar);
        this.j = create4;
        Provider<FavoriteAdvertItemConverter> provider2 = DoubleCheck.provider(create4);
        this.k = provider2;
        i iVar = new i(viewedItemsDependencies);
        this.l = iVar;
        g gVar = new g(viewedItemsDependencies);
        this.m = gVar;
        ViewedItemsInteractorImpl_Factory create5 = ViewedItemsInteractorImpl_Factory.create(this.b, provider2, iVar, gVar);
        this.n = create5;
        this.o = DoubleCheck.provider(create5);
        this.p = new l(viewedItemsDependencies);
        DelegateFactory delegateFactory = new DelegateFactory();
        this.q = delegateFactory;
        ViewedItemsListPresenter_Factory create6 = ViewedItemsListPresenter_Factory.create(delegateFactory);
        this.r = create6;
        h hVar = new h(viewedItemsDependencies);
        this.s = hVar;
        this.t = ViewedItemsBlueprint_Factory.create(create6, hVar, this.c);
        ViewedItemsLoadingItemBlueprint_Factory create7 = ViewedItemsLoadingItemBlueprint_Factory.create(ViewedItemsLoadingItemsPresenterImpl_Factory.create());
        this.u = create7;
        Provider<ItemBinder> provider3 = DoubleCheck.provider(ViewedItemsModule_ProvideViewedItemsItemBinder$favorites_releaseFactory.create(this.t, create7));
        this.v = provider3;
        Provider<AdapterPresenter> provider4 = DoubleCheck.provider(ViewedItemsModule_ProvideViewedItemsAdapterPresenter$favorites_releaseFactory.create(provider3));
        this.w = provider4;
        j jVar = new j(viewedItemsDependencies);
        this.x = jVar;
        d dVar = new d(viewedItemsDependencies);
        this.y = dVar;
        c cVar = new c(viewedItemsDependencies);
        this.z = cVar;
        ViewedItemsPresenterImpl_Factory create8 = ViewedItemsPresenterImpl_Factory.create(this.o, this.p, provider4, jVar, this.m, dVar, cVar, TreeStateIdGenerator_Factory.create());
        this.A = create8;
        DelegateFactory.setDelegate(this.q, DoubleCheck.provider(create8));
    }

    public static ViewedItemsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.viewed_items.di.ViewedItemsComponent
    public void inject(ViewedItemsFragment viewedItemsFragment) {
        ViewedItemsFragment_MembersInjector.injectPresenter(viewedItemsFragment, this.q.get());
        ViewedItemsFragment_MembersInjector.injectAdapterPresenter(viewedItemsFragment, this.w.get());
        ViewedItemsFragment_MembersInjector.injectItemBinder(viewedItemsFragment, this.v.get());
        ViewedItemsFragment_MembersInjector.injectActivityIntentFactory(viewedItemsFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}
