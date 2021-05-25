package ru.sravni.android.bankproduct.domain.offer.osago.entity.list;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0001\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u0010\u0010\u001f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0007R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010\u0004R%\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0012R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b1\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\rR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010&\u001a\u0004\b6\u0010\u0004R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010&\u001a\u0004\b8\u0010\u0004R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010&\u001a\u0004\b:\u0010\u0004¨\u0006="}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoCompanyDetailDomain;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OsagoCompanyDetailEnum;", "component6", "()Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OsagoCompanyDetailEnum;", "component7", "component8", "", "component9", "()Ljava/util/Map;", "productID", "sum", "sumTitle", "sumValue", "linkText", "status", "statusDescription", "statusText", "requestParams", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OsagoCompanyDetailEnum;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoCompanyDetailDomain;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getSumTitle", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getSum", "e", "getLinkText", "i", "Ljava/util/Map;", "getRequestParams", AuthSource.SEND_ABUSE, "getProductID", "f", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OsagoCompanyDetailEnum;", "getStatus", "h", "getStatusText", "d", "getSumValue", g.a, "getStatusDescription", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OsagoCompanyDetailEnum;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoCompanyDetailDomain {
    @NotNull
    public final String a;
    @Nullable
    public final Integer b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @NotNull
    public final OsagoCompanyDetailEnum f;
    @Nullable
    public final String g;
    @Nullable
    public final String h;
    @NotNull
    public final Map<String, String> i;

    public OfferOsagoCompanyDetailDomain(@NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull OsagoCompanyDetailEnum osagoCompanyDetailEnum, @Nullable String str5, @Nullable String str6, @NotNull Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "productID");
        Intrinsics.checkParameterIsNotNull(osagoCompanyDetailEnum, "status");
        Intrinsics.checkParameterIsNotNull(map, "requestParams");
        this.a = str;
        this.b = num;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = osagoCompanyDetailEnum;
        this.g = str5;
        this.h = str6;
        this.i = map;
    }

    public static /* synthetic */ OfferOsagoCompanyDetailDomain copy$default(OfferOsagoCompanyDetailDomain offerOsagoCompanyDetailDomain, String str, Integer num, String str2, String str3, String str4, OsagoCompanyDetailEnum osagoCompanyDetailEnum, String str5, String str6, Map map, int i2, Object obj) {
        return offerOsagoCompanyDetailDomain.copy((i2 & 1) != 0 ? offerOsagoCompanyDetailDomain.a : str, (i2 & 2) != 0 ? offerOsagoCompanyDetailDomain.b : num, (i2 & 4) != 0 ? offerOsagoCompanyDetailDomain.c : str2, (i2 & 8) != 0 ? offerOsagoCompanyDetailDomain.d : str3, (i2 & 16) != 0 ? offerOsagoCompanyDetailDomain.e : str4, (i2 & 32) != 0 ? offerOsagoCompanyDetailDomain.f : osagoCompanyDetailEnum, (i2 & 64) != 0 ? offerOsagoCompanyDetailDomain.g : str5, (i2 & 128) != 0 ? offerOsagoCompanyDetailDomain.h : str6, (i2 & 256) != 0 ? offerOsagoCompanyDetailDomain.i : map);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final Integer component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final OsagoCompanyDetailEnum component6() {
        return this.f;
    }

    @Nullable
    public final String component7() {
        return this.g;
    }

    @Nullable
    public final String component8() {
        return this.h;
    }

    @NotNull
    public final Map<String, String> component9() {
        return this.i;
    }

    @NotNull
    public final OfferOsagoCompanyDetailDomain copy(@NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull OsagoCompanyDetailEnum osagoCompanyDetailEnum, @Nullable String str5, @Nullable String str6, @NotNull Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "productID");
        Intrinsics.checkParameterIsNotNull(osagoCompanyDetailEnum, "status");
        Intrinsics.checkParameterIsNotNull(map, "requestParams");
        return new OfferOsagoCompanyDetailDomain(str, num, str2, str3, str4, osagoCompanyDetailEnum, str5, str6, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferOsagoCompanyDetailDomain)) {
            return false;
        }
        OfferOsagoCompanyDetailDomain offerOsagoCompanyDetailDomain = (OfferOsagoCompanyDetailDomain) obj;
        return Intrinsics.areEqual(this.a, offerOsagoCompanyDetailDomain.a) && Intrinsics.areEqual(this.b, offerOsagoCompanyDetailDomain.b) && Intrinsics.areEqual(this.c, offerOsagoCompanyDetailDomain.c) && Intrinsics.areEqual(this.d, offerOsagoCompanyDetailDomain.d) && Intrinsics.areEqual(this.e, offerOsagoCompanyDetailDomain.e) && Intrinsics.areEqual(this.f, offerOsagoCompanyDetailDomain.f) && Intrinsics.areEqual(this.g, offerOsagoCompanyDetailDomain.g) && Intrinsics.areEqual(this.h, offerOsagoCompanyDetailDomain.h) && Intrinsics.areEqual(this.i, offerOsagoCompanyDetailDomain.i);
    }

    @Nullable
    public final String getLinkText() {
        return this.e;
    }

    @NotNull
    public final String getProductID() {
        return this.a;
    }

    @NotNull
    public final Map<String, String> getRequestParams() {
        return this.i;
    }

    @NotNull
    public final OsagoCompanyDetailEnum getStatus() {
        return this.f;
    }

    @Nullable
    public final String getStatusDescription() {
        return this.g;
    }

    @Nullable
    public final String getStatusText() {
        return this.h;
    }

    @Nullable
    public final Integer getSum() {
        return this.b;
    }

    @Nullable
    public final String getSumTitle() {
        return this.c;
    }

    @Nullable
    public final String getSumValue() {
        return this.d;
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.b;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        OsagoCompanyDetailEnum osagoCompanyDetailEnum = this.f;
        int hashCode6 = (hashCode5 + (osagoCompanyDetailEnum != null ? osagoCompanyDetailEnum.hashCode() : 0)) * 31;
        String str5 = this.g;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.h;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Map<String, String> map = this.i;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode8 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferOsagoCompanyDetailDomain(productID=");
        L.append(this.a);
        L.append(", sum=");
        L.append(this.b);
        L.append(", sumTitle=");
        L.append(this.c);
        L.append(", sumValue=");
        L.append(this.d);
        L.append(", linkText=");
        L.append(this.e);
        L.append(", status=");
        L.append(this.f);
        L.append(", statusDescription=");
        L.append(this.g);
        L.append(", statusText=");
        L.append(this.h);
        L.append(", requestParams=");
        return a.x(L, this.i, ")");
    }
}
