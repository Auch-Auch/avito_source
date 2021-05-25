package com.google.android.gms.ads.internal;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaac;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzace;
import com.google.android.gms.internal.ads.zzaqv;
import com.google.android.gms.internal.ads.zzarb;
import com.google.android.gms.internal.ads.zzatt;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbg;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzeg;
import com.google.android.gms.internal.ads.zzsi;
import com.google.android.gms.internal.ads.zzvc;
import com.google.android.gms.internal.ads.zzvj;
import com.google.android.gms.internal.ads.zzvm;
import com.google.android.gms.internal.ads.zzwe;
import com.google.android.gms.internal.ads.zzwg;
import com.google.android.gms.internal.ads.zzwl;
import com.google.android.gms.internal.ads.zzwx;
import com.google.android.gms.internal.ads.zzxb;
import com.google.android.gms.internal.ads.zzxc;
import com.google.android.gms.internal.ads.zzxi;
import com.google.android.gms.internal.ads.zzya;
import com.google.android.gms.internal.ads.zzyf;
import com.google.android.gms.internal.ads.zzyg;
import com.google.android.gms.internal.ads.zzym;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzj extends zzwx {
    private final zzbbg zzbpa;
    private final zzvj zzbpb;
    private final Future<zzeg> zzbpc = zzbbi.zzedu.zze(new zzo(this));
    private final zzq zzbpd;
    @Nullable
    private WebView zzbpe;
    @Nullable
    private zzwl zzbpf;
    @Nullable
    private zzeg zzbpg;
    private AsyncTask<Void, Void, String> zzbph;
    private final Context zzvr;

    public zzj(Context context, zzvj zzvj, String str, zzbbg zzbbg) {
        this.zzvr = context;
        this.zzbpa = zzbbg;
        this.zzbpb = zzvj;
        this.zzbpe = new WebView(context);
        this.zzbpd = new zzq(context, str);
        zzbt(0);
        this.zzbpe.setVerticalScrollBarEnabled(false);
        this.zzbpe.getSettings().setJavaScriptEnabled(true);
        this.zzbpe.setWebViewClient(new zzm(this));
        this.zzbpe.setOnTouchListener(new zzl(this));
    }

    /* access modifiers changed from: private */
    public final String zzbr(String str) {
        if (this.zzbpg == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.zzbpg.zza(parse, this.zzvr, null, null);
        } catch (zzef e) {
            zzbbd.zzd("Unable to process ad data", e);
        }
        return parse.toString();
    }

    /* access modifiers changed from: private */
    public final void zzbs(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.zzvr.startActivity(intent);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzbph.cancel(true);
        this.zzbpc.cancel(true);
        this.zzbpe.destroy();
        this.zzbpe = null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final Bundle getAdMetadata() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    @Nullable
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    @Nullable
    public final zzyg getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void pause() throws RemoteException {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void resume() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void setUserId(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void showInterstitial() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void stopLoading() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzya zzya) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final boolean zza(zzvc zzvc) throws RemoteException {
        Preconditions.checkNotNull(this.zzbpe, "This Search Ad has already been torn down");
        this.zzbpd.zza(zzvc, this.zzbpa);
        this.zzbph = new zzn(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzbp(String str) {
        throw new IllegalStateException("Unused method");
    }

    @VisibleForTesting
    public final int zzbq(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzwe.zzpq();
            return zzbat.zzc(this.zzvr, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @VisibleForTesting
    public final void zzbt(int i) {
        if (this.zzbpe != null) {
            this.zzbpe.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final IObjectWrapper zzkc() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzbpe);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzkd() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final zzvj zzke() throws RemoteException {
        return this.zzbpb;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    @Nullable
    public final String zzkf() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    @Nullable
    public final zzyf zzkg() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final zzxc zzkh() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final zzwl zzki() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @VisibleForTesting
    public final String zzkj() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath(zzace.zzczm.get());
        builder.appendQueryParameter("query", this.zzbpd.getQuery());
        builder.appendQueryParameter("pubId", this.zzbpd.zzlp());
        Map<String, String> zzlq = this.zzbpd.zzlq();
        for (String str : zzlq.keySet()) {
            builder.appendQueryParameter(str, zzlq.get(str));
        }
        Uri build = builder.build();
        zzeg zzeg = this.zzbpg;
        if (zzeg != null) {
            try {
                build = zzeg.zza(build, this.zzvr);
            } catch (zzef e) {
                zzbbd.zzd("Unable to process ad data", e);
            }
        }
        String zzkk = zzkk();
        String encodedQuery = build.getEncodedQuery();
        return a.s2(a.q0(encodedQuery, a.q0(zzkk, 1)), zzkk, "#", encodedQuery);
    }

    @VisibleForTesting
    public final String zzkk() {
        String zzlo = this.zzbpd.zzlo();
        if (TextUtils.isEmpty(zzlo)) {
            zzlo = "www.google.com";
        }
        String str = zzace.zzczm.get();
        return a.s2(a.q0(str, a.q0(zzlo, 8)), "https://", zzlo, str);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzwl zzwl) throws RemoteException {
        this.zzbpf = zzwl;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzxc zzxc) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzxb zzxb) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzvj zzvj) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzaqv zzaqv) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzarb zzarb, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzabq zzabq) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzwg zzwg) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzxi zzxi) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzatt zzatt) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzaac zzaac) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzym zzym) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzvm zzvm) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzsi zzsi) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }
}
