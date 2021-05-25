package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.d0;
import a2.j.b.e.a.b.j0;
import a2.j.b.e.a.b.n2;
import android.content.Context;
import android.util.Base64;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.internal.cd;
import com.google.android.play.core.splitcompat.d;
import com.google.android.play.core.splitinstall.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipException;
import org.spongycastle.asn1.cmc.BodyPartID;
public final class dd {
    public static a a;

    public static int a(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static boolean a(@AssetPackStatus int i) {
        return i == 1 || i == 7 || i == 2 || i == 3;
    }

    public static AssetLocation b(String str, String str2) throws IOException {
        Long l;
        d.a(str != null, "Attempted to get file location from a null apk path.");
        d.a(str2 != null, String.format("Attempted to get file location in apk %s with a null file path.", str));
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        byte[] bArr = new byte[22];
        randomAccessFile.seek(randomAccessFile.length() - 22);
        randomAccessFile.readFully(bArr);
        j0 d = a(bArr, 0) == 1347093766 ? d(bArr) : null;
        if (d == null) {
            long length = randomAccessFile.length() - 22;
            long j = -65536 + length;
            if (j < 0) {
                j = 0;
            }
            int min = (int) Math.min(1024L, randomAccessFile.length());
            byte[] bArr2 = new byte[min];
            byte[] bArr3 = new byte[22];
            long j2 = length;
            loop0:
            while (true) {
                long max = Math.max(3 + (j2 - ((long) min)), j);
                randomAccessFile.seek(max);
                randomAccessFile.readFully(bArr2);
                for (int i = min - 4; i >= 0; i -= 4) {
                    byte b = bArr2[i];
                    int i2 = b != 5 ? b != 6 ? b != 75 ? b != 80 ? -1 : 0 : 1 : 3 : 2;
                    if (i2 >= 0 && i >= i2 && a(bArr2, i - i2) == 1347093766) {
                        randomAccessFile.seek((max + ((long) i)) - ((long) i2));
                        randomAccessFile.readFully(bArr3);
                        d = d(bArr3);
                        break loop0;
                    }
                }
                if (max != j) {
                    j2 = max;
                } else {
                    throw new ZipException(String.format("End Of Central Directory signature not found in APK %s", str));
                }
            }
        }
        long j3 = d.a;
        byte[] bytes = str2.getBytes("UTF-8");
        byte[] bArr4 = new byte[46];
        byte[] bArr5 = new byte[str2.length()];
        int i3 = 0;
        while (true) {
            if (i3 >= d.b) {
                l = null;
                break;
            }
            randomAccessFile.seek(j3);
            randomAccessFile.readFully(bArr4);
            int a3 = a(bArr4, 0);
            if (a3 == 1347092738) {
                randomAccessFile.seek(28 + j3);
                int h = h(bArr4, 28);
                if (h == str2.length()) {
                    randomAccessFile.seek(46 + j3);
                    randomAccessFile.read(bArr5);
                    if (Arrays.equals(bArr5, bytes)) {
                        l = Long.valueOf(g(bArr4, 42));
                        break;
                    }
                }
                j3 += (long) (h(bArr4, 32) + h(bArr4, 30) + h + 46);
                i3++;
            } else {
                throw new ZipException(String.format("Missing central directory file header signature when looking for file %s in APK %s. Read %d entries out of %d. Found %d instead of the header signature %d.", str2, str, Integer.valueOf(i3), Integer.valueOf(d.b), Integer.valueOf(a3), 1347092738));
            }
        }
        if (l == null) {
            return null;
        }
        long longValue = l.longValue();
        byte[] bArr6 = new byte[8];
        randomAccessFile.seek(22 + longValue);
        randomAccessFile.readFully(bArr6);
        return new d0(str, longValue + 30 + ((long) h(bArr6, 4)) + ((long) h(bArr6, 6)), g(bArr6, 0));
    }

    public static boolean b(@AssetPackStatus int i) {
        return i == 5 || i == 6 || i == 4;
    }

    public static synchronized a c(Context context) {
        a aVar;
        synchronized (dd.class) {
            if (a == null) {
                bt btVar = new bt(null);
                btVar.a(new n2(v.a(context)));
                a = btVar.a();
            }
            aVar = a;
        }
        return aVar;
    }

    public static boolean c(@AssetPackStatus int i) {
        return i == 2 || i == 7 || i == 3;
    }

    public static j0 d(byte[] bArr) {
        int h = h(bArr, 10);
        g(bArr, 12);
        return new j0(g(bArr, 16), h);
    }

    public static String e(List<File> list) throws NoSuchAlgorithmException, IOException {
        int read;
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        byte[] bArr = new byte[8192];
        for (File file : list) {
            FileInputStream fileInputStream = new FileInputStream(file);
            do {
                try {
                    read = fileInputStream.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    cd.a(th, th);
                }
            } while (read != -1);
            fileInputStream.close();
        }
        return Base64.encodeToString(instance.digest(), 11);
        throw th;
    }

    public static boolean f(@AssetPackStatus int i, @AssetPackStatus int i2) {
        if (i == 5 && i2 != 5) {
            return true;
        }
        if (i == 6 && i2 != 6 && i2 != 5) {
            return true;
        }
        if (i == 4 && i2 != 4) {
            return true;
        }
        if (i == 3 && (i2 == 2 || i2 == 7 || i2 == 1 || i2 == 8)) {
            return true;
        }
        if (i != 2) {
            return false;
        }
        return i2 == 1 || i2 == 8;
    }

    public static long g(byte[] bArr, int i) {
        return ((long) ((h(bArr, i + 2) << 16) | h(bArr, i))) & BodyPartID.bodyIdMax;
    }

    public static int h(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }
}
