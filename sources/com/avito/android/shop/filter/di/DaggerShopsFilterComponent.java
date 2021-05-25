package com.avito.android.shop.filter.di;

import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.CategoriesInteractor;
import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.shop.filter.ShopsFilterFragment;
import com.avito.android.shop.filter.ShopsFilterFragment_MembersInjector;
import com.avito.android.shop.filter.ShopsFilterInteractor;
import com.avito.android.shop.filter.ShopsFilterInteractorImpl;
import com.avito.android.shop.filter.ShopsFilterInteractorImpl_Factory;
import com.avito.android.shop.filter.ShopsFilterPresenter;
import com.avito.android.shop.filter.ShopsFilterPresenterImpl;
import com.avito.android.shop.filter.ShopsFilterPresenterImpl_Factory;
import com.avito.android.shop.filter.di.ShopsFilterComponent;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerShopsFilterComponent implements ShopsFilterComponent {
    public final ShopDetailedDependencies a;
    public Provider<CategoriesInteractor> b;
    public Provider<Features> c;
    public Provider<LocationApi> d;
    public Provider<TopLocationInteractor> e;
    public Provider<SchedulersFactory3> f;
    public Provider<ShopsFilterInteractorImpl> g;
    public Provider<ShopsFilterInteractor> h;
    public Provider<Resources> i;
    public Provider<TreeStateIdGenerator> j;
    public Provider<Analytics> k;
    public Provider<ShopsSearchParameters> l;
    public Provider<Bundle> m;
    public Provider<ShopsFilterPresenterImpl> n;
    public Provider<ShopsFilterPresenter> o;

    public static final class b implements ShopsFilterComponent.Builder {
        public LocationDependencies a;
        public ShopDetailedDependencies b;
        public ShopsSearchParameters c;
        public Bundle d;
        public Resources e;
        public ShopsFilterModule f;

        public b(a aVar) {
        }

        @Override // com.avito.android.shop.filter.di.ShopsFilterComponent.Builder
        public ShopsFilterComponent build() {
            Preconditions.checkBuilderRequirement(this.a, LocationDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ShopDetailedDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, ShopsSearchParameters.class);
            Preconditions.checkBuilderRequirement(this.e, Resources.class);
            Preconditions.checkBuilderRequirement(this.f, ShopsFilterModule.class);
            return new DaggerShopsFilterComponent(this.b, this.a, this.c, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.shop.filter.di.ShopsFilterComponent.Builder
        public ShopsFilterComponent.Builder locationDependencies(LocationDependencies locationDependencies) {
            this.a = (LocationDependencies) Preconditions.checkNotNull(locationDependencies);
            return this;
        }

        @Override // com.avito.android.shop.filter.di.ShopsFilterComponent.Builder
        public ShopsFilterComponent.Builder shopDetailedDependencies(ShopDetailedDependencies shopDetailedDependencies) {
            this.b = (ShopDetailedDependencies) Preconditions.checkNotNull(shopDetailedDependencies);
            return this;
        }

        @Override // com.avito.android.shop.filter.di.ShopsFilterComponent.Builder
        public ShopsFilterComponent.Builder shopsFilterModule(ShopsFilterModule shopsFilterModule) {
            this.f = (ShopsFilterModule) Preconditions.checkNotNull(shopsFilterModule);
            return this;
        }

        @Override // com.avito.android.shop.filter.di.ShopsFilterComponent.Builder
        public ShopsFilterComponent.Builder withPresenterState(Bundle bundle) {
            this.d = bundle;
            return this;
        }

        @Override // com.avito.android.shop.filter.di.ShopsFilterComponent.Builder
        public ShopsFilterComponent.Builder withResources(Resources resources) {
            this.e = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.shop.filter.di.ShopsFilterComponent.Builder
        public ShopsFilterComponent.Builder withSearchParams(ShopsSearchParameters shopsSearchParameters) {
            this.c = (ShopsSearchParameters) Preconditions.checkNotNull(shopsSearchParameters);
            return this;
        }
    }

    public static class c implements Provider<LocationApi> {
        public final LocationDependencies a;

        public c(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LocationApi get() {
            return (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi());
        }
    }

    public static class d implements Provider<TopLocationInteractor> {
        public final LocationDependencies a;

        public d(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TopLocationInteractor get() {
            return (TopLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.topLocationInteractor());
        }
    }

    public static class e implements Provider<Analytics> {
        public final ShopDetailedDependencies a;

        public e(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class f implements Provider<CategoriesInteractor> {
        public final ShopDetailedDependencies a;

        public f(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CategoriesInteractor get() {
            return (CategoriesInteractor) Preconditions.checkNotNullFromComponent(this.a.categoriesInteractor());
        }
    }

    public static class g implements Provider<Features> {
        public final ShopDetailedDependencies a;

        public g(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class h implements Provider<SchedulersFactory3> {
        public final ShopDetailedDependencies a;

        public h(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class i implements Provider<TreeStateIdGenerator> {
        public final ShopDetailedDependencies a;

        public i(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TreeStateIdGenerator get() {
            return (TreeStateIdGenerator) Preconditions.checkNotNullFromComponent(this.a.treeStateIdGenerator());
        }
    }

    public DaggerShopsFilterComponent(ShopDetailedDependencies shopDetailedDependencies, LocationDependencies locationDependencies, ShopsSearchParameters shopsSearchParameters, Bundle bundle, Resources resources, ShopsFilterModule shopsFilterModule, a aVar) {
        this.a = shopDetailedDependencies;
        f fVar = new f(shopDetailedDependencies);
        this.b = fVar;
        g gVar = new g(shopDetailedDependencies);
        this.c = gVar;
        c cVar = new c(locationDependencies);
        this.d = cVar;
        d dVar = new d(locationDependencies);
        this.e = dVar;
        h hVar = new h(shopDetailedDependencies);
        this.f = hVar;
        ShopsFilterInteractorImpl_Factory create = ShopsFilterInteractorImpl_Factory.create(fVar, gVar, cVar, dVar, hVar);
        this.g = create;
        this.h = DoubleCheck.provider(create);
        this.i = InstanceFactory.create(resources);
        this.j = new i(shopDetailedDependencies);
        this.k = new e(shopDetailedDependencies);
        this.l = InstanceFactory.create(shopsSearchParameters);
        Factory createNullable = InstanceFactory.createNullable(bundle);
        this.m = createNullable;
        ShopsFilterPresenterImpl_Factory create2 = ShopsFilterPresenterImpl_Factory.create(this.h, this.f, this.i, this.j, this.k, this.l, createNullable);
        this.n = create2;
        this.o = DoubleCheck.provider(create2);
    }

    public static ShopsFilterComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.shop.filter.di.ShopsFilterComponent
    public void inject(ShopsFilterFragment shopsFilterFragment) {
        ShopsFilterFragment_MembersInjector.injectPresenter(shopsFilterFragment, this.o.get());
        ShopsFilterFragment_MembersInjector.injectAnalytics(shopsFilterFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        ShopsFilterFragment_MembersInjector.injectActivityIntentFactory(shopsFilterFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ShopsFilterFragment_MembersInjector.injectDeviceMetrics(shopsFilterFragment, (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics()));
    }
}
