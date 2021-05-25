package ru.sravni.android.bankproduct.utils.filter.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b'\u0010(J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J>\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00052\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000fJ\u001a\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\fR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u0007R\u0019\u0010\u0013\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u000f¨\u0006)"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/entity/FilterSnapPointInfo;", "", "", "isNewPeriodValue", "()Z", "", "getNewPeriod", "()Ljava/lang/String;", "component1", "", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterInfo;", "component2", "()Ljava/util/List;", "", "component3", "()I", "component4", "code", "listFilterInfo", "periodPosition", "defaultPeriod", "copy", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/String;)Lru/sravni/android/bankproduct/utils/filter/entity/FilterSnapPointInfo;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getDefaultPeriod", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getListFilterInfo", AuthSource.SEND_ABUSE, "getCode", "c", "I", "getPeriodPosition", "<init>", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterSnapPointInfo {
    @NotNull
    public final String a;
    @NotNull
    public final List<FilterInfo> b;
    public final int c;
    @NotNull
    public final String d;

    public FilterSnapPointInfo(@NotNull String str, @NotNull List<FilterInfo> list, int i, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "code");
        Intrinsics.checkParameterIsNotNull(list, "listFilterInfo");
        Intrinsics.checkParameterIsNotNull(str2, "defaultPeriod");
        this.a = str;
        this.b = list;
        this.c = i;
        this.d = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.utils.filter.entity.FilterSnapPointInfo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilterSnapPointInfo copy$default(FilterSnapPointInfo filterSnapPointInfo, String str, List list, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = filterSnapPointInfo.a;
        }
        if ((i2 & 2) != 0) {
            list = filterSnapPointInfo.b;
        }
        if ((i2 & 4) != 0) {
            i = filterSnapPointInfo.c;
        }
        if ((i2 & 8) != 0) {
            str2 = filterSnapPointInfo.d;
        }
        return filterSnapPointInfo.copy(str, list, i, str2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final List<FilterInfo> component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final FilterSnapPointInfo copy(@NotNull String str, @NotNull List<FilterInfo> list, int i, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "code");
        Intrinsics.checkParameterIsNotNull(list, "listFilterInfo");
        Intrinsics.checkParameterIsNotNull(str2, "defaultPeriod");
        return new FilterSnapPointInfo(str, list, i, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterSnapPointInfo)) {
            return false;
        }
        FilterSnapPointInfo filterSnapPointInfo = (FilterSnapPointInfo) obj;
        return Intrinsics.areEqual(this.a, filterSnapPointInfo.a) && Intrinsics.areEqual(this.b, filterSnapPointInfo.b) && this.c == filterSnapPointInfo.c && Intrinsics.areEqual(this.d, filterSnapPointInfo.d);
    }

    @NotNull
    public final String getCode() {
        return this.a;
    }

    @NotNull
    public final String getDefaultPeriod() {
        return this.d;
    }

    @NotNull
    public final List<FilterInfo> getListFilterInfo() {
        return this.b;
    }

    @NotNull
    public final String getNewPeriod() {
        return this.b.get(this.c).getValue();
    }

    public final int getPeriodPosition() {
        return this.c;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<FilterInfo> list = this.b;
        int hashCode2 = (((hashCode + (list != null ? list.hashCode() : 0)) * 31) + this.c) * 31;
        String str2 = this.d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final boolean isNewPeriodValue() {
        return !Intrinsics.areEqual(this.d, this.b.get(this.c).getValue());
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("FilterSnapPointInfo(code=");
        L.append(this.a);
        L.append(", listFilterInfo=");
        L.append(this.b);
        L.append(", periodPosition=");
        L.append(this.c);
        L.append(", defaultPeriod=");
        return a.t(L, this.d, ")");
    }
}
