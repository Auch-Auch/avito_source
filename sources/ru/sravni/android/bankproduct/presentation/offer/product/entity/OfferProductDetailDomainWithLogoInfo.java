package ru.sravni.android.bankproduct.presentation.offer.product.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductItemDomain;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductDetailDomainWithLogoInfo;", "", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductItemDomain;", "component1", "()Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductItemDomain;", "Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;", "component2", "()Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;", "offerProductItemDomain", "logoInfo", "copy", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductItemDomain;Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;)Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductDetailDomainWithLogoInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;", "getLogoInfo", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductItemDomain;", "getOfferProductItemDomain", "<init>", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductItemDomain;Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductDetailDomainWithLogoInfo {
    @NotNull
    public final OfferProductItemDomain a;
    @NotNull
    public final LogoInfo b;

    public OfferProductDetailDomainWithLogoInfo(@NotNull OfferProductItemDomain offerProductItemDomain, @NotNull LogoInfo logoInfo) {
        Intrinsics.checkParameterIsNotNull(offerProductItemDomain, "offerProductItemDomain");
        Intrinsics.checkParameterIsNotNull(logoInfo, "logoInfo");
        this.a = offerProductItemDomain;
        this.b = logoInfo;
    }

    public static /* synthetic */ OfferProductDetailDomainWithLogoInfo copy$default(OfferProductDetailDomainWithLogoInfo offerProductDetailDomainWithLogoInfo, OfferProductItemDomain offerProductItemDomain, LogoInfo logoInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            offerProductItemDomain = offerProductDetailDomainWithLogoInfo.a;
        }
        if ((i & 2) != 0) {
            logoInfo = offerProductDetailDomainWithLogoInfo.b;
        }
        return offerProductDetailDomainWithLogoInfo.copy(offerProductItemDomain, logoInfo);
    }

    @NotNull
    public final OfferProductItemDomain component1() {
        return this.a;
    }

    @NotNull
    public final LogoInfo component2() {
        return this.b;
    }

    @NotNull
    public final OfferProductDetailDomainWithLogoInfo copy(@NotNull OfferProductItemDomain offerProductItemDomain, @NotNull LogoInfo logoInfo) {
        Intrinsics.checkParameterIsNotNull(offerProductItemDomain, "offerProductItemDomain");
        Intrinsics.checkParameterIsNotNull(logoInfo, "logoInfo");
        return new OfferProductDetailDomainWithLogoInfo(offerProductItemDomain, logoInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductDetailDomainWithLogoInfo)) {
            return false;
        }
        OfferProductDetailDomainWithLogoInfo offerProductDetailDomainWithLogoInfo = (OfferProductDetailDomainWithLogoInfo) obj;
        return Intrinsics.areEqual(this.a, offerProductDetailDomainWithLogoInfo.a) && Intrinsics.areEqual(this.b, offerProductDetailDomainWithLogoInfo.b);
    }

    @NotNull
    public final LogoInfo getLogoInfo() {
        return this.b;
    }

    @NotNull
    public final OfferProductItemDomain getOfferProductItemDomain() {
        return this.a;
    }

    public int hashCode() {
        OfferProductItemDomain offerProductItemDomain = this.a;
        int i = 0;
        int hashCode = (offerProductItemDomain != null ? offerProductItemDomain.hashCode() : 0) * 31;
        LogoInfo logoInfo = this.b;
        if (logoInfo != null) {
            i = logoInfo.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductDetailDomainWithLogoInfo(offerProductItemDomain=");
        L.append(this.a);
        L.append(", logoInfo=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
