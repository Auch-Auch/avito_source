package ru.sravni.android.bankproduct.repository.offer.product.entity;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004Jn\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010!\u001a\u0004\b(\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010!\u001a\u0004\b*\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010!\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010!\u001a\u0004\b.\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010!\u001a\u0004\b0\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010!\u001a\u0004\b2\u0010\u0004¨\u00065"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "offerTitle", "bankName", "fontColor", "backgroundColor", "iconTitle", "cardType", AnalyticFieldsName.productName, "detailTitle", "bankLogoUrlSVG", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "f", "Ljava/lang/String;", "getCardType", AuthSource.BOOKING_ORDER, "getBankName", "e", "getIconTitle", "c", "getFontColor", "i", "getBankLogoUrlSVG", AuthSource.SEND_ABUSE, "getOfferTitle", "d", "getBackgroundColor", g.a, "getProductName", "h", "getDetailTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductDisplaySettingsRepo {
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
    @Nullable
    public final String f;
    @NotNull
    public final String g;
    @NotNull
    public final String h;
    @Nullable
    public final String i;

    public OfferProductDisplaySettingsRepo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, @NotNull String str7, @NotNull String str8, @Nullable String str9) {
        Intrinsics.checkParameterIsNotNull(str, "offerTitle");
        Intrinsics.checkParameterIsNotNull(str2, "bankName");
        Intrinsics.checkParameterIsNotNull(str3, "fontColor");
        Intrinsics.checkParameterIsNotNull(str4, "backgroundColor");
        Intrinsics.checkParameterIsNotNull(str5, "iconTitle");
        Intrinsics.checkParameterIsNotNull(str7, AnalyticFieldsName.productName);
        Intrinsics.checkParameterIsNotNull(str8, "detailTitle");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
    }

    public static /* synthetic */ OfferProductDisplaySettingsRepo copy$default(OfferProductDisplaySettingsRepo offerProductDisplaySettingsRepo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, Object obj) {
        return offerProductDisplaySettingsRepo.copy((i2 & 1) != 0 ? offerProductDisplaySettingsRepo.a : str, (i2 & 2) != 0 ? offerProductDisplaySettingsRepo.b : str2, (i2 & 4) != 0 ? offerProductDisplaySettingsRepo.c : str3, (i2 & 8) != 0 ? offerProductDisplaySettingsRepo.d : str4, (i2 & 16) != 0 ? offerProductDisplaySettingsRepo.e : str5, (i2 & 32) != 0 ? offerProductDisplaySettingsRepo.f : str6, (i2 & 64) != 0 ? offerProductDisplaySettingsRepo.g : str7, (i2 & 128) != 0 ? offerProductDisplaySettingsRepo.h : str8, (i2 & 256) != 0 ? offerProductDisplaySettingsRepo.i : str9);
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
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final String component7() {
        return this.g;
    }

    @NotNull
    public final String component8() {
        return this.h;
    }

    @Nullable
    public final String component9() {
        return this.i;
    }

    @NotNull
    public final OfferProductDisplaySettingsRepo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, @NotNull String str7, @NotNull String str8, @Nullable String str9) {
        Intrinsics.checkParameterIsNotNull(str, "offerTitle");
        Intrinsics.checkParameterIsNotNull(str2, "bankName");
        Intrinsics.checkParameterIsNotNull(str3, "fontColor");
        Intrinsics.checkParameterIsNotNull(str4, "backgroundColor");
        Intrinsics.checkParameterIsNotNull(str5, "iconTitle");
        Intrinsics.checkParameterIsNotNull(str7, AnalyticFieldsName.productName);
        Intrinsics.checkParameterIsNotNull(str8, "detailTitle");
        return new OfferProductDisplaySettingsRepo(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductDisplaySettingsRepo)) {
            return false;
        }
        OfferProductDisplaySettingsRepo offerProductDisplaySettingsRepo = (OfferProductDisplaySettingsRepo) obj;
        return Intrinsics.areEqual(this.a, offerProductDisplaySettingsRepo.a) && Intrinsics.areEqual(this.b, offerProductDisplaySettingsRepo.b) && Intrinsics.areEqual(this.c, offerProductDisplaySettingsRepo.c) && Intrinsics.areEqual(this.d, offerProductDisplaySettingsRepo.d) && Intrinsics.areEqual(this.e, offerProductDisplaySettingsRepo.e) && Intrinsics.areEqual(this.f, offerProductDisplaySettingsRepo.f) && Intrinsics.areEqual(this.g, offerProductDisplaySettingsRepo.g) && Intrinsics.areEqual(this.h, offerProductDisplaySettingsRepo.h) && Intrinsics.areEqual(this.i, offerProductDisplaySettingsRepo.i);
    }

    @NotNull
    public final String getBackgroundColor() {
        return this.d;
    }

    @Nullable
    public final String getBankLogoUrlSVG() {
        return this.i;
    }

    @NotNull
    public final String getBankName() {
        return this.b;
    }

    @Nullable
    public final String getCardType() {
        return this.f;
    }

    @NotNull
    public final String getDetailTitle() {
        return this.h;
    }

    @NotNull
    public final String getFontColor() {
        return this.c;
    }

    @NotNull
    public final String getIconTitle() {
        return this.e;
    }

    @NotNull
    public final String getOfferTitle() {
        return this.a;
    }

    @NotNull
    public final String getProductName() {
        return this.g;
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.g;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.h;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.i;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        return hashCode8 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductDisplaySettingsRepo(offerTitle=");
        L.append(this.a);
        L.append(", bankName=");
        L.append(this.b);
        L.append(", fontColor=");
        L.append(this.c);
        L.append(", backgroundColor=");
        L.append(this.d);
        L.append(", iconTitle=");
        L.append(this.e);
        L.append(", cardType=");
        L.append(this.f);
        L.append(", productName=");
        L.append(this.g);
        L.append(", detailTitle=");
        L.append(this.h);
        L.append(", bankLogoUrlSVG=");
        return a.t(L, this.i, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OfferProductDisplaySettingsRepo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, j jVar) {
        this(str, str2, str3, str4, str5, (i2 & 32) != 0 ? null : str6, str7, str8, (i2 & 256) != 0 ? null : str9);
    }
}
