package com.avito.android.notification_center.landing.recommends.review.di;

import android.app.Activity;
import com.avito.android.di.PerFragment;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewFragment;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review/di/NcRecommendsReviewComponent;", "", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewFragment;", "fragment", "", "inject", "(Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewFragment;)V", "Builder", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {NcRecommendsReviewDependencies.class}, modules = {NcRecommendsReviewModule.class})
@PerFragment
public interface NcRecommendsReviewComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\u0005H'¢\u0006\u0004\b\n\u0010\bJ\u0019\u0010\r\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review/di/NcRecommendsReviewComponent$Builder;", "", "Lcom/avito/android/notification_center/landing/recommends/review/di/NcRecommendsReviewDependencies;", "dependencies", "(Lcom/avito/android/notification_center/landing/recommends/review/di/NcRecommendsReviewDependencies;)Lcom/avito/android/notification_center/landing/recommends/review/di/NcRecommendsReviewComponent$Builder;", "", "id", "withId", "(Ljava/lang/String;)Lcom/avito/android/notification_center/landing/recommends/review/di/NcRecommendsReviewComponent$Builder;", "hit", "withHint", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/notification_center/landing/recommends/review/di/NcRecommendsReviewComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/notification_center/landing/recommends/review/di/NcRecommendsReviewComponent$Builder;", "Lcom/avito/android/notification_center/landing/recommends/review/di/NcRecommendsReviewComponent;", "build", "()Lcom/avito/android/notification_center/landing/recommends/review/di/NcRecommendsReviewComponent;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        NcRecommendsReviewComponent build();

        @NotNull
        Builder dependencies(@NotNull NcRecommendsReviewDependencies ncRecommendsReviewDependencies);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withHint(@Hint @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withId(@Id @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);
    }

    void inject(@NotNull NcRecommendsReviewFragment ncRecommendsReviewFragment);
}
