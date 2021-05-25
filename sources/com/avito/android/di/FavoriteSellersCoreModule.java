package com.avito.android.di;

import com.avito.android.FavoriteSellersCounterLoader;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.FavoriteSellersRepositoryImpl;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.common.CounterInteractor;
import com.avito.android.common.CounterInteractorImpl;
import com.avito.android.common.CounterLoader;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/di/FavoriteSellersCoreModule;", "", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/common/CounterLoader;", "counterLoader", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lcom/avito/android/common/CounterInteractor;", "provideFavoritesCounterInteractor", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/common/CounterLoader;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;)Lcom/avito/android/common/CounterInteractor;", "<init>", "()V", "Declarations", "favorite-sellers-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class FavoriteSellersCoreModule {
    @NotNull
    public static final FavoriteSellersCoreModule INSTANCE = new FavoriteSellersCoreModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/di/FavoriteSellersCoreModule$Declarations;", "", "Lcom/avito/android/FavoriteSellersRepositoryImpl;", "interactor", "Lcom/avito/android/FavoriteSellersRepository;", "bindFavoriteSellersRepository", "(Lcom/avito/android/FavoriteSellersRepositoryImpl;)Lcom/avito/android/FavoriteSellersRepository;", "Lcom/avito/android/common/CounterInteractor;", GeoContract.PROVIDER, "Lcom/avito/android/account/plugin/AuthorizationPlugin;", "bindAuthorizationPlugin", "(Lcom/avito/android/common/CounterInteractor;)Lcom/avito/android/account/plugin/AuthorizationPlugin;", "Lcom/avito/android/FavoriteSellersCounterLoader;", "impl", "Lcom/avito/android/common/CounterLoader;", "bindCounterLoader", "(Lcom/avito/android/FavoriteSellersCounterLoader;)Lcom/avito/android/common/CounterLoader;", "favorite-sellers-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @Singleton
        AuthorizationPlugin bindAuthorizationPlugin(@FavoriteSellers @NotNull CounterInteractor counterInteractor);

        @Binds
        @NotNull
        @FavoriteSellers
        @Singleton
        CounterLoader bindCounterLoader(@NotNull FavoriteSellersCounterLoader favoriteSellersCounterLoader);

        @Singleton
        @Binds
        @NotNull
        FavoriteSellersRepository bindFavoriteSellersRepository(@NotNull FavoriteSellersRepositoryImpl favoriteSellersRepositoryImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @FavoriteSellers
    @Singleton
    public static final CounterInteractor provideFavoritesCounterInteractor(@NotNull SchedulersFactory3 schedulersFactory3, @FavoriteSellers @NotNull CounterLoader counterLoader, @NotNull AccountStateProvider accountStateProvider, @NotNull NotificationManagerProvider notificationManagerProvider) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(counterLoader, "counterLoader");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
        return new CounterInteractorImpl(schedulersFactory3, counterLoader, accountStateProvider, notificationManagerProvider);
    }
}
