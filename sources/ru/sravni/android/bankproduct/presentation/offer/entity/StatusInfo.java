package ru.sravni.android.bankproduct.presentation.offer.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/entity/StatusInfo;", "", "", "component1", "()I", "component2", "statusIcon", "statusColor", "copy", "(II)Lru/sravni/android/bankproduct/presentation/offer/entity/StatusInfo;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "I", "getStatusColor", AuthSource.SEND_ABUSE, "getStatusIcon", "<init>", "(II)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class StatusInfo {
    public final int a;
    public final int b;

    public StatusInfo(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public static /* synthetic */ StatusInfo copy$default(StatusInfo statusInfo, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = statusInfo.a;
        }
        if ((i3 & 2) != 0) {
            i2 = statusInfo.b;
        }
        return statusInfo.copy(i, i2);
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final StatusInfo copy(int i, int i2) {
        return new StatusInfo(i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatusInfo)) {
            return false;
        }
        StatusInfo statusInfo = (StatusInfo) obj;
        return this.a == statusInfo.a && this.b == statusInfo.b;
    }

    public final int getStatusColor() {
        return this.b;
    }

    public final int getStatusIcon() {
        return this.a;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("StatusInfo(statusIcon=");
        L.append(this.a);
        L.append(", statusColor=");
        return a.j(L, this.b, ")");
    }
}
