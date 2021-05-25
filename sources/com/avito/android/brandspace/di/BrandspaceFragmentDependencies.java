package com.avito.android.brandspace.di;

import com.avito.android.IdProvider;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.brandspace.remote.BrandspaceApi;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.AdvertItemAbDependencies;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.server_time.TimeSource;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H&¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H&¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H&¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H&¢\u0006\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/avito/android/brandspace/di/BrandspaceFragmentDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/di/AdvertItemAbDependencies;", "Lcom/avito/android/brandspace/remote/BrandspaceApi;", "brandspaceApi", "()Lcom/avito/android/brandspace/remote/BrandspaceApi;", "Lcom/avito/android/remote/SearchApi;", "searchApi", "()Lcom/avito/android/remote/SearchApi;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "Ljava/util/Locale;", "locale", "()Ljava/util/Locale;", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "()Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/IdProvider;", "idGenerator", "()Lcom/avito/android/IdProvider;", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "()Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "()Lcom/avito/android/account/AccountStateProvider;", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "favoritesSyncDao", "()Lcom/avito/android/db/favorites/FavoritesSyncDao;", "Lcom/avito/android/favorite/FavoriteAdvertsUploadInteractor;", "favoriteAdvertsUploadInteractor", "()Lcom/avito/android/favorite/FavoriteAdvertsUploadInteractor;", "Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "favoriteAdvertsEventInteractor", "()Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface BrandspaceFragmentDependencies extends CoreComponentDependencies, AdvertItemAbDependencies {
    @Override // com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AbTestsConfigProvider abTestConfigProvider();

    @Override // com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AccountStateProvider accountStateProvider();

    @NotNull
    BrandspaceApi brandspaceApi();

    @Override // com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    ConnectivityProvider connectivityProvider();

    @NotNull
    DeepLinkFactory deepLinkFactory();

    @Override // com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies, com.avito.android.screen_opener.di.ProfileScreenResolverFragmentDependencies
    @NotNull
    DeepLinkIntentFactory deepLinkIntentFactory();

    @Override // com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    FavoriteAdvertsEventInteractor favoriteAdvertsEventInteractor();

    @Override // com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    FavoriteAdvertsUploadInteractor favoriteAdvertsUploadInteractor();

    @Override // com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    FavoritesSyncDao favoritesSyncDao();

    @Override // com.avito.android.player.di.PlayerFragmentDependencies
    @NotNull
    IdProvider idGenerator();

    @Override // com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    Locale locale();

    @NotNull
    SearchApi searchApi();

    @Override // com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();

    @Override // com.avito.android.player.di.PlayerFragmentDependencies
    @NotNull
    TreeStateIdGenerator treeStateIdGenerator();

    @Override // com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationsListDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.verification.di.VerificationActionDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    TypedErrorThrowableConverter typedErrorThrowableConverter();
}
