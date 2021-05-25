package com.avito.android.rating.details;

import com.avito.android.Features;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.user_profile_comment.ReviewStatus;
import com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.rating_details.CommentElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/rating/details/UserProfileRatingDetailsConverter;", "Lcom/avito/android/rating/details/BaseRatingDetailsConverter;", "", "id", "Lcom/avito/android/remote/model/rating_details/CommentElement;", "element", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "convertCommentElement", "(Ljava/lang/String;Lcom/avito/android/remote/model/rating_details/CommentElement;)Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "Lcom/avito/android/rating/details/ReviewReplyResultConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/rating/details/ReviewReplyResultConverter;", "replyConverter", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;Lcom/avito/android/rating/details/ReviewReplyResultConverter;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserProfileRatingDetailsConverter extends BaseRatingDetailsConverter {
    public final ReviewReplyResultConverter b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserProfileRatingDetailsConverter(@NotNull Features features, @NotNull ReviewReplyResultConverter reviewReplyResultConverter) {
        super(features);
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(reviewReplyResultConverter, "replyConverter");
        this.b = reviewReplyResultConverter;
    }

    @Override // com.avito.android.rating.details.BaseRatingDetailsConverter
    @NotNull
    public RatingDetailsItem convertCommentElement(@NotNull String str, @NotNull CommentElement commentElement) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(commentElement, "element");
        return new UserProfileCommentItem(str, commentElement.getReviewId(), commentElement.getTitle(), commentElement.getScore(), commentElement.getAvatar(), commentElement.getText(), commentElement.getStage(), commentElement.getItem(), commentElement.getRated(), commentElement.getCanReply(), this.b.convertReply(commentElement.getReply()), null, null, null, ReviewStatus.NONE, false, commentElement.getImages(), 38912, null);
    }
}
