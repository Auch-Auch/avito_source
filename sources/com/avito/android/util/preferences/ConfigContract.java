package com.avito.android.util.preferences;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/util/preferences/ConfigContract;", "", "", "VERSION_MAX", "Ljava/lang/String;", "YANDEX_REPORTS_ENABLED", "VERSION_MIN", "PLATFORM_VERSION", "GEO_REPORT_TIMEOUT", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class ConfigContract {
    @NotNull
    public static final String GEO_REPORT_TIMEOUT = "config_geo_report_timeout";
    @NotNull
    public static final ConfigContract INSTANCE = new ConfigContract();
    @NotNull
    public static final String PLATFORM_VERSION = "config_platform_version";
    @NotNull
    public static final String VERSION_MAX = "config_version_max";
    @NotNull
    public static final String VERSION_MIN = "config_version_min";
    @NotNull
    public static final String YANDEX_REPORTS_ENABLED = "config_yandex_reports_enabled";
}
