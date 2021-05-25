package com.avito.android.favorites.di;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.db.favorites.FavoriteItemsDao;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.favorites.FavoriteAdvertItemConverter;
import com.avito.android.favorites.FavoriteAdvertItemConverterImpl;
import com.avito.android.favorites.FavoriteAdvertItemConverterImpl_Factory;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProvider;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProviderImpl;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProviderImpl_Factory;
import com.avito.android.favorites.FavoriteAdvertsService;
import com.avito.android.favorites.FavoriteAdvertsServiceInteractor;
import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl;
import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl_Factory;
import com.avito.android.favorites.FavoriteAdvertsService_MembersInjector;
import com.avito.android.favorites.FavoriteAdvertsSyncEventInteractor;
import com.avito.android.favorites.MutableFavoriteStorage;
import com.avito.android.favorites.di.FavoriteAdvertsServiceComponent;
import com.avito.android.favorites.remote.FavoritesApi;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.AdvertPriceFormatter;
import com.avito.android.util.AdvertPriceFormatter_Factory;
import com.avito.android.util.Formatter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerFavoriteAdvertsServiceComponent implements FavoriteAdvertsServiceComponent {
    public Provider<FavoritesApi> a;
    public Provider<AccountStateProvider> b;
    public Provider<FavoritesSyncDao> c;
    public Provider<FavoriteItemsDao> d;
    public Provider<MutableFavoriteStorage> e;
    public Provider<TimeSource> f;
    public Provider<Analytics> g;
    public Provider<FavoriteAdvertsSyncEventInteractor> h;
    public Provider<Locale> i;
    public Provider<AdvertPriceFormatter> j;
    public Provider<Formatter<AdvertPrice>> k;
    public Provider<Resources> l;
    public Provider<FavoriteAdvertItemConverterResourceProviderImpl> m;
    public Provider<FavoriteAdvertItemConverterResourceProvider> n;
    public Provider<Features> o;
    public Provider<FavoriteAdvertItemConverterImpl> p;
    public Provider<FavoriteAdvertItemConverter> q;
    public Provider<FavoriteAdvertsServiceInteractorImpl> r;
    public Provider<FavoriteAdvertsServiceInteractor> s;

    public static final class b implements FavoriteAdvertsServiceComponent.Builder {
        public FavoriteAdvertsServiceDependencies a;
        public Resources b;

        public b(a aVar) {
        }

        @Override // com.avito.android.favorites.di.FavoriteAdvertsServiceComponent.Builder
        public FavoriteAdvertsServiceComponent build() {
            Preconditions.checkBuilderRequirement(this.a, FavoriteAdvertsServiceDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            return new DaggerFavoriteAdvertsServiceComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.favorites.di.FavoriteAdvertsServiceComponent.Builder
        public FavoriteAdvertsServiceComponent.Builder dependentOn(FavoriteAdvertsServiceDependencies favoriteAdvertsServiceDependencies) {
            this.a = (FavoriteAdvertsServiceDependencies) Preconditions.checkNotNull(favoriteAdvertsServiceDependencies);
            return this;
        }

        @Override // com.avito.android.favorites.di.FavoriteAdvertsServiceComponent.Builder
        public FavoriteAdvertsServiceComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final FavoriteAdvertsServiceDependencies a;

        public c(FavoriteAdvertsServiceDependencies favoriteAdvertsServiceDependencies) {
            this.a = favoriteAdvertsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final FavoriteAdvertsServiceDependencies a;

        public d(FavoriteAdvertsServiceDependencies favoriteAdvertsServiceDependencies) {
            this.a = favoriteAdvertsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<FavoriteAdvertsSyncEventInteractor> {
        public final FavoriteAdvertsServiceDependencies a;

        public e(FavoriteAdvertsServiceDependencies favoriteAdvertsServiceDependencies) {
            this.a = favoriteAdvertsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsSyncEventInteractor get() {
            return (FavoriteAdvertsSyncEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsSyncEventInteractor());
        }
    }

    public static class f implements Provider<FavoriteItemsDao> {
        public final FavoriteAdvertsServiceDependencies a;

        public f(FavoriteAdvertsServiceDependencies favoriteAdvertsServiceDependencies) {
            this.a = favoriteAdvertsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteItemsDao get() {
            return (FavoriteItemsDao) Preconditions.checkNotNullFromComponent(this.a.favoriteItemsDao());
        }
    }

    public static class g implements Provider<MutableFavoriteStorage> {
        public final FavoriteAdvertsServiceDependencies a;

        public g(FavoriteAdvertsServiceDependencies favoriteAdvertsServiceDependencies) {
            this.a = favoriteAdvertsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MutableFavoriteStorage get() {
            return (MutableFavoriteStorage) Preconditions.checkNotNullFromComponent(this.a.favoriteStorage());
        }
    }

    public static class h implements Provider<FavoritesApi> {
        public final FavoriteAdvertsServiceDependencies a;

        public h(FavoriteAdvertsServiceDependencies favoriteAdvertsServiceDependencies) {
            this.a = favoriteAdvertsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesApi get() {
            return (FavoritesApi) Preconditions.checkNotNullFromComponent(this.a.favoritesApi());
        }
    }

    public static class i implements Provider<FavoritesSyncDao> {
        public final FavoriteAdvertsServiceDependencies a;

        public i(FavoriteAdvertsServiceDependencies favoriteAdvertsServiceDependencies) {
            this.a = favoriteAdvertsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesSyncDao get() {
            return (FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao());
        }
    }

    public static class j implements Provider<Features> {
        public final FavoriteAdvertsServiceDependencies a;

        public j(FavoriteAdvertsServiceDependencies favoriteAdvertsServiceDependencies) {
            this.a = favoriteAdvertsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class k implements Provider<Locale> {
        public final FavoriteAdvertsServiceDependencies a;

        public k(FavoriteAdvertsServiceDependencies favoriteAdvertsServiceDependencies) {
            this.a = favoriteAdvertsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class l implements Provider<TimeSource> {
        public final FavoriteAdvertsServiceDependencies a;

        public l(FavoriteAdvertsServiceDependencies favoriteAdvertsServiceDependencies) {
            this.a = favoriteAdvertsServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public DaggerFavoriteAdvertsServiceComponent(FavoriteAdvertsServiceDependencies favoriteAdvertsServiceDependencies, Resources resources, a aVar) {
        this.a = new h(favoriteAdvertsServiceDependencies);
        this.b = new c(favoriteAdvertsServiceDependencies);
        this.c = new i(favoriteAdvertsServiceDependencies);
        this.d = new f(favoriteAdvertsServiceDependencies);
        this.e = new g(favoriteAdvertsServiceDependencies);
        this.f = new l(favoriteAdvertsServiceDependencies);
        this.g = new d(favoriteAdvertsServiceDependencies);
        this.h = new e(favoriteAdvertsServiceDependencies);
        k kVar = new k(favoriteAdvertsServiceDependencies);
        this.i = kVar;
        AdvertPriceFormatter_Factory create = AdvertPriceFormatter_Factory.create(kVar);
        this.j = create;
        this.k = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.l = create2;
        FavoriteAdvertItemConverterResourceProviderImpl_Factory create3 = FavoriteAdvertItemConverterResourceProviderImpl_Factory.create(create2);
        this.m = create3;
        Provider<FavoriteAdvertItemConverterResourceProvider> provider = DoubleCheck.provider(create3);
        this.n = provider;
        j jVar = new j(favoriteAdvertsServiceDependencies);
        this.o = jVar;
        FavoriteAdvertItemConverterImpl_Factory create4 = FavoriteAdvertItemConverterImpl_Factory.create(this.k, provider, jVar);
        this.p = create4;
        Provider<FavoriteAdvertItemConverter> provider2 = DoubleCheck.provider(create4);
        this.q = provider2;
        FavoriteAdvertsServiceInteractorImpl_Factory create5 = FavoriteAdvertsServiceInteractorImpl_Factory.create(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, provider2);
        this.r = create5;
        this.s = DoubleCheck.provider(create5);
    }

    public static FavoriteAdvertsServiceComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.favorites.di.FavoriteAdvertsServiceComponent
    public void inject(FavoriteAdvertsService favoriteAdvertsService) {
        FavoriteAdvertsService_MembersInjector.injectInteractor(favoriteAdvertsService, this.s.get());
    }
}
