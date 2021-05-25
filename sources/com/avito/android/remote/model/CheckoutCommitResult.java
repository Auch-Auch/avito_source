package com.avito.android.remote.model;

import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/CheckoutCommitResult;", "", "Lcom/avito/android/remote/model/CheckoutDialog;", "successDialog", "Lcom/avito/android/remote/model/CheckoutDialog;", "getSuccessDialog", "()Lcom/avito/android/remote/model/CheckoutDialog;", "activeDialog", "getActiveDialog", "Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/CheckoutDialog;Lcom/avito/android/remote/model/CheckoutDialog;)V", "checkout_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutCommitResult {
    @SerializedName("activeDialog")
    @Nullable
    private final CheckoutDialog activeDialog;
    @SerializedName("successDialog")
    @Nullable
    private final CheckoutDialog successDialog;
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final DeepLink uri;

    public CheckoutCommitResult(@NotNull DeepLink deepLink, @Nullable CheckoutDialog checkoutDialog, @Nullable CheckoutDialog checkoutDialog2) {
        Intrinsics.checkNotNullParameter(deepLink, ShareConstants.MEDIA_URI);
        this.uri = deepLink;
        this.successDialog = checkoutDialog;
        this.activeDialog = checkoutDialog2;
    }

    @Nullable
    public final CheckoutDialog getActiveDialog() {
        return this.activeDialog;
    }

    @Nullable
    public final CheckoutDialog getSuccessDialog() {
        return this.successDialog;
    }

    @NotNull
    public final DeepLink getUri() {
        return this.uri;
    }
}
