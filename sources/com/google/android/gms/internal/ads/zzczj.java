package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;
public final class zzczj implements zzdek<Bundle> {
    private final zzvj zzbpb;
    private final List<Parcelable> zzgsg;
    private final Context zzvr;

    public zzczj(Context context, zzvj zzvj, List<Parcelable> list) {
        this.zzvr = context;
        this.zzbpb = zzvj;
        this.zzgsg = list;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (zzacq.zzdbc.get().booleanValue()) {
            Bundle bundle3 = new Bundle();
            zzp.zzkp();
            bundle3.putString("activity", zzayh.zzau(this.zzvr));
            Bundle bundle4 = new Bundle();
            bundle4.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.zzbpb.width);
            bundle4.putInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.zzbpb.height);
            bundle3.putBundle("size", bundle4);
            if (this.zzgsg.size() > 0) {
                List<Parcelable> list = this.zzgsg;
                bundle3.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle2.putBundle("view_hierarchy", bundle3);
        }
    }
}
