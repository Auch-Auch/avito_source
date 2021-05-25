package ru.sravni.android.bankproduct.domain.offer.product.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001:\u00010B?\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJT\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\u0007R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u000eR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0004¨\u00061"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;", "", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;", "component1", "()Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain$OfferStatusElementDomain;", "component6", "()Ljava/util/List;", "displaySettings", "productId", "orderID", "bankId", "savedSearchID", "offerStatusElementDomainList", "copy", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/lang/String;", "getSavedSearchID", "c", "getOrderID", AuthSource.BOOKING_ORDER, "getProductId", "d", "getBankId", "f", "Ljava/util/List;", "getOfferStatusElementDomainList", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;", "getDisplaySettings", "<init>", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "OfferStatusElementDomain", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductStatusDomain {
    @NotNull
    public final OfferProductDisplaySettingsDomain a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final List<OfferStatusElementDomain> f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain$OfferStatusElementDomain;", "", "", "component1", "()Ljava/lang/String;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;", "component2", "()Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;", "component3", "elementType", "status", "text", "copy", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain$OfferStatusElementDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getText", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;", "getStatus", AuthSource.SEND_ABUSE, "getElementType", "<init>", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class OfferStatusElementDomain {
        @NotNull
        public final String a;
        @Nullable
        public final ProductStatusEnum b;
        @NotNull
        public final String c;

        public OfferStatusElementDomain(@NotNull String str, @Nullable ProductStatusEnum productStatusEnum, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "elementType");
            Intrinsics.checkParameterIsNotNull(str2, "text");
            this.a = str;
            this.b = productStatusEnum;
            this.c = str2;
        }

        public static /* synthetic */ OfferStatusElementDomain copy$default(OfferStatusElementDomain offerStatusElementDomain, String str, ProductStatusEnum productStatusEnum, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = offerStatusElementDomain.a;
            }
            if ((i & 2) != 0) {
                productStatusEnum = offerStatusElementDomain.b;
            }
            if ((i & 4) != 0) {
                str2 = offerStatusElementDomain.c;
            }
            return offerStatusElementDomain.copy(str, productStatusEnum, str2);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final ProductStatusEnum component2() {
            return this.b;
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final OfferStatusElementDomain copy(@NotNull String str, @Nullable ProductStatusEnum productStatusEnum, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "elementType");
            Intrinsics.checkParameterIsNotNull(str2, "text");
            return new OfferStatusElementDomain(str, productStatusEnum, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OfferStatusElementDomain)) {
                return false;
            }
            OfferStatusElementDomain offerStatusElementDomain = (OfferStatusElementDomain) obj;
            return Intrinsics.areEqual(this.a, offerStatusElementDomain.a) && Intrinsics.areEqual(this.b, offerStatusElementDomain.b) && Intrinsics.areEqual(this.c, offerStatusElementDomain.c);
        }

        @NotNull
        public final String getElementType() {
            return this.a;
        }

        @Nullable
        public final ProductStatusEnum getStatus() {
            return this.b;
        }

        @NotNull
        public final String getText() {
            return this.c;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            ProductStatusEnum productStatusEnum = this.b;
            int hashCode2 = (hashCode + (productStatusEnum != null ? productStatusEnum.hashCode() : 0)) * 31;
            String str2 = this.c;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("OfferStatusElementDomain(elementType=");
            L.append(this.a);
            L.append(", status=");
            L.append(this.b);
            L.append(", text=");
            return a.t(L, this.c, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ OfferStatusElementDomain(String str, ProductStatusEnum productStatusEnum, String str2, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : productStatusEnum, str2);
        }
    }

    public OfferProductStatusDomain(@NotNull OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain, @NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull String str4, @NotNull List<OfferStatusElementDomain> list) {
        Intrinsics.checkParameterIsNotNull(offerProductDisplaySettingsDomain, "displaySettings");
        Intrinsics.checkParameterIsNotNull(str, "productId");
        Intrinsics.checkParameterIsNotNull(str3, "bankId");
        Intrinsics.checkParameterIsNotNull(str4, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "offerStatusElementDomainList");
        this.a = offerProductDisplaySettingsDomain;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusDomain */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferProductStatusDomain copy$default(OfferProductStatusDomain offerProductStatusDomain, OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain, String str, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            offerProductDisplaySettingsDomain = offerProductStatusDomain.a;
        }
        if ((i & 2) != 0) {
            str = offerProductStatusDomain.b;
        }
        if ((i & 4) != 0) {
            str2 = offerProductStatusDomain.c;
        }
        if ((i & 8) != 0) {
            str3 = offerProductStatusDomain.d;
        }
        if ((i & 16) != 0) {
            str4 = offerProductStatusDomain.e;
        }
        if ((i & 32) != 0) {
            list = offerProductStatusDomain.f;
        }
        return offerProductStatusDomain.copy(offerProductDisplaySettingsDomain, str, str2, str3, str4, list);
    }

    @NotNull
    public final OfferProductDisplaySettingsDomain component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final List<OfferStatusElementDomain> component6() {
        return this.f;
    }

    @NotNull
    public final OfferProductStatusDomain copy(@NotNull OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain, @NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull String str4, @NotNull List<OfferStatusElementDomain> list) {
        Intrinsics.checkParameterIsNotNull(offerProductDisplaySettingsDomain, "displaySettings");
        Intrinsics.checkParameterIsNotNull(str, "productId");
        Intrinsics.checkParameterIsNotNull(str3, "bankId");
        Intrinsics.checkParameterIsNotNull(str4, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "offerStatusElementDomainList");
        return new OfferProductStatusDomain(offerProductDisplaySettingsDomain, str, str2, str3, str4, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductStatusDomain)) {
            return false;
        }
        OfferProductStatusDomain offerProductStatusDomain = (OfferProductStatusDomain) obj;
        return Intrinsics.areEqual(this.a, offerProductStatusDomain.a) && Intrinsics.areEqual(this.b, offerProductStatusDomain.b) && Intrinsics.areEqual(this.c, offerProductStatusDomain.c) && Intrinsics.areEqual(this.d, offerProductStatusDomain.d) && Intrinsics.areEqual(this.e, offerProductStatusDomain.e) && Intrinsics.areEqual(this.f, offerProductStatusDomain.f);
    }

    @NotNull
    public final String getBankId() {
        return this.d;
    }

    @NotNull
    public final OfferProductDisplaySettingsDomain getDisplaySettings() {
        return this.a;
    }

    @NotNull
    public final List<OfferStatusElementDomain> getOfferStatusElementDomainList() {
        return this.f;
    }

    @Nullable
    public final String getOrderID() {
        return this.c;
    }

    @NotNull
    public final String getProductId() {
        return this.b;
    }

    @NotNull
    public final String getSavedSearchID() {
        return this.e;
    }

    public int hashCode() {
        OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain = this.a;
        int i = 0;
        int hashCode = (offerProductDisplaySettingsDomain != null ? offerProductDisplaySettingsDomain.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<OfferStatusElementDomain> list = this.f;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductStatusDomain(displaySettings=");
        L.append(this.a);
        L.append(", productId=");
        L.append(this.b);
        L.append(", orderID=");
        L.append(this.c);
        L.append(", bankId=");
        L.append(this.d);
        L.append(", savedSearchID=");
        L.append(this.e);
        L.append(", offerStatusElementDomainList=");
        return a.w(L, this.f, ")");
    }
}
