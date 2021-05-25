package ru.sravni.android.bankproduct.mock.webclient;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JV\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u0004¨\u0006-"}, d2 = {"Lru/sravni/android/bankproduct/mock/webclient/OfferProductWebClientStubInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "productListPath", "productMicroCreditListPath", "productStatusPath", "productCreditListPath", "productMfoListPath", "productCardListPath", "productCreditDetailPath", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/mock/webclient/OfferProductWebClientStubInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/lang/String;", "getProductMfoListPath", g.a, "getProductCreditDetailPath", "c", "getProductStatusPath", AuthSource.SEND_ABUSE, "getProductListPath", "d", "getProductCreditListPath", AuthSource.BOOKING_ORDER, "getProductMicroCreditListPath", "f", "getProductCardListPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductWebClientStubInfo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    @NotNull
    public final String g;

    public OfferProductWebClientStubInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public OfferProductWebClientStubInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkParameterIsNotNull(str, "productListPath");
        Intrinsics.checkParameterIsNotNull(str2, "productMicroCreditListPath");
        Intrinsics.checkParameterIsNotNull(str3, "productStatusPath");
        Intrinsics.checkParameterIsNotNull(str4, "productCreditListPath");
        Intrinsics.checkParameterIsNotNull(str5, "productMfoListPath");
        Intrinsics.checkParameterIsNotNull(str6, "productCardListPath");
        Intrinsics.checkParameterIsNotNull(str7, "productCreditDetailPath");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public static /* synthetic */ OfferProductWebClientStubInfo copy$default(OfferProductWebClientStubInfo offerProductWebClientStubInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offerProductWebClientStubInfo.a;
        }
        if ((i & 2) != 0) {
            str2 = offerProductWebClientStubInfo.b;
        }
        if ((i & 4) != 0) {
            str3 = offerProductWebClientStubInfo.c;
        }
        if ((i & 8) != 0) {
            str4 = offerProductWebClientStubInfo.d;
        }
        if ((i & 16) != 0) {
            str5 = offerProductWebClientStubInfo.e;
        }
        if ((i & 32) != 0) {
            str6 = offerProductWebClientStubInfo.f;
        }
        if ((i & 64) != 0) {
            str7 = offerProductWebClientStubInfo.g;
        }
        return offerProductWebClientStubInfo.copy(str, str2, str3, str4, str5, str6, str7);
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
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final String component7() {
        return this.g;
    }

    @NotNull
    public final OfferProductWebClientStubInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkParameterIsNotNull(str, "productListPath");
        Intrinsics.checkParameterIsNotNull(str2, "productMicroCreditListPath");
        Intrinsics.checkParameterIsNotNull(str3, "productStatusPath");
        Intrinsics.checkParameterIsNotNull(str4, "productCreditListPath");
        Intrinsics.checkParameterIsNotNull(str5, "productMfoListPath");
        Intrinsics.checkParameterIsNotNull(str6, "productCardListPath");
        Intrinsics.checkParameterIsNotNull(str7, "productCreditDetailPath");
        return new OfferProductWebClientStubInfo(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductWebClientStubInfo)) {
            return false;
        }
        OfferProductWebClientStubInfo offerProductWebClientStubInfo = (OfferProductWebClientStubInfo) obj;
        return Intrinsics.areEqual(this.a, offerProductWebClientStubInfo.a) && Intrinsics.areEqual(this.b, offerProductWebClientStubInfo.b) && Intrinsics.areEqual(this.c, offerProductWebClientStubInfo.c) && Intrinsics.areEqual(this.d, offerProductWebClientStubInfo.d) && Intrinsics.areEqual(this.e, offerProductWebClientStubInfo.e) && Intrinsics.areEqual(this.f, offerProductWebClientStubInfo.f) && Intrinsics.areEqual(this.g, offerProductWebClientStubInfo.g);
    }

    @NotNull
    public final String getProductCardListPath() {
        return this.f;
    }

    @NotNull
    public final String getProductCreditDetailPath() {
        return this.g;
    }

    @NotNull
    public final String getProductCreditListPath() {
        return this.d;
    }

    @NotNull
    public final String getProductListPath() {
        return this.a;
    }

    @NotNull
    public final String getProductMfoListPath() {
        return this.e;
    }

    @NotNull
    public final String getProductMicroCreditListPath() {
        return this.b;
    }

    @NotNull
    public final String getProductStatusPath() {
        return this.c;
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
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.g;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductWebClientStubInfo(productListPath=");
        L.append(this.a);
        L.append(", productMicroCreditListPath=");
        L.append(this.b);
        L.append(", productStatusPath=");
        L.append(this.c);
        L.append(", productCreditListPath=");
        L.append(this.d);
        L.append(", productMfoListPath=");
        L.append(this.e);
        L.append(", productCardListPath=");
        L.append(this.f);
        L.append(", productCreditDetailPath=");
        return a.t(L, this.g, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OfferProductWebClientStubInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, j jVar) {
        this((i & 1) != 0 ? "mock/product/ProductList.json" : str, (i & 2) != 0 ? "mock/product/ProductMicroCreditList.json" : str2, (i & 4) != 0 ? "mock/product/ProductStatus.json" : str3, (i & 8) != 0 ? "mock/product/v4/savedSearchItem/credit.json" : str4, (i & 16) != 0 ? "mock/product/v4/savedSearchItem/credit_mfo.json" : str5, (i & 32) != 0 ? "mock/product/v4/savedSearchItem/credit_card.json" : str6, (i & 64) != 0 ? "mock/product/v4/creditProduct/product.json" : str7);
    }
}
