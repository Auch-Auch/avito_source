package com.avito.android.favorites.di;

import android.content.Context;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.common.CounterInteractor;
import com.avito.android.common.CounterInteractorImpl;
import com.avito.android.common.CounterLoader;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.favorite.di.FavoriteItemModule;
import com.avito.android.favorites.FavoriteAdvertsSyncEventInteractor;
import com.avito.android.favorites.FavoriteAdvertsSyncEventInteractorImpl;
import com.avito.android.favorites.FavoriteAdvertsSyncEventProvider;
import com.avito.android.favorites.FavoriteAdvertsSyncRunner;
import com.avito.android.favorites.FavoriteAdvertsUploadInteractorImpl;
import com.avito.android.favorites.FavoritesCounterLoader;
import com.avito.android.favorites.MutableFavoriteStorage;
import com.avito.android.favorites.PrefFavoriteStorage;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.viewed_items.ViewedItemsCountInteractor;
import com.avito.android.viewed_items.ViewedItemsCountInteractorImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0001\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/favorites/di/FavoritesModule;", "", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/favorites/MutableFavoriteStorage;", "provideMutableFavoriteStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/favorites/MutableFavoriteStorage;", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEventInteractor;", "provideFavoriteAdvertsSyncEventInteractor", "()Lcom/avito/android/favorites/FavoriteAdvertsSyncEventInteractor;", "interactor", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEventProvider;", "provideFavoriteAdvertsSyncEventProvider", "(Lcom/avito/android/favorites/FavoriteAdvertsSyncEventInteractor;)Lcom/avito/android/favorites/FavoriteAdvertsSyncEventProvider;", "Landroid/content/Context;", "context", "Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;", "favoriteAdvertsSyncRunner", "Lcom/avito/android/favorite/FavoriteAdvertsUploadInteractor;", "provideFavoriteAdvertsUploadInteractor", "(Landroid/content/Context;Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;)Lcom/avito/android/favorite/FavoriteAdvertsUploadInteractor;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/common/CounterLoader;", "counterLoader", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lcom/avito/android/common/CounterInteractor;", "provideFavoritesCounterInteractor", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/common/CounterLoader;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;)Lcom/avito/android/common/CounterInteractor;", "<init>", "()V", "Declarations", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {FavoriteItemModule.class, FavoriteAdvertsSyncRunnerModule.class, Declarations.class})
public final class FavoritesModule {
    @NotNull
    public static final FavoritesModule INSTANCE = new FavoritesModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/favorites/di/FavoritesModule$Declarations;", "", "Lcom/avito/android/common/CounterInteractor;", GeoContract.PROVIDER, "Lcom/avito/android/account/plugin/AuthorizationPlugin;", "bindAuthorizationPlugin", "(Lcom/avito/android/common/CounterInteractor;)Lcom/avito/android/account/plugin/AuthorizationPlugin;", "Lcom/avito/android/favorites/FavoritesCounterLoader;", "impl", "Lcom/avito/android/common/CounterLoader;", "bindCounterLoader", "(Lcom/avito/android/favorites/FavoritesCounterLoader;)Lcom/avito/android/common/CounterLoader;", "Lcom/avito/android/viewed_items/ViewedItemsCountInteractorImpl;", "Lcom/avito/android/viewed_items/ViewedItemsCountInteractor;", "bindViewedItemsCountInteractor", "(Lcom/avito/android/viewed_items/ViewedItemsCountInteractorImpl;)Lcom/avito/android/viewed_items/ViewedItemsCountInteractor;", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @Singleton
        AuthorizationPlugin bindAuthorizationPlugin(@Favorites @NotNull CounterInteractor counterInteractor);

        @Binds
        @NotNull
        @Favorites
        @Singleton
        CounterLoader bindCounterLoader(@NotNull FavoritesCounterLoader favoritesCounterLoader);

        @Singleton
        @Binds
        @NotNull
        ViewedItemsCountInteractor bindViewedItemsCountInteractor(@NotNull ViewedItemsCountInteractorImpl viewedItemsCountInteractorImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final FavoriteAdvertsSyncEventInteractor provideFavoriteAdvertsSyncEventInteractor() {
        return new FavoriteAdvertsSyncEventInteractorImpl();
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final FavoriteAdvertsSyncEventProvider provideFavoriteAdvertsSyncEventProvider(@NotNull FavoriteAdvertsSyncEventInteractor favoriteAdvertsSyncEventInteractor) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsSyncEventInteractor, "interactor");
        return favoriteAdvertsSyncEventInteractor;
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final FavoriteAdvertsUploadInteractor provideFavoriteAdvertsUploadInteractor(@NotNull Context context, @NotNull FavoriteAdvertsSyncRunner favoriteAdvertsSyncRunner) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(favoriteAdvertsSyncRunner, "favoriteAdvertsSyncRunner");
        return new FavoriteAdvertsUploadInteractorImpl(context, favoriteAdvertsSyncRunner);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Favorites
    @Singleton
    public static final CounterInteractor provideFavoritesCounterInteractor(@NotNull SchedulersFactory3 schedulersFactory3, @Favorites @NotNull CounterLoader counterLoader, @NotNull AccountStateProvider accountStateProvider, @NotNull NotificationManagerProvider notificationManagerProvider) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(counterLoader, "counterLoader");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
        return new CounterInteractorImpl(schedulersFactory3, counterLoader, accountStateProvider, notificationManagerProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final MutableFavoriteStorage provideMutableFavoriteStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        return new PrefFavoriteStorage(preferences);
    }
}
