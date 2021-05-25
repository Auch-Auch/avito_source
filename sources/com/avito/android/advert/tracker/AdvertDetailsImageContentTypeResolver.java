package com.avito.android.advert.tracker;

import android.net.Uri;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.image.ImageContentTypeResolver;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/tracker/AdvertDetailsImageContentTypeResolver;", "Lcom/avito/android/analytics/screens/image/ImageContentTypeResolver;", "", "Landroid/net/Uri;", "mainUris", "", "registerMainUris", "(Ljava/util/Set;)V", ShareConstants.MEDIA_URI, "", "resolve", "(Landroid/net/Uri;)Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsImageContentTypeResolver implements ImageContentTypeResolver {
    public Set<? extends Uri> a = y.emptySet();

    public final void registerMainUris(@NotNull Set<? extends Uri> set) {
        Intrinsics.checkNotNullParameter(set, "mainUris");
        this.a = set;
    }

    @Override // com.avito.android.analytics.screens.image.ImageContentTypeResolver
    @NotNull
    public String resolve(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return this.a.contains(uri) ? ScreenPublicConstsKt.CONTENT_TYPE_ADVERT : "complementary";
    }
}
