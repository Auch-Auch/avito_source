package ru.sravni.android.bankproduct.network.offer.product.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductDisplaySettingsRepo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b-\u0010.J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007Jn\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0010\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\u0007R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b%\u0010\u0007R\u001c\u0010\u0012\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b&\u0010\u0007R\u001c\u0010\u0015\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b'\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b(\u0010\u0007R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b)\u0010\u0007R\u001c\u0010\u0013\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b*\u0010\u0007R\u001c\u0010\u0016\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b+\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b,\u0010\u0007¨\u0006/"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDisplaySettingsResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;", "toOfferProductDisplaySettingsRepo", "()Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "backgroundColor", "cardType", "fontColor", "iconTitle", "offerTitle", "bankName", "detailTitle", AnalyticFieldsName.productName, "bankLogoUrlSVG", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/offer/product/response/OfferProductDisplaySettingsResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBackgroundColor", "getCardType", "getFontColor", "getBankName", "getOfferTitle", "getBankLogoUrlSVG", "getIconTitle", "getDetailTitle", "getProductName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductDisplaySettingsResponse {
    @SerializedName("backgroundColor")
    @NotNull
    private final String backgroundColor;
    @SerializedName("bankLogoUrlSVG")
    @Nullable
    private final String bankLogoUrlSVG;
    @SerializedName("bankName")
    @NotNull
    private final String bankName;
    @SerializedName("cardType")
    @Nullable
    private final String cardType;
    @SerializedName("detailTitle")
    @NotNull
    private final String detailTitle;
    @SerializedName("fontColor")
    @NotNull
    private final String fontColor;
    @SerializedName("iconTitle")
    @NotNull
    private final String iconTitle;
    @SerializedName("offerTitle")
    @NotNull
    private final String offerTitle;
    @SerializedName(AnalyticFieldsName.productName)
    @NotNull
    private final String productName;

    public OfferProductDisplaySettingsResponse(@NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @Nullable String str9) {
        Intrinsics.checkParameterIsNotNull(str, "backgroundColor");
        Intrinsics.checkParameterIsNotNull(str3, "fontColor");
        Intrinsics.checkParameterIsNotNull(str4, "iconTitle");
        Intrinsics.checkParameterIsNotNull(str5, "offerTitle");
        Intrinsics.checkParameterIsNotNull(str6, "bankName");
        Intrinsics.checkParameterIsNotNull(str7, "detailTitle");
        Intrinsics.checkParameterIsNotNull(str8, AnalyticFieldsName.productName);
        this.backgroundColor = str;
        this.cardType = str2;
        this.fontColor = str3;
        this.iconTitle = str4;
        this.offerTitle = str5;
        this.bankName = str6;
        this.detailTitle = str7;
        this.productName = str8;
        this.bankLogoUrlSVG = str9;
    }

    public static /* synthetic */ OfferProductDisplaySettingsResponse copy$default(OfferProductDisplaySettingsResponse offerProductDisplaySettingsResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        return offerProductDisplaySettingsResponse.copy((i & 1) != 0 ? offerProductDisplaySettingsResponse.backgroundColor : str, (i & 2) != 0 ? offerProductDisplaySettingsResponse.cardType : str2, (i & 4) != 0 ? offerProductDisplaySettingsResponse.fontColor : str3, (i & 8) != 0 ? offerProductDisplaySettingsResponse.iconTitle : str4, (i & 16) != 0 ? offerProductDisplaySettingsResponse.offerTitle : str5, (i & 32) != 0 ? offerProductDisplaySettingsResponse.bankName : str6, (i & 64) != 0 ? offerProductDisplaySettingsResponse.detailTitle : str7, (i & 128) != 0 ? offerProductDisplaySettingsResponse.productName : str8, (i & 256) != 0 ? offerProductDisplaySettingsResponse.bankLogoUrlSVG : str9);
    }

    @NotNull
    public final String component1() {
        return this.backgroundColor;
    }

    @Nullable
    public final String component2() {
        return this.cardType;
    }

    @NotNull
    public final String component3() {
        return this.fontColor;
    }

    @NotNull
    public final String component4() {
        return this.iconTitle;
    }

    @NotNull
    public final String component5() {
        return this.offerTitle;
    }

    @NotNull
    public final String component6() {
        return this.bankName;
    }

    @NotNull
    public final String component7() {
        return this.detailTitle;
    }

    @NotNull
    public final String component8() {
        return this.productName;
    }

    @Nullable
    public final String component9() {
        return this.bankLogoUrlSVG;
    }

    @NotNull
    public final OfferProductDisplaySettingsResponse copy(@NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @Nullable String str9) {
        Intrinsics.checkParameterIsNotNull(str, "backgroundColor");
        Intrinsics.checkParameterIsNotNull(str3, "fontColor");
        Intrinsics.checkParameterIsNotNull(str4, "iconTitle");
        Intrinsics.checkParameterIsNotNull(str5, "offerTitle");
        Intrinsics.checkParameterIsNotNull(str6, "bankName");
        Intrinsics.checkParameterIsNotNull(str7, "detailTitle");
        Intrinsics.checkParameterIsNotNull(str8, AnalyticFieldsName.productName);
        return new OfferProductDisplaySettingsResponse(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductDisplaySettingsResponse)) {
            return false;
        }
        OfferProductDisplaySettingsResponse offerProductDisplaySettingsResponse = (OfferProductDisplaySettingsResponse) obj;
        return Intrinsics.areEqual(this.backgroundColor, offerProductDisplaySettingsResponse.backgroundColor) && Intrinsics.areEqual(this.cardType, offerProductDisplaySettingsResponse.cardType) && Intrinsics.areEqual(this.fontColor, offerProductDisplaySettingsResponse.fontColor) && Intrinsics.areEqual(this.iconTitle, offerProductDisplaySettingsResponse.iconTitle) && Intrinsics.areEqual(this.offerTitle, offerProductDisplaySettingsResponse.offerTitle) && Intrinsics.areEqual(this.bankName, offerProductDisplaySettingsResponse.bankName) && Intrinsics.areEqual(this.detailTitle, offerProductDisplaySettingsResponse.detailTitle) && Intrinsics.areEqual(this.productName, offerProductDisplaySettingsResponse.productName) && Intrinsics.areEqual(this.bankLogoUrlSVG, offerProductDisplaySettingsResponse.bankLogoUrlSVG);
    }

    @NotNull
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final String getBankLogoUrlSVG() {
        return this.bankLogoUrlSVG;
    }

    @NotNull
    public final String getBankName() {
        return this.bankName;
    }

    @Nullable
    public final String getCardType() {
        return this.cardType;
    }

    @NotNull
    public final String getDetailTitle() {
        return this.detailTitle;
    }

    @NotNull
    public final String getFontColor() {
        return this.fontColor;
    }

    @NotNull
    public final String getIconTitle() {
        return this.iconTitle;
    }

    @NotNull
    public final String getOfferTitle() {
        return this.offerTitle;
    }

    @NotNull
    public final String getProductName() {
        return this.productName;
    }

    public int hashCode() {
        String str = this.backgroundColor;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cardType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.fontColor;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.iconTitle;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.offerTitle;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.bankName;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.detailTitle;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.productName;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.bankLogoUrlSVG;
        if (str9 != null) {
            i = str9.hashCode();
        }
        return hashCode8 + i;
    }

    @NotNull
    public final OfferProductDisplaySettingsRepo toOfferProductDisplaySettingsRepo() {
        String str = this.backgroundColor;
        String str2 = this.cardType;
        String str3 = this.fontColor;
        String str4 = this.iconTitle;
        return new OfferProductDisplaySettingsRepo(this.offerTitle, this.bankName, str3, str, str4, str2, this.productName, this.detailTitle, this.bankLogoUrlSVG);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductDisplaySettingsResponse(backgroundColor=");
        L.append(this.backgroundColor);
        L.append(", cardType=");
        L.append(this.cardType);
        L.append(", fontColor=");
        L.append(this.fontColor);
        L.append(", iconTitle=");
        L.append(this.iconTitle);
        L.append(", offerTitle=");
        L.append(this.offerTitle);
        L.append(", bankName=");
        L.append(this.bankName);
        L.append(", detailTitle=");
        L.append(this.detailTitle);
        L.append(", productName=");
        L.append(this.productName);
        L.append(", bankLogoUrlSVG=");
        return a.t(L, this.bankLogoUrlSVG, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OfferProductDisplaySettingsResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, j jVar) {
        this(str, str2, str3, str4, str5, str6, str7, str8, (i & 256) != 0 ? null : str9);
    }
}
