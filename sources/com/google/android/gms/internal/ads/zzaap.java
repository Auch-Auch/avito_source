package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;
@ParametersAreNonnullByDefault
public final class zzaap implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Object lock = new Object();
    private Bundle metaData = new Bundle();
    private final ConditionVariable zzclb = new ConditionVariable();
    @VisibleForTesting
    private volatile boolean zzclc = false;
    @Nullable
    private SharedPreferences zzcld = null;
    private Context zzcle;
    private JSONObject zzclf = new JSONObject();
    private volatile boolean zzzh = false;

    private final void zzrf() {
        if (this.zzcld != null) {
            try {
                this.zzclf = new JSONObject((String) zzbal.zza(new zzdsz(this) { // from class: com.google.android.gms.internal.ads.zzaar
                    private final zzaap zzclg;

                    {
                        this.zzclg = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdsz
                    public final Object get() {
                        return this.zzclg.zzrg();
                    }
                }));
            } catch (JSONException unused) {
            }
        }
    }

    public final void initialize(Context context) {
        if (!this.zzzh) {
            synchronized (this.lock) {
                if (!this.zzzh) {
                    if (!this.zzclc) {
                        this.zzclc = true;
                    }
                    Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
                    this.zzcle = applicationContext;
                    try {
                        this.metaData = Wrappers.packageManager(applicationContext).getApplicationInfo(this.zzcle.getPackageName(), 128).metaData;
                    } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                    }
                    boolean z = false;
                    try {
                        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                        if (remoteContext == null) {
                            Context applicationContext2 = context.getApplicationContext();
                            if (applicationContext2 != null) {
                                context = applicationContext2;
                            }
                            remoteContext = context;
                        }
                        if (remoteContext != null) {
                            zzwe.zzps();
                            SharedPreferences sharedPreferences = remoteContext.getSharedPreferences("google_ads_flags", 0);
                            this.zzcld = sharedPreferences;
                            if (sharedPreferences != null) {
                                sharedPreferences.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzadb.zza(new zzaau(this));
                            zzrf();
                            this.zzzh = true;
                            this.zzclc = false;
                            this.zzclb.open();
                        }
                    } finally {
                        this.zzclc = z;
                        this.zzclb.open();
                    }
                }
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzrf();
        }
    }

    public final <T> T zzd(zzaai<T> zzaai) {
        if (!this.zzclb.block(5000)) {
            synchronized (this.lock) {
                if (!this.zzclc) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzzh || this.zzcld == null) {
            synchronized (this.lock) {
                if (this.zzzh) {
                    if (this.zzcld == null) {
                    }
                }
                return zzaai.zzrc();
            }
        }
        if (zzaai.getSource() != 2) {
            return (zzaai.getSource() != 1 || !this.zzclf.has(zzaai.getKey())) ? (T) zzbal.zza(new zzdsz(this, zzaai) { // from class: com.google.android.gms.internal.ads.zzaas
                private final zzaap zzclg;
                private final zzaai zzclh;

                {
                    this.zzclg = r1;
                    this.zzclh = r2;
                }

                @Override // com.google.android.gms.internal.ads.zzdsz
                public final Object get() {
                    return this.zzclg.zze(this.zzclh);
                }
            }) : zzaai.zzb(this.zzclf);
        }
        Bundle bundle = this.metaData;
        if (bundle == null) {
            return zzaai.zzrc();
        }
        return zzaai.zza(bundle);
    }

    public final /* synthetic */ Object zze(zzaai zzaai) {
        return zzaai.zza(this.zzcld);
    }

    public final /* synthetic */ String zzrg() {
        return this.zzcld.getString("flag_configuration", "{}");
    }
}
