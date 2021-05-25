package com.avito.android;

import android.content.Intent;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0015\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/NotificationCenterIntentFactory;", "", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", Tracker.Events.CREATIVE_FULLSCREEN, "withAuthorization", "Landroid/content/Intent;", "promoIntent", "(Landroid/net/Uri;ZZ)Landroid/content/Intent;", "Lcom/avito/android/CalledFrom;", "calledFrom", "(Landroid/net/Uri;Lcom/avito/android/CalledFrom;)Landroid/content/Intent;", "notificationCenterIntent", "()Landroid/content/Intent;", "", "id", "notificationCenterLandingUnifiedIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "notificationCenterLandingMainIntent", "notificationCenterLandingRecommendsIntent", "notificationCenterLandingFeedbackIntent", "notificationCenterLandingShareIntent", "core_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent promoIntent$default(NotificationCenterIntentFactory notificationCenterIntentFactory, Uri uri, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                if ((i & 4) != 0) {
                    z2 = false;
                }
                return notificationCenterIntentFactory.promoIntent(uri, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: promoIntent");
        }
    }

    @NotNull
    Intent notificationCenterIntent();

    @NotNull
    Intent notificationCenterLandingFeedbackIntent(@NotNull String str);

    @NotNull
    Intent notificationCenterLandingMainIntent(@NotNull String str);

    @NotNull
    Intent notificationCenterLandingRecommendsIntent(@NotNull String str);

    @NotNull
    Intent notificationCenterLandingShareIntent(@NotNull String str);

    @NotNull
    Intent notificationCenterLandingUnifiedIntent(@NotNull String str);

    @NotNull
    Intent promoIntent(@NotNull Uri uri, @NotNull CalledFrom calledFrom);

    @NotNull
    Intent promoIntent(@NotNull Uri uri, boolean z, boolean z2);
}
