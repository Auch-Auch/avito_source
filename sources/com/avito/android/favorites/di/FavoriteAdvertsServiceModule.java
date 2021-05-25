package com.avito.android.favorites.di;

import com.avito.android.di.PerService;
import com.avito.android.favorites.FavoriteAdvertItemConverter;
import com.avito.android.favorites.FavoriteAdvertItemConverterImpl;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProvider;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProviderImpl;
import com.avito.android.favorites.FavoriteAdvertsServiceInteractor;
import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.util.AdvertPriceFormatter;
import com.avito.android.util.Formatter;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/favorites/di/FavoriteAdvertsServiceModule;", "", "Lcom/avito/android/favorites/FavoriteAdvertItemConverterImpl;", "converter", "Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "bindFavoriteAdvertItemConverter", "(Lcom/avito/android/favorites/FavoriteAdvertItemConverterImpl;)Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProvider;", "bindFavoriteAdvertItemConverterResourceProvider", "(Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProviderImpl;)Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProvider;", "Lcom/avito/android/util/AdvertPriceFormatter;", "formatter", "Lcom/avito/android/util/Formatter;", "Lcom/avito/android/remote/model/AdvertPrice;", "bindAdvertPriceFormatter", "(Lcom/avito/android/util/AdvertPriceFormatter;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/favorites/FavoriteAdvertsServiceInteractorImpl;", "impl", "Lcom/avito/android/favorites/FavoriteAdvertsServiceInteractor;", "bindInteractor", "(Lcom/avito/android/favorites/FavoriteAdvertsServiceInteractorImpl;)Lcom/avito/android/favorites/FavoriteAdvertsServiceInteractor;", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface FavoriteAdvertsServiceModule {
    @Binds
    @NotNull
    @PerService
    Formatter<AdvertPrice> bindAdvertPriceFormatter(@NotNull AdvertPriceFormatter advertPriceFormatter);

    @PerService
    @Binds
    @NotNull
    FavoriteAdvertItemConverter bindFavoriteAdvertItemConverter(@NotNull FavoriteAdvertItemConverterImpl favoriteAdvertItemConverterImpl);

    @PerService
    @Binds
    @NotNull
    FavoriteAdvertItemConverterResourceProvider bindFavoriteAdvertItemConverterResourceProvider(@NotNull FavoriteAdvertItemConverterResourceProviderImpl favoriteAdvertItemConverterResourceProviderImpl);

    @PerService
    @Binds
    @NotNull
    FavoriteAdvertsServiceInteractor bindInteractor(@NotNull FavoriteAdvertsServiceInteractorImpl favoriteAdvertsServiceInteractorImpl);
}
