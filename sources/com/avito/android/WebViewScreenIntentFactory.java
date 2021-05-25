package com.avito.android;

import android.content.Intent;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/WebViewScreenIntentFactory;", "", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", Tracker.Events.CREATIVE_FULLSCREEN, "withAuthorization", "Landroid/content/Intent;", "webViewScreenIntent", "(Landroid/net/Uri;ZZ)Landroid/content/Intent;", "Lcom/avito/android/CalledFrom;", "calledFrom", "(Landroid/net/Uri;Lcom/avito/android/CalledFrom;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface WebViewScreenIntentFactory {
    @NotNull
    Intent webViewScreenIntent(@NotNull Uri uri, @NotNull CalledFrom calledFrom);

    @NotNull
    Intent webViewScreenIntent(@NotNull Uri uri, boolean z, boolean z2);
}
