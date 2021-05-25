package com.avito.android.rating;

import android.content.Context;
import android.content.Intent;
import com.avito.android.RatingIntentFactory;
import com.avito.android.rating.check.RatingPublishCheckActivityKt;
import com.avito.android.rating.details.RatingDetailsActivityKt;
import com.avito.android.rating.publish.RatingPublishActivityKt;
import com.avito.android.rating.review_details.ReviewDetailsActivityKt;
import com.avito.android.rating.user_contacts.UserContactsActivityKt;
import com.avito.android.rating.user_review_details.UserReviewDetailsActivityKt;
import com.avito.android.rating.user_reviews.UserReviewsActivityKt;
import com.avito.android.ratings.RatingPublishConfig;
import com.avito.android.ratings.ReviewData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AvatarStatus;
import com.avito.android.remote.model.Navigation;
import com.avito.android.user_review.UserReviewData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\bJ\u0019\u0010\u0013\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/rating/RatingIntentFactoryImpl;", "Lcom/avito/android/RatingIntentFactory;", "Landroid/content/Intent;", "userProfileRatingDetails", "()Landroid/content/Intent;", "", "userKey", "publicProfileRatingDetails", "(Ljava/lang/String;)Landroid/content/Intent;", "shopId", "shopRatingDetails", "Lcom/avito/android/ratings/RatingPublishConfig;", Navigation.CONFIG, "", "withCheck", "ratingPublish", "(Lcom/avito/android/ratings/RatingPublishConfig;Z)Landroid/content/Intent;", "contextId", "userReviews", "userContacts", "Lcom/avito/android/user_review/UserReviewData;", AvatarStatus.REVIEW, "userReviewDetails", "(Lcom/avito/android/user_review/UserReviewData;)Landroid/content/Intent;", "Lcom/avito/android/ratings/ReviewData;", "reviewData", "reviewDetails", "(Lcom/avito/android/ratings/ReviewData;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingIntentFactoryImpl implements RatingIntentFactory {
    public final Context a;

    @Inject
    public RatingIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.RatingIntentFactory
    @NotNull
    public Intent publicProfileRatingDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return RatingDetailsActivityKt.createPublicProfileRatingDetailsActivityIntent(this.a, str);
    }

    @Override // com.avito.android.RatingIntentFactory
    @NotNull
    public Intent ratingPublish(@NotNull RatingPublishConfig ratingPublishConfig, boolean z) {
        Intrinsics.checkNotNullParameter(ratingPublishConfig, Navigation.CONFIG);
        Intent createRatingPublishActivityIntent = RatingPublishActivityKt.createRatingPublishActivityIntent(this.a, ratingPublishConfig);
        return z ? RatingPublishCheckActivityKt.createRatingPublishCheckActivityIntent(this.a, ratingPublishConfig.getUserKey(), createRatingPublishActivityIntent) : createRatingPublishActivityIntent;
    }

    @Override // com.avito.android.RatingIntentFactory
    @NotNull
    public Intent reviewDetails(@NotNull ReviewData reviewData) {
        Intrinsics.checkNotNullParameter(reviewData, "reviewData");
        return ReviewDetailsActivityKt.createReviewDetailsActivityIntent(this.a, reviewData);
    }

    @Override // com.avito.android.RatingIntentFactory
    @NotNull
    public Intent shopRatingDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        return RatingDetailsActivityKt.createShopRatingDetailsActivityIntent(this.a, str);
    }

    @Override // com.avito.android.RatingIntentFactory
    @NotNull
    public Intent userContacts(@Nullable String str) {
        return UserContactsActivityKt.createUserContactsActivityIntent(this.a, str);
    }

    @Override // com.avito.android.RatingIntentFactory
    @NotNull
    public Intent userProfileRatingDetails() {
        return RatingDetailsActivityKt.createUserProfileRatingDetailsActivityIntent(this.a);
    }

    @Override // com.avito.android.RatingIntentFactory
    @NotNull
    public Intent userReviewDetails(@NotNull UserReviewData userReviewData) {
        Intrinsics.checkNotNullParameter(userReviewData, AvatarStatus.REVIEW);
        return UserReviewDetailsActivityKt.createUserReviewDetailsActivityIntent(this.a, userReviewData);
    }

    @Override // com.avito.android.RatingIntentFactory
    @NotNull
    public Intent userReviews(@Nullable String str) {
        return UserReviewsActivityKt.createUserReviewsActivityIntent(this.a, str);
    }
}
