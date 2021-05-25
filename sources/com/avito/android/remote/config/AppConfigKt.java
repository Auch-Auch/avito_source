package com.avito.android.remote.config;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\"\u0016\u0010\u0001\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "FALLBACK_MIN_VERSION", "I", "Lcom/avito/android/remote/config/AppConfig;", "getDefaultAppConfig", "()Lcom/avito/android/remote/config/AppConfig;", "defaultAppConfig", "", "GEO_REPORT_DISABLED_TIMEOUT", "J", "config_release"}, k = 2, mv = {1, 4, 2})
public final class AppConfigKt {
    public static final int FALLBACK_MIN_VERSION = 0;
    public static final long GEO_REPORT_DISABLED_TIMEOUT = 0;

    @NotNull
    public static final AppConfig getDefaultAppConfig() {
        return new AppConfig(0, 0, 0, 0, false, 31, null);
    }
}
