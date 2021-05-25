package com.avito.android.rating.user_reviews;

import android.net.Uri;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.user_reviews.UserReviewsResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/rating/user_reviews/UserReviewsInteractorImpl;", "Lcom/avito/android/rating/user_reviews/UserReviewsInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/user_reviews/UserReviewsResult;", "getItems", "()Lio/reactivex/rxjava3/core/Observable;", "Landroid/net/Uri;", "nextPage", "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/rating/remote/RatingApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/remote/RatingApi;", "api", "<init>", "(Lcom/avito/android/rating/remote/RatingApi;Lcom/avito/android/util/SchedulersFactory3;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserReviewsInteractorImpl implements UserReviewsInteractor {
    public final RatingApi a;
    public final SchedulersFactory3 b;

    @Inject
    public UserReviewsInteractorImpl(@NotNull RatingApi ratingApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(ratingApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = ratingApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsInteractor
    @NotNull
    public Observable<UserReviewsResult> getItems() {
        Observable<TypedResult<UserReviewsResult>> subscribeOn = this.a.getUserReviews().subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getUserReviews()\n   …scribeOn(schedulers.io())");
        return TypedObservablesKt.toTyped(subscribeOn);
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsInteractor
    @NotNull
    public Observable<UserReviewsResult> getItems(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "nextPage");
        RatingApi ratingApi = this.a;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "nextPage.toString()");
        Observable<TypedResult<UserReviewsResult>> subscribeOn = ratingApi.getUserReviews(uri2).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getUserReviews(nextP…scribeOn(schedulers.io())");
        return TypedObservablesKt.toTyped(subscribeOn);
    }
}
