package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
public final class zzmm extends zzmj {
    public static final Parcelable.Creator<zzmm> CREATOR = new zzml();
    private final String description;
    private final String value;

    public zzmm(String str, String str2, String str3) {
        super(str);
        this.description = null;
        this.value = str3;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmm.class == obj.getClass()) {
            zzmm zzmm = (zzmm) obj;
            if (this.zzagt.equals(zzmm.zzagt) && zzpq.zza(this.description, zzmm.description) && zzpq.zza(this.value, zzmm.value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        int B0 = a.B0(this.zzagt, 527, 31);
        String str = this.description;
        int i = 0;
        int hashCode = (B0 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzagt);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }

    public zzmm(Parcel parcel) {
        super(parcel.readString());
        this.description = parcel.readString();
        this.value = parcel.readString();
    }
}
