package ru.sravni.android.bankproduct.utils.navigation;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/utils/navigation/DataForPopBack;", "", "", "component1", "()I", "", "component2", "()Z", "screenId", "inclusive", "copy", "(IZ)Lru/sravni/android/bankproduct/utils/navigation/DataForPopBack;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Z", "getInclusive", AuthSource.SEND_ABUSE, "I", "getScreenId", "<init>", "(IZ)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DataForPopBack {
    public final int a;
    public final boolean b;

    public DataForPopBack(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    public static /* synthetic */ DataForPopBack copy$default(DataForPopBack dataForPopBack, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dataForPopBack.a;
        }
        if ((i2 & 2) != 0) {
            z = dataForPopBack.b;
        }
        return dataForPopBack.copy(i, z);
    }

    public final int component1() {
        return this.a;
    }

    public final boolean component2() {
        return this.b;
    }

    @NotNull
    public final DataForPopBack copy(int i, boolean z) {
        return new DataForPopBack(i, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataForPopBack)) {
            return false;
        }
        DataForPopBack dataForPopBack = (DataForPopBack) obj;
        return this.a == dataForPopBack.a && this.b == dataForPopBack.b;
    }

    public final boolean getInclusive() {
        return this.b;
    }

    public final int getScreenId() {
        return this.a;
    }

    public int hashCode() {
        int i = this.a * 31;
        boolean z = this.b;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        return i + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DataForPopBack(screenId=");
        L.append(this.a);
        L.append(", inclusive=");
        return a.B(L, this.b, ")");
    }
}
