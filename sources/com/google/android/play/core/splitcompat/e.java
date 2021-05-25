package com.google.android.play.core.splitcompat;

import a2.j.b.e.a.h.b;
import a2.j.b.e.a.h.n;
import android.content.Context;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
public final class e {
    public final long a;
    public final Context b;
    public File c;

    public e(Context context) throws PackageManager.NameNotFoundException {
        this.b = context;
        this.a = (long) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    }

    public static File b(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            return file2;
        }
        throw new IllegalArgumentException("split ID cannot be placed in target directory");
    }

    public static void c(File file) throws IOException {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                c(file2);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(String.format("Failed to delete '%s'", file.getAbsolutePath()));
        }
    }

    public static void e(File file) throws IOException {
        if (!file.exists()) {
            file.mkdirs();
            if (!file.isDirectory()) {
                String valueOf = String.valueOf(file.getAbsolutePath());
                throw new IOException(valueOf.length() == 0 ? new String("Unable to create directory: ") : "Unable to create directory: ".concat(valueOf));
            }
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException("File input must be directory when it exists.");
        }
    }

    public final File a(File file) throws IOException {
        return b(f(), file.getName());
    }

    public final File a(String str) throws IOException {
        return b(c(), String.valueOf(str).concat(".apk"));
    }

    public final void a() throws IOException {
        File h = h();
        String[] list = h.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.a))) {
                    File file = new File(h, str);
                    String.valueOf(file).length();
                    c(file);
                }
            }
        }
    }

    public final File b() throws IOException {
        return new File(g(), "lock.tmp");
    }

    public final File b(String str) throws IOException {
        return b(f(), String.valueOf(str).concat(".apk"));
    }

    public final File c() throws IOException {
        File file = new File(g(), "unverified-splits");
        e(file);
        return file;
    }

    public final File c(String str) throws IOException {
        File file = new File(g(), "dex");
        e(file);
        File b2 = b(file, str);
        e(b2);
        return b2;
    }

    public final Set<n> d() throws IOException {
        File f = f();
        HashSet hashSet = new HashSet();
        File[] listFiles = f.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.getName().endsWith(".apk")) {
                    String name = file.getName();
                    hashSet.add(new b(file, name.substring(0, name.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    public final File f() throws IOException {
        File file = new File(g(), "verified-splits");
        e(file);
        return file;
    }

    public final File g() throws IOException {
        File file = new File(h(), Long.toString(this.a));
        e(file);
        return file;
    }

    public final File h() throws IOException {
        if (this.c == null) {
            Context context = this.b;
            if (context != null) {
                this.c = context.getFilesDir();
            } else {
                throw new IllegalStateException("context must be non-null to populate null filesDir");
            }
        }
        File file = new File(this.c, "splitcompat");
        e(file);
        return file;
    }

    public final File i() throws IOException {
        File file = new File(g(), "native-libraries");
        e(file);
        return file;
    }

    public final File a(String str, String str2) throws IOException {
        File b2 = b(i(), str);
        e(b2);
        return b(b2, str2);
    }
}
