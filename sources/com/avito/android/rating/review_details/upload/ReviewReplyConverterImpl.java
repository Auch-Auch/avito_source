package com.avito.android.rating.review_details.upload;

import com.avito.android.ratings.ReviewReply;
import com.avito.android.ratings.ReviewReplyStatus;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.review_reply.ReviewReplyResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/rating/review_details/upload/ReviewReplyConverterImpl;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyConverter;", "Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;", "reviewReplyResult", "Lcom/avito/android/ratings/ReviewReply;", "convert", "(Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;)Lcom/avito/android/ratings/ReviewReply;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewReplyConverterImpl implements ReviewReplyConverter {
    @Override // com.avito.android.rating.review_details.upload.ReviewReplyConverter
    @NotNull
    public ReviewReply convert(@NotNull ReviewReplyResult reviewReplyResult) {
        ReviewReplyStatus reviewReplyStatus;
        Intrinsics.checkNotNullParameter(reviewReplyResult, "reviewReplyResult");
        long id = reviewReplyResult.getId();
        String title = reviewReplyResult.getTitle();
        String answerDate = reviewReplyResult.getAnswerDate();
        Image avatar = reviewReplyResult.getAvatar();
        String text = reviewReplyResult.getText();
        Boolean isShop = reviewReplyResult.isShop();
        boolean booleanValue = isShop != null ? isShop.booleanValue() : false;
        String status = reviewReplyResult.getStatus();
        if (status != null) {
            int hashCode = status.hashCode();
            if (hashCode != -2016287450) {
                if (hashCode != -1422950650) {
                    if (hashCode == 568196142 && status.equals("declined")) {
                        reviewReplyStatus = ReviewReplyStatus.DECLINED;
                        return new ReviewReply(id, title, answerDate, avatar, text, booleanValue, reviewReplyStatus, reviewReplyResult.getStatusText(), reviewReplyResult.getRejectMessage(), reviewReplyResult.getLink());
                    }
                } else if (status.equals("active")) {
                    reviewReplyStatus = ReviewReplyStatus.ACTIVE;
                    return new ReviewReply(id, title, answerDate, avatar, text, booleanValue, reviewReplyStatus, reviewReplyResult.getStatusText(), reviewReplyResult.getRejectMessage(), reviewReplyResult.getLink());
                }
            } else if (status.equals("moderation")) {
                reviewReplyStatus = ReviewReplyStatus.MODERATION;
                return new ReviewReply(id, title, answerDate, avatar, text, booleanValue, reviewReplyStatus, reviewReplyResult.getStatusText(), reviewReplyResult.getRejectMessage(), reviewReplyResult.getLink());
            }
        }
        reviewReplyStatus = null;
        return new ReviewReply(id, title, answerDate, avatar, text, booleanValue, reviewReplyStatus, reviewReplyResult.getStatusText(), reviewReplyResult.getRejectMessage(), reviewReplyResult.getLink());
    }
}
