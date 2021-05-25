package a2.j.b.e.a.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.play.core.assetpacks.AssetPackLocation;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.cd;
import com.google.android.play.core.splitcompat.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
public final class a0 {
    public static final aa c = new aa("AssetPackStorage");
    public static final long d;
    public static final long e;
    public final Context a;
    public final x1 b;

    static {
        TimeUnit timeUnit = TimeUnit.DAYS;
        d = timeUnit.toMillis(14);
        e = timeUnit.toMillis(28);
    }

    public a0(Context context, x1 x1Var) {
        this.a = context;
        this.b = x1Var;
    }

    public static List<String> c(PackageInfo packageInfo, String str) {
        ArrayList arrayList = new ArrayList();
        int i = (-Arrays.binarySearch(packageInfo.splitNames, str)) - 1;
        while (true) {
            String[] strArr = packageInfo.splitNames;
            if (i >= strArr.length || !strArr[i].startsWith(str)) {
                break;
            }
            arrayList.add(packageInfo.applicationInfo.splitSourceDirs[i]);
            i++;
        }
        return arrayList;
    }

    public static void d(File file) {
        if (file.listFiles() != null && file.listFiles().length > 1) {
            long g = g(file);
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (!file2.getName().equals(String.valueOf(g)) && !file2.getName().equals("stale.tmp")) {
                    n(file2);
                }
            }
        }
    }

    public static long g(File file) {
        if (!file.exists()) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        try {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (!file2.getName().equals("stale.tmp")) {
                    arrayList.add(Long.valueOf(file2.getName()));
                }
            }
        } catch (NumberFormatException e2) {
            c.a(e2, "Corrupt asset pack directories.", new Object[0]);
        }
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
    }

    public static boolean n(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!n(file2)) {
                    z = false;
                }
            }
        }
        if (file.delete()) {
            return z;
        }
        return false;
    }

    public static long p(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                j += p(file2);
            }
        }
        return j;
    }

    public final File a(String str, int i, long j) {
        return new File(new File(t(str), String.valueOf(i)), String.valueOf(j));
    }

    public final File b(String str, int i, long j, String str2) {
        return new File(new File(new File(w(str, i, j), "_slices"), "_unverified"), str2);
    }

    public final void e(String str, int i, long j, int i2) throws IOException {
        File file = new File(j(str, i, j), "merge.tmp");
        Properties properties = new Properties();
        properties.put("numberOfMerges", String.valueOf(i2));
        file.getParentFile().mkdirs();
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    public final boolean f(String str) {
        try {
            return l(str) != null;
        } catch (IOException unused) {
        }
    }

    public final AssetPackLocation h(String str) throws IOException {
        String l = l(str);
        if (l == null) {
            return null;
        }
        File file = new File(l, "assets");
        if (!file.isDirectory()) {
            c.b("Failed to find assets directory: %s", file);
            return null;
        }
        String canonicalPath = file.getCanonicalPath();
        AssetPackLocation assetPackLocation = AssetPackLocation.a;
        d.a(l, "STORAGE_FILES location path must be non-null");
        d.a(l, "STORAGE_FILES assetsPath must be non-null");
        return new e0(0, l, canonicalPath);
    }

    public final File i(String str, int i, long j, String str2) {
        return new File(new File(new File(w(str, i, j), "_slices"), "_verified"), str2);
    }

    public final File j(String str, int i, long j) {
        return new File(w(str, i, j), "_packs");
    }

    public final File k(String str, int i, long j, String str2) {
        return new File(s(str, i, j, str2), "checkpoint.dat");
    }

    public final String l(String str) throws IOException {
        int length;
        File file = new File(x(), str);
        if (!file.exists()) {
            c.a("Pack not found with pack name: %s", str);
            return null;
        }
        File file2 = new File(file, String.valueOf(this.b.a()));
        if (!file2.exists()) {
            c.a("Pack not found with pack name: %s app version: %s", str, Integer.valueOf(this.b.a()));
            return null;
        }
        File[] listFiles = file2.listFiles();
        if (listFiles == null || (length = listFiles.length) == 0) {
            c.a("No pack version found for pack name: %s app version: %s", str, Integer.valueOf(this.b.a()));
            return null;
        } else if (length <= 1) {
            return listFiles[0].getCanonicalPath();
        } else {
            c.b("Multiple pack versions found for pack name: %s app version: %s", str, Integer.valueOf(this.b.a()));
            return null;
        }
    }

    public final void m() {
        ArrayList arrayList = (ArrayList) u();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            File file = (File) arrayList.get(i);
            if (file.listFiles() != null) {
                d(file);
                long g = g(file);
                if (((long) this.b.a()) != g) {
                    try {
                        new File(new File(file, String.valueOf(g)), "stale.tmp").createNewFile();
                    } catch (IOException unused) {
                        c.b("Could not write staleness marker.", new Object[0]);
                    }
                }
                for (File file2 : file.listFiles()) {
                    d(file2);
                }
            }
        }
    }

    public final int o(String str, int i, long j) throws IOException {
        File file = new File(j(str, i, j), "merge.tmp");
        if (!file.exists()) {
            return 0;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("numberOfMerges") != null) {
                try {
                    return Integer.parseInt(properties.getProperty("numberOfMerges"));
                } catch (NumberFormatException e2) {
                    throw new q0("Merge checkpoint file corrupt.", e2);
                }
            } else {
                throw new q0("Merge checkpoint file corrupt.");
            }
        } catch (Throwable th) {
            cd.a(th, th);
        }
        throw th;
    }

    public final boolean q(String str) {
        if (t(str).exists()) {
            return n(t(str));
        }
        return true;
    }

    public final File r(String str, int i, long j, String str2) {
        return new File(s(str, i, j, str2), "slice.zip");
    }

    public final File s(String str, int i, long j, String str2) {
        return new File(new File(new File(w(str, i, j), "_slices"), "_metadata"), str2);
    }

    public final File t(String str) {
        return new File(x(), str);
    }

    public final List<File> u() {
        ArrayList arrayList = new ArrayList();
        try {
            if (!x().exists() || x().listFiles() == null) {
                return arrayList;
            }
            File[] listFiles = x().listFiles();
            for (File file : listFiles) {
                if (!file.getCanonicalPath().equals(v().getCanonicalPath())) {
                    arrayList.add(file);
                }
            }
            return arrayList;
        } catch (IOException e2) {
            c.b("Could not process directory while scanning installed packs. %s", e2);
        }
    }

    public final File v() {
        return new File(x(), "_tmp");
    }

    public final File w(String str, int i, long j) {
        return new File(new File(new File(v(), str), String.valueOf(i)), String.valueOf(j));
    }

    public final File x() {
        return new File(this.a.getFilesDir(), "assetpacks");
    }
}
