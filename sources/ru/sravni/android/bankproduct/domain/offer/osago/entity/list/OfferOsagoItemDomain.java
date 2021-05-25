package ru.sravni.android.bankproduct.domain.offer.osago.entity.list;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemDomain;", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemEnum;", "component1", "()Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemEnum;", "", "component2", "()Ljava/lang/String;", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDetailDomain;", "component3", "()Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDetailDomain;", "offerOsagoItemEnum", "titleGroup", "offerDomain", "copy", "(Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemEnum;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDetailDomain;)Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDetailDomain;", "getOfferDomain", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitleGroup", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemEnum;", "getOfferOsagoItemEnum", "<init>", "(Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemEnum;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDetailDomain;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoItemDomain {
    @NotNull
    public final OfferOsagoItemEnum a;
    @Nullable
    public final String b;
    @Nullable
    public final OfferOsagoDetailDomain c;

    public OfferOsagoItemDomain(@NotNull OfferOsagoItemEnum offerOsagoItemEnum, @Nullable String str, @Nullable OfferOsagoDetailDomain offerOsagoDetailDomain) {
        Intrinsics.checkParameterIsNotNull(offerOsagoItemEnum, "offerOsagoItemEnum");
        this.a = offerOsagoItemEnum;
        this.b = str;
        this.c = offerOsagoDetailDomain;
    }

    public static /* synthetic */ OfferOsagoItemDomain copy$default(OfferOsagoItemDomain offerOsagoItemDomain, OfferOsagoItemEnum offerOsagoItemEnum, String str, OfferOsagoDetailDomain offerOsagoDetailDomain, int i, Object obj) {
        if ((i & 1) != 0) {
            offerOsagoItemEnum = offerOsagoItemDomain.a;
        }
        if ((i & 2) != 0) {
            str = offerOsagoItemDomain.b;
        }
        if ((i & 4) != 0) {
            offerOsagoDetailDomain = offerOsagoItemDomain.c;
        }
        return offerOsagoItemDomain.copy(offerOsagoItemEnum, str, offerOsagoDetailDomain);
    }

    @NotNull
    public final OfferOsagoItemEnum component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final OfferOsagoDetailDomain component3() {
        return this.c;
    }

    @NotNull
    public final OfferOsagoItemDomain copy(@NotNull OfferOsagoItemEnum offerOsagoItemEnum, @Nullable String str, @Nullable OfferOsagoDetailDomain offerOsagoDetailDomain) {
        Intrinsics.checkParameterIsNotNull(offerOsagoItemEnum, "offerOsagoItemEnum");
        return new OfferOsagoItemDomain(offerOsagoItemEnum, str, offerOsagoDetailDomain);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferOsagoItemDomain)) {
            return false;
        }
        OfferOsagoItemDomain offerOsagoItemDomain = (OfferOsagoItemDomain) obj;
        return Intrinsics.areEqual(this.a, offerOsagoItemDomain.a) && Intrinsics.areEqual(this.b, offerOsagoItemDomain.b) && Intrinsics.areEqual(this.c, offerOsagoItemDomain.c);
    }

    @Nullable
    public final OfferOsagoDetailDomain getOfferDomain() {
        return this.c;
    }

    @NotNull
    public final OfferOsagoItemEnum getOfferOsagoItemEnum() {
        return this.a;
    }

    @Nullable
    public final String getTitleGroup() {
        return this.b;
    }

    public int hashCode() {
        OfferOsagoItemEnum offerOsagoItemEnum = this.a;
        int i = 0;
        int hashCode = (offerOsagoItemEnum != null ? offerOsagoItemEnum.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        OfferOsagoDetailDomain offerOsagoDetailDomain = this.c;
        if (offerOsagoDetailDomain != null) {
            i = offerOsagoDetailDomain.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferOsagoItemDomain(offerOsagoItemEnum=");
        L.append(this.a);
        L.append(", titleGroup=");
        L.append(this.b);
        L.append(", offerDomain=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OfferOsagoItemDomain(OfferOsagoItemEnum offerOsagoItemEnum, String str, OfferOsagoDetailDomain offerOsagoDetailDomain, int i, j jVar) {
        this(offerOsagoItemEnum, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : offerOsagoDetailDomain);
    }
}
