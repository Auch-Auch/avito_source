package com.avito.android.category.di;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.category.CategoryActivity;
import com.avito.android.category.CategoryActivity_MembersInjector;
import com.avito.android.category.CategoryArguments;
import com.avito.android.category.CategoryInteractor;
import com.avito.android.category.CategoryInteractorImpl;
import com.avito.android.category.CategoryInteractorImpl_Factory;
import com.avito.android.category.CategoryInteractorState;
import com.avito.android.category.CategoryPresenter;
import com.avito.android.category.CategoryPresenterImpl;
import com.avito.android.category.CategoryPresenterImpl_Factory;
import com.avito.android.category.CategoryPresenterState;
import com.avito.android.category.analytics.CategoryAnalyticsInteractor;
import com.avito.android.category.di.CategoryComponent;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.SavedLocationInteractorImpl;
import com.avito.android.location.SavedLocationInteractorImpl_Factory;
import com.avito.android.location.SavedLocationStorage;
import com.avito.android.location.back_navigation.BackNavigationLocationInteractor;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerCategoryComponent implements CategoryComponent {
    public final CategoryDependencies a;
    public Provider<CategoryArguments> b;
    public Provider<Resources> c;
    public Provider<CategoryInteractorState> d;
    public Provider<SavedLocationStorage> e;
    public Provider<LocationApi> f;
    public Provider<TopLocationInteractor> g;
    public Provider<Features> h;
    public Provider<BackNavigationLocationInteractor> i;
    public Provider<SavedLocationInteractorImpl> j;
    public Provider<SavedLocationInteractor> k;
    public Provider<SearchApi> l;
    public Provider<SearchParamsConverter> m;
    public Provider<CategoryInteractorImpl> n;
    public Provider<CategoryInteractor> o;
    public Provider<Analytics> p;
    public Provider<TreeStateIdGenerator> q;
    public Provider<CategoryAnalyticsInteractor> r;
    public Provider<SchedulersFactory3> s;
    public Provider<CategoryPresenterState> t;
    public Provider<CategoryPresenterImpl> u;
    public Provider<CategoryPresenter> v;

    public static final class b implements CategoryComponent.Builder {
        public Resources a;
        public CategoryArguments b;
        public CategoryPresenterState c;
        public CategoryInteractorState d;
        public CategoryDependencies e;
        public LocationDependencies f;

        public b(a aVar) {
        }

        @Override // com.avito.android.category.di.CategoryComponent.Builder
        public CategoryComponent.Builder bindArguments(CategoryArguments categoryArguments) {
            this.b = (CategoryArguments) Preconditions.checkNotNull(categoryArguments);
            return this;
        }

        @Override // com.avito.android.category.di.CategoryComponent.Builder
        public CategoryComponent.Builder bindCategoryInteractorState(CategoryInteractorState categoryInteractorState) {
            this.d = categoryInteractorState;
            return this;
        }

        @Override // com.avito.android.category.di.CategoryComponent.Builder
        public CategoryComponent.Builder bindCategoryPresenterState(CategoryPresenterState categoryPresenterState) {
            this.c = categoryPresenterState;
            return this;
        }

        @Override // com.avito.android.category.di.CategoryComponent.Builder
        public CategoryComponent.Builder bindResources(Resources resources) {
            this.a = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.category.di.CategoryComponent.Builder
        public CategoryComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Resources.class);
            Preconditions.checkBuilderRequirement(this.b, CategoryArguments.class);
            Preconditions.checkBuilderRequirement(this.e, CategoryDependencies.class);
            Preconditions.checkBuilderRequirement(this.f, LocationDependencies.class);
            return new DaggerCategoryComponent(this.e, this.f, this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.category.di.CategoryComponent.Builder
        public CategoryComponent.Builder categoryDependencies(CategoryDependencies categoryDependencies) {
            this.e = (CategoryDependencies) Preconditions.checkNotNull(categoryDependencies);
            return this;
        }

        @Override // com.avito.android.category.di.CategoryComponent.Builder
        public CategoryComponent.Builder locationDependencies(LocationDependencies locationDependencies) {
            this.f = (LocationDependencies) Preconditions.checkNotNull(locationDependencies);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final CategoryDependencies a;

        public c(CategoryDependencies categoryDependencies) {
            this.a = categoryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Features> {
        public final CategoryDependencies a;

        public d(CategoryDependencies categoryDependencies) {
            this.a = categoryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final CategoryDependencies a;

        public e(CategoryDependencies categoryDependencies) {
            this.a = categoryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class f implements Provider<SearchApi> {
        public final CategoryDependencies a;

        public f(CategoryDependencies categoryDependencies) {
            this.a = categoryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchApi get() {
            return (SearchApi) Preconditions.checkNotNullFromComponent(this.a.searchApi());
        }
    }

    public static class g implements Provider<BackNavigationLocationInteractor> {
        public final LocationDependencies a;

        public g(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BackNavigationLocationInteractor get() {
            return (BackNavigationLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.backNavigationLocationInteractor());
        }
    }

    public static class h implements Provider<LocationApi> {
        public final LocationDependencies a;

        public h(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LocationApi get() {
            return (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi());
        }
    }

    public static class i implements Provider<SavedLocationStorage> {
        public final LocationDependencies a;

        public i(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SavedLocationStorage get() {
            return (SavedLocationStorage) Preconditions.checkNotNullFromComponent(this.a.savedLocationStorage());
        }
    }

    public static class j implements Provider<TopLocationInteractor> {
        public final LocationDependencies a;

        public j(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TopLocationInteractor get() {
            return (TopLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.topLocationInteractor());
        }
    }

    public DaggerCategoryComponent(CategoryDependencies categoryDependencies, LocationDependencies locationDependencies, Resources resources, CategoryArguments categoryArguments, CategoryPresenterState categoryPresenterState, CategoryInteractorState categoryInteractorState, a aVar) {
        this.a = categoryDependencies;
        this.b = InstanceFactory.create(categoryArguments);
        this.c = InstanceFactory.create(resources);
        this.d = InstanceFactory.createNullable(categoryInteractorState);
        i iVar = new i(locationDependencies);
        this.e = iVar;
        h hVar = new h(locationDependencies);
        this.f = hVar;
        j jVar = new j(locationDependencies);
        this.g = jVar;
        d dVar = new d(categoryDependencies);
        this.h = dVar;
        g gVar = new g(locationDependencies);
        this.i = gVar;
        SavedLocationInteractorImpl_Factory create = SavedLocationInteractorImpl_Factory.create(iVar, hVar, jVar, dVar, gVar);
        this.j = create;
        this.k = SingleCheck.provider(create);
        this.l = new f(categoryDependencies);
        Provider<SearchParamsConverter> provider = DoubleCheck.provider(CategoryModule_ProvideSearchParamsConverterFactory.create());
        this.m = provider;
        CategoryInteractorImpl_Factory create2 = CategoryInteractorImpl_Factory.create(this.d, this.k, this.l, provider);
        this.n = create2;
        this.o = DoubleCheck.provider(create2);
        this.p = new c(categoryDependencies);
        Provider<TreeStateIdGenerator> provider2 = DoubleCheck.provider(CategoryModule_ProvideTreeStateIdGeneratorFactory.create());
        this.q = provider2;
        this.r = DoubleCheck.provider(CategoryModule_ProvideCategoryAnalyticsInteractorFactory.create(this.p, provider2, this.b));
        this.s = new e(categoryDependencies);
        Factory createNullable = InstanceFactory.createNullable(categoryPresenterState);
        this.t = createNullable;
        CategoryPresenterImpl_Factory create3 = CategoryPresenterImpl_Factory.create(this.b, this.c, this.o, this.r, this.s, createNullable);
        this.u = create3;
        this.v = DoubleCheck.provider(create3);
    }

    public static CategoryComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.category.di.CategoryComponent
    public void inject(CategoryActivity categoryActivity) {
        CategoryActivity_MembersInjector.injectPresenter(categoryActivity, this.v.get());
        CategoryActivity_MembersInjector.injectInteractor(categoryActivity, this.o.get());
        CategoryActivity_MembersInjector.injectDeepLinkIntentFactory(categoryActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        CategoryActivity_MembersInjector.injectDeviceMetrics(categoryActivity, (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics()));
        CategoryActivity_MembersInjector.injectBuild(categoryActivity, (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo()));
        CategoryActivity_MembersInjector.injectAnalytics(categoryActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
