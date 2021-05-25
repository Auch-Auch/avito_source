package com.google.android.gms.measurement.internal;

import a2.b.a.a.a;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zznn;
import com.google.android.gms.internal.measurement.zzoe;
import com.google.android.gms.internal.measurement.zzof;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlinx.coroutines.DebugKt;
public class zzkk implements zzgz {
    private static volatile zzkk zza;
    private zzfx zzb;
    private zzfc zzc;
    private zzad zzd;
    private zzfj zze;
    private zzkg zzf;
    private zzo zzg;
    private final zzks zzh;
    private zzii zzi;
    private final zzgd zzj;
    private boolean zzk;
    private boolean zzl;
    @VisibleForTesting
    private long zzm;
    private List<Runnable> zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private FileLock zzt;
    private FileChannel zzu;
    private List<Long> zzv;
    private List<Long> zzw;
    private long zzx;

    public class zza implements zzaf {
        public zzcc.zzg zza;
        public List<Long> zzb;
        public List<zzcc.zzc> zzc;
        private long zzd;

        private zza() {
        }

        @Override // com.google.android.gms.measurement.internal.zzaf
        public final void zza(zzcc.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zza = zzg;
        }

        public /* synthetic */ zza(zzkk zzkk, zzkn zzkn) {
            this();
        }

        @Override // com.google.android.gms.measurement.internal.zzaf
        public final boolean zza(long j, zzcc.zzc zzc2) {
            Preconditions.checkNotNull(zzc2);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzc2)) {
                return false;
            }
            long zzbm = this.zzd + ((long) zzc2.zzbm());
            if (zzbm >= ((long) Math.max(0, zzaq.zzh.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzbm;
            this.zzc.add(zzc2);
            this.zzb.add(Long.valueOf(j));
            if (this.zzc.size() >= Math.max(1, zzaq.zzi.zza(null).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzcc.zzc zzc2) {
            return ((zzc2.zze() / 1000) / 60) / 60;
        }
    }

    private zzkk(zzkq zzkq) {
        this(zzkq, null);
    }

    public static zzkk zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzkk.class) {
                if (zza == null) {
                    zza = new zzkk(new zzkq(context));
                }
            }
        }
        return zza;
    }

    @WorkerThread
    private final void zzaa() {
        zzw();
        if (this.zzq || this.zzr || this.zzs) {
            this.zzj.zzr().zzx().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs));
            return;
        }
        this.zzj.zzr().zzx().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzn;
        if (list != null) {
            for (Runnable runnable : list) {
                runnable.run();
            }
            this.zzn.clear();
        }
    }

    @VisibleForTesting
    @WorkerThread
    private final boolean zzab() {
        FileLock fileLock;
        zzw();
        if (!this.zzj.zzb().zza(zzaq.zzbl) || (fileLock = this.zzt) == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzj.zzn().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzu = channel;
                FileLock tryLock = channel.tryLock();
                this.zzt = tryLock;
                if (tryLock != null) {
                    this.zzj.zzr().zzx().zza("Storage concurrent access okay");
                    return true;
                }
                this.zzj.zzr().zzf().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                this.zzj.zzr().zzf().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                this.zzj.zzr().zzf().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                this.zzj.zzr().zzi().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            this.zzj.zzr().zzx().zza("Storage concurrent access okay");
            return true;
        }
    }

    private final zzfj zzt() {
        zzfj zzfj = this.zze;
        if (zzfj != null) {
            return zzfj;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzkg zzv() {
        zzb(this.zzf);
        return this.zzf;
    }

    @WorkerThread
    private final void zzw() {
        this.zzj.zzq().zzd();
    }

    private final long zzx() {
        long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
        zzfl zzc2 = this.zzj.zzc();
        zzc2.zzaa();
        zzc2.zzd();
        long zza2 = zzc2.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + ((long) zzc2.zzp().zzh().nextInt(86400000));
            zzc2.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    private final boolean zzy() {
        zzw();
        zzk();
        return zze().zzy() || !TextUtils.isEmpty(zze().d_());
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01aa  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzz() {
        /*
        // Method dump skipped, instructions count: 627
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zzz():void");
    }

    public final zzy zzb() {
        return this.zzj.zzb();
    }

    public final zzfx zzc() {
        zzb(this.zzb);
        return this.zzb;
    }

    public final zzfc zzd() {
        zzb(this.zzc);
        return this.zzc;
    }

    public final zzad zze() {
        zzb(this.zzd);
        return this.zzd;
    }

    public final zzo zzf() {
        zzb(this.zzg);
        return this.zzg;
    }

    public final zzii zzg() {
        zzb(this.zzi);
        return this.zzi;
    }

    public final zzks zzh() {
        zzb(this.zzh);
        return this.zzh;
    }

    public final zzex zzi() {
        return this.zzj.zzj();
    }

    public final zzkw zzj() {
        return this.zzj.zzi();
    }

    public final void zzk() {
        if (!this.zzk) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    @WorkerThread
    public final void zzl() {
        zzf zzb2;
        String str;
        zzw();
        zzk();
        this.zzs = true;
        boolean z = false;
        try {
            this.zzj.zzu();
            Boolean zzag = this.zzj.zzw().zzag();
            if (zzag == null) {
                this.zzj.zzr().zzi().zza("Upload data called on the client side before use of service was decided");
            } else if (zzag.booleanValue()) {
                this.zzj.zzr().zzf().zza("Upload called in the client side when service should be used");
                this.zzs = false;
                zzaa();
            } else if (this.zzm > 0) {
                zzz();
                this.zzs = false;
                zzaa();
            } else {
                zzw();
                if (this.zzv != null) {
                    this.zzj.zzr().zzx().zza("Uploading requested multiple times");
                    this.zzs = false;
                    zzaa();
                } else if (!zzd().zzf()) {
                    this.zzj.zzr().zzx().zza("Network not connected, ignoring upload request");
                    zzz();
                    this.zzs = false;
                    zzaa();
                } else {
                    long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
                    int zzb3 = this.zzj.zzb().zzb(null, zzaq.zzap);
                    long zzv2 = currentTimeMillis - zzy.zzv();
                    for (int i = 0; i < zzb3 && zza((String) null, zzv2); i++) {
                    }
                    long zza2 = this.zzj.zzc().zzc.zza();
                    if (zza2 != 0) {
                        this.zzj.zzr().zzw().zza("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza2)));
                    }
                    String d_ = zze().d_();
                    if (!TextUtils.isEmpty(d_)) {
                        if (this.zzx == -1) {
                            this.zzx = zze().zzaa();
                        }
                        List<Pair<zzcc.zzg, Long>> zza3 = zze().zza(d_, this.zzj.zzb().zzb(d_, zzaq.zzf), Math.max(0, this.zzj.zzb().zzb(d_, zzaq.zzg)));
                        if (!zza3.isEmpty()) {
                            Iterator<Pair<zzcc.zzg, Long>> it = zza3.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    str = null;
                                    break;
                                }
                                zzcc.zzg zzg2 = (zzcc.zzg) it.next().first;
                                if (!TextUtils.isEmpty(zzg2.zzad())) {
                                    str = zzg2.zzad();
                                    break;
                                }
                            }
                            if (str != null) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= zza3.size()) {
                                        break;
                                    }
                                    zzcc.zzg zzg3 = (zzcc.zzg) zza3.get(i2).first;
                                    if (!(TextUtils.isEmpty(zzg3.zzad()) || zzg3.zzad().equals(str))) {
                                        zza3 = zza3.subList(0, i2);
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            zzcc.zzf.zza zzb4 = zzcc.zzf.zzb();
                            int size = zza3.size();
                            ArrayList arrayList = new ArrayList(zza3.size());
                            boolean zzg4 = this.zzj.zzb().zzg(d_);
                            for (int i3 = 0; i3 < size; i3++) {
                                zzcc.zzg.zza zza4 = (zzcc.zzg.zza) ((zzcc.zzg) zza3.get(i3).first).zzbl();
                                arrayList.add((Long) zza3.get(i3).second);
                                zzcc.zzg.zza zza5 = zza4.zzg(this.zzj.zzb().zzf()).zza(currentTimeMillis);
                                this.zzj.zzu();
                                zza5.zzb(false);
                                if (!zzg4) {
                                    zza4.zzn();
                                }
                                if (this.zzj.zzb().zze(d_, zzaq.zzay)) {
                                    zza4.zzl(zzh().zza(((zzcc.zzg) ((zzib) zza4.zzv())).zzbi()));
                                }
                                zzb4.zza(zza4);
                            }
                            String zza6 = this.zzj.zzr().zza(2) ? zzh().zza((zzcc.zzf) ((zzib) zzb4.zzv())) : null;
                            zzh();
                            byte[] zzbi = ((zzcc.zzf) ((zzib) zzb4.zzv())).zzbi();
                            String zza7 = zzaq.zzp.zza(null);
                            try {
                                URL url = new URL(zza7);
                                Preconditions.checkArgument(!arrayList.isEmpty());
                                if (this.zzv != null) {
                                    this.zzj.zzr().zzf().zza("Set uploading progress before finishing the previous upload");
                                } else {
                                    this.zzv = new ArrayList(arrayList);
                                }
                                this.zzj.zzc().zzd.zza(currentTimeMillis);
                                String str2 = "?";
                                if (size > 0) {
                                    str2 = zzb4.zza(0).zzx();
                                }
                                this.zzj.zzr().zzx().zza("Uploading data. app, uncompressed size, data", str2, Integer.valueOf(zzbi.length), zza6);
                                this.zzr = true;
                                zzfc zzd2 = zzd();
                                zzkm zzkm = new zzkm(this, d_);
                                zzd2.zzd();
                                zzd2.zzak();
                                Preconditions.checkNotNull(url);
                                Preconditions.checkNotNull(zzbi);
                                Preconditions.checkNotNull(zzkm);
                                zzd2.zzq().zzb(new zzfg(zzd2, d_, url, zzbi, null, zzkm));
                            } catch (MalformedURLException unused) {
                                this.zzj.zzr().zzf().zza("Failed to parse upload URL. Not uploading. appId", zzez.zza(d_), zza7);
                            }
                        }
                    } else {
                        this.zzx = -1;
                        String zza8 = zze().zza(currentTimeMillis - zzy.zzv());
                        if (!TextUtils.isEmpty(zza8) && (zzb2 = zze().zzb(zza8)) != null) {
                            zza(zzb2);
                        }
                    }
                    this.zzs = false;
                    zzaa();
                }
            }
        } finally {
            this.zzs = z;
            zzaa();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final Clock zzm() {
        return this.zzj.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final Context zzn() {
        return this.zzj.zzn();
    }

    @VisibleForTesting
    @WorkerThread
    public final void zzo() {
        zzw();
        zzk();
        if (!this.zzl) {
            this.zzl = true;
            if (zzab()) {
                int zza2 = zza(this.zzu);
                int zzaf = this.zzj.zzy().zzaf();
                zzw();
                if (zza2 > zzaf) {
                    this.zzj.zzr().zzf().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                } else if (zza2 >= zzaf) {
                } else {
                    if (zza(zzaf, this.zzu)) {
                        this.zzj.zzr().zzx().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    } else {
                        this.zzj.zzr().zzf().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    }
                }
            }
        }
    }

    public final void zzp() {
        this.zzp++;
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final zzfw zzq() {
        return this.zzj.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final zzez zzr() {
        return this.zzj.zzr();
    }

    public final zzgd zzs() {
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final zzx zzu() {
        return this.zzj.zzu();
    }

    private zzkk(zzkq zzkq, zzgd zzgd) {
        this.zzk = false;
        Preconditions.checkNotNull(zzkq);
        zzgd zza2 = zzgd.zza(zzkq.zza, null, null);
        this.zzj = zza2;
        this.zzx = -1;
        zzks zzks = new zzks(this);
        zzks.zzal();
        this.zzh = zzks;
        zzfc zzfc = new zzfc(this);
        zzfc.zzal();
        this.zzc = zzfc;
        zzfx zzfx = new zzfx(this);
        zzfx.zzal();
        this.zzb = zzfx;
        zza2.zzq().zza(new zzkn(this, zzkq));
    }

    private static void zzb(zzkl zzkl) {
        if (zzkl == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzkl.zzaj()) {
            String valueOf = String.valueOf(zzkl.getClass());
            throw new IllegalStateException(a.r2(valueOf.length() + 27, "Component not initialized: ", valueOf));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:252:0x08a5, code lost:
        r11 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02db  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(com.google.android.gms.measurement.internal.zzao r27, com.google.android.gms.measurement.internal.zzn r28) {
        /*
        // Method dump skipped, instructions count: 2368
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zzc(com.google.android.gms.measurement.internal.zzao, com.google.android.gms.measurement.internal.zzn):void");
    }

    private final boolean zze(zzn zzn2) {
        return (!zzoe.zzb() || !this.zzj.zzb().zze(zzn2.zza, zzaq.zzbn)) ? !TextUtils.isEmpty(zzn2.zzb) || !TextUtils.isEmpty(zzn2.zzr) : !TextUtils.isEmpty(zzn2.zzb) || !TextUtils.isEmpty(zzn2.zzv) || !TextUtils.isEmpty(zzn2.zzr);
    }

    public final String zzd(zzn zzn2) {
        try {
            return (String) this.zzj.zzq().zza(new zzko(this, zzn2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzr().zzf().zza("Failed to get app instance id. appId", zzez.zza(zzn2.zza), e);
            return null;
        }
    }

    @WorkerThread
    private final void zzb(zzao zzao, zzn zzn2) {
        if (zzof.zzb() && this.zzj.zzb().zza(zzaq.zzcn)) {
            zzfd zza2 = zzfd.zza(zzao);
            this.zzj.zzi().zza(zza2.zzb, zze().zzi(zzn2.zza));
            this.zzj.zzi().zza(zza2, this.zzj.zzb().zza(zzn2.zza));
            zzao = zza2.zza();
        }
        zza(zzao, zzn2);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzkq zzkq) {
        this.zzj.zzq().zzd();
        zzad zzad = new zzad(this);
        zzad.zzal();
        this.zzd = zzad;
        this.zzj.zzb().zza(this.zzb);
        zzo zzo2 = new zzo(this);
        zzo2.zzal();
        this.zzg = zzo2;
        zzii zzii = new zzii(this);
        zzii.zzal();
        this.zzi = zzii;
        zzkg zzkg = new zzkg(this);
        zzkg.zzal();
        this.zzf = zzkg;
        this.zze = new zzfj(this);
        if (this.zzo != this.zzp) {
            this.zzj.zzr().zzf().zza("Not all upload components initialized", Integer.valueOf(this.zzo), Integer.valueOf(this.zzp));
        }
        this.zzk = true;
    }

    private final void zzb(zzcc.zzc.zza zza2, zzcc.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzcc.zze zza4 = zzks.zza((zzcc.zzc) ((zzib) zza2.zzv()), "_et");
        if (zza4.zze() && zza4.zzf() > 0) {
            long zzf2 = zza4.zzf();
            zzh();
            zzcc.zze zza5 = zzks.zza((zzcc.zzc) ((zzib) zza3.zzv()), "_et");
            if (zza5 != null && zza5.zzf() > 0) {
                zzf2 += zza5.zzf();
            }
            zzh().zza(zza3, "_et", Long.valueOf(zzf2));
            zzh().zza(zza2, "_fr", (Object) 1L);
        }
    }

    @WorkerThread
    private final Boolean zzb(zzf zzf2) {
        try {
            if (zzf2.zzm() != -2147483648L) {
                if (zzf2.zzm() == ((long) Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzf2.zzc(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzf2.zzc(), 0).versionName;
                if (zzf2.zzl() != null && zzf2.zzl().equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @WorkerThread
    public final void zza() {
        this.zzj.zzq().zzd();
        zze().zzv();
        if (this.zzj.zzc().zzc.zza() == 0) {
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        zzz();
    }

    @WorkerThread
    public final void zzb(zzkr zzkr, zzn zzn2) {
        zzw();
        zzk();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
            } else if (!"_npa".equals(zzkr.zza) || zzn2.zzs == null) {
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkr.zza));
                zze().zzf();
                try {
                    zzc(zzn2);
                    zze().zzb(zzn2.zza, zzkr.zza);
                    zze().b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkr.zza));
                } finally {
                    zze().zzh();
                }
            } else {
                this.zzj.zzr().zzw().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzkr("_npa", this.zzj.zzm().currentTimeMillis(), Long.valueOf(zzn2.zzs.booleanValue() ? 1 : 0), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzn2);
            }
        }
    }

    @WorkerThread
    public final void zza(zzao zzao, String str) {
        zzf zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping event", str);
            return;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null) {
            if (!"_ui".equals(zzao.zza)) {
                this.zzj.zzr().zzi().zza("Could not find package. appId", zzez.zza(str));
            }
        } else if (!zzb3.booleanValue()) {
            this.zzj.zzr().zzf().zza("App version does not match; dropping event. appId", zzez.zza(str));
            return;
        }
        zzb(zzao, new zzn(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0L, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zzoe.zzb() || !this.zzj.zzb().zze(zzb2.zzc(), zzaq.zzbn)) ? null : zzb2.zzg()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:127:0x03b4  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x048a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011b A[Catch:{ all -> 0x04b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x024e  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.measurement.internal.zzn r22) {
        /*
        // Method dump skipped, instructions count: 1215
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zzb(com.google.android.gms.measurement.internal.zzn):void");
    }

    @WorkerThread
    public final void zza(zzao zzao, zzn zzn2) {
        List<zzw> list;
        List<zzw> list2;
        List<zzw> list3;
        List<String> list4;
        zzao zzao2 = zzao;
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn2.zza);
        zzw();
        zzk();
        String str = zzn2.zza;
        long j = zzao2.zzd;
        zzh();
        if (zzks.zza(zzao, zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            if (this.zzj.zzb().zze(str, zzaq.zzbb) && (list4 = zzn2.zzu) != null) {
                if (list4.contains(zzao2.zza)) {
                    Bundle zzb2 = zzao2.zzb.zzb();
                    zzb2.putLong("ga_safelisted", 1);
                    zzao2 = new zzao(zzao2.zza, new zzan(zzb2), zzao2.zzc, zzao2.zzd);
                } else {
                    this.zzj.zzr().zzw().zza("Dropping non-safelisted event. appId, event name, origin", str, zzao2.zza, zzao2.zzc);
                    return;
                }
            }
            zze().zzf();
            try {
                zzad zze2 = zze();
                Preconditions.checkNotEmpty(str);
                zze2.zzd();
                zze2.zzak();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zze2.zzr().zzi().zza("Invalid time querying timed out conditional properties", zzez.zza(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zze2.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzw zzw2 : list) {
                    if (zzw2 != null) {
                        this.zzj.zzr().zzx().zza("User property timed out", zzw2.zza, this.zzj.zzj().zzc(zzw2.zzc.zza), zzw2.zzc.zza());
                        if (zzw2.zzg != null) {
                            zzc(new zzao(zzw2.zzg, j), zzn2);
                        }
                        zze().zze(str, zzw2.zzc.zza);
                    }
                }
                zzad zze3 = zze();
                Preconditions.checkNotEmpty(str);
                zze3.zzd();
                zze3.zzak();
                if (i < 0) {
                    zze3.zzr().zzi().zza("Invalid time querying expired conditional properties", zzez.zza(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zze3.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzw zzw3 : list2) {
                    if (zzw3 != null) {
                        this.zzj.zzr().zzx().zza("User property expired", zzw3.zza, this.zzj.zzj().zzc(zzw3.zzc.zza), zzw3.zzc.zza());
                        zze().zzb(str, zzw3.zzc.zza);
                        zzao zzao3 = zzw3.zzk;
                        if (zzao3 != null) {
                            arrayList.add(zzao3);
                        }
                        zze().zze(str, zzw3.zzc.zza);
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    zzc(new zzao((zzao) obj, j), zzn2);
                }
                zzad zze4 = zze();
                String str2 = zzao2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zze4.zzd();
                zze4.zzak();
                if (i < 0) {
                    zze4.zzr().zzi().zza("Invalid time querying triggered conditional properties", zzez.zza(str), zze4.zzo().zza(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zze4.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(list3.size());
                for (zzw zzw4 : list3) {
                    if (zzw4 != null) {
                        zzkr zzkr = zzw4.zzc;
                        zzkt zzkt = new zzkt(zzw4.zza, zzw4.zzb, zzkr.zza, j, zzkr.zza());
                        if (zze().zza(zzkt)) {
                            this.zzj.zzr().zzx().zza("User property triggered", zzw4.zza, this.zzj.zzj().zzc(zzkt.zzc), zzkt.zze);
                        } else {
                            this.zzj.zzr().zzf().zza("Too many active user properties, ignoring", zzez.zza(zzw4.zza), this.zzj.zzj().zzc(zzkt.zzc), zzkt.zze);
                        }
                        zzao zzao4 = zzw4.zzi;
                        if (zzao4 != null) {
                            arrayList2.add(zzao4);
                        }
                        zzw4.zzc = new zzkr(zzkt);
                        zzw4.zze = true;
                        zze().zza(zzw4);
                    }
                }
                zzc(zzao2, zzn2);
                int size2 = arrayList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    zzc(new zzao((zzao) obj2, j), zzn2);
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0595  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x066c  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0807  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x0823  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x083d  */
    /* JADX WARNING: Removed duplicated region for block: B:500:0x0f19  */
    /* JADX WARNING: Removed duplicated region for block: B:505:0x0f30  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0256  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(java.lang.String r44, long r45) {
        /*
        // Method dump skipped, instructions count: 3905
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zza(java.lang.String, long):boolean");
    }

    @WorkerThread
    public final void zzb(zzw zzw2) {
        zzn zza2 = zza(zzw2.zza);
        if (zza2 != null) {
            zzb(zzw2, zza2);
        }
    }

    @WorkerThread
    public final void zzb(zzw zzw2, zzn zzn2) {
        Preconditions.checkNotNull(zzw2);
        Preconditions.checkNotEmpty(zzw2.zza);
        Preconditions.checkNotNull(zzw2.zzc);
        Preconditions.checkNotEmpty(zzw2.zzc.zza);
        zzw();
        zzk();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            zze().zzf();
            try {
                zzc(zzn2);
                zzw zzd2 = zze().zzd(zzw2.zza, zzw2.zzc.zza);
                if (zzd2 != null) {
                    this.zzj.zzr().zzw().zza("Removing conditional user property", zzw2.zza, this.zzj.zzj().zzc(zzw2.zzc.zza));
                    zze().zze(zzw2.zza, zzw2.zzc.zza);
                    if (zzd2.zze) {
                        zze().zzb(zzw2.zza, zzw2.zzc.zza);
                    }
                    zzao zzao = zzw2.zzk;
                    if (zzao != null) {
                        Bundle bundle = null;
                        zzan zzan = zzao.zzb;
                        if (zzan != null) {
                            bundle = zzan.zzb();
                        }
                        zzkw zzi2 = this.zzj.zzi();
                        String str = zzw2.zza;
                        zzao zzao2 = zzw2.zzk;
                        zzc(zzi2.zza(str, zzao2.zza, bundle, zzd2.zzb, zzao2.zzd, true, false), zzn2);
                    }
                } else {
                    this.zzj.zzr().zzi().zza("Conditional user property doesn't exist", zzez.zza(zzw2.zza), this.zzj.zzj().zzc(zzw2.zzc.zza));
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    @WorkerThread
    public final zzf zzc(zzn zzn2) {
        zzw();
        zzk();
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn2.zza);
        zzf zzb2 = zze().zzb(zzn2.zza);
        String zzb3 = this.zzj.zzc().zzb(zzn2.zza);
        if (!zznn.zzb() || !this.zzj.zzb().zza(zzaq.zzbt)) {
            return zza(zzn2, zzb2, zzb3);
        }
        if (zzb2 == null) {
            zzb2 = new zzf(this.zzj, zzn2.zza);
            zzb2.zza(this.zzj.zzi().zzk());
            zzb2.zze(zzb3);
        } else if (!zzb3.equals(zzb2.zzh())) {
            zzb2.zze(zzb3);
            zzb2.zza(this.zzj.zzi().zzk());
        }
        zzb2.zzb(zzn2.zzb);
        zzb2.zzc(zzn2.zzr);
        if (zzoe.zzb() && this.zzj.zzb().zze(zzb2.zzc(), zzaq.zzbn)) {
            zzb2.zzd(zzn2.zzv);
        }
        if (!TextUtils.isEmpty(zzn2.zzk)) {
            zzb2.zzf(zzn2.zzk);
        }
        long j = zzn2.zze;
        if (j != 0) {
            zzb2.zzd(j);
        }
        if (!TextUtils.isEmpty(zzn2.zzc)) {
            zzb2.zzg(zzn2.zzc);
        }
        zzb2.zzc(zzn2.zzj);
        String str = zzn2.zzd;
        if (str != null) {
            zzb2.zzh(str);
        }
        zzb2.zze(zzn2.zzf);
        zzb2.zza(zzn2.zzh);
        if (!TextUtils.isEmpty(zzn2.zzg)) {
            zzb2.zzi(zzn2.zzg);
        }
        if (!this.zzj.zzb().zza(zzaq.zzcl)) {
            zzb2.zzp(zzn2.zzl);
        }
        zzb2.zzb(zzn2.zzo);
        zzb2.zzc(zzn2.zzp);
        zzb2.zza(zzn2.zzs);
        zzb2.zzf(zzn2.zzt);
        if (zzb2.zza()) {
            zze().zza(zzb2);
        }
        return zzb2;
    }

    private static void zza(zzcc.zzg.zza zza2) {
        zza2.zzb(Long.MAX_VALUE).zzc(Long.MIN_VALUE);
        for (int i = 0; i < zza2.zzb(); i++) {
            zzcc.zzc zzb2 = zza2.zzb(i);
            if (zzb2.zze() < zza2.zzf()) {
                zza2.zzb(zzb2.zze());
            }
            if (zzb2.zze() > zza2.zzg()) {
                zza2.zzc(zzb2.zze());
            }
        }
    }

    @VisibleForTesting
    private final void zza(zzcc.zzg.zza zza2, long j, boolean z) {
        zzkt zzkt;
        String str = z ? "_se" : "_lte";
        zzkt zzc2 = zze().zzc(zza2.zzj(), str);
        if (zzc2 == null || zzc2.zze == null) {
            zzkt = new zzkt(zza2.zzj(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzkt = new zzkt(zza2.zzj(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j));
        }
        zzcc.zzk zzk2 = (zzcc.zzk) ((zzib) zzcc.zzk.zzj().zza(str).zza(this.zzj.zzm().currentTimeMillis()).zzb(((Long) zzkt.zze).longValue()).zzv());
        boolean z2 = false;
        int zza3 = zzks.zza(zza2, str);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzk2);
            z2 = true;
        }
        if (!z2) {
            zza2.zza(zzk2);
        }
        if (j > 0) {
            zze().zza(zzkt);
            this.zzj.zzr().zzx().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzkt.zze);
        }
    }

    private final boolean zza(zzcc.zzc.zza zza2, zzcc.zzc.zza zza3) {
        String str;
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzcc.zze zza4 = zzks.zza((zzcc.zzc) ((zzib) zza2.zzv()), "_sc");
        String str2 = null;
        if (zza4 == null) {
            str = null;
        } else {
            str = zza4.zzd();
        }
        zzh();
        zzcc.zze zza5 = zzks.zza((zzcc.zzc) ((zzib) zza3.zzv()), "_pc");
        if (zza5 != null) {
            str2 = zza5.zzd();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        zzb(zza2, zza3);
        return true;
    }

    @VisibleForTesting
    private static void zza(zzcc.zzc.zza zza2, @NonNull String str) {
        List<zzcc.zze> zza3 = zza2.zza();
        for (int i = 0; i < zza3.size(); i++) {
            if (str.equals(zza3.get(i).zzb())) {
                zza2.zzb(i);
                return;
            }
        }
    }

    @VisibleForTesting
    private static void zza(zzcc.zzc.zza zza2, int i, String str) {
        List<zzcc.zze> zza3 = zza2.zza();
        for (int i2 = 0; i2 < zza3.size(); i2++) {
            if ("_err".equals(zza3.get(i2).zzb())) {
                return;
            }
        }
        zza2.zza((zzcc.zze) ((zzib) zzcc.zze.zzm().zza("_err").zza(Long.valueOf((long) i).longValue()).zzv())).zza((zzcc.zze) ((zzib) zzcc.zze.zzm().zza("_ev").zzb(str).zzv()));
    }

    /* JADX INFO: finally extract failed */
    @VisibleForTesting
    @WorkerThread
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzw();
        zzk();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzr = false;
                zzaa();
                throw th2;
            }
        }
        List<Long> list = this.zzv;
        this.zzv = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
                this.zzj.zzc().zzd.zza(0);
                zzz();
                this.zzj.zzr().zzx().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zzf();
                try {
                    for (Long l : list) {
                        try {
                            zzad zze2 = zze();
                            long longValue = l.longValue();
                            zze2.zzd();
                            zze2.zzak();
                            try {
                                if (zze2.c_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                                }
                            } catch (SQLiteException e) {
                                zze2.zzr().zzf().zza("Failed to delete a bundle in a queue table", e);
                                throw e;
                            }
                        } catch (SQLiteException e2) {
                            List<Long> list2 = this.zzw;
                            if (list2 == null || !list2.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zze().b_();
                    zze().zzh();
                    this.zzw = null;
                    if (!zzd().zzf() || !zzy()) {
                        this.zzx = -1;
                        zzz();
                    } else {
                        zzl();
                    }
                    this.zzm = 0;
                } catch (Throwable th3) {
                    zze().zzh();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzj.zzr().zzf().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzm = this.zzj.zzm().elapsedRealtime();
                this.zzj.zzr().zzx().zza("Disable upload, time", Long.valueOf(this.zzm));
            }
        } else {
            this.zzj.zzr().zzx().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
            if (!(i == 503 || i == 429)) {
                z = false;
            }
            if (z) {
                this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
            }
            zze().zza(list);
            zzz();
        }
        this.zzr = false;
        zzaa();
    }

    @WorkerThread
    private final void zza(zzf zzf2) {
        ArrayMap arrayMap;
        zzw();
        if (!zzoe.zzb() || !this.zzj.zzb().zze(zzf2.zzc(), zzaq.zzbn)) {
            if (TextUtils.isEmpty(zzf2.zze()) && TextUtils.isEmpty(zzf2.zzf())) {
                zza(zzf2.zzc(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(zzf2.zze()) && TextUtils.isEmpty(zzf2.zzg()) && TextUtils.isEmpty(zzf2.zzf())) {
            zza(zzf2.zzc(), 204, null, null, null);
            return;
        }
        String zza2 = this.zzj.zzb().zza(zzf2);
        try {
            URL url = new URL(zza2);
            this.zzj.zzr().zzx().zza("Fetching remote configuration", zzf2.zzc());
            zzca.zzb zza3 = zzc().zza(zzf2.zzc());
            String zzb2 = zzc().zzb(zzf2.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb2)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, zzb2);
                arrayMap = arrayMap2;
            }
            this.zzq = true;
            zzfc zzd2 = zzd();
            String zzc2 = zzf2.zzc();
            zzkp zzkp = new zzkp(this);
            zzd2.zzd();
            zzd2.zzak();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkp);
            zzd2.zzq().zzb(new zzfg(zzd2, zzc2, url, null, arrayMap, zzkp));
        } catch (MalformedURLException unused) {
            this.zzj.zzr().zzf().zza("Failed to parse config URL. Not fetching. appId", zzez.zza(zzf2.zzc()), zza2);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014a  */
    @com.google.android.gms.common.util.VisibleForTesting
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
        // Method dump skipped, instructions count: 413
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    @WorkerThread
    public final void zza(Runnable runnable) {
        zzw();
        if (this.zzn == null) {
            this.zzn = new ArrayList();
        }
        this.zzn.add(runnable);
    }

    @VisibleForTesting
    @WorkerThread
    private final int zza(FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzj.zzr().zzi().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to read from channel", e);
            return 0;
        }
    }

    @VisibleForTesting
    @WorkerThread
    private final boolean zza(int i, FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            this.zzj.zzb().zza(zzaq.zzby);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzr().zzf().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to write to channel", e);
            return false;
        }
    }

    @VisibleForTesting
    @WorkerThread
    public final void zza(zzn zzn2) {
        if (this.zzv != null) {
            ArrayList arrayList = new ArrayList();
            this.zzw = arrayList;
            arrayList.addAll(this.zzv);
        }
        zzad zze2 = zze();
        String str = zzn2.zza;
        Preconditions.checkNotEmpty(str);
        zze2.zzd();
        zze2.zzak();
        try {
            SQLiteDatabase c_ = zze2.c_();
            String[] strArr = {str};
            int delete = c_.delete("apps", "app_id=?", strArr) + 0 + c_.delete("events", "app_id=?", strArr) + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("queue", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("main_event_params", "app_id=?", strArr) + c_.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze2.zzr().zzx().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze2.zzr().zzf().zza("Error resetting analytics data. appId, error", zzez.zza(str), e);
        }
        if (zzn2.zzh) {
            zzb(zzn2);
        }
    }

    @WorkerThread
    public final void zza(zzkr zzkr, zzn zzn2) {
        zzw();
        zzk();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            int zzc2 = this.zzj.zzi().zzc(zzkr.zza);
            if (zzc2 != 0) {
                this.zzj.zzi();
                String zza2 = zzkw.zza(zzkr.zza, 24, true);
                String str = zzkr.zza;
                this.zzj.zzi().zza(zzn2.zza, zzc2, "_ev", zza2, str != null ? str.length() : 0);
                return;
            }
            int zzb2 = this.zzj.zzi().zzb(zzkr.zza, zzkr.zza());
            if (zzb2 != 0) {
                this.zzj.zzi();
                String zza3 = zzkw.zza(zzkr.zza, 24, true);
                Object zza4 = zzkr.zza();
                this.zzj.zzi().zza(zzn2.zza, zzb2, "_ev", zza3, (zza4 == null || (!(zza4 instanceof String) && !(zza4 instanceof CharSequence))) ? 0 : String.valueOf(zza4).length());
                return;
            }
            Object zzc3 = this.zzj.zzi().zzc(zzkr.zza, zzkr.zza());
            if (zzc3 != null) {
                if ("_sid".equals(zzkr.zza)) {
                    long j = zzkr.zzb;
                    String str2 = zzkr.zze;
                    long j2 = 0;
                    zzkt zzc4 = zze().zzc(zzn2.zza, "_sno");
                    if (zzc4 != null) {
                        Object obj = zzc4.zze;
                        if (obj instanceof Long) {
                            j2 = ((Long) obj).longValue();
                            zza(new zzkr("_sno", j, Long.valueOf(j2 + 1), str2), zzn2);
                        }
                    }
                    if (zzc4 != null) {
                        this.zzj.zzr().zzi().zza("Retrieved last session number from database does not contain a valid (long) value", zzc4.zze);
                    }
                    zzak zza5 = zze().zza(zzn2.zza, "_s");
                    if (zza5 != null) {
                        j2 = zza5.zzc;
                        this.zzj.zzr().zzx().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                    }
                    zza(new zzkr("_sno", j, Long.valueOf(j2 + 1), str2), zzn2);
                }
                zzkt zzkt = new zzkt(zzn2.zza, zzkr.zze, zzkr.zza, zzkr.zzb, zzc3);
                this.zzj.zzr().zzx().zza("Setting user property", this.zzj.zzj().zzc(zzkt.zzc), zzc3);
                zze().zzf();
                try {
                    zzc(zzn2);
                    boolean zza6 = zze().zza(zzkt);
                    zze().b_();
                    if (!zza6) {
                        this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzj().zzc(zzkt.zzc), zzkt.zze);
                        this.zzj.zzi().zza(zzn2.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zze().zzh();
                }
            }
        }
    }

    public final void zza(zzkl zzkl) {
        this.zzo++;
    }

    @WorkerThread
    private final zzn zza(String str) {
        zzf zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping", str);
            return null;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null || zzb3.booleanValue()) {
            return new zzn(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0L, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zzoe.zzb() || !this.zzj.zzb().zze(str, zzaq.zzbn)) ? null : zzb2.zzg());
        }
        this.zzj.zzr().zzf().zza("App version does not match; dropping. appId", zzez.zza(str));
        return null;
    }

    @WorkerThread
    public final void zza(zzw zzw2) {
        zzn zza2 = zza(zzw2.zza);
        if (zza2 != null) {
            zza(zzw2, zza2);
        }
    }

    @WorkerThread
    public final void zza(zzw zzw2, zzn zzn2) {
        boolean z;
        Preconditions.checkNotNull(zzw2);
        Preconditions.checkNotEmpty(zzw2.zza);
        Preconditions.checkNotNull(zzw2.zzb);
        Preconditions.checkNotNull(zzw2.zzc);
        Preconditions.checkNotEmpty(zzw2.zzc.zza);
        zzw();
        zzk();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            zzw zzw3 = new zzw(zzw2);
            boolean z2 = false;
            zzw3.zze = false;
            zze().zzf();
            try {
                zzw zzd2 = zze().zzd(zzw3.zza, zzw3.zzc.zza);
                if (zzd2 != null && !zzd2.zzb.equals(zzw3.zzb)) {
                    this.zzj.zzr().zzi().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzj().zzc(zzw3.zzc.zza), zzw3.zzb, zzd2.zzb);
                }
                if (zzd2 != null && (z = zzd2.zze)) {
                    zzw3.zzb = zzd2.zzb;
                    zzw3.zzd = zzd2.zzd;
                    zzw3.zzh = zzd2.zzh;
                    zzw3.zzf = zzd2.zzf;
                    zzw3.zzi = zzd2.zzi;
                    zzw3.zze = z;
                    zzkr zzkr = zzw3.zzc;
                    zzw3.zzc = new zzkr(zzkr.zza, zzd2.zzc.zzb, zzkr.zza(), zzd2.zzc.zze);
                } else if (TextUtils.isEmpty(zzw3.zzf)) {
                    zzkr zzkr2 = zzw3.zzc;
                    zzw3.zzc = new zzkr(zzkr2.zza, zzw3.zzd, zzkr2.zza(), zzw3.zzc.zze);
                    zzw3.zze = true;
                    z2 = true;
                }
                if (zzw3.zze) {
                    zzkr zzkr3 = zzw3.zzc;
                    zzkt zzkt = new zzkt(zzw3.zza, zzw3.zzb, zzkr3.zza, zzkr3.zzb, zzkr3.zza());
                    if (zze().zza(zzkt)) {
                        this.zzj.zzr().zzw().zza("User property updated immediately", zzw3.zza, this.zzj.zzj().zzc(zzkt.zzc), zzkt.zze);
                    } else {
                        this.zzj.zzr().zzf().zza("(2)Too many active user properties, ignoring", zzez.zza(zzw3.zza), this.zzj.zzj().zzc(zzkt.zzc), zzkt.zze);
                    }
                    if (z2 && zzw3.zzi != null) {
                        zzc(new zzao(zzw3.zzi, zzw3.zzd), zzn2);
                    }
                }
                if (zze().zza(zzw3)) {
                    this.zzj.zzr().zzw().zza("Conditional property added", zzw3.zza, this.zzj.zzj().zzc(zzw3.zzc.zza), zzw3.zzc.zza());
                } else {
                    this.zzj.zzr().zzf().zza("Too many conditional properties, ignoring", zzez.zza(zzw3.zza), this.zzj.zzj().zzc(zzw3.zzc.zza), zzw3.zzc.zza());
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.zzf zza(com.google.android.gms.measurement.internal.zzn r9, com.google.android.gms.measurement.internal.zzf r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 405
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zza(com.google.android.gms.measurement.internal.zzn, com.google.android.gms.measurement.internal.zzf, java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    public final void zza(boolean z) {
        zzz();
    }
}
