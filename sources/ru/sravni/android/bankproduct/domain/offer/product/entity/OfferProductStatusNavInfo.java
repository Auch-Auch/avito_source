package ru.sravni.android.bankproduct.domain.offer.product.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusNavInfo;", "", "", "component1", "()Ljava/lang/Integer;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;", "component2", "()Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;", "backDestinationId", "statusDomain", "copy", "(Ljava/lang/Integer;Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;)Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusNavInfo;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;", "getStatusDomain", AuthSource.SEND_ABUSE, "Ljava/lang/Integer;", "getBackDestinationId", "<init>", "(Ljava/lang/Integer;Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductStatusNavInfo {
    @Nullable
    public final Integer a;
    @NotNull
    public final OfferProductStatusDomain b;

    public OfferProductStatusNavInfo(@Nullable Integer num, @NotNull OfferProductStatusDomain offerProductStatusDomain) {
        Intrinsics.checkParameterIsNotNull(offerProductStatusDomain, "statusDomain");
        this.a = num;
        this.b = offerProductStatusDomain;
    }

    public static /* synthetic */ OfferProductStatusNavInfo copy$default(OfferProductStatusNavInfo offerProductStatusNavInfo, Integer num, OfferProductStatusDomain offerProductStatusDomain, int i, Object obj) {
        if ((i & 1) != 0) {
            num = offerProductStatusNavInfo.a;
        }
        if ((i & 2) != 0) {
            offerProductStatusDomain = offerProductStatusNavInfo.b;
        }
        return offerProductStatusNavInfo.copy(num, offerProductStatusDomain);
    }

    @Nullable
    public final Integer component1() {
        return this.a;
    }

    @NotNull
    public final OfferProductStatusDomain component2() {
        return this.b;
    }

    @NotNull
    public final OfferProductStatusNavInfo copy(@Nullable Integer num, @NotNull OfferProductStatusDomain offerProductStatusDomain) {
        Intrinsics.checkParameterIsNotNull(offerProductStatusDomain, "statusDomain");
        return new OfferProductStatusNavInfo(num, offerProductStatusDomain);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductStatusNavInfo)) {
            return false;
        }
        OfferProductStatusNavInfo offerProductStatusNavInfo = (OfferProductStatusNavInfo) obj;
        return Intrinsics.areEqual(this.a, offerProductStatusNavInfo.a) && Intrinsics.areEqual(this.b, offerProductStatusNavInfo.b);
    }

    @Nullable
    public final Integer getBackDestinationId() {
        return this.a;
    }

    @NotNull
    public final OfferProductStatusDomain getStatusDomain() {
        return this.b;
    }

    public int hashCode() {
        Integer num = this.a;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        OfferProductStatusDomain offerProductStatusDomain = this.b;
        if (offerProductStatusDomain != null) {
            i = offerProductStatusDomain.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductStatusNavInfo(backDestinationId=");
        L.append(this.a);
        L.append(", statusDomain=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OfferProductStatusNavInfo(Integer num, OfferProductStatusDomain offerProductStatusDomain, int i, j jVar) {
        this((i & 1) != 0 ? null : num, offerProductStatusDomain);
    }
}
