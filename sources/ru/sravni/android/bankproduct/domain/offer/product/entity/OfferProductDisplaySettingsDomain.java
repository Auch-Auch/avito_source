package ru.sravni.android.bankproduct.domain.offer.product.entity;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u001d\b\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u000f\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000bJx\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010\u000bJ\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0004J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u000bR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010-\u001a\u0004\b0\u0010\u000bR\u0019\u0010\u0018\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010-\u001a\u0004\b2\u0010\u000bR\u0019\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0011R\u0019\u0010\u0017\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010-\u001a\u0004\b7\u0010\u000bR\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010*\u001a\u0004\b9\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010-\u001a\u0004\b;\u0010\u000bR\u0019\u0010\u001c\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010-\u001a\u0004\b=\u0010\u000b¨\u0006@"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;", "", "", "component1", "()I", "Lru/sravni/android/bankproduct/domain/offer/product/entity/CardTypeEnum;", "component2", "()Lru/sravni/android/bankproduct/domain/offer/product/entity/CardTypeEnum;", "component3", "", "component4", "()Ljava/lang/String;", "component5", "component6", "component7", "Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductTypeEnum;", "component8", "()Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductTypeEnum;", "component9", "component10", "backgroundColor", "cardType", "fontColor", "titleIcon", AnalyticFieldsName.productName, "offerTitle", "detailTitle", "productType", "bankName", "bankLogoUrlSVG", "copy", "(ILru/sravni/android/bankproduct/domain/offer/product/entity/CardTypeEnum;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductTypeEnum;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/offer/product/entity/CardTypeEnum;", "getCardType", AuthSource.SEND_ABUSE, "I", "getBackgroundColor", g.a, "Ljava/lang/String;", "getDetailTitle", "j", "getBankLogoUrlSVG", "e", "getProductName", "h", "Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductTypeEnum;", "getProductType", "d", "getTitleIcon", "c", "getFontColor", "f", "getOfferTitle", "i", "getBankName", "<init>", "(ILru/sravni/android/bankproduct/domain/offer/product/entity/CardTypeEnum;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductTypeEnum;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductDisplaySettingsDomain {
    public final int a;
    @Nullable
    public final CardTypeEnum b;
    public final int c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    @NotNull
    public final String g;
    @NotNull
    public final ProductTypeEnum h;
    @NotNull
    public final String i;
    @Nullable
    public final String j;

    public OfferProductDisplaySettingsDomain(int i2, @Nullable CardTypeEnum cardTypeEnum, int i3, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull ProductTypeEnum productTypeEnum, @NotNull String str5, @Nullable String str6) {
        Intrinsics.checkParameterIsNotNull(str, "titleIcon");
        Intrinsics.checkParameterIsNotNull(str2, AnalyticFieldsName.productName);
        Intrinsics.checkParameterIsNotNull(str3, "offerTitle");
        Intrinsics.checkParameterIsNotNull(str4, "detailTitle");
        Intrinsics.checkParameterIsNotNull(productTypeEnum, "productType");
        Intrinsics.checkParameterIsNotNull(str5, "bankName");
        this.a = i2;
        this.b = cardTypeEnum;
        this.c = i3;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = productTypeEnum;
        this.i = str5;
        this.j = str6;
    }

    public static /* synthetic */ OfferProductDisplaySettingsDomain copy$default(OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain, int i2, CardTypeEnum cardTypeEnum, int i3, String str, String str2, String str3, String str4, ProductTypeEnum productTypeEnum, String str5, String str6, int i4, Object obj) {
        return offerProductDisplaySettingsDomain.copy((i4 & 1) != 0 ? offerProductDisplaySettingsDomain.a : i2, (i4 & 2) != 0 ? offerProductDisplaySettingsDomain.b : cardTypeEnum, (i4 & 4) != 0 ? offerProductDisplaySettingsDomain.c : i3, (i4 & 8) != 0 ? offerProductDisplaySettingsDomain.d : str, (i4 & 16) != 0 ? offerProductDisplaySettingsDomain.e : str2, (i4 & 32) != 0 ? offerProductDisplaySettingsDomain.f : str3, (i4 & 64) != 0 ? offerProductDisplaySettingsDomain.g : str4, (i4 & 128) != 0 ? offerProductDisplaySettingsDomain.h : productTypeEnum, (i4 & 256) != 0 ? offerProductDisplaySettingsDomain.i : str5, (i4 & 512) != 0 ? offerProductDisplaySettingsDomain.j : str6);
    }

    public final int component1() {
        return this.a;
    }

    @Nullable
    public final String component10() {
        return this.j;
    }

    @Nullable
    public final CardTypeEnum component2() {
        return this.b;
    }

    public final int component3() {
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
    public final ProductTypeEnum component8() {
        return this.h;
    }

    @NotNull
    public final String component9() {
        return this.i;
    }

    @NotNull
    public final OfferProductDisplaySettingsDomain copy(int i2, @Nullable CardTypeEnum cardTypeEnum, int i3, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull ProductTypeEnum productTypeEnum, @NotNull String str5, @Nullable String str6) {
        Intrinsics.checkParameterIsNotNull(str, "titleIcon");
        Intrinsics.checkParameterIsNotNull(str2, AnalyticFieldsName.productName);
        Intrinsics.checkParameterIsNotNull(str3, "offerTitle");
        Intrinsics.checkParameterIsNotNull(str4, "detailTitle");
        Intrinsics.checkParameterIsNotNull(productTypeEnum, "productType");
        Intrinsics.checkParameterIsNotNull(str5, "bankName");
        return new OfferProductDisplaySettingsDomain(i2, cardTypeEnum, i3, str, str2, str3, str4, productTypeEnum, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductDisplaySettingsDomain)) {
            return false;
        }
        OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain = (OfferProductDisplaySettingsDomain) obj;
        return this.a == offerProductDisplaySettingsDomain.a && Intrinsics.areEqual(this.b, offerProductDisplaySettingsDomain.b) && this.c == offerProductDisplaySettingsDomain.c && Intrinsics.areEqual(this.d, offerProductDisplaySettingsDomain.d) && Intrinsics.areEqual(this.e, offerProductDisplaySettingsDomain.e) && Intrinsics.areEqual(this.f, offerProductDisplaySettingsDomain.f) && Intrinsics.areEqual(this.g, offerProductDisplaySettingsDomain.g) && Intrinsics.areEqual(this.h, offerProductDisplaySettingsDomain.h) && Intrinsics.areEqual(this.i, offerProductDisplaySettingsDomain.i) && Intrinsics.areEqual(this.j, offerProductDisplaySettingsDomain.j);
    }

    public final int getBackgroundColor() {
        return this.a;
    }

    @Nullable
    public final String getBankLogoUrlSVG() {
        return this.j;
    }

    @NotNull
    public final String getBankName() {
        return this.i;
    }

    @Nullable
    public final CardTypeEnum getCardType() {
        return this.b;
    }

    @NotNull
    public final String getDetailTitle() {
        return this.g;
    }

    public final int getFontColor() {
        return this.c;
    }

    @NotNull
    public final String getOfferTitle() {
        return this.f;
    }

    @NotNull
    public final String getProductName() {
        return this.e;
    }

    @NotNull
    public final ProductTypeEnum getProductType() {
        return this.h;
    }

    @NotNull
    public final String getTitleIcon() {
        return this.d;
    }

    public int hashCode() {
        int i2 = this.a * 31;
        CardTypeEnum cardTypeEnum = this.b;
        int i3 = 0;
        int hashCode = (((i2 + (cardTypeEnum != null ? cardTypeEnum.hashCode() : 0)) * 31) + this.c) * 31;
        String str = this.d;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.e;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.g;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        ProductTypeEnum productTypeEnum = this.h;
        int hashCode6 = (hashCode5 + (productTypeEnum != null ? productTypeEnum.hashCode() : 0)) * 31;
        String str5 = this.i;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.j;
        if (str6 != null) {
            i3 = str6.hashCode();
        }
        return hashCode7 + i3;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductDisplaySettingsDomain(backgroundColor=");
        L.append(this.a);
        L.append(", cardType=");
        L.append(this.b);
        L.append(", fontColor=");
        L.append(this.c);
        L.append(", titleIcon=");
        L.append(this.d);
        L.append(", productName=");
        L.append(this.e);
        L.append(", offerTitle=");
        L.append(this.f);
        L.append(", detailTitle=");
        L.append(this.g);
        L.append(", productType=");
        L.append(this.h);
        L.append(", bankName=");
        L.append(this.i);
        L.append(", bankLogoUrlSVG=");
        return a.t(L, this.j, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OfferProductDisplaySettingsDomain(int i2, CardTypeEnum cardTypeEnum, int i3, String str, String str2, String str3, String str4, ProductTypeEnum productTypeEnum, String str5, String str6, int i4, j jVar) {
        this(i2, cardTypeEnum, i3, str, str2, str3, str4, productTypeEnum, str5, (i4 & 512) != 0 ? null : str6);
    }
}
