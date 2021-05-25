package com.avito.android.advert.di;

import com.avito.android.advert.AdvertDetailsActivity;
import com.avito.android.advert.di.AdvertActivityComponent;
import dagger.internal.Preconditions;
public final class DaggerAdvertActivityComponent implements AdvertActivityComponent {

    public static final class b implements AdvertActivityComponent.Builder {
        public AdvertActivityDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.advert.di.AdvertActivityComponent.Builder
        public AdvertActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AdvertActivityDependencies.class);
            return new DaggerAdvertActivityComponent(this.a);
        }

        @Override // com.avito.android.advert.di.AdvertActivityComponent.Builder
        public AdvertActivityComponent.Builder dependencies(AdvertActivityDependencies advertActivityDependencies) {
            this.a = (AdvertActivityDependencies) Preconditions.checkNotNull(advertActivityDependencies);
            return this;
        }
    }

    public DaggerAdvertActivityComponent() {
    }

    public static AdvertActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.advert.di.AdvertActivityComponent
    public void inject(AdvertDetailsActivity advertDetailsActivity) {
    }

    public DaggerAdvertActivityComponent(AdvertActivityDependencies advertActivityDependencies) {
    }
}
