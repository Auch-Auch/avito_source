package com.avito.android.rating.user_review_details;

import com.avito.android.rating.remote.RatingApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/rating/user_review_details/UserReviewDetailsInteractorImpl;", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsInteractor;", "", "reviewId", "Lio/reactivex/rxjava3/core/Completable;", "deleteReview", "(Ljava/lang/Long;)Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/rating/remote/RatingApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/remote/RatingApi;", "api", "<init>", "(Lcom/avito/android/rating/remote/RatingApi;Lcom/avito/android/util/SchedulersFactory3;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserReviewDetailsInteractorImpl implements UserReviewDetailsInteractor {
    public final RatingApi a;
    public final SchedulersFactory3 b;

    @Inject
    public UserReviewDetailsInteractorImpl(@NotNull RatingApi ratingApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(ratingApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = ratingApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsInteractor
    @NotNull
    public Completable deleteReview(@Nullable Long l) {
        if (l == null) {
            Completable error = Completable.error(new IllegalArgumentException("review id must be not null"));
            Intrinsics.checkNotNullExpressionValue(error, "Completable.error(Illega…ew id must be not null\"))");
            return error;
        }
        Observable<TypedResult<Unit>> subscribeOn = this.a.deleteReview(l.longValue()).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.deleteReview(reviewI…scribeOn(schedulers.io())");
        Completable ignoreElements = TypedObservablesKt.toTyped(subscribeOn).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "api.deleteReview(reviewI…        .ignoreElements()");
        return ignoreElements;
    }
}
