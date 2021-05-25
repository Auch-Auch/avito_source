package com.avito.android.notifications_settings;

import com.avito.android.remote.model.notifications_settings.NotificationsSettings;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/notifications_settings/NotificationsSettingsInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings;", "load", "()Lio/reactivex/Observable;", "", "section", "channel", "", "value", "", "save", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationsSettingsInteractor {
    @NotNull
    Observable<LoadingState<NotificationsSettings>> load();

    @NotNull
    Observable<LoadingState<Unit>> save(@NotNull String str, @NotNull String str2, boolean z);
}
