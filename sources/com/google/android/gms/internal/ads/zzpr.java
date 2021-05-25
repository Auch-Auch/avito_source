package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
public final class zzpr implements Parcelable {
    public static final Parcelable.Creator<zzpr> CREATOR = new zzpu();
    private int zzahr;
    public final int zzars;
    public final int zzart;
    public final int zzaru;
    public final byte[] zzbkn;

    public zzpr(int i, int i2, int i3, byte[] bArr) {
        this.zzars = i;
        this.zzaru = i2;
        this.zzart = i3;
        this.zzbkn = bArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzpr.class == obj.getClass()) {
            zzpr zzpr = (zzpr) obj;
            if (this.zzars == zzpr.zzars && this.zzaru == zzpr.zzaru && this.zzart == zzpr.zzart && Arrays.equals(this.zzbkn, zzpr.zzbkn)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        if (this.zzahr == 0) {
            this.zzahr = Arrays.hashCode(this.zzbkn) + ((((((this.zzars + 527) * 31) + this.zzaru) * 31) + this.zzart) * 31);
        }
        return this.zzahr;
    }

    @Override // java.lang.Object
    public final String toString() {
        int i = this.zzars;
        int i2 = this.zzaru;
        int i3 = this.zzart;
        boolean z = this.zzbkn != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzars);
        parcel.writeInt(this.zzaru);
        parcel.writeInt(this.zzart);
        parcel.writeInt(this.zzbkn != null ? 1 : 0);
        byte[] bArr = this.zzbkn;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    public zzpr(Parcel parcel) {
        this.zzars = parcel.readInt();
        this.zzaru = parcel.readInt();
        this.zzart = parcel.readInt();
        this.zzbkn = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }
}
