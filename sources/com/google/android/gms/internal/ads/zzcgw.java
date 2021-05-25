package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;
public final class zzcgw extends zzaer {
    private final Context zzaai;
    private final zzccv zzfvt;
    private zzcco zzfyz;
    private zzcdr zzgch;

    public zzcgw(Context context, zzccv zzccv, zzcdr zzcdr, zzcco zzcco) {
        this.zzaai = context;
        this.zzfvt = zzccv;
        this.zzgch = zzcdr;
        this.zzfyz = zzcco;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final void destroy() {
        zzcco zzcco = this.zzfyz;
        if (zzcco != null) {
            zzcco.destroy();
        }
        this.zzfyz = null;
        this.zzgch = null;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final List<String> getAvailableAssetNames() {
        SimpleArrayMap<String, zzadi> zzalv = this.zzfvt.zzalv();
        SimpleArrayMap<String, String> zzalx = this.zzfvt.zzalx();
        String[] strArr = new String[(zzalx.size() + zzalv.size())];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < zzalv.size()) {
            strArr[i3] = zzalv.keyAt(i2);
            i2++;
            i3++;
        }
        while (i < zzalx.size()) {
            strArr[i3] = zzalx.keyAt(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final String getCustomTemplateId() {
        return this.zzfvt.getCustomTemplateId();
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final zzyg getVideoController() {
        return this.zzfvt.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final void performClick(String str) {
        zzcco zzcco = this.zzfyz;
        if (zzcco != null) {
            zzcco.zzfz(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final void recordImpression() {
        zzcco zzcco = this.zzfyz;
        if (zzcco != null) {
            zzcco.zzalc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final String zzcx(String str) {
        return this.zzfvt.zzalx().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final zzadw zzcy(String str) {
        return this.zzfvt.zzalv().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final boolean zzp(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup)) {
            return false;
        }
        zzcdr zzcdr = this.zzgch;
        if (!(zzcdr != null && zzcdr.zza((ViewGroup) unwrap))) {
            return false;
        }
        this.zzfvt.zzals().zza(new zzcgv(this));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final void zzq(IObjectWrapper iObjectWrapper) {
        zzcco zzcco;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzfvt.zzalu() != null && (zzcco = this.zzfyz) != null) {
            zzcco.zzaa((View) unwrap);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final IObjectWrapper zzsg() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final IObjectWrapper zzsl() {
        return ObjectWrapper.wrap(this.zzaai);
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final boolean zzsm() {
        zzcco zzcco = this.zzfyz;
        if ((zzcco == null || zzcco.zzalj()) && this.zzfvt.zzalt() != null && this.zzfvt.zzals() == null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final boolean zzsn() {
        IObjectWrapper zzalu = this.zzfvt.zzalu();
        if (zzalu != null) {
            zzp.zzle().zzab(zzalu);
            return true;
        }
        zzbbd.zzfe("Trying to start OMID session before creation.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final void zzso() {
        String zzalw = this.zzfvt.zzalw();
        if ("Google".equals(zzalw)) {
            zzbbd.zzfe("Illegal argument specified for omid partner name.");
            return;
        }
        zzcco zzcco = this.zzfyz;
        if (zzcco != null) {
            zzcco.zzh(zzalw, false);
        }
    }
}
