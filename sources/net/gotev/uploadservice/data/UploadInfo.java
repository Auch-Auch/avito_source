package net.gotev.uploadservice.data;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import net.gotev.uploadservice.data.UploadRate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\bH\u0010IJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JR\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\n2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001a\u0010\fJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\nHÖ\u0001¢\u0006\u0004\b \u0010\fJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b%\u0010&R\u0019\u0010,\u001a\u00020'8F@\u0006¢\u0006\f\u0012\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0007R\u0019\u00104\u001a\u0002008F@\u0006¢\u0006\f\u0012\u0004\b3\u0010+\u001a\u0004\b1\u00102R\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b6\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010.\u001a\u0004\b8\u0010\u0007R\u0019\u0010;\u001a\u00020\n8F@\u0006¢\u0006\f\u0012\u0004\b:\u0010+\u001a\u0004\b9\u0010\fR\u0019\u0010>\u001a\u00020\n8F@\u0006¢\u0006\f\u0012\u0004\b=\u0010+\u001a\u0004\b<\u0010\fR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u0010R\u0019\u0010\u0015\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010\fR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010\u0004¨\u0006J"}, d2 = {"Lnet/gotev/uploadservice/data/UploadInfo;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "component3", "component4", "", "component5", "()I", "Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/data/UploadFile;", "component6", "()Ljava/util/ArrayList;", "uploadId", "startTime", "uploadedBytes", "totalBytes", "numberOfRetries", "files", "copy", "(Ljava/lang/String;JJJILjava/util/ArrayList;)Lnet/gotev/uploadservice/data/UploadInfo;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lnet/gotev/uploadservice/data/UploadRate;", "getUploadRate", "()Lnet/gotev/uploadservice/data/UploadRate;", "getUploadRate$annotations", "()V", "uploadRate", "c", "J", "getUploadedBytes", "Lnet/gotev/uploadservice/data/UploadElapsedTime;", "getElapsedTime", "()Lnet/gotev/uploadservice/data/UploadElapsedTime;", "getElapsedTime$annotations", "elapsedTime", "d", "getTotalBytes", AuthSource.BOOKING_ORDER, "getStartTime", "getSuccessfullyUploadedFiles", "getSuccessfullyUploadedFiles$annotations", "successfullyUploadedFiles", "getProgressPercent", "getProgressPercent$annotations", "progressPercent", "f", "Ljava/util/ArrayList;", "getFiles", "e", "I", "getNumberOfRetries", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUploadId", "<init>", "(Ljava/lang/String;JJJILjava/util/ArrayList;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class UploadInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @NotNull
    public final String a;
    public final long b;
    public final long c;
    public final long d;
    public final int e;
    @NotNull
    public final ArrayList<UploadFile> f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            long readLong3 = parcel.readLong();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add((UploadFile) UploadFile.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new UploadInfo(readString, readLong, readLong2, readLong3, readInt, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i) {
            return new UploadInfo[i];
        }
    }

    @JvmOverloads
    public UploadInfo(@NotNull String str) {
        this(str, 0, 0, 0, 0, null, 62, null);
    }

    @JvmOverloads
    public UploadInfo(@NotNull String str, long j) {
        this(str, j, 0, 0, 0, null, 60, null);
    }

    @JvmOverloads
    public UploadInfo(@NotNull String str, long j, long j2) {
        this(str, j, j2, 0, 0, null, 56, null);
    }

    @JvmOverloads
    public UploadInfo(@NotNull String str, long j, long j2, long j3) {
        this(str, j, j2, j3, 0, null, 48, null);
    }

    @JvmOverloads
    public UploadInfo(@NotNull String str, long j, long j2, long j3, int i) {
        this(str, j, j2, j3, i, null, 32, null);
    }

    @JvmOverloads
    public UploadInfo(@NotNull String str, long j, long j2, long j3, int i, @NotNull ArrayList<UploadFile> arrayList) {
        Intrinsics.checkNotNullParameter(str, "uploadId");
        Intrinsics.checkNotNullParameter(arrayList, "files");
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = i;
        this.f = arrayList;
    }

    public static /* synthetic */ UploadInfo copy$default(UploadInfo uploadInfo, String str, long j, long j2, long j3, int i, ArrayList arrayList, int i2, Object obj) {
        return uploadInfo.copy((i2 & 1) != 0 ? uploadInfo.a : str, (i2 & 2) != 0 ? uploadInfo.b : j, (i2 & 4) != 0 ? uploadInfo.c : j2, (i2 & 8) != 0 ? uploadInfo.d : j3, (i2 & 16) != 0 ? uploadInfo.e : i, (i2 & 32) != 0 ? uploadInfo.f : arrayList);
    }

    public static /* synthetic */ void getElapsedTime$annotations() {
    }

    public static /* synthetic */ void getProgressPercent$annotations() {
    }

    public static /* synthetic */ void getSuccessfullyUploadedFiles$annotations() {
    }

    public static /* synthetic */ void getUploadRate$annotations() {
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final long component2() {
        return this.b;
    }

    public final long component3() {
        return this.c;
    }

    public final long component4() {
        return this.d;
    }

    public final int component5() {
        return this.e;
    }

    @NotNull
    public final ArrayList<UploadFile> component6() {
        return this.f;
    }

    @NotNull
    public final UploadInfo copy(@NotNull String str, long j, long j2, long j3, int i, @NotNull ArrayList<UploadFile> arrayList) {
        Intrinsics.checkNotNullParameter(str, "uploadId");
        Intrinsics.checkNotNullParameter(arrayList, "files");
        return new UploadInfo(str, j, j2, j3, i, arrayList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadInfo)) {
            return false;
        }
        UploadInfo uploadInfo = (UploadInfo) obj;
        return Intrinsics.areEqual(this.a, uploadInfo.a) && this.b == uploadInfo.b && this.c == uploadInfo.c && this.d == uploadInfo.d && this.e == uploadInfo.e && Intrinsics.areEqual(this.f, uploadInfo.f);
    }

    @NotNull
    public final UploadElapsedTime getElapsedTime() {
        int time = (int) ((new Date().getTime() - this.b) / ((long) 1000));
        int i = time / 60;
        return new UploadElapsedTime(i, time - (i * 60));
    }

    @NotNull
    public final ArrayList<UploadFile> getFiles() {
        return this.f;
    }

    public final int getNumberOfRetries() {
        return this.e;
    }

    public final int getProgressPercent() {
        long j = this.d;
        if (j == 0) {
            return 0;
        }
        return (int) ((this.c * ((long) 100)) / j);
    }

    public final long getStartTime() {
        return this.b;
    }

    public final int getSuccessfullyUploadedFiles() {
        ArrayList<UploadFile> arrayList = this.f;
        int i = 0;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getSuccessfullyUploaded() && (i = i + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i;
    }

    public final long getTotalBytes() {
        return this.d;
    }

    @NotNull
    public final String getUploadId() {
        return this.a;
    }

    @NotNull
    public final UploadRate getUploadRate() {
        double d2;
        int totalSeconds = getElapsedTime().getTotalSeconds();
        if (totalSeconds < 1) {
            d2 = 0.0d;
        } else {
            d2 = ((((double) this.c) / ((double) 1000)) * ((double) 8)) / ((double) totalSeconds);
        }
        if (d2 < ((double) 1)) {
            return new UploadRate((int) (d2 * ((double) 1000)), UploadRate.UploadRateUnit.BitPerSecond);
        }
        double d3 = (double) 1000;
        if (d2 >= d3) {
            return new UploadRate((int) (d2 / d3), UploadRate.UploadRateUnit.MegabitPerSecond);
        }
        return new UploadRate((int) d2, UploadRate.UploadRateUnit.KilobitPerSecond);
    }

    public final long getUploadedBytes() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.b;
        long j2 = this.c;
        long j3 = this.d;
        int i2 = ((((((((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.e) * 31;
        ArrayList<UploadFile> arrayList = this.f;
        if (arrayList != null) {
            i = arrayList.hashCode();
        }
        return i2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("UploadInfo(uploadId=");
        L.append(this.a);
        L.append(", startTime=");
        L.append(this.b);
        L.append(", uploadedBytes=");
        L.append(this.c);
        L.append(", totalBytes=");
        L.append(this.d);
        L.append(", numberOfRetries=");
        L.append(this.e);
        L.append(", files=");
        L.append(this.f);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeLong(this.d);
        parcel.writeInt(this.e);
        ArrayList<UploadFile> arrayList = this.f;
        parcel.writeInt(arrayList.size());
        for (UploadFile uploadFile : arrayList) {
            uploadFile.writeToParcel(parcel, 0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadInfo(String str, long j, long j2, long j3, int i, ArrayList arrayList, int i2, j jVar) {
        this(str, (i2 & 2) != 0 ? 0 : j, (i2 & 4) != 0 ? 0 : j2, (i2 & 8) == 0 ? j3 : 0, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? new ArrayList() : arrayList);
    }
}
