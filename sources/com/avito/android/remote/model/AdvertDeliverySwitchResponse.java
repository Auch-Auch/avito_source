package com.avito.android.remote.model;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/AdvertDeliverySwitchResponse;", "", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Landroid/net/Uri;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDeliverySwitchResponse {
    @SerializedName("message")
    @Nullable
    private final String message;
    @SerializedName(ShareConstants.MEDIA_URI)
    @Nullable
    private final Uri uri;

    public AdvertDeliverySwitchResponse(@Nullable String str, @Nullable Uri uri2) {
        this.message = str;
        this.uri = uri2;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Uri getUri() {
        return this.uri;
    }
}
