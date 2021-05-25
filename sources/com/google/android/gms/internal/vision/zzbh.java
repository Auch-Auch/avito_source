package com.google.android.gms.internal.vision;

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
public final class zzbh {
    private static zzbe zza(File file) {
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
                        zzbe zzbe = new zzbe(hashMap);
                        bufferedReader.close();
                        return zzbe;
                    }
                }
            } catch (Throwable th) {
                zzfd.zza(th, th);
            }
            throw th;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static zzcy<zzbe> zzg(Context context) {
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        boolean z = false;
        if ((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys"))) {
            z = true;
        }
        if (!z) {
            return zzcy.zzcb();
        }
        if (zzas.zzu() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        zzcy<File> zzh = zzh(context);
        if (zzh.isPresent()) {
            return zzcy.zzb(zza(zzh.get()));
        }
        return zzcy.zzcb();
    }

    private static zzcy<File> zzh(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            try {
                File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
                return file.exists() ? zzcy.zzb(file) : zzcy.zzcb();
            } catch (RuntimeException unused) {
                zzcy<File> zzcb = zzcy.zzcb();
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return zzcb;
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
