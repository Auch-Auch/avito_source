package com.avito.android.shop.detailed.di;

import com.avito.android.shop.detailed.ShopDetailedActivity;
import com.avito.android.shop.detailed.di.ShopDetailedActivityComponent;
import dagger.internal.Preconditions;
public final class DaggerShopDetailedActivityComponent implements ShopDetailedActivityComponent {

    public static final class b implements ShopDetailedActivityComponent.Builder {
        public ShopDetailedDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.shop.detailed.di.ShopDetailedActivityComponent.Builder
        public ShopDetailedActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ShopDetailedDependencies.class);
            return new DaggerShopDetailedActivityComponent(this.a);
        }

        @Override // com.avito.android.shop.detailed.di.ShopDetailedActivityComponent.Builder
        public ShopDetailedActivityComponent.Builder dependencies(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = (ShopDetailedDependencies) Preconditions.checkNotNull(shopDetailedDependencies);
            return this;
        }
    }

    public DaggerShopDetailedActivityComponent() {
    }

    public static ShopDetailedActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.shop.detailed.di.ShopDetailedActivityComponent
    public void inject(ShopDetailedActivity shopDetailedActivity) {
    }

    public DaggerShopDetailedActivityComponent(ShopDetailedDependencies shopDetailedDependencies) {
    }
}
