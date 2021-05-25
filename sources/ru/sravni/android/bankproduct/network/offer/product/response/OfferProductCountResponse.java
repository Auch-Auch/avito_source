package ru.sravni.android.bankproduct.network.offer.product.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductCountResponse;", "", "", "component1", "()I", "count", "copy", "(I)Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductCountResponse;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCount", "<init>", "(I)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductCountResponse {
    @SerializedName("count")
    private final int count;

    public OfferProductCountResponse(int i) {
        this.count = i;
    }

    public static /* synthetic */ OfferProductCountResponse copy$default(OfferProductCountResponse offerProductCountResponse, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = offerProductCountResponse.count;
        }
        return offerProductCountResponse.copy(i);
    }

    public final int component1() {
        return this.count;
    }

    @NotNull
    public final OfferProductCountResponse copy(int i) {
        return new OfferProductCountResponse(i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof OfferProductCountResponse) && this.count == ((OfferProductCountResponse) obj).count;
        }
        return true;
    }

    public final int getCount() {
        return this.count;
    }

    public int hashCode() {
        return this.count;
    }

    @NotNull
    public String toString() {
        return a.j(a.L("OfferProductCountResponse(count="), this.count, ")");
    }
}
