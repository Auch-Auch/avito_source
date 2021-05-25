package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.firebase.messaging.Constants;
import kotlinx.coroutines.DebugKt;
import ru.avito.messenger.internal.ConstantsKt;
public final class zzp {
    private final zzgd zza;

    public zzp(zzgd zzgd) {
        this.zza = zzgd;
    }

    private final boolean zzc() {
        if (zzd() && this.zza.zzm().currentTimeMillis() - this.zza.zzc().zzw.zza() > this.zza.zzb().zza((String) null, zzaq.zzcr)) {
            return true;
        }
        return false;
    }

    private final boolean zzd() {
        return this.zza.zzc().zzw.zza() > 0;
    }

    @WorkerThread
    public final void zza() {
        this.zza.zzq().zzd();
        if (zzd()) {
            if (zzc()) {
                this.zza.zzc().zzv.zza(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1);
                this.zza.zzh().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_cmpx", bundle);
            } else {
                String zza2 = this.zza.zzc().zzv.zza();
                if (TextUtils.isEmpty(zza2)) {
                    this.zza.zzr().zzg().zza("Cache still valid but referrer not found");
                } else {
                    long zza3 = ((this.zza.zzc().zzw.zza() / ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS) - 1) * ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS;
                    Uri parse = Uri.parse(zza2);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String str : parse.getQueryParameterNames()) {
                        bundle2.putString(str, parse.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", zza3);
                    this.zza.zzh().zza((String) pair.first, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, (Bundle) pair.second);
                }
                this.zza.zzc().zzv.zza(null);
            }
            this.zza.zzc().zzw.zza(0);
        }
    }

    public final void zzb() {
        if (zzd() && zzc()) {
            this.zza.zzc().zzv.zza(null);
        }
    }

    @WorkerThread
    public final void zza(String str, Bundle bundle) {
        String str2;
        this.zza.zzq().zzd();
        if (!this.zza.zzab()) {
            if (bundle == null || bundle.isEmpty()) {
                str2 = null;
            } else {
                if (str == null || str.isEmpty()) {
                    str = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String str3 : bundle.keySet()) {
                    builder.appendQueryParameter(str3, bundle.getString(str3));
                }
                str2 = builder.build().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                this.zza.zzc().zzv.zza(str2);
                this.zza.zzc().zzw.zza(this.zza.zzm().currentTimeMillis());
            }
        }
    }
}
