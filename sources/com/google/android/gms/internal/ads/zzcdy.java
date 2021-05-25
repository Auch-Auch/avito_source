package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.messaging.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
public final class zzcdy implements View.OnClickListener {
    private final Clock zzbpw;
    private final zzchc zzfzs;
    @Nullable
    private zzafr zzfzt;
    @Nullable
    private zzahf<Object> zzfzu;
    @Nullable
    @VisibleForTesting
    public String zzfzv;
    @Nullable
    @VisibleForTesting
    public Long zzfzw;
    @Nullable
    @VisibleForTesting
    public WeakReference<View> zzfzx;

    public zzcdy(zzchc zzchc, Clock clock) {
        this.zzfzs = zzchc;
        this.zzbpw = clock;
    }

    private final void zzamx() {
        View view;
        this.zzfzv = null;
        this.zzfzw = null;
        WeakReference<View> weakReference = this.zzfzx;
        if (weakReference != null && (view = weakReference.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener(null);
            this.zzfzx = null;
        }
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzfzt != null && this.zzfzw != null) {
            zzamx();
            try {
                this.zzfzt.onUnconfirmedClickCancelled();
            } catch (RemoteException e) {
                zzbbd.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WeakReference<View> weakReference = this.zzfzx;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.zzfzv == null || this.zzfzw == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zzfzv);
                hashMap.put(SDKConstants.PARAM_A2U_TIME_INTERVAL, String.valueOf(this.zzbpw.currentTimeMillis() - this.zzfzw.longValue()));
                hashMap.put(Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, "onePointFiveClick");
                this.zzfzs.zza("sendMessageToNativeJs", hashMap);
            }
            zzamx();
        }
    }

    public final void zza(zzafr zzafr) {
        this.zzfzt = zzafr;
        zzahf<Object> zzahf = this.zzfzu;
        if (zzahf != null) {
            this.zzfzs.zzb("/unconfirmedClick", zzahf);
        }
        zzcdx zzcdx = new zzahf(this, zzafr) { // from class: com.google.android.gms.internal.ads.zzcdx
            private final zzcdy zzfzq;
            private final zzafr zzfzr;

            {
                this.zzfzq = r1;
                this.zzfzr = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzahf
            public final void zza(Object obj, Map map) {
                zzcdy zzcdy = this.zzfzq;
                zzafr zzafr2 = this.zzfzr;
                try {
                    zzcdy.zzfzw = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
                } catch (NumberFormatException unused) {
                    zzbbd.zzfc("Failed to call parse unconfirmedClickTimestamp.");
                }
                zzcdy.zzfzv = (String) map.get("id");
                String str = (String) map.get("asset_id");
                if (zzafr2 == null) {
                    zzbbd.zzef("Received unconfirmed click but UnconfirmedClickListener is null.");
                    return;
                }
                try {
                    zzafr2.onUnconfirmedClickReceived(str);
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
        };
        this.zzfzu = zzcdx;
        this.zzfzs.zza("/unconfirmedClick", zzcdx);
    }

    @Nullable
    public final zzafr zzamw() {
        return this.zzfzt;
    }
}
