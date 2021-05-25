package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
public final class zzcv {
    public static zzdr<zzcs> zza(Context context) {
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        boolean z = false;
        if ((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys"))) {
            z = true;
        }
        if (!z) {
            return zzdr.zzc();
        }
        if (zzcg.zza() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        zzdr<File> zzb = zzb(context);
        if (zzb.zza()) {
            return zzdr.zza(zza(zzb.zzb()));
        }
        return zzdr.zzc();
    }

    private static zzdr<File> zzb(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            try {
                File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
                return file.exists() ? zzdr.zza(file) : zzdr.zzc();
            } catch (RuntimeException unused) {
                zzdr<File> zzc = zzdr.zzc();
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return zzc;
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static zzcs zza(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                HashMap hashMap = new HashMap();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split(" ", 3);
                        if (split.length == 3) {
                            String str = split[0];
                            String decode = Uri.decode(split[1]);
                            String decode2 = Uri.decode(split[2]);
                            if (!hashMap.containsKey(str)) {
                                hashMap.put(str, new HashMap());
                            }
                            ((Map) hashMap.get(str)).put(decode, decode2);
                        } else if (readLine.length() != 0) {
                            "Invalid: ".concat(readLine);
                        } else {
                            new String("Invalid: ");
                        }
                    } else {
                        String.valueOf(file).length();
                        zzcs zzcs = new zzcs(hashMap);
                        bufferedReader.close();
                        return zzcs;
                    }
                }
            } catch (Throwable th) {
                zzgd.zza(th, th);
            }
            throw th;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
