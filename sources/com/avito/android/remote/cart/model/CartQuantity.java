package com.avito.android.remote.cart.model;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/cart/model/CartQuantity;", "", "", "component1", "()Ljava/lang/Integer;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", FirebaseAnalytics.Param.QUANTITY, ShareConstants.MEDIA_URI, "copy", "(Ljava/lang/Integer;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/remote/cart/model/CartQuantity;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "Ljava/lang/Integer;", "getQuantity", "<init>", "(Ljava/lang/Integer;Lcom/avito/android/deep_linking/links/DeepLink;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class CartQuantity {
    @SerializedName(FirebaseAnalytics.Param.QUANTITY)
    @Nullable
    private final Integer quantity;
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final DeepLink uri;

    public CartQuantity(@Nullable Integer num, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, ShareConstants.MEDIA_URI);
        this.quantity = num;
        this.uri = deepLink;
    }

    public static /* synthetic */ CartQuantity copy$default(CartQuantity cartQuantity, Integer num, DeepLink deepLink, int i, Object obj) {
        if ((i & 1) != 0) {
            num = cartQuantity.quantity;
        }
        if ((i & 2) != 0) {
            deepLink = cartQuantity.uri;
        }
        return cartQuantity.copy(num, deepLink);
    }

    @Nullable
    public final Integer component1() {
        return this.quantity;
    }

    @NotNull
    public final DeepLink component2() {
        return this.uri;
    }

    @NotNull
    public final CartQuantity copy(@Nullable Integer num, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, ShareConstants.MEDIA_URI);
        return new CartQuantity(num, deepLink);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartQuantity)) {
            return false;
        }
        CartQuantity cartQuantity = (CartQuantity) obj;
        return Intrinsics.areEqual(this.quantity, cartQuantity.quantity) && Intrinsics.areEqual(this.uri, cartQuantity.uri);
    }

    @Nullable
    public final Integer getQuantity() {
        return this.quantity;
    }

    @NotNull
    public final DeepLink getUri() {
        return this.uri;
    }

    public int hashCode() {
        Integer num = this.quantity;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        DeepLink deepLink = this.uri;
        if (deepLink != null) {
            i = deepLink.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CartQuantity(quantity=");
        L.append(this.quantity);
        L.append(", uri=");
        return a.m(L, this.uri, ")");
    }
}
