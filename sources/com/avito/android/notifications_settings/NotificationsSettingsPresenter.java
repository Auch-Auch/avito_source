package com.avito.android.notifications_settings;

import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/avito/android/notifications_settings/NotificationsSettingsPresenter;", "", "Lcom/avito/android/notifications_settings/NotificationsSettingsView;", "view", "", "attachView", "(Lcom/avito/android/notifications_settings/NotificationsSettingsView;)V", "Lcom/avito/android/notifications_settings/NotificationsSettingsRouter;", "router", "attachRouter", "(Lcom/avito/android/notifications_settings/NotificationsSettingsRouter;)V", "", "isEnabled", "checkNotificationsEnabled", "(Z)V", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "detachRouter", "()V", "detachView", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationsSettingsPresenter {
    void attachRouter(@NotNull NotificationsSettingsRouter notificationsSettingsRouter);

    void attachView(@NotNull NotificationsSettingsView notificationsSettingsView);

    void checkNotificationsEnabled(boolean z);

    void detachRouter();

    void detachView();

    @NotNull
    Kundle getState();
}
