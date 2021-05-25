package com.avito.android.rating.review_details.upload;

import com.avito.android.rating.remote.RatingApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.review_reply.AddReviewReplyResult;
import com.avito.android.remote.model.review_reply.DeleteReviewReplyResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/rating/review_details/upload/ReviewReplyInteractorImpl;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyInteractor;", "", "reviewId", "", "text", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/review_reply/AddReviewReplyResult;", "addReviewReply", "(JLjava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "answerId", "Lcom/avito/android/remote/model/review_reply/DeleteReviewReplyResult;", "deleteReviewReply", "(J)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/rating/remote/RatingApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/remote/RatingApi;", "api", "<init>", "(Lcom/avito/android/rating/remote/RatingApi;Lcom/avito/android/util/SchedulersFactory3;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewReplyInteractorImpl implements ReviewReplyInteractor {
    public final RatingApi a;
    public final SchedulersFactory3 b;

    @Inject
    public ReviewReplyInteractorImpl(@NotNull RatingApi ratingApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(ratingApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = ratingApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.rating.review_details.upload.ReviewReplyInteractor
    @NotNull
    public Observable<AddReviewReplyResult> addReviewReply(long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        Observable<TypedResult<AddReviewReplyResult>> subscribeOn = this.a.addReviewReply(j, str, null).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.addReviewReply(revie…scribeOn(schedulers.io())");
        return TypedObservablesKt.toTyped(subscribeOn);
    }

    @Override // com.avito.android.rating.review_details.upload.ReviewReplyInteractor
    @NotNull
    public Observable<DeleteReviewReplyResult> deleteReviewReply(long j) {
        Observable<TypedResult<DeleteReviewReplyResult>> subscribeOn = this.a.deleteReviewReply(j, null).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.deleteReviewReply(an…scribeOn(schedulers.io())");
        return TypedObservablesKt.toTyped(subscribeOn);
    }
}
