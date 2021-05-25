package ru.sravni.android.bankproduct.network.dashboard.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\u00020\u00002\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/network/dashboard/response/OfferCalculationListResponse;", "", "", "Lru/sravni/android/bankproduct/network/dashboard/response/OfferCalculationItem;", "component1", "()Ljava/util/List;", "items", "copy", "(Ljava/util/List;)Lru/sravni/android/bankproduct/network/dashboard/response/OfferCalculationListResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferCalculationListResponse {
    @SerializedName("items")
    @Nullable
    private final List<OfferCalculationItem> items;

    public OfferCalculationListResponse() {
        this(null, 1, null);
    }

    public OfferCalculationListResponse(@Nullable List<OfferCalculationItem> list) {
        this.items = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.dashboard.response.OfferCalculationListResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferCalculationListResponse copy$default(OfferCalculationListResponse offerCalculationListResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = offerCalculationListResponse.items;
        }
        return offerCalculationListResponse.copy(list);
    }

    @Nullable
    public final List<OfferCalculationItem> component1() {
        return this.items;
    }

    @NotNull
    public final OfferCalculationListResponse copy(@Nullable List<OfferCalculationItem> list) {
        return new OfferCalculationListResponse(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof OfferCalculationListResponse) && Intrinsics.areEqual(this.items, ((OfferCalculationListResponse) obj).items);
        }
        return true;
    }

    @Nullable
    public final List<OfferCalculationItem> getItems() {
        return this.items;
    }

    public int hashCode() {
        List<OfferCalculationItem> list = this.items;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.w(a.L("OfferCalculationListResponse(items="), this.items, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OfferCalculationListResponse(List list, int i, j jVar) {
        this((i & 1) != 0 ? null : list);
    }
}
