package ru.sravni.android.bankproduct.network.offer.product.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductStatusResponse;", "", "Lru/sravni/android/bankproduct/network/offer/product/response/ItemOfferStatus;", "component1", "()Lru/sravni/android/bankproduct/network/offer/product/response/ItemOfferStatus;", "itemOfferStatus", "copy", "(Lru/sravni/android/bankproduct/network/offer/product/response/ItemOfferStatus;)Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductStatusResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/offer/product/response/ItemOfferStatus;", "getItemOfferStatus", "<init>", "(Lru/sravni/android/bankproduct/network/offer/product/response/ItemOfferStatus;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductStatusResponse {
    @SerializedName("item")
    @NotNull
    private final ItemOfferStatus itemOfferStatus;

    public OfferProductStatusResponse(@NotNull ItemOfferStatus itemOfferStatus2) {
        Intrinsics.checkParameterIsNotNull(itemOfferStatus2, "itemOfferStatus");
        this.itemOfferStatus = itemOfferStatus2;
    }

    public static /* synthetic */ OfferProductStatusResponse copy$default(OfferProductStatusResponse offerProductStatusResponse, ItemOfferStatus itemOfferStatus2, int i, Object obj) {
        if ((i & 1) != 0) {
            itemOfferStatus2 = offerProductStatusResponse.itemOfferStatus;
        }
        return offerProductStatusResponse.copy(itemOfferStatus2);
    }

    @NotNull
    public final ItemOfferStatus component1() {
        return this.itemOfferStatus;
    }

    @NotNull
    public final OfferProductStatusResponse copy(@NotNull ItemOfferStatus itemOfferStatus2) {
        Intrinsics.checkParameterIsNotNull(itemOfferStatus2, "itemOfferStatus");
        return new OfferProductStatusResponse(itemOfferStatus2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof OfferProductStatusResponse) && Intrinsics.areEqual(this.itemOfferStatus, ((OfferProductStatusResponse) obj).itemOfferStatus);
        }
        return true;
    }

    @NotNull
    public final ItemOfferStatus getItemOfferStatus() {
        return this.itemOfferStatus;
    }

    public int hashCode() {
        ItemOfferStatus itemOfferStatus2 = this.itemOfferStatus;
        if (itemOfferStatus2 != null) {
            return itemOfferStatus2.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductStatusResponse(itemOfferStatus=");
        L.append(this.itemOfferStatus);
        L.append(")");
        return L.toString();
    }
}
