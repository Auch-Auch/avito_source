package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "DynamicLinkDataCreator")
public class DynamicLinkData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DynamicLinkData> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getDynamicLink", id = 1)
    public String a;
    @SafeParcelable.Field(getter = "getDeepLink", id = 2)
    public String b;
    @SafeParcelable.Field(getter = "getMinVersion", id = 3)
    public int c;
    @SafeParcelable.Field(getter = "getClickTimestamp", id = 4)
    public long d = 0;
    @SafeParcelable.Field(getter = "getExtensionBundle", id = 5)
    public Bundle e = null;
    @SafeParcelable.Field(getter = "getRedirectUrl", id = 6)
    public Uri f;

    @SafeParcelable.Constructor
    public DynamicLinkData(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) long j, @SafeParcelable.Param(id = 5) Bundle bundle, @SafeParcelable.Param(id = 6) Uri uri) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = j;
        this.e = bundle;
        this.f = uri;
    }

    public final long getClickTimestamp() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.a, false);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.writeInt(parcel, 3, this.c);
        SafeParcelWriter.writeLong(parcel, 4, this.d);
        SafeParcelWriter.writeBundle(parcel, 5, zzf(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final void zza(long j) {
        this.d = j;
    }

    public final Uri zzc() {
        return this.f;
    }

    public final String zzd() {
        return this.b;
    }

    public final int zze() {
        return this.c;
    }

    public final Bundle zzf() {
        Bundle bundle = this.e;
        return bundle == null ? new Bundle() : bundle;
    }
}
