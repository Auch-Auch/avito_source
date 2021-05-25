package com.avito.android.rating.details;

import com.avito.android.ratings.ReviewReply;
import com.avito.android.ratings.ReviewReplyStatus;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.review_reply.ReviewReplyResult;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/rating/details/ReviewReplyResultConverterImpl;", "Lcom/avito/android/rating/details/ReviewReplyResultConverter;", "Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;", "reply", "Lcom/avito/android/ratings/ReviewReply;", "convertReply", "(Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;)Lcom/avito/android/ratings/ReviewReply;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewReplyResultConverterImpl implements ReviewReplyResultConverter {
    @Override // com.avito.android.rating.details.ReviewReplyResultConverter
    @Nullable
    public ReviewReply convertReply(@Nullable ReviewReplyResult reviewReplyResult) {
        ReviewReplyStatus reviewReplyStatus = null;
        if (reviewReplyResult == null) {
            return null;
        }
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
                    }
                } else if (status.equals("active")) {
                    reviewReplyStatus = ReviewReplyStatus.ACTIVE;
                }
            } else if (status.equals("moderation")) {
                reviewReplyStatus = ReviewReplyStatus.MODERATION;
            }
        }
        return new ReviewReply(id, title, answerDate, avatar, text, booleanValue, reviewReplyStatus, reviewReplyResult.getStatusText(), reviewReplyResult.getRejectMessage(), reviewReplyResult.getLink());
    }
}
