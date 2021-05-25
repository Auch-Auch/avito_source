package ru.sravni.android.bankproduct.repository.offer.osago.entity.list;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoDisplaySettingsDomain;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoDisplaySettingsRepo;", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDisplaySettingsDomain;", "toOfferOsagoDisplaySettingsDomain", "()Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDisplaySettingsDomain;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "fontColor", "backgroundColor", "iconTitle", AnalyticFieldsName.productName, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoDisplaySettingsRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getFontColor", AuthSource.BOOKING_ORDER, "getBackgroundColor", "d", "getProductName", "c", "getIconTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoDisplaySettingsRepo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;

    public OfferOsagoDisplaySettingsRepo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "fontColor");
        Intrinsics.checkParameterIsNotNull(str2, "backgroundColor");
        Intrinsics.checkParameterIsNotNull(str3, "iconTitle");
        Intrinsics.checkParameterIsNotNull(str4, AnalyticFieldsName.productName);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public static /* synthetic */ OfferOsagoDisplaySettingsRepo copy$default(OfferOsagoDisplaySettingsRepo offerOsagoDisplaySettingsRepo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offerOsagoDisplaySettingsRepo.a;
        }
        if ((i & 2) != 0) {
            str2 = offerOsagoDisplaySettingsRepo.b;
        }
        if ((i & 4) != 0) {
            str3 = offerOsagoDisplaySettingsRepo.c;
        }
        if ((i & 8) != 0) {
            str4 = offerOsagoDisplaySettingsRepo.d;
        }
        return offerOsagoDisplaySettingsRepo.copy(str, str2, str3, str4);
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
    public final OfferOsagoDisplaySettingsRepo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "fontColor");
        Intrinsics.checkParameterIsNotNull(str2, "backgroundColor");
        Intrinsics.checkParameterIsNotNull(str3, "iconTitle");
        Intrinsics.checkParameterIsNotNull(str4, AnalyticFieldsName.productName);
        return new OfferOsagoDisplaySettingsRepo(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferOsagoDisplaySettingsRepo)) {
            return false;
        }
        OfferOsagoDisplaySettingsRepo offerOsagoDisplaySettingsRepo = (OfferOsagoDisplaySettingsRepo) obj;
        return Intrinsics.areEqual(this.a, offerOsagoDisplaySettingsRepo.a) && Intrinsics.areEqual(this.b, offerOsagoDisplaySettingsRepo.b) && Intrinsics.areEqual(this.c, offerOsagoDisplaySettingsRepo.c) && Intrinsics.areEqual(this.d, offerOsagoDisplaySettingsRepo.d);
    }

    @NotNull
    public final String getBackgroundColor() {
        return this.b;
    }

    @NotNull
    public final String getFontColor() {
        return this.a;
    }

    @NotNull
    public final String getIconTitle() {
        return this.c;
    }

    @NotNull
    public final String getProductName() {
        return this.d;
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
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public final OfferOsagoDisplaySettingsDomain toOfferOsagoDisplaySettingsDomain() {
        return new OfferOsagoDisplaySettingsDomain(UtilFunctionsKt.getTitleColor(this.b), UtilFunctionsKt.getTitleColor(this.a), this.c, this.d);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferOsagoDisplaySettingsRepo(fontColor=");
        L.append(this.a);
        L.append(", backgroundColor=");
        L.append(this.b);
        L.append(", iconTitle=");
        L.append(this.c);
        L.append(", productName=");
        return a.t(L, this.d, ")");
    }
}
