package com.avito.android.rating.review_details.upload.di;

import com.avito.android.rating.remote.RatingApi;
import com.avito.android.rating.review_details.upload.ReplyUploadPresenter;
import com.avito.android.rating.review_details.upload.ReplyUploadPresenterImpl;
import com.avito.android.rating.review_details.upload.ReviewReplyConverter;
import com.avito.android.rating.review_details.upload.ReviewReplyConverterImpl;
import com.avito.android.rating.review_details.upload.ReviewReplyInteractor;
import com.avito.android.rating.review_details.upload.ReviewReplyInteractorImpl;
import com.avito.android.rating.review_details.upload.ReviewReplyProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/avito/android/rating/review_details/upload/di/ReviewReplyModule;", "", "Lcom/avito/android/rating/review_details/upload/ReviewReplyInteractor;", "reviewReplyInteractor", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/rating/review_details/upload/ReviewReplyConverter;", "converter", "Lcom/avito/android/rating/review_details/upload/ReplyUploadPresenterImpl;", "provideUploadPresenterImpl", "(Lcom/avito/android/rating/review_details/upload/ReviewReplyInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/rating/review_details/upload/ReviewReplyConverter;)Lcom/avito/android/rating/review_details/upload/ReplyUploadPresenterImpl;", "presenterImpl", "Lcom/avito/android/rating/review_details/upload/ReplyUploadPresenter;", "providePresenter", "(Lcom/avito/android/rating/review_details/upload/ReplyUploadPresenterImpl;)Lcom/avito/android/rating/review_details/upload/ReplyUploadPresenter;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyProvider;", "provideReviewReplyProvider", "(Lcom/avito/android/rating/review_details/upload/ReplyUploadPresenterImpl;)Lcom/avito/android/rating/review_details/upload/ReviewReplyProvider;", "provideConverter", "()Lcom/avito/android/rating/review_details/upload/ReviewReplyConverter;", "Lcom/avito/android/rating/remote/RatingApi;", "api", "provideReviewReplyInteractor", "(Lcom/avito/android/rating/remote/RatingApi;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/rating/review_details/upload/ReviewReplyInteractor;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ReviewReplyModule {
    @Provides
    @Singleton
    @NotNull
    public final ReviewReplyConverter provideConverter() {
        return new ReviewReplyConverterImpl();
    }

    @Provides
    @Singleton
    @NotNull
    public final ReplyUploadPresenter providePresenter(@NotNull ReplyUploadPresenterImpl replyUploadPresenterImpl) {
        Intrinsics.checkNotNullParameter(replyUploadPresenterImpl, "presenterImpl");
        return replyUploadPresenterImpl;
    }

    @Provides
    @Singleton
    @NotNull
    public final ReviewReplyInteractor provideReviewReplyInteractor(@NotNull RatingApi ratingApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(ratingApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        return new ReviewReplyInteractorImpl(ratingApi, schedulersFactory3);
    }

    @Provides
    @Singleton
    @NotNull
    public final ReviewReplyProvider provideReviewReplyProvider(@NotNull ReplyUploadPresenterImpl replyUploadPresenterImpl) {
        Intrinsics.checkNotNullParameter(replyUploadPresenterImpl, "presenterImpl");
        return replyUploadPresenterImpl;
    }

    @Provides
    @Singleton
    @NotNull
    public final ReplyUploadPresenterImpl provideUploadPresenterImpl(@NotNull ReviewReplyInteractor reviewReplyInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ReviewReplyConverter reviewReplyConverter) {
        Intrinsics.checkNotNullParameter(reviewReplyInteractor, "reviewReplyInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(reviewReplyConverter, "converter");
        return new ReplyUploadPresenterImpl(reviewReplyInteractor, schedulersFactory3, reviewReplyConverter);
    }
}
