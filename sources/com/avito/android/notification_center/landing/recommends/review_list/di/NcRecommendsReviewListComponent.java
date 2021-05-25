package com.avito.android.notification_center.landing.recommends.review_list.di;

import android.app.Activity;
import com.avito.android.di.PerFragment;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListFragment;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review_list/di/NcRecommendsReviewListComponent;", "", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListFragment;", "fragment", "", "inject", "(Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListFragment;)V", "Builder", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {NcRecommendsReviewListDependencies.class}, modules = {NcRecommendsReviewListModule.class})
@PerFragment
public interface NcRecommendsReviewListComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review_list/di/NcRecommendsReviewListComponent$Builder;", "", "Lcom/avito/android/notification_center/landing/recommends/review_list/di/NcRecommendsReviewListDependencies;", "dependencies", "(Lcom/avito/android/notification_center/landing/recommends/review_list/di/NcRecommendsReviewListDependencies;)Lcom/avito/android/notification_center/landing/recommends/review_list/di/NcRecommendsReviewListComponent$Builder;", "", "id", "withId", "(Ljava/lang/String;)Lcom/avito/android/notification_center/landing/recommends/review_list/di/NcRecommendsReviewListComponent$Builder;", "", ContextActionHandler.MethodCall.REACTION, "withReaction", "(I)Lcom/avito/android/notification_center/landing/recommends/review_list/di/NcRecommendsReviewListComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/notification_center/landing/recommends/review_list/di/NcRecommendsReviewListComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/notification_center/landing/recommends/review_list/di/NcRecommendsReviewListComponent$Builder;", "Lcom/avito/android/notification_center/landing/recommends/review_list/di/NcRecommendsReviewListComponent;", "build", "()Lcom/avito/android/notification_center/landing/recommends/review_list/di/NcRecommendsReviewListComponent;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        NcRecommendsReviewListComponent build();

        @NotNull
        Builder dependencies(@NotNull NcRecommendsReviewListDependencies ncRecommendsReviewListDependencies);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withId(@NotNull String str);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withReaction(int i);
    }

    void inject(@NotNull NcRecommendsReviewListFragment ncRecommendsReviewListFragment);
}
