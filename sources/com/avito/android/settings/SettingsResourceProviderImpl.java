package com.avito.android.settings;

import android.content.res.Resources;
import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010:\u001a\u00020\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\tR\u0016\u0010\u000f\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u0016\u0010\u0019\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000eR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000eR\u0016\u0010\u001d\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000eR\u0016\u0010\u001f\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000eR\u0016\u0010!\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u000eR\u0016\u0010#\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u000eR\u0016\u0010%\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b$\u0010\u000eR\u0016\u0010'\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u000eR\u0016\u0010)\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u000eR\u0016\u0010+\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u000eR\u0016\u0010-\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u000eR\u0016\u0010/\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u000eR\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u000eR\u0016\u00107\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b6\u0010\u000eR\u0016\u00109\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u000e¨\u0006="}, d2 = {"Lcom/avito/android/settings/SettingsResourceProviderImpl;", "Lcom/avito/android/settings/SettingsResourceProvider;", "Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "theme", "", "themeMode", "(Lcom/avito/android/lib/util/DarkThemeManager$Mode;)Ljava/lang/String;", "deviceId", "(Ljava/lang/String;)Ljava/lang/String;", "appVersion", "user", "supportEmailSubject", "getHelpCenter", "()Ljava/lang/String;", "helpCenter", "getB2bHub", "b2bHub", "getReadTermOfUse", "readTermOfUse", "getUiTheme", "uiTheme", "getUserBehaviorAnalyticsTitle", "userBehaviorAnalyticsTitle", "getClearSearchHistorySuccessMessage", "clearSearchHistorySuccessMessage", "getUserEmail", "userEmail", "getClearSearchHistoryFailMessage", "clearSearchHistoryFailMessage", "getAboutApp", "aboutApp", "getNotifications", "notifications", "getClearSearchHistory", "clearSearchHistory", "getSupportEmailText", "supportEmailText", "getOpenSourceLicences", "openSourceLicences", "getLicencesAndAgreements", "licencesAndAgreements", "getReadOffer", "readOffer", "getUserBehaviorAnalyticsSubtitle", "userBehaviorAnalyticsSubtitle", "getRegionForSearch", "regionForSearch", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "getB2bHubUrl", "b2bHubUrl", "getSupportEmailAddress", "supportEmailAddress", "getReadAppsLicence", "readAppsLicence", "supportEmailResourceProviderDelegate", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/shared_providers/SupportEmailResourceProvider;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class SettingsResourceProviderImpl implements SettingsResourceProvider, SupportEmailResourceProvider {
    public final Resources a;
    public final /* synthetic */ SupportEmailResourceProvider b;

    @Inject
    public SettingsResourceProviderImpl(@NotNull Resources resources, @NotNull SupportEmailResourceProvider supportEmailResourceProvider) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(supportEmailResourceProvider, "supportEmailResourceProviderDelegate");
        this.b = supportEmailResourceProvider;
        this.a = resources;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String appVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "appVersion");
        String string = this.a.getString(R.string.version_template, str);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ion_template, appVersion)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String deviceId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        String string = this.a.getString(R.string.device_id, str);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.device_id, deviceId)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getAboutApp() {
        String string = this.a.getString(R.string.about_app);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.about_app)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getB2bHub() {
        String string = this.a.getString(R.string.b2b_hub);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.b2b_hub)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getB2bHubUrl() {
        String string = this.a.getString(R.string.b2b_hub_url);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.b2b_hub_url)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getClearSearchHistory() {
        String string = this.a.getString(R.string.clear_search_history);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.clear_search_history)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getClearSearchHistoryFailMessage() {
        String string = this.a.getString(R.string.clear_search_history_fail);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…lear_search_history_fail)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getClearSearchHistorySuccessMessage() {
        String string = this.a.getString(R.string.clear_search_history_success);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…r_search_history_success)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getHelpCenter() {
        String string = this.a.getString(R.string.help);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.help)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getLicencesAndAgreements() {
        String string = this.a.getString(R.string.licenses_and_agreements);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st….licenses_and_agreements)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getNotifications() {
        String string = this.a.getString(R.string.settings_notifications);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R…g.settings_notifications)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getOpenSourceLicences() {
        String string = this.a.getString(R.string.open_source_licences);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.open_source_licences)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getReadAppsLicence() {
        String string = this.a.getString(R.string.read_apps_licence);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R.string.read_apps_licence)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getReadOffer() {
        String string = this.a.getString(R.string.read_offer);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R.string.read_offer)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getReadTermOfUse() {
        String string = this.a.getString(R.string.read_licence);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R.string.read_licence)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getRegionForSearch() {
        String string = this.a.getString(R.string.region_for_search);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R.string.region_for_search)");
        return string;
    }

    @Override // com.avito.android.shared_providers.SupportEmailResourceProvider
    @NotNull
    public String getSupportEmailAddress() {
        return this.b.getSupportEmailAddress();
    }

    @Override // com.avito.android.shared_providers.SupportEmailResourceProvider
    @NotNull
    public String getSupportEmailText() {
        return this.b.getSupportEmailText();
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getUiTheme() {
        String string = this.a.getString(R.string.ui_theme);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.ui_theme)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getUserBehaviorAnalyticsSubtitle() {
        String string = this.a.getString(R.string.user_behavior_analytics_subtitle);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…avior_analytics_subtitle)");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String getUserBehaviorAnalyticsTitle() {
        String string = this.a.getString(R.string.user_behavior_analytics_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…behavior_analytics_title)");
        return string;
    }

    @Override // com.avito.android.shared_providers.SupportEmailResourceProvider
    @Nullable
    public String getUserEmail() {
        return this.b.getUserEmail();
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000d: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r5v1 java.lang.String) */
    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String supportEmailSubject(@Nullable String str) {
        Resources resources = this.a;
        int i = com.avito.android.resource_providers.R.string.support_email_subject;
        Object[] objArr = new Object[1];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        String string = resources.getString(i, objArr);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   … user.orEmpty()\n        )");
        return string;
    }

    @Override // com.avito.android.settings.SettingsResourceProvider
    @NotNull
    public String themeMode(@NotNull DarkThemeManager.Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "theme");
        if (Intrinsics.areEqual(mode, DarkThemeManager.Mode.LightAlways.INSTANCE)) {
            String string = this.a.getString(R.string.light_mode_title);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.light_mode_title)");
            return string;
        } else if (Intrinsics.areEqual(mode, DarkThemeManager.Mode.DarkAlways.INSTANCE)) {
            String string2 = this.a.getString(R.string.dark_mode_title);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.dark_mode_title)");
            return string2;
        } else if (Intrinsics.areEqual(mode, DarkThemeManager.Mode.AutoBattery.INSTANCE)) {
            String string3 = this.a.getString(R.string.auto_battery_mode_title);
            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st….auto_battery_mode_title)");
            return string3;
        } else if (Intrinsics.areEqual(mode, DarkThemeManager.Mode.FollowSystem.INSTANCE)) {
            String string4 = this.a.getString(R.string.follow_system_mode_title);
            Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…follow_system_mode_title)");
            return string4;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
