package com.google.android.gms.measurement.internal;

import a2.b.a.a.a;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
public final class zzai extends zzgw {
    private long zza;
    private String zzb;
    private Boolean zzc;
    private AccountManager zzd;
    private Boolean zze;
    private long zzf;

    public zzai(zzgd zzgd) {
        super(zzgd);
    }

    public final boolean zza(Context context) {
        if (this.zzc == null) {
            zzu();
            this.zzc = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.zzc = Boolean.TRUE;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.zzc.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzgw
    public final boolean zze() {
        Calendar instance = Calendar.getInstance();
        this.zza = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        this.zzb = a.s2(a.q0(lowerCase2, a.q0(lowerCase, 1)), lowerCase, "-", lowerCase2);
        return false;
    }

    public final long zzf() {
        zzaa();
        return this.zza;
    }

    public final String zzg() {
        zzaa();
        return this.zzb;
    }

    @WorkerThread
    public final long zzh() {
        zzd();
        return this.zzf;
    }

    @WorkerThread
    public final void zzi() {
        zzd();
        this.zze = null;
        this.zzf = 0;
    }

    @WorkerThread
    public final boolean zzj() {
        zzd();
        long currentTimeMillis = zzm().currentTimeMillis();
        if (currentTimeMillis - this.zzf > 86400000) {
            this.zze = null;
        }
        Boolean bool = this.zze;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (ContextCompat.checkSelfPermission(zzn(), "android.permission.GET_ACCOUNTS") != 0) {
            zzr().zzj().zza("Permission error checking for dasher/unicorn accounts");
            this.zzf = currentTimeMillis;
            this.zze = Boolean.FALSE;
            return false;
        }
        if (this.zzd == null) {
            this.zzd = AccountManager.get(zzn());
        }
        try {
            Account[] result = this.zzd.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
            if (result == null || result.length <= 0) {
                Account[] result2 = this.zzd.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
                if (result2 != null && result2.length > 0) {
                    this.zze = Boolean.TRUE;
                    this.zzf = currentTimeMillis;
                    return true;
                }
                this.zzf = currentTimeMillis;
                this.zze = Boolean.FALSE;
                return false;
            }
            this.zze = Boolean.TRUE;
            this.zzf = currentTimeMillis;
            return true;
        } catch (AuthenticatorException | OperationCanceledException | IOException e) {
            zzr().zzg().zza("Exception checking account types", e);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzai zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzex zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzkw zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ zzfw zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ zzez zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzfl zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzy zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ zzx zzu() {
        return super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
