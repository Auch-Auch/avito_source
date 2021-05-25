package com.google.mlkit.vision.common.internal;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@KeepForSdk
@SafeParcelable.Class(creator = "VisionImageMetadataParcelCreator")
public class VisionImageMetadataParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VisionImageMetadataParcel> CREATOR = new zze();
    @SafeParcelable.Field(id = 3)
    public final int a;
    @KeepForSdk
    @SafeParcelable.Field(id = 2)
    public final int height;
    @KeepForSdk
    @SafeParcelable.Field(id = 5)
    public final int rotation;
    @KeepForSdk
    @SafeParcelable.Field(id = 4)
    public final long timestampMillis;
    @KeepForSdk
    @SafeParcelable.Field(id = 1)
    public final int width;

    @SafeParcelable.Constructor
    public VisionImageMetadataParcel(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) long j, @SafeParcelable.Param(id = 5) int i4) {
        this.width = i;
        this.height = i2;
        this.a = i3;
        this.timestampMillis = j;
        this.rotation = i4;
    }

    @Nullable
    @KeepForSdk
    public Matrix getUprightRotationMatrix() {
        if (this.rotation == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate(((float) (-this.width)) / 2.0f, ((float) (-this.height)) / 2.0f);
        matrix.postRotate((float) (this.rotation * 90));
        boolean z = this.rotation % 2 != 0;
        matrix.postTranslate(((float) (z ? this.height : this.width)) / 2.0f, ((float) (z ? this.width : this.height)) / 2.0f);
        return matrix;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.width);
        SafeParcelWriter.writeInt(parcel, 2, this.height);
        SafeParcelWriter.writeInt(parcel, 3, this.a);
        SafeParcelWriter.writeLong(parcel, 4, this.timestampMillis);
        SafeParcelWriter.writeInt(parcel, 5, this.rotation);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
