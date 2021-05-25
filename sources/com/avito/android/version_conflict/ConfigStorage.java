package com.avito.android.version_conflict;

import com.avito.android.remote.config.AppConfig;
import com.avito.android.remote.model.Navigation;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/version_conflict/ConfigStorage;", "", "Lcom/avito/android/remote/config/AppConfig;", "getConfig", "()Lcom/avito/android/remote/config/AppConfig;", Navigation.CONFIG, "", "getGeoReportTimeout", "()J", "geoReportTimeout", "", "isYandexReportsEnabled", "()Z", "version-conflict_release"}, k = 1, mv = {1, 4, 2})
public interface ConfigStorage {
    @Nullable
    AppConfig getConfig();

    long getGeoReportTimeout();

    boolean isYandexReportsEnabled();
}
