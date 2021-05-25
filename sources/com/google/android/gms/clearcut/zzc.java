package com.google.android.gms.clearcut;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "CollectForDebugParcelableCreator")
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzd();
    @SafeParcelable.Field(defaultValue = "false", id = 1)
    private final boolean zzad;
    @SafeParcelable.Field(id = 3)
    private final long zzae;
    @SafeParcelable.Field(id = 2)
    private final long zzaf;

    @SafeParcelable.Constructor
    public zzc(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 2) long j2) {
        this.zzad = z;
        this.zzae = j;
        this.zzaf = j2;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzc) {
            zzc zzc = (zzc) obj;
            if (this.zzad == zzc.zzad && this.zzae == zzc.zzae && this.zzaf == zzc.zzaf) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zzad), Long.valueOf(this.zzae), Long.valueOf(this.zzaf));
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder sb = new StringBuilder("CollectForDebugParcelable[skipPersistentStorage: ");
        sb.append(this.zzad);
        sb.append(",collectForDebugStartTimeMillis: ");
        sb.append(this.zzae);
        sb.append(",collectForDebugExpiryTimeMillis: ");
        return a.l(sb, this.zzaf, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzad);
        SafeParcelWriter.writeLong(parcel, 2, this.zzaf);
        SafeParcelWriter.writeLong(parcel, 3, this.zzae);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
