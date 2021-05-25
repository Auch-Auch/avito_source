package com.google.android.exoplayer2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public final class AtomicFile {
    public final File a;
    public final File b;

    public static final class a extends OutputStream {
        public final FileOutputStream a;
        public boolean b = false;

        public a(File file) throws FileNotFoundException {
            this.a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.b) {
                this.b = true;
                this.a.flush();
                try {
                    this.a.getFD().sync();
                } catch (IOException e) {
                    Log.w("AtomicFile", "Failed to sync file descriptor:", e);
                }
                this.a.close();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.a.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.a.write(bArr, i, i2);
        }
    }

    public AtomicFile(File file) {
        this.a = file;
        this.b = new File(file.getPath() + ".bak");
    }

    public void delete() {
        this.a.delete();
        this.b.delete();
    }

    public void endWrite(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.b.delete();
    }

    public boolean exists() {
        return this.a.exists() || this.b.exists();
    }

    public InputStream openRead() throws FileNotFoundException {
        if (this.b.exists()) {
            this.a.delete();
            this.b.renameTo(this.a);
        }
        return new FileInputStream(this.a);
    }

    public OutputStream startWrite() throws IOException {
        if (this.a.exists()) {
            if (this.b.exists()) {
                this.a.delete();
            } else if (!this.a.renameTo(this.b)) {
                StringBuilder L = a2.b.a.a.a.L("Couldn't rename file ");
                L.append(this.a);
                L.append(" to backup file ");
                L.append(this.b);
                Log.w("AtomicFile", L.toString());
            }
        }
        try {
            return new a(this.a);
        } catch (FileNotFoundException e) {
            File parentFile = this.a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                StringBuilder L2 = a2.b.a.a.a.L("Couldn't create ");
                L2.append(this.a);
                throw new IOException(L2.toString(), e);
            }
            try {
                return new a(this.a);
            } catch (FileNotFoundException e2) {
                StringBuilder L3 = a2.b.a.a.a.L("Couldn't create ");
                L3.append(this.a);
                throw new IOException(L3.toString(), e2);
            }
        }
    }
}
