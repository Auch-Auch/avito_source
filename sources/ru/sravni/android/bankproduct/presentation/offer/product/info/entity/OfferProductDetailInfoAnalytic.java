package ru.sravni.android.bankproduct.presentation.offer.product.info.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoAnalytic;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "savedSearchID", AnalyticFieldsName.productName, AnalyticFieldsName.organizationName, AnalyticFieldsName.offerName, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoAnalytic;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getOfferName", AuthSource.SEND_ABUSE, "getSavedSearchID", "c", "getOrganizationName", AuthSource.BOOKING_ORDER, "getProductName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductDetailInfoAnalytic {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;

    public OfferProductDetailInfoAnalytic(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(str2, AnalyticFieldsName.productName);
        Intrinsics.checkParameterIsNotNull(str3, AnalyticFieldsName.organizationName);
        Intrinsics.checkParameterIsNotNull(str4, AnalyticFieldsName.offerName);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public static /* synthetic */ OfferProductDetailInfoAnalytic copy$default(OfferProductDetailInfoAnalytic offerProductDetailInfoAnalytic, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offerProductDetailInfoAnalytic.a;
        }
        if ((i & 2) != 0) {
            str2 = offerProductDetailInfoAnalytic.b;
        }
        if ((i & 4) != 0) {
            str3 = offerProductDetailInfoAnalytic.c;
        }
        if ((i & 8) != 0) {
            str4 = offerProductDetailInfoAnalytic.d;
        }
        return offerProductDetailInfoAnalytic.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final OfferProductDetailInfoAnalytic copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(str2, AnalyticFieldsName.productName);
        Intrinsics.checkParameterIsNotNull(str3, AnalyticFieldsName.organizationName);
        Intrinsics.checkParameterIsNotNull(str4, AnalyticFieldsName.offerName);
        return new OfferProductDetailInfoAnalytic(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductDetailInfoAnalytic)) {
            return false;
        }
        OfferProductDetailInfoAnalytic offerProductDetailInfoAnalytic = (OfferProductDetailInfoAnalytic) obj;
        return Intrinsics.areEqual(this.a, offerProductDetailInfoAnalytic.a) && Intrinsics.areEqual(this.b, offerProductDetailInfoAnalytic.b) && Intrinsics.areEqual(this.c, offerProductDetailInfoAnalytic.c) && Intrinsics.areEqual(this.d, offerProductDetailInfoAnalytic.d);
    }

    @NotNull
    public final String getOfferName() {
        return this.d;
    }

    @NotNull
    public final String getOrganizationName() {
        return this.c;
    }

    @NotNull
    public final String getProductName() {
        return this.b;
    }

    @NotNull
    public final String getSavedSearchID() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductDetailInfoAnalytic(savedSearchID=");
        L.append(this.a);
        L.append(", productName=");
        L.append(this.b);
        L.append(", organizationName=");
        L.append(this.c);
        L.append(", offerName=");
        return a.t(L, this.d, ")");
    }
}
