package com.avito.android.settings;

import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b+\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000b\u0010\bR\u0016\u0010\u000e\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0016\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0016\u0010\u0018\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0016\u0010\u001a\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0016\u0010\u001c\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\rR\u0016\u0010\u001e\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0016\u0010 \u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0016\u0010\"\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u0016\u0010$\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\rR\u0016\u0010&\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\rR\u0016\u0010(\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\rR\u0016\u0010*\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\rR\u0016\u0010,\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\rR\u0016\u0010.\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\r¨\u0006/"}, d2 = {"Lcom/avito/android/settings/SettingsResourceProvider;", "Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "theme", "", "themeMode", "(Lcom/avito/android/lib/util/DarkThemeManager$Mode;)Ljava/lang/String;", "deviceId", "(Ljava/lang/String;)Ljava/lang/String;", "appVersion", "user", "supportEmailSubject", "getB2bHub", "()Ljava/lang/String;", "b2bHub", "getAboutApp", "aboutApp", "getClearSearchHistorySuccessMessage", "clearSearchHistorySuccessMessage", "getReadTermOfUse", "readTermOfUse", "getOpenSourceLicences", "openSourceLicences", "getHelpCenter", "helpCenter", "getReadOffer", "readOffer", "getNotifications", "notifications", "getReadAppsLicence", "readAppsLicence", "getClearSearchHistory", "clearSearchHistory", "getUiTheme", "uiTheme", "getLicencesAndAgreements", "licencesAndAgreements", "getRegionForSearch", "regionForSearch", "getUserBehaviorAnalyticsTitle", "userBehaviorAnalyticsTitle", "getClearSearchHistoryFailMessage", "clearSearchHistoryFailMessage", "getB2bHubUrl", "b2bHubUrl", "getUserBehaviorAnalyticsSubtitle", "userBehaviorAnalyticsSubtitle", "settings_release"}, k = 1, mv = {1, 4, 2})
public interface SettingsResourceProvider extends SupportEmailResourceProvider {
    @NotNull
    String appVersion(@NotNull String str);

    @NotNull
    String deviceId(@NotNull String str);

    @NotNull
    String getAboutApp();

    @NotNull
    String getB2bHub();

    @NotNull
    String getB2bHubUrl();

    @NotNull
    String getClearSearchHistory();

    @NotNull
    String getClearSearchHistoryFailMessage();

    @NotNull
    String getClearSearchHistorySuccessMessage();

    @NotNull
    String getHelpCenter();

    @NotNull
    String getLicencesAndAgreements();

    @NotNull
    String getNotifications();

    @NotNull
    String getOpenSourceLicences();

    @NotNull
    String getReadAppsLicence();

    @NotNull
    String getReadOffer();

    @NotNull
    String getReadTermOfUse();

    @NotNull
    String getRegionForSearch();

    @NotNull
    String getUiTheme();

    @NotNull
    String getUserBehaviorAnalyticsSubtitle();

    @NotNull
    String getUserBehaviorAnalyticsTitle();

    @NotNull
    String supportEmailSubject(@Nullable String str);

    @NotNull
    String themeMode(@NotNull DarkThemeManager.Mode mode);
}
