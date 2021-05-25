package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import kotlinx.coroutines.DebugKt;
public final class zzczv implements zzdek<Bundle> {
    private final String zzacx;
    private final zzvj zzbpb;
    private final float zzbrw;
    private final boolean zzchp;
    private final int zzdng;
    private final int zzdnh;
    private final String zzgsm;
    private final String zzgsn;
    private final boolean zzgso;

    public zzczv(zzvj zzvj, String str, boolean z, String str2, float f, int i, int i2, String str3, boolean z2) {
        Preconditions.checkNotNull(zzvj, "the adSize must not be null");
        this.zzbpb = zzvj;
        this.zzacx = str;
        this.zzchp = z;
        this.zzgsm = str2;
        this.zzbrw = f;
        this.zzdng = i;
        this.zzdnh = i2;
        this.zzgsn = str3;
        this.zzgso = z2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdlu.zza(bundle2, "smart_w", MessengerShareContentUtility.WEBVIEW_RATIO_FULL, this.zzbpb.width == -1);
        zzdlu.zza(bundle2, "smart_h", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, this.zzbpb.height == -2);
        Boolean bool = Boolean.TRUE;
        zzdlu.zza(bundle2, "ene", bool, this.zzbpb.zzchq);
        zzdlu.zza(bundle2, "rafmt", "102", this.zzbpb.zzcht);
        zzdlu.zza(bundle2, "rafmt", "103", this.zzbpb.zzchu);
        zzdlu.zza(bundle2, "inline_adaptive_slot", bool, this.zzgso);
        zzdlu.zza(bundle2, "format", this.zzacx);
        zzdlu.zza(bundle2, "fluid", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.zzchp);
        String str = this.zzgsm;
        zzdlu.zza(bundle2, "sz", str, !TextUtils.isEmpty(str));
        bundle2.putFloat("u_sd", this.zzbrw);
        bundle2.putInt("sw", this.zzdng);
        bundle2.putInt("sh", this.zzdnh);
        String str2 = this.zzgsn;
        zzdlu.zza(bundle2, "sc", str2, true ^ TextUtils.isEmpty(str2));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        zzvj[] zzvjArr = this.zzbpb.zzcho;
        if (zzvjArr == null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.zzbpb.height);
            bundle3.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.zzbpb.width);
            bundle3.putBoolean("is_fluid_height", this.zzbpb.zzchp);
            arrayList.add(bundle3);
        } else {
            for (zzvj zzvj : zzvjArr) {
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean("is_fluid_height", zzvj.zzchp);
                bundle4.putInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, zzvj.height);
                bundle4.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, zzvj.width);
                arrayList.add(bundle4);
            }
        }
        bundle2.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
