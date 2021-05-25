package com.yandex.mapkit;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.offline_cache.DownloadNotificationsListener;
import com.yandex.mapkit.offline_cache.internal.BackgroundDownloadManager;
import com.yandex.runtime.Runtime;
import com.yandex.runtime.i18n.I18nManagerFactory;
public final class MapKitFactory {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static String apiKey_ = null;
    private static boolean initialized_ = false;
    private static String locale_;

    private static void checkApiKey() {
    }

    public static native MapKit getInstance();

    public static synchronized void initialize(Context context) {
        synchronized (MapKitFactory.class) {
            checkApiKey();
            Runtime.init(context);
            Runtime.loadLibrary(context, BuildConfig.APPLICATION_ID);
            getInstance().setApiKey(apiKey_);
            I18nManagerFactory.setLocale(locale_);
            initialized_ = true;
        }
    }

    public static synchronized void initializeBackgroundDownload(final Context context, @Nullable DownloadNotificationsListener downloadNotificationsListener) {
        synchronized (MapKitFactory.class) {
            checkApiKey();
            BackgroundDownloadManager.initialize(new Runnable() { // from class: com.yandex.mapkit.MapKitFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    MapKitFactory.initialize(context);
                    MapKitFactory.getInstance().getOfflineCacheManager();
                }
            }, context, downloadNotificationsListener);
        }
    }

    public static synchronized void setApiKey(@NonNull String str) {
        synchronized (MapKitFactory.class) {
            apiKey_ = str;
        }
    }

    public static synchronized void setLocale(@Nullable String str) {
        synchronized (MapKitFactory.class) {
            locale_ = str;
        }
    }
}
