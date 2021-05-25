package com.avito.android.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.view.ContextThemeWrapper;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.avito.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J;\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/util/ShortcutInfoFactoryImpl;", "Lcom/avito/android/util/ShortcutInfoFactory;", "Landroid/content/Context;", "context", "", "id", "", "label", "icon", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Landroid/content/pm/ShortcutInfo;", "createShortcutInfo", "(Landroid/content/Context;Ljava/lang/String;IILcom/avito/android/deep_linking/links/DeepLink;)Landroid/content/pm/ShortcutInfo;", "Lcom/avito/android/ActivityIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "<init>", "(Lcom/avito/android/ActivityIntentFactory;)V", "application_release"}, k = 1, mv = {1, 4, 2})
@TargetApi(25)
public final class ShortcutInfoFactoryImpl implements ShortcutInfoFactory {
    public final ActivityIntentFactory a;

    public ShortcutInfoFactoryImpl(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        this.a = activityIntentFactory;
    }

    @Override // com.avito.android.util.ShortcutInfoFactory
    @NotNull
    public ShortcutInfo createShortcutInfo(@NotNull Context context, @NotNull String str, @StringRes int i, @DrawableRes int i2, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intent appShortcutsDeepLinkIntent = this.a.appShortcutsDeepLinkIntent(deepLink);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, R.style.Theme_DesignSystem_Avito);
        ShortcutInfo.Builder shortLabel = new ShortcutInfo.Builder(context, str).setShortLabel(context.getString(i));
        Drawable drawable = contextThemeWrapper.getDrawable(i2);
        Intrinsics.checkNotNull(drawable);
        Intrinsics.checkNotNullExpressionValue(drawable, "contextWrapper.getDrawable(icon)!!");
        ShortcutInfo build = shortLabel.setIcon(Icon.createWithBitmap(DrawablesKt.getBitmap(drawable))).setIntents(new Intent[]{appShortcutsDeepLinkIntent}).build();
        Intrinsics.checkNotNullExpressionValue(build, "ShortcutInfo.Builder(con…nts)\n            .build()");
        return build;
    }
}
