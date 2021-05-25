package ru.sravni.android.bankproduct.repository.offer.product.entity;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductDisplaySettingsDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusDomain;
import ru.sravni.android.bankproduct.repository.offer.product.entity.util.OfferProductUtilKt;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001:\u00017BG\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b5\u00106J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J^\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010%\u001a\u0004\b(\u0010\u0007R\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010\u0007R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b,\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\nR\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010%\u001a\u0004\b1\u0010\u0007R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0012¨\u00068"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductStatusRepo;", "", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;", "toOfferProductStatusDomain", "()Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;", "", "component1", "()Ljava/lang/String;", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;", "component2", "()Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;", "component3", "component4", "component5", "component6", "", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductStatusRepo$OfferStatusElementRepo;", "component7", "()Ljava/util/List;", "productType", "displaySettings", "productID", "orderID", "bankID", "savedSearchID", "offerStatusElementRepoList", "copy", "(Ljava/lang/String;Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductStatusRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getOrderID", "e", "getBankID", "f", "getSavedSearchID", AuthSource.SEND_ABUSE, "getProductType", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;", "getDisplaySettings", "c", "getProductID", g.a, "Ljava/util/List;", "getOfferStatusElementRepoList", "<init>", "(Ljava/lang/String;Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "OfferStatusElementRepo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductStatusRepo {
    @NotNull
    public final String a;
    @NotNull
    public final OfferProductDisplaySettingsRepo b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    @NotNull
    public final List<OfferStatusElementRepo> g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J0\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductStatusRepo$OfferStatusElementRepo;", "", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain$OfferStatusElementDomain;", "toOfferProductStatusDomain", "()Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain$OfferStatusElementDomain;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "elementType", "status", "text", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductStatusRepo$OfferStatusElementRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getText", AuthSource.BOOKING_ORDER, "getStatus", AuthSource.SEND_ABUSE, "getElementType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class OfferStatusElementRepo {
        @NotNull
        public final String a;
        @Nullable
        public final String b;
        @NotNull
        public final String c;

        public OfferStatusElementRepo(@NotNull String str, @Nullable String str2, @NotNull String str3) {
            Intrinsics.checkParameterIsNotNull(str, "elementType");
            Intrinsics.checkParameterIsNotNull(str3, "text");
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        public static /* synthetic */ OfferStatusElementRepo copy$default(OfferStatusElementRepo offerStatusElementRepo, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = offerStatusElementRepo.a;
            }
            if ((i & 2) != 0) {
                str2 = offerStatusElementRepo.b;
            }
            if ((i & 4) != 0) {
                str3 = offerStatusElementRepo.c;
            }
            return offerStatusElementRepo.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final OfferStatusElementRepo copy(@NotNull String str, @Nullable String str2, @NotNull String str3) {
            Intrinsics.checkParameterIsNotNull(str, "elementType");
            Intrinsics.checkParameterIsNotNull(str3, "text");
            return new OfferStatusElementRepo(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OfferStatusElementRepo)) {
                return false;
            }
            OfferStatusElementRepo offerStatusElementRepo = (OfferStatusElementRepo) obj;
            return Intrinsics.areEqual(this.a, offerStatusElementRepo.a) && Intrinsics.areEqual(this.b, offerStatusElementRepo.b) && Intrinsics.areEqual(this.c, offerStatusElementRepo.c);
        }

        @NotNull
        public final String getElementType() {
            return this.a;
        }

        @Nullable
        public final String getStatus() {
            return this.b;
        }

        @NotNull
        public final String getText() {
            return this.c;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public final OfferProductStatusDomain.OfferStatusElementDomain toOfferProductStatusDomain() {
            return new OfferProductStatusDomain.OfferStatusElementDomain(this.a, OfferProductUtilKt.statusParse(this.b), this.c);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("OfferStatusElementRepo(elementType=");
            L.append(this.a);
            L.append(", status=");
            L.append(this.b);
            L.append(", text=");
            return a.t(L, this.c, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ OfferStatusElementRepo(String str, String str2, String str3, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : str2, str3);
        }
    }

    public OfferProductStatusRepo(@NotNull String str, @NotNull OfferProductDisplaySettingsRepo offerProductDisplaySettingsRepo, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @NotNull List<OfferStatusElementRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "productType");
        Intrinsics.checkParameterIsNotNull(offerProductDisplaySettingsRepo, "displaySettings");
        Intrinsics.checkParameterIsNotNull(str2, "productID");
        Intrinsics.checkParameterIsNotNull(str4, "bankID");
        Intrinsics.checkParameterIsNotNull(str5, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "offerStatusElementRepoList");
        this.a = str;
        this.b = offerProductDisplaySettingsRepo;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductStatusRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferProductStatusRepo copy$default(OfferProductStatusRepo offerProductStatusRepo, String str, OfferProductDisplaySettingsRepo offerProductDisplaySettingsRepo, String str2, String str3, String str4, String str5, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offerProductStatusRepo.a;
        }
        if ((i & 2) != 0) {
            offerProductDisplaySettingsRepo = offerProductStatusRepo.b;
        }
        if ((i & 4) != 0) {
            str2 = offerProductStatusRepo.c;
        }
        if ((i & 8) != 0) {
            str3 = offerProductStatusRepo.d;
        }
        if ((i & 16) != 0) {
            str4 = offerProductStatusRepo.e;
        }
        if ((i & 32) != 0) {
            str5 = offerProductStatusRepo.f;
        }
        if ((i & 64) != 0) {
            list = offerProductStatusRepo.g;
        }
        return offerProductStatusRepo.copy(str, offerProductDisplaySettingsRepo, str2, str3, str4, str5, list);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final OfferProductDisplaySettingsRepo component2() {
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

    @NotNull
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final List<OfferStatusElementRepo> component7() {
        return this.g;
    }

    @NotNull
    public final OfferProductStatusRepo copy(@NotNull String str, @NotNull OfferProductDisplaySettingsRepo offerProductDisplaySettingsRepo, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @NotNull List<OfferStatusElementRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "productType");
        Intrinsics.checkParameterIsNotNull(offerProductDisplaySettingsRepo, "displaySettings");
        Intrinsics.checkParameterIsNotNull(str2, "productID");
        Intrinsics.checkParameterIsNotNull(str4, "bankID");
        Intrinsics.checkParameterIsNotNull(str5, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "offerStatusElementRepoList");
        return new OfferProductStatusRepo(str, offerProductDisplaySettingsRepo, str2, str3, str4, str5, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductStatusRepo)) {
            return false;
        }
        OfferProductStatusRepo offerProductStatusRepo = (OfferProductStatusRepo) obj;
        return Intrinsics.areEqual(this.a, offerProductStatusRepo.a) && Intrinsics.areEqual(this.b, offerProductStatusRepo.b) && Intrinsics.areEqual(this.c, offerProductStatusRepo.c) && Intrinsics.areEqual(this.d, offerProductStatusRepo.d) && Intrinsics.areEqual(this.e, offerProductStatusRepo.e) && Intrinsics.areEqual(this.f, offerProductStatusRepo.f) && Intrinsics.areEqual(this.g, offerProductStatusRepo.g);
    }

    @NotNull
    public final String getBankID() {
        return this.e;
    }

    @NotNull
    public final OfferProductDisplaySettingsRepo getDisplaySettings() {
        return this.b;
    }

    @NotNull
    public final List<OfferStatusElementRepo> getOfferStatusElementRepoList() {
        return this.g;
    }

    @Nullable
    public final String getOrderID() {
        return this.d;
    }

    @NotNull
    public final String getProductID() {
        return this.c;
    }

    @NotNull
    public final String getProductType() {
        return this.a;
    }

    @NotNull
    public final String getSavedSearchID() {
        return this.f;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        OfferProductDisplaySettingsRepo offerProductDisplaySettingsRepo = this.b;
        int hashCode2 = (hashCode + (offerProductDisplaySettingsRepo != null ? offerProductDisplaySettingsRepo.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List<OfferStatusElementRepo> list = this.g;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public final OfferProductStatusDomain toOfferProductStatusDomain() {
        OfferProductDisplaySettingsDomain createDisplaySettings = OfferProductUtilKt.createDisplaySettings(this.b, this.a);
        String str = this.c;
        String str2 = this.d;
        String str3 = this.e;
        String str4 = this.f;
        List<OfferStatusElementRepo> list = this.g;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toOfferProductStatusDomain());
        }
        return new OfferProductStatusDomain(createDisplaySettings, str, str2, str3, str4, arrayList);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductStatusRepo(productType=");
        L.append(this.a);
        L.append(", displaySettings=");
        L.append(this.b);
        L.append(", productID=");
        L.append(this.c);
        L.append(", orderID=");
        L.append(this.d);
        L.append(", bankID=");
        L.append(this.e);
        L.append(", savedSearchID=");
        L.append(this.f);
        L.append(", offerStatusElementRepoList=");
        return a.w(L, this.g, ")");
    }
}
