package com.avito.android.favorite.di;

import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractor;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/favorite/di/FavoriteItemModule;", "", "Lcom/avito/android/favorite/FavoriteAdvertsInteractorImpl;", "interactor", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "bindAdvertsInteractor", "(Lcom/avito/android/favorite/FavoriteAdvertsInteractorImpl;)Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "Lcom/avito/android/analytics/FavoriteAdvertsAnalyticsInteractorImpl;", "Lcom/avito/android/analytics/FavoriteAdvertsAnalyticsInteractor;", "bindAnalyticsInteractor", "(Lcom/avito/android/analytics/FavoriteAdvertsAnalyticsInteractorImpl;)Lcom/avito/android/analytics/FavoriteAdvertsAnalyticsInteractor;", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface FavoriteItemModule {
    @Binds
    @NotNull
    FavoriteAdvertsInteractor bindAdvertsInteractor(@NotNull FavoriteAdvertsInteractorImpl favoriteAdvertsInteractorImpl);

    @Binds
    @NotNull
    FavoriteAdvertsAnalyticsInteractor bindAnalyticsInteractor(@NotNull FavoriteAdvertsAnalyticsInteractorImpl favoriteAdvertsAnalyticsInteractorImpl);
}
