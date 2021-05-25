package ru.sravni.android.bankproduct.network.offer.product.request.legacy;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/request/legacy/OfferSendRequest;", "", "", "component1", "()Ljava/lang/String;", "requestParams", "copy", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/network/offer/product/request/legacy/OfferSendRequest;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRequestParams", "<init>", "(Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferSendRequest {
    @SerializedName("requestParams")
    @NotNull
    private final String requestParams;

    public OfferSendRequest(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "requestParams");
        this.requestParams = str;
    }

    public static /* synthetic */ OfferSendRequest copy$default(OfferSendRequest offerSendRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offerSendRequest.requestParams;
        }
        return offerSendRequest.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.requestParams;
    }

    @NotNull
    public final OfferSendRequest copy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "requestParams");
        return new OfferSendRequest(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof OfferSendRequest) && Intrinsics.areEqual(this.requestParams, ((OfferSendRequest) obj).requestParams);
        }
        return true;
    }

    @NotNull
    public final String getRequestParams() {
        return this.requestParams;
    }

    public int hashCode() {
        String str = this.requestParams;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.t(a.L("OfferSendRequest(requestParams="), this.requestParams, ")");
    }
}
