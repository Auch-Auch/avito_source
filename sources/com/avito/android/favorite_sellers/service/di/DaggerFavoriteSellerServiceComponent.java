package com.avito.android.favorite_sellers.service.di;

import android.app.Application;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.analytics.Analytics;
import com.avito.android.favorite_sellers.service.FavoriteSellerInteractorImpl;
import com.avito.android.favorite_sellers.service.FavoriteSellerService;
import com.avito.android.favorite_sellers.service.FavoriteSellerService_MembersInjector;
import com.avito.android.favorite_sellers.service.di.FavoriteSellerServiceComponent;
import com.avito.android.remote.FavoriteSellersApi;
import dagger.internal.Preconditions;
public final class DaggerFavoriteSellerServiceComponent implements FavoriteSellerServiceComponent {
    public final FavoriteSellerServiceDependencies a;

    public static final class b implements FavoriteSellerServiceComponent.Builder {
        public FavoriteSellerServiceDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.favorite_sellers.service.di.FavoriteSellerServiceComponent.Builder
        public FavoriteSellerServiceComponent build() {
            Preconditions.checkBuilderRequirement(this.a, FavoriteSellerServiceDependencies.class);
            return new DaggerFavoriteSellerServiceComponent(this.a, null);
        }

        @Override // com.avito.android.favorite_sellers.service.di.FavoriteSellerServiceComponent.Builder
        public FavoriteSellerServiceComponent.Builder dependentOn(FavoriteSellerServiceDependencies favoriteSellerServiceDependencies) {
            this.a = (FavoriteSellerServiceDependencies) Preconditions.checkNotNull(favoriteSellerServiceDependencies);
            return this;
        }
    }

    public DaggerFavoriteSellerServiceComponent(FavoriteSellerServiceDependencies favoriteSellerServiceDependencies, a aVar) {
        this.a = favoriteSellerServiceDependencies;
    }

    public static FavoriteSellerServiceComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.favorite_sellers.service.di.FavoriteSellerServiceComponent
    public void inject(FavoriteSellerService favoriteSellerService) {
        FavoriteSellerService_MembersInjector.injectAnalytics(favoriteSellerService, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        FavoriteSellerService_MembersInjector.injectNotificationManagerCompat(favoriteSellerService, FavoriteSellerServiceModule_ProvideNotificationManagerFactory.provideNotificationManager((Application) Preconditions.checkNotNullFromComponent(this.a.application())));
        FavoriteSellerService_MembersInjector.injectInteractor(favoriteSellerService, new FavoriteSellerInteractorImpl((FavoriteSellersApi) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersApi()), (FavoriteSellersRepository) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersRepository())));
    }
}
