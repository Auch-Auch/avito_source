package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "AdValueParcelCreator")
public final class zzvl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvl> CREATOR = new zzvk();
    @SafeParcelable.Field(id = 1)
    public final int type;
    @SafeParcelable.Field(id = 2)
    public final int zzadb;
    @SafeParcelable.Field(id = 3)
    public final String zzadc;
    @SafeParcelable.Field(id = 4)
    public final long zzadd;

    @SafeParcelable.Constructor
    public zzvl(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) long j) {
        this.type = i;
        this.zzadb = i2;
        this.zzadc = str;
        this.zzadd = j;
    }

    public static zzvl zza(JSONObject jSONObject) throws JSONException {
        return new zzvl(jSONObject.getInt("type_num"), jSONObject.getInt("precision_num"), jSONObject.getString(FirebaseAnalytics.Param.CURRENCY), jSONObject.getLong("value"));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.type);
        SafeParcelWriter.writeInt(parcel, 2, this.zzadb);
        SafeParcelWriter.writeString(parcel, 3, this.zzadc, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzadd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
