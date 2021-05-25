package ru.sravni.android.bankproduct.repository.offer.entity;

import a2.b.a.a.a;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001:\u0001(B-\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b&\u0010'J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ>\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u000bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\bR\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u000b¨\u0006)"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo;", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain;", "toOfferFilterDomain", "()Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain;", "", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo$DetailRepo;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "filterDetails", "filterIcon", "filterName", "filterTitle", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getFilterTitle", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getFilterDetails", "c", "getFilterName", AuthSource.BOOKING_ORDER, "getFilterIcon", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "DetailRepo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferFilterRepo {
    @NotNull
    public final List<DetailRepo> a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001:\u0001*B-\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b(\u0010)J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ>\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\t2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u000b¨\u0006+"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo$DetailRepo;", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain$DetailDomain;", "toOfferFilterDetailDomain", "()Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain$DetailDomain;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo$DetailRepo$ValueRepo;", "component4", "()Ljava/util/List;", "detailTitle", "filterType", "editable", ResidentialComplexModuleKt.VALUES, "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo$DetailRepo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getFilterType", "d", "Ljava/util/List;", "getValues", AuthSource.SEND_ABUSE, "getDetailTitle", "c", "Z", "getEditable", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "ValueRepo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class DetailRepo {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        public final boolean c;
        @NotNull
        public final List<ValueRepo> d;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J.\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo$DetailRepo$ValueRepo;", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain$DetailDomain$ValueDomain;", "toOfferFilterDetailValueDomain", "()Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain$DetailDomain$ValueDomain;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "code", "title", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo$DetailRepo$ValueRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCode", AuthSource.BOOKING_ORDER, "getTitle", "c", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class ValueRepo {
            @NotNull
            public final String a;
            @NotNull
            public final String b;
            @NotNull
            public final String c;

            public ValueRepo(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                a.a1(str, "code", str2, "title", str3, "value");
                this.a = str;
                this.b = str2;
                this.c = str3;
            }

            public static /* synthetic */ ValueRepo copy$default(ValueRepo valueRepo, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = valueRepo.a;
                }
                if ((i & 2) != 0) {
                    str2 = valueRepo.b;
                }
                if ((i & 4) != 0) {
                    str3 = valueRepo.c;
                }
                return valueRepo.copy(str, str2, str3);
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
            public final ValueRepo copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkParameterIsNotNull(str, "code");
                Intrinsics.checkParameterIsNotNull(str2, "title");
                Intrinsics.checkParameterIsNotNull(str3, "value");
                return new ValueRepo(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ValueRepo)) {
                    return false;
                }
                ValueRepo valueRepo = (ValueRepo) obj;
                return Intrinsics.areEqual(this.a, valueRepo.a) && Intrinsics.areEqual(this.b, valueRepo.b) && Intrinsics.areEqual(this.c, valueRepo.c);
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
            public final OfferFilterDomain.DetailDomain.ValueDomain toOfferFilterDetailValueDomain() {
                return new OfferFilterDomain.DetailDomain.ValueDomain(this.a, this.b, this.c);
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("ValueRepo(code=");
                L.append(this.a);
                L.append(", title=");
                L.append(this.b);
                L.append(", value=");
                return a.t(L, this.c, ")");
            }
        }

        public DetailRepo(@NotNull String str, @NotNull String str2, boolean z, @NotNull List<ValueRepo> list) {
            Intrinsics.checkParameterIsNotNull(str, "detailTitle");
            Intrinsics.checkParameterIsNotNull(str2, "filterType");
            Intrinsics.checkParameterIsNotNull(list, ResidentialComplexModuleKt.VALUES);
            this.a = str;
            this.b = str2;
            this.c = z;
            this.d = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterRepo$DetailRepo */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DetailRepo copy$default(DetailRepo detailRepo, String str, String str2, boolean z, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = detailRepo.a;
            }
            if ((i & 2) != 0) {
                str2 = detailRepo.b;
            }
            if ((i & 4) != 0) {
                z = detailRepo.c;
            }
            if ((i & 8) != 0) {
                list = detailRepo.d;
            }
            return detailRepo.copy(str, str2, z, list);
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
        public final List<ValueRepo> component4() {
            return this.d;
        }

        @NotNull
        public final DetailRepo copy(@NotNull String str, @NotNull String str2, boolean z, @NotNull List<ValueRepo> list) {
            Intrinsics.checkParameterIsNotNull(str, "detailTitle");
            Intrinsics.checkParameterIsNotNull(str2, "filterType");
            Intrinsics.checkParameterIsNotNull(list, ResidentialComplexModuleKt.VALUES);
            return new DetailRepo(str, str2, z, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DetailRepo)) {
                return false;
            }
            DetailRepo detailRepo = (DetailRepo) obj;
            return Intrinsics.areEqual(this.a, detailRepo.a) && Intrinsics.areEqual(this.b, detailRepo.b) && this.c == detailRepo.c && Intrinsics.areEqual(this.d, detailRepo.d);
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
        public final List<ValueRepo> getValues() {
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
            List<ValueRepo> list = this.d;
            if (list != null) {
                i = list.hashCode();
            }
            return i5 + i;
        }

        @NotNull
        public final OfferFilterDomain.DetailDomain toOfferFilterDetailDomain() {
            String str = this.a;
            String str2 = this.b;
            boolean z = this.c;
            List<ValueRepo> list = this.d;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toOfferFilterDetailValueDomain());
            }
            return new OfferFilterDomain.DetailDomain(str, str2, z, arrayList);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("DetailRepo(detailTitle=");
            L.append(this.a);
            L.append(", filterType=");
            L.append(this.b);
            L.append(", editable=");
            L.append(this.c);
            L.append(", values=");
            return a.w(L, this.d, ")");
        }
    }

    public OfferFilterRepo(@NotNull List<DetailRepo> list, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(list, "filterDetails");
        Intrinsics.checkParameterIsNotNull(str, "filterIcon");
        Intrinsics.checkParameterIsNotNull(str2, "filterName");
        Intrinsics.checkParameterIsNotNull(str3, "filterTitle");
        this.a = list;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferFilterRepo copy$default(OfferFilterRepo offerFilterRepo, List list, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = offerFilterRepo.a;
        }
        if ((i & 2) != 0) {
            str = offerFilterRepo.b;
        }
        if ((i & 4) != 0) {
            str2 = offerFilterRepo.c;
        }
        if ((i & 8) != 0) {
            str3 = offerFilterRepo.d;
        }
        return offerFilterRepo.copy(list, str, str2, str3);
    }

    @NotNull
    public final List<DetailRepo> component1() {
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
    public final OfferFilterRepo copy(@NotNull List<DetailRepo> list, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(list, "filterDetails");
        Intrinsics.checkParameterIsNotNull(str, "filterIcon");
        Intrinsics.checkParameterIsNotNull(str2, "filterName");
        Intrinsics.checkParameterIsNotNull(str3, "filterTitle");
        return new OfferFilterRepo(list, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferFilterRepo)) {
            return false;
        }
        OfferFilterRepo offerFilterRepo = (OfferFilterRepo) obj;
        return Intrinsics.areEqual(this.a, offerFilterRepo.a) && Intrinsics.areEqual(this.b, offerFilterRepo.b) && Intrinsics.areEqual(this.c, offerFilterRepo.c) && Intrinsics.areEqual(this.d, offerFilterRepo.d);
    }

    @NotNull
    public final List<DetailRepo> getFilterDetails() {
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
        List<DetailRepo> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
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
    public final OfferFilterDomain toOfferFilterDomain() {
        return new OfferFilterDomain(((DetailRepo) CollectionsKt___CollectionsKt.first((List<? extends Object>) this.a)).toOfferFilterDetailDomain(), this.b, this.c, this.d);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferFilterRepo(filterDetails=");
        L.append(this.a);
        L.append(", filterIcon=");
        L.append(this.b);
        L.append(", filterName=");
        L.append(this.c);
        L.append(", filterTitle=");
        return a.t(L, this.d, ")");
    }
}
