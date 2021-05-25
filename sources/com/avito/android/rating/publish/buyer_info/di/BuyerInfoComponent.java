package com.avito.android.rating.publish.buyer_info.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.di.PerActivity;
import com.avito.android.dialog.di.DialogModule;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.buyer_info.BuyerInfoFragment;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoComponent;", "", "Lcom/avito/android/rating/publish/buyer_info/BuyerInfoFragment;", "fragment", "", "inject", "(Lcom/avito/android/rating/publish/buyer_info/BuyerInfoFragment;)V", "Builder", "rating_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {BuyerInfoDependencies.class}, modules = {BuyerInfoModule.class, DialogModule.class, ErrorHelperModule.class})
@PerActivity
public interface BuyerInfoComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\b\u0010\fJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\b\u0010\u000fJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\b\u0010\u0012J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\b\u0010\u0015J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\b\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoComponent$Builder;", "", "Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoDependencies;)Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "with", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoComponent$Builder;", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoComponent$Builder;", "Lcom/avito/android/rating/publish/StepListener;", "stepListener", "(Lcom/avito/android/rating/publish/StepListener;)Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoComponent$Builder;", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "(Lcom/avito/android/ratings/RatingPublishData;)Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoComponent$Builder;", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "(Lcom/avito/android/rating/publish/RatingPublishViewData;)Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoComponent$Builder;", "Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoComponent;", "build", "()Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoComponent;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        BuyerInfoComponent build();

        @NotNull
        Builder dependentOn(@NotNull BuyerInfoDependencies buyerInfoDependencies);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder with(@NotNull RatingPublishViewData ratingPublishViewData);

        @BindsInstance
        @NotNull
        Builder with(@NotNull StepListener stepListener);

        @BindsInstance
        @NotNull
        Builder with(@NotNull RatingPublishData ratingPublishData);

        @BindsInstance
        @NotNull
        Builder with(@Nullable Kundle kundle);
    }

    void inject(@NotNull BuyerInfoFragment buyerInfoFragment);
}
