package ru.sravni.android.bankproduct.utils.filter.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b)\u0010*J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J>\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\b2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u0010\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0010J\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\rR\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0010¨\u0006+"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/entity/FilterBarrelDayInfo;", "", "", "isNewDateValue", "()Z", "", "getNewDate", "()J", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "", "component3", "()I", "component4", "code", "listDate", "datePosition", "recommendedDate", "copy", "(Ljava/lang/String;Ljava/util/List;IJ)Lru/sravni/android/bankproduct/utils/filter/entity/FilterBarrelDayInfo;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCode", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getListDate", "d", "J", "getRecommendedDate", "c", "I", "getDatePosition", "<init>", "(Ljava/lang/String;Ljava/util/List;IJ)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterBarrelDayInfo {
    @NotNull
    public final String a;
    @NotNull
    public final List<Long> b;
    public final int c;
    public final long d;

    public FilterBarrelDayInfo(@NotNull String str, @NotNull List<Long> list, int i, long j) {
        Intrinsics.checkParameterIsNotNull(str, "code");
        Intrinsics.checkParameterIsNotNull(list, "listDate");
        this.a = str;
        this.b = list;
        this.c = i;
        this.d = j;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.sravni.android.bankproduct.utils.filter.entity.FilterBarrelDayInfo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilterBarrelDayInfo copy$default(FilterBarrelDayInfo filterBarrelDayInfo, String str, List list, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = filterBarrelDayInfo.a;
        }
        if ((i2 & 2) != 0) {
            list = filterBarrelDayInfo.b;
        }
        if ((i2 & 4) != 0) {
            i = filterBarrelDayInfo.c;
        }
        if ((i2 & 8) != 0) {
            j = filterBarrelDayInfo.d;
        }
        return filterBarrelDayInfo.copy(str, list, i, j);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final List<Long> component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    public final long component4() {
        return this.d;
    }

    @NotNull
    public final FilterBarrelDayInfo copy(@NotNull String str, @NotNull List<Long> list, int i, long j) {
        Intrinsics.checkParameterIsNotNull(str, "code");
        Intrinsics.checkParameterIsNotNull(list, "listDate");
        return new FilterBarrelDayInfo(str, list, i, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterBarrelDayInfo)) {
            return false;
        }
        FilterBarrelDayInfo filterBarrelDayInfo = (FilterBarrelDayInfo) obj;
        return Intrinsics.areEqual(this.a, filterBarrelDayInfo.a) && Intrinsics.areEqual(this.b, filterBarrelDayInfo.b) && this.c == filterBarrelDayInfo.c && this.d == filterBarrelDayInfo.d;
    }

    @NotNull
    public final String getCode() {
        return this.a;
    }

    public final int getDatePosition() {
        return this.c;
    }

    @NotNull
    public final List<Long> getListDate() {
        return this.b;
    }

    public final long getNewDate() {
        return this.b.get(this.c).longValue();
    }

    public final long getRecommendedDate() {
        return this.d;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Long> list = this.b;
        if (list != null) {
            i = list.hashCode();
        }
        return ((((hashCode + i) * 31) + this.c) * 31) + c.a(this.d);
    }

    public final boolean isNewDateValue() {
        return this.d != this.b.get(this.c).longValue();
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("FilterBarrelDayInfo(code=");
        L.append(this.a);
        L.append(", listDate=");
        L.append(this.b);
        L.append(", datePosition=");
        L.append(this.c);
        L.append(", recommendedDate=");
        return a.l(L, this.d, ")");
    }
}
