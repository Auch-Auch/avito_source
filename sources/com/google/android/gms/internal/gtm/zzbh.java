package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
public final class zzbh extends zzan {
    private volatile String zzut;
    private Future<String> zzyh;

    public zzbh(zzap zzap) {
        super(zzap);
    }

    private final boolean zzb(Context context, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotMainThread("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            zza("Storing clientId", str);
            fileOutputStream = context.openFileOutput("gaClientId", 0);
            fileOutputStream.write(str.getBytes());
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e) {
                zze("Failed to close clientId writing stream", e);
                return true;
            }
        } catch (FileNotFoundException e2) {
            zze("Error creating clientId file", e2);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    zze("Failed to close clientId writing stream", e3);
                }
            }
            return false;
        } catch (IOException e4) {
            zze("Error writing to clientId file", e4);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    zze("Failed to close clientId writing stream", e5);
                }
            }
            return false;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    zze("Failed to close clientId writing stream", e6);
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071 A[SYNTHETIC, Splitter:B:36:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007e A[SYNTHETIC, Splitter:B:44:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x008a A[SYNTHETIC, Splitter:B:52:0x008a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzd(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "gaClientId"
            java.lang.String r1 = "Failed to close client id reading stream"
            java.lang.String r2 = "ClientId should be loaded from worker thread"
            com.google.android.gms.common.internal.Preconditions.checkNotMainThread(r2)
            r2 = 0
            java.io.FileInputStream r3 = r9.openFileInput(r0)     // Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x0065, all -> 0x0063 }
            r4 = 36
            byte[] r5 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            r6 = 0
            int r4 = r3.read(r5, r6, r4)     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            int r7 = r3.available()     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            if (r7 <= 0) goto L_0x0031
            java.lang.String r4 = "clientId file seems corrupted, deleting it."
            r8.zzt(r4)     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            r3.close()     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            r9.deleteFile(r0)     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            r3.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x0030:
            return r2
        L_0x0031:
            r7 = 14
            if (r4 >= r7) goto L_0x0049
            java.lang.String r4 = "clientId file is empty, deleting it."
            r8.zzt(r4)
            r3.close()
            r9.deleteFile(r0)
            r3.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x0048:
            return r2
        L_0x0049:
            r3.close()
            java.lang.String r7 = new java.lang.String
            r7.<init>(r5, r6, r4)
            java.lang.String r4 = "Read client id from disk"
            r8.zza(r4, r7)
            r3.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x005e:
            return r7
        L_0x005f:
            r4 = move-exception
            goto L_0x0067
        L_0x0061:
            goto L_0x0088
        L_0x0063:
            r9 = move-exception
            goto L_0x007c
        L_0x0065:
            r4 = move-exception
            r3 = r2
        L_0x0067:
            java.lang.String r5 = "Error reading client id file, deleting it"
            r8.zze(r5, r4)     // Catch:{ all -> 0x007a }
            r9.deleteFile(r0)     // Catch:{ all -> 0x007a }
            if (r3 == 0) goto L_0x0079
            r3.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x0079
        L_0x0075:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x0079:
            return r2
        L_0x007a:
            r9 = move-exception
            r2 = r3
        L_0x007c:
            if (r2 == 0) goto L_0x0086
            r2.close()     // Catch:{ IOException -> 0x0082 }
            goto L_0x0086
        L_0x0082:
            r0 = move-exception
            r8.zze(r1, r0)
        L_0x0086:
            throw r9
        L_0x0087:
            r3 = r2
        L_0x0088:
            if (r3 == 0) goto L_0x0092
            r3.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x0092:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbh.zzd(android.content.Context):java.lang.String");
    }

    /* access modifiers changed from: private */
    @VisibleForTesting
    public final String zzek() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        try {
            if (!zzb(zzcq().getContext(), lowerCase)) {
                return "0";
            }
            return lowerCase;
        } catch (Exception e) {
            zze("Error saving clientId file", e);
            return "0";
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    public final void zzaw() {
    }

    public final String zzeh() {
        String str;
        zzdb();
        synchronized (this) {
            if (this.zzut == null) {
                this.zzyh = zzcq().zza(new zzbi(this));
            }
            Future<String> future = this.zzyh;
            if (future != null) {
                try {
                    this.zzut = future.get();
                } catch (InterruptedException e) {
                    zzd("ClientId loading or generation was interrupted", e);
                    this.zzut = "0";
                } catch (ExecutionException e2) {
                    zze("Failed to load or generate client id", e2);
                    this.zzut = "0";
                }
                if (this.zzut == null) {
                    this.zzut = "0";
                }
                zza("Loaded clientId", this.zzut);
                this.zzyh = null;
            }
            str = this.zzut;
        }
        return str;
    }

    public final String zzei() {
        synchronized (this) {
            this.zzut = null;
            this.zzyh = zzcq().zza(new zzbj(this));
        }
        return zzeh();
    }

    @VisibleForTesting
    public final String zzej() {
        String zzd = zzd(zzcq().getContext());
        return zzd == null ? zzek() : zzd;
    }
}
