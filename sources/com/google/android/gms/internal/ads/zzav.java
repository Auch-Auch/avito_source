package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public final class zzav implements zzk {
    private final Map<String, zzax> zzci;
    private long zzcj;
    private final zzaz zzck;
    private final int zzcl;

    public zzav(File file, int i) {
        this.zzci = new LinkedHashMap(16, 0.75f, true);
        this.zzcj = 0;
        this.zzck = new zzay(this, file);
        this.zzcl = 20971520;
    }

    private final synchronized void remove(String str) {
        boolean delete = zzf(str).delete();
        removeEntry(str);
        if (!delete) {
            zzaq.d("Could not delete cache entry for key=%s, filename=%s", str, zze(str));
        }
    }

    private final void removeEntry(String str) {
        zzax remove = this.zzci.remove(str);
        if (remove != null) {
            this.zzcj -= remove.zzcm;
        }
    }

    public static long zzc(InputStream inputStream) throws IOException {
        return (((long) zza(inputStream)) & 255) | 0 | ((((long) zza(inputStream)) & 255) << 8) | ((((long) zza(inputStream)) & 255) << 16) | ((((long) zza(inputStream)) & 255) << 24) | ((((long) zza(inputStream)) & 255) << 32) | ((((long) zza(inputStream)) & 255) << 40) | ((((long) zza(inputStream)) & 255) << 48) | ((255 & ((long) zza(inputStream))) << 56);
    }

    private static String zze(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final File zzf(String str) {
        return new File(this.zzck.zzo(), zze(str));
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized void initialize() {
        File zzo = this.zzck.zzo();
        if (!zzo.exists()) {
            if (!zzo.mkdirs()) {
                zzaq.e("Unable to create cache dir %s", zzo.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = zzo.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                try {
                    long length = file.length();
                    zzba zzba = new zzba(new BufferedInputStream(zza(file)), length);
                    try {
                        zzax zzc = zzax.zzc(zzba);
                        zzc.zzcm = length;
                        zza(zzc.zzcn, zzc);
                    } finally {
                        zzba.close();
                    }
                } catch (IOException unused) {
                    file.delete();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized void zza(String str, boolean z) {
        zzn zzb = zzb(str);
        if (zzb != null) {
            zzb.zzv = 0;
            zzb.zzu = 0;
            zza(str, zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized zzn zzb(String str) {
        zzax zzax = this.zzci.get(str);
        if (zzax == null) {
            return null;
        }
        File zzf = zzf(str);
        try {
            zzba zzba = new zzba(new BufferedInputStream(zza(zzf)), zzf.length());
            try {
                zzax zzc = zzax.zzc(zzba);
                if (!TextUtils.equals(str, zzc.zzcn)) {
                    zzaq.d("%s: key=%s, found=%s", zzf.getAbsolutePath(), str, zzc.zzcn);
                    removeEntry(str);
                    return null;
                }
                byte[] zza = zza(zzba, zzba.zzp());
                zzn zzn = new zzn();
                zzn.data = zza;
                zzn.zzr = zzax.zzr;
                zzn.zzs = zzax.zzs;
                zzn.zzt = zzax.zzt;
                zzn.zzu = zzax.zzu;
                zzn.zzv = zzax.zzv;
                List<zzu> list = zzax.zzx;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzu zzu : list) {
                    treeMap.put(zzu.getName(), zzu.getValue());
                }
                zzn.zzw = treeMap;
                zzn.zzx = Collections.unmodifiableList(zzax.zzx);
                zzba.close();
                return zzn;
            } finally {
                zzba.close();
            }
        } catch (IOException e) {
            zzaq.d("%s: %s", zzf.getAbsolutePath(), e.toString());
            remove(str);
            return null;
        }
    }

    private zzav(zzaz zzaz, int i) {
        this.zzci = new LinkedHashMap(16, 0.75f, true);
        this.zzcj = 0;
        this.zzck = zzaz;
        this.zzcl = 5242880;
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized void zza(String str, zzn zzn) {
        long j;
        long j2 = this.zzcj;
        byte[] bArr = zzn.data;
        long length = j2 + ((long) bArr.length);
        int i = this.zzcl;
        if (length <= ((long) i) || ((float) bArr.length) <= ((float) i) * 0.9f) {
            File zzf = zzf(str);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(zzf));
                zzax zzax = new zzax(str, zzn);
                if (zzax.zza(bufferedOutputStream)) {
                    bufferedOutputStream.write(zzn.data);
                    bufferedOutputStream.close();
                    zzax.zzcm = zzf.length();
                    zza(str, zzax);
                    if (this.zzcj >= ((long) this.zzcl)) {
                        if (zzaq.DEBUG) {
                            zzaq.v("Pruning old cache entries.", new Object[0]);
                        }
                        long j3 = this.zzcj;
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        Iterator<Map.Entry<String, zzax>> it = this.zzci.entrySet().iterator();
                        int i2 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                j = elapsedRealtime;
                                break;
                            }
                            zzax value = it.next().getValue();
                            if (zzf(value.zzcn).delete()) {
                                j = elapsedRealtime;
                                this.zzcj -= value.zzcm;
                            } else {
                                j = elapsedRealtime;
                                String str2 = value.zzcn;
                                zzaq.d("Could not delete cache entry for key=%s, filename=%s", str2, zze(str2));
                            }
                            it.remove();
                            i2++;
                            if (((float) this.zzcj) < ((float) this.zzcl) * 0.9f) {
                                break;
                            }
                            elapsedRealtime = j;
                        }
                        if (zzaq.DEBUG) {
                            zzaq.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzcj - j3), Long.valueOf(SystemClock.elapsedRealtime() - j));
                        }
                    }
                    return;
                }
                bufferedOutputStream.close();
                zzaq.d("Failed to write header for %s", zzf.getAbsolutePath());
                throw new IOException();
            } catch (IOException unused) {
                if (!zzf.delete()) {
                    zzaq.d("Could not clean up file %s", zzf.getAbsolutePath());
                }
                if (!this.zzck.zzo().exists()) {
                    zzaq.d("Re-initializing cache after external clearing.", new Object[0]);
                    this.zzci.clear();
                    this.zzcj = 0;
                    initialize();
                }
            }
        }
    }

    public zzav(zzaz zzaz) {
        this(zzaz, 5242880);
    }

    public static int zzb(InputStream inputStream) throws IOException {
        return (zza(inputStream) << 24) | zza(inputStream) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16);
    }

    public static List<zzu> zzb(zzba zzba) throws IOException {
        int zzb = zzb((InputStream) zzba);
        if (zzb >= 0) {
            List<zzu> emptyList = zzb == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < zzb; i++) {
                emptyList.add(new zzu(zza(zzba).intern(), zza(zzba).intern()));
            }
            return emptyList;
        }
        throw new IOException(a.m2(31, "readHeaderList size=", zzb));
    }

    private final void zza(String str, zzax zzax) {
        if (!this.zzci.containsKey(str)) {
            this.zzcj += zzax.zzcm;
        } else {
            this.zzcj = (zzax.zzcm - this.zzci.get(str).zzcm) + this.zzcj;
        }
        this.zzci.put(str, zzax);
    }

    @VisibleForTesting
    private static byte[] zza(zzba zzba, long j) throws IOException {
        long zzp = zzba.zzp();
        if (j >= 0 && j <= zzp) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(zzba).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(73);
        sb.append("streamToBytes length=");
        sb.append(j);
        sb.append(", maxLength=");
        sb.append(zzp);
        throw new IOException(sb.toString());
    }

    @VisibleForTesting
    private static InputStream zza(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    public static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    public static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    public static String zza(zzba zzba) throws IOException {
        return new String(zza(zzba, zzc(zzba)), "UTF-8");
    }
}
