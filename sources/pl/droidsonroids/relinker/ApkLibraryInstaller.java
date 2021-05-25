package pl.droidsonroids.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import pl.droidsonroids.relinker.ReLinker;
public class ApkLibraryInstaller implements ReLinker.LibraryInstaller {

    public static class a {
        public ZipFile a;
        public ZipEntry b;

        public a(ZipFile zipFile, ZipEntry zipEntry) {
            this.a = zipFile;
            this.b = zipEntry;
        }
    }

    public final a a(Context context, String[] strArr, String str, ReLinkerInstance reLinkerInstance) {
        String[] strArr2;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr3 = applicationInfo.splitSourceDirs;
        char c = 0;
        int i = 1;
        if (strArr3 == null || strArr3.length == 0) {
            strArr2 = new String[]{applicationInfo.sourceDir};
        } else {
            strArr2 = new String[(strArr3.length + 1)];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr3, 0, strArr2, 1, strArr3.length);
        }
        int length = strArr2.length;
        int i2 = 0;
        ZipFile zipFile = null;
        while (i2 < length) {
            String str2 = strArr2[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), i);
                    break;
                } catch (IOException unused) {
                    i3 = i4;
                }
            }
            if (zipFile != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 < 5) {
                        int length2 = strArr.length;
                        int i7 = 0;
                        while (i7 < length2) {
                            String str3 = strArr[i7];
                            StringBuilder L = a2.b.a.a.a.L("lib");
                            L.append(File.separatorChar);
                            L.append(str3);
                            L.append(File.separatorChar);
                            L.append(str);
                            String sb = L.toString();
                            Object[] objArr = new Object[2];
                            objArr[c] = sb;
                            objArr[i] = str2;
                            reLinkerInstance.log("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(sb);
                            if (entry != null) {
                                return new a(zipFile, entry);
                            }
                            i7++;
                            c = 0;
                            i = 1;
                        }
                        i5 = i6;
                        i = 1;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i2++;
            c = 0;
            i = 1;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x00a6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x00a6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0084 A[SYNTHETIC, Splitter:B:55:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0089 A[SYNTHETIC, Splitter:B:59:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0091 A[SYNTHETIC, Splitter:B:67:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x009e A[SYNTHETIC, Splitter:B:76:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x00c2 A[SYNTHETIC, Splitter:B:95:0x00c2] */
    @Override // pl.droidsonroids.relinker.ReLinker.LibraryInstaller
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void installLibrary(android.content.Context r11, java.lang.String[] r12, java.lang.String r13, java.io.File r14, pl.droidsonroids.relinker.ReLinkerInstance r15) {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.relinker.ApkLibraryInstaller.installLibrary(android.content.Context, java.lang.String[], java.lang.String, java.io.File, pl.droidsonroids.relinker.ReLinkerInstance):void");
    }
}
