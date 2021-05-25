package ru.sravni.android.bankproduct.domain.offer.osago.entity.list;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDisplaySettingsDomain;", "", "", "component1", "()I", "component2", "", "component3", "()Ljava/lang/String;", "component4", "backgroundColor", "fontColor", "titleIcon", AnalyticFieldsName.productName, "copy", "(IILjava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDisplaySettingsDomain;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getTitleIcon", AuthSource.SEND_ABUSE, "I", "getBackgroundColor", AuthSource.BOOKING_ORDER, "getFontColor", "d", "getProductName", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoDisplaySettingsDomain {
    public final int a;
    public final int b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;

    public OfferOsagoDisplaySettingsDomain(int i, int i2, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "titleIcon");
        Intrinsics.checkParameterIsNotNull(str2, AnalyticFieldsName.productName);
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
    }

    public static /* synthetic */ OfferOsagoDisplaySettingsDomain copy$default(OfferOsagoDisplaySettingsDomain offerOsagoDisplaySettingsDomain, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = offerOsagoDisplaySettingsDomain.a;
        }
        if ((i3 & 2) != 0) {
            i2 = offerOsagoDisplaySettingsDomain.b;
        }
        if ((i3 & 4) != 0) {
            str = offerOsagoDisplaySettingsDomain.c;
        }
        if ((i3 & 8) != 0) {
            str2 = offerOsagoDisplaySettingsDomain.d;
        }
        return offerOsagoDisplaySettingsDomain.copy(i, i2, str, str2);
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
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
    public final OfferOsagoDisplaySettingsDomain copy(int i, int i2, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "titleIcon");
        Intrinsics.checkParameterIsNotNull(str2, AnalyticFieldsName.productName);
        return new OfferOsagoDisplaySettingsDomain(i, i2, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferOsagoDisplaySettingsDomain)) {
            return false;
        }
        OfferOsagoDisplaySettingsDomain offerOsagoDisplaySettingsDomain = (OfferOsagoDisplaySettingsDomain) obj;
        return this.a == offerOsagoDisplaySettingsDomain.a && this.b == offerOsagoDisplaySettingsDomain.b && Intrinsics.areEqual(this.c, offerOsagoDisplaySettingsDomain.c) && Intrinsics.areEqual(this.d, offerOsagoDisplaySettingsDomain.d);
    }

    public final int getBackgroundColor() {
        return this.a;
    }

    public final int getFontColor() {
        return this.b;
    }

    @NotNull
    public final String getProductName() {
        return this.d;
    }

    @NotNull
    public final String getTitleIcon() {
        return this.c;
    }

    public int hashCode() {
        int i = ((this.a * 31) + this.b) * 31;
        String str = this.c;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferOsagoDisplaySettingsDomain(backgroundColor=");
        L.append(this.a);
        L.append(", fontColor=");
        L.append(this.b);
        L.append(", titleIcon=");
        L.append(this.c);
        L.append(", productName=");
        return a.t(L, this.d, ")");
    }
}
