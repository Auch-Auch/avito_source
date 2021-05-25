package ru.sravni.android.bankproduct.domain.dashboard.entity;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u001c\b\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004Jv\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u0010\u0010\u001f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001f\u0010\rJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010%\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\rR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b0\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010%\u001a\u0004\b2\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010%\u001a\u0004\b4\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010%\u001a\u0004\b6\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010-\u001a\u0004\b8\u0010\rR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010%\u001a\u0004\b:\u0010\u0004¨\u0006="}, d2 = {"Lru/sravni/android/bankproduct/domain/dashboard/entity/OfferCalculationElementDomain;", "", "", "component1", "()Ljava/lang/String;", "Ljava/util/Date;", "component2", "()Ljava/util/Date;", "component3", "component4", "component5", "", "component6", "()I", "component7", "component8", "component9", "component10", AnalyticFieldsName.conversationID, Sort.DATE, "creditName", AnalyticFieldsName.productName, "creditTitle", "offerCount", "requestSend", "offerCountTitle", "requestCountTitle", "savedSearchID", "copy", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/dashboard/entity/OfferCalculationElementDomain;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/lang/String;", "getCreditTitle", "i", "getRequestCountTitle", AuthSource.BOOKING_ORDER, "Ljava/util/Date;", "getDate", "f", "I", "getOfferCount", AuthSource.SEND_ABUSE, "getConversationId", "c", "getCreditName", "h", "getOfferCountTitle", "j", "getSavedSearchID", g.a, "getRequestSend", "d", "getProductName", "<init>", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferCalculationElementDomain {
    @NotNull
    public final String a;
    @NotNull
    public final Date b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @NotNull
    public final String e;
    public final int f;
    public final int g;
    @NotNull
    public final String h;
    @NotNull
    public final String i;
    @NotNull
    public final String j;

    public OfferCalculationElementDomain(@NotNull String str, @NotNull Date date, @NotNull String str2, @Nullable String str3, @NotNull String str4, int i2, int i3, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        Intrinsics.checkParameterIsNotNull(date, Sort.DATE);
        Intrinsics.checkParameterIsNotNull(str2, "creditName");
        Intrinsics.checkParameterIsNotNull(str4, "creditTitle");
        Intrinsics.checkParameterIsNotNull(str5, "offerCountTitle");
        Intrinsics.checkParameterIsNotNull(str6, "requestCountTitle");
        Intrinsics.checkParameterIsNotNull(str7, "savedSearchID");
        this.a = str;
        this.b = date;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = i2;
        this.g = i3;
        this.h = str5;
        this.i = str6;
        this.j = str7;
    }

    public static /* synthetic */ OfferCalculationElementDomain copy$default(OfferCalculationElementDomain offerCalculationElementDomain, String str, Date date, String str2, String str3, String str4, int i2, int i3, String str5, String str6, String str7, int i4, Object obj) {
        return offerCalculationElementDomain.copy((i4 & 1) != 0 ? offerCalculationElementDomain.a : str, (i4 & 2) != 0 ? offerCalculationElementDomain.b : date, (i4 & 4) != 0 ? offerCalculationElementDomain.c : str2, (i4 & 8) != 0 ? offerCalculationElementDomain.d : str3, (i4 & 16) != 0 ? offerCalculationElementDomain.e : str4, (i4 & 32) != 0 ? offerCalculationElementDomain.f : i2, (i4 & 64) != 0 ? offerCalculationElementDomain.g : i3, (i4 & 128) != 0 ? offerCalculationElementDomain.h : str5, (i4 & 256) != 0 ? offerCalculationElementDomain.i : str6, (i4 & 512) != 0 ? offerCalculationElementDomain.j : str7);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component10() {
        return this.j;
    }

    @NotNull
    public final Date component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final String component5() {
        return this.e;
    }

    public final int component6() {
        return this.f;
    }

    public final int component7() {
        return this.g;
    }

    @NotNull
    public final String component8() {
        return this.h;
    }

    @NotNull
    public final String component9() {
        return this.i;
    }

    @NotNull
    public final OfferCalculationElementDomain copy(@NotNull String str, @NotNull Date date, @NotNull String str2, @Nullable String str3, @NotNull String str4, int i2, int i3, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        Intrinsics.checkParameterIsNotNull(date, Sort.DATE);
        Intrinsics.checkParameterIsNotNull(str2, "creditName");
        Intrinsics.checkParameterIsNotNull(str4, "creditTitle");
        Intrinsics.checkParameterIsNotNull(str5, "offerCountTitle");
        Intrinsics.checkParameterIsNotNull(str6, "requestCountTitle");
        Intrinsics.checkParameterIsNotNull(str7, "savedSearchID");
        return new OfferCalculationElementDomain(str, date, str2, str3, str4, i2, i3, str5, str6, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferCalculationElementDomain)) {
            return false;
        }
        OfferCalculationElementDomain offerCalculationElementDomain = (OfferCalculationElementDomain) obj;
        return Intrinsics.areEqual(this.a, offerCalculationElementDomain.a) && Intrinsics.areEqual(this.b, offerCalculationElementDomain.b) && Intrinsics.areEqual(this.c, offerCalculationElementDomain.c) && Intrinsics.areEqual(this.d, offerCalculationElementDomain.d) && Intrinsics.areEqual(this.e, offerCalculationElementDomain.e) && this.f == offerCalculationElementDomain.f && this.g == offerCalculationElementDomain.g && Intrinsics.areEqual(this.h, offerCalculationElementDomain.h) && Intrinsics.areEqual(this.i, offerCalculationElementDomain.i) && Intrinsics.areEqual(this.j, offerCalculationElementDomain.j);
    }

    @NotNull
    public final String getConversationId() {
        return this.a;
    }

    @NotNull
    public final String getCreditName() {
        return this.c;
    }

    @NotNull
    public final String getCreditTitle() {
        return this.e;
    }

    @NotNull
    public final Date getDate() {
        return this.b;
    }

    public final int getOfferCount() {
        return this.f;
    }

    @NotNull
    public final String getOfferCountTitle() {
        return this.h;
    }

    @Nullable
    public final String getProductName() {
        return this.d;
    }

    @NotNull
    public final String getRequestCountTitle() {
        return this.i;
    }

    public final int getRequestSend() {
        return this.g;
    }

    @NotNull
    public final String getSavedSearchID() {
        return this.j;
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Date date = this.b;
        int hashCode2 = (hashCode + (date != null ? date.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        int hashCode5 = (((((hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.f) * 31) + this.g) * 31;
        String str5 = this.h;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.i;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.j;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode7 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferCalculationElementDomain(conversationId=");
        L.append(this.a);
        L.append(", date=");
        L.append(this.b);
        L.append(", creditName=");
        L.append(this.c);
        L.append(", productName=");
        L.append(this.d);
        L.append(", creditTitle=");
        L.append(this.e);
        L.append(", offerCount=");
        L.append(this.f);
        L.append(", requestSend=");
        L.append(this.g);
        L.append(", offerCountTitle=");
        L.append(this.h);
        L.append(", requestCountTitle=");
        L.append(this.i);
        L.append(", savedSearchID=");
        return a.t(L, this.j, ")");
    }
}
