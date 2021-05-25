package com.avito.android.di.module;

import android.content.res.Resources;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsResourceProviderImpl;
import com.avito.android.util.SchedulersFactory3;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/di/module/FavoriteAdvertsPresenterModule;", "", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;", "resourceProvider", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "provideFavoriteAdvertsPresenter$favorite_core_release", "(Lcom/avito/android/favorite/FavoriteAdvertsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;)Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "provideFavoriteAdvertsPresenter", "Landroid/content/res/Resources;", "resources", "provideFavoriteAdvertsResourceProvider$favorite_core_release", "(Landroid/content/res/Resources;)Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;", "provideFavoriteAdvertsResourceProvider", "<init>", "()V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class FavoriteAdvertsPresenterModule {
    @NotNull
    public static final FavoriteAdvertsPresenterModule INSTANCE = new FavoriteAdvertsPresenterModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final FavoriteAdvertsPresenter provideFavoriteAdvertsPresenter$favorite_core_release(@NotNull FavoriteAdvertsInteractor favoriteAdvertsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull FavoriteAdvertsResourceProvider favoriteAdvertsResourceProvider) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(favoriteAdvertsResourceProvider, "resourceProvider");
        return new FavoriteAdvertsPresenterImpl(favoriteAdvertsInteractor, favoriteAdvertsResourceProvider, schedulersFactory3);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final FavoriteAdvertsResourceProvider provideFavoriteAdvertsResourceProvider$favorite_core_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new FavoriteAdvertsResourceProviderImpl(resources);
    }
}
