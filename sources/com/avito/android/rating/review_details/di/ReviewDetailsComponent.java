package com.avito.android.rating.review_details.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.di.PerActivity;
import com.avito.android.dialog.di.DialogModule;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.rating.di.RatingsTnsGalleryClicksModule;
import com.avito.android.rating.review_details.ReviewDetailsActivity;
import com.avito.android.ratings.ReviewData;
import com.avito.android.remote.model.AvatarStatus;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/rating/review_details/di/ReviewDetailsComponent;", "", "Lcom/avito/android/rating/review_details/ReviewDetailsActivity;", "activity", "", "inject", "(Lcom/avito/android/rating/review_details/ReviewDetailsActivity;)V", "Builder", "rating_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ReviewDetailsDependencies.class}, modules = {DialogModule.class, ErrorHelperModule.class, ReviewDetailsModule.class, RatingsTnsGalleryClicksModule.class})
@PerActivity
public interface ReviewDetailsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u00002\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00002\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\rH'¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\b\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/rating/review_details/di/ReviewDetailsComponent$Builder;", "", "Lcom/avito/android/rating/review_details/di/ReviewDetailsDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/rating/review_details/di/ReviewDetailsDependencies;)Lcom/avito/android/rating/review_details/di/ReviewDetailsComponent$Builder;", "Landroid/app/Activity;", "activity", "with", "(Landroid/app/Activity;)Lcom/avito/android/rating/review_details/di/ReviewDetailsComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/rating/review_details/di/ReviewDetailsComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withDetails", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/rating/review_details/di/ReviewDetailsComponent$Builder;", "withReply", "Lcom/avito/android/ratings/ReviewData;", AvatarStatus.REVIEW, "(Lcom/avito/android/ratings/ReviewData;)Lcom/avito/android/rating/review_details/di/ReviewDetailsComponent$Builder;", "Lcom/avito/android/rating/review_details/di/ReviewDetailsComponent;", "build", "()Lcom/avito/android/rating/review_details/di/ReviewDetailsComponent;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ReviewDetailsComponent build();

        @NotNull
        Builder dependentOn(@NotNull ReviewDetailsDependencies reviewDetailsDependencies);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder with(@NotNull ReviewData reviewData);

        @BindsInstance
        @NotNull
        Builder withDetails(@DetailsState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withReply(@ReplyState @Nullable Kundle kundle);
    }

    void inject(@NotNull ReviewDetailsActivity reviewDetailsActivity);
}
