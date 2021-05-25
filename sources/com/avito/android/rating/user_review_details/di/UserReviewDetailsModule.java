package com.avito.android.rating.user_review_details.di;

import com.avito.android.rating.user_review_details.UserReviewDetailsInteractor;
import com.avito.android.rating.user_review_details.UserReviewDetailsInteractorImpl;
import com.avito.android.rating.user_review_details.UserReviewDetailsPresenter;
import com.avito.android.rating.user_review_details.UserReviewDetailsPresenterImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/rating/user_review_details/di/UserReviewDetailsModule;", "", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenterImpl;", "presenter", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter;", "bindUserReviewDetailsPresenter", "(Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenterImpl;)Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter;", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsInteractorImpl;", "interactor", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsInteractor;", "bindUserReviewDetailsInteractor", "(Lcom/avito/android/rating/user_review_details/UserReviewDetailsInteractorImpl;)Lcom/avito/android/rating/user_review_details/UserReviewDetailsInteractor;", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface UserReviewDetailsModule {
    @Binds
    @NotNull
    UserReviewDetailsInteractor bindUserReviewDetailsInteractor(@NotNull UserReviewDetailsInteractorImpl userReviewDetailsInteractorImpl);

    @Binds
    @NotNull
    UserReviewDetailsPresenter bindUserReviewDetailsPresenter(@NotNull UserReviewDetailsPresenterImpl userReviewDetailsPresenterImpl);
}
