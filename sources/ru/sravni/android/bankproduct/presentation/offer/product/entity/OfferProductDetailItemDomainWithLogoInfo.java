package ru.sravni.android.bankproduct.presentation.offer.product.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductDetailItemDomainWithLogoInfo;", "", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailItemDomain;", "component1", "()Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailItemDomain;", "Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;", "component2", "()Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;", "offerProductDetailInfoDomain", "logoInfo", "copy", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailItemDomain;Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;)Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductDetailItemDomainWithLogoInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailItemDomain;", "getOfferProductDetailInfoDomain", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;", "getLogoInfo", "<init>", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailItemDomain;Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductDetailItemDomainWithLogoInfo {
    @NotNull
    public final OfferProductDetailItemDomain a;
    @NotNull
    public final LogoInfo b;

    public OfferProductDetailItemDomainWithLogoInfo(@NotNull OfferProductDetailItemDomain offerProductDetailItemDomain, @NotNull LogoInfo logoInfo) {
        Intrinsics.checkParameterIsNotNull(offerProductDetailItemDomain, "offerProductDetailInfoDomain");
        Intrinsics.checkParameterIsNotNull(logoInfo, "logoInfo");
        this.a = offerProductDetailItemDomain;
        this.b = logoInfo;
    }

    public static /* synthetic */ OfferProductDetailItemDomainWithLogoInfo copy$default(OfferProductDetailItemDomainWithLogoInfo offerProductDetailItemDomainWithLogoInfo, OfferProductDetailItemDomain offerProductDetailItemDomain, LogoInfo logoInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            offerProductDetailItemDomain = offerProductDetailItemDomainWithLogoInfo.a;
        }
        if ((i & 2) != 0) {
            logoInfo = offerProductDetailItemDomainWithLogoInfo.b;
        }
        return offerProductDetailItemDomainWithLogoInfo.copy(offerProductDetailItemDomain, logoInfo);
    }

    @NotNull
    public final OfferProductDetailItemDomain component1() {
        return this.a;
    }

    @NotNull
    public final LogoInfo component2() {
        return this.b;
    }

    @NotNull
    public final OfferProductDetailItemDomainWithLogoInfo copy(@NotNull OfferProductDetailItemDomain offerProductDetailItemDomain, @NotNull LogoInfo logoInfo) {
        Intrinsics.checkParameterIsNotNull(offerProductDetailItemDomain, "offerProductDetailInfoDomain");
        Intrinsics.checkParameterIsNotNull(logoInfo, "logoInfo");
        return new OfferProductDetailItemDomainWithLogoInfo(offerProductDetailItemDomain, logoInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductDetailItemDomainWithLogoInfo)) {
            return false;
        }
        OfferProductDetailItemDomainWithLogoInfo offerProductDetailItemDomainWithLogoInfo = (OfferProductDetailItemDomainWithLogoInfo) obj;
        return Intrinsics.areEqual(this.a, offerProductDetailItemDomainWithLogoInfo.a) && Intrinsics.areEqual(this.b, offerProductDetailItemDomainWithLogoInfo.b);
    }

    @NotNull
    public final LogoInfo getLogoInfo() {
        return this.b;
    }

    @NotNull
    public final OfferProductDetailItemDomain getOfferProductDetailInfoDomain() {
        return this.a;
    }

    public int hashCode() {
        OfferProductDetailItemDomain offerProductDetailItemDomain = this.a;
        int i = 0;
        int hashCode = (offerProductDetailItemDomain != null ? offerProductDetailItemDomain.hashCode() : 0) * 31;
        LogoInfo logoInfo = this.b;
        if (logoInfo != null) {
            i = logoInfo.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductDetailItemDomainWithLogoInfo(offerProductDetailInfoDomain=");
        L.append(this.a);
        L.append(", logoInfo=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
