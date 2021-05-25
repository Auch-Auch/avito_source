package ru.sravni.android.bankproduct.network.offer.entity.request;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0018"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/entity/request/OfferFilterRequest;", "", "", "Lru/sravni/android/bankproduct/network/offer/entity/request/OfferFilterRequest$OfferFilterInfoRequest;", "component1", "()Ljava/util/List;", "items", "copy", "(Ljava/util/List;)Lru/sravni/android/bankproduct/network/offer/entity/request/OfferFilterRequest;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;)V", "OfferFilterInfoRequest", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferFilterRequest {
    @SerializedName("items")
    @NotNull
    private final List<OfferFilterInfoRequest> items;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/entity/request/OfferFilterRequest$OfferFilterInfoRequest;", "", "", "component1", "()Ljava/lang/String;", "component2", "name", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/offer/entity/request/OfferFilterRequest$OfferFilterInfoRequest;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class OfferFilterInfoRequest {
        @SerializedName("name")
        @NotNull
        private final String name;
        @SerializedName("value")
        @NotNull
        private final String value;

        public OfferFilterInfoRequest(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(str2, "value");
            this.name = str;
            this.value = str2;
        }

        public static /* synthetic */ OfferFilterInfoRequest copy$default(OfferFilterInfoRequest offerFilterInfoRequest, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = offerFilterInfoRequest.name;
            }
            if ((i & 2) != 0) {
                str2 = offerFilterInfoRequest.value;
            }
            return offerFilterInfoRequest.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        @NotNull
        public final String component2() {
            return this.value;
        }

        @NotNull
        public final OfferFilterInfoRequest copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(str2, "value");
            return new OfferFilterInfoRequest(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OfferFilterInfoRequest)) {
                return false;
            }
            OfferFilterInfoRequest offerFilterInfoRequest = (OfferFilterInfoRequest) obj;
            return Intrinsics.areEqual(this.name, offerFilterInfoRequest.name) && Intrinsics.areEqual(this.value, offerFilterInfoRequest.value);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            String str = this.name;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.value;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("OfferFilterInfoRequest(name=");
            L.append(this.name);
            L.append(", value=");
            return a.t(L, this.value, ")");
        }
    }

    public OfferFilterRequest(@NotNull List<OfferFilterInfoRequest> list) {
        Intrinsics.checkParameterIsNotNull(list, "items");
        this.items = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.offer.entity.request.OfferFilterRequest */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferFilterRequest copy$default(OfferFilterRequest offerFilterRequest, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = offerFilterRequest.items;
        }
        return offerFilterRequest.copy(list);
    }

    @NotNull
    public final List<OfferFilterInfoRequest> component1() {
        return this.items;
    }

    @NotNull
    public final OfferFilterRequest copy(@NotNull List<OfferFilterInfoRequest> list) {
        Intrinsics.checkParameterIsNotNull(list, "items");
        return new OfferFilterRequest(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof OfferFilterRequest) && Intrinsics.areEqual(this.items, ((OfferFilterRequest) obj).items);
        }
        return true;
    }

    @NotNull
    public final List<OfferFilterInfoRequest> getItems() {
        return this.items;
    }

    public int hashCode() {
        List<OfferFilterInfoRequest> list = this.items;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.w(a.L("OfferFilterRequest(items="), this.items, ")");
    }
}
