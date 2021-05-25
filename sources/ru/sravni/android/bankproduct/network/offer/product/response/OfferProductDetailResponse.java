package ru.sravni.android.bankproduct.network.offer.product.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.network.offer.product.response.OfferProductListResponse;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDetailResponse;", "", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse;", "component1", "()Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse;", "itemOfferDetail", "copy", "(Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse;)Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDetailResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse;", "getItemOfferDetail", "<init>", "(Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductListResponse$ItemResponse$OfferGroupResponse$OfferResponse;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductDetailResponse {
    @SerializedName("item")
    @NotNull
    private final OfferProductListResponse.ItemResponse.OfferGroupResponse.OfferResponse itemOfferDetail;

    public OfferProductDetailResponse(@NotNull OfferProductListResponse.ItemResponse.OfferGroupResponse.OfferResponse offerResponse) {
        Intrinsics.checkParameterIsNotNull(offerResponse, "itemOfferDetail");
        this.itemOfferDetail = offerResponse;
    }

    public static /* synthetic */ OfferProductDetailResponse copy$default(OfferProductDetailResponse offerProductDetailResponse, OfferProductListResponse.ItemResponse.OfferGroupResponse.OfferResponse offerResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            offerResponse = offerProductDetailResponse.itemOfferDetail;
        }
        return offerProductDetailResponse.copy(offerResponse);
    }

    @NotNull
    public final OfferProductListResponse.ItemResponse.OfferGroupResponse.OfferResponse component1() {
        return this.itemOfferDetail;
    }

    @NotNull
    public final OfferProductDetailResponse copy(@NotNull OfferProductListResponse.ItemResponse.OfferGroupResponse.OfferResponse offerResponse) {
        Intrinsics.checkParameterIsNotNull(offerResponse, "itemOfferDetail");
        return new OfferProductDetailResponse(offerResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof OfferProductDetailResponse) && Intrinsics.areEqual(this.itemOfferDetail, ((OfferProductDetailResponse) obj).itemOfferDetail);
        }
        return true;
    }

    @NotNull
    public final OfferProductListResponse.ItemResponse.OfferGroupResponse.OfferResponse getItemOfferDetail() {
        return this.itemOfferDetail;
    }

    public int hashCode() {
        OfferProductListResponse.ItemResponse.OfferGroupResponse.OfferResponse offerResponse = this.itemOfferDetail;
        if (offerResponse != null) {
            return offerResponse.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductDetailResponse(itemOfferDetail=");
        L.append(this.itemOfferDetail);
        L.append(")");
        return L.toString();
    }
}
