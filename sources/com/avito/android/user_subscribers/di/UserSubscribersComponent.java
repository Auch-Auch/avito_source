package com.avito.android.user_subscribers.di;

import android.content.res.Resources;
import com.avito.android.di.PerActivity;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.user_subscribers.UserSubscribersActivity;
import com.avito.android.user_subscribers.adapter.error.di.ErrorItemModule;
import com.avito.android.user_subscribers.adapter.loading.di.LoadingItemModule;
import com.avito.android.user_subscribers.adapter.subscriber.di.SubscriberItemModule;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/user_subscribers/di/UserSubscribersComponent;", "", "Lcom/avito/android/user_subscribers/UserSubscribersActivity;", "activity", "", "inject", "(Lcom/avito/android/user_subscribers/UserSubscribersActivity;)V", "Builder", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {UserSubscribersDependencies.class}, modules = {UserSubscribersModule.class, ErrorHelperModule.class, SubscriberItemModule.class, LoadingItemModule.class, ErrorItemModule.class})
@PerActivity
public interface UserSubscribersComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/user_subscribers/di/UserSubscribersComponent$Builder;", "", "Lcom/avito/android/user_subscribers/di/UserSubscribersDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/user_subscribers/di/UserSubscribersDependencies;)Lcom/avito/android/user_subscribers/di/UserSubscribersComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "with", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/user_subscribers/di/UserSubscribersComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/user_subscribers/di/UserSubscribersComponent$Builder;", "Lcom/avito/android/user_subscribers/di/UserSubscribersComponent;", "build", "()Lcom/avito/android/user_subscribers/di/UserSubscribersComponent;", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        UserSubscribersComponent build();

        @NotNull
        Builder dependentOn(@NotNull UserSubscribersDependencies userSubscribersDependencies);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder with(@Nullable Kundle kundle);
    }

    void inject(@NotNull UserSubscribersActivity userSubscribersActivity);
}
