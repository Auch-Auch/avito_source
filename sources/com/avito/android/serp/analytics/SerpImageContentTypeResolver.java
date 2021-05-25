package com.avito.android.serp.analytics;

import android.net.Uri;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.image.ImageContentTypeResolver;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/serp/analytics/SerpImageContentTypeResolver;", "Lcom/avito/android/analytics/screens/image/ImageContentTypeResolver;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "resolve", "(Landroid/net/Uri;)Ljava/lang/String;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpImageContentTypeResolver implements ImageContentTypeResolver {
    @Override // com.avito.android.analytics.screens.image.ImageContentTypeResolver
    @NotNull
    public String resolve(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return ScreenPublicConstsKt.CONTENT_TYPE_ADVERT;
    }
}
