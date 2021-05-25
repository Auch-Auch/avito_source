package ru.sravni.android.bankproduct.domain.offer.entity;

import a2.b.a.a.a;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001:\u0001$B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u0007¨\u0006%"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain;", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain$DetailDomain;", "component1", "()Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain$DetailDomain;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "filterDetail", "filterIcon", "filterName", "filterTitle", "copy", "(Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain$DetailDomain;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain$DetailDomain;", "getFilterDetail", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getFilterIcon", "d", "getFilterTitle", "c", "getFilterName", "<init>", "(Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain$DetailDomain;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "DetailDomain", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferFilterDomain {
    @NotNull
    public final DetailDomain a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001:\u0001'B-\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ>\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u0019\u0010\u000f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\u0004¨\u0006("}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain$DetailDomain;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain$DetailDomain$ValueDomain;", "component4", "()Ljava/util/List;", "detailTitle", "filterType", "editable", ResidentialComplexModuleKt.VALUES, "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain$DetailDomain;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/util/List;", "getValues", "c", "Z", "getEditable", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getFilterType", AuthSource.SEND_ABUSE, "getDetailTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "ValueDomain", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class DetailDomain {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        public final boolean c;
        @NotNull
        public final List<ValueDomain> d;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain$DetailDomain$ValueDomain;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "code", "title", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain$DetailDomain$ValueDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCode", AuthSource.BOOKING_ORDER, "getTitle", "c", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class ValueDomain {
            @NotNull
            public final String a;
            @NotNull
            public final String b;
            @NotNull
            public final String c;

            public ValueDomain(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                a.a1(str, "code", str2, "title", str3, "value");
                this.a = str;
                this.b = str2;
                this.c = str3;
            }

            public static /* synthetic */ ValueDomain copy$default(ValueDomain valueDomain, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = valueDomain.a;
                }
                if ((i & 2) != 0) {
                    str2 = valueDomain.b;
                }
                if ((i & 4) != 0) {
                    str3 = valueDomain.c;
                }
                return valueDomain.copy(str, str2, str3);
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
            public final ValueDomain copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkParameterIsNotNull(str, "code");
                Intrinsics.checkParameterIsNotNull(str2, "title");
                Intrinsics.checkParameterIsNotNull(str3, "value");
                return new ValueDomain(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ValueDomain)) {
                    return false;
                }
                ValueDomain valueDomain = (ValueDomain) obj;
                return Intrinsics.areEqual(this.a, valueDomain.a) && Intrinsics.areEqual(this.b, valueDomain.b) && Intrinsics.areEqual(this.c, valueDomain.c);
            }

            @NotNull
            public final String getCode() {
                return this.a;
            }

            @NotNull
            public final String getTitle() {
                return this.b;
            }

            @NotNull
            public final String getValue() {
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
            public String toString() {
                StringBuilder L = a.L("ValueDomain(code=");
                L.append(this.a);
                L.append(", title=");
                L.append(this.b);
                L.append(", value=");
                return a.t(L, this.c, ")");
            }
        }

        public DetailDomain(@NotNull String str, @NotNull String str2, boolean z, @NotNull List<ValueDomain> list) {
            Intrinsics.checkParameterIsNotNull(str, "detailTitle");
            Intrinsics.checkParameterIsNotNull(str2, "filterType");
            Intrinsics.checkParameterIsNotNull(list, ResidentialComplexModuleKt.VALUES);
            this.a = str;
            this.b = str2;
            this.c = z;
            this.d = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain$DetailDomain */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DetailDomain copy$default(DetailDomain detailDomain, String str, String str2, boolean z, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = detailDomain.a;
            }
            if ((i & 2) != 0) {
                str2 = detailDomain.b;
            }
            if ((i & 4) != 0) {
                z = detailDomain.c;
            }
            if ((i & 8) != 0) {
                list = detailDomain.d;
            }
            return detailDomain.copy(str, str2, z, list);
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
        public final List<ValueDomain> component4() {
            return this.d;
        }

        @NotNull
        public final DetailDomain copy(@NotNull String str, @NotNull String str2, boolean z, @NotNull List<ValueDomain> list) {
            Intrinsics.checkParameterIsNotNull(str, "detailTitle");
            Intrinsics.checkParameterIsNotNull(str2, "filterType");
            Intrinsics.checkParameterIsNotNull(list, ResidentialComplexModuleKt.VALUES);
            return new DetailDomain(str, str2, z, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DetailDomain)) {
                return false;
            }
            DetailDomain detailDomain = (DetailDomain) obj;
            return Intrinsics.areEqual(this.a, detailDomain.a) && Intrinsics.areEqual(this.b, detailDomain.b) && this.c == detailDomain.c && Intrinsics.areEqual(this.d, detailDomain.d);
        }

        @NotNull
        public final String getDetailTitle() {
            return this.a;
        }

        public final boolean getEditable() {
            return this.c;
        }

        @NotNull
        public final String getFilterType() {
            return this.b;
        }

        @NotNull
        public final List<ValueDomain> getValues() {
            return this.d;
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
            List<ValueDomain> list = this.d;
            if (list != null) {
                i = list.hashCode();
            }
            return i5 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("DetailDomain(detailTitle=");
            L.append(this.a);
            L.append(", filterType=");
            L.append(this.b);
            L.append(", editable=");
            L.append(this.c);
            L.append(", values=");
            return a.w(L, this.d, ")");
        }
    }

    public OfferFilterDomain(@NotNull DetailDomain detailDomain, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(detailDomain, "filterDetail");
        Intrinsics.checkParameterIsNotNull(str, "filterIcon");
        Intrinsics.checkParameterIsNotNull(str2, "filterName");
        Intrinsics.checkParameterIsNotNull(str3, "filterTitle");
        this.a = detailDomain;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public static /* synthetic */ OfferFilterDomain copy$default(OfferFilterDomain offerFilterDomain, DetailDomain detailDomain, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            detailDomain = offerFilterDomain.a;
        }
        if ((i & 2) != 0) {
            str = offerFilterDomain.b;
        }
        if ((i & 4) != 0) {
            str2 = offerFilterDomain.c;
        }
        if ((i & 8) != 0) {
            str3 = offerFilterDomain.d;
        }
        return offerFilterDomain.copy(detailDomain, str, str2, str3);
    }

    @NotNull
    public final DetailDomain component1() {
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
    public final OfferFilterDomain copy(@NotNull DetailDomain detailDomain, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(detailDomain, "filterDetail");
        Intrinsics.checkParameterIsNotNull(str, "filterIcon");
        Intrinsics.checkParameterIsNotNull(str2, "filterName");
        Intrinsics.checkParameterIsNotNull(str3, "filterTitle");
        return new OfferFilterDomain(detailDomain, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferFilterDomain)) {
            return false;
        }
        OfferFilterDomain offerFilterDomain = (OfferFilterDomain) obj;
        return Intrinsics.areEqual(this.a, offerFilterDomain.a) && Intrinsics.areEqual(this.b, offerFilterDomain.b) && Intrinsics.areEqual(this.c, offerFilterDomain.c) && Intrinsics.areEqual(this.d, offerFilterDomain.d);
    }

    @NotNull
    public final DetailDomain getFilterDetail() {
        return this.a;
    }

    @NotNull
    public final String getFilterIcon() {
        return this.b;
    }

    @NotNull
    public final String getFilterName() {
        return this.c;
    }

    @NotNull
    public final String getFilterTitle() {
        return this.d;
    }

    public int hashCode() {
        DetailDomain detailDomain = this.a;
        int i = 0;
        int hashCode = (detailDomain != null ? detailDomain.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferFilterDomain(filterDetail=");
        L.append(this.a);
        L.append(", filterIcon=");
        L.append(this.b);
        L.append(", filterName=");
        L.append(this.c);
        L.append(", filterTitle=");
        return a.t(L, this.d, ")");
    }
}
