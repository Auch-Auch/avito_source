package com.avito.android.shop.info.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.shop.info.ShopInfoActivity;
import com.avito.android.shop.info.ShopInfoActivity_MembersInjector;
import com.avito.android.shop.info.ShopInfoInteractor;
import com.avito.android.shop.info.ShopInfoPresenter;
import com.avito.android.shop.info.ShopInfoResourceProvider;
import com.avito.android.shop.info.di.ShopInfoComponent;
import com.avito.android.shop.remote.ShopsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerShopInfoComponent implements ShopInfoComponent {
    public final ShopDetailedDependencies a;
    public Provider<ShopsApi> b;
    public Provider<SchedulersFactory3> c;
    public Provider<ShopInfoInteractor> d;
    public Provider<ShopInfoResourceProvider> e;
    public Provider<ShopInfoPresenter> f;

    public static final class b implements ShopInfoComponent.Builder {
        public ShopDetailedDependencies a;
        public ShopInfoModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.shop.info.di.ShopInfoComponent.Builder
        public ShopInfoComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ShopDetailedDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ShopInfoModule.class);
            return new DaggerShopInfoComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.shop.info.di.ShopInfoComponent.Builder
        public ShopInfoComponent.Builder shopDetailedDependencies(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = (ShopDetailedDependencies) Preconditions.checkNotNull(shopDetailedDependencies);
            return this;
        }

        @Override // com.avito.android.shop.info.di.ShopInfoComponent.Builder
        public ShopInfoComponent.Builder shopInfoModule(ShopInfoModule shopInfoModule) {
            this.b = (ShopInfoModule) Preconditions.checkNotNull(shopInfoModule);
            return this;
        }
    }

    public static class c implements Provider<SchedulersFactory3> {
        public final ShopDetailedDependencies a;

        public c(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class d implements Provider<ShopsApi> {
        public final ShopDetailedDependencies a;

        public d(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShopsApi get() {
            return (ShopsApi) Preconditions.checkNotNullFromComponent(this.a.shopsApi());
        }
    }

    public DaggerShopInfoComponent(ShopInfoModule shopInfoModule, ShopDetailedDependencies shopDetailedDependencies, a aVar) {
        this.a = shopDetailedDependencies;
        d dVar = new d(shopDetailedDependencies);
        this.b = dVar;
        c cVar = new c(shopDetailedDependencies);
        this.c = cVar;
        this.d = DoubleCheck.provider(ShopInfoModule_ProvideInteractorFactory.create(shopInfoModule, dVar, cVar));
        Provider<ShopInfoResourceProvider> provider = DoubleCheck.provider(ShopInfoModule_ProvideResourceProviderFactory.create(shopInfoModule));
        this.e = provider;
        this.f = DoubleCheck.provider(ShopInfoModule_ProvidePresenterFactory.create(shopInfoModule, this.d, this.c, provider));
    }

    public static ShopInfoComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.shop.info.di.ShopInfoComponent
    public void inject(ShopInfoActivity shopInfoActivity) {
        ShopInfoActivity_MembersInjector.injectPresenter(shopInfoActivity, this.f.get());
        ShopInfoActivity_MembersInjector.injectAnalytics(shopInfoActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        ShopInfoActivity_MembersInjector.injectInteractor(shopInfoActivity, this.d.get());
        ShopInfoActivity_MembersInjector.injectActivityIntentFactory(shopInfoActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}
