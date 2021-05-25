package net.gotev.uploadservice.data;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001d"}, d2 = {"Lnet/gotev/uploadservice/data/UploadRate;", "", "", "component1", "()I", "Lnet/gotev/uploadservice/data/UploadRate$UploadRateUnit;", "component2", "()Lnet/gotev/uploadservice/data/UploadRate$UploadRateUnit;", "value", "unit", "copy", "(ILnet/gotev/uploadservice/data/UploadRate$UploadRateUnit;)Lnet/gotev/uploadservice/data/UploadRate;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getValue", AuthSource.BOOKING_ORDER, "Lnet/gotev/uploadservice/data/UploadRate$UploadRateUnit;", "getUnit", "<init>", "(ILnet/gotev/uploadservice/data/UploadRate$UploadRateUnit;)V", "UploadRateUnit", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class UploadRate {
    public final int a;
    @NotNull
    public final UploadRateUnit b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lnet/gotev/uploadservice/data/UploadRate$UploadRateUnit;", "", "<init>", "(Ljava/lang/String;I)V", "BitPerSecond", "KilobitPerSecond", "MegabitPerSecond", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public enum UploadRateUnit {
        BitPerSecond,
        KilobitPerSecond,
        MegabitPerSecond
    }

    public UploadRate() {
        this(0, null, 3, null);
    }

    public UploadRate(int i, @NotNull UploadRateUnit uploadRateUnit) {
        Intrinsics.checkNotNullParameter(uploadRateUnit, "unit");
        this.a = i;
        this.b = uploadRateUnit;
    }

    public static /* synthetic */ UploadRate copy$default(UploadRate uploadRate, int i, UploadRateUnit uploadRateUnit, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = uploadRate.a;
        }
        if ((i2 & 2) != 0) {
            uploadRateUnit = uploadRate.b;
        }
        return uploadRate.copy(i, uploadRateUnit);
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final UploadRateUnit component2() {
        return this.b;
    }

    @NotNull
    public final UploadRate copy(int i, @NotNull UploadRateUnit uploadRateUnit) {
        Intrinsics.checkNotNullParameter(uploadRateUnit, "unit");
        return new UploadRate(i, uploadRateUnit);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadRate)) {
            return false;
        }
        UploadRate uploadRate = (UploadRate) obj;
        return this.a == uploadRate.a && Intrinsics.areEqual(this.b, uploadRate.b);
    }

    @NotNull
    public final UploadRateUnit getUnit() {
        return this.b;
    }

    public final int getValue() {
        return this.a;
    }

    public int hashCode() {
        int i = this.a * 31;
        UploadRateUnit uploadRateUnit = this.b;
        return i + (uploadRateUnit != null ? uploadRateUnit.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("UploadRate(value=");
        L.append(this.a);
        L.append(", unit=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadRate(int i, UploadRateUnit uploadRateUnit, int i2, j jVar) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? UploadRateUnit.BitPerSecond : uploadRateUnit);
    }
}
