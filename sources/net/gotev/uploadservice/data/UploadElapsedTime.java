package net.gotev.uploadservice.data;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0013\u0010\u0016\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lnet/gotev/uploadservice/data/UploadElapsedTime;", "", "", "component1", "()I", "component2", "minutes", "seconds", "copy", "(II)Lnet/gotev/uploadservice/data/UploadElapsedTime;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "I", "getSeconds", "getTotalSeconds", "totalSeconds", AuthSource.SEND_ABUSE, "getMinutes", "<init>", "(II)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class UploadElapsedTime {
    public final int a;
    public final int b;

    public UploadElapsedTime(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public static /* synthetic */ UploadElapsedTime copy$default(UploadElapsedTime uploadElapsedTime, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = uploadElapsedTime.a;
        }
        if ((i3 & 2) != 0) {
            i2 = uploadElapsedTime.b;
        }
        return uploadElapsedTime.copy(i, i2);
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final UploadElapsedTime copy(int i, int i2) {
        return new UploadElapsedTime(i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadElapsedTime)) {
            return false;
        }
        UploadElapsedTime uploadElapsedTime = (UploadElapsedTime) obj;
        return this.a == uploadElapsedTime.a && this.b == uploadElapsedTime.b;
    }

    public final int getMinutes() {
        return this.a;
    }

    public final int getSeconds() {
        return this.b;
    }

    public final int getTotalSeconds() {
        return (this.a * 60) + this.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("UploadElapsedTime(minutes=");
        L.append(this.a);
        L.append(", seconds=");
        return a.j(L, this.b, ")");
    }
}
