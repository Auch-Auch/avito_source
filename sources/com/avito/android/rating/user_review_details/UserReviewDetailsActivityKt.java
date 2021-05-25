package com.avito.android.rating.user_review_details;

import android.content.Context;
import android.content.Intent;
import com.avito.android.rating.RatingParamsKt;
import com.avito.android.remote.model.AvatarStatus;
import com.avito.android.user_review.UserReviewData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/user_review/UserReviewData;", AvatarStatus.REVIEW, "Landroid/content/Intent;", "createUserReviewDetailsActivityIntent", "(Landroid/content/Context;Lcom/avito/android/user_review/UserReviewData;)Landroid/content/Intent;", "", "RESULT_DELETED", "I", "rating_release"}, k = 2, mv = {1, 4, 2})
public final class UserReviewDetailsActivityKt {
    public static final int RESULT_DELETED = 42;

    @NotNull
    public static final Intent createUserReviewDetailsActivityIntent(@NotNull Context context, @NotNull UserReviewData userReviewData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userReviewData, AvatarStatus.REVIEW);
        return RatingParamsKt.putReview(new Intent(context, UserReviewDetailsActivity.class), userReviewData);
    }
}
