package com.google.android.gms.internal.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RemoteViews;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@ShowFirstParty
@SafeParcelable.Class(creator = "GetSaveInstrumentDetailsResponseCreator")
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzp();
    @SafeParcelable.Field(id = 1)
    private String[] zzem;
    @SafeParcelable.Field(id = 2)
    private int[] zzen;
    @SafeParcelable.Field(id = 3)
    private RemoteViews zzeo;
    @SafeParcelable.Field(id = 4)
    private byte[] zzep;

    @SafeParcelable.Constructor
    public zzm(@SafeParcelable.Param(id = 1) String[] strArr, @SafeParcelable.Param(id = 2) int[] iArr, @SafeParcelable.Param(id = 3) RemoteViews remoteViews, @SafeParcelable.Param(id = 4) byte[] bArr) {
        this.zzem = strArr;
        this.zzen = iArr;
        this.zzeo = remoteViews;
        this.zzep = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.zzem, false);
        SafeParcelWriter.writeIntArray(parcel, 2, this.zzen, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzeo, i, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzep, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private zzm() {
    }
}
