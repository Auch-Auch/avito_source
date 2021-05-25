package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
@SafeParcelable.Class(creator = "SafeBrowsingConfigParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzavt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzavt> CREATOR = new zzavs();
    @SafeParcelable.Field(id = 2)
    public final String zzdwh;
    @SafeParcelable.Field(id = 3)
    public final String zzdwi;
    @SafeParcelable.Field(id = 4)
    public final boolean zzdwj;
    @SafeParcelable.Field(id = 5)
    public final boolean zzdwk;
    @SafeParcelable.Field(id = 6)
    public final List<String> zzdwl;
    @SafeParcelable.Field(id = 7)
    public final boolean zzdwm;
    @SafeParcelable.Field(id = 8)
    public final boolean zzdwn;
    @SafeParcelable.Field(id = 9)
    public final List<String> zzdwo;

    @SafeParcelable.Constructor
    public zzavt(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 7) boolean z3, @SafeParcelable.Param(id = 8) boolean z4, @SafeParcelable.Param(id = 9) List<String> list2) {
        this.zzdwh = str;
        this.zzdwi = str2;
        this.zzdwj = z;
        this.zzdwk = z2;
        this.zzdwl = list;
        this.zzdwm = z3;
        this.zzdwn = z4;
        this.zzdwo = list2 == null ? new ArrayList<>() : list2;
    }

    @Nullable
    public static zzavt zzg(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        return new zzavt(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zzbab.zza(jSONObject.optJSONArray("allowed_headers"), (List<String>) null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zzbab.zza(jSONObject.optJSONArray("webview_permissions"), (List<String>) null));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdwh, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdwi, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzdwj);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzdwk);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdwl, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzdwm);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdwn);
        SafeParcelWriter.writeStringList(parcel, 9, this.zzdwo, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
