package com.avito.android.shop.write_seller.di;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.shop.remote.ShopsApi;
import com.avito.android.shop.write_seller.WriteSellerActivity;
import com.avito.android.shop.write_seller.WriteSellerActivity_MembersInjector;
import com.avito.android.shop.write_seller.WriteSellerInteractor;
import com.avito.android.shop.write_seller.WriteSellerPresenter;
import com.avito.android.shop.write_seller.di.WriteSellerComponent;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerWriteSellerComponent implements WriteSellerComponent {
    public Provider<ShopsApi> a;
    public Provider<WriteSellerInteractor> b;
    public Provider<AccountStorageInteractor> c;
    public Provider<SchedulersFactory3> d;
    public Provider<WriteSellerPresenter> e;

    public static final class b implements WriteSellerComponent.Builder {
        public ShopDetailedDependencies a;
        public WriteSellerModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.shop.write_seller.di.WriteSellerComponent.Builder
        public WriteSellerComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ShopDetailedDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, WriteSellerModule.class);
            return new DaggerWriteSellerComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.shop.write_seller.di.WriteSellerComponent.Builder
        public WriteSellerComponent.Builder shopDetailedDependencies(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = (ShopDetailedDependencies) Preconditions.checkNotNull(shopDetailedDependencies);
            return this;
        }

        @Override // com.avito.android.shop.write_seller.di.WriteSellerComponent.Builder
        public WriteSellerComponent.Builder writeSellerModule(WriteSellerModule writeSellerModule) {
            this.b = (WriteSellerModule) Preconditions.checkNotNull(writeSellerModule);
            return this;
        }
    }

    public static class c implements Provider<AccountStorageInteractor> {
        public final ShopDetailedDependencies a;

        public c(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStorageInteractor get() {
            return (AccountStorageInteractor) Preconditions.checkNotNullFromComponent(this.a.accountStorageInteractor());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final ShopDetailedDependencies a;

        public d(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class e implements Provider<ShopsApi> {
        public final ShopDetailedDependencies a;

        public e(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShopsApi get() {
            return (ShopsApi) Preconditions.checkNotNullFromComponent(this.a.shopsApi());
        }
    }

    public DaggerWriteSellerComponent(WriteSellerModule writeSellerModule, ShopDetailedDependencies shopDetailedDependencies, a aVar) {
        e eVar = new e(shopDetailedDependencies);
        this.a = eVar;
        Provider<WriteSellerInteractor> provider = DoubleCheck.provider(WriteSellerModule_ProvideWriteSellerInteractorFactory.create(writeSellerModule, eVar));
        this.b = provider;
        c cVar = new c(shopDetailedDependencies);
        this.c = cVar;
        d dVar = new d(shopDetailedDependencies);
        this.d = dVar;
        this.e = DoubleCheck.provider(WriteSellerModule_ProvideWriteSellerPresenterFactory.create(writeSellerModule, provider, cVar, dVar));
    }

    public static WriteSellerComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.shop.write_seller.di.WriteSellerComponent
    public void inject(WriteSellerActivity writeSellerActivity) {
        WriteSellerActivity_MembersInjector.injectPresenter(writeSellerActivity, this.e.get());
    }
}
