package com.avito.android.rating.user_reviews;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/rating/user_reviews/ItemToReviewDataConverterImpl;", "Lcom/avito/android/rating/user_reviews/ItemToReviewDataConverter;", "Lcom/avito/android/rating/details/adapter/user_profile_comment/UserProfileCommentItem;", "item", "Lcom/avito/android/user_review/UserReviewData;", "convert", "(Lcom/avito/android/rating/details/adapter/user_profile_comment/UserProfileCommentItem;)Lcom/avito/android/user_review/UserReviewData;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ItemToReviewDataConverterImpl implements ItemToReviewDataConverter {
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0081  */
    @Override // com.avito.android.rating.user_reviews.ItemToReviewDataConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.user_review.UserReviewData convert(@org.jetbrains.annotations.NotNull com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItem r14) {
        /*
            r13 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.Long r2 = r14.getReviewId()
            java.lang.Float r3 = r14.getScore()
            com.avito.android.ratings.ReviewReply r0 = r14.getReply()
            r1 = 0
            if (r0 == 0) goto L_0x0039
            com.avito.android.ratings.ReviewReply r0 = r14.getReply()
            if (r0 == 0) goto L_0x0058
            com.avito.android.user_review.RecipientProfile r11 = new com.avito.android.user_review.RecipientProfile
            java.lang.String r5 = r0.getTitle()
            boolean r6 = r0.isShop()
            com.avito.android.remote.model.Image r7 = r0.getAvatar()
            com.avito.android.deep_linking.links.DeepLink r8 = r0.getLink()
            java.lang.String r9 = r0.getText()
            java.lang.String r10 = r0.getAnswerDate()
            r4 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            goto L_0x0059
        L_0x0039:
            com.avito.android.user_review.RecipientData r0 = r14.getRecipientData()
            if (r0 == 0) goto L_0x0058
            com.avito.android.user_review.RecipientProfile r11 = new com.avito.android.user_review.RecipientProfile
            java.lang.String r5 = r0.getName()
            boolean r6 = r0.isShop()
            com.avito.android.remote.model.Image r7 = r0.getAvatar()
            com.avito.android.deep_linking.links.DeepLink r8 = r0.getLink()
            r9 = 0
            r10 = 0
            r4 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            goto L_0x0059
        L_0x0058:
            r11 = r1
        L_0x0059:
            r4 = r11
            com.avito.android.user_review.UserProfileData r11 = new com.avito.android.user_review.UserProfileData
            java.lang.String r0 = r14.getName()
            com.avito.android.remote.model.Image r5 = r14.getAvatar()
            r11.<init>(r0, r5)
            java.lang.String r5 = r14.getMessage()
            java.lang.String r6 = r14.getStage()
            java.lang.String r7 = r14.getItem()
            java.lang.String r8 = r14.getPublicationDate()
            java.lang.String r9 = r14.getRejectMessage()
            java.lang.String r0 = r14.getReviewStatusText()
            if (r0 == 0) goto L_0x0090
            com.avito.android.rating.details.adapter.user_profile_comment.ReviewStatus r10 = r14.getReviewStatus()
            com.avito.android.rating.details.adapter.user_profile_comment.ReviewStatus r12 = com.avito.android.rating.details.adapter.user_profile_comment.ReviewStatus.MODERATION
            if (r10 != r12) goto L_0x008b
            r10 = 1
            goto L_0x008c
        L_0x008b:
            r10 = 0
        L_0x008c:
            if (r10 == 0) goto L_0x0090
            r10 = r0
            goto L_0x0091
        L_0x0090:
            r10 = r1
        L_0x0091:
            java.util.List r12 = r14.getImages()
            com.avito.android.user_review.UserReviewData r14 = new com.avito.android.user_review.UserReviewData
            r1 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.rating.user_reviews.ItemToReviewDataConverterImpl.convert(com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItem):com.avito.android.user_review.UserReviewData");
    }
}
