package com.avito.android.similar_adverts.di;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.server_time.TimeSource;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/avito/android/similar_adverts/di/SimilarAdvertsDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "advertDetailsApi", "()Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "Ljava/util/Locale;", "locale", "()Ljava/util/Locale;", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "()Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "viewedAdvertsDao", "()Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "favoritesSyncDao", "()Lcom/avito/android/db/favorites/FavoritesSyncDao;", "Lcom/avito/android/favorite/FavoriteAdvertsUploadInteractor;", "favoriteAdvertsUploadInteractor", "()Lcom/avito/android/favorite/FavoriteAdvertsUploadInteractor;", "Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "favoriteAdvertsEventInteractor", "()Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "()Lcom/avito/android/account/AccountStateProvider;", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "viewedAdvertsEventInteractor", "()Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface SimilarAdvertsDependencies extends CoreComponentDependencies {
    @NotNull
    AbTestsConfigProvider abTestConfigProvider();

    @NotNull
    AccountStateProvider accountStateProvider();

    @NotNull
    AdvertDetailsApi advertDetailsApi();

    @NotNull
    ConnectivityProvider connectivityProvider();

    @Override // com.avito.android.screen_opener.di.ProfileScreenResolverFragmentDependencies
    @NotNull
    DeepLinkIntentFactory deepLinkIntentFactory();

    @NotNull
    FavoriteAdvertsEventInteractor favoriteAdvertsEventInteractor();

    @NotNull
    FavoriteAdvertsUploadInteractor favoriteAdvertsUploadInteractor();

    @NotNull
    FavoritesSyncDao favoritesSyncDao();

    @NotNull
    Locale locale();

    @NotNull
    TimeSource timeSource();

    @NotNull
    ViewedAdvertsDao viewedAdvertsDao();

    @NotNull
    ViewedAdvertsEventInteractor viewedAdvertsEventInteractor();
}
