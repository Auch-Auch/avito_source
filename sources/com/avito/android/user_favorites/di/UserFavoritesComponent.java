package com.avito.android.user_favorites.di;

import androidx.fragment.app.Fragment;
import com.avito.android.di.PerActivity;
import com.avito.android.dialog.di.DialogModule;
import com.avito.android.user_favorites.UserFavoritesFragment;
import com.avito.android.user_favorites.adapter.items.di.ItemsTabModule;
import com.avito.android.user_favorites.adapter.search.di.SearchTabModule;
import com.avito.android.user_favorites.adapter.sellers.di.SellersTabModule;
import com.avito.android.user_favorites.adapter.viewed_items.di.ViewedItemsTabModule;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/user_favorites/di/UserFavoritesComponent;", "", "Lcom/avito/android/user_favorites/UserFavoritesFragment;", "activity", "", "inject", "(Lcom/avito/android/user_favorites/UserFavoritesFragment;)V", "Builder", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {UserFavoritesDependencies.class}, modules = {UserFavoritesModule.class, DialogModule.class, ItemsTabModule.class, SearchTabModule.class, SellersTabModule.class, ViewedItemsTabModule.class})
@PerActivity
public interface UserFavoritesComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\b\u0010\fJ\u0019\u0010\b\u001a\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\b\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/user_favorites/di/UserFavoritesComponent$Builder;", "", "Lcom/avito/android/user_favorites/di/UserFavoritesDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/user_favorites/di/UserFavoritesDependencies;)Lcom/avito/android/user_favorites/di/UserFavoritesComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "with", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/user_favorites/di/UserFavoritesComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/user_favorites/di/UserFavoritesComponent$Builder;", "", "startTab", "(I)Lcom/avito/android/user_favorites/di/UserFavoritesComponent$Builder;", "Lcom/avito/android/user_favorites/di/UserFavoritesComponent;", "build", "()Lcom/avito/android/user_favorites/di/UserFavoritesComponent;", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        UserFavoritesComponent build();

        @NotNull
        Builder dependentOn(@NotNull UserFavoritesDependencies userFavoritesDependencies);

        @BindsInstance
        @NotNull
        Builder with(@StartTab int i);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder with(@Nullable Kundle kundle);
    }

    void inject(@NotNull UserFavoritesFragment userFavoritesFragment);
}
