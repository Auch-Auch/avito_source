package ru.sravni.android.bankproduct.utils.navigation.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u001a\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOrderInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "conversationID", "cardID", "savedSearchID", "copy", "(Ljava/lang/String;ILjava/lang/String;)Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOrderInfo;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getFieldNameProductID", "fieldNameProductID", AuthSource.SEND_ABUSE, "getFieldNameStatus", "fieldNameStatus", "d", "I", "getCardID", "e", "getSavedSearchID", "c", "getConversationID", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OsagoNavOrderInfo {
    @NotNull
    public final String a = "status";
    @NotNull
    public final String b = "productId";
    @NotNull
    public final String c;
    public final int d;
    @NotNull
    public final String e;

    public OsagoNavOrderInfo(@NotNull String str, int i, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        Intrinsics.checkParameterIsNotNull(str2, "savedSearchID");
        this.c = str;
        this.d = i;
        this.e = str2;
    }

    public static /* synthetic */ OsagoNavOrderInfo copy$default(OsagoNavOrderInfo osagoNavOrderInfo, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = osagoNavOrderInfo.c;
        }
        if ((i2 & 2) != 0) {
            i = osagoNavOrderInfo.d;
        }
        if ((i2 & 4) != 0) {
            str2 = osagoNavOrderInfo.e;
        }
        return osagoNavOrderInfo.copy(str, i, str2);
    }

    @NotNull
    public final String component1() {
        return this.c;
    }

    public final int component2() {
        return this.d;
    }

    @NotNull
    public final String component3() {
        return this.e;
    }

    @NotNull
    public final OsagoNavOrderInfo copy(@NotNull String str, int i, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        Intrinsics.checkParameterIsNotNull(str2, "savedSearchID");
        return new OsagoNavOrderInfo(str, i, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OsagoNavOrderInfo)) {
            return false;
        }
        OsagoNavOrderInfo osagoNavOrderInfo = (OsagoNavOrderInfo) obj;
        return Intrinsics.areEqual(this.c, osagoNavOrderInfo.c) && this.d == osagoNavOrderInfo.d && Intrinsics.areEqual(this.e, osagoNavOrderInfo.e);
    }

    public final int getCardID() {
        return this.d;
    }

    @NotNull
    public final String getConversationID() {
        return this.c;
    }

    @NotNull
    public final String getFieldNameProductID() {
        return this.b;
    }

    @NotNull
    public final String getFieldNameStatus() {
        return this.a;
    }

    @NotNull
    public final String getSavedSearchID() {
        return this.e;
    }

    public int hashCode() {
        String str = this.c;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.d) * 31;
        String str2 = this.e;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OsagoNavOrderInfo(conversationID=");
        L.append(this.c);
        L.append(", cardID=");
        L.append(this.d);
        L.append(", savedSearchID=");
        return a.t(L, this.e, ")");
    }
}
