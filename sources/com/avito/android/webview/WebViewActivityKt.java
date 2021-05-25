package com.avito.android.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.avito.android.CalledFrom;
import com.avito.android.util.Intents;
import com.facebook.share.internal.ShareConstants;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t\u001a%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\f¨\u0006\r"}, d2 = {"Landroid/content/Context;", "context", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", Tracker.Events.CREATIVE_FULLSCREEN, "withAuthorization", "Landroid/content/Intent;", "createWebViewActivityIntent", "(Landroid/content/Context;Landroid/net/Uri;ZZ)Landroid/content/Intent;", "Lcom/avito/android/CalledFrom;", "calledFrom", "(Landroid/content/Context;Landroid/net/Uri;Lcom/avito/android/CalledFrom;)Landroid/content/Intent;", "webview_release"}, k = 2, mv = {1, 4, 2})
public final class WebViewActivityKt {
    @NotNull
    public static final Intent createWebViewActivityIntent(@NotNull Context context, @NotNull Uri uri, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intent putExtra = new Intent(context, WebViewActivity.class).putExtra("key_uri", uri).putExtra("key_fullscreen", z).putExtra("key_with_authorization", z2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…ATION, withAuthorization)");
        return putExtra;
    }

    @NotNull
    public static final Intent createWebViewActivityIntent(@NotNull Context context, @NotNull Uri uri, @NotNull CalledFrom calledFrom) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(calledFrom, "calledFrom");
        Intent putExtra = new Intent(context, WebViewActivity.class).putExtra("key_uri", uri);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…  .putExtra(KEY_URI, uri)");
        Intents.setCalledFrom(putExtra, calledFrom);
        return putExtra;
    }
}
