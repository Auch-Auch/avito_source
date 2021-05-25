package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "VideoOptionsParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzaac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaac> CREATOR = new zzaab();
    @SafeParcelable.Field(id = 2)
    public final boolean zzadr;
    @SafeParcelable.Field(id = 3)
    public final boolean zzads;
    @SafeParcelable.Field(id = 4)
    public final boolean zzadt;

    public zzaac(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzadr);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzads);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzadt);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzaac(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) boolean z3) {
        this.zzadr = z;
        this.zzads = z2;
        this.zzadt = z3;
    }
}
