package com.avito.android.favorites.di;

import android.content.res.Resources;
import androidx.core.app.NotificationCompat;
import com.avito.android.di.PerService;
import com.avito.android.favorites.FavoriteAdvertsService;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/favorites/di/FavoriteAdvertsServiceComponent;", "", "Lcom/avito/android/favorites/FavoriteAdvertsService;", NotificationCompat.CATEGORY_SERVICE, "", "inject", "(Lcom/avito/android/favorites/FavoriteAdvertsService;)V", "Builder", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
@PerService
@Component(dependencies = {FavoriteAdvertsServiceDependencies.class}, modules = {FavoriteAdvertsServiceModule.class})
public interface FavoriteAdvertsServiceComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/favorites/di/FavoriteAdvertsServiceComponent$Builder;", "", "Lcom/avito/android/favorites/di/FavoriteAdvertsServiceDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/favorites/di/FavoriteAdvertsServiceDependencies;)Lcom/avito/android/favorites/di/FavoriteAdvertsServiceComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/favorites/di/FavoriteAdvertsServiceComponent$Builder;", "Lcom/avito/android/favorites/di/FavoriteAdvertsServiceComponent;", "build", "()Lcom/avito/android/favorites/di/FavoriteAdvertsServiceComponent;", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        FavoriteAdvertsServiceComponent build();

        @NotNull
        Builder dependentOn(@NotNull FavoriteAdvertsServiceDependencies favoriteAdvertsServiceDependencies);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);
    }

    void inject(@NotNull FavoriteAdvertsService favoriteAdvertsService);
}
