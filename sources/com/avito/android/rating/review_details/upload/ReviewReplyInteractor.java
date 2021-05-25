package com.avito.android.rating.review_details.upload;

import com.avito.android.remote.model.review_reply.AddReviewReplyResult;
import com.avito.android.remote.model.review_reply.DeleteReviewReplyResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/rating/review_details/upload/ReviewReplyInteractor;", "", "", "reviewId", "", "text", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/review_reply/AddReviewReplyResult;", "addReviewReply", "(JLjava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "answerId", "Lcom/avito/android/remote/model/review_reply/DeleteReviewReplyResult;", "deleteReviewReply", "(J)Lio/reactivex/rxjava3/core/Observable;", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface ReviewReplyInteractor {
    @NotNull
    Observable<AddReviewReplyResult> addReviewReply(long j, @NotNull String str);

    @NotNull
    Observable<DeleteReviewReplyResult> deleteReviewReply(long j);
}
