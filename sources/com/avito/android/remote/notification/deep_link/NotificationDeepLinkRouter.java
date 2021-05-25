package com.avito.android.remote.notification.deep_link;

import android.net.Uri;
import com.avito.android.CalledFrom;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/notification/deep_link/NotificationDeepLinkRouter;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/CalledFrom$Push;", "calledFrom", "", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/CalledFrom$Push;)Z", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "openPromoScreen", "(Landroid/net/Uri;Lcom/avito/android/CalledFrom$Push;)V", "closeScreen", "()V", "notification-deeplink_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationDeepLinkRouter {
    void closeScreen();

    boolean openDeepLink(@NotNull DeepLink deepLink, @NotNull CalledFrom.Push push);

    void openPromoScreen(@NotNull Uri uri, @NotNull CalledFrom.Push push);
}
