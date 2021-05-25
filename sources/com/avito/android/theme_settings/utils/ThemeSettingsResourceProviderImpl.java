package com.avito.android.theme_settings.utils;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.avito.android.lib.util.DarkThemeManagerKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.settings.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0018\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001c\u0010\u001b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010!\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010$\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006¨\u0006)"}, d2 = {"Lcom/avito/android/theme_settings/utils/ThemeSettingsResourceProviderImpl;", "Lcom/avito/android/theme_settings/utils/ThemeSettingsResourceProvider;", "", "d", "Ljava/lang/String;", "getAutoBatterySubtitle", "()Ljava/lang/String;", "autoBatterySubtitle", "", AuthSource.SEND_ABUSE, "Z", "isDarkTheme", "()Z", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "getDarkThemeImage", "()Landroid/graphics/drawable/Drawable;", "darkThemeImage", "e", "getAutoBatteryTitle", "autoBatteryTitle", "h", "getLightThemeImage", "lightThemeImage", "c", "getFollowSystemTitle", "followSystemTitle", g.a, "getDarkThemeTitle", "darkThemeTitle", "i", "getLightThemeTitle", "lightThemeTitle", AuthSource.BOOKING_ORDER, "getFollowSystemSubtitle", "followSystemSubtitle", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class ThemeSettingsResourceProviderImpl implements ThemeSettingsResourceProvider {
    public final boolean a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final Drawable f;
    @NotNull
    public final String g;
    @NotNull
    public final Drawable h;
    @NotNull
    public final String i;

    @Inject
    public ThemeSettingsResourceProviderImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = DarkThemeManagerKt.isDarkTheme(context);
        String string = context.getString(R.string.follow_system_mode_subtitle);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…low_system_mode_subtitle)");
        this.b = string;
        String string2 = context.getString(R.string.follow_system_mode_title);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…follow_system_mode_title)");
        this.c = string2;
        String string3 = context.getString(R.string.auto_battery_mode_subtitle);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…to_battery_mode_subtitle)");
        this.d = string3;
        String string4 = context.getString(R.string.auto_battery_mode_title);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri….auto_battery_mode_title)");
        this.e = string4;
        Drawable drawable = context.getDrawable(R.drawable.ic_phone_dark);
        Intrinsics.checkNotNull(drawable);
        this.f = drawable;
        String string5 = context.getString(R.string.dark_mode_title);
        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.string.dark_mode_title)");
        this.g = string5;
        Drawable drawable2 = context.getDrawable(R.drawable.ic_phone_light);
        Intrinsics.checkNotNull(drawable2);
        this.h = drawable2;
        String string6 = context.getString(R.string.light_mode_title);
        Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.string.light_mode_title)");
        this.i = string6;
    }

    @Override // com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider
    @NotNull
    public String getAutoBatterySubtitle() {
        return this.d;
    }

    @Override // com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider
    @NotNull
    public String getAutoBatteryTitle() {
        return this.e;
    }

    @Override // com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider
    @NotNull
    public Drawable getDarkThemeImage() {
        return this.f;
    }

    @Override // com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider
    @NotNull
    public String getDarkThemeTitle() {
        return this.g;
    }

    @Override // com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider
    @NotNull
    public String getFollowSystemSubtitle() {
        return this.b;
    }

    @Override // com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider
    @NotNull
    public String getFollowSystemTitle() {
        return this.c;
    }

    @Override // com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider
    @NotNull
    public Drawable getLightThemeImage() {
        return this.h;
    }

    @Override // com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider
    @NotNull
    public String getLightThemeTitle() {
        return this.i;
    }

    @Override // com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider
    public boolean isDarkTheme() {
        return this.a;
    }
}
