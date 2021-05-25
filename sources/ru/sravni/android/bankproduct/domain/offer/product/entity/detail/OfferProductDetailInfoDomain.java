package ru.sravni.android.bankproduct.domain.offer.product.entity.detail;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductDisplaySettingsDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductStatusEnum;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ`\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0007J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010\nR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010!\u001a\u0004\b)\u0010\nR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010!\u001a\u0004\b+\u0010\nR\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0007R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\r¨\u00064"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailInfoDomain;", "", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;", "component1", "()Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;", "", "component2", "()I", "", "component3", "()Ljava/lang/String;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;", "component4", "()Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;", "component5", "component6", "component7", "displaySettings", "profitability", "profitabilityText", "status", "statusText", "url", "urlText", "copy", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;ILjava/lang/String;Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailInfoDomain;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "f", "Ljava/lang/String;", "getUrl", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;", "getDisplaySettings", "e", "getStatusText", "c", "getProfitabilityText", g.a, "getUrlText", AuthSource.BOOKING_ORDER, "I", "getProfitability", "d", "Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;", "getStatus", "<init>", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;ILjava/lang/String;Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductDetailInfoDomain {
    @NotNull
    public final OfferProductDisplaySettingsDomain a;
    public final int b;
    @Nullable
    public final String c;
    @Nullable
    public final ProductStatusEnum d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;

    public OfferProductDetailInfoDomain(@NotNull OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain, int i, @Nullable String str, @Nullable ProductStatusEnum productStatusEnum, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkParameterIsNotNull(offerProductDisplaySettingsDomain, "displaySettings");
        this.a = offerProductDisplaySettingsDomain;
        this.b = i;
        this.c = str;
        this.d = productStatusEnum;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    public static /* synthetic */ OfferProductDetailInfoDomain copy$default(OfferProductDetailInfoDomain offerProductDetailInfoDomain, OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain, int i, String str, ProductStatusEnum productStatusEnum, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            offerProductDisplaySettingsDomain = offerProductDetailInfoDomain.a;
        }
        if ((i2 & 2) != 0) {
            i = offerProductDetailInfoDomain.b;
        }
        if ((i2 & 4) != 0) {
            str = offerProductDetailInfoDomain.c;
        }
        if ((i2 & 8) != 0) {
            productStatusEnum = offerProductDetailInfoDomain.d;
        }
        if ((i2 & 16) != 0) {
            str2 = offerProductDetailInfoDomain.e;
        }
        if ((i2 & 32) != 0) {
            str3 = offerProductDetailInfoDomain.f;
        }
        if ((i2 & 64) != 0) {
            str4 = offerProductDetailInfoDomain.g;
        }
        return offerProductDetailInfoDomain.copy(offerProductDisplaySettingsDomain, i, str, productStatusEnum, str2, str3, str4);
    }

    @NotNull
    public final OfferProductDisplaySettingsDomain component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final ProductStatusEnum component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    @Nullable
    public final String component7() {
        return this.g;
    }

    @NotNull
    public final OfferProductDetailInfoDomain copy(@NotNull OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain, int i, @Nullable String str, @Nullable ProductStatusEnum productStatusEnum, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkParameterIsNotNull(offerProductDisplaySettingsDomain, "displaySettings");
        return new OfferProductDetailInfoDomain(offerProductDisplaySettingsDomain, i, str, productStatusEnum, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductDetailInfoDomain)) {
            return false;
        }
        OfferProductDetailInfoDomain offerProductDetailInfoDomain = (OfferProductDetailInfoDomain) obj;
        return Intrinsics.areEqual(this.a, offerProductDetailInfoDomain.a) && this.b == offerProductDetailInfoDomain.b && Intrinsics.areEqual(this.c, offerProductDetailInfoDomain.c) && Intrinsics.areEqual(this.d, offerProductDetailInfoDomain.d) && Intrinsics.areEqual(this.e, offerProductDetailInfoDomain.e) && Intrinsics.areEqual(this.f, offerProductDetailInfoDomain.f) && Intrinsics.areEqual(this.g, offerProductDetailInfoDomain.g);
    }

    @NotNull
    public final OfferProductDisplaySettingsDomain getDisplaySettings() {
        return this.a;
    }

    public final int getProfitability() {
        return this.b;
    }

    @Nullable
    public final String getProfitabilityText() {
        return this.c;
    }

    @Nullable
    public final ProductStatusEnum getStatus() {
        return this.d;
    }

    @Nullable
    public final String getStatusText() {
        return this.e;
    }

    @Nullable
    public final String getUrl() {
        return this.f;
    }

    @Nullable
    public final String getUrlText() {
        return this.g;
    }

    public int hashCode() {
        OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain = this.a;
        int i = 0;
        int hashCode = (((offerProductDisplaySettingsDomain != null ? offerProductDisplaySettingsDomain.hashCode() : 0) * 31) + this.b) * 31;
        String str = this.c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        ProductStatusEnum productStatusEnum = this.d;
        int hashCode3 = (hashCode2 + (productStatusEnum != null ? productStatusEnum.hashCode() : 0)) * 31;
        String str2 = this.e;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.g;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductDetailInfoDomain(displaySettings=");
        L.append(this.a);
        L.append(", profitability=");
        L.append(this.b);
        L.append(", profitabilityText=");
        L.append(this.c);
        L.append(", status=");
        L.append(this.d);
        L.append(", statusText=");
        L.append(this.e);
        L.append(", url=");
        L.append(this.f);
        L.append(", urlText=");
        return a.t(L, this.g, ")");
    }
}
