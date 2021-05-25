package ru.sravni.android.bankproduct.repository.offer.osago.entity.list;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoListDomain;
import ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001:\u0001?BS\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\u0006\u0010\u001e\u001a\u00020\u0011\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00170\u0002¢\u0006\u0004\b=\u0010>J)\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u000f\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000f\u0010\fJ\u0010\u0010\u0010\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0010\u0010\fJ\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016Jl\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\u00112\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00170\u0002HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\"\u0010\fJ\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)R\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0016R\u0019\u0010\u001a\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\fR\u0019\u0010\u001b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010.\u001a\u0004\b1\u0010\fR\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00170\u00028\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010+\u001a\u0004\b3\u0010\u0016R\u0019\u0010\u001d\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010.\u001a\u0004\b5\u0010\fR\u0019\u0010\u001e\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u0013R\u0019\u0010\u001c\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010.\u001a\u0004\b:\u0010\fR\u0019\u0010\u0019\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010.\u001a\u0004\b<\u0010\f¨\u0006@"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo;", "", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemDomain;", "listOffers", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain;", "filters", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoListDomain;", "toOfferOsagoListDomain", "(Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoListDomain;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()J", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo$OfferGroupRepo;", "component7", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo;", "component8", "topHeaderTitle", "recommendedDate", "savedSearchID", "conversationID", "pollingID", "pollingInterval", "offerGroups", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", g.a, "Ljava/util/List;", "getOfferGroups", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getRecommendedDate", "c", "getSavedSearchID", "h", "getFilters", "e", "getPollingID", "f", "J", "getPollingInterval", "d", "getConversationID", AuthSource.SEND_ABUSE, "getTopHeaderTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/util/List;)V", "OfferGroupRepo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoListRepo {
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
    public final long f;
    @NotNull
    public final List<OfferGroupRepo> g;
    @NotNull
    public final List<OfferFilterRepo> h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001:\u0001!B)\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ8\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo$OfferGroupRepo;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo$OfferGroupRepo$OfferRepo;", "component3", "()Ljava/util/List;", "titleGroup", "typeGroup", "offerList", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo$OfferGroupRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/util/List;", "getOfferList", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitleGroup", AuthSource.BOOKING_ORDER, "getTypeGroup", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "OfferRepo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class OfferGroupRepo {
        @Nullable
        public final String a;
        @Nullable
        public final String b;
        @NotNull
        public final List<OfferRepo> c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo$OfferGroupRepo$OfferRepo;", "", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoDisplaySettingsRepo;", "component1", "()Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoDisplaySettingsRepo;", "", "component2", "()Ljava/lang/String;", "component3", "displaySettings", "productID", "productType", "copy", "(Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoDisplaySettingsRepo;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo$OfferGroupRepo$OfferRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getProductType", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoDisplaySettingsRepo;", "getDisplaySettings", AuthSource.BOOKING_ORDER, "getProductID", "<init>", "(Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoDisplaySettingsRepo;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class OfferRepo {
            @NotNull
            public final OfferOsagoDisplaySettingsRepo a;
            @NotNull
            public final String b;
            @NotNull
            public final String c;

            public OfferRepo(@NotNull OfferOsagoDisplaySettingsRepo offerOsagoDisplaySettingsRepo, @NotNull String str, @NotNull String str2) {
                Intrinsics.checkParameterIsNotNull(offerOsagoDisplaySettingsRepo, "displaySettings");
                Intrinsics.checkParameterIsNotNull(str, "productID");
                Intrinsics.checkParameterIsNotNull(str2, "productType");
                this.a = offerOsagoDisplaySettingsRepo;
                this.b = str;
                this.c = str2;
            }

            public static /* synthetic */ OfferRepo copy$default(OfferRepo offerRepo, OfferOsagoDisplaySettingsRepo offerOsagoDisplaySettingsRepo, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    offerOsagoDisplaySettingsRepo = offerRepo.a;
                }
                if ((i & 2) != 0) {
                    str = offerRepo.b;
                }
                if ((i & 4) != 0) {
                    str2 = offerRepo.c;
                }
                return offerRepo.copy(offerOsagoDisplaySettingsRepo, str, str2);
            }

            @NotNull
            public final OfferOsagoDisplaySettingsRepo component1() {
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
            public final OfferRepo copy(@NotNull OfferOsagoDisplaySettingsRepo offerOsagoDisplaySettingsRepo, @NotNull String str, @NotNull String str2) {
                Intrinsics.checkParameterIsNotNull(offerOsagoDisplaySettingsRepo, "displaySettings");
                Intrinsics.checkParameterIsNotNull(str, "productID");
                Intrinsics.checkParameterIsNotNull(str2, "productType");
                return new OfferRepo(offerOsagoDisplaySettingsRepo, str, str2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OfferRepo)) {
                    return false;
                }
                OfferRepo offerRepo = (OfferRepo) obj;
                return Intrinsics.areEqual(this.a, offerRepo.a) && Intrinsics.areEqual(this.b, offerRepo.b) && Intrinsics.areEqual(this.c, offerRepo.c);
            }

            @NotNull
            public final OfferOsagoDisplaySettingsRepo getDisplaySettings() {
                return this.a;
            }

            @NotNull
            public final String getProductID() {
                return this.b;
            }

            @NotNull
            public final String getProductType() {
                return this.c;
            }

            public int hashCode() {
                OfferOsagoDisplaySettingsRepo offerOsagoDisplaySettingsRepo = this.a;
                int i = 0;
                int hashCode = (offerOsagoDisplaySettingsRepo != null ? offerOsagoDisplaySettingsRepo.hashCode() : 0) * 31;
                String str = this.b;
                int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.c;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode2 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("OfferRepo(displaySettings=");
                L.append(this.a);
                L.append(", productID=");
                L.append(this.b);
                L.append(", productType=");
                return a.t(L, this.c, ")");
            }
        }

        public OfferGroupRepo(@Nullable String str, @Nullable String str2, @NotNull List<OfferRepo> list) {
            Intrinsics.checkParameterIsNotNull(list, "offerList");
            this.a = str;
            this.b = str2;
            this.c = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoListRepo$OfferGroupRepo */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OfferGroupRepo copy$default(OfferGroupRepo offerGroupRepo, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = offerGroupRepo.a;
            }
            if ((i & 2) != 0) {
                str2 = offerGroupRepo.b;
            }
            if ((i & 4) != 0) {
                list = offerGroupRepo.c;
            }
            return offerGroupRepo.copy(str, str2, list);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final List<OfferRepo> component3() {
            return this.c;
        }

        @NotNull
        public final OfferGroupRepo copy(@Nullable String str, @Nullable String str2, @NotNull List<OfferRepo> list) {
            Intrinsics.checkParameterIsNotNull(list, "offerList");
            return new OfferGroupRepo(str, str2, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OfferGroupRepo)) {
                return false;
            }
            OfferGroupRepo offerGroupRepo = (OfferGroupRepo) obj;
            return Intrinsics.areEqual(this.a, offerGroupRepo.a) && Intrinsics.areEqual(this.b, offerGroupRepo.b) && Intrinsics.areEqual(this.c, offerGroupRepo.c);
        }

        @NotNull
        public final List<OfferRepo> getOfferList() {
            return this.c;
        }

        @Nullable
        public final String getTitleGroup() {
            return this.a;
        }

        @Nullable
        public final String getTypeGroup() {
            return this.b;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            List<OfferRepo> list = this.c;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("OfferGroupRepo(titleGroup=");
            L.append(this.a);
            L.append(", typeGroup=");
            L.append(this.b);
            L.append(", offerList=");
            return a.w(L, this.c, ")");
        }
    }

    public OfferOsagoListRepo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, @NotNull List<OfferGroupRepo> list, @NotNull List<OfferFilterRepo> list2) {
        Intrinsics.checkParameterIsNotNull(str, "topHeaderTitle");
        Intrinsics.checkParameterIsNotNull(str2, "recommendedDate");
        Intrinsics.checkParameterIsNotNull(str3, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(str4, "conversationID");
        Intrinsics.checkParameterIsNotNull(str5, "pollingID");
        Intrinsics.checkParameterIsNotNull(list, "offerGroups");
        Intrinsics.checkParameterIsNotNull(list2, "filters");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = j;
        this.g = list;
        this.h = list2;
    }

    public static /* synthetic */ OfferOsagoListRepo copy$default(OfferOsagoListRepo offerOsagoListRepo, String str, String str2, String str3, String str4, String str5, long j, List list, List list2, int i, Object obj) {
        return offerOsagoListRepo.copy((i & 1) != 0 ? offerOsagoListRepo.a : str, (i & 2) != 0 ? offerOsagoListRepo.b : str2, (i & 4) != 0 ? offerOsagoListRepo.c : str3, (i & 8) != 0 ? offerOsagoListRepo.d : str4, (i & 16) != 0 ? offerOsagoListRepo.e : str5, (i & 32) != 0 ? offerOsagoListRepo.f : j, (i & 64) != 0 ? offerOsagoListRepo.g : list, (i & 128) != 0 ? offerOsagoListRepo.h : list2);
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

    public final long component6() {
        return this.f;
    }

    @NotNull
    public final List<OfferGroupRepo> component7() {
        return this.g;
    }

    @NotNull
    public final List<OfferFilterRepo> component8() {
        return this.h;
    }

    @NotNull
    public final OfferOsagoListRepo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, @NotNull List<OfferGroupRepo> list, @NotNull List<OfferFilterRepo> list2) {
        Intrinsics.checkParameterIsNotNull(str, "topHeaderTitle");
        Intrinsics.checkParameterIsNotNull(str2, "recommendedDate");
        Intrinsics.checkParameterIsNotNull(str3, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(str4, "conversationID");
        Intrinsics.checkParameterIsNotNull(str5, "pollingID");
        Intrinsics.checkParameterIsNotNull(list, "offerGroups");
        Intrinsics.checkParameterIsNotNull(list2, "filters");
        return new OfferOsagoListRepo(str, str2, str3, str4, str5, j, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferOsagoListRepo)) {
            return false;
        }
        OfferOsagoListRepo offerOsagoListRepo = (OfferOsagoListRepo) obj;
        return Intrinsics.areEqual(this.a, offerOsagoListRepo.a) && Intrinsics.areEqual(this.b, offerOsagoListRepo.b) && Intrinsics.areEqual(this.c, offerOsagoListRepo.c) && Intrinsics.areEqual(this.d, offerOsagoListRepo.d) && Intrinsics.areEqual(this.e, offerOsagoListRepo.e) && this.f == offerOsagoListRepo.f && Intrinsics.areEqual(this.g, offerOsagoListRepo.g) && Intrinsics.areEqual(this.h, offerOsagoListRepo.h);
    }

    @NotNull
    public final String getConversationID() {
        return this.d;
    }

    @NotNull
    public final List<OfferFilterRepo> getFilters() {
        return this.h;
    }

    @NotNull
    public final List<OfferGroupRepo> getOfferGroups() {
        return this.g;
    }

    @NotNull
    public final String getPollingID() {
        return this.e;
    }

    public final long getPollingInterval() {
        return this.f;
    }

    @NotNull
    public final String getRecommendedDate() {
        return this.b;
    }

    @NotNull
    public final String getSavedSearchID() {
        return this.c;
    }

    @NotNull
    public final String getTopHeaderTitle() {
        return this.a;
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
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        int hashCode5 = (((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + c.a(this.f)) * 31;
        List<OfferGroupRepo> list = this.g;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        List<OfferFilterRepo> list2 = this.h;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public final OfferOsagoListDomain toOfferOsagoListDomain(@NotNull List<OfferOsagoItemDomain> list, @NotNull List<OfferFilterDomain> list2) {
        Intrinsics.checkParameterIsNotNull(list, "listOffers");
        Intrinsics.checkParameterIsNotNull(list2, "filters");
        return new OfferOsagoListDomain(this.a, this.b, this.d, this.c, this.e, this.f, list2, list);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferOsagoListRepo(topHeaderTitle=");
        L.append(this.a);
        L.append(", recommendedDate=");
        L.append(this.b);
        L.append(", savedSearchID=");
        L.append(this.c);
        L.append(", conversationID=");
        L.append(this.d);
        L.append(", pollingID=");
        L.append(this.e);
        L.append(", pollingInterval=");
        L.append(this.f);
        L.append(", offerGroups=");
        L.append(this.g);
        L.append(", filters=");
        return a.w(L, this.h, ")");
    }
}
