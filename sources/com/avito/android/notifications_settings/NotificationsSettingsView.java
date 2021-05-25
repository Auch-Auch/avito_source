package com.avito.android.notifications_settings;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/notifications_settings/NotificationsSettingsView;", "", "Lio/reactivex/Observable;", "", "getBackClicks", "()Lio/reactivex/Observable;", "getRetryClicks", "showLoadProgress", "()V", "showLoadContent", "", "error", "showLoadError", "(Ljava/lang/String;)V", "notifyDataChanged", "showSaveError", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationsSettingsView {
    @NotNull
    Observable<Unit> getBackClicks();

    @NotNull
    Observable<Unit> getRetryClicks();

    void notifyDataChanged();

    void showLoadContent();

    void showLoadError(@NotNull String str);

    void showLoadProgress();

    void showSaveError(@NotNull String str);
}
