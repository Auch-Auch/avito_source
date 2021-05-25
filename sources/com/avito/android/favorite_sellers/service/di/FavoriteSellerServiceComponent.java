package com.avito.android.favorite_sellers.service.di;

import androidx.core.app.NotificationCompat;
import com.avito.android.favorite_sellers.service.FavoriteSellerService;
import com.avito.android.notification_manager_provider.NotificationManagerModule;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Component(dependencies = {FavoriteSellerServiceDependencies.class}, modules = {FavoriteSellerServiceModule.class, NotificationManagerModule.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/favorite_sellers/service/di/FavoriteSellerServiceComponent;", "", "Lcom/avito/android/favorite_sellers/service/FavoriteSellerService;", NotificationCompat.CATEGORY_SERVICE, "", "inject", "(Lcom/avito/android/favorite_sellers/service/FavoriteSellerService;)V", "Builder", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteSellerServiceComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/favorite_sellers/service/di/FavoriteSellerServiceComponent$Builder;", "", "Lcom/avito/android/favorite_sellers/service/di/FavoriteSellerServiceDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/favorite_sellers/service/di/FavoriteSellerServiceDependencies;)Lcom/avito/android/favorite_sellers/service/di/FavoriteSellerServiceComponent$Builder;", "Lcom/avito/android/favorite_sellers/service/di/FavoriteSellerServiceComponent;", "build", "()Lcom/avito/android/favorite_sellers/service/di/FavoriteSellerServiceComponent;", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        FavoriteSellerServiceComponent build();

        @NotNull
        Builder dependentOn(@NotNull FavoriteSellerServiceDependencies favoriteSellerServiceDependencies);
    }

    void inject(@NotNull FavoriteSellerService favoriteSellerService);
}
