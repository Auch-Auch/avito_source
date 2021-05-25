package com.yandex.mapkit.offline_cache;

import androidx.annotation.NonNull;
public interface DownloadNotificationsListener {
    void startNotifications(@NonNull OfflineCacheManager offlineCacheManager);
}
