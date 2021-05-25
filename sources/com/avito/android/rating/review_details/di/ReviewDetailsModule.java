package com.avito.android.rating.review_details.di;

import com.avito.android.rating.review_details.ReviewDetailsPresenter;
import com.avito.android.rating.review_details.ReviewDetailsPresenterImpl;
import com.avito.android.rating.review_details.reply.ReviewReplyPresenter;
import com.avito.android.rating.review_details.reply.ReviewReplyPresenterImpl;
import com.avito.android.rating.review_details.upload.ReviewReplyInteractor;
import com.avito.android.rating.review_details.upload.ReviewReplyInteractorImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/rating/review_details/di/ReviewDetailsModule;", "", "Lcom/avito/android/rating/review_details/ReviewDetailsPresenterImpl;", "presenter", "Lcom/avito/android/rating/review_details/ReviewDetailsPresenter;", "bindReviewDetailsPresenter", "(Lcom/avito/android/rating/review_details/ReviewDetailsPresenterImpl;)Lcom/avito/android/rating/review_details/ReviewDetailsPresenter;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyInteractorImpl;", "interactor", "Lcom/avito/android/rating/review_details/upload/ReviewReplyInteractor;", "bindReviewReplyInteractor", "(Lcom/avito/android/rating/review_details/upload/ReviewReplyInteractorImpl;)Lcom/avito/android/rating/review_details/upload/ReviewReplyInteractor;", "Lcom/avito/android/rating/review_details/reply/ReviewReplyPresenterImpl;", "Lcom/avito/android/rating/review_details/reply/ReviewReplyPresenter;", "bindReviewReplyPresenter", "(Lcom/avito/android/rating/review_details/reply/ReviewReplyPresenterImpl;)Lcom/avito/android/rating/review_details/reply/ReviewReplyPresenter;", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface ReviewDetailsModule {
    @Binds
    @NotNull
    ReviewDetailsPresenter bindReviewDetailsPresenter(@NotNull ReviewDetailsPresenterImpl reviewDetailsPresenterImpl);

    @Binds
    @NotNull
    ReviewReplyInteractor bindReviewReplyInteractor(@NotNull ReviewReplyInteractorImpl reviewReplyInteractorImpl);

    @Binds
    @NotNull
    ReviewReplyPresenter bindReviewReplyPresenter(@NotNull ReviewReplyPresenterImpl reviewReplyPresenterImpl);
}
