package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbhb;
import com.google.android.gms.internal.ads.zzbhd;
@TargetApi(17)
public final class zzbgp<WebViewT extends zzbgt & zzbhb & zzbhd> {
    private final zzbgq zzepj;
    private final WebViewT zzepk;

    private zzbgp(WebViewT webviewt, zzbgq zzbgq) {
        this.zzepj = zzbgq;
        this.zzepk = webviewt;
    }

    public static zzbgp<zzbfq> zzc(zzbfq zzbfq) {
        return new zzbgp<>(zzbfq, new zzbgq(zzbfq) { // from class: com.google.android.gms.internal.ads.zzbgo
            private final zzbfq zzepi;

            {
                this.zzepi = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbgq
            public final void zzh(Uri uri) {
                zzbhc zzabe = this.zzepi.zzabe();
                if (zzabe == null) {
                    zzbbd.zzfc("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
                } else {
                    zzabe.zzh(uri);
                }
            }
        });
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zzaxy.zzei("Click string is empty, not proceeding.");
            return "";
        }
        zzeg zzabh = this.zzepk.zzabh();
        if (zzabh == null) {
            zzaxy.zzei("Signal utils is empty, ignoring.");
            return "";
        }
        zzdw zzca = zzabh.zzca();
        if (zzca == null) {
            zzaxy.zzei("Signals object is empty, ignoring.");
            return "";
        } else if (this.zzepk.getContext() != null) {
            return zzca.zza(this.zzepk.getContext(), str, this.zzepk.getView(), this.zzepk.zzzq());
        } else {
            zzaxy.zzei("Context is null, ignoring.");
            return "";
        }
    }

    @JavascriptInterface
    public final void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzbbd.zzfe("URL is empty, ignoring message");
        } else {
            zzayh.zzeaj.post(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzbgr
                private final String zzdft;
                private final zzbgp zzepl;

                {
                    this.zzepl = r1;
                    this.zzdft = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzepl.zzfu(this.zzdft);
                }
            });
        }
    }

    public final /* synthetic */ void zzfu(String str) {
        this.zzepj.zzh(Uri.parse(str));
    }
}
