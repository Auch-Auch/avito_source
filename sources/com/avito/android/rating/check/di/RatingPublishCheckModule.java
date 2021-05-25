package com.avito.android.rating.check.di;

import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.di.PerActivity;
import com.avito.android.rating.check.RatingPublishCheckInteractor;
import com.avito.android.rating.check.RatingPublishCheckInteractorImpl;
import com.avito.android.rating.check.RatingPublishCheckPresenter;
import com.avito.android.rating.check.RatingPublishCheckPresenterImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/rating/check/di/RatingPublishCheckModule;", "", "Lcom/avito/android/rating/check/RatingPublishCheckInteractorImpl;", "interactor", "Lcom/avito/android/rating/check/RatingPublishCheckInteractor;", "bindRatingPublishCheckInteractor", "(Lcom/avito/android/rating/check/RatingPublishCheckInteractorImpl;)Lcom/avito/android/rating/check/RatingPublishCheckInteractor;", "Lcom/avito/android/rating/check/RatingPublishCheckPresenterImpl;", "presenter", "Lcom/avito/android/rating/check/RatingPublishCheckPresenter;", "bindRatingPublishCheckPresenter", "(Lcom/avito/android/rating/check/RatingPublishCheckPresenterImpl;)Lcom/avito/android/rating/check/RatingPublishCheckPresenter;", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker$Impl;", "resolver", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "UnknownScreenTracker", "(Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker$Impl;)Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface RatingPublishCheckModule {
    @PerActivity
    @Binds
    @NotNull
    UnknownScreenTracker UnknownScreenTracker(@NotNull UnknownScreenTracker.Impl impl);

    @PerActivity
    @Binds
    @NotNull
    RatingPublishCheckInteractor bindRatingPublishCheckInteractor(@NotNull RatingPublishCheckInteractorImpl ratingPublishCheckInteractorImpl);

    @PerActivity
    @Binds
    @NotNull
    RatingPublishCheckPresenter bindRatingPublishCheckPresenter(@NotNull RatingPublishCheckPresenterImpl ratingPublishCheckPresenterImpl);
}
