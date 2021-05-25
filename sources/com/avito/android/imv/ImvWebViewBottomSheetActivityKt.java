package com.avito.android.imv;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Landroid/content/Intent;", "createImvWebViewBottomSheetActivityIntent", "(Landroid/content/Context;Landroid/net/Uri;)Landroid/content/Intent;", "imv-webview-bottomsheet_release"}, k = 2, mv = {1, 4, 2})
public final class ImvWebViewBottomSheetActivityKt {
    @NotNull
    public static final Intent createImvWebViewBottomSheetActivityIntent(@NotNull Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intent putExtra = new Intent(context, ImvWebViewBottomSheetActivity.class).putExtra("key_uri", uri);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…  .putExtra(KEY_URI, uri)");
        return putExtra;
    }
}
