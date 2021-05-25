package com.avito.android.rating.details;

import com.avito.android.Features;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.comment.CommentItem;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.rating_details.CommentElement;
import com.avito.android.remote.model.review_reply.ReviewReplyResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/rating/details/RatingDetailsConverterImpl;", "Lcom/avito/android/rating/details/BaseRatingDetailsConverter;", "", "id", "Lcom/avito/android/remote/model/rating_details/CommentElement;", "element", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "convertCommentElement", "(Ljava/lang/String;Lcom/avito/android/remote/model/rating_details/CommentElement;)Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingDetailsConverterImpl extends BaseRatingDetailsConverter {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatingDetailsConverterImpl(@NotNull Features features) {
        super(features);
        Intrinsics.checkNotNullParameter(features, "features");
    }

    @Override // com.avito.android.rating.details.BaseRatingDetailsConverter
    @NotNull
    public RatingDetailsItem convertCommentElement(@NotNull String str, @NotNull CommentElement commentElement) {
        CommentItem.Reply reply;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(commentElement, "element");
        String title = commentElement.getTitle();
        Float score = commentElement.getScore();
        Image avatar = commentElement.getAvatar();
        String text = commentElement.getText();
        String stage = commentElement.getStage();
        String item = commentElement.getItem();
        String rated = commentElement.getRated();
        ReviewReplyResult reply2 = commentElement.getReply();
        if (reply2 != null) {
            String title2 = reply2.getTitle();
            String answerDate = reply2.getAnswerDate();
            Image avatar2 = reply2.getAvatar();
            String text2 = reply2.getText();
            Boolean isShop = reply2.isShop();
            reply = new CommentItem.Reply(title2, answerDate, avatar2, text2, isShop != null ? isShop.booleanValue() : false);
        } else {
            reply = null;
        }
        return new CommentItem(str, title, score, avatar, text, stage, item, rated, reply, false, commentElement.getImages(), 512, null);
    }
}
