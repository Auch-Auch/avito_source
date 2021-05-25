package com.avito.android.deep_linking;

import android.content.Context;
import android.content.Intent;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Landroid/content/Intent;", "createAppShortcutsDeepLinkActivityIntent", "(Landroid/content/Context;Lcom/avito/android/deep_linking/links/DeepLink;)Landroid/content/Intent;", "deep-linking_release"}, k = 2, mv = {1, 4, 2})
public final class AppShortcutsDeepLinkActivityKt {
    @NotNull
    public static final Intent createAppShortcutsDeepLinkActivityIntent(@NotNull Context context, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intent data = new Intent(context, AppShortcutsDeepLinkActivity.class).setAction("android.intent.action.VIEW").setData(deepLink.getUri());
        Intrinsics.checkNotNullExpressionValue(data, "Intent(context, AppShort…   .setData(deepLink.uri)");
        return data;
    }
}
