package com.avito.android.advert.closed.di;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.advert.closed.ClosedAdvertActivity;
import com.avito.android.advert.closed.ClosedAdvertActivity_MembersInjector;
import com.avito.android.advert.closed.ClosedAdvertPresenter;
import com.avito.android.advert.closed.ClosedAdvertPresenterImpl;
import com.avito.android.advert.closed.ClosedAdvertPresenterImpl_Factory;
import com.avito.android.advert.closed.ClosedAdvertResourcesProvider;
import com.avito.android.advert.closed.ClosedAdvertResourcesProviderImpl;
import com.avito.android.advert.closed.ClosedAdvertResourcesProviderImpl_Factory;
import com.avito.android.advert.closed.di.ClosedAdvertComponent;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractorImpl;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractorImpl_Factory;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractorFactoryImpl_Factory;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorites.FavoriteAdvertsSyncEventProvider;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerClosedAdvertComponent implements ClosedAdvertComponent {
    public final ClosedAdvertDependencies a;
    public Provider<String> b;
    public Provider<FavoriteAdvertsInteractor> c;
    public Provider<FavoriteAdvertsSyncEventProvider> d;
    public Provider<SchedulersFactory3> e;
    public Provider<AdvertDetailsFavoriteInteractorImpl> f;
    public Provider<AdvertDetailsFavoriteInteractor> g;
    public Provider<ViewedAdvertsDao> h;
    public Provider<ViewedAdvertsEventInteractor> i;
    public Provider<Features> j;
    public Provider<ViewedAdvertsInteractor> k = DoubleCheck.provider(ClosedAdvertModule_ProvideViewedAdvertsInteractor$advert_details_releaseFactory.create(ViewedAdvertsInteractorFactoryImpl_Factory.create(), this.h, this.e, this.i, this.j));
    public Provider<Resources> l;
    public Provider<Formatter<Throwable>> m;
    public Provider<ClosedAdvertResourcesProviderImpl> n;
    public Provider<ClosedAdvertResourcesProvider> o;
    public Provider<ClosedAdvertPresenterImpl> p;
    public Provider<ClosedAdvertPresenter> q;

    public static final class b implements ClosedAdvertComponent.Builder {
        public ClosedAdvertDependencies a;
        public String b;
        public Resources c;

        public b(a aVar) {
        }

        @Override // com.avito.android.advert.closed.di.ClosedAdvertComponent.Builder
        public ClosedAdvertComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ClosedAdvertDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            return new DaggerClosedAdvertComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.advert.closed.di.ClosedAdvertComponent.Builder
        public ClosedAdvertComponent.Builder closedAdvertDependencies(ClosedAdvertDependencies closedAdvertDependencies) {
            this.a = (ClosedAdvertDependencies) Preconditions.checkNotNull(closedAdvertDependencies);
            return this;
        }

        @Override // com.avito.android.advert.closed.di.ClosedAdvertComponent.Builder
        public ClosedAdvertComponent.Builder withAdvertId(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.advert.closed.di.ClosedAdvertComponent.Builder
        public ClosedAdvertComponent.Builder withResources(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<FavoriteAdvertsInteractor> {
        public final ClosedAdvertDependencies a;

        public c(ClosedAdvertDependencies closedAdvertDependencies) {
            this.a = closedAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsInteractor get() {
            return (FavoriteAdvertsInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsInteractor());
        }
    }

    public static class d implements Provider<FavoriteAdvertsSyncEventProvider> {
        public final ClosedAdvertDependencies a;

        public d(ClosedAdvertDependencies closedAdvertDependencies) {
            this.a = closedAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsSyncEventProvider get() {
            return (FavoriteAdvertsSyncEventProvider) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsSyncEventProvider());
        }
    }

    public static class e implements Provider<Features> {
        public final ClosedAdvertDependencies a;

        public e(ClosedAdvertDependencies closedAdvertDependencies) {
            this.a = closedAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<SchedulersFactory3> {
        public final ClosedAdvertDependencies a;

        public f(ClosedAdvertDependencies closedAdvertDependencies) {
            this.a = closedAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class g implements Provider<ViewedAdvertsDao> {
        public final ClosedAdvertDependencies a;

        public g(ClosedAdvertDependencies closedAdvertDependencies) {
            this.a = closedAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsDao get() {
            return (ViewedAdvertsDao) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsDao());
        }
    }

    public static class h implements Provider<ViewedAdvertsEventInteractor> {
        public final ClosedAdvertDependencies a;

        public h(ClosedAdvertDependencies closedAdvertDependencies) {
            this.a = closedAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsEventInteractor get() {
            return (ViewedAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsEventInteractor());
        }
    }

    public DaggerClosedAdvertComponent(ClosedAdvertDependencies closedAdvertDependencies, String str, Resources resources, a aVar) {
        this.a = closedAdvertDependencies;
        this.b = InstanceFactory.create(str);
        c cVar = new c(closedAdvertDependencies);
        this.c = cVar;
        d dVar = new d(closedAdvertDependencies);
        this.d = dVar;
        f fVar = new f(closedAdvertDependencies);
        this.e = fVar;
        AdvertDetailsFavoriteInteractorImpl_Factory create = AdvertDetailsFavoriteInteractorImpl_Factory.create(cVar, dVar, fVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        this.h = new g(closedAdvertDependencies);
        this.i = new h(closedAdvertDependencies);
        this.j = new e(closedAdvertDependencies);
        Factory create2 = InstanceFactory.create(resources);
        this.l = create2;
        this.m = DoubleCheck.provider(ClosedAdvertModule_ProvideThrowableFormatter$advert_details_releaseFactory.create(create2));
        ClosedAdvertResourcesProviderImpl_Factory create3 = ClosedAdvertResourcesProviderImpl_Factory.create(this.l);
        this.n = create3;
        Provider<ClosedAdvertResourcesProvider> provider = DoubleCheck.provider(create3);
        this.o = provider;
        ClosedAdvertPresenterImpl_Factory create4 = ClosedAdvertPresenterImpl_Factory.create(this.b, this.g, this.k, this.m, provider, this.e);
        this.p = create4;
        this.q = DoubleCheck.provider(create4);
    }

    public static ClosedAdvertComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.advert.closed.di.ClosedAdvertComponent
    public void inject(ClosedAdvertActivity closedAdvertActivity) {
        ClosedAdvertActivity_MembersInjector.injectPresenter(closedAdvertActivity, this.q.get());
        ClosedAdvertActivity_MembersInjector.injectFeatures(closedAdvertActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}
