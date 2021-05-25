package com.avito.android.util;

import android.content.Intent;
import android.net.Uri;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J-\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\fJ)\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\r\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H&¢\u0006\u0004\b\u0019\u0010\u0018J\u001d\u0010\u001c\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000eH&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H&¢\u0006\u0004\b!\u0010\u0018J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H&¢\u0006\u0004\b&\u0010\u0018J!\u0010)\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020'H&¢\u0006\u0004\b)\u0010*J\u001f\u0010-\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0002H&¢\u0006\u0004\b-\u0010\fJ\u000f\u0010.\u001a\u00020\u0006H&¢\u0006\u0004\b.\u0010\u0018J\u000f\u0010/\u001a\u00020\u0006H&¢\u0006\u0004\b/\u0010\u0018J#\u00101\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b1\u00102J\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u0006032\u0006\u0010\u001e\u001a\u00020\u000eH&¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000eH&¢\u0006\u0004\b6\u0010 J\u001f\u00106\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u0002H&¢\u0006\u0004\b6\u00108J\u001f\u0010:\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u00109\u001a\u00020'H&¢\u0006\u0004\b:\u0010*J-\u0010=\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u00062\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000603H&¢\u0006\u0004\b=\u0010>J!\u0010@\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000e2\b\u0010?\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b@\u00108¨\u0006A"}, d2 = {"Lcom/avito/android/util/ImplicitIntentFactory;", "", "", "email", "subject", SDKConstants.PARAM_A2U_BODY, "Landroid/content/Intent;", "emailIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "url", "title", "shareItemIntent", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "shareIntent", "Landroid/net/Uri;", "imageUri", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Landroid/content/Intent;", "intent", "pickActivityIntent", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;", "number", "dialIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "pickExternalMultipleImageIntent", "()Landroid/content/Intent;", "pickExternalSingleImageIntent", "", "mimeTypes", "pickExternalSingleFileOfSpecificFormatsIntent", "([Ljava/lang/String;)Landroid/content/Intent;", ShareConstants.MEDIA_URI, "frontCameraIntent", "(Landroid/net/Uri;)Landroid/content/Intent;", "locationSettingsIntent", "Lcom/avito/android/remote/model/Coordinates;", "targetCoordinates", "mapsApplicationsIntent", "(Lcom/avito/android/remote/model/Coordinates;)Landroid/content/Intent;", "createAppSettingsIntent", "", "withShareButton", "uriIntentCustomChromeTabs", "(Landroid/net/Uri;Z)Landroid/content/Intent;", BookingInfoActivity.EXTRA_ITEM_ID, "queryParameters", "autotekaBuyReportCustomChromeTabsIntent", "marketIntent", "notificationsSettingsIntent", "fallback", "externalUriIntent", "(Landroid/net/Uri;Landroid/net/Uri;)Landroid/content/Intent;", "", "getExternalIntentsForUrl", "(Landroid/net/Uri;)Ljava/util/List;", "uriIntent", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;", "useCustomTab", "safeUriIntent", "targetIntent", "initialIntents", "chooserIntent", "(Ljava/lang/String;Landroid/content/Intent;Ljava/util/List;)Landroid/content/Intent;", MessageBody.File.MIME_TYPE, "openExternalFileOfSpecificType", "core_release"}, k = 1, mv = {1, 4, 2})
public interface ImplicitIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent uriIntentCustomChromeTabs$default(ImplicitIntentFactory implicitIntentFactory, Uri uri, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return implicitIntentFactory.uriIntentCustomChromeTabs(uri, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uriIntentCustomChromeTabs");
        }
    }

    @NotNull
    Intent autotekaBuyReportCustomChromeTabsIntent(@NotNull String str, @NotNull String str2);

    @NotNull
    Intent chooserIntent(@NotNull String str, @NotNull Intent intent, @NotNull List<? extends Intent> list);

    @NotNull
    Intent createAppSettingsIntent();

    @NotNull
    Intent dialIntent(@NotNull String str);

    @NotNull
    Intent emailIntent(@Nullable String str, @Nullable String str2, @Nullable String str3);

    @Nullable
    Intent externalUriIntent(@NotNull Uri uri, @Nullable Uri uri2);

    @NotNull
    Intent frontCameraIntent(@NotNull Uri uri);

    @NotNull
    List<Intent> getExternalIntentsForUrl(@NotNull Uri uri);

    @NotNull
    Intent locationSettingsIntent();

    @NotNull
    Intent mapsApplicationsIntent(@NotNull Coordinates coordinates);

    @NotNull
    Intent marketIntent();

    @NotNull
    Intent notificationsSettingsIntent();

    @NotNull
    Intent openExternalFileOfSpecificType(@NotNull Uri uri, @Nullable String str);

    @NotNull
    Intent pickActivityIntent(@NotNull Intent intent, @NotNull String str);

    @NotNull
    Intent pickExternalMultipleImageIntent();

    @NotNull
    Intent pickExternalSingleFileOfSpecificFormatsIntent(@NotNull String[] strArr);

    @NotNull
    Intent pickExternalSingleImageIntent();

    @NotNull
    Intent safeUriIntent(@NotNull Uri uri, boolean z);

    @NotNull
    Intent shareIntent(@Nullable String str, @NotNull String str2);

    @NotNull
    Intent shareIntent(@Nullable String str, @NotNull String str2, @NotNull Uri uri);

    @NotNull
    Intent shareItemIntent(@NotNull String str, @NotNull String str2);

    @NotNull
    Intent uriIntent(@NotNull Uri uri);

    @NotNull
    Intent uriIntent(@NotNull Uri uri, @NotNull String str);

    @NotNull
    Intent uriIntentCustomChromeTabs(@NotNull Uri uri, boolean z);
}
