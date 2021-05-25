package com.yandex.metrica;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.profile.UserProfile;
import java.util.Map;
public interface IReporter {
    void pauseSession();

    void reportError(@NonNull String str, @Nullable Throwable th);

    void reportEvent(@NonNull String str);

    void reportEvent(@NonNull String str, @Nullable String str2);

    void reportEvent(@NonNull String str, @Nullable Map<String, Object> map);

    void reportRevenue(@NonNull Revenue revenue);

    void reportUnhandledException(@NonNull Throwable th);

    void reportUserProfile(@NonNull UserProfile userProfile);

    void resumeSession();

    void sendEventsBuffer();

    void setStatisticsSending(boolean z);

    void setUserProfileID(@Nullable String str);
}
