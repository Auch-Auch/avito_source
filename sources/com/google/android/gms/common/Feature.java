package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.avito.android.remote.model.category_parameters.DateTimeParameterKt;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@KeepForSdk
@SafeParcelable.Class(creator = "FeatureCreator")
public class Feature extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Feature> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getName", id = 1)
    private final String zza;
    @SafeParcelable.Field(getter = "getOldVersion", id = 2)
    @Deprecated
    private final int zzb;
    @SafeParcelable.Field(defaultValue = DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME, getter = "getVersion", id = 3)
    private final long zzc;

    @KeepForSdk
    public Feature(@RecentlyNonNull String str, @RecentlyNonNull long j) {
        this.zza = str;
        this.zzc = j;
        this.zzb = -1;
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((getName() != null && getName().equals(feature.getName())) || (getName() == null && feature.getName() == null)) && getVersion() == feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    @RecentlyNonNull
    @KeepForSdk
    public String getName() {
        return this.zza;
    }

    @RecentlyNonNull
    @KeepForSdk
    public long getVersion() {
        long j = this.zzc;
        return j == -1 ? (long) this.zzb : j;
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public int hashCode() {
        return Objects.hashCode(getName(), Long.valueOf(getVersion()));
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public String toString() {
        return Objects.toStringHelper(this).add("name", getName()).add("version", Long.valueOf(getVersion())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeLong(parcel, 3, getVersion());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public Feature(@RecentlyNonNull @SafeParcelable.Param(id = 1) String str, @RecentlyNonNull @SafeParcelable.Param(id = 2) int i, @RecentlyNonNull @SafeParcelable.Param(id = 3) long j) {
        this.zza = str;
        this.zzb = i;
        this.zzc = j;
    }
}
