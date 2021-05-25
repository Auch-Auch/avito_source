package com.avito.android.notification_center.list.di;

import android.content.res.Resources;
import com.avito.android.di.PerActivity;
import com.avito.android.notification_center.list.NotificationCenterListActivity;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/notification_center/list/di/NotificationCenterListComponent;", "", "Lcom/avito/android/notification_center/list/NotificationCenterListActivity;", "activity", "", "inject", "(Lcom/avito/android/notification_center/list/NotificationCenterListActivity;)V", "Builder", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {NotificationCenterListDependencies.class}, modules = {NotificationCenterListModule.class})
@PerActivity
public interface NotificationCenterListComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/notification_center/list/di/NotificationCenterListComponent$Builder;", "", "Lcom/avito/android/notification_center/list/di/NotificationCenterListDependencies;", "dependencies", "(Lcom/avito/android/notification_center/list/di/NotificationCenterListDependencies;)Lcom/avito/android/notification_center/list/di/NotificationCenterListComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/notification_center/list/di/NotificationCenterListComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/notification_center/list/di/NotificationCenterListComponent$Builder;", "Lcom/avito/android/notification_center/list/di/NotificationCenterListComponent;", "build", "()Lcom/avito/android/notification_center/list/di/NotificationCenterListComponent;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        NotificationCenterListComponent build();

        @NotNull
        Builder dependencies(@NotNull NotificationCenterListDependencies notificationCenterListDependencies);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);
    }

    void inject(@NotNull NotificationCenterListActivity notificationCenterListActivity);
}
