package com.avito.android.advert.closed.di;

import com.avito.android.MessengerWorkFactory;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorites.FavoriteAdvertsSyncEventProvider;
import com.avito.android.user_advert.UserAdvertsInfoUpdateRunner;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert/closed/di/ClosedAdvertDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/ServiceIntentFactory;", "serviceIntentFactory", "()Lcom/avito/android/ServiceIntentFactory;", "Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "userAdvertsInfoUpdateRunner", "()Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "Lcom/avito/android/MessengerWorkFactory;", "messengerWorkFactory", "()Lcom/avito/android/MessengerWorkFactory;", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "favoriteAdvertsInteractor", "()Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEventProvider;", "favoriteAdvertsSyncEventProvider", "()Lcom/avito/android/favorites/FavoriteAdvertsSyncEventProvider;", "Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "viewedAdvertsDao", "()Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "viewedAdvertsEventInteractor", "()Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface ClosedAdvertDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.payment.lib.di.PaymentLibraryDependencies
    @NotNull
    AbTestsConfigProvider abTestsConfigProvider();

    @Override // com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    FavoriteAdvertsInteractor favoriteAdvertsInteractor();

    @NotNull
    FavoriteAdvertsSyncEventProvider favoriteAdvertsSyncEventProvider();

    @Override // com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    MessengerWorkFactory messengerWorkFactory();

    @Override // com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    ServiceIntentFactory serviceIntentFactory();

    @Override // com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner();

    @Override // com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    ViewedAdvertsDao viewedAdvertsDao();

    @Override // com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    ViewedAdvertsEventInteractor viewedAdvertsEventInteractor();
}
