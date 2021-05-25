package ru.sravni.android.bankproduct.utils.navigation.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u000f\u0010\bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\f¨\u0006("}, d2 = {"Lru/sravni/android/bankproduct/utils/navigation/entity/ProductNavOffersInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "", "component5", "()Ljava/lang/Integer;", "savedSearchID", AnalyticFieldsName.productName, "isPush", "conversationID", "cardID", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;)Lru/sravni/android/bankproduct/utils/navigation/entity/ProductNavOffersInfo;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getProductName", AuthSource.SEND_ABUSE, "getSavedSearchID", "d", "getConversationID", "c", "Z", "e", "Ljava/lang/Integer;", "getCardID", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProductNavOffersInfo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final boolean c;
    @NotNull
    public final String d;
    @Nullable
    public final Integer e;

    public ProductNavOffersInfo(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3, @Nullable Integer num) {
        a.a1(str, "savedSearchID", str2, AnalyticFieldsName.productName, str3, "conversationID");
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = str3;
        this.e = num;
    }

    public static /* synthetic */ ProductNavOffersInfo copy$default(ProductNavOffersInfo productNavOffersInfo, String str, String str2, boolean z, String str3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = productNavOffersInfo.a;
        }
        if ((i & 2) != 0) {
            str2 = productNavOffersInfo.b;
        }
        if ((i & 4) != 0) {
            z = productNavOffersInfo.c;
        }
        if ((i & 8) != 0) {
            str3 = productNavOffersInfo.d;
        }
        if ((i & 16) != 0) {
            num = productNavOffersInfo.e;
        }
        return productNavOffersInfo.copy(str, str2, z, str3, num);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final Integer component5() {
        return this.e;
    }

    @NotNull
    public final ProductNavOffersInfo copy(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(str2, AnalyticFieldsName.productName);
        Intrinsics.checkParameterIsNotNull(str3, "conversationID");
        return new ProductNavOffersInfo(str, str2, z, str3, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductNavOffersInfo)) {
            return false;
        }
        ProductNavOffersInfo productNavOffersInfo = (ProductNavOffersInfo) obj;
        return Intrinsics.areEqual(this.a, productNavOffersInfo.a) && Intrinsics.areEqual(this.b, productNavOffersInfo.b) && this.c == productNavOffersInfo.c && Intrinsics.areEqual(this.d, productNavOffersInfo.d) && Intrinsics.areEqual(this.e, productNavOffersInfo.e);
    }

    @Nullable
    public final Integer getCardID() {
        return this.e;
    }

    @NotNull
    public final String getConversationID() {
        return this.d;
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
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode2 + i2) * 31;
        String str3 = this.d;
        int hashCode3 = (i5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.e;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode3 + i;
    }

    public final boolean isPush() {
        return this.c;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProductNavOffersInfo(savedSearchID=");
        L.append(this.a);
        L.append(", productName=");
        L.append(this.b);
        L.append(", isPush=");
        L.append(this.c);
        L.append(", conversationID=");
        L.append(this.d);
        L.append(", cardID=");
        return a.p(L, this.e, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductNavOffersInfo(String str, String str2, boolean z, String str3, Integer num, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? false : z, str3, (i & 16) != 0 ? null : num);
    }
}
