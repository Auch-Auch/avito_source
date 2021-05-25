package com.avito.android.theme_settings.utils;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\f\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0016\u0010\u0010\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0014\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0016\u0010\u0016\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0016\u0010\u0018\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/theme_settings/utils/ThemeSettingsResourceProvider;", "", "", "isDarkTheme", "()Z", "", "getDarkThemeTitle", "()Ljava/lang/String;", "darkThemeTitle", "getLightThemeTitle", "lightThemeTitle", "getAutoBatterySubtitle", "autoBatterySubtitle", "Landroid/graphics/drawable/Drawable;", "getDarkThemeImage", "()Landroid/graphics/drawable/Drawable;", "darkThemeImage", "getAutoBatteryTitle", "autoBatteryTitle", "getFollowSystemSubtitle", "followSystemSubtitle", "getFollowSystemTitle", "followSystemTitle", "getLightThemeImage", "lightThemeImage", "settings_release"}, k = 1, mv = {1, 4, 2})
public interface ThemeSettingsResourceProvider {
    @NotNull
    String getAutoBatterySubtitle();

    @NotNull
    String getAutoBatteryTitle();

    @NotNull
    Drawable getDarkThemeImage();

    @NotNull
    String getDarkThemeTitle();

    @NotNull
    String getFollowSystemSubtitle();

    @NotNull
    String getFollowSystemTitle();

    @NotNull
    Drawable getLightThemeImage();

    @NotNull
    String getLightThemeTitle();

    boolean isDarkTheme();
}
