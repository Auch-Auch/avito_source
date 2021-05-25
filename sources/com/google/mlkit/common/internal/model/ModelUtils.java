package com.google.mlkit.common.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzan;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@KeepForSdk
@WorkerThread
public class ModelUtils {
    public static final GmsLogger a = new GmsLogger("ModelUtils", "");

    @KeepForSdk
    public static abstract class ModelLoggingInfo {
        @KeepForSdk
        public abstract String getHash();

        @KeepForSdk
        public abstract long getSize();
    }

    @Nullable
    public static String a(InputStream inputStream) {
        int i;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            a.e("ModelUtils", "Do not have SHA-256 algorithm");
            return null;
        } catch (IOException unused2) {
            a.e("ModelUtils", "Failed to read model file");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bc A[SYNTHETIC, Splitter:B:59:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c9 A[SYNTHETIC, Splitter:B:65:0x00c9] */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo getModelLoggingInfo(android.content.Context r10, com.google.mlkit.common.model.LocalModel r11) {
        /*
        // Method dump skipped, instructions count: 231
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.getModelLoggingInfo(android.content.Context, com.google.mlkit.common.model.LocalModel):com.google.mlkit.common.internal.model.ModelUtils$ModelLoggingInfo");
    }

    @Nullable
    @KeepForSdk
    public static String getSHA256(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                String a3 = a(fileInputStream);
                fileInputStream.close();
                return a3;
            } catch (Throwable th) {
                zzan.zza(th, th);
            }
            throw th;
        } catch (IOException e) {
            GmsLogger gmsLogger = a;
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 44);
            sb.append("Failed to create FileInputStream for model: ");
            sb.append(valueOf);
            gmsLogger.e("ModelUtils", sb.toString());
            return null;
        }
    }

    public static boolean zza(@NonNull File file, @NonNull String str) {
        String sha256 = getSHA256(file);
        GmsLogger gmsLogger = a;
        String valueOf = String.valueOf(sha256);
        gmsLogger.d("ModelUtils", valueOf.length() != 0 ? "Calculated hash value is: ".concat(valueOf) : new String("Calculated hash value is: "));
        return str.equals(sha256);
    }
}
