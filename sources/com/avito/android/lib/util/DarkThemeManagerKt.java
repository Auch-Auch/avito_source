package com.avito.android.lib.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0006¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0003\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\b\u0010\u0005\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0006¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Landroid/content/Context;", "", "isDarkTheme", "(Landroid/content/Context;)Z", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)Z", "Landroid/content/res/Configuration;", "(Landroid/content/res/Configuration;)Z", "isLightTheme", "components_release"}, k = 2, mv = {1, 4, 2})
public final class DarkThemeManagerKt {
    public static final boolean isDarkTheme(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$isDarkTheme");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return isDarkTheme(resources);
    }

    public static final boolean isLightTheme(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$isLightTheme");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return isLightTheme(resources);
    }

    public static final boolean isDarkTheme(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "$this$isDarkTheme");
        Configuration configuration = resources.getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "configuration");
        return isDarkTheme(configuration);
    }

    public static final boolean isLightTheme(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "$this$isLightTheme");
        Configuration configuration = resources.getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "configuration");
        return isLightTheme(configuration);
    }

    public static final boolean isDarkTheme(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "$this$isDarkTheme");
        return (configuration.uiMode & 48) == 32;
    }

    public static final boolean isLightTheme(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "$this$isLightTheme");
        return !isDarkTheme(configuration);
    }
}
