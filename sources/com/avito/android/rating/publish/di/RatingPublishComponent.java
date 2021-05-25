package com.avito.android.rating.publish.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.di.PerActivity;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.rating.publish.RatingPublishActivity;
import com.avito.android.rating.publish.RatingPublishPresenter;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/rating/publish/di/RatingPublishComponent;", "", "Lcom/avito/android/rating/publish/RatingPublishActivity;", "fragment", "", "inject", "(Lcom/avito/android/rating/publish/RatingPublishActivity;)V", "Builder", "rating_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {RatingPublishDependencies.class}, modules = {RatingPublishModule.class, ErrorHelperModule.class})
@PerActivity
public interface RatingPublishComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\b\u0010\fJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\b\u0010\u000fJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\b\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/rating/publish/di/RatingPublishComponent$Builder;", "", "Lcom/avito/android/rating/publish/di/RatingPublishDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/rating/publish/di/RatingPublishDependencies;)Lcom/avito/android/rating/publish/di/RatingPublishComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "with", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/rating/publish/di/RatingPublishComponent$Builder;", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)Lcom/avito/android/rating/publish/di/RatingPublishComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/rating/publish/di/RatingPublishComponent$Builder;", "Lcom/avito/android/rating/publish/RatingPublishPresenter$StepHolder;", "stepHolder", "(Lcom/avito/android/rating/publish/RatingPublishPresenter$StepHolder;)Lcom/avito/android/rating/publish/di/RatingPublishComponent$Builder;", "Lcom/avito/android/rating/publish/di/RatingPublishComponent;", "build", "()Lcom/avito/android/rating/publish/di/RatingPublishComponent;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        RatingPublishComponent build();

        @NotNull
        Builder dependentOn(@NotNull RatingPublishDependencies ratingPublishDependencies);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder with(@NotNull RatingPublishPresenter.StepHolder stepHolder);

        @BindsInstance
        @NotNull
        Builder with(@Nullable Kundle kundle);
    }

    void inject(@NotNull RatingPublishActivity ratingPublishActivity);
}
