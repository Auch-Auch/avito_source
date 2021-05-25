package com.google.androidbrowserhelper.trusted;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.trusted.TrustedWebActivityDisplayMode;
import java.util.Arrays;
import java.util.List;
public class LauncherActivityMetadata {
    @Nullable
    public final List<String> additionalTrustedOrigins;
    @Nullable
    public final String defaultUrl;
    public final TrustedWebActivityDisplayMode displayMode;
    @Nullable
    public final String fallbackStrategyType;
    @Nullable
    public final String fileProviderAuthority;
    public final int navigationBarColorDarkId;
    public final int navigationBarColorId;
    public final int splashImageDrawableId;
    public final int splashScreenBackgroundColorId;
    public final int splashScreenFadeOutDurationMillis;
    public final int statusBarColorDarkId;
    public final int statusBarColorId;

    public LauncherActivityMetadata(@NonNull Bundle bundle, @NonNull Resources resources) {
        TrustedWebActivityDisplayMode trustedWebActivityDisplayMode;
        this.defaultUrl = bundle.getString("android.support.customtabs.trusted.DEFAULT_URL");
        int i = bundle.getInt("android.support.customtabs.trusted.STATUS_BAR_COLOR", 17170443);
        this.statusBarColorId = i;
        this.statusBarColorDarkId = bundle.getInt("android.support.customtabs.trusted.STATUS_BAR_COLOR_DARK", i);
        int i2 = bundle.getInt("android.support.customtabs.trusted.NAVIGATION_BAR_COLOR", 17170443);
        this.navigationBarColorId = i2;
        this.navigationBarColorDarkId = bundle.getInt("android.support.customtabs.trusted.NAVIGATION_BAR_COLOR_DARK", i2);
        this.splashImageDrawableId = bundle.getInt("android.support.customtabs.trusted.SPLASH_IMAGE_DRAWABLE", 0);
        this.splashScreenBackgroundColorId = bundle.getInt("android.support.customtabs.trusted.SPLASH_SCREEN_BACKGROUND_COLOR", 17170443);
        this.fileProviderAuthority = bundle.getString("android.support.customtabs.trusted.FILE_PROVIDER_AUTHORITY");
        this.splashScreenFadeOutDurationMillis = bundle.getInt("android.support.customtabs.trusted.SPLASH_SCREEN_FADE_OUT_DURATION", 0);
        if (bundle.containsKey("android.support.customtabs.trusted.ADDITIONAL_TRUSTED_ORIGINS")) {
            this.additionalTrustedOrigins = Arrays.asList(resources.getStringArray(bundle.getInt("android.support.customtabs.trusted.ADDITIONAL_TRUSTED_ORIGINS")));
        } else {
            this.additionalTrustedOrigins = null;
        }
        this.fallbackStrategyType = bundle.getString("android.support.customtabs.trusted.FALLBACK_STRATEGY");
        if ("immersive".equals(bundle.getString("android.support.customtabs.trusted.DISPLAY_MODE"))) {
            trustedWebActivityDisplayMode = new TrustedWebActivityDisplayMode.ImmersiveMode(false, 0);
        } else {
            trustedWebActivityDisplayMode = new TrustedWebActivityDisplayMode.DefaultMode();
        }
        this.displayMode = trustedWebActivityDisplayMode;
    }

    public static LauncherActivityMetadata parse(Context context) {
        Bundle bundle;
        Resources resources = context.getResources();
        try {
            bundle = context.getPackageManager().getActivityInfo(new ComponentName(context, context.getClass()), 128).metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            bundle = null;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        return new LauncherActivityMetadata(bundle, resources);
    }
}
