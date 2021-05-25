package com.avito.android.rating.user_reviews;

import com.avito.android.rating.details.ReviewReplyResultConverter;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/rating/user_reviews/ReviewItemConverterImpl;", "Lcom/avito/android/rating/user_reviews/ReviewItemConverter;", "Lcom/avito/android/remote/model/user_reviews/ReviewElement;", "element", "", "id", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "convert", "(Lcom/avito/android/remote/model/user_reviews/ReviewElement;Ljava/lang/String;)Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "Lcom/avito/android/rating/details/ReviewReplyResultConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/details/ReviewReplyResultConverter;", "replyConverter", "<init>", "(Lcom/avito/android/rating/details/ReviewReplyResultConverter;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewItemConverterImpl implements ReviewItemConverter {
    public final ReviewReplyResultConverter a;

    @Inject
    public ReviewItemConverterImpl(@NotNull ReviewReplyResultConverter reviewReplyResultConverter) {
        Intrinsics.checkNotNullParameter(reviewReplyResultConverter, "replyConverter");
        this.a = reviewReplyResultConverter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a8  */
    @Override // com.avito.android.rating.user_reviews.ReviewItemConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.rating.details.adapter.RatingDetailsItem convert(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.user_reviews.ReviewElement r23, @org.jetbrains.annotations.NotNull java.lang.String r24) {
        /*
            r22 = this;
            r0 = r23
            java.lang.String r1 = "element"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "id"
            r3 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            boolean r1 = r0 instanceof com.avito.android.remote.model.user_reviews.RatingElement
            if (r1 == 0) goto L_0x00c2
            com.avito.android.remote.model.user_reviews.RatingElement r0 = (com.avito.android.remote.model.user_reviews.RatingElement) r0
            java.lang.Long r4 = r0.getReviewId()
            java.lang.String r5 = r0.getTitle()
            java.lang.Float r6 = r0.getScore()
            com.avito.android.remote.model.Image r7 = r0.getAvatar()
            java.lang.String r8 = r0.getText()
            java.lang.String r9 = r0.getStageTitle()
            java.lang.String r10 = r0.getItemTitle()
            java.lang.String r11 = r0.getCreatedAt()
            java.lang.Boolean r12 = java.lang.Boolean.FALSE
            r1 = r22
            com.avito.android.rating.details.ReviewReplyResultConverter r2 = r1.a
            com.avito.android.remote.model.review_reply.ReviewReplyResult r13 = r0.getAnswer()
            com.avito.android.ratings.ReviewReply r13 = r2.convertReply(r13)
            java.lang.String r16 = r0.getStatusText()
            java.lang.String r2 = r0.getStatus()
            if (r2 != 0) goto L_0x004d
            goto L_0x0082
        L_0x004d:
            int r14 = r2.hashCode()
            r15 = -2016287450(0xffffffff87d1e526, float:-3.1581506E-34)
            if (r14 == r15) goto L_0x0077
            r15 = 568196142(0x21ddfc2e, float:1.5042294E-18)
            if (r14 == r15) goto L_0x006c
            r15 = 1447404014(0x5645a1ee, float:5.4324818E13)
            if (r14 == r15) goto L_0x0061
            goto L_0x0082
        L_0x0061:
            java.lang.String r14 = "published"
            boolean r2 = r2.equals(r14)
            if (r2 == 0) goto L_0x0082
            com.avito.android.rating.details.adapter.user_profile_comment.ReviewStatus r2 = com.avito.android.rating.details.adapter.user_profile_comment.ReviewStatus.PUBLISHED
            goto L_0x0084
        L_0x006c:
            java.lang.String r14 = "declined"
            boolean r2 = r2.equals(r14)
            if (r2 == 0) goto L_0x0082
            com.avito.android.rating.details.adapter.user_profile_comment.ReviewStatus r2 = com.avito.android.rating.details.adapter.user_profile_comment.ReviewStatus.DECLINED
            goto L_0x0084
        L_0x0077:
            java.lang.String r14 = "moderation"
            boolean r2 = r2.equals(r14)
            if (r2 == 0) goto L_0x0082
            com.avito.android.rating.details.adapter.user_profile_comment.ReviewStatus r2 = com.avito.android.rating.details.adapter.user_profile_comment.ReviewStatus.MODERATION
            goto L_0x0084
        L_0x0082:
            com.avito.android.rating.details.adapter.user_profile_comment.ReviewStatus r2 = com.avito.android.rating.details.adapter.user_profile_comment.ReviewStatus.NONE
        L_0x0084:
            r17 = r2
            java.lang.String r14 = r0.getRejectMessage()
            com.avito.android.remote.model.user_reviews.Recipient r2 = r0.getRecipient()
            if (r2 == 0) goto L_0x00a8
            com.avito.android.user_review.RecipientData r15 = new com.avito.android.user_review.RecipientData
            java.lang.String r1 = r2.getTitle()
            boolean r3 = r2.isShop()
            r23 = r14
            com.avito.android.remote.model.Image r14 = r2.getAvatar()
            com.avito.android.deep_linking.links.DeepLink r2 = r2.getLink()
            r15.<init>(r1, r3, r14, r2)
            goto L_0x00ac
        L_0x00a8:
            r23 = r14
            r1 = 0
            r15 = r1
        L_0x00ac:
            r18 = 0
            java.util.List r19 = r0.getImages()
            r20 = 32768(0x8000, float:4.5918E-41)
            r21 = 0
            com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItem r0 = new com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItem
            r2 = r0
            r3 = r24
            r14 = r23
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        L_0x00c2:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unknown element type "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.rating.user_reviews.ReviewItemConverterImpl.convert(com.avito.android.remote.model.user_reviews.ReviewElement, java.lang.String):com.avito.android.rating.details.adapter.RatingDetailsItem");
    }
}
