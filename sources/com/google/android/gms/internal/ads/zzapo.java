package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "RtbVersionInfoParcelCreator")
public final class zzapo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzapo> CREATOR = new zzapn();
    @SafeParcelable.Field(id = 1)
    private final int major;
    @SafeParcelable.Field(id = 2)
    private final int minor;
    @SafeParcelable.Field(id = 3)
    private final int zzdlw;

    @SafeParcelable.Constructor
    public zzapo(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3) {
        this.major = i;
        this.minor = i2;
        this.zzdlw = i3;
    }

    public static zzapo zza(VersionInfo versionInfo) {
        return new zzapo(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzapo)) {
            zzapo zzapo = (zzapo) obj;
            if (zzapo.zzdlw == this.zzdlw && zzapo.minor == this.minor && zzapo.major == this.major) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new int[]{this.major, this.minor, this.zzdlw});
    }

    @Override // java.lang.Object
    public final String toString() {
        int i = this.major;
        int i2 = this.minor;
        int i3 = this.zzdlw;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.major);
        SafeParcelWriter.writeInt(parcel, 2, this.minor);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdlw);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
