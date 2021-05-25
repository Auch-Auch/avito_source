package com.avito.android.favorites.di;

import android.content.Context;
import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.favorites.FavoritesFragment;
import com.avito.android.favorites.action.FavoriteItemAction;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/favorites/di/FavoriteAdvertsComponent;", "", "Lcom/avito/android/favorites/FavoritesFragment;", "fragment", "", "inject", "(Lcom/avito/android/favorites/FavoritesFragment;)V", "Builder", "favorites_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {FavoriteAdvertsDependencies.class}, modules = {FavoriteAdvertsModule.class, FavoriteTrackerModule.class})
@PerFragment
public interface FavoriteAdvertsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/favorites/di/FavoriteAdvertsComponent$Builder;", "", "Lcom/avito/android/favorites/di/FavoriteAdvertsDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/favorites/di/FavoriteAdvertsDependencies;)Lcom/avito/android/favorites/di/FavoriteAdvertsComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/favorites/di/FavoriteAdvertsComponent$Builder;", "Landroid/content/Context;", "context", "withContext", "(Landroid/content/Context;)Lcom/avito/android/favorites/di/FavoriteAdvertsComponent$Builder;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/favorites/action/FavoriteItemAction;", "relay", "withActionRelay", "(Lcom/jakewharton/rxrelay2/PublishRelay;)Lcom/avito/android/favorites/di/FavoriteAdvertsComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/favorites/di/FavoriteAdvertsComponent$Builder;", "Lcom/avito/android/favorites/di/FavoriteAdvertsComponent;", "build", "()Lcom/avito/android/favorites/di/FavoriteAdvertsComponent;", "favorites_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        FavoriteAdvertsComponent build();

        @NotNull
        Builder dependentOn(@NotNull FavoriteAdvertsDependencies favoriteAdvertsDependencies);

        @BindsInstance
        @NotNull
        Builder withActionRelay(@NotNull PublishRelay<FavoriteItemAction> publishRelay);

        @BindsInstance
        @NotNull
        Builder withContext(@NotNull Context context);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);
    }

    void inject(@NotNull FavoritesFragment favoritesFragment);
}
