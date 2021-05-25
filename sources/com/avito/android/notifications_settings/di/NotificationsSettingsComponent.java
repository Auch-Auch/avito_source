package com.avito.android.notifications_settings.di;

import com.avito.android.di.PerActivity;
import com.avito.android.notifications_settings.NotificationsSettingsActivity;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/notifications_settings/di/NotificationsSettingsComponent;", "", "Lcom/avito/android/notifications_settings/NotificationsSettingsActivity;", "activity", "", "inject", "(Lcom/avito/android/notifications_settings/NotificationsSettingsActivity;)V", "Builder", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {NotificationsSettingsDependencies.class}, modules = {NotificationsSettingsModule.class})
@PerActivity
public interface NotificationsSettingsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/notifications_settings/di/NotificationsSettingsComponent$Builder;", "", "Lcom/avito/android/notifications_settings/di/NotificationsSettingsDependencies;", "dependencies", "(Lcom/avito/android/notifications_settings/di/NotificationsSettingsDependencies;)Lcom/avito/android/notifications_settings/di/NotificationsSettingsComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/notifications_settings/di/NotificationsSettingsComponent$Builder;", "Lcom/avito/android/notifications_settings/di/NotificationsSettingsComponent;", "build", "()Lcom/avito/android/notifications_settings/di/NotificationsSettingsComponent;", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        NotificationsSettingsComponent build();

        @NotNull
        Builder dependencies(@NotNull NotificationsSettingsDependencies notificationsSettingsDependencies);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);
    }

    void inject(@NotNull NotificationsSettingsActivity notificationsSettingsActivity);
}
