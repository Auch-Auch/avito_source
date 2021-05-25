package com.google.firebase.crashlytics.internal.proto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
public class ClsFileOutputStream extends FileOutputStream {
    public static final String IN_PROGRESS_SESSION_FILE_EXTENSION = ".cls_temp";
    public static final String SESSION_FILE_EXTENSION = ".cls";
    public static final FilenameFilter TEMP_FILENAME_FILTER = new a();
    public final String a;
    public File b;
    public File c;
    public boolean d;

    public class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION);
        }
    }

    public ClsFileOutputStream(String str, String str2) throws FileNotFoundException {
        this(new File(str), str2);
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (!this.d) {
            this.d = true;
            super.flush();
            super.close();
            File file = new File(this.a + SESSION_FILE_EXTENSION);
            if (this.b.renameTo(file)) {
                this.b = null;
                this.c = file;
                return;
            }
            String str = "";
            if (file.exists()) {
                str = " (target already exists)";
            } else if (!this.b.exists()) {
                str = " (source does not exist)";
            }
            throw new IOException("Could not rename temp file: " + this.b + " -> " + file + str);
        }
    }

    public void closeInProgressStream() throws IOException {
        if (!this.d) {
            this.d = true;
            super.flush();
            super.close();
        }
    }

    public File getCompleteFile() {
        return this.c;
    }

    public File getInProgressFile() {
        return this.b;
    }

    public ClsFileOutputStream(File file, String str) throws FileNotFoundException {
        super(new File(file, a2.b.a.a.a.c3(str, IN_PROGRESS_SESSION_FILE_EXTENSION)));
        this.d = false;
        StringBuilder sb = new StringBuilder();
        sb.append(file);
        String t = a2.b.a.a.a.t(sb, File.separator, str);
        this.a = t;
        this.b = new File(a2.b.a.a.a.c3(t, IN_PROGRESS_SESSION_FILE_EXTENSION));
    }
}
