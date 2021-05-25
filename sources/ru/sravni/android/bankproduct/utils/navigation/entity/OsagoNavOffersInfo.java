package ru.sravni.android.bankproduct.utils.navigation.entity;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b-\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u0004R\u001c\u0010$\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u0004R\u001c\u0010'\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u0004R\u001c\u0010*\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010\u0004R\u001c\u0010-\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b+\u0010\u001b\u001a\u0004\b,\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u001b\u001a\u0004\b2\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b\u0011\u0010\f¨\u00067"}, d2 = {"Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOffersInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "", "component5", "()Z", "conversationID", "cardID", AnalyticFieldsName.productName, "savedSearchID", "isPush", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Z)Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOffersInfo;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getFieldNameProductId", "fieldNameProductId", "i", "getSavedSearchID", "h", "getProductName", AuthSource.SEND_ABUSE, "getFieldNameOfferID", "fieldNameOfferID", AuthSource.BOOKING_ORDER, "getFieldNamePrice", "fieldNamePrice", "c", "getFieldNameDate", "fieldNameDate", "e", "getFieldNamePollingId", "fieldNamePollingId", g.a, "Ljava/lang/Integer;", "getCardID", "f", "getConversationID", "j", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Z)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OsagoNavOffersInfo {
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
    @Nullable
    public final Integer g;
    @NotNull
    public final String h;
    @NotNull
    public final String i;
    public final boolean j;

    public OsagoNavOffersInfo(@NotNull String str, @Nullable Integer num, @NotNull String str2, @NotNull String str3, boolean z) {
        a.a1(str, "conversationID", str2, AnalyticFieldsName.productName, str3, "savedSearchID");
        this.f = str;
        this.g = num;
        this.h = str2;
        this.i = str3;
        this.j = z;
        this.a = "offerId";
        this.b = "price";
        this.c = "policedate";
        this.d = "productId";
        this.e = "pollingId";
    }

    public static /* synthetic */ OsagoNavOffersInfo copy$default(OsagoNavOffersInfo osagoNavOffersInfo, String str, Integer num, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = osagoNavOffersInfo.f;
        }
        if ((i2 & 2) != 0) {
            num = osagoNavOffersInfo.g;
        }
        if ((i2 & 4) != 0) {
            str2 = osagoNavOffersInfo.h;
        }
        if ((i2 & 8) != 0) {
            str3 = osagoNavOffersInfo.i;
        }
        if ((i2 & 16) != 0) {
            z = osagoNavOffersInfo.j;
        }
        return osagoNavOffersInfo.copy(str, num, str2, str3, z);
    }

    @NotNull
    public final String component1() {
        return this.f;
    }

    @Nullable
    public final Integer component2() {
        return this.g;
    }

    @NotNull
    public final String component3() {
        return this.h;
    }

    @NotNull
    public final String component4() {
        return this.i;
    }

    public final boolean component5() {
        return this.j;
    }

    @NotNull
    public final OsagoNavOffersInfo copy(@NotNull String str, @Nullable Integer num, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        Intrinsics.checkParameterIsNotNull(str2, AnalyticFieldsName.productName);
        Intrinsics.checkParameterIsNotNull(str3, "savedSearchID");
        return new OsagoNavOffersInfo(str, num, str2, str3, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OsagoNavOffersInfo)) {
            return false;
        }
        OsagoNavOffersInfo osagoNavOffersInfo = (OsagoNavOffersInfo) obj;
        return Intrinsics.areEqual(this.f, osagoNavOffersInfo.f) && Intrinsics.areEqual(this.g, osagoNavOffersInfo.g) && Intrinsics.areEqual(this.h, osagoNavOffersInfo.h) && Intrinsics.areEqual(this.i, osagoNavOffersInfo.i) && this.j == osagoNavOffersInfo.j;
    }

    @Nullable
    public final Integer getCardID() {
        return this.g;
    }

    @NotNull
    public final String getConversationID() {
        return this.f;
    }

    @NotNull
    public final String getFieldNameDate() {
        return this.c;
    }

    @NotNull
    public final String getFieldNameOfferID() {
        return this.a;
    }

    @NotNull
    public final String getFieldNamePollingId() {
        return this.e;
    }

    @NotNull
    public final String getFieldNamePrice() {
        return this.b;
    }

    @NotNull
    public final String getFieldNameProductId() {
        return this.d;
    }

    @NotNull
    public final String getProductName() {
        return this.h;
    }

    @NotNull
    public final String getSavedSearchID() {
        return this.i;
    }

    public int hashCode() {
        String str = this.f;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.g;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.h;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.i;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = (hashCode3 + i2) * 31;
        boolean z = this.j;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        return i3 + i4;
    }

    public final boolean isPush() {
        return this.j;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OsagoNavOffersInfo(conversationID=");
        L.append(this.f);
        L.append(", cardID=");
        L.append(this.g);
        L.append(", productName=");
        L.append(this.h);
        L.append(", savedSearchID=");
        L.append(this.i);
        L.append(", isPush=");
        return a.B(L, this.j, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OsagoNavOffersInfo(String str, Integer num, String str2, String str3, boolean z, int i2, j jVar) {
        this(str, (i2 & 2) != 0 ? null : num, str2, str3, (i2 & 16) != 0 ? false : z);
    }
}
