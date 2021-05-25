package ru.sravni.android.bankproduct.network.offer.osago.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoDisplaySettingsRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001c\u0010\f\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001c\u0010\u0007R\u001c\u0010\r\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoDisplaySettingsResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoDisplaySettingsRepo;", "toOfferOsagoDisplaySettingsRepo", "()Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoDisplaySettingsRepo;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "backgroundColor", "fontColor", "iconTitle", AnalyticFieldsName.productName, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/offer/osago/response/OfferOsagoDisplaySettingsResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBackgroundColor", "getFontColor", "getProductName", "getIconTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoDisplaySettingsResponse {
    @SerializedName("backgroundColor")
    @NotNull
    private final String backgroundColor;
    @SerializedName("fontColor")
    @NotNull
    private final String fontColor;
    @SerializedName("iconTitle")
    @NotNull
    private final String iconTitle;
    @SerializedName(AnalyticFieldsName.productName)
    @NotNull
    private final String productName;

    public OfferOsagoDisplaySettingsResponse(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "backgroundColor");
        Intrinsics.checkParameterIsNotNull(str2, "fontColor");
        Intrinsics.checkParameterIsNotNull(str3, "iconTitle");
        Intrinsics.checkParameterIsNotNull(str4, AnalyticFieldsName.productName);
        this.backgroundColor = str;
        this.fontColor = str2;
        this.iconTitle = str3;
        this.productName = str4;
    }

    public static /* synthetic */ OfferOsagoDisplaySettingsResponse copy$default(OfferOsagoDisplaySettingsResponse offerOsagoDisplaySettingsResponse, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offerOsagoDisplaySettingsResponse.backgroundColor;
        }
        if ((i & 2) != 0) {
            str2 = offerOsagoDisplaySettingsResponse.fontColor;
        }
        if ((i & 4) != 0) {
            str3 = offerOsagoDisplaySettingsResponse.iconTitle;
        }
        if ((i & 8) != 0) {
            str4 = offerOsagoDisplaySettingsResponse.productName;
        }
        return offerOsagoDisplaySettingsResponse.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.backgroundColor;
    }

    @NotNull
    public final String component2() {
        return this.fontColor;
    }

    @NotNull
    public final String component3() {
        return this.iconTitle;
    }

    @NotNull
    public final String component4() {
        return this.productName;
    }

    @NotNull
    public final OfferOsagoDisplaySettingsResponse copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "backgroundColor");
        Intrinsics.checkParameterIsNotNull(str2, "fontColor");
        Intrinsics.checkParameterIsNotNull(str3, "iconTitle");
        Intrinsics.checkParameterIsNotNull(str4, AnalyticFieldsName.productName);
        return new OfferOsagoDisplaySettingsResponse(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferOsagoDisplaySettingsResponse)) {
            return false;
        }
        OfferOsagoDisplaySettingsResponse offerOsagoDisplaySettingsResponse = (OfferOsagoDisplaySettingsResponse) obj;
        return Intrinsics.areEqual(this.backgroundColor, offerOsagoDisplaySettingsResponse.backgroundColor) && Intrinsics.areEqual(this.fontColor, offerOsagoDisplaySettingsResponse.fontColor) && Intrinsics.areEqual(this.iconTitle, offerOsagoDisplaySettingsResponse.iconTitle) && Intrinsics.areEqual(this.productName, offerOsagoDisplaySettingsResponse.productName);
    }

    @NotNull
    public final String getBackgroundColor() {
        return this.backgroundColor;
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
    public final String getProductName() {
        return this.productName;
    }

    public int hashCode() {
        String str = this.backgroundColor;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.fontColor;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.iconTitle;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.productName;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public final OfferOsagoDisplaySettingsRepo toOfferOsagoDisplaySettingsRepo() {
        return new OfferOsagoDisplaySettingsRepo(this.fontColor, this.backgroundColor, this.iconTitle, this.productName);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferOsagoDisplaySettingsResponse(backgroundColor=");
        L.append(this.backgroundColor);
        L.append(", fontColor=");
        L.append(this.fontColor);
        L.append(", iconTitle=");
        L.append(this.iconTitle);
        L.append(", productName=");
        return a.t(L, this.productName, ")");
    }
}
