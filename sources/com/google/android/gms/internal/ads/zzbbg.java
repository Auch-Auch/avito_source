package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "VersionInfoParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzbbg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbbg> CREATOR = new zzbbj();
    @SafeParcelable.Field(id = 2)
    public String zzbra;
    @SafeParcelable.Field(id = 3)
    public int zzedq;
    @SafeParcelable.Field(id = 4)
    public int zzedr;
    @SafeParcelable.Field(id = 5)
    public boolean zzeds;
    @SafeParcelable.Field(id = 6)
    public boolean zzedt;

    public zzbbg(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public static zzbbg zzyr() {
        return new zzbbg(12451009, 12451009, true);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbra, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzedq);
        SafeParcelWriter.writeInt(parcel, 4, this.zzedr);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzeds);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzedt);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzbbg(int i, int i2, boolean z, boolean z2) {
        this(i, i2, true, false, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzbbg(int r8, int r9, boolean r10, boolean r11, boolean r12) {
        /*
            r7 = this;
            if (r10 == 0) goto L_0x0005
            java.lang.String r11 = "0"
            goto L_0x0007
        L_0x0005:
            java.lang.String r11 = "1"
        L_0x0007:
            int r12 = r11.length()
            int r12 = r12 + 36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            java.lang.String r12 = "afma-sdk-a-v"
            r0.append(r12)
            r0.append(r8)
            java.lang.String r12 = "."
            r0.append(r12)
            r0.append(r9)
            java.lang.String r2 = a2.b.a.a.a.t(r0, r12, r11)
            r6 = 0
            r1 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbg.<init>(int, int, boolean, boolean, boolean):void");
    }

    @SafeParcelable.Constructor
    public zzbbg(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) boolean z2) {
        this.zzbra = str;
        this.zzedq = i;
        this.zzedr = i2;
        this.zzeds = z;
        this.zzedt = z2;
    }
}
