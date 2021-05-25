package com.avito.android.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.avito.android.CalledFrom;
import com.avito.android.WebViewScreenIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import com.yandex.mobile.ads.video.tracking.Tracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/webview/WebViewScreenIntentFactoryImpl;", "Lcom/avito/android/WebViewScreenIntentFactory;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", Tracker.Events.CREATIVE_FULLSCREEN, "withAuthorization", "Landroid/content/Intent;", "webViewScreenIntent", "(Landroid/net/Uri;ZZ)Landroid/content/Intent;", "Lcom/avito/android/CalledFrom;", "calledFrom", "(Landroid/net/Uri;Lcom/avito/android/CalledFrom;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "webview_release"}, k = 1, mv = {1, 4, 2})
public final class WebViewScreenIntentFactoryImpl implements WebViewScreenIntentFactory {
    public final Context a;

    @Inject
    public WebViewScreenIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.WebViewScreenIntentFactory
    @NotNull
    public Intent webViewScreenIntent(@NotNull Uri uri, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return WebViewActivityKt.createWebViewActivityIntent(this.a, uri, z, z2);
    }

    @Override // com.avito.android.WebViewScreenIntentFactory
    @NotNull
    public Intent webViewScreenIntent(@NotNull Uri uri, @NotNull CalledFrom calledFrom) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(calledFrom, "calledFrom");
        return WebViewActivityKt.createWebViewActivityIntent(this.a, uri, calledFrom);
    }
}
