package ru.sravni.android.bankproduct.utils.filter.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010 R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/entity/FilterSwitcherInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "component4", "component5", "title", "active", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "enabled", "value", "copy", "(Ljava/lang/String;ZZZLjava/lang/String;)Lru/sravni/android/bankproduct/utils/filter/entity/FilterSwitcherInfo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", AuthSource.BOOKING_ORDER, "Z", "getActive", "setActive", "(Z)V", "c", "getVisibility", "d", "getEnabled", "e", "getValue", "<init>", "(Ljava/lang/String;ZZZLjava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterSwitcherInfo {
    @NotNull
    public final String a;
    public boolean b;
    public final boolean c;
    public final boolean d;
    @NotNull
    public final String e;

    public FilterSwitcherInfo(@NotNull String str, boolean z, boolean z2, boolean z3, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        this.a = str;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = str2;
    }

    public static /* synthetic */ FilterSwitcherInfo copy$default(FilterSwitcherInfo filterSwitcherInfo, String str, boolean z, boolean z2, boolean z3, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = filterSwitcherInfo.a;
        }
        if ((i & 2) != 0) {
            z = filterSwitcherInfo.b;
        }
        if ((i & 4) != 0) {
            z2 = filterSwitcherInfo.c;
        }
        if ((i & 8) != 0) {
            z3 = filterSwitcherInfo.d;
        }
        if ((i & 16) != 0) {
            str2 = filterSwitcherInfo.e;
        }
        return filterSwitcherInfo.copy(str, z, z2, z3, str2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final boolean component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    @NotNull
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final FilterSwitcherInfo copy(@NotNull String str, boolean z, boolean z2, boolean z3, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        return new FilterSwitcherInfo(str, z, z2, z3, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterSwitcherInfo)) {
            return false;
        }
        FilterSwitcherInfo filterSwitcherInfo = (FilterSwitcherInfo) obj;
        return Intrinsics.areEqual(this.a, filterSwitcherInfo.a) && this.b == filterSwitcherInfo.b && this.c == filterSwitcherInfo.c && this.d == filterSwitcherInfo.d && Intrinsics.areEqual(this.e, filterSwitcherInfo.e);
    }

    public final boolean getActive() {
        return this.b;
    }

    public final boolean getEnabled() {
        return this.d;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    @NotNull
    public final String getValue() {
        return this.e;
    }

    public final boolean getVisibility() {
        return this.c;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.b;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode + i3) * 31;
        boolean z2 = this.c;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (i6 + i7) * 31;
        boolean z3 = this.d;
        if (!z3) {
            i2 = z3 ? 1 : 0;
        }
        int i11 = (i10 + i2) * 31;
        String str2 = this.e;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i11 + i;
    }

    public final void setActive(boolean z) {
        this.b = z;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("FilterSwitcherInfo(title=");
        L.append(this.a);
        L.append(", active=");
        L.append(this.b);
        L.append(", visibility=");
        L.append(this.c);
        L.append(", enabled=");
        L.append(this.d);
        L.append(", value=");
        return a.t(L, this.e, ")");
    }
}
