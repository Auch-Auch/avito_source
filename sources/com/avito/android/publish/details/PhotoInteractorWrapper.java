package com.avito.android.publish.details;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/details/PhotoInteractorWrapper;", "", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", VKApiConst.POSITION, "", "uploadId", "", ProductAction.ACTION_ADD, "(Landroid/net/Uri;ILjava/lang/String;)V", "deleteAll", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoInteractorWrapper {
    void add(@NotNull Uri uri, int i, @NotNull String str);

    void deleteAll();
}
