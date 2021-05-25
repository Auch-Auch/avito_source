package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.DateTimeParameterKt;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "FaceSettingsParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zze();
    @SafeParcelable.Field(id = 3)
    public int landmarkType;
    @SafeParcelable.Field(id = 2)
    public int mode;
    @SafeParcelable.Field(defaultValue = DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME, id = 7)
    public float proportionalMinFaceSize;
    @SafeParcelable.Field(id = 6)
    public boolean trackingEnabled;
    @SafeParcelable.Field(id = 5)
    public boolean zzcv;
    @SafeParcelable.Field(id = 4)
    public int zzcw;

    public zzf() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.mode);
        SafeParcelWriter.writeInt(parcel, 3, this.landmarkType);
        SafeParcelWriter.writeInt(parcel, 4, this.zzcw);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzcv);
        SafeParcelWriter.writeBoolean(parcel, 6, this.trackingEnabled);
        SafeParcelWriter.writeFloat(parcel, 7, this.proportionalMinFaceSize);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzf(@SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) boolean z2, @SafeParcelable.Param(id = 7) float f) {
        this.mode = i;
        this.landmarkType = i2;
        this.zzcw = i3;
        this.zzcv = z;
        this.trackingEnabled = z2;
        this.proportionalMinFaceSize = f;
    }
}
