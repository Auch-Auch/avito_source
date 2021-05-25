package com.facebook.soloader;

import a2.b.a.a.a;
import android.os.StrictMode;
import android.os.Trace;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.Nullable;
public class DirectorySoSource extends SoSource {
    public static final int ON_LD_LIBRARY_PATH = 2;
    public static final int RESOLVE_DEPENDENCIES = 1;
    public final int flags;
    public final File soDirectory;

    public DirectorySoSource(File file, int i) {
        this.soDirectory = file;
        this.flags = i;
    }

    public static String[] a(File file) throws IOException {
        boolean z = SoLoader.a;
        if (z) {
            Api18TraceUtils.a("SoLoader.getElfDependencies[", file.getName(), "]");
        }
        try {
            String[] extract_DT_NEEDED = MinElf.extract_DT_NEEDED(file);
            if (z) {
                Trace.endSection();
            }
            return extract_DT_NEEDED;
        } catch (Throwable th) {
            if (SoLoader.a) {
                Trace.endSection();
            }
            throw th;
        }
    }

    @Override // com.facebook.soloader.SoSource
    public void addToLdLibraryPath(Collection<String> collection) {
        collection.add(this.soDirectory.getAbsolutePath());
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String[] getLibraryDependencies(String str) throws IOException {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return a(file);
        }
        return null;
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String getLibraryPath(String str) throws IOException {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return file.getCanonicalPath();
        }
        return null;
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
    }

    public int loadLibraryFrom(String str, int i, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file.getCanonicalPath();
            return 0;
        }
        file.getCanonicalPath();
        if (!((i & 1) == 0 || (this.flags & 2) == 0)) {
            return 2;
        }
        if ((this.flags & 1) != 0) {
            String[] a = a(file2);
            Arrays.toString(a);
            for (String str2 : a) {
                if (!str2.startsWith("/")) {
                    SoLoader.e(str2, null, null, i | 1, threadPolicy);
                }
            }
        }
        try {
            SoLoader.b.load(file2.getAbsolutePath(), i);
            return 1;
        } catch (UnsatisfiedLinkError e) {
            if (e.getMessage().contains("bad ELF magic")) {
                return 3;
            }
            throw e;
        }
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        String str;
        try {
            str = String.valueOf(this.soDirectory.getCanonicalPath());
        } catch (IOException unused) {
            str = this.soDirectory.getName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[root = ");
        sb.append(str);
        sb.append(" flags = ");
        return a.i(sb, this.flags, ']');
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File unpackLibrary(String str) throws IOException {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }
}
