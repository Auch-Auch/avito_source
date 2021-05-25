package ru.sravni.android.bankproduct.network.offer.product.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductDisplaySettingsRepo;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductStatusRepo;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001:\u00010BM\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\u0004\b.\u0010/J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J`\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R$\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b%\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\u0007R\u001c\u0010\u0018\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b(\u0010\u0007R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b)\u0010\u0007R\u001c\u0010\u0015\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b*\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b+\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010,\u001a\u0004\b-\u0010\n¨\u00061"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/response/ItemOfferStatus;", "", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductStatusRepo;", "toOfferStatusElementRepo", "()Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductStatusRepo;", "", "component1", "()Ljava/lang/String;", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDisplaySettingsResponse;", "component2", "()Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDisplaySettingsResponse;", "component3", "component4", "component5", "component6", "", "Lru/sravni/android/bankproduct/network/offer/product/response/ItemOfferStatus$Status;", "component7", "()Ljava/util/List;", "productType", "displaySettings", "productID", "orderID", "savedSearchID", "bankID", "statusList", "copy", "(Ljava/lang/String;Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDisplaySettingsResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/network/offer/product/response/ItemOfferStatus;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getStatusList", "Ljava/lang/String;", "getProductType", "getBankID", "getOrderID", "getProductID", "getSavedSearchID", "Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDisplaySettingsResponse;", "getDisplaySettings", "<init>", "(Ljava/lang/String;Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDisplaySettingsResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Status", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ItemOfferStatus {
    @SerializedName("bankId")
    @NotNull
    private final String bankID;
    @SerializedName("displaySettings")
    @NotNull
    private final OfferProductDisplaySettingsResponse displaySettings;
    @SerializedName(AnalyticFieldsName.orderId)
    @Nullable
    private final String orderID;
    @SerializedName("productId")
    @NotNull
    private final String productID;
    @SerializedName("productType")
    @NotNull
    private final String productType;
    @SerializedName("savedSearchId")
    @NotNull
    private final String savedSearchID;
    @SerializedName("statusList")
    @Nullable
    private final List<Status> statusList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J0\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\f\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/response/ItemOfferStatus$Status;", "", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductStatusRepo$OfferStatusElementRepo;", "toOfferStatusElementRepo", "()Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductStatusRepo$OfferStatusElementRepo;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "elementType", "status", "text", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/offer/product/response/ItemOfferStatus$Status;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "getStatus", "getElementType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Status {
        @SerializedName("elementType")
        @NotNull
        private final String elementType;
        @SerializedName("status")
        @Nullable
        private final String status;
        @SerializedName("text")
        @NotNull
        private final String text;

        public Status(@NotNull String str, @Nullable String str2, @NotNull String str3) {
            Intrinsics.checkParameterIsNotNull(str, "elementType");
            Intrinsics.checkParameterIsNotNull(str3, "text");
            this.elementType = str;
            this.status = str2;
            this.text = str3;
        }

        public static /* synthetic */ Status copy$default(Status status2, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = status2.elementType;
            }
            if ((i & 2) != 0) {
                str2 = status2.status;
            }
            if ((i & 4) != 0) {
                str3 = status2.text;
            }
            return status2.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.elementType;
        }

        @Nullable
        public final String component2() {
            return this.status;
        }

        @NotNull
        public final String component3() {
            return this.text;
        }

        @NotNull
        public final Status copy(@NotNull String str, @Nullable String str2, @NotNull String str3) {
            Intrinsics.checkParameterIsNotNull(str, "elementType");
            Intrinsics.checkParameterIsNotNull(str3, "text");
            return new Status(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Status)) {
                return false;
            }
            Status status2 = (Status) obj;
            return Intrinsics.areEqual(this.elementType, status2.elementType) && Intrinsics.areEqual(this.status, status2.status) && Intrinsics.areEqual(this.text, status2.text);
        }

        @NotNull
        public final String getElementType() {
            return this.elementType;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            String str = this.elementType;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.status;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.text;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public final OfferProductStatusRepo.OfferStatusElementRepo toOfferStatusElementRepo() {
            return new OfferProductStatusRepo.OfferStatusElementRepo(this.elementType, this.status, this.text);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Status(elementType=");
            L.append(this.elementType);
            L.append(", status=");
            L.append(this.status);
            L.append(", text=");
            return a.t(L, this.text, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Status(String str, String str2, String str3, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : str2, str3);
        }
    }

    public ItemOfferStatus(@NotNull String str, @NotNull OfferProductDisplaySettingsResponse offerProductDisplaySettingsResponse, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @Nullable List<Status> list) {
        Intrinsics.checkParameterIsNotNull(str, "productType");
        Intrinsics.checkParameterIsNotNull(offerProductDisplaySettingsResponse, "displaySettings");
        Intrinsics.checkParameterIsNotNull(str2, "productID");
        Intrinsics.checkParameterIsNotNull(str4, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(str5, "bankID");
        this.productType = str;
        this.displaySettings = offerProductDisplaySettingsResponse;
        this.productID = str2;
        this.orderID = str3;
        this.savedSearchID = str4;
        this.bankID = str5;
        this.statusList = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: ru.sravni.android.bankproduct.network.offer.product.response.ItemOfferStatus */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ItemOfferStatus copy$default(ItemOfferStatus itemOfferStatus, String str, OfferProductDisplaySettingsResponse offerProductDisplaySettingsResponse, String str2, String str3, String str4, String str5, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = itemOfferStatus.productType;
        }
        if ((i & 2) != 0) {
            offerProductDisplaySettingsResponse = itemOfferStatus.displaySettings;
        }
        if ((i & 4) != 0) {
            str2 = itemOfferStatus.productID;
        }
        if ((i & 8) != 0) {
            str3 = itemOfferStatus.orderID;
        }
        if ((i & 16) != 0) {
            str4 = itemOfferStatus.savedSearchID;
        }
        if ((i & 32) != 0) {
            str5 = itemOfferStatus.bankID;
        }
        if ((i & 64) != 0) {
            list = itemOfferStatus.statusList;
        }
        return itemOfferStatus.copy(str, offerProductDisplaySettingsResponse, str2, str3, str4, str5, list);
    }

    @NotNull
    public final String component1() {
        return this.productType;
    }

    @NotNull
    public final OfferProductDisplaySettingsResponse component2() {
        return this.displaySettings;
    }

    @NotNull
    public final String component3() {
        return this.productID;
    }

    @Nullable
    public final String component4() {
        return this.orderID;
    }

    @NotNull
    public final String component5() {
        return this.savedSearchID;
    }

    @NotNull
    public final String component6() {
        return this.bankID;
    }

    @Nullable
    public final List<Status> component7() {
        return this.statusList;
    }

    @NotNull
    public final ItemOfferStatus copy(@NotNull String str, @NotNull OfferProductDisplaySettingsResponse offerProductDisplaySettingsResponse, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @Nullable List<Status> list) {
        Intrinsics.checkParameterIsNotNull(str, "productType");
        Intrinsics.checkParameterIsNotNull(offerProductDisplaySettingsResponse, "displaySettings");
        Intrinsics.checkParameterIsNotNull(str2, "productID");
        Intrinsics.checkParameterIsNotNull(str4, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(str5, "bankID");
        return new ItemOfferStatus(str, offerProductDisplaySettingsResponse, str2, str3, str4, str5, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemOfferStatus)) {
            return false;
        }
        ItemOfferStatus itemOfferStatus = (ItemOfferStatus) obj;
        return Intrinsics.areEqual(this.productType, itemOfferStatus.productType) && Intrinsics.areEqual(this.displaySettings, itemOfferStatus.displaySettings) && Intrinsics.areEqual(this.productID, itemOfferStatus.productID) && Intrinsics.areEqual(this.orderID, itemOfferStatus.orderID) && Intrinsics.areEqual(this.savedSearchID, itemOfferStatus.savedSearchID) && Intrinsics.areEqual(this.bankID, itemOfferStatus.bankID) && Intrinsics.areEqual(this.statusList, itemOfferStatus.statusList);
    }

    @NotNull
    public final String getBankID() {
        return this.bankID;
    }

    @NotNull
    public final OfferProductDisplaySettingsResponse getDisplaySettings() {
        return this.displaySettings;
    }

    @Nullable
    public final String getOrderID() {
        return this.orderID;
    }

    @NotNull
    public final String getProductID() {
        return this.productID;
    }

    @NotNull
    public final String getProductType() {
        return this.productType;
    }

    @NotNull
    public final String getSavedSearchID() {
        return this.savedSearchID;
    }

    @Nullable
    public final List<Status> getStatusList() {
        return this.statusList;
    }

    public int hashCode() {
        String str = this.productType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        OfferProductDisplaySettingsResponse offerProductDisplaySettingsResponse = this.displaySettings;
        int hashCode2 = (hashCode + (offerProductDisplaySettingsResponse != null ? offerProductDisplaySettingsResponse.hashCode() : 0)) * 31;
        String str2 = this.productID;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.orderID;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.savedSearchID;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.bankID;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List<Status> list = this.statusList;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public final OfferProductStatusRepo toOfferStatusElementRepo() {
        List list;
        String str = this.productType;
        OfferProductDisplaySettingsRepo offerProductDisplaySettingsRepo = this.displaySettings.toOfferProductDisplaySettingsRepo();
        String str2 = this.productID;
        String str3 = this.orderID;
        String str4 = this.savedSearchID;
        String str5 = this.bankID;
        List<Status> list2 = this.statusList;
        if (list2 != null) {
            list = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                list.add(it.next().toOfferStatusElementRepo());
            }
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return new OfferProductStatusRepo(str, offerProductDisplaySettingsRepo, str2, str3, str5, str4, list);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ItemOfferStatus(productType=");
        L.append(this.productType);
        L.append(", displaySettings=");
        L.append(this.displaySettings);
        L.append(", productID=");
        L.append(this.productID);
        L.append(", orderID=");
        L.append(this.orderID);
        L.append(", savedSearchID=");
        L.append(this.savedSearchID);
        L.append(", bankID=");
        L.append(this.bankID);
        L.append(", statusList=");
        return a.w(L, this.statusList, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemOfferStatus(String str, OfferProductDisplaySettingsResponse offerProductDisplaySettingsResponse, String str2, String str3, String str4, String str5, List list, int i, j jVar) {
        this(str, offerProductDisplaySettingsResponse, str2, (i & 8) != 0 ? null : str3, str4, str5, (i & 64) != 0 ? null : list);
    }
}
