package com.avito.android.rating;

import android.content.Intent;
import com.avito.android.remote.model.AvatarStatus;
import com.avito.android.user_review.UserReviewData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u0003\u001a\u001b\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroid/content/Intent;", "", "getMessage", "(Landroid/content/Intent;)Ljava/lang/String;", "message", "putMessage", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/user_review/UserReviewData;", "getReview", "(Landroid/content/Intent;)Lcom/avito/android/user_review/UserReviewData;", AvatarStatus.REVIEW, "putReview", "(Landroid/content/Intent;Lcom/avito/android/user_review/UserReviewData;)Landroid/content/Intent;", "getPublishedRatingUserKey", "userKey", "putPublishedRatingUserKey", "rating_release"}, k = 2, mv = {1, 4, 2})
public final class RatingParamsKt {
    @Nullable
    public static final String getMessage(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getMessage");
        return intent.getStringExtra("message");
    }

    @Nullable
    public static final String getPublishedRatingUserKey(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getPublishedRatingUserKey");
        return intent.getStringExtra("published_rating_user_key");
    }

    @Nullable
    public static final UserReviewData getReview(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getReview");
        return (UserReviewData) intent.getParcelableExtra(AvatarStatus.REVIEW);
    }

    @NotNull
    public static final Intent putMessage(@NotNull Intent intent, @Nullable String str) {
        Intrinsics.checkNotNullParameter(intent, "$this$putMessage");
        Intent putExtra = intent.putExtra("message", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(KEY_MESSAGE, message)");
        return putExtra;
    }

    @NotNull
    public static final Intent putPublishedRatingUserKey(@NotNull Intent intent, @NotNull String str) {
        Intrinsics.checkNotNullParameter(intent, "$this$putPublishedRatingUserKey");
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intent putExtra = intent.putExtra("published_rating_user_key", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(KEY_PUBLISHED_RATING_USER_KEY, userKey)");
        return putExtra;
    }

    @NotNull
    public static final Intent putReview(@NotNull Intent intent, @Nullable UserReviewData userReviewData) {
        Intrinsics.checkNotNullParameter(intent, "$this$putReview");
        Intent putExtra = intent.putExtra(AvatarStatus.REVIEW, userReviewData);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(KEY_REVIEW, review)");
        return putExtra;
    }
}
