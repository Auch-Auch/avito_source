package com.avito.android;

import android.content.Intent;
import com.avito.android.ratings.RatingPublishConfig;
import com.avito.android.ratings.ReviewData;
import com.avito.android.remote.model.AvatarStatus;
import com.avito.android.remote.model.Navigation;
import com.avito.android.user_review.UserReviewData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\bJ!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0012\u0010\bJ\u0019\u0010\u0013\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/RatingIntentFactory;", "", "Landroid/content/Intent;", "userProfileRatingDetails", "()Landroid/content/Intent;", "", "userKey", "publicProfileRatingDetails", "(Ljava/lang/String;)Landroid/content/Intent;", "shopId", "shopRatingDetails", "Lcom/avito/android/ratings/RatingPublishConfig;", Navigation.CONFIG, "", "withCheck", "ratingPublish", "(Lcom/avito/android/ratings/RatingPublishConfig;Z)Landroid/content/Intent;", "contextId", "userReviews", "userContacts", "Lcom/avito/android/user_review/UserReviewData;", AvatarStatus.REVIEW, "userReviewDetails", "(Lcom/avito/android/user_review/UserReviewData;)Landroid/content/Intent;", "Lcom/avito/android/ratings/ReviewData;", "reviewData", "reviewDetails", "(Lcom/avito/android/ratings/ReviewData;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface RatingIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent ratingPublish$default(RatingIntentFactory ratingIntentFactory, RatingPublishConfig ratingPublishConfig, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                return ratingIntentFactory.ratingPublish(ratingPublishConfig, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ratingPublish");
        }
    }

    @NotNull
    Intent publicProfileRatingDetails(@NotNull String str);

    @NotNull
    Intent ratingPublish(@NotNull RatingPublishConfig ratingPublishConfig, boolean z);

    @NotNull
    Intent reviewDetails(@NotNull ReviewData reviewData);

    @NotNull
    Intent shopRatingDetails(@NotNull String str);

    @NotNull
    Intent userContacts(@Nullable String str);

    @NotNull
    Intent userProfileRatingDetails();

    @NotNull
    Intent userReviewDetails(@NotNull UserReviewData userReviewData);

    @NotNull
    Intent userReviews(@Nullable String str);
}
