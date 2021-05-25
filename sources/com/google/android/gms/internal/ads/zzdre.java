package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;
public final class zzdre {
    private final Context zzvr;
    private final zzdpy zzvw;

    public zzdre(@NonNull Context context, zzdpy zzdpy) {
        this.zzvr = context;
        this.zzvw = zzdpy;
    }

    private final String zzavq() {
        HashSet hashSet = new HashSet(Arrays.asList("i686", "armv71"));
        String value = zzdsx.OS_ARCH.value();
        if (!TextUtils.isEmpty(value) && hashSet.contains(value)) {
            return value;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (NoSuchFieldException e) {
            zzdpy zzdpy = this.zzvw;
            if (zzdpy != null) {
                zzdpy.zza(2024, 0, e);
            }
        } catch (IllegalAccessException e2) {
            zzdpy zzdpy2 = this.zzvw;
            if (zzdpy2 != null) {
                zzdpy2.zza(2024, 0, e2);
            }
        }
        String str = Build.CPU_ABI;
        if (str != null) {
            return str;
        }
        return Build.CPU_ABI2;
    }

    private final zzgo zzavr() {
        File file = new File(new File(this.zzvr.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            return zzgo.UNSUPPORTED;
        }
        File[] listFiles = file.listFiles(new zzduf(Pattern.compile(".*\\.so$", 2)));
        if (listFiles == null || listFiles.length == 0) {
            return zzgo.UNSUPPORTED;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(listFiles[0]);
            try {
                byte[] bArr = new byte[20];
                if (fileInputStream.read(bArr) == 20) {
                    byte[] bArr2 = {0, 0};
                    if (bArr[5] == 2) {
                        zzj(bArr);
                        zzgo zzgo = zzgo.UNSUPPORTED;
                        fileInputStream.close();
                        return zzgo;
                    }
                    bArr2[0] = bArr[19];
                    bArr2[1] = bArr[18];
                    short s = ByteBuffer.wrap(bArr2).getShort();
                    if (s == 3) {
                        zzgo zzgo2 = zzgo.X86;
                        fileInputStream.close();
                        return zzgo2;
                    } else if (s == 40) {
                        zzgo zzgo3 = zzgo.ARM7;
                        fileInputStream.close();
                        return zzgo3;
                    } else if (s == 62) {
                        zzgo zzgo4 = zzgo.X86_64;
                        fileInputStream.close();
                        return zzgo4;
                    } else if (s != 183) {
                        zzgo zzgo5 = zzgo.UNSUPPORTED;
                        fileInputStream.close();
                        return zzgo5;
                    } else {
                        zzgo zzgo6 = zzgo.ARM64;
                        fileInputStream.close();
                        return zzgo6;
                    }
                } else {
                    fileInputStream.close();
                    return zzgo.UNSUPPORTED;
                }
            } catch (Throwable th) {
                zzeeo.zza(th, th);
            }
        } catch (IOException unused) {
        }
        throw th;
    }

    private final void zzj(byte[] bArr) {
        if (this.zzvw != null) {
            StringBuilder L = a.L("os.arch:");
            L.append(zzdsx.OS_ARCH.value());
            L.append(";");
            try {
                String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
                if (strArr != null) {
                    L.append("supported_abis:");
                    L.append(Arrays.toString(strArr));
                    L.append(";");
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
            L.append("CPU_ABI:");
            a.m1(L, Build.CPU_ABI, ";", "CPU_ABI2:");
            L.append(Build.CPU_ABI2);
            L.append(";");
            if (bArr != null) {
                L.append("ELF:");
                L.append(Arrays.toString(bArr));
                L.append(";");
            }
            this.zzvw.zzg(4007, L.toString());
        }
    }

    public final zzgo zzavs() {
        zzgo zzavr = zzavr();
        zzgo zzgo = zzgo.UNSUPPORTED;
        if (zzavr != zzgo) {
            return zzavr;
        }
        String zzavq = zzavq();
        if (!TextUtils.isEmpty(zzavq)) {
            if (zzavq.equalsIgnoreCase("i686") || zzavq.equalsIgnoreCase("x86")) {
                return zzgo.X86;
            }
            if (zzavq.equalsIgnoreCase("x86_64")) {
                return zzgo.X86_64;
            }
            if (zzavq.equalsIgnoreCase("arm64-v8a")) {
                return zzgo.ARM64;
            }
            if (zzavq.equalsIgnoreCase("armeabi-v7a") || zzavq.equalsIgnoreCase("armv71")) {
                return zzgo.ARM7;
            }
        }
        zzj(null);
        return zzgo;
    }
}
