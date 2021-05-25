package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010 B\u0011\b\u0012\u0012\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ$\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001e\u0010\r¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/PhoneConfirmationStatus;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()J", "component2", "lastTryTime", "nextTryTime", "copy", "(JJ)Lcom/avito/android/remote/model/PhoneConfirmationStatus;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getNextTryTime", "getLastTryTime", "<init>", "(JJ)V", "parcel", "(Landroid/os/Parcel;)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmationStatus implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<PhoneConfirmationStatus> CREATOR = Parcels.creator(PhoneConfirmationStatus$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("lastTryTime")
    private final long lastTryTime;
    @SerializedName("nextTryTime")
    private final long nextTryTime;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/PhoneConfirmationStatus$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/PhoneConfirmationStatus;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public PhoneConfirmationStatus(long j, long j2) {
        this.lastTryTime = j;
        this.nextTryTime = j2;
    }

    public static /* synthetic */ PhoneConfirmationStatus copy$default(PhoneConfirmationStatus phoneConfirmationStatus, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = phoneConfirmationStatus.lastTryTime;
        }
        if ((i & 2) != 0) {
            j2 = phoneConfirmationStatus.nextTryTime;
        }
        return phoneConfirmationStatus.copy(j, j2);
    }

    public final long component1() {
        return this.lastTryTime;
    }

    public final long component2() {
        return this.nextTryTime;
    }

    @NotNull
    public final PhoneConfirmationStatus copy(long j, long j2) {
        return new PhoneConfirmationStatus(j, j2);
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
        if (!(obj instanceof PhoneConfirmationStatus)) {
            return false;
        }
        PhoneConfirmationStatus phoneConfirmationStatus = (PhoneConfirmationStatus) obj;
        return this.lastTryTime == phoneConfirmationStatus.lastTryTime && this.nextTryTime == phoneConfirmationStatus.nextTryTime;
    }

    public final long getLastTryTime() {
        return this.lastTryTime;
    }

    public final long getNextTryTime() {
        return this.nextTryTime;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (c.a(this.lastTryTime) * 31) + c.a(this.nextTryTime);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PhoneConfirmationStatus(lastTryTime=");
        L.append(this.lastTryTime);
        L.append(", nextTryTime=");
        return a.l(L, this.nextTryTime, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(this.lastTryTime);
        parcel.writeLong(this.nextTryTime);
    }

    public /* synthetic */ PhoneConfirmationStatus(Parcel parcel, j jVar) {
        this(parcel);
    }

    private PhoneConfirmationStatus(Parcel parcel) {
        this(parcel.readLong(), parcel.readLong());
    }
}
