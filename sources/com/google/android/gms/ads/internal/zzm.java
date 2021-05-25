package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzbbd;
public final class zzm extends WebViewClient {
    private final /* synthetic */ zzj zzbpi;

    public zzm(zzj zzj) {
        this.zzbpi = zzj;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.zzbpi.zzbpf != null) {
            try {
                this.zzbpi.zzbpf.onAdFailedToLoad(0);
            } catch (RemoteException e) {
                zzbbd.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.zzbpi.zzkk())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            if (this.zzbpi.zzbpf != null) {
                try {
                    this.zzbpi.zzbpf.onAdFailedToLoad(3);
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
            this.zzbpi.zzbt(0);
            return true;
        } else if (str.startsWith("gmsg://scriptLoadFailed")) {
            if (this.zzbpi.zzbpf != null) {
                try {
                    this.zzbpi.zzbpf.onAdFailedToLoad(0);
                } catch (RemoteException e2) {
                    zzbbd.zze("#007 Could not call remote method.", e2);
                }
            }
            this.zzbpi.zzbt(0);
            return true;
        } else if (str.startsWith("gmsg://adResized")) {
            if (this.zzbpi.zzbpf != null) {
                try {
                    this.zzbpi.zzbpf.onAdLoaded();
                } catch (RemoteException e3) {
                    zzbbd.zze("#007 Could not call remote method.", e3);
                }
            }
            this.zzbpi.zzbt(this.zzbpi.zzbq(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            if (this.zzbpi.zzbpf != null) {
                try {
                    this.zzbpi.zzbpf.onAdLeftApplication();
                } catch (RemoteException e4) {
                    zzbbd.zze("#007 Could not call remote method.", e4);
                }
            }
            this.zzbpi.zzbs(this.zzbpi.zzbr(str));
            return true;
        }
    }
}
