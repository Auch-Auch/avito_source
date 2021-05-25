package com.avito.android.util;

import android.content.Context;
import android.content.pm.ShortcutInfo;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J;\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/util/ShortcutInfoFactory;", "", "Landroid/content/Context;", "context", "", "id", "", "label", "icon", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Landroid/content/pm/ShortcutInfo;", "createShortcutInfo", "(Landroid/content/Context;Ljava/lang/String;IILcom/avito/android/deep_linking/links/DeepLink;)Landroid/content/pm/ShortcutInfo;", "application_release"}, k = 1, mv = {1, 4, 2})
public interface ShortcutInfoFactory {
    @NotNull
    ShortcutInfo createShortcutInfo(@NotNull Context context, @NotNull String str, @StringRes int i, @DrawableRes int i2, @NotNull DeepLink deepLink);
}
