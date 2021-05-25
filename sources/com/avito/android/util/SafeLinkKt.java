package com.avito.android.util;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/net/Uri;", "", "isSafeLink", "(Landroid/net/Uri;)Z", "", "externalUrl", "wrapIntoSafeLink", "(Ljava/lang/String;)Landroid/net/Uri;", "core_release"}, k = 2, mv = {1, 4, 2})
public final class SafeLinkKt {
    public static final boolean isSafeLink(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "$this$isSafeLink");
        return Intrinsics.areEqual(uri.getAuthority(), "link.avito.ru") && Intrinsics.areEqual(uri.getPath(), "/go") && uri.getQueryParameter("to") != null;
    }

    @NotNull
    public static final Uri wrapIntoSafeLink(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "externalUrl");
        Uri build = new Uri.Builder().scheme("https").authority("link.avito.ru").path("/go").appendQueryParameter("to", str).build();
        Intrinsics.checkNotNullExpressionValue(build, "Uri.Builder()\n        .s…rnalUrl)\n        .build()");
        return build;
    }
}
