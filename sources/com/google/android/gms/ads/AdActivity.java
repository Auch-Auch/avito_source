package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaql;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzwe;
@KeepForSdk
public final class AdActivity extends Activity {
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    @KeepForSdk
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzaql zzacp;

    private final void zzdo() {
        zzaql zzaql = this.zzacp;
        if (zzaql != null) {
            try {
                zzaql.zzdo();
            } catch (RemoteException e) {
                zzbbd.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.zzacp.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        boolean z = true;
        try {
            zzaql zzaql = this.zzacp;
            if (zzaql != null) {
                z = zzaql.zzuq();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.zzacp.zzad(ObjectWrapper.wrap(configuration));
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzaql zzb = zzwe.zzpr().zzb(this);
        this.zzacp = zzb;
        if (zzb == null) {
            zzbbd.zze("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzb.onCreate(bundle);
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        try {
            zzaql zzaql = this.zzacp;
            if (zzaql != null) {
                zzaql.onDestroy();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onPause() {
        try {
            zzaql zzaql = this.zzacp;
            if (zzaql != null) {
                zzaql.onPause();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onRestart() {
        super.onRestart();
        try {
            zzaql zzaql = this.zzacp;
            if (zzaql != null) {
                zzaql.onRestart();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        try {
            zzaql zzaql = this.zzacp;
            if (zzaql != null) {
                zzaql.onResume();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            zzaql zzaql = this.zzacp;
            if (zzaql != null) {
                zzaql.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
        try {
            zzaql zzaql = this.zzacp;
            if (zzaql != null) {
                zzaql.onStart();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onStop() {
        try {
            zzaql zzaql = this.zzacp;
            if (zzaql != null) {
                zzaql.onStop();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        super.setContentView(i);
        zzdo();
    }

    @Override // android.app.Activity
    public final void setContentView(View view) {
        super.setContentView(view);
        zzdo();
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzdo();
    }
}
